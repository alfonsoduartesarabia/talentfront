import React from "react";
import "./App.sass";
import "bootstrap/dist/css/bootstrap.min.css";
import "tailwindcss/tailwind.css";
import Registration from "./screens/registration";
import Login from "./screens/login";
import PostingsScreen from "./screens/postings/postings";
import { CookiesProvider } from "react-cookie";
import { BrowserRouter as Router, Route } from "react-router-dom";
import ProfileScreenV2 from "./screens/profile/profile.v2.js";
import EntriesScreen from "./screens/entries/entries";
import Footer from "./components/footer";
import Navbar from "./components/navbar";
import PostingScreen from "./screens/posting/posting";

function App() {
  return (
    <CookiesProvider>
      <div className="App">
        <Router>
          <Navbar />
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

          <Route path="/posting" exact>
            <PostingScreen />
          </Route>

          <Route path="/posting/:id">
            <PostingScreen />
          </Route>

          {/*<Route path="/postings">*/}
          {/*  <PostingsScreen />*/}
          {/*</Route>*/}
          <Route path="/entries">
            <EntriesScreen />
          </Route>
          <Route path="/" exact>
            <EntriesScreen emptySearch={true}/>
          </Route>
        </Router>
        <Footer />
      </div>
    </CookiesProvider>
  );
}

export default App;
