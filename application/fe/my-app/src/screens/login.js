import React from 'react'
// import axios from 'axios'
import "./registration.css"
import Navbar from '../components/navbar'
import {
    // BrowserRouter as Router,
    // Switch,
    // Route,
    Link
  } from "react-router-dom";

import { useDispatch } from 'react-redux'
import { login } from "../features/user/slice"

const Login = (props) => {
    const dispatch = useDispatch()
    //const [selectedUser, setSelectedUser] = useState()
    // const handleSubmit = (event) => {
    //     event.preventDefault()
    //     var userType = document.getElementById("login-user-type").value
    //     console.log(userType)
    // }

    /**
     * Austin's Code for login endpoint
     */

    let handleSubmit = (event) => {
        event.preventDefault()
        console.log("HELLO?")
        console.log(login)
        dispatch(login())
    }

    // var data = JSON.stringify({
    // "email": "test-email2@tester.mail",
    // "password": "badfishsmell"
    // });

    // var config = {
    //     method: 'post',
    //     url: 'http://localhost:8080/backend/api/login',
    //     headers: { 
    //         'Content-Type': 'application/json'
    //     },
    //     data : data
    // };

    // axios(config)
    //     .then(function (response) {
    //         console.log(JSON.stringify(response.data));
    //     })
    //     .catch(function (error) {
    //         console.log(error);
    //     });

    return(
        <div>
            <Navbar />
            <div className="login-main">
                <form onSubmit={handleSubmit}>
                    {/*<label for="login-user-type"><b>Indicate Type of User</b></label>
                        <select name="login-user-type" id="login-user-type">
                        <option value="talent">Talent</option>
                        <option value="professor">Professor</option>
                        <option value="employer">Employer</option>
                    </select>*/}
                    <input type="text" placeholder="Username" name="username" id="username"></input>
                    <input type="text" placeholder="Password" name="password" id="password"></input>
                    <button onClick={handleSubmit} type="submit" class="enter-button">Login</button> 
                    {/* <Link to="/register"><button type="submit" class="register-button">Signup</button> </Link> */}
                    <p>Dont' have an account? <Link to="/register">Sign up</Link></p>
                </form>
            </div>    
        </div>
        
    )

}

export default Login