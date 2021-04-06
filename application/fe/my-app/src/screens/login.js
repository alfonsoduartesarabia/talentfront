import React, { useState } from 'react'
import axios from 'axios'
import LoginEmployer from './login-employer'
import LoginProfessor from './login-professor'
import LoginTalent from './login-talent'
import "./registration.css"

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
  } from "react-router-dom";

const LoginMain = (props) => {

    const [selectedUser, setSelectedUser] = useState()
    var res

    const handleSubmit = (event) => {
        event.preventDefault()

        var userType = document.getElementById("login-user-type").value
        console.log(userType)

        // switch(userType){
        //     case "talent":
        //         res = '/login-talent'
        //     case "professor":
                
        //     case "employer":
        //         <div><LoginEmployer /></div>
        // }

        return(
            <Router>

            </Router>
        )

        
    }

    function LoginUser(props){

    }

    return(
        <div className="login-main">
            <form onSubmit={handleSubmit}>
            <label for="login-user-type"><b>Indicate Type of User</b></label>
            <select name="login-user-type" id="login-user-type">
            <option value="talent">Talent</option>
            <option value="professor">Professor</option>
            <option value="employer">Employer</option>
            </select>
            <button type="submit" class="enter-button">Enter</button> 
            </form>
        </div>
    )

}

export default LoginMain