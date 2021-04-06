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
            {/*<label for="login-user-type"><b>Indicate Type of User</b></label>
                <select name="login-user-type" id="login-user-type">
                <option value="talent">Talent</option>
                <option value="professor">Professor</option>
                <option value="employer">Employer</option>
            </select>*/}
            <input type="text" placeholder="Username" name="school" id="school"></input>
            <input type="text" placeholder="Password" name="school" id="school"></input>
            <button type="submit" class="enter-button">Enter</button> 
            <Link to="/register"><button type="submit" class="enter-button">Signup</button> </Link>
            </form>
        </div>
    )

}

export default LoginMain
/*
 <div className="login-talent-container">    
        
        <form action="/">
        <label for="school"><b>School</b></label>
        <input type="text" placeholder="Enter School" name="school" id="school"></input>
        <br></br>

        <label for="first-name"><b>First Name</b></label>
        <input type="text" placeholder="Enter first name" name="first-name" id="first-name"></input>
        <br></br>

        <label for="last-name"><b>Last Name</b></label>
        <input type="text" placeholder="Enter last name" name="last-name" id="last-name"></input>
        <br></br>

        <label for="degree"><b>Degree</b></label>
        <select name="degree-type" id="degree-type">
        <option value="bachelors">Bachelor's Degree</option>
        <option value="masters">Master's Degree</option>
        <option value="phd">Doctoral Degree</option>
        </select>
        <input type="text" placeholder="Enter degree" name="degree" id="degree"></input>
        <br></br>

        <label for="location"><b>Location</b></label>
        <input type="text" placeholder="Enter location" name="location" id="location"></input>
        <br></br>

        <button type="submit" class="back-button">Back</button>
        <button type="submit" class="enter-button">Enter</button> 
            
        </form>
        </div>

        */