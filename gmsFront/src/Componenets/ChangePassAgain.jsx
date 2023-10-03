import React, { useState } from "react";
import "../Styles/ChangePassword.css";
import AdminDashboard from "./AdminDashboard";
import { useNavigate } from "react-router-dom";
import APIService from "../Service/api";
import Alert from "./Alert";
import MemberDashboard from "./MemberDashboard";
import { useEffect } from "react";

export default function ChangePassAgain() {
  const [oldPassword, setOldPassword] = useState("");
  const [oldPasswordErr, setOldPasswordErr] = useState("");
  const [newPassword, setNewPassword] = useState("");
  const [newPasswordErr, setNewPasswordErr] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [confirmPasswordErr, setConfirmPasswordErr] = useState("");
  const [show, setShow] = useState(false);
  const [alertMessage, setAlertMessage] = useState("");
  const [userRole, setUserRole] = useState("");

  useEffect(() => {
    setUserRole(localStorage.getItem("role"));
  });

  const validateOldPassword = (oldPassword) => {
    const oldPasswordRegex =
      /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$/;
    return oldPasswordRegex.test(oldPassword);
  };

  const validateNewPassword = (newPassword) => {
    const passwordRegex =
      /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{8,20}$/;
    return passwordRegex.test(newPassword);
  };

  const validateConfirmPassword = (confirmPassword) => {
    return confirmPassword === newPassword;
  };

  const handleOldPassword = (e) => {
    setOldPassword(e.target.value);
  };

  const handleNewPassword = (e) => {
    setNewPassword(e.target.value);
  };

  const handleConfirmPassword = async (e) => {
    setConfirmPassword(e.target.value);
  };

  const closeAlert = () => {
    setAlertMessage("");
    setShow(false);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!validateOldPassword(oldPassword)) {
      setOldPasswordErr("incorrect password");
    } else {
      setOldPasswordErr("");
    }
    if (!validateNewPassword(newPassword)) {
      setNewPasswordErr("must contain uppercase, lowercase, numberic & symbol");
    } else {
      setNewPasswordErr("");
    }
    if (!validateConfirmPassword(confirmPassword)) {
      setConfirmPasswordErr("password mismatch");
    } else {
      setConfirmPasswordErr("");
    }
    if (
      validateOldPassword(oldPassword) &&
      validateNewPassword(newPassword) &&
      validateConfirmPassword(confirmPassword)
    ) {
      await APIService.changePassword(oldPassword, newPassword)
        .then((res) => {
          localStorage.setItem(
            "user",
            JSON.stringify({
              ...JSON.parse(localStorage.getItem("user")),
              encodePassword: res.data.data,
            })
          );
          setShow(true);
          setNewPassword("");
          setOldPassword("");
          setConfirmPassword("");
          setAlertMessage(res.data.message);
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
  return (
    <>
      {userRole === "ADMIN" ? <AdminDashboard /> : <MemberDashboard />}
      <div className="change-password-parent-container">
        <div className="change-password-container">
          <form onSubmit={handleSubmit}>
            <h1>Change Password</h1>
            <div>
              <label htmlFor="">Old Password</label>
              <input
                type="password"
                placeholder="Enter Old Password"
                onChange={(e) => {
                  handleOldPassword(e);
                }}
                value={oldPassword}
                className="form-control"
                required
              />
            </div>
            {oldPasswordErr && (
              <p style={{ color: "red", fontSize: "large", marginTop: "auto" }}>
                *{oldPasswordErr}
              </p>
            )}
            <div>
              <label htmlFor="">New Password</label>
              <input
                type="password"
                placeholder="Enter New Password"
                onChange={(e) => {
                  handleNewPassword(e);
                }}
                value={newPassword}
                className="form-control"
                required
              />
              {newPasswordErr && (
                <p
                  style={{ color: "red", fontSize: "large", marginTop: "auto" }}
                >
                  *{newPasswordErr}
                </p>
              )}
            </div>
            {/* {newPasswordErr && <p style={{ color: "red", fontSize:"large", marginTop:"auto" }}>*{newPasswordErr}</p>} */}
            <div>
              <label htmlFor="">Confirm Password</label>
              <input
                type="password"
                placeholder="Enter Password"
                onChange={(e) => {
                  handleConfirmPassword(e);
                }}
                value={confirmPassword}
                className="form-control"
                required
              />
            </div>
            {confirmPasswordErr && (
              <p style={{ color: "red", fontSize: "large", marginTop: "auto" }}>
                *{confirmPasswordErr}
              </p>
            )}
            <input type="submit" className="btn" value="Submit" />
          </form>
        </div>
      </div>
      {show && <Alert message={alertMessage} close={closeAlert} />}
    </>
  );
}
