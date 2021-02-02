# csc648 Repository

## Please when ready add your teams application URL or IP to the repository description. This will help with grading. Teams are expected to keep this value up to date.


## Team Members

| Student Name | Student Email | GitHub Username |
|    :---:     |     :---:     |     :---:       |
| Austin Wimberley | awimberley@mail.sfsu.edu | pachecosf |
| Alfonso Duarte-Sarabia | asarabi2@mail.sfsu.edu | alfonsoduartesarabia |
| Ezra Player |eplayer@mail.sfsu.edu | ezra5512 |
| Battulga Tsogtgerel  |  btsogtgerel@mail.sfsu.edu  | thetulga      |
| Yuhua Wu      | ywu23@mail.sfsu.edu|  yuhua21223               |
| member6      |               |                 |

## NO code needs to be stored in the root of your repository. You may rename the application folder if you like to your team's application name. But all source code related to your team's application should be stored inside the application folder.

## Github CI

We've set up github actions to publish the docker images on every PR/push to master to publish an image to dockerhub. You can view these pipelines at ./github/workflows. There should be no need to locally build the docker images, the latest image will be built and pushed to dockerhub as you push to this repo. Be mindful that our actions are limited for free accounts, so develop on a non master branch and once its ready for a MR it will build the image.