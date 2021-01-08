package br.com.navita.patrimonioempresa.service.interfaces;

import br.com.navita.patrimonioempresa.dto.UserDto;
import br.com.navita.patrimonioempresa.model.UserModel;

public interface IUserService {

	UserModel createUser(UserDto userDto);
}
