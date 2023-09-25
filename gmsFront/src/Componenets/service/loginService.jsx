import axios from "axios";

const BASEURL = "http://localhost:8080/gms/";

const loginService = {
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
    return axios.get(`${BASEURL}user/ticket/${ticketId}?userId=${userId}`);
  },


  getAllTicket() {
    const userId = JSON.parse(localStorage.getItem("user"))?.id;
    console.log(userId);
    const myTicket = false;
    console.log(myTicket);
    return axios.get(
      `${BASEURL}user/ticket?userId=${userId}&myTicket=${myTicket}&pageNumber=${1}`);
  },


  getAllDepartment() {
    return axios.get(BASEURL + "user/department");
  },


  changePassword(password, newPassword) {
    // const userId = JSON.parse(localStorage.getItem('userId'))?.id;
    const userId = localStorage.getItem('userId');
    console.log(userId);
    console.log(password);
    console.log(newPassword);
    return axios.post(BASEURL + "auth/change-password", {
      userId,
      password,
      newPassword,
    });
  },


  addDepartment(departmentName) {
    console.log(departmentName);
    return axios.post(
      `BASEURL+user/department?departmentName=${departmentName}`
    );
  },


  addNewUser(user) {
    console.log(user);
    return axios.post(BASEURL + "admin/adduser", user);
  },


  addNewTicket(ticket) {
    console.log(ticket);
    return axios.post(BASEURL + "user/ticket", ticket);
  },
};

export default loginService;
