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

    /**
     * Austin's Code for login endpoint
     */
    var axios = require('axios');
    var data = JSON.stringify({
    "email": "test-email2@tester.mail",
    "password": "badfishsmell"
    });

    var config = {
    method: 'post',
    url: 'http://localhost:8080/backend/api/login',
    headers: { 
        'Content-Type': 'application/json'
    },
    data : data
    };

    axios(config)
    .then(function (response) {
    console.log(JSON.stringify(response.data));
    })
    .catch(function (error) {
    console.log(error);
    });

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