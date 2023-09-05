import React from "react";
import "../Styles/AddNewTicket.css";

export default function AddNewTicket() {
  return (
    <div>
      <div className="add-new-ticket-container">
        <div className="new-ticket-container">
          <form className="form">
            <div className="heading">
              <h2>ADD NEW TICKET</h2>
            </div>
            <label className="addTicket_label">Ticket Type</label>
            <div className="select-box">
              <select style={{ fontSize: "1.5rem" }}>
                <option>Grievance</option>
                <option>Feedback</option>
              </select>
            </div>
            <div className="input-box">
              <label className="addTicket_label">Title</label>
              <input
                type="text"
                placeholder="Ticket Title"
                required
                className="addTicket_input"
              />
            </div>
            <div className="input-box">
              <label className="addTicket_label">Description</label>
              <input
                type="text"
                placeholder="Enter Description"
                required
                className="addTicket_input"
              />
            </div>

            {/* <div className='column1'>
            <label className="addTicket_label">Assigned To</label>
            <label className="addTicket_label">Status</label>
            </div> */}
            <div className="column">
              <div className="assigned-to">
                <label className="addTicket_label">Assigned To</label>
                <div className="select-box">
                  <select style={{ fontSize: "1.5rem" }}>
                    <option>HR</option>
                    <option>Techinal Assitance</option>
                  </select>
                </div>
              </div>
              <div className="status">
                <label className="addTicket_label">Status</label>
                <div className="select-box">
                  <select disabled style={{ fontSize: "1.5rem" }}>
                    <option>OPEN</option>
                    <option>BEING ADDRESSED</option>
                    <option>RESOLVED</option>
                  </select>
                </div>
              </div>
            </div>
            <button className="newticket-btn">Generate Ticket</button>
          </form>
        </div>
      </div>
    </div>
  );
}
