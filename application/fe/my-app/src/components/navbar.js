import { useState, useEffect } from "react";
import "./navbar.sass";
import { BsSearch } from "react-icons/bs";
import { useHistory } from "react-router-dom";
import { Link } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import { updateQuery } from "../utility/slices/search";
import { logout } from "../utility/slices/user";
import { selectUser, getUser } from "../utility/slices/user";
import {getProfile} from "../utility/request";

const Navbar = (props) => {
  let history = useHistory();
  const dispatch = useDispatch();
  const [searchTerm, setSearchTerm] = useState("");
  const [filter, setFilter] = useState("");
  const currUser = useSelector((state) => state.user);
  const [user, setUser] = useState(currUser);

  useEffect(() => {
    getProfile("").then(res => {
      setUser(res?.data);
    })
  }, []);

  const handleSearch = (event) => {
    event.preventDefault();
    const query = {
      filter: filter,
      subFilter: "",
      searchTerm: searchTerm,
    };
    console.log(query);
    console.log("calling dispatch");
    dispatch(updateQuery(query));
    history.push("/entries");
  };

  const handleLogout = (event) => {
    console.log("logging out");
    dispatch(logout());
    history.push("/login");
    window.location.reload(false);
  };

  // @TODO FIX THESE - LOGOUT button not redirecting but it is loggin out user
  let loginButton = (
    <div>
      {user ? (
        <Link to="/login">
          <button className="navbar-btn" onClick={(e) => handleLogout(e)}>
            Logout
          </button>
        </Link>
      ) : (
        <Link to="/login">
          <button className="navbar-btn">Login</button>
        </Link>
      )}
    </div>
  );

  // let loginButton = (
  //   <Link to="/logout">
  //     <button className="navbar-btn" >Logout</button>
  //   </Link>
  // );
  // if (!loggedIn) {
  //   loginButton = (
  //     <Link to="/login">
  //       <button className="navbar-btn">Login</button>
  //     </Link>
  //   );
  // }

  // let loginButton = null
  // if (!loggedIn) {
  //   loginButton = (
  //     <Link to="/login">
  //       <button className="navbar-btn">Login</button>
  //     </Link>
  //   );
  // }
  // else if(loggedIn){
  //   loginButton = (
  //     <Link to="/">
  //       <button className="navbar-btn" >Logout</button>
  //     </Link>
  //   );
  // }

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
              <BsSearch />
            </div>
            <select className="filter" onChange={(event) => setFilter(event.target.value)}>
              <option value="">Any</option>
              <option value="talent">Talent</option>
              <option value="professor">Professor</option>
              <option value="jobPosting">Jobs</option>
            </select>
            </div>
          <button onClick={handleSearch} className="navbar-btn">
            Search
          </button>
        </form>
      </div>
      <div className="navbar-right">
        {Object.keys(user).length && user?.firstName ? (
          <>
            <Link to="/profile">
              <button className="navbar-btn">{user.firstName}</button>
            </Link>
            <button className="navbar-btn" onClick={handleLogout}>
              Logout
            </button>
          </>
        ) : (
          <Link to="/login">
            <button className="navbar-btn">Login</button>
          </Link>
        )}
      </div>
    </div>
  );
};

export default Navbar;
