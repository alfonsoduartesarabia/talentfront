import React, { useState } from 'react'
import "./home.css"
import axios from 'axios'

import Navbar from '../components/navbar'

const HomeScreen = (props) => {
  const [searchString, setSearchString] = useState("");
  const [searchResult, setSearchResult] = useState([]);
  const [filter, setFilter] = useState("");


  const BASE_URL = window.origin 

  const handleRadioButtonChange = (e) => {
    setFilter(e.target.value)
  }

  const handleSubmit = (event) => {
    event.preventDefault();
    let data = {
      "filter": filter,
      "subFilter": "",
      "searchTerm": searchString
    }
    console.log("MAKING API CALL with this DATA", data)
    axios.post(BASE_URL + '/backend/api/search', data)
    .then(function (response) {
      console.log(response);
      setSearchResult(response.data.entries)
    })
    .catch(function (error) {
      console.log(error);
      setSearchResult([
        {
            "type": "USER",
            "title": "Battulga Tsogtgerel",
            "description": "Is pursuing an undergraduate degree from San Francisco State University",
            "link": "/posting/1"
        },{
            "type": "USER",
            "title": "Ezra Player",
            "description": "Is pursuing an undergraduate degree from San Francisco State University",
            "link": "/posting/2"
        }
      ])
    });
  }

  let renderedResult = searchResult.map( (result, index) => {
    return <div key={index}>
      <h3>{result.title}</h3>
      <p>{result.description}</p>
    </div>
  })

  return (
    <div className="home-container">
      <Navbar />
      <div className="searchbar-container">
        <form onSubmit={handleSubmit}>
          <div className="searchbar-options-container">
            <input onChange={ (event) => { setSearchString(event.target.value) } }/>
            <div>
              <input type="radio" checked={filter === "jobPosting" } onChange={handleRadioButtonChange} value="jobPosting" />Job Posting
              <input type="radio" checked={filter === "talent" } onChange={handleRadioButtonChange} value="talent"/>Talent
              <input type="radio" checked={filter === "professor" } onChange={handleRadioButtonChange} value="professor"/>Professor
              <input type="radio" checked={filter === "organization" } onChange={handleRadioButtonChange} value="organization"/>Organization   
            </div>
          </div>
          <button type="submit">
            Search
          </button>
        </form> 
      </div> 

      <div className="search-results-container">
        {renderedResult}
      </div>
    </div>
    
  )
}

export default HomeScreen

//docker-compose pull
//docker-compose up

// LOCAL => localhost:8080

// PROD localhost:80/api

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

