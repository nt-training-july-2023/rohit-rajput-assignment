import React, { useEffect, useState } from "react";
import "../Styles/AddNewTicket.css";
import AdminDashboard from "./AdminDashboard";
import Alert from "./Alert";
import APIService from "../Service/api";
import MemberDashboard from "./MemberDashboard";

export default function AddNewTicket() {
  const [show, setShow] = useState(false);
  const [alertMessage, setAlertMessage] = useState("");
  const[titleErr,setTitleErr]=useState('');
  const[descriptionErr,setDescriptionErr]=useState("")
  const[departmentIdErr,setDepartmentIdErr]=useState("")
  const [userRole, setUserRole] = useState("");
  const [department, setDepartment] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [isPaginated, setIsPaginated] = useState(false);
  const [ticket, setTicket] = useState({
    ticketType: "GRIEVANCE",
    title: "",
    description: "",
    departmentId: 0,
    userId: JSON.parse(localStorage.getItem('user'))?.id
  });

  useEffect(()=>{
    setUserRole(localStorage.getItem('role'));
  })

  const validateDepartmentId = (departmentId) => {
    if (departmentId===0) {
      return false;
    } else {
      return true;
    }
  };

  const validateDescription = (description) =>{
     return (description.length!==0)
  }

  useEffect(() => {
    fetchDepartment();
  }, []);

  const handleChange = (e) => {
    const value = e.target.value;
    setTicket({ ...ticket, [e.target.name]: value });
    // console.log(user);
  };

  const closeAlert = () => {
    setAlertMessage("");
    setShow(false);
    // navigate("/admin");
    
};

  const fetchDepartment = async () => {
    await APIService
      .getAllDepartment(currentPage, isPaginated)
      .then((res) => {
        if (res.data.hasdata) {
          setDepartment(res.data.data);
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
  const handleSubmit = async(e) => {
    e.preventDefault();
    console.log(ticket);
    if (!validateDepartmentId(ticket.departmentId)) {
      setDepartmentIdErr("Select a department");
    } else {
      setDepartmentIdErr(0);
    }
    if (!validateDescription(ticket.description)) {
      setDescriptionErr("add description");
    } else {
      setDescriptionErr("");
    }
    if(validateDepartmentId(ticket.departmentId) && validateDescription(ticket.description)){
        await APIService.addNewTicket(ticket)
        .then((res)=>{
          setShow(true)
          setAlertMessage(res.data.message)
        }).catch((error)=>{
          setShow(true)
          if(error.code==="ERR_NETWORK"){
            setAlertMessage(error.message)
          }else{
            setAlertMessage(error.response.data.message)
          }
        })
    }
    console.log(ticket.userId);
  };
  return (
    <>
      <div>
        {userRole === 'ADMIN' ? <AdminDashboard />:<MemberDashboard/>}
        <div className="add-new-ticket-container">
          <div className="new-ticket-container">
            <form onSubmit={handleSubmit} className="form">
              <div className="heading">
                <h2>ADD NEW TICKET</h2>
              </div>
              <label className="addTicket_label">Ticket Type</label>
              <div className="select-box">
                <select
                  style={{ fontSize: "1.5rem" }}
                  onChange={(e) => {
                    handleChange(e);
                  }}
                >
                  {/* <option hidden>Select TicketType</option> */}
                  <option name="ticketType" value="GRIEVANCE">
                    Grievance
                  </option>
                  <option name="ticketType" value="FEEDBACK">
                    Feedback
                  </option>
                </select>
              </div>
              <div className="input-box">
                <label className="addTicket_label">Title</label>
                <input
                  type="text"
                  placeholder="Ticket Title"
                  name="title"
                  value={ticket.title}
                  onChange={(e) => {
                    handleChange(e);
                  }}
                  required
                  className="addTicket_input"
                />
              </div>
              <div className="input-box">
                <label className="addTicket_label">Description</label>
                {/* <input
                type="text"
                placeholder="Enter Description"
                required
                className="addTicket_input"
              /> */}
                <textarea
                  type="text"
                  placeholder="Enter Description"
                  id="addTicket-textarea"
                  name="description"
                  value={ticket.description}
                  onChange={(e) => {
                    handleChange(e);
                  }}
                  rows="4"
                  cols="50"
                />
              </div>
              {descriptionErr && (
                  <span
                    style={{
                      fontSize: "1.5rem",
                      color: "red",
                      paddingBottom: "1rem",
                    }}
                  >
                    *{descriptionErr}
                  </span>
                )}

              {/* <div className='column1'>
            <label className="addTicket_label">Assigned To</label>
            <label className="addTicket_label">Status</label>
            </div> */}
              <div className="column">
                <div className="assigned-to">
                  <label className="addTicket_label">Assigned To</label>
                  <div className="select-box">
                    <select
                      name="departmentId"
                      value={ticket.assignedTo}
                      onChange={(e) => handleChange(e)}
                      style={{ fontSize: "1.5rem" }}
                    >
                      <option hidden>Select Department</option>
                      {department.map((dept) => (
                        <option
                          className="addnewuser_option"
                          value={dept.id}
                          key={dept.id}
                        >
                          {dept.departmentName}
                        </option>
                      ))}
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
              {departmentIdErr!==0 && (
                  <span
                    style={{
                      fontSize: "1.5rem",
                      color: "red",
                      paddingBottom: "1rem",
                    }}
                  >
                    *{departmentIdErr}
                  </span>
                )}
              <button className="newticket-btn" type="submit">
                Raise Grievance
              </button>
            </form>
          </div>
        </div>
        {show && <Alert message={alertMessage} close={closeAlert}/>}
      </div>
    </>
  );
}
