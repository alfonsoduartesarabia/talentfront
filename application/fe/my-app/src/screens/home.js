import React, { useState } from "react";
import "./home.scss";
import axios from "axios";

import LogoImage from "../assets/talent_front_logo.bmp";
import WorkerImage from "../assets/worker-clipart.png";
import ProfessorImage from "../assets/professor.jpg";
import StudentImage from "../assets/student.jpg";
import OfficeImage from "../assets/office.jpg";
import TalkImage from "../assets/talk.jpg";
import ClassroomImage from "../assets/classroom.jpg";
import HiringImage from "../assets/hiring-pipeline.jpg";
import { Link } from "react-router-dom";
import { Button, Jumbotron, Media } from "react-bootstrap";

const SearchSection = () => {
  return (
    <div className="search-container">
      <h1>Find your next internship or fulltime job</h1>
      <p>
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

const JobSection = () => {
  return (
    <div className="job-search-home">
      <Media>
        <Media.Body>
          <img className="mr-3" src={TalkImage} alt="Generic placeholder" />
          <h2>Expand your network</h2>
          <h4>
            Every 2 out of 3 hires are hired through referral. Stay in touch
            with your colleagues and make new connections
          </h4>
        </Media.Body>
      </Media>
      <Media>
        <Media.Body>
          <img
            className="mr-3"
            src={ClassroomImage}
            alt="Generic placeholder"
          />
          <h2>Help your students to succeed</h2>
          <h4>
            Your recommendation is valueable information for employers to figure
            out who's right person for the job
          </h4>
        </Media.Body>
      </Media>
      <Media>
        <Media.Body>
          <img className="mr-3" src={HiringImage} alt="Generic placeholder" />
          <h2>Hire right candidate</h2>
          <h4>We make it easy and fast to hire from our rich pool of talent</h4>
        </Media.Body>
      </Media>
    </div>
  );
};

const HomeScreen = () => {
  return (
    <div className="home-container">
      <IntroSection />
      <SearchSection />
      <JobSection />
    </div>
  );
};

export default HomeScreen;
