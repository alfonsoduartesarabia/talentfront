import react, { useState, useEffect} from 'react'
import Navbar from '../../components/navbar'
import axios from 'axios'
import "./postings.scss"

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
          <h1>{job.title}</h1>
          <p> { job.description } </p>  
        </div>
        <div className="job-post-right">
          <h1>{job.type}</h1>
        </div>
      </div>
    )
  })

  if (loading){
    return(
      <div>
        LOADING
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