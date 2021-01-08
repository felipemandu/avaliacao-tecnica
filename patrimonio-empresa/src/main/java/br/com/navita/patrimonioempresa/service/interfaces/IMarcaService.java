package br.com.navita.patrimonioempresa.service.interfaces;

import org.springframework.data.domain.Page;

import br.com.navita.patrimonioempresa.dto.MarcaDto;
import br.com.navita.patrimonioempresa.model.Marca;

public interface IMarcaService {

	
	Marca createMarca(MarcaDto marcaDto);
	
	Marca findMarcaById(String id);
	
	Marca findMarcaByName(String nome);
	
	Marca changeMarcaName(String id, String nome);

	
	Page<Marca> findAllMarcas(Integer page);

}
