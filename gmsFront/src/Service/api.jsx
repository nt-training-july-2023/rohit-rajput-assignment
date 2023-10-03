import axios from "axios";
import AuthHeader from "./AuthHeader";

const BASEURL = "http://localhost:8080/gms/";

const APIService = {
  login(loginCredentials) {
    return axios.post(BASEURL + "auth/login", loginCredentials, {
      headers: {
        username: loginCredentials.email,
        encodePassword: loginCredentials.password,
      },
    });
  },

  getTicketById(ticketId) {
    const userId = JSON.parse(localStorage.getItem('user'))?.id; 
    return axios.get(`${BASEURL}user/ticket/${ticketId}?userId=${userId}`,{headers:AuthHeader()});
  },


  getAllTicket(currentPage, filterStatus, myTicket) {
    const userId = JSON.parse(localStorage.getItem("user"))?.id;
    if(filterStatus === ""){
    return axios.get(
      `${BASEURL}user/ticket?userId=${userId}&myTicket=${myTicket}&pageNumber=${currentPage}`,{headers:AuthHeader()});
    }else{
      return axios.get(
        `${BASEURL}user/ticket?userId=${userId}&myTicket=${myTicket}&pageNumber=${currentPage}&filterStatus=${filterStatus}`,{headers:AuthHeader()});
    }
  },


  getAllDepartment(currentPage, isPaginated) {
    return axios.get(`${BASEURL}user/department?pageNumber=${currentPage}&isPaginate=${isPaginated}`,{headers:AuthHeader()});
  },


  getAllUser(currentPage, filterDepartment) {
    const filter = filterDepartment === undefined ? "all" : filterDepartment;
    return axios.get(`${BASEURL}admin?pageNumber=${currentPage}&filterDepartment=${filter}`,{headers:AuthHeader()});
  },


  changePassword(password, newPassword) {
    const userId = JSON.parse(localStorage.getItem('user'))?.id;
    const data={
      userId:userId,
      password:btoa(password),
      newPassword:btoa(newPassword),
    };
    return axios.post(BASEURL + "auth/change-password", data,{headers:AuthHeader()});
  },


  addDepartment(departmentName) {
    return axios.post(
      `${BASEURL}admin/department?departmentName=${departmentName}`,{headers:AuthHeader()}
    );
  },


  addNewUser(user) {
    return axios.post(BASEURL + "admin/adduser", user,{headers:AuthHeader()});
  },


  addNewTicket(ticket) {
    return axios.post(BASEURL + "user/ticket", ticket,{headers:AuthHeader()});
  },

  updateTicket(status, ticketId, comment){
    const userId = JSON.parse(localStorage.getItem('user'))?.id;
    return axios.put(BASEURL + "user/ticket",{status, ticketId, userId, comment},{headers:AuthHeader()});
  },

  deleteUserById(userId){
    return axios.delete(`${BASEURL}admin/${userId}`,{headers:AuthHeader()})
  },

  deleteDepartmentById(departmentId){
    return axios.delete(`${BASEURL}admin/department/${departmentId}`,{headers:AuthHeader()})
  }
};

export default APIService;
