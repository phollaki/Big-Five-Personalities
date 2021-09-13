import axios from "axios";

const API_URL = "http://localhost:8083/api/auth/";

const register = (
  stu_id,
  password,
  dep_code,
  fac_code,
  loc_code,
  gender,
  stu_fname,
  stu_lname
) => {
  return axios.post(API_URL + "signup", {
    stu_id,
    password,
    dep_code,
    fac_code,
    loc_code,
    gender,
    stu_fname,
    stu_lname,
  });
};

const login = (username, password) => {
  return axios
    .post(API_URL + "signin", {
      username,
      password,
    })
    .then((response) => {
      if (response.data.accessToken) {
        localStorage.setItem("user", JSON.stringify(response.data));
      }
      return response.data;
    });
};

const logout = () => {
  localStorage.removeItem("user");
};

export default {
  register,
  login,
  logout,
};
