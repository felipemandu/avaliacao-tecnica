package br.com.navita.patrimonioempresa.utils.mapper;

import br.com.navita.patrimonioempresa.dto.UserDto;
import br.com.navita.patrimonioempresa.model.UserModel;
import br.com.navita.patrimonioempresa.view.UserView;

public class UserMapper {

	public static UserModel modelFromDto(UserDto userDto) {
		UserModel user = new UserModel();
		user.setEmail(userDto.getEmail());
		user.setNome(userDto.getNome());
		user.setSenha(userDto.getSenha());
		user.setEnabled(true);
		return user;
	}
	
	public static UserView viewFromModel(UserModel user) {
		return new UserView(user.getEmail(), user.getNome());
	}
}
