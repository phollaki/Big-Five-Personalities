import axios from "axios";

const API_URL = "http://localhost:8083/api/auth/";

class StudentService {
  getTest = () => {
    return axios.get(API_URL + "test").then((response) => {
      return response.data;
    });
  };
  getPersonality = (id) => {
    return axios.post(API_URL + "personality", id).then((response) => {
      return response.data;
    });
  };
  sendTest = (result) => {
    return axios.post(API_URL + "result", result).then((response) => {
      return response.data;
    });
  };
  sendGuestTest = (result) => {
    return axios.post(API_URL + "guest", result).then((response) => {
      return response.data;
    });
  };
  getCompareData = (id, stuid) => {
    return axios
      .post(API_URL + "compare", { id: id, stuid: stuid })
      .then((response) => {
        return response.data;
      });
  };
  getCalculationData = (id) => {
    return axios.post(API_URL + "calculations", id).then((response) => {
      return response.data;
    });
  };
}

export default new StudentService();
