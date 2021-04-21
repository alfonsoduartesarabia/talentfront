import React from "react";
import "./App.sass";
import "bootstrap/dist/css/bootstrap.min.css";
import Registration from "./screens/registration";
import Login from "./screens/login";
import PostingsScreen from "./screens/postings/postings";
import { CookiesProvider } from "react-cookie";
import { BrowserRouter as Router, Route } from "react-router-dom";
import ProfileScreen from "./screens/profile/profile.js";
import ProfileScreenV2 from "./screens/profile/profile.v2.js";

function App() {
  return (
    <CookiesProvider>
      <div className="App">
        <Router>
          <Route path="/register">
            <Registration />
          </Route>
          <Route path="/login">
            {
              /* Conditionally render here
            or have a main login screen and render coditionally
            maybe dropdown would do the work.
            @Alfonso
           */
              <Login />
            }
            {/* <LoginEmployer />
        <LoginProfessor />
        <LoginTalent /> */}
          </Route>

          <Route path="/profile" exact>
            <ProfileScreenV2 />
          </Route>

          <Route path="/profile/:id">
            <ProfileScreenV2 />
          </Route>
          <Route path="/postings">
            <PostingsScreen />
          </Route>
          <Route path="/" exact>
            <ProfileScreenV2 />
          </Route>
        </Router>
      </div>
    </CookiesProvider>
  );
}

export default App;
