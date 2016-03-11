package controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.UserService;
import entity.User;

@RestController
@RequestMapping("/user")
@Api(value="Algo")
public class UserController {

	
	UserService userService; 
	
	
	// Retrieve Single User
	@ApiOperation(httpMethod= "GET",value="return a user")
	@RequestMapping(value = "/get/{nickName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(
			@PathVariable("nickName") String nickName) {
		System.out.println("Fetching User with nick name " + nickName);
		User user = userService.findByNickName(nickName);
		if (user == null) {
			System.out
					.println("User with nick name " + nickName + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// Create a User
	@ApiOperation(httpMethod= "POST",value="create a user")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user) {

		if (userService.isUserExist(user)) {
			System.out.println("A User with name " + user.getNickName()
					+ " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		userService.add(user);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	// Update a User
	@ApiOperation(httpMethod= "PUT",value="update a user")
	@RequestMapping(value = "/put/{nickName}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(
			@PathVariable("nickName") String nickName, @RequestBody User user) {

		User currentUser = userService.findByNickName(nickName);

		if (currentUser == null) {
			System.out
					.println("User with nick name " + nickName + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		currentUser.setName(user.getName());
		currentUser.setEmail(user.getEmail());
		currentUser.setPassword(user.getPassword());

		userService.update(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

	// Delete a User

	@ApiOperation(httpMethod= "DELETE",value="delete a user")
	@RequestMapping(value = "/delete/{nickName}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(
			@PathVariable("nickName") String nickName) {

		User user = userService.findByNickName(nickName);
		if (user == null) {
			System.out.println("Unable to delete. User with nickName "
					+ nickName + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		userService.delete(nickName);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}
