package br.com.navita.patrimonioempresa.utils.mapper;

import br.com.navita.patrimonioempresa.dto.PatrimonioDto;
import br.com.navita.patrimonioempresa.model.Marca;
import br.com.navita.patrimonioempresa.model.Patrimonio;
import br.com.navita.patrimonioempresa.view.PatrimonioView;

public class PatrimonioMapper {

	public static Patrimonio modelFromDto(PatrimonioDto patrimonioDto, Marca marcaId) {
		Patrimonio patrimonio = new Patrimonio();
		patrimonio.setNome(patrimonioDto.getNome());
		patrimonio.setMarcaId(marcaId);
		patrimonio.setDescricao(patrimonioDto.getDescricao());
		return patrimonio;
	}
	
	public static PatrimonioView viewFromModel(Patrimonio patrimonio) {
		return new PatrimonioView(patrimonio.getNome(), 
				patrimonio.getNumeroDoTombo().toString(), 
				patrimonio.getDescricao(), 
				MarcaMapper.viewFromModel(patrimonio.getMarca()));
	}
}
