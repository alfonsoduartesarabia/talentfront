import React, { useState, useEffect } from "react";
import "./profile.scss";
import axios from "axios";
import { Spinner } from "react-bootstrap";
import { Button } from "react-bootstrap";
import {
  Form,
  Row,
  Col,
  Card,
  Fade,
  Modal,
  ListGroup,
  FormControl,
} from "react-bootstrap";
import Navbar from "../../components/navbar";
import { useParams } from "react-router-dom";
import { getProfile, postJobUser } from "../../utility/request";
import Cookies from "universal-cookie";
import { RiDeleteBin5Fill } from "react-icons/ri";
import { BsFilePlus } from "react-icons/bs";
import { BiPencil } from "react-icons/bi";
import { FaCheck } from "react-icons/fa";
import { useDispatch, useSelector } from "react-redux";
import { getUser, addJob, updateEducation } from "../../utility/slices/user";

const cookies = new Cookies();
const BASE_URL = "http://localhost";

const AddNewExperience = (props) => {
  const dispatch = useDispatch();
  const { show, handleClose } = props;
  const [company, setCompany] = useState("");
  const [title, setTitle] = useState("");
  const [dateStart, setStartDate] = useState();
  const [dateEnd, setEndDate] = useState(null);
  const [description, setDescription] = useState("");
  const [isStillWorking, setIsStillWorking] = useState(false);
  const [loading, setLoading] = useState(false);

  const handleSave = () => {
    setLoading(true);
    let job = {
      title,
      company,
      dateStart,
      dateEnd,
      description,
    };
    dispatch(addJob(job));
  };

  return (
    <Modal
      backdrop="static"
      keyboard={false}
      show={show}
      onHide={handleClose}
      size="lg"
      centered
    >
      <Modal.Header closeButton>
        <Modal.Title>New Job Experience</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form>
          <Form.Row>
            <Form.Group as={Col}>
              <Form.Label>Job title</Form.Label>
              <Form.Control
                onChange={(event) => setTitle(event.target.value)}
                placeholder="Enter job title"
              />
            </Form.Group>
            <Form.Group as={Col}>
              <Form.Label>Company Name</Form.Label>
              <Form.Control
                onChange={(event) => setCompany(event.target.value)}
                placeholder="Enter company name"
              />
            </Form.Group>
          </Form.Row>
          <Form.Row>
            <Form.Group as={Col}>
              <Form.Label>Started Date</Form.Label>
              <Form.Control
                type="month"
                name="started date"
                placeholder="Start Date"
                onChange={(event) => setStartDate(event.target.value)}
              />
            </Form.Group>
            <Form.Group as={Col}>
              <Row>
                <Col>
                  <Form.Label>End Date</Form.Label>
                </Col>
                <Col>
                  <Form.Check
                    className="float-right"
                    type="checkbox"
                    id="default-checkbox"
                    label="Current"
                    onChange={(event) => {
                      setIsStillWorking(!isStillWorking);
                    }}
                  />
                </Col>
                {/*<Col>
                  <Switch
                    checked={isStillWorking}
                    onChange={setIsStillWorking}
                    className={`${
                      isStillWorking ? "bg-blue-600" : "bg-gray-200"
                    } relative inline-flex items-center h-6 rounded-full w-11`}
                  >
                    <span className="sr-only">Enable notifications</span>
                    <span
                      className={`${
                        isStillWorking ? "translate-x-6" : "translate-x-1"
                      } inline-block w-4 h-4 transform bg-white rounded-full`}
                    />
                  </Switch>
                </Col>*/}
              </Row>
              <Form.Control
                type="month"
                name="ended date"
                placeholder="End Date"
                disabled={isStillWorking}
                onChange={(event) => setEndDate(event.target.value)}
              />
            </Form.Group>
          </Form.Row>
          <Form.Group>
            <Form.Label>Description</Form.Label>
            <Form.Control
              onChange={(event) => setDescription(event.target.value)}
              as="textarea"
              rows={4}
            />
          </Form.Group>
        </Form>
      </Modal.Body>
      <Modal.Footer>
        {loading ? <Spinner animation="border" variant="primary" /> : null}
        <Button variant="secondary" onClick={handleClose}>
          Close
        </Button>
        <Button variant="primary" onClick={handleSave}>
          Save Changes
        </Button>
      </Modal.Footer>
    </Modal>
  );
};

const LeftSection = (props) => {
  const dispatch = useDispatch();
  let user = useSelector((state) => state.user);
  const { imageLink, addSkill } = props;
  const [newSkill, setNewSkill] = useState("");
  const [skills, setSkills] = useState(user.skills);
  const [isEditing, setIsEditing] = useState(false);
  const [school, setSchool] = useState("");
  const [degree, setDegree] = useState("");
  const [major, setMajor] = useState("");

  useEffect(() => {
    if (user.educations && user.educations.length) {
      setSchool(user.educations[0].school);
      setDegree(user.educations[0].degree);
      setMajor(user.educations[0].major);
    }
  }, [user]);
  const handleNewSkill = () => {
    addSkill(newSkill);
    setSkills((skills) => [...skills, newSkill]);
    setNewSkill("");
  };
  const handleRemoveSkill = (index) => {
    setSkills((skills) => skills.filter((skill, idx) => index !== idx));
  };
  const toggleEdit = () => {
    if (isEditing) {
      dispatch(updateEducation({ school, degree, major }));
    }
    setIsEditing(!isEditing);
  };

  return (
    <div className="personals">
      <Card className="profile-details">
        <div className="edit-profile">
          {isEditing ? (
            <FaCheck onClick={toggleEdit} />
          ) : (
            <BiPencil onClick={toggleEdit} />
          )}
        </div>
        <img className="profile-image" src={imageLink} alt="profile" />
        <div className="profile-name">
          {user.firstName + " " + user.lastName}
        </div>
        <div className="education">
          {isEditing ? (
            <Form>
              <Form.Group>
                <FormControl
                  as="select"
                  onChange={(event) => setDegree(event.target.value)}
                  value={degree}
                >
                  <option label="Associate in Arts">AA</option>
                  <option label="Bachelor of Arts">BA</option>
                  <option label="Bachelor of Science">BS</option>
                  <option label="Masters">MA</option>
                  <option label="Master of Business Administration">MBA</option>
                  <option label="Doctorate">D</option>
                </FormControl>
              </Form.Group>
              <Form.Group>
                <FormControl
                  aria-label="Small"
                  aria-describedby="inputGroup-sizing-sm"
                  placeholder="School"
                  onChange={(event) => setSchool(event.target.value)}
                  value={school}
                />
              </Form.Group>
              <Form.Group>
                <FormControl
                  aria-label="Small"
                  aria-describedby="inputGroup-sizing-sm"
                  placeholder="Major"
                  onChange={(event) => setMajor(event.target.value)}
                  value={major}
                />
              </Form.Group>
            </Form>
          ) : (
            <>
              <div className="text-muted">
                {degree !== "" ? degree : "Degree - Not Available"}
              </div>
              <div className="text-muted">
                {school ? school : "School - Not Available"}
              </div>
              <div className="text-muted">
                {major ? major : "Major - Not Available"}
              </div>
            </>
          )}
        </div>
      </Card>
      <Card>
        <Card.Header>Skills</Card.Header>
        <ListGroup variant="flush">
          <ListGroup.Item className="individual-skill">
            Java <RiDeleteBin5Fill style={{ color: "#dc3545" }} />
          </ListGroup.Item>
          <ListGroup.Item className="individual-skill">
            JavaScript
            <RiDeleteBin5Fill style={{ color: "#dc3545" }} />
          </ListGroup.Item>
          <ListGroup.Item className="individual-skill">
            Googling
            <RiDeleteBin5Fill style={{ color: "#dc3545" }} />
          </ListGroup.Item>
          {skills?.map((skill, index) => {
            return (
              <ListGroup.Item className="individual-skill" key={index}>
                {skill}
                <RiDeleteBin5Fill
                  onClick={() => handleRemoveSkill(index)}
                  style={{ color: "#dc3545" }}
                />
              </ListGroup.Item>
            );
          })}
          <ListGroup.Item className="add-skill">
            <FormControl
              aria-label="Small"
              aria-describedby="inputGroup-sizing-sm"
              onChange={(event) => setNewSkill(event.target.value)}
              value={newSkill}
            />
            <Button variant="outline-primary" onClick={handleNewSkill}>
              Add Skill
            </Button>
          </ListGroup.Item>
        </ListGroup>
      </Card>
    </div>
  );
};

const RightSection = (props) => {
  const { handleShow } = props;
  let experiences = useSelector((state) => state.user.experiences);
  if (experiences === undefined) experiences = [];
  const RenderedExperiences = experiences.map((experience, index) => {
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
          <Card.Text>{experience.description}</Card.Text>
        </Card.Body>
      </Card>
    );
  });
  return (
    <div className="right-section">
      {RenderedExperiences.length ? RenderedExperiences : null}
      <div className="add-experience" onClick={handleShow}>
        <div>Add Experience</div> <BsFilePlus />
      </div>
    </div>
  );
};

const ProfileScreen = (props) => {
  let id = useParams().id;
  if (id === undefined) id = "";
  const dispatch = useDispatch();
  const [editMode, setEditMode] = useState(false);
  const [loading, setLoading] = useState(true);
  const [show, setShow] = useState(false);
  const user = useSelector((state) => state.user);
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  useEffect(() => {
    if (id === "") {
      dispatch(getUser());
    } else {
      dispatch(getProfile(id));
    }
  }, [dispatch, id]);

  const addSkill = (skill) => {
    user.skills.push(skill);
  };

  let imageLink =
    `${BASE_URL}/backend/api/user-image/${id}` +
    `?cookie=${cookies.get("talentfront-session")}`;
  if (editMode)
    imageLink =
      BASE_URL +
      "/backend/api/user-image/" +
      `?cookie=${cookies.get("talentfront-session")}`;

  // useEffect(() => {
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

  const handleSubmit = (file) => {
    const BASE_URL = window.origin;
    const form = document.querySelector("form");
    const formData = new FormData(form);
    formData.append("image", file);
    formData.append("userId", "USER EZRA");
    console.log(file);
    axios
      .post(BASE_URL + "/backend/api/user-image/upload", formData, {
        "Content-Type": "Multipart-FormData",
      })
      .then((res) => {
        console.log("RECEIVED IMAGE URL", res.config.url);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  const PersonalInfo = () => {
    var result;
    if (!editMode) {
      result = (
        <div>
          <Card className="profile-details">
            <img className="profile-image" src={imageLink} alt="profile" />
            <div className="profile-name">
              {user.firstName + " " + user.lastName}
            </div>
            <div>{user.degree ? user.degree : "Degree"}</div>
            <div>{user.school ? user.school : "School"}</div>
            <div>{user.company ? user.company : "Company"}</div>
          </Card>

          <Card className="profile-card">
            <Card.Body>
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
              <Card.Link href="#" onClick={() => setEditMode(!editMode)}>
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
            <img className="profile-Image-Bruh" src={imageLink} alt="profile" />
            <Form className="profile-image-upload" style={{ padding: "2%" }}>
              <Form.File
                id="custom-file"
                label="upload image"
                onChange={(event) => handleSubmit(event.target.files[0])}
                custom
              />
            </Form>
            <Card className="profile-card">
              <Card.Body>
                <Card.Title>{user.firstName + " " + user.lastName}</Card.Title>
                <Card.Title>
                  <Form.Label>Degree</Form.Label>
                  <Form.Control as="select" custom>
                    <option>Associate in Arts</option>
                    <option>Bachelor of Arts</option>
                    <option>Bachelor of Science</option>
                    <option>Masters</option>
                    <option>Masters of Business Administration</option>
                    <option>Doctorate</option>
                  </Form.Control>
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
  };
  const RenderArticles = () => {
    var result;
    if (editMode) {
      result = (
        <div className="profile-right-side">
          <EditMenu />
          {articlesResult}
        </div>
      );
    } else {
      result = (
        <div className="profile-right-side">
          <Button variant="primary" onClick={handleShow}>
            Add new job
          </Button>
          {articlesResult}
        </div>
      );
    }
    return result;
  };
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
              <Card.Text>{experience.description}</Card.Text>
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
              onClick={() => setEditMode(!editMode)}
            >
              Save
            </Button>
            <Button
              type="button"
              className="save-changes-button"
              onClick={() => setEditMode(!editMode)}
            >
              Don't Save
            </Button>
          </div>
        </Form>
      </div>
    );
  }

  return (
    <div>
      <AddNewExperience show={show} handleClose={handleClose} />
      <Navbar />
      <div className="profile-screen-contanier">
        <LeftSection user={user} imageLink={imageLink} addSkill={addSkill} />
        <RightSection handleShow={handleShow} />
      </div>
    </div>
  );
};

export default ProfileScreen;
