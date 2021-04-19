import { useState } from "react";
import "./navbar.sass";
import { BsSearch } from "react-icons/bs";
import { useHistory } from "react-router-dom";
import { Link } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import { updateQuery } from "../utility/slices/search";
import { logout } from "../utility/slices/user";

const Navbar = (props) => {
  const dispatch = useDispatch();
  let history = useHistory();
  const [searchTerm, setSearchTerm] = useState("");
  const handleClick = (event) => {
    event.preventDefault();
    let query = {
      filter: "",
      subFilter: "",
      searchTerm: searchTerm,
    };
    dispatch(updateQuery(query));
    history.push("/postings");
  };

  // const handleLogOutClick = (event) =>{
  //   // event.preventDefault();
  //     dispatch(logout());
  // }

  const loggedIn = useSelector((state) => state.user.loggedIn);
  // console.log("loggedIn: " + loggedIn);
  let loginButton = (
    <Link to="/logout">
      <button className="navbar-btn" >Logout</button>
    </Link>
  );
  if (!loggedIn) {
    loginButton = (
      <Link to="/login">
        <button className="navbar-btn">Login</button>
      </Link>
    );
  }

  let username = useSelector((state) => state.user.name);
  let userID = useSelector((state) => state.user.id);

  return (
    <div className="navbar-search">
      <div className="search-bar-wrapper">
        <form action="">
          <div className="search-bar">
            <input
              onChange={(event) => setSearchTerm(event.target.value)}
              type="text"
            />
            <div className="search-bar-btn">
              {" "}
              <BsSearch />{" "}
            </div>
          </div>
          <button onClick={handleClick} className="navbar-btn">
            Search
          </button>
        </form>
      </div>
      <div>
        {/* CENTER */}
        <Link to={"/USER/" + userID}>{username}</Link>
      </div>
      <div className="navbar-right">
        <Link to="/profile">
          <button className="navbar-btn">Profile</button>
        </Link>
        {loginButton}
      </div>
    </div>
  );
};

export default Navbar;
