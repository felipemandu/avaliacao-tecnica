package br.com.navita.patrimonioempresa.service.interfaces;

import org.springframework.data.domain.Page;

import br.com.navita.patrimonioempresa.dto.PatrimonioDto;
import br.com.navita.patrimonioempresa.model.Patrimonio;

public interface IPatrimonioService {

	Patrimonio createPatrimonio(PatrimonioDto patrimonioDto);
	Patrimonio findByNumeroDeTombo(String numeroDeTombo);
	Patrimonio changePatrimonio(PatrimonioDto patrimonioDto, String numeroDeTombo);
	Page<Patrimonio> findByMarcaNome(String nome, Integer page);
	Page<Patrimonio> findByMarcaId(String id, Integer page);
	Page<Patrimonio> findByMarcaNomeLike(String nome, Integer page);
	Page<Patrimonio> findByDescricaoLike(String descricao, Integer page);
	void deletePatrimonioByNumeroDeTombo(String numeroDeTombo);
	
}
