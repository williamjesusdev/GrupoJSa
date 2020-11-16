import axios from "axios";

const baseURL = process.env.REACT_APP_API_URL || "http://localhost:8080/api/v1";

export const api = axios.create({ baseURL });

console.log(baseURL);
