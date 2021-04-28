import { createRequest } from "../../request";
import Cookies from "universal-cookie";

const cookies = new Cookies();

export const getUser = () => {
  return createRequest({
    params: {
      cookie: cookies.get("talentfront-session"),
    },
  })
    .get("backend/api/user")
    .catch((err) => {
      console.log(err);
    });
};

export const postJobUser = (action) => {
  const job = action.payload;
  console.log(job);
  return createRequest().post("backend/api/user/experience", job);
};

export const postEducationUser = (action) => {
  const education = action.payload;
  console.log(education);
  return createRequest().post("backend/api/user/education", {
    ...education,
    isFinished: false,
  });
};

export const postSkill = (action) => {
  const skill = action.payload;
  console.log("POST SKILL HANDLER FIRED");
  console.log("skill in the request", skill);
  return createRequest().post("backend/api/user/skill", skill);
};
