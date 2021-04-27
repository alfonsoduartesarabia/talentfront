import { createSlice } from "@reduxjs/toolkit";
import Cookies from "universal-cookie";

const cookies = new Cookies();

export const userSlice = createSlice({
  name: "user",
  initialState: {},
  reducers: {
    getUser() {},
    setUser: (state, action) => {
      const userData = action.payload;
      if (typeof userData !== "object") return;
      return { ...state, ...userData };
    },
    logout: (state, action) => {
      cookies.remove("talentfront-session");
      return {};
    },
    addJob: (state, action) => {
      const { title, company, description } = action.payload;
      //¯\_(ツ)_/¯ in the response we get startDt and endDt
      // to be consistent changing this here so we store it
      // as startDt and endDt so UI doesnt get confused
      console.log(action.payload);
      // state.experiences.push({
      //   title,
      //   company,
      //   description,
      //   startDt: action.payload.dateStart.substring(
      //     0,
      //     action.payload.dateStart.length - 3
      //   ),
      //   endDt: action.payload.dateEnd.substring(
      //     0,
      //     action.payload.dateEnd.length - 3
      //   ),
      // });
    },
    updateEducation: (state, action) => {
      const { school, degree } = action.payload;
      return { ...state, school, degree };
    },
  },
});

export const {
  setUser,
  logout,
  getUser,
  addJob,
  updateEducation,
} = userSlice.actions;

export const selectUser = (state) => state.user.user;

export default userSlice.reducer;
