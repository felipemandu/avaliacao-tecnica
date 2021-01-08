package br.com.navita.patrimonioempresa.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.navita.patrimonioempresa.dto.UserDto;
import br.com.navita.patrimonioempresa.exceptions.UserAlreadyExistException;
import br.com.navita.patrimonioempresa.model.UserModel;
import br.com.navita.patrimonioempresa.repository.UserRepository;
import br.com.navita.patrimonioempresa.service.interfaces.IUserService;
import br.com.navita.patrimonioempresa.utils.mapper.UserMapper;

@Service
public class UserService implements IUserService{
	
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserModel createUser(UserDto userDto) {
		throwExceptionIfUserAlreadyExists(userDto);
		return userRepository.save(UserMapper.modelFromDto(userDto));
	}

	private void throwExceptionIfUserAlreadyExists(UserDto userDto) {
		if (userRepository.findById(userDto.getEmail()).isPresent()) {
			throw new UserAlreadyExistException("Já existe usuário com email informado.");
		}
	}
	

	

}
