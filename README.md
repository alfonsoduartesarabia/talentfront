# Final Project for CSC 648
Project description - Built a full stack website that connects SFSU students or graduates with potential employers, teachers, and other students. The website would make it easier for employers to find talented graduates and students, where professors can recommend students to employers, and make it easier for students and graduates with their job search. We titled our website Talent Front.

Github pages
https://alfonsoduartesarabia.github.io/talentfront/

Since github pages is serverless then I cannot demonstrate each functionality of the webiste. Rather I will showcase the UI/UX design of the homepage, login, and sign-up page.

Tools used:
React, Redux, React-Bootstrap, Tailwind CSS, and Sass. 


# csc648 Repository

## Please when ready add your teams application URL or IP to the repository description. This will help with grading. Teams are expected to keep this value up to date.


## Team Members

| Student Name | Student Email | GitHub Username |
|    :---:     |     :---:     |     :---:       |
| Austin Wimberley | awimberley@mail.sfsu.edu | pachecosf |
| Alfonso Duarte-Sarabia | asarabi2@mail.sfsu.edu | alfonsoduartesarabia |
| Ezra Player |eplayer@mail.sfsu.edu | ezra5512 |
| Battulga Tsogtgerel  |  btsogtgerel@mail.sfsu.edu  | thetulga      |
| UTKRISHT SHARMA (meme lord)|  usharma1@mail.sfsu.edu  |    utkrishtsharma   |

## NO code needs to be stored in the root of your repository. You may rename the application folder if you like to your team's application name. But all source code related to your team's application should be stored inside the application folder.

## Github CI

We've set up github actions to publish the docker images on every PR/push to master to publish an image to dockerhub. You can view these pipelines at ./github/workflows. There should be no need to locally build the docker images, the latest image will be built and pushed to dockerhub as you push to this repo. Be mindful that our actions are limited for free accounts, so develop on a non master branch and once its ready for a MR it will build the image.
