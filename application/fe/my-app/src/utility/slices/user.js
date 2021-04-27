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
      state.experiences.push(action.payload);
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
