import React, { useState } from 'react'
import "./home.css"
import axios from 'axios'

export default function (props) {
  const [searchString, setSearchString] = useState("empty");
  const [searchResult, setSearchResult] = useState([]);
  const handleSubmit = () => {
    console.log("MAKING API CALL with this DATA", searchString)
    let data = {
      "filter": "",
      "subFilter": "",
      "searchTerm": searchString
    }
    axios.post('/GET_IT_FROM_AUSTIN', data)
    .then(function (response) {
      console.log(response);
      // setSearchResult(response.data)
    })
    .catch(function (error) {
      console.log(error);
    });
  }
  return (
    <div className="searchbar-container">
      HOME
      <div className="searchbar-options-container">
        <input onChange={ (e) => { setSearchString(e.target.value) } }/>
        <div>
          <input type="radio" value="jobPosting" />Job Posting
          <input type="radio" value="talent"/>Talent
          <input type="radio" value="professor"/>Professor
          <input type="radio" value="organization"/>Organization  
        </div>
        
      </div>
      

      <button onClick={handleSubmit}>
        Search
      </button>
    </div>
  )
}

/*
{
    "filter": "",
    "subFilter": "",
    "searchTerm": ""
}

{
    "filterTypes": [
        "", -> any
        "jobPosting",
        "talent",
        "professor",
        "organization"
    ],
    "subFilterTypes": [
        "talent": [
            "undergrad",
            "graduate",
            "postgrad"
        ]
    ]
}
*/