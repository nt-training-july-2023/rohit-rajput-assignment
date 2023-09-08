import { useEffect, useState } from "react";
import "../Styles/AddNewUser.css";
import Footer from "./Footer";
import Header from "./Header";
import loginService from "./service/loginService";
import Alert from "./Alert";
import AdminDashboard from "./AdminDashboard";
import { useNavigate } from "react-router-dom";
const AddNewUser = () => {
  const [show, setShow] = useState(false);
  const [alertMessage, setAlertMessage] = useState("");
  const [usernameErr, setUsernameErr] = useState("");
  const [nameErr, setNameErr] = useState("");
  const [passwordErr, setPasswordErr] = useState("");
  const[isNavigate,setIsNavigate]=useState(false);
  const [departmentErr, setDepartmentErr] = useState("");
  const [department, setDepartment] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    fetchDepartment();
  }, []);

  const [user, setUser] = useState({
    name: "",
    username: "",
    password: "",
    userType: "MEMBER",
    departmentId: 0,
  });

  // const fetchDepartment = async () => {
  //   try {
  //     const res = await loginService.getAllDepartment();
  //     console.log(res);
  //     if (res.data.hasdata) {
  //       setDepartment(res.data.data);
  //     }
  //   } catch (error) {
  //     alert(error);
  //   }
  //   // console.log(department);
  // };

  const fetchDepartment = async () =>{
       await loginService.getAllDepartment()
       .then((res)=>{
          if(res.data.hasdata){
            setDepartment(res.data.data)
          }
       })
       .catch((error)=>{
        setShow(true);
        if(error.code==="ERR_NETWORK"){
             setAlertMessage(error.message);
        }else{
        setAlertMessage(error.response.data.message);
        }
       })
  }

  const validateUsername = (username) => {
    const usernameRegex = /^[a-z]{2,}\.[a-z]{2,}@nucleusteq\.com$/;
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
    if (departmentId===0) {
      return false;
    } else {
      return true;
    }
  };

  const validatePassword = (password) => {
    const passwordRegex =
      /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$/;
    const isValid = passwordRegex.test(password);
    return isValid;
  };

  const handleSubmit = async(e) => {
    e.preventDefault();
    console.log(user);
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
    if(validateName(user.name) && validateDepartment(user,department) && validatePassword(user.password) && validateUsername(user.username)){
      console.log(user);
      await loginService.addNewUser(user)
      .then((res)=>{
        e.preventDefault();
        setShow(true)
        setAlertMessage(res.data.message);
        setIsNavigate(true);
        // navigate("/add-user");
      }).catch((error)=>{
        setShow(true)
        if(error.code==="ERR_NETWORK"){
           setAlertMessage(error.message);
        }
        else{
          setAlertMessage(error.response.data.message);
        }
      })
    }

  };

  const closeAlert = () => {
    setAlertMessage("");
    setShow(false);
    if(isNavigate){
    navigate("/add-user");
    }
  };

  const handleChange = (e) => {
    const value = e.target.value;
    setUser({ ...user, [e.target.name]: value });
    // console.log(user);
  };

  return (
    <>
      <AdminDashboard/>
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
                type="text"
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
                  value={department.id}
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
                {departmentErr && (
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
                    onChange={(e)=>{handleChange(e)}}
                    // onChange={handleChange}

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
                    onChange={(e)=>{handleChange(e)}}
                    // onChange={(e) => handleChange(e)}
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
      {/* <Footer /> */}
      {show && <Alert message={alertMessage} close={closeAlert} />}
    </>
  );
};
export default AddNewUser;
