import './App.css';

// You can choose your kind of history here (e.g. browserHistory)
import {Route, Router, Switch} from 'react-router-dom';
import history from './utils/history';
import React from "react";
import {Austin} from "./pages/Austin";
import AboutBattulga from './pages/Battulga'
import About from './pages/About'

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
