import React from "react";
import "./App.sass";
import "bootstrap/dist/css/bootstrap.min.css";
import "tailwindcss/tailwind.css";
import Registration from "./screens/registration";
import Login from "./screens/login";
import PostingsScreen from "./screens/postings/postings";
import SearchBar from "./components/searchbar";
import { CookiesProvider } from "react-cookie";
import { BrowserRouter as Router, Route } from "react-router-dom";
import ProfileScreenV2 from "./screens/profile/profile.v2.js";
import ProfileScreen from "./screens/profile/profile.js";
import EntriesScreen from "./screens/entries/entries";

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
            <ProfileScreenV2 />
          </Route>

          <Route path="/profile/:id">
            <ProfileScreenV2 />
          </Route>
          <Route path="/postings">
            <PostingsScreen />
          </Route>
          <Route path="/entries">
            <EntriesScreen />
          </Route>
          <Route path="/" exact>
            <ProfileScreenV2 />
            <SearchBar />
          </Route>
        </Router>
      </div>
    </CookiesProvider>
  );
}

export default App;
