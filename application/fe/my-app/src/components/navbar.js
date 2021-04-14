import { useState } from "react";
import "./navbar.sass";
import { BsSearch } from "react-icons/bs";
import { useHistory } from "react-router-dom";
import { Link } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import { updateQuery } from "../utility/slices/search";

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

  const loggedIn = useSelector((state) => state.user.loggedIn);
  let loginButton = (
    <Link to="/logout">
      <button className="navbar-btn">Logout</button>
    </Link>
  );
  let username = useSelector((state) => state.user.name);
  let userID = useSelector((state) => state.user.id);
  if (!loggedIn) {
    loginButton = (
      <Link to="/login">
        <button className="navbar-btn">Login</button>
      </Link>
    );
  }

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
