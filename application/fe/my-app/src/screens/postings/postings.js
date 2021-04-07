import { useState, useEffect} from 'react'
import Navbar from '../../components/navbar'
import axios from 'axios'
import "./postings.scss"
import { Spinner } from 'react-bootstrap';

const PostingsScreen = (props) => {
  const BASE_URL = "http://localhost:8080"
  const [jobs, setJobs] = useState([]); 
  const [loading, setLoading] = useState(true)
  let data = {
    "filter": "",
    "subFilter": "",
    "searchTerm": ""
  }

  useEffect( () => {
    console.log("MAKING API CALL with this DATA", data)
    axios.post(BASE_URL + '/backend/api/search', data)
      .then(res => {
        setJobs(res.data.entries)
        console.log(res.data)
        setLoading(false)
      })  
  }, [])

  let renderedPostings = jobs.map( (job, index) => {
    return (
      <div className="job-post" key={index}>
        <div className="job-post-left">
          <div className="job-post-header">
            <div className="job-title">
              <h3>{job.title}</h3>  
              <span>Company Name</span>
            </div>
            Salary Est. 50k - 70k
          </div>
          <p> { job.description } </p>  
        </div>
        <div className="job-post-right">
          <h3> Requirements</h3>
          <ul>
            <li> JavaScript </li>
            <li> Java </li>
            <li> C++ </li>
            <li> GoLang </li>
          </ul>
          <div className="footer">
            <div> Posted Date: August 20, 2021 </div>
            <button className="apply-btn"> APPLY NOW </button>  
            
          </div>
        </div>
      </div>
    )
  })

  if (loading){
    return(
      <div className="spin-wrapper">
        <Spinner animation="border" variant="primary" />  
      </div>
    )
  }
  return (
    <div>
      <Navbar />
      <div className="job-posts-container">
        {renderedPostings}
      </div>
    </div>
  )
}

export default PostingsScreen