import axios from "axios";

const BASEURL = "http://localhost:8080/gms/v1/login";

const loginService = {
   login(loginCredentials)  {
    return  axios.post(BASEURL, loginCredentials);
  },
    getAllDepartment(){
      return axios.get("http://localhost:8080/department");
    }
};

export default loginService;
