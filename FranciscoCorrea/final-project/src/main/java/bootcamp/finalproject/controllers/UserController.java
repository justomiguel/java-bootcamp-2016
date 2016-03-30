package bootcamp.finalproject.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.finalproject.entities.User;
import bootcamp.finalproject.services.UserService;

import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ResponseEntity<?> userRegistration(@RequestBody User user) {
		if(userService.isValid(user)) {
			User newUser = this.userService.saveUser(user);
			return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
		}
		return new ResponseEntity<>("User and/or email not valid", HttpStatus.CONFLICT);
	}
	
}
