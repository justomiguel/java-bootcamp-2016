package userapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// For documentation domain/swagger-ui.html


@RestController
@RequestMapping("/user")
public class UserRestController {
	
	private UserRepository userRepository;
	
	@ApiOperation(value = "Add User", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	@ApiResponses({
		@ApiResponse(code = 201, message = "User added")
	})
	public ResponseEntity<User> add(@ApiParam(value = "User to be add", required = true) @RequestBody User input) {
		User r = this.userRepository.save(input);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(r.getId()).toUri());
		return new ResponseEntity<User>(httpHeaders, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "List all users", response = User.class, responseContainer = "List")
	@RequestMapping(method = RequestMethod.GET)
	@ApiResponses({
		@ApiResponse(code = 200, message = "User list")
	})
	public List<User> getAll() {
		return this.userRepository.findAll();
	}
	
	@ApiOperation(value = "Find users by name", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.GET, value = "/search")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Users founded"),
		@ApiResponse(code = 404, message = "Users not found")
	})
	public ResponseEntity<List<User>> findByName(@ApiParam(value = "Name to find", required = true) 
									@RequestParam(value = "firstname") String firstname) {
		if (this.userRepository.findByFirstName(firstname).get().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<User> result = this.userRepository.findByFirstName(firstname).get();
		return new ResponseEntity<List<User>>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Find an user by nickname", response = ResponseEntity.class)
	@RequestMapping(method = RequestMethod.GET, value = "/{nick}")
	@ApiResponses({
		@ApiResponse(code = 200, message = "User founded"),
		@ApiResponse(code = 404, message = "User not found")
	})
	public ResponseEntity<User> findByNickName(@ApiParam(value = "nick to search an user", required = true) 
								@PathVariable String nick) {
		if(!this.userRepository.findByNickName(nick).isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		User result = this.userRepository.findByNickName(nick).get();
		return new ResponseEntity<User>(result, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Updated an existing user")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	@ApiResponses({
		@ApiResponse(code = 204, message = "User updated succesfully"),
	})
	public void update(@ApiParam(value = "Id to find the user", required = true) @PathVariable Long id, 
						@ApiParam(value = "User with data for update", required = true) @RequestBody User input) {
	
		User old = this.userRepository.findOne(id);
		old.setFirstName(input.getFirstName());
		old.setLastname(input.getLastname());
		old.setNickName(input.getNickName());
		old.setPassword(input.getPassword());
		this.userRepository.save(old);
	}
	
	
	@ApiOperation(value = "Delete an existing user")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	@ApiResponses({
		@ApiResponse(code = 204, message = "User deleted succesfully")
	})
	public void delete(@ApiParam(value = "Id to find and delete the user", required = true) @PathVariable Long id) {
		this.userRepository.delete(id);
	}
		
	@Autowired
	UserRestController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
