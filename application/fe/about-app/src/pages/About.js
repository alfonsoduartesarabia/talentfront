import { Link } from 'react-router-dom'

function About() {
  let sfsuLogoURL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSERxa7hbrwGg5vCL6kwHVy_GxegTQa5eCNng&usqp=CAU"
  return (
      <div className='App'>
        <div className='App-text'>
          <div className="about-header">
            <h1>CSC 648 - Software Engineering Class</h1> 
            <img src={sfsuLogoURL} alt="SFSU" /> 
          </div>
          <div className="about-info-container">
            <div>
              <h3>Term Offered: Spring 2021</h3>
              <h3>Section Number: 02</h3>
              <h3>Team Number: 5</h3>    
            </div>
            <div className="team-info-container">
              <p>
                About page for Team 5.
              </p>
              <Link to='/about/austin/'>Austin Wimberley</Link>
              <Link to='/about/tulga/'>Battulga Tsogtgerel</Link>
              <Link to='/about/ezra/'>Ezra Player</Link> 
              <Link to='/about/alfonso'>Alfonso Duarte-Sarabia</Link> 
            </div>
          </div>
        </div>
      </div>
  );
}


export default About