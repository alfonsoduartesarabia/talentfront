import './App.css';

// You can choose your kind of history here (e.g. browserHistory)
import {Route, Router, Switch} from 'react-router-dom';
import history from './utils/history';
import React from "react";
import {Austin} from "./pages/Austin";
import AboutBattulga from './pages/Battulga'
import AboutAlfonso from './pages/Alfonso'
import About from './pages/About'
import {AboutEzra} from "./pages/Ezra";

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
          <Route exact path='/about/ezra/'>
            <AboutEzra/>
          </Route>
          <Route exact path='/about/alfonso/'>
            <AboutAlfonso/>
          </Route>
        </Switch>
      </Router>
  )
}
