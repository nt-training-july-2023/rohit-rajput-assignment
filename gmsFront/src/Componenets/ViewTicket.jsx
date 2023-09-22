import React, { useEffect, useState } from "react";
import "../Styles/ViewTicket.css";
import AdminDashboard from "./AdminDashboard";
import { useLocation } from "react-router-dom";
import APIService from "../Service/api";
export default function ViewTicket() {
  const location = useLocation();
  const data = location.state;
  const [ticketInfo, setTicketInfo] = useState("");
  console.log(data);

  useEffect(() => {
    fetchTicketById();
  }, []);

  const fetchTicketById = async () => {
    await APIService
      .getTicketById(data.id)
      .then((res) => {
        console.log(res.data.data);
        setTicketInfo(res.data.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  console.log(ticketInfo);

  return (
    <>
      <AdminDashboard />
      <div className="view-ticket-parent-container">
        <div className="view-ticket-container">
          <form>
            <div>
              <h2 className="heading">Ticket Information</h2>
            </div>
            <div className="view-ticket-content">
              <div className="ticket-info">
                <div className="view-ticket-input-box">
                  <label className="ticket-info-label">Title</label>
                  <input
                    type="text"
                    className="ticket-info-input"
                    disabled
                    value={ticketInfo.title}
                  />
                </div>
                <div className="view-ticket-input-box">
                  <label className="ticket-info-label">TicketType</label>
                  <input
                    type="text"
                    className="ticket-info-input"
                    disabled
                    value={ticketInfo.ticketType}
                  />
                </div>

                <div className="view-ticket-input-box">
                  <label className="ticket-info-label">Description</label>
                  <input
                    type="text"
                    className="ticket-info-input"
                    disabled
                    value={ticketInfo.description}
                  />
                </div>
                <div className="view-ticket-input-box">
                  <label className="ticket-info-label">Assigned To</label>
                  <input
                    type="text"
                    className="ticket-info-input"
                    disabled
                    value={ticketInfo.assignedTo}
                  />
                </div>
                <div className="view-ticket-input-box">
                  <label className="ticket-info-label">Assigned By</label>
                  <input
                    type="text"
                    className="ticket-info-input"
                    disabled
                    value={ticketInfo.assignedBy}
                  />
                </div>
                <div className="view-ticket-input-box">
                  <label className="ticket-info-label">Status</label>
                  <select
                    className="view-ticket-selectbox"
                    value={ticketInfo.status}
                  >
                    <option className="view-ticket-option" hidden>
                      OPEN
                    </option>
                    <option>BEING_ADDRESSED</option>
                    <option>RESOLVED</option>
                  </select>
                </div>
                <div className="view-ticket-input-box">
                  <label className="ticket-info-label">Created Time</label>
                  <input
                    type="text"
                    className="ticket-info-input"
                    disabled
                    value={ticketInfo.creationTime}
                  />
                </div>
                <div className="view-ticket-input-box">
                  <label className="ticket-info-label">Last Updated Time</label>
                  <input
                    type="text"
                    className="ticket-info-input"
                    disabled
                    value={ticketInfo.lastUpdatedTime}
                  />
                </div>
              </div>
              <div className="view-ticket-input-comment-box">
                <div className="ticket-info-comment-label">
                  <label>Comment</label>
                </div>
                <hr />
                <div className="scrollbar">
                  {ticketInfo.comments?.map((comment) => (
                    <div className="ticket-info-comment-input-div">
                      <label className="ticket-info-comment-input-lable">
                        {comment.userName} :
                      </label>
                      <span className="ticket-info-comment-input">
                        {comment.comment}
                      </span>
                    </div>
                  ))}
                </div>
              </div>
            </div>
            <div className="view-comment-add">
              <button className="view-ticket-btn" type="submit">
                Update Ticket
              </button>
              <input
                className="ticket-info-input"
                type="text"
                placeholder="Write comment here"
              />
            </div>
          </form>
        </div>
      </div>
    </>
  );
}
