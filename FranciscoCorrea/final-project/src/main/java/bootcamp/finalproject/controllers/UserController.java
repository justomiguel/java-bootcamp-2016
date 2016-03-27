package bootcamp.finalproject.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import bootcamp.finalproject.entities.User;
import bootcamp.finalproject.services.UserService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;


@RequestMapping("/users")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<User> add(@RequestBody User user) {
		User r = this.userService.saveUser(user);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(r.getUserId()).toUri());
		return new ResponseEntity<User>(httpHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public User get(@PathVariable long id) {
		return this.userService.findById(id);
	}
	
	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public Object getAuthUser() {
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<User> update(@PathVariable long id, @RequestBody User input) {
		User old = this.userService.findById(id);
		
		if(old != null) {
			old.setFirstName(input.getFirstName());
			old.setLastName(input.getLastName());
			old.setNickName(input.getNickName());
			old.setPassword(input.getPassword());
			old.setPhone(input.getPhone());
			old.setEmail(input.getEmail());
			this.userService.updateUser(old);
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void update(@PathVariable long id) {
		this.userService.deleteUser(id);
	}
	
}
