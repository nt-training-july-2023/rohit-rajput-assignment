import React, { useState } from "react";
import "../Styles/AdminDashboard.css";
import { Link, useNavigate } from "react-router-dom";

export default function MemberDashboard() {
  const navigate = useNavigate();
  const handleLogout = () => {
    localStorage.clear();
    navigate("/");
  };
  return (
    <div>
      <div className="admin-parent-container">
        <div className="admin-container">
          <h1 className="admin-heading">Grievance Management</h1>
          <hr />
          <ul>
            <li>
              <Link to="/get-all-ticket">Tickets</Link>
            </li>
            <li>
              <Link to="/get-my-ticket">My Tickets</Link>
            </li>
            <li>
              <Link to="/update-password">Change-Password</Link>
            </li>
            <li>
              <Link to="/add-ticket">New Ticket</Link>
            </li>
          </ul>

          <input
            className="admin-dashboard-btn"
            onClick={handleLogout}
            type="button"
            value="Logout"
          />
        </div>
      </div>
    </div>
  );
}
