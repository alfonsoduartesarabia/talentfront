import { createSlice } from '@reduxjs/toolkit';

export const userSlice = createSlice({
  name: 'user',
  initialState: {
    loggedIn: false,
    user: {
        firstname: "Battulga",
        lastname: "Tsogtgerel",
        email: "theonlytugla@gmail.com",
        degree: "Bachelors of Science",
        password: "omega secret password",
        about: "PRetty boi living in west coast lol",
        skills: "Runs fast, PLays dota whatrever does something everyday.",
        graduateDate: new Date(),
        userType: "student",
        school: "San Francisco State University",
        major: "Computer Science",
        imageURL: "SOME URL HERE",
        userID: "1"
    }
  },
  reducers: {
    login: (state) => {
      console.log("logging in new user")
      state.user = {
        firstname: "Battulga",
        lastname: "Tsogtgerel",
        email: "theonlytugla@gmail.com",
        degree: "Bachelors of Science",
        password: "omega secret password",
        about: "PRetty boi living in west coast lol",
        skills: "Runs fast, PLays dota whatrever does something everyday.",
        graduateDate: new Date(),
        userType: "student",
        school: "San Francisco State University",
        major: "Computer Science",
        imageURL: "SOME URL HERE",
        userID: "1"
      }
      state.loggedIn = true
    },
    logout: (state, action) => {
      state.user = {}
      state.loggedIn = false
    }
  }
})

export const { login, logout } = userSlice.actions

export default userSlice.reducer