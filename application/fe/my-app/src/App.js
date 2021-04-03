import React from 'react';
import './App.css';
import HomeScreen from './screens/home'
import Registration from './screens/registration'
import LoginEmployer from './screens/login-employer'
import LoginProfessor from './screens/login-professor'
import LoginTalent from './screens/login-talent'

function App() {
  return (
    <div className="App">
      {/* <HomeScreen /> */}
      <Registration/>
      {/* < LoginEmployer /> */}
      {/* < LoginProfessor /> */}
      {/* < LoginTalent /> */}
    </div>
  );
}

export default App;
