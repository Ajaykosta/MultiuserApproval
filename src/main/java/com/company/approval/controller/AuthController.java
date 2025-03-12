package com.company.approval.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.approval.entity.User;
import com.company.approval.service.IAuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private IAuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody User user) {
		return ResponseEntity.ok(authService.signup(user));
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {
		return ResponseEntity.ok(authService.login(user));
	}
}
