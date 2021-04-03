// import React, { useState } from 'react'
// import axios from 'axios'
import "./registration.css"

const LoginProfessor = (props) => {

    return(
        <div className="login-professor-container">    
        
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
    )
}

export default LoginProfessor