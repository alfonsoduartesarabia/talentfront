import axios from "axios";
import Cookies from "universal-cookie";

const cookies = new Cookies();

// const BASE_URL =
//   process.env.REACT_APP_ENV === "PROD" ? window.origin : "http://localhost";

// @Alfonso works for me when yarn and docker are running
// const BASE_URL = "http://localhost:8080";
const BASE_URL = window.origin;

const source = axios.CancelToken.source(); // cancel a request using a cancel token
// {cancelToken: source.token}
/**
 * https://github.com/axios/axios#cancellation
 * https://dev.to/otamnitram/react-useeffect-cleanup-how-and-when-to-use-it-2hbm
 */

const createRequest = () =>
  axios.create({
    // withCredentials: true,
    baseURL: BASE_URL,
    params: {
      cookie: cookies.get("talentfront-session"),
    },
  });

export { createRequest, BASE_URL };
// const cookieAsQueryParam = () => {
//   return "?cookie=" + document.cooki;
// };

export function postSearch(data) {
  return createRequest()
    .post("/backend/api/search", data)
    .then((res) => {
      console.log(res);
      return res;
    })
    .catch((err) => {
      console.log(err);
    });
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

export const getImageLink = (isUsersPage, id) => {
  return isUsersPage
      ? `${BASE_URL}/backend/api/user-image/?cookie=${cookies.get(
          "talentfront-session")}`
      : `${BASE_URL}/backend/api/user-image/${id}`;
};

export const postUserImage = (formData) => {
  axios
  .post(BASE_URL + `/backend/api/user-image/upload?cookie=${cookies.get("talentfront-session")}`, formData, {
    "Content-Type": "Multipart-FormData",
  })
  .then((res) => {
    console.log("RECEIVED IMAGE URL", res.config.url);
  })
  .catch((err) => {
    console.log(err);
  });
}

export const getProfile = (id) => {
  console.log("SESSION COOKIE WE HAVE IS:", cookies.get("talentfront-session"));
  return createRequest()
    .get("backend/api/user/" + id)
    .then((res) => {
      console.log("RESPONSE FROM", BASE_URL + "/backend/api/user/" + id);
      console.log(res);
      return res;
    })
    .catch((err) => {
      console.log("Get profile request failed: /backend/api/user/" + id);
      console.log(err);
      source.cancel();
      return "err";
    });
};

export const getPosting = (id) => {
  console.log("SESSION COOKIE WE HAVE IS:", cookies.get("talentfront-session"));
  return createRequest()
  .get("backend/api/posting/" + id)
  .then((res) => {
    console.log("RESPONSE FROM", BASE_URL + "/backend/api/posting/" + id);
    console.log(res);
    return res;
  })
  .catch((err) => {
    console.log("Get posting request failed: /backend/api/posting/" + id);
    console.log(err);
    source.cancel();
    return "err";
  });
};

export const postPosting = (postingData) => {
  return createRequest()
  .post("/backend/api/posting", postingData)
  .then((res) => {
    console.log(res);
    return res;
  });
}

export const postAddJob = (job) => {
  return createRequest()
    .post("backend/api/user/experience", job)
    .then((res) => {
      console.log(res);
      return res;
    });
};
