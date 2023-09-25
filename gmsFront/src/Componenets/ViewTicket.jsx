import React, { useEffect, useState } from "react";
import "../Styles/ViewTicket.css";
import AdminDashboard from "./AdminDashboard";
import { useLocation, useNavigate, useParams } from "react-router-dom";
import APIService from "../Service/api";
import Alert from "./Alert";
export default function ViewTicket() {
  const [ticketDepartmentName, setTicketDepartmentName] = useState("");
  const [show, setShow] = useState(false);
  const [alertMessage, setAlertMessage] = useState("");
  const [isUpdate, setIsUpdate] = useState(false);
  const [statusErr, setStatusErr] = useState("");
  const [ticketInfo, setTicketInfo] = useState("");
  const [updateComment, setUpdateComment] = useState("");
  const [startingStatus, setStartingStatus] = useState("");
  const [updatedStatus, setUpdatedStatus] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const [err,setErr] = useState("");
  const navigate = useNavigate();
  const param = useParams();
  const ticketId = param.ticketId;

  const userDepartment = JSON.parse(
    localStorage.getItem("user")
  )?.departmentName;
  console.log(userDepartment);
   

  useEffect(() => {
    fetchTicketById();
  }, [isUpdate]);

  const handleStatus = (e) => {
    setErr("");
    setStatusErr("");
    console.log(e.target.value);
    setUpdatedStatus(e.target.value);
  };

  const handleComment = (e) => {
    setErr("");
    setErrorMessage("");
    console.log(e.target.value);
    const comment = e.target.value;
    setUpdateComment(comment);
  };

  const isCommentValid = () =>{
    if (startingStatus === "OPEN" && updateComment === "") {
      setErrorMessage("Please add a comment");
      return false;
    } else {
      setErrorMessage("");
      return true;
    }
  }

  const isErrValid = () =>{
    if(startingStatus === updatedStatus && updateComment === ""){
      setErr("Nothing to update");
      return false;
   }else{
     setErr("");
     return true;
   }
  }

  const isStatusValid = () =>{
    if (updatedStatus === "OPEN") {
      setStatusErr("Please update the status");
      return false;
    } else {
      setStatusErr("");
      return true;
    }
  }

  const fetchTicketById = async () => {
    await APIService.getTicketById(ticketId)
      .then((res) => {
        console.log(res.data.data);
        setTicketInfo(res.data.data);
        setTicketDepartmentName(res.data.data.assignedTo);
        setStartingStatus(res.data.data.status);
        setUpdatedStatus(res.data.data.status);
      })
      .catch((error) => {
        setShow(true);
        if(error.code==="ERR_NETWORK"){
          setAlertMessage(error.message);
        }else{
          setAlertMessage(error.response.data.message);
        }
      });
  };
  console.log(ticketInfo);

  const handleSubmit = async(e) => {
    e.preventDefault();
    if(isStatusValid() && isCommentValid() && isErrValid()){
      await APIService.updateTicket(updatedStatus, ticketId, updateComment)
      .then((res)=>{
        setUpdateComment("");
        setIsUpdate(!isUpdate);
        setShow(true);
        setAlertMessage(res.data.data);
        console.log(res);
      }).catch((error)=>{
        setShow(true);
        console.log(error);
        if(error.code==="ERR_NETWORK"){
          setAlertMessage(error.message);
        }else{
          setAlertMessage(error.response.data.message);
        }
      })
      setUpdateComment("");
    }
  };

  const closeAlert = () => {
    // setUpdateComment("");
    setAlertMessage("");
    setShow(false);

    // navigate('/get-all-ticket');
  };

  return (
    <>
      <AdminDashboard />
      <div className="view-ticket-parent-container">
        <div className="view-ticket-container">
          <form onSubmit={handleSubmit}>
            <div>
              <h2 className="heading">Ticket Information</h2>
            </div>
            {err !== "" && (
                  <span style={{ fontSize: "1.5rem", color: "red" }}>
                    *{err}
                  </span>
                )}
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
                    onChange={(e) => {
                      handleStatus(e);
                    }}
                    value={updatedStatus}
                    disabled={
                      startingStatus === "RESOLVED" ||
                      ticketDepartmentName !== userDepartment
                        ? true
                        : false
                    }
                  >
                    <option hidden>OPEN</option>
                    <option>BEING_ADDRESSED</option>
                    <option>RESOLVED</option>
                  </select>
                </div>
                {statusErr !== "" && (
                  <span style={{ fontSize: "1.5rem", color: "red" }}>
                    *{statusErr}
                  </span>
                )}
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
                  {errorMessage !== "" && (
                    <span style={{ fontSize: "1.5rem", color: "red" }}>
                      *{errorMessage}
                    </span>
                  )}
                </div>
              </div>
            </div>
            <div className="view-comment-add">
              <button
                className="view-ticket-btn"
                type="submit"
                hidden={
                  startingStatus === "RESOLVED" ||
                  ticketDepartmentName !== userDepartment
                    ? true
                    : false
                }
              >
                Update Ticket
              </button>
              <input
                className="ticket-info-input"
                type="text"
                onClick={(e)=>{handleComment(e)}}
                placeholder="Write comment here"
                disabled={updatedStatus === "OPEN" ? true : false}
                hidden={
                  startingStatus === "RESOLVED" ||
                  ticketDepartmentName !== userDepartment
                    ? true
                    : false
                }
              />
            </div>
          </form>
        </div>
      </div>
      {show && <Alert message={alertMessage} close={closeAlert} />}
    </>
  );
}
