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
          console.log(res);
          if (res.data.success) {
            localStorage.setItem("user", JSON.stringify(res.data));
            navigate("/admin");
          } else {
            setShow(true);
            setAlertMessage(res.data.message);
            // alert(res.data.message);
          }
        })
        .catch((error) => {
          alert(error);
        });
      setEmailErr("");
    }
    // else{
    //   console.log(email);
    //   const res=loginService.login({email,password});
    //   if(res.data.success){
    //     localStorage.setItem(res.data);
    //     navigate("/admin")
    //   }
    //   else{
    //     alert(res.data.message);
    //   }
    // }

    setEmail("");
    setPassword("");
  };

  const closeAlert = () => {
    setAlertMessage("");
    setShow(false);
  };

  const validateEmail = (email) => {
    if (email.endsWith("@nucleusteq.com")) {
      return true;
    }
    return false;
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
            {emailErr !== "" && <p style={{ color: "red" }}>{emailErr}</p>}
            {error && <p style={{ color: "red" }}>{error}</p>}
            <input type="submit" className="btn" value="Login" />
            <a id="forgot" href="">
              Forgot Password ?
            </a>
          </form>
        </div>
      </div>
      <Footer />
      {show && <Alert message={alertMessage} close={closeAlert} />}
    </>
  );
};
export default Login;
