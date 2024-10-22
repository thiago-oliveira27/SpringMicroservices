package com.spring.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hruser.entities.User;
import com.spring.hruser.services.UserService;

@RestController
@RequestMapping(value= "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) throws Exception{	
		User worker = userService.findById(id);
		return ResponseEntity.ok(worker);
	}
	
	@GetMapping(value="/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email) throws Exception{	
		User user;
		try {
			 user = userService.findByEmail(email);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("Error-Message", "User with email " + email + " not found.")
                    .build();
		}
		return ResponseEntity.ok(user);
	}
	
}
