import React from "react";
import "./App.sass";
import "bootstrap/dist/css/bootstrap.min.css";
import Registration from "./screens/registration";
import Login from "./screens/login";
import PostingsScreen from "./screens/postings/postings";
import SearchBar from "./components/searchbar";
import { CookiesProvider } from "react-cookie";
import { BrowserRouter as Router, Route } from "react-router-dom";
import ProfileScreen from "./screens/profile/profile.js";

function App() {
  return (
    <CookiesProvider>
      <div className="App">
        <Router>
          <Route path="/register">
            <Registration />
          </Route>
          <Route path="/login">
            <Login />
          </Route>

          <Route path="/profile" exact>
            <ProfileScreen />
          </Route>

          <Route path="/profile/:id">
            <ProfileScreen />
          </Route>
          <Route path="/postings">
            <PostingsScreen />
          </Route>
          <Route path="/" exact>
            {/* <ProfileScreen /> */}
            {/* < Home /> */}
            <SearchBar />
          </Route>
        </Router>
      </div>
    </CookiesProvider>
  );
}

export default App;
