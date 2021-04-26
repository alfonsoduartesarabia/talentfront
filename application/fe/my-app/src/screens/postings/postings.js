import { useState, useEffect } from "react";
import Navbar from "../../components/navbar";
import { Spinner } from "react-bootstrap";
import { useSelector } from "react-redux";
import { postSearch } from "../../utility/request";
import { Dropdown } from "react-bootstrap";
import Moment from "react-moment";
import "./postings.scss";
import postingDummyData from "./postingDummyData";

const PostingsScreen = (props) => {
  const [jobs, setJobs] = useState([]);
  const [salaryFilter, setSalaryFilter] = useState("");
  const [loading, setLoading] = useState(true);

  let query = useSelector((state) => state.search);
  useEffect(() => {
    console.log("SENDING REQUEST TO BACKEND");
    console.log(JSON.stringify(query));
    // setJobs(postingDummyData);
    setLoading(false);
    postSearch(query?.search)
      .then(res => {
        setJobs(res.data.entries)
        console.log(`This is the response for ${JSON.stringify(res.data)}`)
        setLoading(false)
      })
      .catch (err => {
        console.log(err)
        setLoading(false)
      })
  }, [query]);

  let renderedPostings = jobs.map((job, index) => {
    return (
      <div className="job-post" key={index}>
        <div className="job-post-left">
          <div className="job-post-header">
            <div className="job-title">
              <h3>{job.title}</h3>
              <span>{job.companyName}</span>
            </div>
            Salary Est. {job.salaryEstimate}
          </div>
          <p> {job.description} </p>
        </div>
        <div className="job-post-right">
          {/*<h3> Requirements</h3>*/}
          {/*<ul>*/}
          {/*  {job.requirements.map((requirement, index) => {*/}
          {/*    return <li key={index}>{requirement}</li>;*/}
          {/*  })}*/}
          {/*</ul>*/}

          <div className="footer">
            <div>
              {" "}
              Posted Date: <Moment format="MM/DD/YYYY">
                {job.postedDate}
              </Moment>{" "}
            </div>
            <button className="apply-btn"> APPLY NOW </button>
          </div>
        </div>
      </div>
    );
  });

  if (loading) {
    return (
      <div className="spin-wrapper">
        <Spinner animation="border" variant="primary" />
      </div>
    );
  }
  return (
    <div>
      <Navbar />
      <div className="postings-filter">
        FILTER BY:
        <div className="filter-sub">
          SALARY
          <Dropdown>
            <Dropdown.Toggle variant="primary" id="dropdown-basic">
              {salaryFilter === "" ? "Range" : salaryFilter}
            </Dropdown.Toggle>

            <Dropdown.Menu>
              <Dropdown.Item onClick={(event) => setSalaryFilter("")}>
                Clear Filter
              </Dropdown.Item>
              <Dropdown.Item onClick={(event) => setSalaryFilter("100k-150k")}>
                100k - 150k
              </Dropdown.Item>
              <Dropdown.Item onClick={(event) => setSalaryFilter("120k-150k")}>
                120k - 150k
              </Dropdown.Item>
              <Dropdown.Item onClick={(event) => setSalaryFilter("200k+")}>
                200k+
              </Dropdown.Item>
            </Dropdown.Menu>
          </Dropdown>
        </div>
        <div className="filter-sub">
          SORT BY DATE
          <Dropdown>
            <Dropdown.Toggle variant="primary" id="dropdown-basic">
              {salaryFilter === "" ? "Range" : salaryFilter}
            </Dropdown.Toggle>

            <Dropdown.Menu>
              <Dropdown.Item onClick={(event) => setSalaryFilter("")}>
                Clear Filter
              </Dropdown.Item>
              <Dropdown.Item onClick={(event) => setSalaryFilter("100k-150k")}>
                100k - 150k
              </Dropdown.Item>
              <Dropdown.Item onClick={(event) => setSalaryFilter("120k-150k")}>
                120k - 150k
              </Dropdown.Item>
              <Dropdown.Item onClick={(event) => setSalaryFilter("200k+")}>
                200k+
              </Dropdown.Item>
            </Dropdown.Menu>
          </Dropdown>
        </div>
        <div className="filter-sub">
          EXPERIENCE REQUIREMENT
          <Dropdown>
            <Dropdown.Toggle variant="primary" id="dropdown-basic">
              {salaryFilter === "" ? "Range" : salaryFilter}
            </Dropdown.Toggle>

            <Dropdown.Menu>
              <Dropdown.Item onClick={(event) => setSalaryFilter("")}>
                Clear Filter
              </Dropdown.Item>
              <Dropdown.Item onClick={(event) => setSalaryFilter("100k-150k")}>
                100k - 150k
              </Dropdown.Item>
              <Dropdown.Item onClick={(event) => setSalaryFilter("120k-150k")}>
                120k - 150k
              </Dropdown.Item>
              <Dropdown.Item onClick={(event) => setSalaryFilter("200k+")}>
                200k+
              </Dropdown.Item>
            </Dropdown.Menu>
          </Dropdown>
        </div>
      </div>
      <div className="job-posts-container">{renderedPostings}</div>
    </div>
  );
};

export default PostingsScreen;
