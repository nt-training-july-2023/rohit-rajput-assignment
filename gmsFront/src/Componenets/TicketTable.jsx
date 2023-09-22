import React, { useEffect, useState } from "react";
import "../Styles/TicketTable.css";
import { AiOutlineEdit } from "react-icons/ai";
import AdminDashboard from "./AdminDashboard";
import { Link, useNavigate } from "react-router-dom";
import Alert from "./Alert";
import APIService from "../Service/api";

export default function TicketTable() {
  const [tickets, setTickets] = useState([]);
  const [show, setShow] = useState(false);
  const [filterStatus, setFilterStatus] = useState("");
  const [isNextPage, setIsNextPage] = useState(true);
  const [alertMessage, setAlertMessage] = useState("");
  const [currentPage, setCurrentPage] = useState(1);

  useEffect(() => {
    fetchTickets();
  },[currentPage]);

  const handleSubmit = (e) =>{
    e.preventDefault();
       fetchTickets();
  }

  const fetchTickets = async () => {
    if (currentPage <= 0) {
      setCurrentPage(1);
      return;
    }
    await APIService.getAllTicket(currentPage,filterStatus)
      .then((res) => {
        console.log(res);
        if (res.data.data.length == 0) {
          setCurrentPage(currentPage - 1);
          setIsNextPage(false);
          setShow(true);
          setAlertMessage("Next page is empty");
        } else {
          setTickets(res.data.data);
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

  const getNext = () => {
    if (isNextPage) {
      setCurrentPage(currentPage + 1);
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

  const handleStatus = (e) =>{
    setFilterStatus(e.target.value);
    console.log(e.target.value);
  }

  return (
    <>
      <AdminDashboard />
      <div className="ticket-table-parent-container">
        <div className="ticket-table-top-element">
          <select onChange={(e)=>{handleStatus(e)}}>
            Filter
            <option hidden>Status</option>
            <option value="OPEN">OPEN</option>
            <option value="BEING_ADDRESSED">BEING_ADDRESSED</option>
            <option value="RESOLVED">RESOLVED</option>
          </select>
          <span>
              <button onClick={handleSubmit} className="ticket-table-filter-btn">Filter</button>
          </span>
        </div>
        <div className="ticket-table-container">
          <table className="ticket-table">
            <thead>
              <tr>
                <th>Title</th>
                <th>Department</th>
                <th>Status</th>
                <th>Assigned By</th>
                <th>Last Updated Time</th>
                <th>Update</th>
              </tr>
            </thead>

            {tickets?.map((ticket) => {
              const data = {
                id: ticket.ticketId,
                departName: ticket.departmentName,
              };

              return (
                <tr key={ticket.ticketId}>
                  <td>{ticket.title}</td>
                  <td>{ticket.departmentName}</td>
                  <td>{ticket.status}</td>
                  <td>{ticket.assignedBy}</td>
                  <td>{ticket.lastUpdationTime}</td>
                  <td>
                    <Link to="/update-ticket" state={data}>
                      <button className="ticket-table-data-update">
                        <AiOutlineEdit />
                      </button>
                    </Link>
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
