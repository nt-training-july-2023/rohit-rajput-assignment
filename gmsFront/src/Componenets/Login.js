import { useState } from "react";
import "../Styles/Login.css";
import loginService from "./service/loginService";
import { redirect, useNavigate } from "react-router-dom";
import Footer from "./Footer";
import Header from "./Header";
import Alert from "./Alert";
const Login = () => {
  const [emailErr, setEmailErr] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [show, setShow] = useState(false);
  const [alertMessage, setAlertMessage] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!validateEmail(email)) {
      setEmailErr("Invalid username");
    } else {
      console.log(email);
      await loginService
        .login({ email, password })
        .then((res) => {
          // console.log(res.data.data.firstLogin);
          if (res.data.data.firstLogin) {
            localStorage.setItem('userId',res.data.data.id);
           
            // role(res.data.data.role);
            navigate("/change-password");
          } else {
            // role(res.data.data.role);            
            const mockdata = res.data.data;
            if (mockdata.hasOwnProperty("firstLogin")) {
              delete mockdata.firstLogin;
            }
            console.log(mockdata);
            localStorage.setItem("user", JSON.stringify(mockdata));
            localStorage.setItem("role", mockdata.role);
            if(localStorage.getItem("role")==="ADMIN"){
              navigate("/admin")
            }
            else{
              navigate("/member")
            }
          }
        })
        .catch((error) => {
          console.log(error);
          setShow(true);
          if (error.code === "ERR_NETWORK") {
            setAlertMessage(error.message);
          } else {
            setAlertMessage(error.response.data.message);
          }
        });
      setEmailErr("");
    }
  };

  const closeAlert = () => {
    setAlertMessage("");
    setShow(false);
  };

  const validateEmail = (email) => {
    const emailRegex = /^[a-z]{2,}\.[a-z]{2,}@nucleusteq\.com$/;
    if (emailRegex.test(email)) {
      return true;
    } else {
      return false;
    }
  };

  const handleEmail = (e) => {
    setEmail(e.target.value);
  };

  const handlePassword = (e) => {
    setPassword(e.target.value);
  };
  return (
    <>
      <Header />

      {/* {show && <Alert message={alertMessage} close={closeAlert} />} */}
      <div className="parent-container">
        <div className="login-container">
          <form onSubmit={handleSubmit}>
            <h1>Login</h1>
            <div>
              <label htmlFor="">Username</label>
              <input
                type="text"
                placeholder="Enter Username"
                onChange={handleEmail}
                value={email}
                className="form-control"
                required
              />
            </div>
            {/* {emailErr !== "" && <p style={{ color: "red" }}>{emailErr}</p>} */}
            <div>
              <label htmlFor="">Password</label>
              <input
                type="password"
                placeholder="Enter password"
                onChange={handlePassword}
                value={password}
                className="form-control"
                required
              />
            </div>
            {emailErr !== "" && (
              <p style={{ color: "red", fontSize: "1.5rem" }}>{emailErr}</p>
            )}
            {error && <p style={{ color: "red" }}>{error}</p>}
            <input type="submit" className="btn" value="Login" />
            {/* <a id="forgot" href="">
              Forgot Password ?
            </a> */}
          </form>
        </div>
      </div>
      <Footer />
      {show && <Alert message={alertMessage} close={closeAlert} />}
    </>
  );
};
export default Login;
