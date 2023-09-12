import axios from "axios";

const BASEURL = "http://localhost:8080/gms/v1/login";

const loginService = {
   login(loginCredentials)  {
    return  axios.post(BASEURL, loginCredentials);
  },
    getAllDepartment(){
      return axios.get("http://localhost:8080/department");
    },
    changePassword(password,newPassword){
      const userId = localStorage.getItem('userId')
      console.log(userId);
      console.log(newPassword);
      return axios.post("http://localhost:8080/gms/v1/change-password",{userId, password, newPassword})
    },
    addDepartment(departmentName){
      console.log(departmentName);
      return axios.post(`http://localhost:8080/department?departmentName=${departmentName}`)
    },
    addNewUser(user){
      console.log(user)
      return axios.post("http://localhost:8080/gms/v1/adduser",user)
    },
    addNewTicket(ticket){
      console.log(ticket)
      return axios.post("http://localhost:8080/ticket",ticket);
    }
};

export default loginService;
