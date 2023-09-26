import React, { useEffect, useState } from 'react'
import AdminDashboard from './AdminDashboard';
import APIService from '../Service/api';
import { RiDeleteBin6Line } from "react-icons/ri";
import Alert from './Alert';

export default function AllDepartmentTable() {
  const [departments, setDepartments] = useState([]);
  const [show, setShow] = useState(false);
  const [filterDepartment, setFilterDepartment] = useState();
  const [isNextPage, setIsNextPage] = useState(true);
  const [alertMessage, setAlertMessage] = useState("");
  const [currentPage, setCurrentPage] = useState(1);
  const [logedInUserDepart,setLogedInUserDepart] = useState("");
  const [isPaginated, setIsPaginated] = useState(true);

  useEffect(() => {
    setLogedInUserDepart(JSON.parse(localStorage.getItem('user'))?.departmentName);
    fetchDepartment();
  }, [currentPage]);

  useEffect(()=>{

  },[departments]);

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

  const handleDelete = async(departmentId) => {
    console.log(departmentId);
    await APIService.deleteDepartmentById(departmentId)
    .then((res)=>{
        setShow(true);
        setAlertMessage(res.data.message);
        setDepartments(departments.filter(department => department.id !== departmentId));
          
    }).catch((error)=>{
        setShow(true);
        if(error.code === "ERR_NETWORK"){
           setAlertMessage(error.message);
        }else{
            setAlertMessage(error.response.data.message);
        }
    })
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
          setIsNextPage(false);
          setCurrentPage(currentPage-1);
          setAlertMessage(error.response.data.message);
        }
      });
  };
  return (
    <>
    <AdminDashboard />
      <div className="ticket-table-parent-container" style={{marginLeft:"21vw"}}>
        <div className="ticket-table-container">
          <table className="ticket-table">
            <thead>
              <tr>
                <th>S.No</th>
                <th>Department</th>
                <th>Delete</th>
              </tr>
            </thead>
            {departments?.map((department, index) => {
              return (
                <tr key={department.id}>
                  <td>{(currentPage - 1) * 10 + (index + 1)}</td>
                  <td>{department.departmentName}</td>
                  <td style={{ textAlign: "center" }}>
                    <button
                      className="ticket-table-data-update"
                      value={department.id}
                      onClick={(e) => handleDelete(department.id)}
                      hidden=
                      { department.departmentName === logedInUserDepart
                        ? true
                        : false}
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
  )
}
