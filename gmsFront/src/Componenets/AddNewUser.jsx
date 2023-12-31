import { useEffect, useState } from "react";
import "../Styles/AddNewUser.css";
import Alert from "./Alert";
import AdminDashboard from "./AdminDashboard";
import { useNavigate } from "react-router-dom";
import APIService from "../Service/api";
const AddNewUser = () => {
  const [show, setShow] = useState(false);
  const [alertMessage, setAlertMessage] = useState("");
  const [usernameErr, setUsernameErr] = useState("");
  const [nameErr, setNameErr] = useState("");
  const [passwordErr, setPasswordErr] = useState("");
  const [departmentErr, setDepartmentErr] = useState(0);
  const [department, setDepartment] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [isPaginated, setIsPaginated] = useState(false);

  useEffect(() => {
    fetchDepartment();
  }, []);

  const userState = {
    name: "",
    username: "",
    password: "",
    userType: "MEMBER",
    departmentId: 0,
  };

  const [user, setUser] = useState(userState);

  const fetchDepartment = async () => {
    await APIService.getAllDepartment(currentPage, isPaginated)
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

  const validateUsername = (username) => {
    const usernameRegex = /^[a-z0-9]{2,}\.[a-z]{2,}@nucleusteq\.com$/;
    if (usernameRegex.test(username)) {
      return true;
    } else {
      return false;
    }
  };

  const validateName = (name) => {
    const nameRegex = /^[a-zA-Z ]{2,}$/;
    return nameRegex.test(name);
  };

  const validateDepartment = (departmentId) => {
    if (departmentId === 0) {
      return false;
    } else {
      return true;
    }
  };

  const validatePassword = (password) => {
    const passwordRegex =
      /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&#])[A-Za-z0-9@$!%*?&#]{8,20}$/;
    const isValid = passwordRegex.test(password);
    return isValid;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!validateUsername(user.username)) {
      setUsernameErr("Please Enter valid username");
    } else {
      setUsernameErr("");
    }
    if (!validateDepartment(user.departmentId)) {
      setDepartmentErr("Select a department");
    } else {
      setDepartmentErr(0);
    }
    if (!validateName(user.name)) {
      setNameErr("Incorrect Name");
    } else {
      setNameErr("");
    }

    if (!validatePassword(user.password)) {
      setPasswordErr("example Abc@1234 , must be 8 character long");
    } else {
      setPasswordErr("");
    }

    if (
      validateName(user.name) &&
      validateDepartment(user.departmentId) &&
      validatePassword(user.password) &&
      validateUsername(user.username)
    ) {
      const data = {
        name: user.name,
        username: user.username,
        password: btoa(user.password),
        userType: user.userType,
        departmentId: user.departmentId,
      };
      await APIService.addNewUser(data)
        .then((res) => {
          e.preventDefault();
          setShow(true);
          setAlertMessage(res.data.message);
          setUser(userState);
        })
        .catch((error) => {
          setShow(true);
          if (error.code === "ERR_NETWORK") {
            setAlertMessage(error.message);
          } else {
            setAlertMessage(error.response.data.message);
          }
        });
    }
  };

  const closeAlert = () => {
    setAlertMessage("");
    setShow(false);
  };

  const handleChange = (e) => {
    const value = e.target.value;
    setUser({ ...user, [e.target.name]: value });
  };

  return (
    <>
      <AdminDashboard />
      <div className="parent-register-container">
        <div className="register-container">
          <form onSubmit={handleSubmit} className="form">
            <div>
              <header className="addUser_heading">ADD NEW USER</header>
            </div>
            <div className="input-box">
              <label className="addUser_lable">Name</label>
              <input
                type="text"
                placeholder="Enter Name"
                name="name"
                onChange={(e) => handleChange(e)}
                value={user.name}
                required
                className="addUser_input"
              />
            </div>
            {nameErr && (
              <span style={{ fontSize: "1.5rem", color: "red" }}>
                *{nameErr}
              </span>
            )}
            <div className="input-box">
              <label className="addUser_lable">Username</label>
              <input
                type="text"
                placeholder="Enter Username"
                name="username"
                onChange={(e) => handleChange(e)}
                value={user.username}
                required
                className="addUser_input"
              />
            </div>
            {usernameErr && (
              <span style={{ fontSize: "1.5rem", color: "red" }}>
                *{usernameErr}
              </span>
            )}
            <div className="input-box">
              <label className="addUser_lable">Password</label>
              <input
                type="password"
                placeholder="Enter Password"
                name="password"
                onChange={(e) => handleChange(e)}
                value={user.password}
                required
                className="addUser_input"
              />
            </div>
            {passwordErr && (
              <span style={{ fontSize: "1.5rem", color: "red" }}>
                *{passwordErr}
              </span>
            )}
            <div className="column">
              <div className="select-box">
                <select
                  name="departmentId"
                  value={user.departmentId}
                  onChange={(e) => handleChange(e)}
                  style={{ fontSize: "1.5rem" }}
                >
                  <option className="addnewuser_option" hidden>
                    Select Department
                  </option>
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
                {departmentErr !== 0 && (
                  <span
                    style={{
                      fontSize: "1.5rem",
                      color: "red",
                      paddingBottom: "1rem",
                    }}
                  >
                    *{departmentErr}
                  </span>
                )}
              </div>
            </div>
            <div>
              <h3 style={{ fontSize: "2rem" }}>User Role</h3>
              <div className="role-option">
                <div className="role">
                  <input
                    type="radio"
                    name="userType"
                    value="MEMBER"
                    id="check-member"
                    onChange={(e) => {
                      handleChange(e);
                    }}
                    defaultChecked
                  />
                  <label className="addUser_lable" htmlFor="check-member">
                    Member
                  </label>
                </div>
                <div className="role">
                  <input
                    type="radio"
                    name="userType"
                    value="ADMIN"
                    onChange={(e) => {
                      handleChange(e);
                    }}
                    id="check-admin"
                  />
                  <label className="addUser_lable" htmlFor="check-admin">
                    Admin
                  </label>
                </div>
              </div>
            </div>
            <button className="add-user-btn" type="submit">
              Add User
            </button>
          </form>
        </div>
      </div>
      {show && <Alert message={alertMessage} close={closeAlert} />}
    </>
  );
};
export default AddNewUser;
