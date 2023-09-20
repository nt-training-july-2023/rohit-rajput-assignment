import React, { useEffect, useState } from "react";
import "../Styles/TicketTable.css";
import { AiOutlineEdit, AiOutlineEye } from "react-icons/ai";
import AdminDashboard from "./AdminDashboard";
import { Link, useNavigate } from "react-router-dom";
import loginService from "./service/loginService";
import ViewTicket from "./ViewTicket";
import Alert from "./Alert";

export default function TicketTable() {
  const [tickets, setTickets] = useState([]);
  const [show, setShow] = useState(false);
  const [alertMessage, setAlertMessage] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    fetchTickets();
  }, []);

  const fetchTickets = async () => {
    await loginService
      .getAllTicket()
      .then((res) => {
        console.log(res);
        if (res.data.hasdata) {
          setTickets(res.data.data);
          setTickets(res.data.data);
        }
      })
      .catch((error) => {
          setShow(true);
        if (error.code === "ERR_NETWORK") {
            setAlertMessage(error.message);
        }
        else{
            setAlertMessage(error.response.data.message);
        }
      });
  };

  const closeAlert = () => {
    setAlertMessage("");
    setShow(false);
      navigate("/admin");
  };

  return (
    <>
      <AdminDashboard />
      <div className="ticket-table-top-element">
        <select>
          Filter
          <option>Status</option>
          <option>Department</option>``
          <option>Assigned By</option>
        </select>
        <span>
          <Link to="/update-ticket">
            <button className="ticket-table-filter-btn">Filter</button>
          </Link>
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
            const data ={
                id : ticket.ticketId,
                departName: ticket.departmentName
            }

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
      </div>
      {show && <Alert message={alertMessage} close={closeAlert} />}
    </>
  );
}
