import React, { useState } from 'react'
import "./profile.css"
import axios from 'axios'
import deafaultPic from './x.png';


const ProfileScreen = (props) => {
  const [searchResult, setSearchResult] = useState([]);
  const [editMode, setEditMode] = useState(false);

  const handleEditModeChange = () => {
    setEditMode(true);
  }

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

  function PersonalInfo() {
    var result;

    if (!editMode) {
    result = (
    <div>
        <h2 className="personal-info-bit">username</h2>
        <h2 className="personal-info-bit">student/professor</h2>
        <h2 className="personal-info-bit">grad date</h2>
        <h2 className="personal-info-bit">degree</h2>

      <button type="button" class="generic-button" onClick={handleEditModeChange}><p>Edit Profile</p></button> 

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
      <div class="personal-info-edit">
          <form>
            <input type="file" onchange="this.form.submit()" /> 
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
