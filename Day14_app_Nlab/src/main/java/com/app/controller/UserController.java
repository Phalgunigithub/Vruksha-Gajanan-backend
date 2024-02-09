package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.dto.UserDto;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {
	
	@Autowired
	private UserService uService;


	@PostMapping("/create")
	public ResponseEntity<?> addNewUser(@RequestBody @Valid UserDto dto) {
		System.out.println("in add user " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(uService.addNewUser(dto));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?>  getList(){
		return ResponseEntity.ok(uService.getAllUsers());
	}

}
