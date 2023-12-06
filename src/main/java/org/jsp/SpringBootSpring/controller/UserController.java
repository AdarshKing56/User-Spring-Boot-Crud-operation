package org.jsp.SpringBootSpring.controller;

import java.util.List;

import org.jsp.SpringBootSpring.dto.ResponseStructure;
import org.jsp.SpringBootSpring.dto.User;
import org.jsp.SpringBootSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@PutMapping("/users")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable int id) {
		return userService.findUserById(id);

	}

	@GetMapping("/users")
	public ResponseEntity<ResponseStructure<List<User>>> findAlluser(@RequestBody User user) {
		return userService.findAlluser(user);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}

	@PostMapping("/users/verify-by-phone")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam long phone, @RequestParam String password) {
		return userService.verifyUser(phone, password);
	}

	@PostMapping("/users/verify-by-email")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam String email,
			@RequestParam String password) {
		return userService.verifyUser(email, password);
	}

	@PostMapping("/users/verify-by-id")
	public ResponseEntity<ResponseStructure<User>> verifyUser(@RequestParam int id, @RequestParam String password) {
		return userService.verifyUser(id, password);
	}
	
	//public ResponseEntity<ResponseStructure<User>> 

}
