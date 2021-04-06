import React, { useState } from 'react'
// import axios from 'axios'
import "./registration.css"
import {Link} from 'react-router-dom'


const Registration = (props) => {
    const [userType, setUserType] = useState("recent-grad")
    let additionalFields = "";
    
    if (userType == "student") {
        additionalFields = 
        (<div> 
            <label for="first-name"><b>School Name</b></label>
            <input type="text" placeholder="Enter your school" name="school-name" id="school-name"></input>
            <br></br>
            <label for="first-name"><b>Degree</b></label>
            <input type="text" placeholder="Enter your degree" name="degree" id="degree"></input>
            <br></br>
            <label for="first-name"><b>Major</b></label>
            <input type="text" placeholder="Enter your field" name="field" id="field"></input>
            <br></br>
        </div>)
    }

    if (userType == "recent-grad") {
        additionalFields = 
        (<div> 
            <label for="first-name"><b>Highest Earned Degree</b></label>
            <input type="text" placeholder="Enter your highest earned degree" name="degree" id="degree"></input>
            <br></br>
            <label for="first-name"><b>Employer</b></label>
            <input type="text" placeholder="Enter your employer" name="employer" id="employer"></input>
            <br></br>
            <label for="first-name"><b>Title</b></label>
            <input type="text" placeholder="Enter your title" name="job-title" id="job-title"></input>
            <br></br>
        </div>)
    }

    if (userType == "employer") {
        additionalFields = 
        (<div> 
            <label for="first-name"><b>Company Name</b></label>
            <input type="text" placeholder="Enter your company name" name="company-name" id="company-name"></input>
            <br></br>
            <label for="first-name"><b>Location</b></label>
            <input type="text" placeholder="Enter your location" name="location" id="location"></input>
            <br></br>
        </div>)
    }
    if (userType == "teacher") {
        additionalFields = 
        (<div> 
            <label for="first-name"><b>School Name</b></label>
            <input type="text" placeholder="Enter your school" name="school-name" id="school-name"></input>
            <br></br>
            <label for="first-name"><b>Field</b></label>
            <input type="text" placeholder="Enter your major" name="major" id="major"></input>
            <br></br>
        </div>)
    }
    const handleChange = (event) => {
        setUserType(event.target.value)
    }

    return(
        <div className="registration-container">
            {/* <HomeScreen/> */}
            <h1>Registration</h1>
            <p className="info-paragraph">Please fill out the form to create account.</p>

            <form className="register-form" action="/">
            <label for="email"><b>Email</b></label>
            <input type="text" placeholder="Enter email" name="email" id="email"></input>
            

            <label for="first-name"><b>First Name</b></label>
            <input type="text" placeholder="Enter first name" name="first-name" id="first-name"></input>

            <label for="last-name"><b>Last Name</b></label>
            <input type="text" placeholder="Enter last name" name="last-name" id="last-name"></input>

            <label for="password"><b>Password</b></label>
            <input type="text" placeholder="Create password, max length 20" name="password" id="password"></input>

            <label for="confirm-password"><b>Confirm Password</b></label>
            <input type="text" placeholder="Repeat password" name="confirm-password" id="confirm-password"></input>

            <label for="user-type"><b>Indicate Type of User</b></label>
            <select name="user-type" id="user-type" onChange={handleChange}>
                <option value="recent-grad">Recent Graduate</option>
                <option value="student">Current Student</option>
                <option value="teacher">Teacher</option>
                <option value="employer">Employer</option>
            </select>
            { additionalFields }


            <div className="bottom-page">
            <button type="submit" class="register-button">Register</button> 
            <p>Already have an account? <Link to="/login">Sign in</Link></p>
            </div>
            </form>
        </div>
    )
}

export default Registration