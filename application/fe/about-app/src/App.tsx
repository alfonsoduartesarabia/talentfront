import './App.css';

// You can choose your kind of history here (e.g. browserHistory)
import {Route, Router, Switch, Link} from 'react-router-dom';
import history from './utils/history';
import React from "react";
import {Austin} from "./pages/Austin";
import AboutBattulga from './pages/Battulga'

export default function App() {
  return (
      <Router history={history}>
        <Switch>
          <Route exact path='/about/'>
            <About/>
          </Route>
          <Route exact path='/about/austin/'>
            <Austin/>
          </Route>
          <Route exact path='/about/tulga/'>
            <AboutBattulga/>
          </Route>
        </Switch>
      </Router>
  )
}

function About() {
  return (
      <div className='App'>
        <div className='App-text'>
          <h1>Software Engineering Class SFSU</h1>
          <h3>Spring 2021</h3>
          <h3>Section 02</h3>
          <h3>Team 5</h3>
          <p>
            About page for Team 5.
          </p>
          <Link to='/about/austin/'>Austin Wimberley</Link>
          <Link to='/about/tulga/'>Battulga Tsogtgerel</Link>
        </div>
      </div>
  );
}
