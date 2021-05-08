import React, {useState, useEffect} from "react";
import "./company.scss";
import {
  Card,
} from "react-bootstrap";
import { useParams } from "react-router-dom";
import {
  getCompany,
} from "../../utility/request";

const CompanySection = (props) => {
  const { company } = props;

  const RenderedLocations = company?.locations?.map((location, index) => {
    return (
        <li className="individual-skill" key={index}>
          * {location}
        </li>
    );
  });

  return (
      <div className="right-section">
        <Card key="posting" className="article">
          <Card.Header className="card-head">
            <div className="article-head">
              <h2 className="article-title">{company.companyName}</h2>
              <h5 className="article-date">Number of Employees: {company.numberEmployees}</h5>
            </div>
          </Card.Header>
          <Card.Body>
            <h5 className="article-title">Company's Mission</h5>
            <Card.Text>{company.mission}</Card.Text>
            <h5 className="article-title">Company's Product</h5>
            <Card.Text>{company.product}</Card.Text>
          </Card.Body>
          <Card.Footer>
            <h5>Locations: </h5>
            {RenderedLocations}
          </Card.Footer>
        </Card>
      </div>
  );
};

const CompanyScreen = (props) => {
  let id = useParams().id;
  const [company, setCompany] = useState({});

  useEffect(() => {
    if (id !== "") {
      getCompany(id).then((res) => {
        setCompany(res.data);
      });
    }
  }, [id, setCompany]);

  return (
      <div>
        <div className="profile-screen-container">
          <CompanySection company={company}/>
        </div>
      </div>
  );
};

export default CompanyScreen;
