import React from "react";
import Alert from "./Alert";
import { useState } from "react";
import { RiDeleteBin6Line } from "react-icons/ri";
import AdminDashboard from "./AdminDashboard";
import { useEffect } from "react";
import APIService from "../Service/api";

export default function AllUserTable() {
  const [departments, setDepartments] = useState([]);
  const [users, setUsers] = useState([]);
  const [show, setShow] = useState(false);
  const [filterDepartment, setFilterDepartment] = useState();
  const [isNextPage, setIsNextPage] = useState(true);
  const [alertMessage, setAlertMessage] = useState("");
  const [currentPage, setCurrentPage] = useState(1);
  const [logedInUserId, setLogedInUserId] = useState("");
  const [isPaginated, setIsPaginated] = useState(false);

  useEffect(() => {
    setLogedInUserId(JSON.parse(localStorage.getItem("user"))?.id);
    fetchDepartment();
  }, []);

  useEffect(() => {
    fetchAllUser();
  }, [currentPage, filterDepartment]);

  useEffect(() => {}, [users]);

  const getNext = () => {
    if (isNextPage) {
      setCurrentPage(currentPage + 1);
    } else {
      setShow(true);
      setAlertMessage("No data available");
    }
  };

  const getPrev = () => {
    setIsNextPage(true);
    if (currentPage > 1) {
      setCurrentPage(currentPage - 1);
    }
  };

  const closeAlert = () => {
    setAlertMessage("");
    setShow(false);
  };

  const handleSubmit = () => {
    setIsNextPage(true);
    setFilterDepartment();
  };

  const handleDepartment = (e) => {
    setCurrentPage(1);
    setFilterDepartment(e.target.value);
  };

  const handleDelete = async (userId) => {
    if(window.confirm("Are you sure ?") == false){
          return;
    }
    await APIService.deleteUserById(userId)
      .then((res) => {
        setShow(true);
        setAlertMessage(res.data.message);
        setUsers(users.filter((user) => user.userId !== userId));
      })
      .catch((error) => {
        setShow(true);
        if (error.code === "ERR_NETWORK") {
          setAlertMessage(error.message);
        } else {
          setAlertMessage(error.response.data.message);
        }
      });
  };

  const fetchDepartment = async () => {
    await APIService.getAllDepartment(currentPage, isPaginated)
      .then((res) => {
        if (res.data.hasdata) {
          setDepartments(res.data.data);
        }
      })
      .catch((error) => {
        setShow(true);
        if (error.code === "ERR_NETWORK") {
          setAlertMessage(error.message);
        } else {
          setAlertMessage(error.response.data.message);
        }
      });
  };

  const fetchAllUser = async () => {
    await APIService.getAllUser(currentPage, filterDepartment)
      .then((res) => {
        if (res.data.data.length == 0) {
          setIsNextPage(false);
          setShow(true);
          setAlertMessage("No data available");
          return;
        }
        if (res.data.hasdata) {
          setUsers(res.data.data);
          if (res.data.data.length < 10) {
            setIsNextPage(false);
          }
        }
      })
      .catch((error) => {
        setShow(true);
        if (error.code === "ERR_NETWORK") {
          setAlertMessage(error.message);
        } else {
          setIsNextPage(false);
          setCurrentPage(currentPage - 1);
          setAlertMessage(error.response.data.message);
        }
      });
  };
  return (
    <>
      <AdminDashboard />
      <div className="ticket-table-parent-container">
        <div className="ticket-table-top-element">
          <select
            value={filterDepartment === undefined ? '' : filterDepartment}
            onChange={(e) => {
              handleDepartment(e);
            }}
          >
            <option hidden>--Select Department--</option>
            {departments.map((dept) => (
              <option
                className="addnewuser_option"
                value={dept.departmentName}
                key={dept.id}
              >
                {dept.departmentName}
              </option>
            ))}
          </select>
          <span>
            <button onClick={handleSubmit} className="ticket-table-filter-btn">
              Clear
            </button>
          </span>
        </div>
        <div className="ticket-table-container">
          <table className="ticket-table">
            <thead>
              <tr>
                <th>S.No</th>
                <th>Name</th>
                <th>Department</th>
                <th>Role</th>
                <th>Delete</th>
              </tr>
            </thead>
            {users?.map((user, index) => {
              return (
                <tr key={user.userId}>
                  <td>{(currentPage - 1) * 10 + (index + 1)}</td>
                  <td>{user.name}</td>
                  <td>{user.departmentName}</td>
                  <td>{user.userRole}</td>
                  <></>
                  <td style={{ textAlign: "center" }}>
                    <button
                      className="ticket-table-data-update"
                      value={user.userId}
                      onClick={(e) => handleDelete(user.userId)}
                      hidden={user.userId === logedInUserId ? true : false}
                    >
                      <RiDeleteBin6Line />
                    </button>
                  </td>
                </tr>
              );
            })}
          </table>
          <div className="ticket_btn">
            <button className="ticket-table-prev-page-btn" onClick={getPrev}>
              Prev
            </button>
            <button className="ticket-table-next-page-btn" onClick={getNext}>
              Next
            </button>
          </div>
        </div>
      </div>
      {show && <Alert message={alertMessage} close={closeAlert} />}
    </>
  );
}
