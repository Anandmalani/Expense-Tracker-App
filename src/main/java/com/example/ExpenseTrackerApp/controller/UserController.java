package com.example.ExpenseTrackerApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExpenseTrackerApp.entity.Entry;
import com.example.ExpenseTrackerApp.entity.Userr;
import com.example.ExpenseTrackerApp.service.EntryService;
import com.example.ExpenseTrackerApp.service.UserService;

@RestController
@RequestMapping("/signup")
public class UserController {
	
	 private UserService userService;
	
	 @Autowired
	 public UserController(UserService userService) {
		
		this.userService = userService;
	}

//	@GetMapping
//	 public List<Userr> getAllUsers() {
//	     return userService.getAllUsers();
//	 }
	
	 @PostMapping
	 public ResponseEntity<?> signupUser(@RequestBody Userr user) {
//	      userService.saveUser(user);
		 Userr createdUser = userService.saveUser(user);
	        if (createdUser != null) {
	            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	        } else {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create customer");
	        }
	 }
//	 @DeleteMapping("/{id}")
//	 public void deleteUser(@PathVariable Integer id) {
//	     userService.deleteUser(id);
//	 }
	
//	 @GetMapping("/get/{id}")
//		public Userr getUser(@PathVariable Integer id) {
//			return userService.getUser(id);
//			
//		}
//		@PutMapping("/update/{id}")
//		public Userr updateUser(@RequestBody Userr u1 ,@PathVariable Integer id) {
//			return userService.updateUser(u1,id);
//
//			
//			
//		}


}
