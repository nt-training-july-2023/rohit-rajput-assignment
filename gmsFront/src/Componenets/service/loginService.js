import axios from "axios";

const BASEURL = "http://localhost:8080/gms/v1/login";

const loginService = {
  async login(loginCredentials) {
    const res = await axios.post(BASEURL, loginCredentials);
  }
};

export default loginService;
