import React, { useState, useEffect } from 'react'
import "./profile.scss"
import axios from 'axios'
import { useDispatch, useSelector } from 'react-redux'
import deafaultPic from './x.png';
import { Spinner } from 'react-bootstrap';
import { Button} from 'react-bootstrap';
import { InputGroup, Form, Row, Col, Card, Fade} from 'react-bootstrap';
import { login } from '../../features/user/slice'
import Navbar from '../../components/navbar'
// import SELECTOR from "@redux"

function GetFormattedDate(datearg) {
    var todayTime = datearg;
    var month = todayTime .getMonth() + 1;
    var day = todayTime .getDate();
    var year = todayTime .getFullYear();
    return month + "-" + day + "-" + year;
}

const ProfileScreen = (props) => {
  const BASE_URL = "http://localhost:8080"
  const [searchResult, setSearchResult] = useState([]);
  const [editMode, setEditMode] = useState(false);
  const [loading, setLoading] = useState(true);
  const [selectedFile, setSelectedFile] = useState();
  const [imageUrl, setImageUrl] = useState("");
  const handleEditModeChange = () => {
    setEditMode(!editMode);
  }

  let user = useSelector( state => state.user.user)

  let data = {
    "filter": "",
    "subFilter": "",
    "searchTerm": ""
  }

  let dummyData = [
    {
      "title":"title",
      "description":"All play and no work makes jack a dull boy.All play and no work makes jack a dull boy.All play and no work makes jack a dull boy.All play and no work makes jack a dull boy.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
      "startDate":"1/1/1",
      "endDate":"1/1/2"
    },
    {
      "title":"title",
      "description":"All play and no work makes jack a dull boy.All play and no work makes jack a dull boy.All play and no work makes jack a dull boy.All play and no work makes jack a dull boy.",
      "startDate":"1/1/1",
      "endDate":"1/1/2"
    },
  ];
  useEffect( () => {
    setSearchResult(dummyData)
    setLoading(false)
    console.log("MAKING API CALL with this DATA", data)
    // axios.post(BASE_URL + '/backend/api/search', data)
    //   .then(res => {
    //     setSearchResult(res.data.entries)
    //     console.log(res.data)
    //     setLoading(false)
    //   })
    //   .catch (err => {
    //     console.log(err)
    //     setLoading(false)
    //     return (
    //       <div>
    //         <h1>something went wrong...</h1>
    //       </div>
    //     )
    //   })
  }, [])

  

  // var formData = new FormData();
  // var imagefile = document.querySelector('#file');
  // formData.append("image", imagefile.files[0]); 
  // axios.post('upload_file', formData, {
  //     headers: {
  //       'Content-Type': 'multipart/form-data'
  //     }
  // })

  let articlesResult = searchResult.map( (result, index) => {
    var result;
    if (!editMode) {
      result = (
        <Card key={index} className="article">
          <Card.Header className="card-head">
            <div className="article-head">
            <h2 className="article-title">{result.title}</h2>
            <h2 className="article-date">{result.startDate + " - " + result.endDate}</h2>
            </div>  
          </Card.Header>
          <Card.Body>
            <Card.Text>
              {result.description}
            </Card.Text>
          </Card.Body>
        </Card>
      )
    } else {

        result = (
          <Card key={index} className="article">
            <Card.Header className="card-head">
              <div className="article-head">
              <h2 className="article-title"><Form.Control placeholder="Degree" defaultValue={result.title}/></h2>
              <h2 className="article-date"><input type="date" id="grad-date" classname="date-select"></input> - <input type="date" id="grad-date" classname="date-select"></input></h2>
              </div>  
            </Card.Header>
            <Card.Body>
              <Card.Text>
                <Form.Control as="textarea" defaultValue={result.description} rows={10} />
              </Card.Text>
            </Card.Body>
          </Card>
        )
    }
    return result;
    // return (<article key={index}>
    //   <div className="article-head">
    //     <h2 className="article-title">{result.title}</h2>
    //     <h2 className="article-date">{result.startDate + " - " + result.endDate}</h2>
    //   </div>
    //     <div className="article-content">
    //      <p>{result.description}</p>
    //     </div>
    //   </article>)
  })

  const handleImageSelect = (event) => {
    setSelectedFile(event.target.files[0]);
    console.log(event.target.files[0]);
    handleSubmit(event.target.files[0])
  }

  const handleSubmit = (file) => {
    // const BASE_URL = window.origin 
    //event.preventDefault()
    const BASE_URL = "http://localhost:8080"
    const form = document.querySelector('form');
    const formData = new FormData(form)
    formData.append("image", file)
    formData.append("userId", "USER EZRA")
    console.log(file)
    axios.post(BASE_URL + "/backend/api/user-image/upload/3", formData, {
      "Content-Type": "Multipart-FormData"
    }).then( res => {
      console.log("RECEIVED IMAGE URL", res.config.url)
      setImageUrl(BASE_URL + "/backend/api/user-image/3")
    }).catch( err => {
      console.log(err)
    })
  }



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
        <img className="profile-Image-Bruh" src={BASE_URL + "/backend/api/user-image/3"} alt="profile picture"/>

        <Card className="profile-card">
          <Card.Body>
            <Card.Title>{user.firstname}</Card.Title>
            <Card.Subtitle className="mb-2 text-muted">{user.userType}</Card.Subtitle>
            <Card.Title>{user.degree}</Card.Title>
            <Card.Subtitle className="mb-2 text-muted">Graduates: {user.graduateDate.toString()}</Card.Subtitle>
            <Card className="skills-card">
               <Card.Title style={{padding:"2%"}}>Skills:</Card.Title>
              <Card.Text style={{padding:"2%"}}>
                {user.skills}
              </Card.Text>
            </Card>
            <Card.Link href="#" onClick={handleEditModeChange}>Edit Profile</Card.Link>
          </Card.Body>
        </Card>
    </div>
    )
    } else {
      result = (
        <Fade in={editMode}>
        <div className="personal-info-edit">
          <img src={deafaultPic} alt="profile picture"/>
          <Form style={{padding:"2%"}}>
            <Form.File 
              id="custom-file"
              label="test"
              onChange={handleImageSelect}
              custom
            />
          </Form>
          <Card className="profile-card">
            <Card.Body>
              <Card.Title>
              {user.userType}
              </Card.Title>
              <Card.Subtitle className="mb-2 text-muted">{user.firstname + " " + user.lastname}</Card.Subtitle>
              <Card.Title>
                <Form.Control defaultValue={user.degree} placeholder="Degree" />
              </Card.Title>
              <Card.Subtitle className="mb-2 text-muted">
                <div className="grad-date-container">
                  <div>
                  Graduates: 
                  </div>
                <input value={user.graduateDate.toString()} onChange={event => {user.graduationDate = event.target.value}} type="date" id="grad-date" classname="date-select"></input>
                </div>
              </Card.Subtitle>
              <Card className="skills-card">
                <Card.Title style={{padding:"2%"}}>Skills:</Card.Title>
                <Card.Text style={{padding:"2%"}}>
                <Form.Control defaultValue={user.skills} as="textarea" rows={10} className="description-box"/>
                </Card.Text>
              </Card>
            </Card.Body>
          </Card>
        </div>
        </Fade>
      )
    }
  
    return (result)
  }

  function RenderArticles() {
    var result;
    if (editMode) {
      result = (<div><EditMenu/>{articlesResult}</div>)
    }
    else {
      result = (<div>{articlesResult}</div>)
    }
    return (result)
  }

  function EditMenu() {
    return (
      <div className="edit-menu">
          <Form className="account-edit">
            <Card.Header className = "account-head">Account Info</Card.Header>
            <Row>
              <Col>
                <Form.Group controlId="formBasicEmail">
                  <Form.Label>Email address</Form.Label>
                  <Form.Control defaultValue={user.email} type="email" placeholder="Enter email" />
                  <Form.Text className="text-muted">
                    We'll never share your email with anyone else.
                  </Form.Text>
                </Form.Group>
                <Row>
                  <Col>
                    <Form.Control defaultValue={user.firstname} placeholder="First name" />
                  </Col>
                  <Col>
                    <Form.Control defaultValue={user.lastname} placeholder="Last name" />
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
                <Form.Control defaultValue={user.about} as="textarea" rows={10} className="description-box"/>
              </Form.Group>
              </Col>
            </Row>
            <div className="save-changes-buttons">
              <Button variant="primary" type="button" className="save-changes-button" onClick={handleEditModeChange}>Save</Button>
              <Button type="button" className="save-changes-button" onClick={handleEditModeChange}>Don't Save</Button>
            </div>
          </Form>
      </div>
    )
  }


  if (loading) {
    return(
      <div className="spin-wrapper">
        <Spinner animation="border" variant="primary" />  
      </div>
    )
  }

  return (
    <div>
    <Navbar />
    <section>
      <div className="personals">
        <PersonalInfo/>
      </div>
      <content>
        <RenderArticles/>
      </content>
    </section>
    </div>
  )
}

export default ProfileScreen
