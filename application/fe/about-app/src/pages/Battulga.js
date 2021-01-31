import "./Battulga.css"

function AboutBattulga () {

  let avatarUrl = "https://avatars.githubusercontent.com/u/6256640?s=400&u=1e1fcc44878bb3b015d78fef0179499dc8ce9418&v=4"
  return (
    <div className="tulga-about-container">
      <h1>Battulga Tsogtgerel</h1>
      <img alt="avatar" className="tulga-avatar" src={avatarUrl} />
      <div className="about-info-container">
        <div> Student ID: 920203983 </div>
      </div>
    </div>
  )
}


export default AboutBattulga