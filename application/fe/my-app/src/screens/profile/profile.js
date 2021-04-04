import React, { useState } from 'react'
import "./profile.css"
import axios from 'axios'
import deafaultPic from './x.png';
// import SELECTOR from "@redux"

const ProfileScreen = (props) => {
  const [searchResult, setSearchResult] = useState([]);
  const [editMode, setEditMode] = useState(false);
  const [selectedFile, setSelectedFile] = useState();
  const handleEditModeChange = () => {
    setEditMode(true);
  }

  // 
  // const userID = SELECTOR (state.USERID)


  let renderedArticles = [
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
    {
      "title":"title",
      "description":"All play and no work makes jack a dull boy.All play and no work makes jack a dull boy.All play and no work makes jack a dull boy.All play and no work makes jack a dull boy.",
      "startDate":"1/1/1",
      "endDate":"1/1/2"
    }
  ];

  // var formData = new FormData();
  // var imagefile = document.querySelector('#file');
  // formData.append("image", imagefile.files[0]);
  // axios.post('upload_file', formData, {
  //     headers: {
  //       'Content-Type': 'multipart/form-data'
  //     }
  // })

  let articlesResult = renderedArticles.map( (result, index) => {
    return (<article key={index}>
      <div className="article-head">
        <h2 className="article-title">{result.title}</h2>
        <h2 className="article-date">{result.startDate + " - " + result.endDate}</h2>
      </div>
        <div className="article-content">
         <p>{result.description}</p>
        </div>
      </article>)
  })

  const handleImageSelect = (event) => {
    setSelectedFile(event.target.files[0])
  }

  const handleSubmit = (event) => {
    // const BASE_URL = window.origin 
    const BASE_URL = "http://localhost:8080"
    event.preventDefault()
    const form = document.querySelector('form');
    const formData = new FormData(form)
    formData.append("file", selectedFile)
    formData.append("userId", "USER EZRA")

    axios.post(BASE_URL + "/backend/api/user-image/upload/1", formData, {
      "Content-Type": "Multipart-FormData"
    }).then( res => {
      console.log(res)
    }).catch( err => {
      console.log(err)
    })
  }

  function PersonalInfo() {
    var result;

    if (!editMode) {
    result = (
    <div>
        <h2 className="personal-info-bit">username</h2>
        <h2 className="personal-info-bit">student/professor</h2>
        <h2 className="personal-info-bit">grad date</h2>
        <h2 className="personal-info-bit">degree</h2>

      <button type="button" className="generic-button" onClick={handleEditModeChange}><p>Edit Profile</p></button> 

      <article>
        <h2 className="article-title">description</h2>
        <div className="description-box">
          <p>In this box, I am defined.</p>
        </div>
      </article>
    </div>
    )
    } else {
      result = (
      <div className="personal-info-edit">
          <form onSubmit={handleSubmit}>
            <input type="file" onChange={handleImageSelect} />
            <button type="submit"> SUBMIT BRUH </button>
          </form>
          <input type="date" id="fname" name="fname"></input>
          <input type="text" id="fname" name="fname"></input>
        <h2 className="article-title">description</h2>
        <input type="text" id="fdescription" name="fdescription"></input>
    </div>
      )
    }
  
    return (result)
  }

  function renderArticles() {

  }

  return (
    <div className="test">
    <section>
      <personals>
          <img src={deafaultPic} alt="profile picture"/>

          <PersonalInfo name="Sara" />
      </personals>
      <content>
        {articlesResult}
      </content>
    </section>
    </div>
  )
}

export default ProfileScreen
