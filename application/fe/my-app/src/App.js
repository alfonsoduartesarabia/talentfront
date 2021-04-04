import React from 'react';
import './App.sass';
import HomeScreen from './screens/home'
import Registration from './screens/registration'
import LoginEmployer from './screens/login-employer'
import LoginProfessor from './screens/login-professor'
import LoginTalent from './screens/login-talent'
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
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
         }
        <LoginEmployer />
        <LoginProfessor />
        <LoginTalent />
      </Route>


      <Route path="/profile">
        <ProfileScreen />
      </Route>

      <Route path="/" exact>
        <HomeScreen />
      </Route>
    </Router>
    </div>
  );
}

export default App;
