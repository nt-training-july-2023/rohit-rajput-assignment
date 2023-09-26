import axios from "axios";
import AuthHeader from "./AuthHeader";

const BASEURL = "http://localhost:8080/gms/";

const APIService = {
  login(loginCredentials) {
    const header = {
      username: loginCredentials.email,
      encodedPassword: btoa(loginCredentials.password),
    };
    console.log(loginCredentials);
    console.log(header.username);
    console.log(header.encodedPassword);
    console.log(header);
    return axios.post(BASEURL + "auth/login", loginCredentials, {
      headers: {
        username: loginCredentials.email,
        encodePassword: btoa(loginCredentials.password),
      },
    });
  },

  getTicketById(ticketId) {
    const userId = JSON.parse(localStorage.getItem('user'))?.id; 
    return axios.get(`${BASEURL}user/ticket/${ticketId}?userId=${userId}`,{headers:AuthHeader()});
  },


  getAllTicket(currentPage, filterStatus, myTicket) {
    const userId = JSON.parse(localStorage.getItem("user"))?.id;
    console.log(userId);
    // const myTicket = false;
    console.log(myTicket);
    console.log(currentPage);
    console.log(filterStatus);
    if(filterStatus === ""){
    return axios.get(
      `${BASEURL}user/ticket?userId=${userId}&myTicket=${myTicket}&pageNumber=${currentPage}`,{headers:AuthHeader()});
    }else{
      return axios.get(
        `${BASEURL}user/ticket?userId=${userId}&myTicket=${myTicket}&pageNumber=${currentPage}&filterStatus=${filterStatus}`,{headers:AuthHeader()});
    }
  },


  getAllDepartment() {
    return axios.get(BASEURL + "user/department",{headers:AuthHeader()});
  },


  changePassword(password, newPassword) {
    const userId = JSON.parse(localStorage.getItem('user'))?.id;
    // const userId = localStorage.getItem('userId');
    console.log(userId);
    console.log(password);
    console.log(newPassword);
    return axios.post(BASEURL + "auth/change-password", {
      userId,
      password,
      newPassword,
    },{headers:AuthHeader()});
  },


  addDepartment(departmentName) {
    console.log(departmentName);
    return axios.post(
      `${BASEURL}admin/department?departmentName=${departmentName}`,{headers:AuthHeader()}
    );
  },


  addNewUser(user) {
    console.log(user);
    return axios.post(BASEURL + "admin/adduser", user,{headers:AuthHeader()});
  },


  addNewTicket(ticket) {
    console.log(ticket);
    return axios.post(BASEURL + "user/ticket", ticket,{headers:AuthHeader()});
  },

  updateTicket(status, ticketId, comment){
    const userId = JSON.parse(localStorage.getItem('user'))?.id;
    console.log(userId);
    console.log(comment);
    return axios.put(BASEURL + "user/ticket",{status, ticketId, userId, comment},{headers:AuthHeader()});
  }
};

export default APIService;
