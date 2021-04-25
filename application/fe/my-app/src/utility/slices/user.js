import { createSlice } from "@reduxjs/toolkit";

export const userSlice = createSlice({
  name: "user",
  initialState: {},
  reducers: {
    getUser() {},
    setUser: (state, action) => {
      const userData = action.payload;
      return { ...state, ...userData };
    },
    logout: (state, action) => {
      state.user = {};
    },
  },
});

export const { setUser, logout, getUser } = userSlice.actions;

export default userSlice.reducer;
