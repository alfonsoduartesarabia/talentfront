import React, { useState, useEffect, useReducer } from "react";
import "./profile.scss";
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
import { useParams, useHistory } from "react-router-dom";
import {
  getImageLink,
  getProfile,
  postCompany,
  postReview,
  postUserImage,
} from "../../utility/request";
import { RiDeleteBin5Fill } from "react-icons/ri";
import { BsFilePlus } from "react-icons/bs";
import { BiPencil } from "react-icons/bi";
import { FaCheck } from "react-icons/fa";
import { useDispatch, useSelector } from "react-redux";
import {
  getUser,
  addJob,
  updateEducation,
  updateSkill,
} from "../../utility/slices/user";
import { AddNewPosting } from "../posting/posting";

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
    dispatch(getUser());
    setTimeout(function () {
      window.location.reload(false);
    }, 1000);
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
                onChange={(event) => setStartDate(event.target.value + "-01")}
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
              </Row>
              <Form.Control
                type="month"
                name="ended date"
                placeholder="End Date"
                disabled={isStillWorking}
                onChange={(event) => setEndDate(event.target.value + "-01")}
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

const AddNewReview = (props) => {
  const { show, handleClose, user } = props;
  const [review, setReview] = useState("");
  const [loading, setLoading] = useState(false);
  const [score, setScore] = useState(5);
  const revieweeId = props.id;

  const handleSave = () => {
    setLoading(true);
    let reviewData = {
      revieweeId,
      review,
      score,
    };
    postReview(reviewData).then((res) => console.log(res.data));
    setTimeout(function () {
      window.location.reload(false);
    }, 500);
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
        <Modal.Title>
          New Review for {user.firstName} {user.lastName}
        </Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form>
          <Form.Group>
            <Form.Label>Rate them out of 5</Form.Label>
            <Form.Control
              onChange={(event) => setScore(parseInt(event.target.value))}
              as="select"
            >
              <option>5</option>
              <option>4</option>
              <option>3</option>
              <option>2</option>
              <option>1</option>
            </Form.Control>
          </Form.Group>
        </Form>
        <Form>
          <Form.Group>
            <Form.Label>Review</Form.Label>
            <Form.Control
              onChange={(event) => setReview(event.target.value)}
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

const AddCompanyPage = (props) => {
  const { show, handleClose, user } = props;
  const [companyName, setCompanyName] = useState("");
  const [mission, setMission] = useState("");
  const [product, setProduct] = useState("");
  const [numberEmployees, setNumberEmployees] = useState(0);
  const [locations, setLocations] = useState([]);

  const handleSave = () => {
    let companyData = {
      companyName,
      mission,
      product,
      numberEmployees,
      locations,
    };
    postCompany(companyData).then((res) =>
      window.location.assign(`/company/${res?.data?.companyId}`)
    );
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
        <Modal.Title>Create a New Company Page</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <Form>
          <Form.Row>
            <Form.Group as={Col}>
              <Form.Label>Company Name</Form.Label>
              <Form.Control
                onChange={(event) => setCompanyName(event.target.value)}
                placeholder="Enter Company Name"
              />
            </Form.Group>
            <Form.Group as={Col}>
              <Form.Label>Number of Employees</Form.Label>
              <Form.Control
                onChange={(event) =>
                  setNumberEmployees(parseInt(event.target.value))
                }
                placeholder="Enter Number of Employees"
              />
            </Form.Group>
          </Form.Row>
          <Form.Group>
            <Form.Label>Product</Form.Label>
            <Form.Control
              onChange={(event) => setProduct(event.target.value)}
              as="textarea"
              rows={3}
              placeholder="Describe your Product"
            />
          </Form.Group>
          <Form.Group>
            <Form.Label>Mission</Form.Label>
            <Form.Control
              onChange={(event) => setMission(event.target.value)}
              as="textarea"
              rows={3}
              placeholder="Describe your company's mission"
            />
          </Form.Group>
          <Form.Group>
            <Form.Label>Locations</Form.Label>
            <Form.Control
              onChange={(event) => setLocations(event.target.value.split(","))}
              as="textarea"
              placeholder="Enter Your Company's Locations"
              rows={1}
            />
          </Form.Group>
        </Form>
      </Modal.Body>
      <Modal.Footer>
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
  const { user } = props;
  const { imageLink, setSkill } = props;
  const [newSkill, setNewSkill] = useState("");
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
  const toggleEdit = () => {
    if (isEditing) {
      dispatch(updateEducation({ school, degree, major }));
    }
    setIsEditing(!isEditing);
  };

  const addSkill = (event) => {
    console.log("ADD SKILL UI fired");
    dispatch(
      updateSkill({
        add: [newSkill],
      })
    );
    setNewSkill("");
    dispatch(getUser());
    setTimeout(function () {
      window.location.reload(false);
    }, 500);
  };

  const handleRemoveSkill = (skill) => {
    dispatch(
      updateSkill({
        remove: [skill],
      })
    );
    dispatch(getUser());
    window.location.reload(false);
  };

  const handleImageSubmit = (file) => {
    const form = document.querySelector("form");
    const formData = new FormData(form);
    formData.append("image", file);
    postUserImage(formData);
    setTimeout(function () {
      window.location.reload(false);
    }, 500);
  };

  const RenderedSkills = user.skills?.map((skill, index) => {
    return (
      <ListGroup.Item className="individual-skill" key={index}>
        {skill}
        {isEditing ? (
          <RiDeleteBin5Fill
            onClick={() => handleRemoveSkill(skill)}
            style={{ color: "#dc3545" }}
          />
        ) : null}
      </ListGroup.Item>
    );
  });

  return (
    <div className="personals">
      <Card className="profile-details">
        <div className="edit-profile">
          {props.isUsersPage ? (
            isEditing ? (
              <FaCheck onClick={toggleEdit} />
            ) : (
              <BiPencil onClick={toggleEdit} />
            )
          ) : (
            <div />
          )}
        </div>
        <img className="profile-image" src={imageLink} alt="profile" />
        {props.isUsersPage ? (
          <Form className="profile-image-upload" style={{ padding: "2%" }}>
            <Form.File
              id="custom-file"
              label="upload image"
              onChange={(event) => handleImageSubmit(event.target.files[0])}
              custom
            />
          </Form>
        ) : (
          <div></div>
        )}
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
                {degree !== ""
                  ? degree
                  : props.isUsersPage
                  ? "Add a Degree"
                  : "Degree - Not Available"}
              </div>
              <div className="text-muted">
                {school
                  ? school
                  : props.isUsersPage
                  ? "Add a School"
                  : "School - Not Available"}
              </div>
              <div className="text-muted">
                {major
                  ? major
                  : props.isUsersPage
                  ? "Add a Major"
                  : "Major - Not Available"}
              </div>
            </>
          )}
        </div>
      </Card>
      <Card>
        <Card.Header>Skills</Card.Header>
        <ListGroup variant="flush">
          {user.skills && user.skills.length !== 0 ? (
            RenderedSkills
          ) : (
            <ListGroup.Item className="individual-skill">
              {props.isUsersPage ? "Add your first skill" : ""}
            </ListGroup.Item>
          )}
          {isEditing ? (
            <ListGroup.Item className="add-skill">
              <FormControl
                aria-label="Small"
                aria-describedby="inputGroup-sizing-sm"
                onChange={(event) => setNewSkill(event.target.value)}
                value={newSkill}
              />
              <Button variant="outline-primary" onClick={addSkill}>
                Add Skill
              </Button>
            </ListGroup.Item>
          ) : null}
        </ListGroup>
      </Card>
    </div>
  );
};

const RightSection = (props) => {
  const {
    handleShow,
    handlePosting,
    user,
    handleReview,
    handleCompany,
  } = props;
  let experiences = user.experiences;
  if (experiences === undefined) experiences = [];
  const RenderedExperiences = experiences.map((experience, index) => {
    return (
      <Card key={index} className="article">
        <Card.Header className="card-head">
          <div className="article-head">
            <h2 className="article-title">
              {experience.company} - {experience.title}
            </h2>
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
  let reviews = user.reviews;
  if (reviews === undefined) reviews = [];
  const RenderedReviews = reviews.map((review, index) => {
    return (
      <Card key={index} className="article">
        <Card.Header className="card-head">
          <div className="article-head">
            <h5 className="article-title">Review from {review.reviewerName}</h5>
            <h5 className="article-date">{review.stars}</h5>
            <button
              className="link-btn"
              onClick={() => {
                window.location.assign(review.link);
              }}
            >
              {" "}
              Reviewer{" "}
            </button>
          </div>
        </Card.Header>
        <Card.Body>
          <Card.Text>{review.review}</Card.Text>
        </Card.Body>
      </Card>
    );
  });
  return (
    <div className="right-section">
      {RenderedExperiences.length ? RenderedExperiences : null}
      {RenderedReviews.length ? RenderedReviews : null}
      {props.isUsersPage ? (
        <div className="add-experience" onClick={handleShow}>
          <div>Add Experience</div> <BsFilePlus />
        </div>
      ) : (
        <div />
      )}
      {props.isUsersPage &&
      ("recruiter" === props.user?.userType ||
        "company" === props.user?.userType) ? (
        <div className="add-experience" onClick={handlePosting}>
          <div>Create a Job Posting</div>
          <BsFilePlus />
        </div>
      ) : (
        <div />
      )}
      {props.isUsersPage && "company" === props.user?.userType ? (
        <div className="add-experience" onClick={handleCompany}>
          <div>Create a Company Page</div>
          <BsFilePlus />
        </div>
      ) : (
        <div />
      )}
      {props.user?.isProfessor ? (
        <div className="add-experience" onClick={handleReview}>
          <div>Add a review</div>
          <BsFilePlus />
        </div>
      ) : (
        <div />
      )}
    </div>
  );
};

const ProfileScreen = (props) => {
  let id = useParams().id;
  if (id === undefined) id = "";
  const isUsersPage = id === "";
  const [showAddExperience, setShowAddExperience] = useState(false);
  const [showAddPosting, setShowAddPosting] = useState(false);
  const [showReview, setShowReview] = useState(false);
  const [showCompany, setShowCompany] = useState(false);
  const currUser = useSelector((state) => state.user);
  const [user, setUser] = useState(currUser);
  const handleClose = () => {
    setShowAddExperience(false);
    setShowAddPosting(false);
    setShowReview(false);
    setShowCompany(false);
  };
  // let history = useHistory();
  // if (Object.entries(user).length === 0) {
  //   history.push("/");
  // }
  const handleShowExperience = () => setShowAddExperience(true);
  const handleShowPosting = () => setShowAddPosting(true);
  const handleReview = () => setShowReview(true);
  const handleShowCompany = () => setShowCompany(true);

  useEffect(() => {
    getProfile(id).then((res) => {
      setUser(res?.data);
    });
  }, [id, setUser]);

  const imageLink = getImageLink(isUsersPage, id);

  return (
    <div>
      <AddNewExperience show={showAddExperience} handleClose={handleClose} />
      <AddNewPosting show={showAddPosting} handleClose={handleClose} />
      <AddNewReview
        show={showReview}
        handleClose={handleClose}
        id={id}
        user={user}
      />
      <AddCompanyPage show={showCompany} handleClose={handleClose} />
      <div className="profile-screen-container">
        <LeftSection
          user={user}
          imageLink={imageLink}
          isUsersPage={isUsersPage}
        />
        <RightSection
          user={user}
          handleShow={handleShowExperience}
          handlePosting={handleShowPosting}
          handleReview={handleReview}
          handleCompany={handleShowCompany}
          isUsersPage={isUsersPage}
        />
      </div>
    </div>
  );
};

export default ProfileScreen;
