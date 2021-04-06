import React from 'react';
import './App.sass';
import 'bootstrap/dist/css/bootstrap.min.css';
import HomeScreen from './screens/home'
import Registration from './screens/registration'
import LoginEmployer from './screens/login-employer'
import LoginProfessor from './screens/login-professor'
import LoginTalent from './screens/login-talent'
import LoginMain from './screens/login'
import PostingsScreen from './screens/postings/postings'
import {
  BrowserRouter as Router,
  // Switch,
  Route,
  // Link
} from "react-router-dom";
import ProfileScreen from './screens/profile/profile.js'

function App() {
  return (
    <div className="App">
    <Router>
      <Route path="/register">
        <Registration/>  
      </Route>
      <Route path="/login">
        {
          /* Conditionally render here
            or have a main login screen and render coditionally
            maybe dropdown would do the work.
            @Alfonso
           */
           <LoginMain />

         }
        {/* <LoginEmployer />
        <LoginProfessor />
        <LoginTalent /> */}
      </Route>

      {/* <Switch>
        <Route path="/login-talent">
          <LoginTalent />
        </Route>
        <Route path="/login-professor">
          <LoginProfessor />
        </Route>
        <Route path="/login-employer">
          <LoginEmployer />
        </Route>
      </Switch> */}


      <Route path="/profile">
        <ProfileScreen />
      </Route>
      <Route path="/postings">
        <PostingsScreen />
      </Route>
      <Route path="/" exact>
        <HomeScreen />
      </Route>
    </Router>
    </div>
  );
}

export default App;
