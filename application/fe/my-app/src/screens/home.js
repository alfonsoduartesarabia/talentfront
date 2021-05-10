import React, { useState } from "react";
import "./home.scss";
import axios from "axios";

import LogoImage from "../assets/talent_front_logo.bmp";
import WorkerImage from "../assets/worker-clipart.png";
import ProfessorImage from "../assets/professor.jpg";
import StudentImage from "../assets/student.jpg";
import OfficeImage from "../assets/office.jpg";
import { Link } from "react-router-dom";
import { Button, Jumbotron, Media } from "react-bootstrap";

const SearchSection = () => {
  return (
    <div className="search-container">
      <h1>Find your next internship or fulltime job</h1>
      <p>
        {" "}
        Take your first step into job seeking field with us. We make job seeking
        process easier than anybody else.{" "}
      </p>
      <div className="search-suggestion-list">
        <Link to="/entries">
          <Button variant="light"> Software Engineer </Button>
        </Link>
        <Link to="/entries">
          <Button variant="light"> Product Manager </Button>
        </Link>
        <Link to="/entries">
          <Button variant="light"> UI/UX Designer </Button>
        </Link>
        <Link to="/entries">
          <Button variant="light"> Shift Manager </Button>
        </Link>
      </div>
      <div className="search-suggestion-list">
        <Link to="/entries">
          <Button variant="light"> Engineering Specialist </Button>
        </Link>
        <Link to="/entries">
          <Button variant="light"> Manufacturing Technician </Button>
        </Link>
        <Link to="/entries">
          <Button variant="light"> Shift Supervisor </Button>
        </Link>
      </div>
    </div>
  );
};

const IntroSection = () => {
  return (
    <div className="landing-info-wrapper">
      <Jumbotron>
        <h1>Welcome to Talent Front!</h1>
        <p>
          Talent Front is San Francisco State University's students, alumnis and
          professors' professional networking space. Here you will be able to
          alumnis and connect other students. Professors we didn't forget about
          you! Professors will be able to recommend students for a job!
        </p>
        <Media>
          <img
            className="align-self-start mr-3"
            src={StudentImage}
            width={80}
            height={80}
          />
          <Media.Body>
            <h4>Connect with thousands other students</h4>
          </Media.Body>
        </Media>
        <Media>
          <img
            className="align-self-start mr-3"
            src={OfficeImage}
            width={80}
            height={80}
          />
          <Media.Body>
            <h4>Network with alumnis</h4>
          </Media.Body>
        </Media>
        <Media>
          <img
            className="align-self-start mr-3"
            src={ProfessorImage}
            width={80}
            height={80}
          />
          <Media.Body>
            <h4>Get recommendations from professors</h4>
          </Media.Body>
        </Media>
      </Jumbotron>
      <img src={WorkerImage} />
    </div>
  );
};

const HomeScreen = () => {
  return (
    <div className="home-container">
      <IntroSection />
      <SearchSection />
    </div>
  );
};

export default HomeScreen;
