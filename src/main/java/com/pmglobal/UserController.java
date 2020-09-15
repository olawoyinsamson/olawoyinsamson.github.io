package com.pmglobal;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	
	@Autowired 
	UserService userService;
	

	
	@RequestMapping(method=RequestMethod.POST,value="/users")
	ResponseEntity<Map<String, Object>> newUser(@RequestBody User newUser) {
		User user = userService.addUser(newUser);
		Map<String,Object> response = new HashMap<>();
		response.put("Data", user);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

	@GetMapping("/users")
	List<User> getAll(@RequestParam HashMap<String,String> args) {
		return userService.getAllUser(args);
	}
	
	@GetMapping("/users/{id}")
	Optional<User> getOneUser(@PathVariable int id){
		return userService.getUserById(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users")
	ResponseEntity<Map<String, Object>> updateUser(@RequestBody User newUser) {
		User user = userService.addUser(newUser);
		Map<String,Object> response = new HashMap<>();
		response.put("Data", user);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{id}")
	void deleteUser(@PathVariable int id) {
		System.out.print("About to delete");
		userService.deleteUser(id);
		System.out.print("Delete completed");
	}
	

}
