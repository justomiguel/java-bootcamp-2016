package controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import org.jboss.logging.annotations.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import service.UserService;
import entity.User;

@RestController
@RequestMapping("/site")
@Api(value = "userService", produces = "application/json")
public class UserController {

	UserService userService;

	@RequestMapping(value = "/singup", method = RequestMethod.POST)
	@ApiOperation(value = "register user", notes = "Registration of the user")
	@ApiResponse(code = 200, message = "user was created successfully")
	public @ResponseBody void createUser(User user) {

		userService.addUser(user);
	}
}
