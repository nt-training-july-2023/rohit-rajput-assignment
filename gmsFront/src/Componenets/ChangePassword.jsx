import { useState } from "react";
import "../Styles/Login.css";
import { redirect, useNavigate } from "react-router-dom";
import Footer from "./Footer";
import Header from "./Header";
import Alert from "./Alert";
import APIService from "../Service/api";
const ChangePassword = () => {
    const[newPassword, setNewPassword] = useState('');
    const[newPasswordErr, setNewPasswordErr] = useState('');
    const[confirmPassword, setConfirmPassword] = useState('');
    const[confirmPasswordErr, setConfirmPasswordErr] = useState('')
    const [show, setShow] = useState(false);
    const [alertMessage, setAlertMessage] = useState("");
    const[navigateLogin,setNavigateLogin]=useState(false);
    // const[userId, setuserId]= useState(0);
    const navigate = useNavigate();

    const validateNewPassword = (newPassword) =>{
        const passwordRegex =/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$/;
        return passwordRegex.test(newPassword);
    }

    const validateConfirmPassword = (confirmPassword) =>{
        return confirmPassword===newPassword;
    }
    const handleNewPassword = (e) =>{
         setNewPassword(e.target.value);
    }

    const handleConfirmPassword = async(e) =>{
       setConfirmPassword(e.target.value);
   }

   const closeAlert = () => {
    setAlertMessage("");
    setShow(false);
    if(navigateLogin){
      localStorage.clear();
    navigate("/login");
    }
  };

   const handleSubmit = async(e) =>{
    e.preventDefault();
    if(!validateNewPassword(newPassword)){
         setNewPasswordErr("must contain uppercase, lowercase, numberic & special symbol")
    }
    else{
        setNewPasswordErr("");
    }
    if(!validateConfirmPassword(confirmPassword)){
        setConfirmPasswordErr("password mismatch");  
    }
    else{
        setConfirmPasswordErr("");
    }
    if(validateNewPassword(newPassword) && validateConfirmPassword(confirmPassword)){
        // setNewPasswordErr("");
        // setuserId(localStorage.getItem('userId'));
        // console.log(userId);
        await APIService.changePassword(newPassword ,confirmPassword)
        .then((res) => {
             setShow(true);
             setAlertMessage(res.data.message);
             localStorage.clear();
             setNavigateLogin(true);
            //  navigate("/login");
        })
        .catch((error)=>{
            console.log(error);
            setShow(true);
            if(error.code==="ERR_NETWORK"){
               setAlertMessage(error.message);
            }else{
                setAlertMessage(error.response.data.message);
            }
        })
    }
    
    

   }

  return (
    <>
      <Header />
      <div className="parent-container">
        <div className="login-container">
          <form onSubmit={handleSubmit}>
            <h1>Change Password</h1>
            <div>
              <label htmlFor="">New Password</label>
              <input
                type="password"
                placeholder="Enter New Password"
                onChange={(e)=>handleNewPassword(e)}
                value={newPassword}
                className="form-control"
                required
              />
            </div>
            {newPasswordErr && <p style={{ color: "red" }}>{newPasswordErr}</p>}
            <div>
              <label htmlFor="">Confirm Password</label>
              <input
                type="password"
                placeholder="Enter Password"
                onChange={(e)=>handleConfirmPassword(e)}
                value={confirmPassword}
                className="form-control"
                required
              />
            </div>
            {confirmPasswordErr && <p style={{ color: "red" }}>{confirmPasswordErr}</p>}
            <input type="submit" className="btn" value="Save" />
          </form>
        </div>
      </div>
      <Footer />
      {show && <Alert message={alertMessage} close={closeAlert} />}
    </>
  );
};
export default ChangePassword;

