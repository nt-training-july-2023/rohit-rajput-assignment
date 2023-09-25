import React, { useState } from "react";
import '../Styles/AdminDashboard.css';
import { Link } from "react-router-dom";

export default function AdminDashboard() {
  return (
    <div>
      <div className="admin-parent-container">
        <div className="admin-container">
            <h1 className="admin-heading">Grievance Management</h1>
            <hr/>
            <ul>
                <li><Link to="/get-all-user">All Users</Link></li>
                <li><Link to="/delete-user">Delete User</Link></li>
                <li><Link to="/get-all-ticket">Tickets</Link></li>
                <li><Link to="/get-my-ticket" >My Tickets</Link></li>
                <li><Link to="/add-user">Add User</Link></li>
                <li><Link to="/add-department">Add Department</Link></li>
                <li><Link to="/update-password">Change-Password</Link></li>
                <li><Link to="/add-ticket">New Ticket</Link></li>
                <li><Link to="/get-all-user">All Department</Link></li>
            </ul>

            <input className="admin-dashboard-btn" type="button" value="Logout"/>

        </div>
      </div>
    </div>
  );
}
