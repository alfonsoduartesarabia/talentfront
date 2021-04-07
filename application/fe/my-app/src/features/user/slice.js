import { createSlice } from '@reduxjs/toolkit';

export const userSlice = createSlice({
  name: 'user',
  initialState: {
    loggedIn: false,
    user: {}
  },
  reducers: {
    login: (state, action) => {
      console.log("logging in new user", action)
      state.user = {
        name: "Battulga",
        userType: "student",
        school: "San Francisco State University",
        major: "Computer Science",
        imageURL: "SOME URL HERE"
      }
      state.loggedIn = true
      // SEND BACKEND AUTH API CALL
    },
    logout: (state, action) => {
      state.user = {}
      state.loggedIn = false
    }
  }
})

export const { login, logout } = userSlice.actions

export default userSlice.reducer