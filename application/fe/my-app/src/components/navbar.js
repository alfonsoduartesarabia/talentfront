import { useState, useEffect } from "react";
import "./navbar.sass";
import { BsSearch } from "react-icons/bs";
import { useHistory } from "react-router-dom";
import { Link } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import { updateQuery } from "../utility/slices/search";
import { logout } from "../utility/slices/user";
import { selectUser, getUser } from "../utility/slices/user";

const Navbar = (props) => {
  let history = useHistory();
  const dispatch = useDispatch();
  const [searchTerm, setSearchTerm] = useState("");
  const user = useSelector((state) => state.user);

  useEffect(() => {
    dispatch(getUser());
  }, [dispatch]);
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

  const handleLogout = (event) => {
    console.log("logging out");
    dispatch(logout());
    history.push("/login");
  };

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
          </div>
          <button onClick={handleClick} className="navbar-btn">
            Search
          </button>
        </form>
      </div>
      <div className="navbar-right">
        {Object.keys(user).length ? (
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
