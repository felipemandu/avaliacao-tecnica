package br.com.navita.patrimonioempresa.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.navita.patrimonioempresa.dto.UserDto;
import br.com.navita.patrimonioempresa.exceptions.UserAlreadyExistException;
import br.com.navita.patrimonioempresa.service.interfaces.IUserService;
import br.com.navita.patrimonioempresa.utils.mapper.UserMapper;
import br.com.navita.patrimonioempresa.view.UserView;

@RestController
@RequestMapping("/api/user")
public class UserResource {
	
	private IUserService userService;

	@Autowired
	public UserResource(IUserService userService) {
		this.userService = userService;
	}

	@PostMapping( produces = "application/json")
	public UserView postUser(@Valid @RequestBody UserDto userDto) throws UserAlreadyExistException {
		var user = userService.createUser(userDto);
		return UserMapper.viewFromModel(user);
	}
	

}
