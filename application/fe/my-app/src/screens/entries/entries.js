import { useState, useEffect } from "react";
import { Spinner } from "react-bootstrap";
import {useDispatch, useSelector} from "react-redux";
import { postSearch } from "../../utility/request";
import "./entries.scss";
import {useHistory} from "react-router-dom";
import {updateQuery} from "../../utility/slices/search";

const EntriesScreen = (props) => {
  const [entries, setEntries] = useState([]);
  const [loading, setLoading] = useState(true);
  const history = useHistory();
  let query = useSelector((state) => state.search);
  if (props.emptySearch) {
    let newQuery = {
      filter: "",
      subFilter: "",
      searchTerm: "",
    };
  }
  useEffect(() => {
    console.log("SENDING REQUEST TO BACKEND");
    console.log(JSON.stringify(query));
    setLoading(false);
    if (props.emptySearch) {
      postSearch({
        filter: "",
        subFilter: "",
        searchTerm: "",
      })
      .then(res => {
        setEntries(res.data.entries)
        setLoading(false)
      })
      .catch(err => {
        console.log(err)
        setLoading(false)
      })
    } else {
      postSearch(query?.search)
      .then(res => {
        setEntries(res.data.entries)
        setLoading(false)
      })
      .catch(err => {
        console.log(err)
        setLoading(false)
      })
    }
  }, [query, props.emptySearch]);

  let renderedPostings = entries.map((entry, index) => {
    return (
      <div className="job-post" key={index}>
        <div className="job-post-left">
          <div className="job-post-header">
            <div className="job-title">
              <h3>{entry.title}</h3>
            </div>
          </div>
          <p> {entry.description} </p>
        </div>
        <div className="job-post-right">
          <div className="footer">
            <button className="link-btn" onClick={() => {
              history.push(entry.link)
            }}> Page </button>
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
      <div className="job-posts-container">{renderedPostings}</div>
    </div>
  );
};

export default EntriesScreen;
