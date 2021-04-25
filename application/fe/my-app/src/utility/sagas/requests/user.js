import axios from "axios";
import Cookies from "universal-cookie";
import { instance } from "../../request";

const cookies = new Cookies();

export const getUser = () => {
  return instance.get("backend/api/user");
};
