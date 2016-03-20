package controller;



import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.SiteService;
import entity.User;








@RestController
@RequestMapping("/site")
public class SiteController {
	
	private SiteService siteService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ApiOperation(value = "login user", notes = "login of the user")
	@ApiResponse(code = 200, message = "user was log in successfully")
	String checkLogin(User user) {
		if (siteService.login(user)== true){
			return "Login Succefully";
		}else{
			return "Errors";
		}
	}
	
}