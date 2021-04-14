import React from "react";
import "./registration.css";
import Navbar from "../components/navbar";
import { Link } from "react-router-dom";
import { useDispatch } from "react-redux";
import { login } from "../utility/slices/user";

const Login = (props) => {
  const dispatch = useDispatch();

  let handleSubmit = (event) => {
    event.preventDefault();
    console.log("HELLO?");
    console.log(login);
    dispatch(login());
  };

  return (
    <div>
      <Navbar />
      <div className="login-main">
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            placeholder="Username"
            name="username"
            id="username"
            required
          ></input>
          <input
            type="password"
            placeholder="Password"
            name="password"
            id="password"
            required
          ></input>
          <button type="submit" class="enter-button">
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
