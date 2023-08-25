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
  const navigate = useNavigate();
  const handleSubmit = (e) => {
    e.preventDefault();
    if (!validateEmail(email)) {
      setEmailErr("Invalid username");
    } else {
      console.log(email);
      loginService
        .login({ email, password })
        .then((res) => {
          navigate("/");
        })
        .catch((error) => {
          setEmailErr("")
          setError("Invalid credential");
        });
      setEmailErr("");
    }

    setEmail("");
    setPassword("");
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

      {/* {error && <Alert message={"Invalid credential"} onClose={true} />} */}
      <div className="parent-container">
        <div className="container">
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
    </>
  );
};
export default Login;
