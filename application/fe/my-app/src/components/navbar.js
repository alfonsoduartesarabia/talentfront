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
<<<<<<< HEAD
        {/* CENTER */}
        <Link to="/login">Login</Link>
=======
        <Link to="/postings">JOBS</Link> 
>>>>>>> 41d55b486508ed358ce84bcb7cd17541062510cb
      </div>
      <div>
        <Link to="/profile">PROFILE</Link> 
      </div>
    </div>
  )
}

export default Navbar;