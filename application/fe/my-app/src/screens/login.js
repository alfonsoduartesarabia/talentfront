import React, {useState} from "react";
import "./registration.css";
import Navbar from "../components/navbar";
import { Link, useHistory } from "react-router-dom";
import { useDispatch } from "react-redux";
import { login } from "../utility/slices/user";
import { postLogin } from "../utility/request";
//import axios from 'axios'

const Login = (props) => {
  const dispatch = useDispatch();
  
  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  const history = useHistory();

  let handleSubmit = (event) => {
    event.preventDefault();
    // console.log("HELLO?");
    console.log(login);
   dispatch(login({
     email: email,
     password: password,
   }));

  const data = JSON.stringify({
    "email": email,
    "password": password,
    });

    postLogin(data).then((res) =>{
      console.log(res)
      history.push("/profile");
    });
  };

  return (
    <div>
      <Navbar />
      <div className="login-main">
        <form className="login-form" onSubmit={handleSubmit}>
          <input
            type="email"
            placeholder="Email"
            name="email"
            id="email"
            onChange={(event) => setEmail(event.target.value)}
            required
          ></input>
          <input
            type="password"
            placeholder="Password"
            name="password"
            id="password"
            onChange={(event) => setPassword(event.target.value)}
            required
          ></input>
          <button type="submit" className="enter-button">
            Login
          </button>
          <p>
            Dont' have an account? <Link to="/register">Sign up</Link>
          </p>
        </form>
      </div>
    </div>
  );
};

export default Login;

// const handleSubmit = (event) => {
  //   event.preventDefault()
  //   const data = JSON.stringify({
  //       "email": email,
  //       "password": password
  //   });
  //   const baseUrl = 'http://localhost:8080';

  //   const config = {
  //       method: 'post',
  //       url: baseUrl + '/backend/api/login',
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
