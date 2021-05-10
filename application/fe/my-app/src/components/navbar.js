import React, { useState, useEffect } from "react";
import "./navbar.sass";
import { BsSearch } from "react-icons/bs";
import { useHistory } from "react-router-dom";
import { Link } from "react-router-dom";
import { useDispatch } from "react-redux";
import { updateQuery } from "../utility/slices/search";
import { logout } from "../utility/slices/user";
import { getProfile } from "../utility/request";
import { Modal } from "react-bootstrap";
import LogoImage from "../assets/talent_front_logo.bmp";

export const ShowMessage = (props) => {
    const { showMessage, handleClose, user } = props;

    const handleLink = (page) => {
        window.location.assign(page);
    };

    const RenderMessage = () =>
        user?.notifications?.map((message, index) => {
            return (
                <div className="individual-skill" key={index}>
                    <h4>{message?.applyName} has applied to your posting</h4>
                    <h6>You can reach out to him at {message?.email}</h6>
                    <button
                        className="message-button"
                        onClick={() => handleLink(message?.postingLink)}
                    >
                        Posting
                    </button>
                    <button
                        className="message-button"
                        onClick={() => handleLink(message?.profileLink)}
                    >
                        Applicant
                    </button>
                </div>
            );
        });

    return (
        <Modal
            backdrop="static"
            keyboard={false}
            show={showMessage}
            onHide={handleClose}
            size="lg"
            centered
        >
            <Modal.Header closeButton>
                <Modal.Title>
                    <h2>You've received these messages: </h2>
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <RenderMessage></RenderMessage>
            </Modal.Body>
        </Modal>
    );
};

const Navbar = (props) => {
    let history = useHistory();
    const dispatch = useDispatch();
    const [searchTerm, setSearchTerm] = useState("");
    const [filter, setFilter] = useState("");
    const [user, setUser] = useState({});
    const [showMessage, setShowMessage] = useState(false);

    useEffect(() => {
        getProfile("").then((res) => {
            setUser(res?.data);
        });
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

    const handleLogout = () => {
        setUser({});
        dispatch(logout());
        setTimeout(() => {
            window.location.assign("/login");
        }, 500);
    };

    const handleMessage = () => {
        setShowMessage(true);
    };
    const handleClose = () => {
        setShowMessage(false);
    };

    return (
        <div>
            <ShowMessage
                showMessage={showMessage}
                handleClose={handleClose}
                user={user}
            />
            <div className="navbar-search">
                <img src={LogoImage} />
                <div className="search-bar-wrapper">
                    <form action="">
                        <div className="search-bar">
                            <input
                                onChange={(event) =>
                                    setSearchTerm(event.target.value)
                                }
                                type="text"
                            />
                            <div className="search-bar-btn">
                                <BsSearch />
                            </div>
                            <select
                                className="filter"
                                onChange={(event) =>
                                    setFilter(event.target.value)
                                }
                            >
                                <option value="">Any</option>
                                <option value="talent">Talent</option>
                                <option value="professor">Professor</option>
                                <option value="jobPosting">Jobs</option>
                                <option value="organization">
                                    Organizations
                                </option>
                            </select>
                        </div>
                        <button onClick={handleSearch} className="navbar-btn">
                            Search
                        </button>
                    </form>
                </div>
                <div className="navbar-right">
                    {user && Object.keys(user).length && user?.firstName ? (
                        <>
                            <Link to="/profile">
                                <button className="navbar-btn">
                                    {user.firstName}
                                </button>
                            </Link>
                            <button
                                className="navbar-btn"
                                onClick={handleLogout}
                            >
                                Logout
                            </button>
                            {user?.notifications?.length &&
                            user?.notifications?.length !== 0 ? (
                                <button
                                    className="navbar-btn"
                                    onClick={handleMessage}
                                >
                                    Message!
                                </button>
                            ) : (
                                <div />
                            )}
                        </>
                    ) : (
                        <Link to="/login">
                            <button className="navbar-btn">Login</button>
                        </Link>
                    )}
                </div>
            </div>
        </div>
    );
};

export default Navbar;
