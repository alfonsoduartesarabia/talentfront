// import React, { useState } from 'react'
// import axios from 'axios'
import "./registration.css"


const Registration = (props) => {

    return(
        <div className="registration-container">
            {/* <HomeScreen/> */}
            <h1>Registration</h1>
            <p className="info-paragraph">Please fill out the form to create account.</p>

            <form action="/">
            <label for="email"><b>Email</b></label>
            <input type="text" placeholder="Enter email" name="email" id="email"></input>
            <br></br>

            <label for="first-name"><b>First Name</b></label>
            <input type="text" placeholder="Enter first name" name="first-name" id="first-name"></input>
            <br></br>

            <label for="last-name"><b>Last Name</b></label>
            <input type="text" placeholder="Enter last name" name="last-name" id="last-name"></input>
            <br></br>

            <label for="password"><b>Password</b></label>
            <input type="text" placeholder="Create password, max length 20" name="password" id="password"></input>
            <br></br>

            <label for="confirm-password"><b>Confirm Password</b></label>
            <input type="text" placeholder="Repeat password" name="confirm-password" id="confirm-password"></input>
            <br></br>

            <label for="user-type"><b>Indicate Type of User</b></label>
            <select name="user-type" id="user-type">
            <option value="recent-grad">Recent Graduate</option>
            <option value="student">Current Student</option>
            <option value="teacher">Teacher</option>
            <option value="employer">Employer</option>
            </select>
            <br></br>

            <div className="bottom-page">
            <button type="submit" class="register-button">Register</button> 
            <p>Already have an account? Sign in.</p>
            </div>
            </form>
        </div>
    )
}

export default Registration