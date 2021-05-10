import React, { useState } from "react";
import "./registration.css";
import { Link } from "react-router-dom";
import { postLogin } from "../utility/request";

const Login = (props) => {

  const [email, setEmail] = useState();
  const [password, setPassword] = useState();

  const handleSubmit = (event) => {
    event.preventDefault();
    const data = JSON.stringify({
      email: email,
      password: password,
    });

    postLogin(data).then((res) => {
      if (res === undefined) {
        console.log("Error when logging in.");
      } else {
        window.location.assign("/profile");
      }
    });
  };
  return (
    <div>
      <div className="login-main">
        <form className="login-form" onSubmit={handleSubmit}>
          <input
            type="email"
            placeholder="Email"
            name="email"
            id="email"
            onChange={(event) => setEmail(event.target.value)}
            required
          />
          <input
            type="password"
            placeholder="Password"
            name="password"
            id="password"
            onChange={(event) => setPassword(event.target.value)}
            required
          />
          <button type="submit" className="enter-button">
            Login
          </button>
          <p>
            Don't have an account? <Link to="/register">Sign up</Link>
          </p>
        </form>
      </div>
    </div>
  );
};

export default Login;
