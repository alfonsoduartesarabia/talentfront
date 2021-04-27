import React, { useState } from "react";
import "./registration.css";
import Navbar from "../components/navbar";
import { Link, useHistory } from "react-router-dom";
import { useDispatch } from "react-redux";
import { setUser, getUser } from "../utility/slices/user";
import { postLogin } from "../utility/request";

const Login = (props) => {
  const dispatch = useDispatch();

  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  const history = useHistory();

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
        history.push("/profile");
      }
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
