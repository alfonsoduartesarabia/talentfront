// import { useState } from "react";
import "./searchbar.sass";
import "./searchbar.css";
import { BsSearch } from "react-icons/bs";
import { Link } from "react-router-dom";
// import { Menu, Transition} from "@headlessui/react";
// import { ChevronDownIcon } from "@heroicons/react/solid";
// import { Fragment, useEffect, useRef, useState } from "react";
// import Footer from '../components/footer';

const SearchBar = (props) => {

    return (
        <div id="nav">
        <div className="navbar-search">

          <div className="search-bar-wrapper">
            <form action="" className="">
              <div className="search-bar">
                <input
                //   onChange={(event) => setSearchTerm(event.target.value)}
                  type="text"
                />
                
                <button className="search-btn">
                  <div className="search-logo"><BsSearch />{""}</div>
                </button>
              </div>

              {/* <button  className="navbar-btn">
                Search
              </button> */}

                <div className="searchbar-options-container">
                <label htmlFor="user-type">
                </label>
                    <select
                    defaultValue=""
                    name="search"
                    id="user-type">
                        <option value="">
                            Filter
                        </option>
                        <option value="jobPosting">Job Posting</option> 
                        <option value="talent">Talent</option>
                        <option value="professor">Professor</option>
                        <option value="organization">Organization</option>
                    </select>

                    
            </div> 
            </form>
          </div>
            <div className="navbar-right">
            <Link to="/profile">
            <button className="navbar-btn">Profile</button>
            </Link>
            {/* {loginButton} */}
            <Link to="/login">
            <button className="navbar-btn">Login</button>
            </Link>
            </div>
          </div>

          {/* <Footer/> */}
          </div>
      );
      
      
}

export default SearchBar;