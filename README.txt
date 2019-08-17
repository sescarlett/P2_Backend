//---------routes by type-------------

//----------User----------

//post new user
post("localhost:8080/user/")

//get all users
get("localhost:8080/user")

//get user by id
get("localhost:8080/user/:id")
	-> will have to do some error checking if user doesnt exist

//update user name
put("localhost:8080/user/name/:id")
	-> full user object passed in ex:
	{
	
	"firstname": "Steve",
	
	"lastname": "",
	"email": 
	"stephen.scarlett@email.com",
	
	"password": "password"

	}
	-> this info should be pulled from
	-> this.props.user.{firstname, lastname, etc.}

//update user email
put("localhost:8080/user/email/:id")
	->same usage as name update

//update user password
put("localhost:8080/user/password/:id")

//-----------Review-------------

// create new review
post("localhost:8080/review")
	-> CURRENTLY ADDING NEW MOVIES AND USERS ON POST
		-> need to figure out how to just relate to object instead of adding
		-> try @JsonIgnore on user and movie in Review modal
	-> on front end use user id from JWT to get the user object
	-> try to search postgres for movie by title and year
		-> if exists use movie object for post
		-> else create new movie (see create new movie route)

//get all reviews by a user
get("localhost:8080/review/user/:id")
	-> returns a full array containing both user and movie objects
	-> if empty user has no reviews

//get all reviews for a movie
get("localhost:8080/review/movie/:id")
	-> returns a full array containing both user and movie objects
	-> if empty user has no reviews

//----------Movie----------

//create new movie
post("localhost:8080/movie")

//------------------other notes--------------------------

- need to figure out how do the rating
	-> current thought: get an array of all rating for a
		movie then math it on the front end

- Trey has to get login/signup/logout working.
	->when someone signs up immediately log them in 
		with their provided credentials






