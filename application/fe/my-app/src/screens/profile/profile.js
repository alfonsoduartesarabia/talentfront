import React, { useState, useEffect } from "react";
import "./profile.scss";
import axios from "axios";
import { Spinner } from "react-bootstrap";
import { Button } from "react-bootstrap";
import { Form, Row, Col, Card, Fade } from "react-bootstrap";
import Navbar from "../../components/navbar";
import { useParams } from "react-router-dom";
import { getProfile, getMyProfile } from "../../utility/request";
import { useDispatch } from "react-redux";
import { getUser } from "../../utility/slices/user";
import Cookies from "universal-cookie";

const cookies = new Cookies();

const ProfileScreen = (props) => {
  const BASE_URL = "http://localhost:8080";
  const dispatch = useDispatch();
  let id = useParams().id;
  const [user, setUser] = useState({});
  const [editMode, setEditMode] = useState(false);
  const [loading, setLoading] = useState(true);
  const handleEditModeChange = () => {
    setEditMode(!editMode);
  };
  if (id === undefined) id = "";

  useEffect(() => {
    console.log("ID=", id);
    console.log(dispatch(getUser()));
  }, [dispatch]);

  // useEffect(() => {
  //   console.log("id=", id);
  //   if (id === "") {
  //     getMyProfile().then((res) => {
  //       console.log("getProfile RESPONSE", res);
  //       if (res !== "err") setLoading(false);
  //       setUser(res.data);
  //     });
  //   } else {
  //     getProfile(id).then((res) => {
  //       console.log("getProfile RESPONSE", res);
  //       if (res !== "err") setLoading(false);
  //       setUser(res.data);
  //     });
  //   }
  // }, []);

  let articlesResult = "";
  if (user?.experiences)
    articlesResult = user.experiences.map((experience, index) => {
      if (!editMode) {
        return (
          <Card key={index} className="article">
            <Card.Header className="card-head">
              <div className="article-head">
                <h2 className="article-title">{experience.title}</h2>
                {experience.endDt === "null" ? (
                  <h2 className="article-date">
                    {experience.startDt + " to present"}
                  </h2>
                ) : (
                  <h2 className="article-date">
                    {experience.startDt + " - " + experience.endDt}
                  </h2>
                )}
              </div>
            </Card.Header>
            <Card.Body>
              {/*<Card.Text>{experience.description}</Card.Text>*/}
            </Card.Body>
          </Card>
        );
      }
      return (
        <Card key={index} className="article">
          <Card.Header className="card-head">
            <div className="article-head">
              <h2 className="article-title">
                <Form.Control
                  placeholder="Degree"
                  defaultValue={experience.title}
                />
              </h2>
              <h2 className="article-date">
                <input
                  type="date"
                  id="grad-date"
                  classname="date-select"
                ></input>{" "}
                -{" "}
                <input
                  type="date"
                  id="grad-date"
                  classname="date-select"
                ></input>
              </h2>
            </div>
          </Card.Header>
          <Card.Body>
            <Card.Text>
              <Form.Control
                as="textarea"
                defaultValue={experience.description}
                rows={10}
              />
            </Card.Text>
          </Card.Body>
        </Card>
      );
    });

  const handleImageSelect = (event) => {
    // setSelectedFile(event.target.files[0]);
    console.log(event.target.files[0]);
    handleSubmit(event.target.files[0]);
  };

  const handleSubmit = (file) => {
    // const BASE_URL = window.origin
    //event.preventDefault()
    const BASE_URL = window.origin;
    const form = document.querySelector("form");
    const formData = new FormData(form);
    formData.append("image", file);
    formData.append("userId", "USER EZRA");
    console.log(file);
    axios
      .post(
        BASE_URL + "/backend/api/user-image/upload/" + user.userID,
        formData,
        {
          "Content-Type": "Multipart-FormData",
        }
      )
      .then((res) => {
        console.log("RECEIVED IMAGE URL", res.config.url);
        // setImageUrl(BASE_URL + "/backend/api/user-image/" + user.userID)
      })
      .catch((err) => {
        console.log(err);
      });
  };

  function PersonalInfo() {
    var result;

    if (!editMode) {
      result = (
        <div>
          {
            // imageUrl === ""
            //   ? <img src={deafaultPic} alt="profile picture"/>
            //   : <img src={} alt="profile picture"/>
          }
          <img
            className="profile-Image-Bruh"
            src={
              BASE_URL +
              "/backend/api/user-image/" +
              id +
              `?cookie=${cookies.get("talentfront-session")}`
            }
            alt="profile"
          />

          <Card className="profile-card">
            <Card.Body>
              <Card.Title>{user.firstName + " " + user.lastName}</Card.Title>
              <Card.Subtitle className="mb-2 text-muted">
                {user.companyName}
              </Card.Subtitle>
              <Card.Title>{user.degree}</Card.Title>
              <Card className="skills-card">
                <Card.Title style={{ padding: "2%" }}>Skills:</Card.Title>
                <div style={{ padding: "2%" }}>
                  <ul>
                    {user?.skills?.map((skill, index) => {
                      return <li key={index}>{skill}</li>;
                    })}
                  </ul>
                </div>
              </Card>
              <Card.Link href="#" onClick={handleEditModeChange}>
                Edit Profile
              </Card.Link>
            </Card.Body>
          </Card>
        </div>
      );
    } else {
      result = (
        <Fade in={editMode}>
          <div className="personal-info-edit">
            <img
              src={
                BASE_URL +
                "/backend/api/user-image/" +
                `?cookie=${cookies.get("talentfront-session")}`
              }
              alt="profile"
            />
            <Form style={{ padding: "2%" }}>
              <Form.File
                id="custom-file"
                label="upload image"
                onChange={handleImageSelect}
                custom
              />
            </Form>
            <Card className="profile-card">
              <Card.Body>
                <Card.Title>{user.userType}</Card.Title>
                <Card.Subtitle className="mb-2 text-muted">
                  {user.firstname + " " + user.lastname}
                </Card.Subtitle>
                <Card.Title>
                  <Form.Control
                    defaultValue={user.degree}
                    placeholder="Degree"
                  />
                </Card.Title>
                <Card.Subtitle className="mb-2 text-muted">
                  <div className="grad-date-container">
                    <div>Graduates:</div>
                  </div>
                </Card.Subtitle>
                <Card className="skills-card">
                  <Card.Title style={{ padding: "2%" }}>Skills:</Card.Title>
                  <Card.Text style={{ padding: "2%" }}>
                    <Form.Control
                      defaultValue={user.skills}
                      as="textarea"
                      rows={10}
                      className="description-box"
                    />
                  </Card.Text>
                </Card>
              </Card.Body>
            </Card>
          </div>
        </Fade>
      );
    }

    return result;
  }

  function RenderArticles() {
    var result;
    if (editMode) {
      result = (
        <div>
          <EditMenu />
          {articlesResult}
        </div>
      );
    } else {
      result = <div>{articlesResult}</div>;
    }
    return result;
  }

  function EditMenu() {
    return (
      <div className="edit-menu">
        <Form className="account-edit">
          <Card.Header className="account-head">Account Info</Card.Header>
          <Row>
            <Col>
              <Form.Group controlId="formBasicEmail">
                <Form.Label>Email address</Form.Label>
                <Form.Control
                  defaultValue={user.email}
                  type="email"
                  placeholder="Enter email"
                />
                <Form.Text className="text-muted">
                  We'll never share your email with anyone else.
                </Form.Text>
              </Form.Group>
              <Row>
                <Col>
                  <Form.Control
                    defaultValue={user.firstname}
                    placeholder="First name"
                  />
                </Col>
                <Col>
                  <Form.Control
                    defaultValue={user.lastname}
                    placeholder="Last name"
                  />
                </Col>
              </Row>

              <Form.Group controlId="formBasicPassword">
                <Form.Label>New Password</Form.Label>
                <Form.Control type="password" placeholder="Password" />
              </Form.Group>
              <Form.Group controlId="formBasicPassword">
                <Form.Label>Confirm Password</Form.Label>
                <Form.Control type="password" placeholder="Password" />
              </Form.Group>
            </Col>
            <Col>
              <Form.Group controlId="exampleForm.ControlTextarea1">
                <Form.Label>About Me</Form.Label>
                <Form.Control
                  defaultValue={user.about}
                  as="textarea"
                  rows={10}
                  className="description-box"
                />
              </Form.Group>
            </Col>
          </Row>
          <div className="save-changes-buttons">
            <Button
              variant="primary"
              type="button"
              className="save-changes-button"
              onClick={handleEditModeChange}
            >
              Save
            </Button>
            <Button
              type="button"
              className="save-changes-button"
              onClick={handleEditModeChange}
            >
              Don't Save
            </Button>
          </div>
        </Form>
      </div>
    );
  }

  if (loading) {
    return (
      <div className="spin-wrapper">
        <Spinner animation="border" variant="primary" />
      </div>
    );
  }

  return (
    <div>
      <Navbar />
      <section>
        <div className="personals">
          <PersonalInfo />
        </div>
        <div>
          <RenderArticles />
        </div>
      </section>
    </div>
  );
};

export default ProfileScreen;
