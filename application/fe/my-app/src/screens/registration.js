import React, { useState } from 'react'
// import axios from 'axios'
import "./registration.css"
import {Link, useHistory} from 'react-router-dom'

import Navbar from '../components/navbar'

const Registration = () => {

    const [userType, setUserType] = useState("")
    let additionalFields = "";

    if (userType === "student") {
        additionalFields =
            (<div>
                <label for="first-name"><b>School Name</b></label>
                <input type="text" placeholder="Enter your school" name="school-name" id="school-name"></input>

                <label for="first-name"><b>Degree</b></label>
                <input type="text" placeholder="Enter your degree" name="degree" id="degree"></input>

                <label for="first-name"><b>Major</b></label>
                <input type="text" placeholder="Enter your field" name="field" id="field"></input>

            </div>)
    }

    if (userType === "recent-grad") {
        additionalFields =
            (<div>
                <label for="first-name"><b>Highest Earned Degree</b></label>
                <input type="text" placeholder="Enter your highest earned degree" name="degree" id="degree"></input>

                <label for="first-name"><b>Employer</b></label>
                <input type="text" placeholder="Enter your employer" name="employer" id="employer"></input>

                <label for="first-name"><b>Title</b></label>
                <input type="text" placeholder="Enter your title" name="job-title" id="job-title"></input>

            </div>)
    }

    if (userType === "employer") {
        additionalFields =
            (<div>
                <label for="first-name"><b>Company Name</b></label>
                <input type="text" placeholder="Enter your company name" name="company-name" id="company-name"></input>

                <label for="first-name"><b>Location</b></label>
                <input type="text" placeholder="Enter your location" name="location" id="location"></input>

            </div>)
    }
    if (userType === "teacher") {
        additionalFields =
            (<div>
                <label for="first-name"><b>School Name</b></label>
                <input type="text" placeholder="Enter your school" name="school-name" id="school-name"></input>

                <label for="first-name"><b>Field</b></label>
                <input type="text" placeholder="Enter your major" name="major" id="major"></input>

            </div>)
    }
    const handleChange = (event) => {
        setUserType(event.target.value)
    }
    const [email, setEmail] = useState();
    const [password, setPassword] = useState();
    const [firstName, setFirstName] = useState();
    const [lastName, setLastName] = useState();
    const history = useHistory();
    const axios = require('axios');


    const handleSubmit = (event) => {
        /**
         * Austin's Code for register endpoint
         */
        event.preventDefault()
        const data = JSON.stringify({
            "email": email,
            "password": password,
            "userType": userType,
            "firstName": firstName,
            "lastName": lastName
        });

        const baseUrl = window.origin;
        // const baseUrl = 'http://localhost';

        const config = {
            method: 'post',
            // withCredentials: true,
            url: baseUrl + '/backend/api/register',
            headers: {
                'Content-Type': 'application/json'
            },
            data: data
        };

        axios(config)
        .then( res => {
            document.cookie = res.data.sessionCookie
            history.push("/profile")
        })
        .catch( err => {
            console.log(err)
        })

    }
    return(
        <div>
            <Navbar />
            <div className="registration-container">
                <h1>Registration</h1>
                <p className="info-paragraph">Please fill out the form to create account.</p>

                <form className="register-form" onSubmit={handleSubmit}>
                    <label for="email"><b>Email</b></label>
                    <input type="text" placeholder="Enter email" name="email" id="email" onChange={event => setEmail(event.target.value)}></input>

                    <label for="first-name"><b>First Name</b></label>
                    <input type="text" placeholder="Enter first name" name="first-name" id="first-name" onChange={event => setFirstName(event.target.value)}></input>

                    <label for="last-name"><b>Last Name</b></label>
                    <input type="text" placeholder="Enter last name" name="last-name" id="last-name" onChange={event => setLastName(event.target.value)}></input>

                    <label for="password"><b>Password</b></label>
                    <input type="password" placeholder="Create password, max length 20" name="password" id="password" onChange={event => setPassword(event.target.value)}></input>

                    <label for="user-type"><b>Indicate Type of User</b></label>
                    <select name="user-type" id="user-type" onChange={handleChange}>
                        <option value="" disabled selected>Select your option</option>
                        <option value="talent">Talent</option>
                        <option value="recruiter">Employer</option>
                        <option value="professor">Teacher</option>
                    </select>
                    { additionalFields }

                    <button type="submit" class="register-button">Register</button>
                    <p>Already have an account? <Link to="/login">Sign in</Link></p>

                </form>
            </div>
        </div>

    )
}

export default Registration
