import axios from "axios";
import Cookies from "universal-cookie";

const cookies = new Cookies();

// const BASE_URL =
//   process.env.REACT_APP_ENV === "PROD" ? window.origin : "http://localhost";

// @Alfonso works for me when yarn and docker are running
const BASE_URL = "http://localhost:8080";

const instance = axios.create({
  // withCredentials: true,
  baseURL: BASE_URL,
  params: {
    cookie: cookies.get("talentfront-session"),
  },
});

// const instance= () => {
//   const [sessionCookie, setSessionCookie] = useCookies(["name"]);
//   return axios.create({
//     withCredentials: true,
//     baseURL: BASE_URL,
//     params: {
//       cookie: sessionCookie,
//     },
//   });
// };

export { instance, BASE_URL };
const cookieAsQueryParam = () => {
  return "?cookie=" + document.cooki;
};

export function postSearch(data) {
  return instance.post("search", data);
  // return axios.request({
  //   method: "post",
  //   url: BASE_URL + "/backend/api/search",
  //   data
  // })
  // .then(res => { console.log(res) })
  // .catch(err => { console.log(err) })
}

export const postLogin = async (data) => {
  const config = {
    // withCredentials: true,
    method: "post",
    url: BASE_URL + "/backend/api/login",
    headers: {
      "Content-Type": "application/json",
      // "Access-Control-Allow-Origin": "*"
    },
    data: data,
  };

  try {
    const res = await axios(config);
    cookies.set(res.data.sessionCookie);
    return res;
  } catch (err) {
    console.log(err);
  }
};

export const postRegister = (data) => {
  const config = {
    method: "post",
    url: BASE_URL + "/backend/api/register",
    headers: {
      "Content-Type": "application/json",
    },
    data: data,
  };
  // @TODO look into this later.
  return axios(config)
    .then((res) => {
      cookies.set(res.data.sessionCookie);
      return res;
    })
    .catch((err) => {
      console.log(err);
    });
};

export const getMyProfile = () => {
  console.log("session cookie:", cookies.get("talentfront-session"));
  console.log("GET backend/api/user");
  return instance
    .get("backend/api/user")
    .then((res) => {
      return res;
    })
    .catch((err) => {
      console.log("Get profile request failed: /backend/api/user");
      console.log(err);
      return "err";
    });
};

export const getProfile = (id) => {
  console.log("SESSION COOKIE WE HAVE IS:", cookies.get("talentfront-session"));
  return instance
    .get("backend/api/user/" + id)
    .then((res) => {
      console.log("RESPONSE FROM", BASE_URL + "/backend/api/user/" + id);
      console.log(res);
      return res;
    })
    .catch((err) => {
      console.log("Get profile request failed: /backend/api/user/" + id);
      console.log(err);
      return "err";
    });
};

// export const updateProfile = () => {
//   return instance
// @TODO update Profile Individually
// for ENDPOINTS OPEN THE DOC FROM GOOGLE
// IMAGE
// SKILLS /backend/api/user/
// EXPERIENCE <- COMPANY NAME
// EDUCATION
// WEEK #1
// }

// JOB DESCRIPTION
// EXPRIENCE REQUIREMENT
// SALARY RANGE : top & bottom
// TITLE
// LOCATION

export const postNewJob = (job) => {
  return instance.post("backend/api/user/experience", job).then((res) => {
    console.log(res);
    return res;
  });
};
