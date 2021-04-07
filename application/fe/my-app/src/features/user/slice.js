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
        about: "Im a computer student. I like playing basketball and soccer. My favorite artists are Weeknd, Post Malone & Joji.",
        skills: "C++, GoLang, JavaScript, React",
        graduateDate: new Date(),
        userType: "student",
        school: "San Francisco State University",
        major: "Computer Science",
        imageURL: "SOME URL HERE",
        userID: "2"
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
        about: "Im a computer student. I like playing basketball and soccer. My favorite artists are Weeknd, Post Malone & Joji.",
        skills: "C++, GoLang, JavaScript, React",
        graduateDate: new Date(),
        userType: "student",
        school: "San Francisco State University",
        major: "Computer Science",
        imageURL: "SOME URL HERE",
        userID: "2"
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