
sync
LINE EXECUTES
LINE 2

async
LINE FIRES => 2 secs => USER_DATA


LINE DOESNT WAIT =>


CALLBACK
api.get("https:/8321.3.23.2/user/data", function(data){
  console.log(data.user);
  data
})


axios.get("https:/8321.3.23.2/user/data", function(data))

axios.get("https:/8321.3.23.2/user/data").then().then().catch()


PROMISE
api.get("https:/8321.3.23.2/user/data")
  .then( (data) => {
    // display user data.
  })
  .catch( (err) => {
    console.log(err)
    // display error to user within UI
  })

