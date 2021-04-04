// import React, { useState } from 'react'
// import axios from 'axios'
import "./registration.css"

const LoginEmployer = (props) => {

    return(
        <div className="login-employer-container">    
        
        <form action="/">
        <label for="company-name"><b>Company Name</b></label>
        <input type="text" placeholder="Enter name" name="company-name" id="company-name"></input>
        <br></br>

        <label for="location"><b>Location</b></label>
        <input type="text" placeholder="Enter location" name="location" id="location"></input>
        <br></br>

        <button type="submit" class="enter-button">Enter</button> 
        <p>Already have an account? <a href="#">Sign in</a>.</p>
            
        </form>
        </div>
    )
}

export default LoginEmployer
