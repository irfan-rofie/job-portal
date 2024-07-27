package com.dans.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dans.java.service.LoginService;
import com.dans.java.dto.LoginDto;
import com.dans.java.model.User;
import com.dans.java.response.LoginResponse;
import com.dans.java.service.JwtService;

@RestController
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	private JwtService jwtService;
    
	@Autowired
    private LoginService loginService;
	
	@PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginDto loginDto) {
        User user = loginService.login(loginDto);

        String jwtToken = jwtService.generateToken(user);

        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());
        
        return ResponseEntity.ok(loginResponse);
    }
}
