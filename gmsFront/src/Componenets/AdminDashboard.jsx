import React, { useState } from "react";
import '../Styles/AdminDashboard.css';
import { Link } from "react-router-dom";
import Alert from "./Alert";

export default function AdminDashboard() {
  // const [show, setShow] = useState(false);
  // const [alertMessage, setAlertMessage] = useState("");

  // const closeAlert = () => {
  //   setAlertMessage("");
  //   setShow(false);
  // };

  return (
    <div>
      <div className="admin-parent-container">
        <div className="admin-container">
            <h1 className="admin-heading">Grievance Management</h1>
            <hr/>
            {/* <a className="admin-anchor" ><Link to="/get-all-user">All Users</Link></a>
            <a className="admin-anchor" href="/delete-user">Delete User</a>
            <a className="admin-anchor" href="/get-all-ticket">Tickets</a>
            <a className="admin-anchor" href="/add-department">Add Department</a>
            <a className="admin-anchor" href="/delete-department">Delete Department</a>
            <a className="admin-anchor" href="/get-all-department">All Department</a> */}
            <ul>
                <li><Link to="/get-all-user">All Users</Link></li>
                <li><Link to="/delete-user">Delete User</Link></li>
                <li><Link to="/get-all-ticket">Tickets</Link></li>
                <li><Link to="/add-user">Add User</Link></li>
                <li><Link to="/add-department">Add Department</Link></li>
                <li><Link to="/delete-department">Delete Department</Link></li>
                <li><Link to="/add-ticket">New Ticket</Link></li>
                <li><Link to="/get-all-user">All Department</Link></li>
            </ul>

            <input className="admin-dashboard-btn" type="button" value="Logout"/>

        </div>
      </div>
    </div>
  );
}
