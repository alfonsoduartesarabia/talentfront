import React, { useState } from 'react'
import axios from 'axios'
import "./registration.css"

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
  } from "react-router-dom";

const Login = (props) => {

    //const [selectedUser, setSelectedUser] = useState()
    // const handleSubmit = (event) => {
    //     event.preventDefault()
    //     var userType = document.getElementById("login-user-type").value
    //     console.log(userType)
    // }

    return(
        <div className="login-main">
            <form>
            {/*<label for="login-user-type"><b>Indicate Type of User</b></label>
                <select name="login-user-type" id="login-user-type">
                <option value="talent">Talent</option>
                <option value="professor">Professor</option>
                <option value="employer">Employer</option>
            </select>*/}
            <input type="text" placeholder="Username" name="username" id="username"></input>
            <input type="text" placeholder="Password" name="password" id="password"></input>
            <button type="submit" class="enter-button">Login</button> 
            {/* <Link to="/register"><button type="submit" class="register-button">Signup</button> </Link> */}
            <p>Dont' have an account? <Link to="/register">Sign up</Link></p>
            </form>
        </div>
    )

}

export default Login