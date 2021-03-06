import React, {useState} from "react";
import "./registration.css";
import {Link, useHistory} from "react-router-dom";
import {postRegister} from "../utility/request";
import {useDispatch} from "react-redux";
import {getUser} from "../utility/slices/user.js";

const employerFields = () => (
    <div>
        <label htmlFor="first-name">
            <b>Company Name</b>
        </label>
        <input
            type="text"
            placeholder="Enter your company name"
            name="company-name"
            id="company-name"
        />

        <label htmlFor="first-name">
            <b>Location</b>
        </label>
        <input
            type="text"
            placeholder="Enter your location"
            name="location"
            id="location"
        />
    </div>
);
const teacherFields = () => (
    <div>
        <label htmlFor="first-name">
            <b>School Name</b>
        </label>
        <input
            type="text"
            placeholder="Enter your school"
            name="school-name"
            id="school-name"
        />

        <label htmlFor="first-name">
            <b>Field</b>
        </label>
        <input type="text" placeholder="Enter your major" name="major"
               id="major"/>
    </div>
);
const studentFields = () => (
    <div>
        <label htmlFor="first-name">
            <b>School Name</b>
        </label>
        <input
            type="text"
            placeholder="Enter your school"
            name="school-name"
            id="school-name"
        />

        <label htmlFor="first-name">
            <b>Degree</b>
        </label>
        <input
            type="text"
            placeholder="Enter your degree"
            name="degree"
            id="degree"
        />

        <label htmlFor="first-name">
            <b>Major</b>
        </label>
        <input type="text" placeholder="Enter your field" name="field"
               id="field"/>
    </div>
);
const gradFields = () => (
    <div>
        <label htmlFor="first-name">
            <b>Highest Earned Degree</b>
        </label>
        <input
            type="text"
            placeholder="Enter your highest earned degree"
            name="degree"
            id="degree"
        />

        <label htmlFor="first-name">
            <b>Employer</b>
        </label>
        <input
            type="text"
            placeholder="Enter your employer"
            name="employer"
            id="employer"
        />

        <label htmlFor="first-name">
            <b>Title</b>
        </label>
        <input
            type="text"
            placeholder="Enter your title"
            name="job-title"
            id="job-title"
        />
    </div>
);

const Registration = () => {
    const [userType, setUserType] = useState("");
    const [talentType, setTalentType] = useState("");
    let additionalFields = "";
    const dispatch = useDispatch();

    const getTalentType = () => {
        if (talentType === "student") {
            return studentFields();
        } else if (talentType === "recent-grad") {
            return gradFields();
        }
    };

    const talentField = () => (
        <div>
            <label htmlFor="talent-type">
                <b>Indicate Type of Talent</b>
            </label>
            <select
                defaultValue=""
                name="talent-type"
                id="talent-type"
                //onChange={(event) => setUserType(event.target.value)}
                required
                onChange={(e) => setTalentType(e.target.value)}
            >
                <option value="" disabled>
                    Select type of talent
                </option>
                <option value="recent-grad" id="recent-grad" name="recent-grad">
                    Graduate
                </option>
                <option value="student" id="student" name="student">
                    Student
                </option>
            </select>
            <div>{getTalentType()}</div>
        </div>
    );

    if (userType === "talent") {
        additionalFields = talentField();
    }
    if (userType === "recruiter") {
        additionalFields = employerFields();
    }
    if (userType === "professor") {
        additionalFields = teacherFields();
    }

    const [email, setEmail] = useState();
    const [password, setPassword] = useState();
    const [firstName, setFirstName] = useState();
    const [lastName, setLastName] = useState();
    const history = useHistory();

    const handleSubmit = (event) => {
        event.preventDefault();
        const data = JSON.stringify({
            email: email,
            password: password,
            userType: userType,
            firstName: firstName,
            lastName: lastName,
        });

        postRegister(data).then((res) => {
            console.log(res);
            if (res === undefined) {
                console.log("Error when registering.");
            } else {
                dispatch(getUser());
                history.push("/profile");
                window.location.reload(false);
            }
        });
    };
    return (
        <div>
            <div className="registration-container">
                <h1>Registration</h1>
                <p className="info-paragraph">
                    Please fill out the form to create account.
                </p>

                <form className="register-form" onSubmit={handleSubmit}>

                    <label htmlFor="first-name">
                        <b>First Name</b>
                    </label>
                    <input
                        type="text"
                        placeholder="Enter first name"
                        name="first-name"
                        id="first-name"
                        onChange={(event) => setFirstName(event.target.value)}
                        required
                    />

                    <label htmlFor="last-name">
                        <b>Last Name</b>
                    </label>
                    <input
                        type="text"
                        placeholder="Enter last name"
                        name="last-name"
                        id="last-name"
                        onChange={(event) => setLastName(event.target.value)}
                        required
                    />
                    <label htmlFor="email">
                        <b>Email</b>
                    </label>
                    <input
                        type="email"
                        placeholder="Enter email"
                        name="email"
                        id="email"
                        onChange={(event) => setEmail(event.target.value)}
                        required
                    />

                    <label htmlFor="password">
                        <b>Password</b>
                    </label>
                    <input
                        type="password"
                        placeholder="Create password, max length 20"
                        name="password"
                        id="password"
                        onChange={(event) => setPassword(event.target.value)}
                        required
                    />

                    <label htmlFor="user-type">
                        <b>Indicate Type of User</b>
                    </label>
                    <select
                        defaultValue=""
                        name="user-type"
                        id="user-type"
                        onChange={(event) => setUserType(event.target.value)}
                        required
                    >
                        <option value="" disabled>
                            Select your option
                        </option>
                        <option value="talent">Talent</option>
                        <option value="recruiter">Recruiter</option>
                        <option value="professor">Professor</option>
                        <option value="company">Company</option>

                        {/* <option value="student">Student</option>
            <option value="recent-grad">Graduate</option>
            <option value="teacher">Teacher</option>
            <option value="recruiter">Recruiter</option> */}
                    </select>
                    {/*{additionalFields}*/}

                    <button type="submit" className="register-button">
                        Register
                    </button>
                    <p>
                        Already have an account? <Link to="/login">Sign
                        in</Link>
                    </p>
                </form>
                <p className="terms-of-service">
                    Terms of Service: All information provided to TalentFront will
                    be displayed for any user, besides emails and passwords which
                    are not displayed anywhere on TalentFront website. We use a
                    standard salt and hash verification for saving passwords in
                    the database. So in the database there are two columns for
                    the password logic, the first being a salt the second being
                    the hash of the salt and password. When a user tries to login
                    we pull up the authentication record, grab the salt, add it
                    to the password, hash it and verify that the hashes match.
                    By using this approach we protect against rainbow table attacks.
                </p>
            </div>
            {/* <Footer/> */}
        </div>
    );
};

export default Registration;

// const handleSubmit = (event) => {
//   event.preventDefault()
//   const data = JSON.stringify({
//       "email": email,
//       "password": password,
//       "userType": userType,
//       "firstName": firstName,
//       "lastName": lastName
//   });

//   // const baseUrl = window.origin;
//   // const baseUrl = 'http://localhost';
//   const baseUrl = 'http://localhost:8080';

//   const config = {
//       method: 'post',
//       // withCredentials: true,
//       url: baseUrl + '/backend/api/register',
//       headers: {
//           'Content-Type': 'application/json'
//       },
//       data: data
//   };
//   axios(config)
//   .then( res => {
//       document.cookie = res.data.sessionCookie
//       history.push("/profile")
//   })
//   .catch( err => {
//       console.log(err)
//   });
// }
