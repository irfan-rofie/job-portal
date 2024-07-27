package com.dans.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.dans.java.dto.LoginDto;
import com.dans.java.model.User;
import com.dans.java.repository.UserRepository;

@Service
public class LoginService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	public User login(LoginDto dto) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));

		return userRepository.findByUsername(dto.getUsername()).orElseThrow(null);
	}
}
