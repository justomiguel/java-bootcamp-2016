package finalproject.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import finalproject.entity.User;
import finalproject.service.UserService;

@RestController
@RequestMapping("/api/user")
@Api(value = "user", produces = "application/json")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/singup", method = RequestMethod.POST)
	@ApiOperation(value = "register user", notes = "Registration of the user")
	@ApiResponse(code = 200, message = "user was created successfully")
	public User createUser(@RequestBody User user) {

		return userService.persistUser(user);
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
	@ApiOperation(value = "delete user")
	@ApiResponse(code = 200, message = "user was deleted successfully")
	public void deleteUserByUsername(@PathVariable String username) {
		userService.deleteUserByUsername(username);

	}
	
	@RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
	@ApiOperation(value = "find user")
	@ApiResponse(code = 200, message = "user was finded successfully")
	public User findByUsername(@PathVariable String username){
		return userService.findByUsername(username);
		
		
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "find user")
	@ApiResponse(code = 200, message = "user was finded successfully")
	public User findUserById(@PathVariable long id) {
		return userService.getUserById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "delete user")
	@ApiResponse(code = 200, message = "user was deleted successfully")
	public void deleteUser(@PathVariable long id){
		userService.deleteUser(id);
		
	}
	
	
}
