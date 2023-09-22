import React, { useState } from 'react'
import Alert from './Alert';
import '../Styles/NewDepartment.css'
import { useNavigate } from 'react-router-dom';
import AdminDashboard from './AdminDashboard';
import APIService from '../Service/api';

export default function AddDepartment() {
    const[departmentName, setDepartmentName]=useState('')
   const[show, setShow] = useState(false);
   const[alertMessage,setAlertMessage]= useState("")
   const[departmentNameErr,setDepartmentNameErr]=useState("")
   const[isNavigate,setIsNavigate]=useState(false);
   const navigate = useNavigate();

    const handleSubmit = async(e) => {
      e.preventDefault();
       if(!validateDepartmentName(departmentName)){
        setDepartmentNameErr("Invalid department name")
       }else{
        await APIService.addDepartment(departmentName)
        .then((res)=>{
          setShow(true)
          setAlertMessage(res.data.message);
          // navigate("/admin");
          setIsNavigate(true);
        }).catch((error)=>{
          setShow(true)
          console.log(error);
          if(error.code==="ERR_NETWORK"){
            setAlertMessage(error.message);
          }
          if(error.code==="ERR_BAD_REQUEST"){
            setAlertMessage(error.response.data.message);
          }
        })
      }
      };

    const validateDepartmentName = (departmentName) =>{
      const nameRegex = /^[a-zA-Z ]{2,}$/;
      return nameRegex.test(departmentName);
    }

    const handlesCancel = () => {
        navigate("/admin");
    };

    const closeAlert = () => {
        setAlertMessage("");
        setShow(false);
        if(isNavigate){
        navigate("/admin");
        }
    };

    const handleDepartmentName = (e) =>{
         setDepartmentName(e.target.value);
    }
  return (
    <>
    <AdminDashboard/>
    <div className="add-department">
            <div className="add-department-container">
            <form onSubmit={handleSubmit} className='form'>
            <h1>ADD DEPARTMENT</h1>
            <div className="add-department-input-box">
              <label className="add-department_lable">Department Name</label>
              <input
                type="text"
                placeholder="Enter Departemnt Name "
                name="departmentName"
                onChange={(e) => handleDepartmentName(e)}
                value={departmentName}
                required
                className="add-department-input"
              />
               {departmentNameErr && (
              <span style={{ fontSize: "1.5rem", color: "red" }}>
                *{departmentNameErr}
              </span>
            )}
              </div>
              <div className='column'>
               <button className="btn" onClick={handleSubmit}>Submit</button>
               <span><button className="btn" onClick={handlesCancel}>Cancel</button></span>
               </div>
               </form>
            </div>
            {show && <Alert message={alertMessage} close={closeAlert}/>}
    </div>
    </>
  )
}
