package br.com.navita.patrimonioempresa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.navita.patrimonioempresa.dto.UserDto;
import br.com.navita.patrimonioempresa.repository.UserRepository;
import br.com.navita.patrimonioempresa.view.UserView;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@PostMapping
	public UserView postUser(@Valid @RequestBody UserDto userDto) {
		userRepository.save(userDto.toUser());
		return userDto.toUserView();
	}
	

}
