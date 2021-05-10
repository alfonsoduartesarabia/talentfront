import React, {useState, useEffect} from "react";
import "./posting.scss";
import { Button } from "react-bootstrap";
import {
  Form,
  Col,
  Card,
  Modal,
} from "react-bootstrap";
import { useParams } from "react-router-dom";
import {
  getApply,
  getPosting, postPosting,
} from "../../utility/request";

export const ShowNotification = (props) => {
  const {showNotification, handleClose} = props;

  return (
      <Modal
          backdrop="static"
          keyboard={false}
          show={showNotification}
          onHide={handleClose}
          size="lg"
          centered
      >
        <Modal.Header closeButton>
          <Modal.Title>We've notified the Poster of Your Interest</Modal.Title>
        </Modal.Header>
      </Modal>);
};
export const AddNewPosting = (props) => {
  const { show, handleClose } = props;
  const [jobTitle, setJobTitle] = useState("");
  const [companyName, setCompanyName] = useState("");
  const [description, setDescription] = useState("");
  const [salaryBottom, setSalaryBottom] = useState(0);
  const [salaryTop, setSalaryTop] = useState(0);
  const [requirements, setRequirements] = useState([]);
  const [state, setState] = useState("");
  const [city, setCity] = useState("");

  const handleSave = () => {
    let postingData = {
      jobTitle,
      companyName,
      salaryBottom,
      salaryTop,
      description,
      requirements,
      state,
      city,
    };
    postPosting(postingData)
      .then(res => window.location.assign(`/posting/${res?.data?.postingId}`))
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
          <Modal.Title>Create New Job Posting</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Row>
              <Form.Group as={Col}>
                <Form.Label>Job title</Form.Label>
                <Form.Control
                    onChange={(event) => setJobTitle(event.target.value)}
                    placeholder="Enter job title"
                />
              </Form.Group>
              <Form.Group as={Col}>
                <Form.Label>Company Name</Form.Label>
                <Form.Control
                    onChange={(event) => setCompanyName(event.target.value)}
                    placeholder="Enter company name"
                />
              </Form.Group>
            </Form.Row>
            <Form.Row>
              <Form.Group as={Col}>
                <Form.Label>Salary Top</Form.Label>
                <Form.Control
                    onChange={(event) => setSalaryTop(parseInt(event.target.value))}
                    placeholder="Enter a number"
                />
              </Form.Group>
              <Form.Group as={Col}>
                <Form.Label>Salary Bottom</Form.Label>
                <Form.Control
                    onChange={(event) => setSalaryBottom(parseInt(event.target.value))}
                    placeholder="Enter a number"
                />
              </Form.Group>
            </Form.Row>
            <Form.Row>
              <Form.Group as={Col}>
                <Form.Label>City</Form.Label>
                <Form.Control
                    onChange={(event) => setCity(event.target.value)}
                    placeholder="Enter the city"
                />
              </Form.Group>
              <Form.Group as={Col}>
                <Form.Label>State</Form.Label>
                <Form.Control
                    onChange={(event) => setState(event.target.value)}
                    placeholder="Enter the state"
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
            <Form.Group>
              <Form.Label>Requirements</Form.Label>
              <Form.Control
                  onChange={(event) => setRequirements(event.target.value.split(','))}
                  as="textarea"
                  placeholder="Enter requirements"
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

const JobSection = (props) => {
  const { handleShow, posting, isPostersPage, id, handleShowNotification } = props;

  const RenderedReqs = posting?.requirements?.map((requirement, index) => {
    return (
        <li className="individual-skill" key={index}>
          * {requirement}
        </li>
    );
  });

  const handleApply = () => {
    console.log("logging out");
    handleShowNotification()
    getApply(id).then(r => console.log("HI"));
  };


  return (!isPostersPage) ?
      (
      <div className="right-section">
        <Card key="posting" className="article">
          <Card.Header className="card-head">
            <div className="article-head">
              <h2 className="article-title">{posting.companyName} - {posting.jobTitle}</h2>
              <h2 className="article-date">Date Posted {posting.datePosted}</h2>
            </div>
            <div className="article-sub-head">
              <h4 className="article-sub-title">Salary Range: {posting.salaryRange}</h4>
              <button className="navbar-btn" onClick={handleApply}>
                Apply
              </button>
            </div>
          </Card.Header>
          <Card.Body>
            <Card.Text>{posting.description}</Card.Text>
          </Card.Body>
          <Card.Footer>
            <h5>Requirements: </h5>
            {RenderedReqs}
          </Card.Footer>
        </Card>
      </div>
  ) : (
          <div className="right-section">
            <Card className="add-experience" onClick={handleShow}>
              <div>Create Posting</div>
            </Card>
          </div>
      );
};

const PostingScreen = (props) => {
  let id = useParams().id;
  if (id === undefined) id = "";
  const isPostersPage = id === "";
  const [show, setShow] = useState(false);
  const [showNotification, setShowNotification] = useState(false);
  const [posting, setPosting] = useState({});
  const handleClose = () => {
    setShow(false);
    setShowNotification(false)
  }
  const handleShow = () => setShow(true);
  const handleShowNotification = () => setShowNotification(true);

  useEffect(() => {
    if (id !== "") {
      getPosting(id).then((res) => {
        setPosting(res.data);
      });
    }
  }, [id, setPosting]);

  return (
      <div>
        <AddNewPosting show={show} handleClose={handleClose} />
        <ShowNotification showNotification={showNotification} handleClose={handleClose} />
        <div className="profile-screen-container">
          <JobSection id = {id} posting={posting} handleShow={handleShow} handleShowNotification={handleShowNotification} isPostersPage={isPostersPage} />
        </div>
      </div>
  );
};

export default PostingScreen;
