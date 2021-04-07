// import react from 'react'
import './navbar.sass'
import { BsSearch } from 'react-icons/bs';
import {
  Link
} from "react-router-dom";
import { useSelector } from 'react-redux'

const Navbar = (props) => {

  const loggedIn = useSelector( state => state.user.loggedIn)

  let loginButton = <Link to="/logout"><button className="navbar-btn">Logout</button></Link>
  let username = useSelector( state => state.user.name )
  let userID = useSelector( state => state.user.id )
  if (!loggedIn) { 
    loginButton = <Link to="/login"><button className="navbar-btn">Login</button></Link>
  }

  return (
    <div className="navbar-search">
      <div className="search-bar-wrapper">
        <form action="">
          <div className="search-bar">
            <input type="text" />
            <div className="search-bar-btn"> <BsSearch /> </div>  
          </div>
          <button className="navbar-btn">Search</button>
        </form>
      </div>
      <div>
        {/* CENTER */}
        <Link to={"/USER/" + userID}>{username}</Link>
      </div>
      <div className="navbar-right">
        <Link to="/"><button className="navbar-btn">Home</button></Link> 
        {loginButton}
      </div>
    </div>
  )
}

export default Navbar;