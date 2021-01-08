package br.com.navita.patrimonioempresa.utils.mapper;

import br.com.navita.patrimonioempresa.dto.MarcaDto;
import br.com.navita.patrimonioempresa.model.Marca;
import br.com.navita.patrimonioempresa.view.MarcaView;

public class MarcaMapper {

	public static Marca modelFromDto(MarcaDto marcaDto) {
		Marca marca = new Marca();
		marca.setNome(marcaDto.getNome());
		return marca;
	}
	
	public static MarcaView viewFromModel(Marca marca) {
		return new MarcaView(marca.getNome(), marca.getMarcaId().toString());
	}

}
