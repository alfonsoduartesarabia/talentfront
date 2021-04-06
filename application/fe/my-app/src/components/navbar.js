// import react from 'react'
import './navbar.sass'

import {
  Link
} from "react-router-dom";

const Navbar = (props) => {
  return (
    <div className="navbar">
      <div>
        <input type="text" />
      </div>
      <div>
        {/* CENTER */}
        <Link to="/login">Login</Link>

        <Link to="/postings">JOBS</Link> 
      </div>
      <div>
        <Link to="/profile">PROFILE</Link> 
      </div>
    </div>
  )
}

export default Navbar;