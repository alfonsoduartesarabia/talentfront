import React, { useState } from "react";
import "./registration.css";
import { Link, useHistory } from "react-router-dom";
import { postRegister } from "../utility/request";
import Navbar from "../components/navbar";
// import axios from 'axios'

const employerFields = () => (
  <div>
    <label htmlFor="first-name">
      <b>Company Name</b>
    </label>
    <input
      type="text"
      placeholder="Enter your company name"
      name="company-name"
      id="company-name"
    ></input>

    <label htmlFor="first-name">
      <b>Location</b>
    </label>
    <input
      type="text"
      placeholder="Enter your location"
      name="location"
      id="location"
    ></input>
  </div>
);
const teacherFields = () => (
  <div>
    <label htmlFor="first-name">
      <b>School Name</b>
    </label>
    <input
      type="text"
      placeholder="Enter your school"
      name="school-name"
      id="school-name"
    ></input>

    <label htmlFor="first-name">
      <b>Field</b>
    </label>
    <input
      type="text"
      placeholder="Enter your major"
      name="major"
      id="major"
    ></input>
  </div>
);
const studentFields = () => (
  <div>
    <label htmlFor="first-name">
      <b>School Name</b>
    </label>
    <input
      type="text"
      placeholder="Enter your school"
      name="school-name"
      id="school-name"
    ></input>

    <label htmlFor="first-name">
      <b>Degree</b>
    </label>
    <input
      type="text"
      placeholder="Enter your degree"
      name="degree"
      id="degree"
    ></input>

    <label htmlFor="first-name">
      <b>Major</b>
    </label>
    <input
      type="text"
      placeholder="Enter your field"
      name="field"
      id="field"
    ></input>
  </div>
);
const gradFields = () => (
  <div>
    <label htmlFor="first-name">
      <b>Highest Earned Degree</b>
    </label>
    <input
      type="text"
      placeholder="Enter your highest earned degree"
      name="degree"
      id="degree"
    ></input>

    <label htmlFor="first-name">
      <b>Employer</b>
    </label>
    <input
      type="text"
      placeholder="Enter your employer"
      name="employer"
      id="employer"
    ></input>

    <label htmlFor="first-name">
      <b>Title</b>
    </label>
    <input
      type="text"
      placeholder="Enter your title"
      name="job-title"
      id="job-title"
    ></input>
  </div>
);

const Registration = () => {
  // const axios = require("axios");
  const [userType, setUserType] = useState("");
  let additionalFields = "";
  if (userType === "student") additionalFields = studentFields();
  if (userType === "recent-grad") additionalFields = gradFields();
  if (userType === "employer") additionalFields = employerFields();
  if (userType === "teacher") additionalFields = teacherFields();

  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  const [firstName, setFirstName] = useState();
  const [lastName, setLastName] = useState();
  const history = useHistory();

  const handleSubmit = (event) => {
    event.preventDefault();
    const data = JSON.stringify({
      email: email,
      password: password,
      userType: userType,
      firstName: firstName,
      lastName: lastName,
    });

    postRegister(data).then((res) => {
      console.log(res);
      history.push("/profile");
    });
  };

  return (
    <div>
      <Navbar />
      <div className="registration-container">
        <h1>Registration</h1>
        <p className="info-paragraph">
          Please fill out the form to create account.
        </p>

        <form className="register-form" onSubmit={handleSubmit}>
          <label htmlFor="email">
            <b>Email</b>
          </label>
          <input
            type="email"
            placeholder="Enter email"
            name="email"
            id="email"
            onChange={(event) => setEmail(event.target.value)}
            required
          ></input>

          <label htmlFor="first-name">
            <b>First Name</b>
          </label>
          <input
            type="text"
            placeholder="Enter first name"
            name="first-name"
            id="first-name"
            onChange={(event) => setFirstName(event.target.value)}
            required
          ></input>

          <label htmlFor="last-name">
            <b>Last Name</b>
          </label>
          <input
            type="text"
            placeholder="Enter last name"
            name="last-name"
            id="last-name"
            onChange={(event) => setLastName(event.target.value)}
            required
          ></input>

          <label htmlFor="password">
            <b>Password</b>
          </label>
          <input
            type="password"
            placeholder="Create password, max length 20"
            name="password"
            id="password"
            onChange={(event) => setPassword(event.target.value)}
            required
          ></input>

          <label htmlFor="user-type">
            <b>Indicate Type of User</b>
          </label>
          <select
            defaultValue=""
            name="user-type"
            id="user-type"
            onChange={(event) => setUserType(event.target.value)}
            required
          >
            <option value="" disabled>
              Select your option
            </option>
            <option value="talent">Talent</option> 
            <option value="recruiter">Recruiter</option>
            <option value="professor">Professor</option>

            {/* <option value="student">Student</option>
            <option value="recent-grad">Graduate</option>
            <option value="teacher">Teacher</option>
            <option value="recruiter">Recruiter</option> */}
        
          </select>
          {additionalFields}

          <button type="submit" className="register-button">
            Register
          </button>
          <p>
            Already have an account? <Link to="/login">Sign in</Link>
          </p>
        </form>
      </div>
    </div>
  );
};

export default Registration;

// const handleSubmit = (event) => {
  //   event.preventDefault()
  //   const data = JSON.stringify({
  //       "email": email,
  //       "password": password,
  //       "userType": userType,
  //       "firstName": firstName,
  //       "lastName": lastName
  //   });
    
  //   // const baseUrl = window.origin;
  //   // const baseUrl = 'http://localhost';
  //   const baseUrl = 'http://localhost:8080';

  //   const config = {
  //       method: 'post',
  //       // withCredentials: true,
  //       url: baseUrl + '/backend/api/register',
  //       headers: {
  //           'Content-Type': 'application/json'
  //       },
  //       data: data
  //   };
  //   axios(config)
  //   .then( res => {
  //       document.cookie = res.data.sessionCookie
  //       history.push("/profile")
  //   })
  //   .catch( err => {
  //       console.log(err)
  //   });
  // }
