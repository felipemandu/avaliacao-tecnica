package br.com.navita.patrimonioempresa.service.implementations;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.navita.patrimonioempresa.dto.PatrimonioDto;
import br.com.navita.patrimonioempresa.exceptions.MarcaNotFoundException;
import br.com.navita.patrimonioempresa.exceptions.PatrimonioNotFoundException;
import br.com.navita.patrimonioempresa.model.Marca;
import br.com.navita.patrimonioempresa.model.Patrimonio;
import br.com.navita.patrimonioempresa.repository.MarcaRepository;
import br.com.navita.patrimonioempresa.repository.PatrimonioRepository;
import br.com.navita.patrimonioempresa.service.interfaces.IPatrimonioService;
import br.com.navita.patrimonioempresa.utils.mapper.PatrimonioMapper;

@Service

public class PatrimonioService implements IPatrimonioService {

	@Value("${model.pages.size:10}")
	private Integer SIZE_PAGES;

	private PatrimonioRepository repository;
	private MarcaRepository marcaRepository;

	@Autowired
	public PatrimonioService(PatrimonioRepository patrimonioRepository, MarcaRepository marcaRepository) {
		this.repository = patrimonioRepository;
		this.marcaRepository = marcaRepository;
	}

	@Override
	public Patrimonio createPatrimonio(PatrimonioDto patrimonioDto) {
		String marcaId = patrimonioDto.getMarcaId();
		var marcaOptional = marcaRepository.findById(UUID.fromString(marcaId));
		var marca = getMarcaFromOptionalOrThrowException(marcaOptional);

		var patrimonio = PatrimonioMapper.modelFromDto(patrimonioDto, marca);
		marca.addPatrimonio(patrimonio);
		marcaRepository.save(marca);
		return patrimonio;
	}

	@Override
	public Patrimonio findByNumeroDeTombo(String numeroDeTombo) {
		var patrimonioOptional = repository.findById(UUID.fromString(numeroDeTombo));
		throwExpectionIfPatrimonioNotFound(patrimonioOptional,
				"Não foi encontrado patrimônio com número de tombo informado");
		return patrimonioOptional.get();
	}

	@Override
	public Page<Patrimonio> findByMarcaNome(String nome, Integer page) {
		var pageRequest = PageRequest.of(page, SIZE_PAGES, Sort.by(Direction.ASC, "numeroDoTombo"));
		return repository.findByMarcaNome(nome, pageRequest);
	}

	@Override
	public Page<Patrimonio> findByMarcaId(String id, Integer page) {
		var pageRequest = PageRequest.of(page, SIZE_PAGES, Sort.by(Direction.ASC, "numeroDoTombo"));
		return repository.findByMarcaId(UUID.fromString(id), pageRequest);
	}

	@Override
	public Page<Patrimonio> findByMarcaNomeLike(String nome, Integer page) {
		var pageRequest = PageRequest.of(page, SIZE_PAGES, Sort.by(Direction.ASC, "numeroDoTombo"));
		return repository.findByMarcaNomeLike(nome, pageRequest);
	}

	@Override
	public Page<Patrimonio> findByDescricaoLike(String descricao, Integer page) {
		var pageRequest = PageRequest.of(page, SIZE_PAGES, Sort.by(Direction.ASC, "numeroDoTombo"));
		return repository.findByDescricaoLike(descricao, pageRequest);
	}

	@Override
	public Patrimonio changePatrimonio(PatrimonioDto patrimonioDto, String numeroDeTombo) {
		var patrimonioOptional = repository.findById(UUID.fromString(numeroDeTombo));
		throwExpectionIfPatrimonioNotFound(patrimonioOptional,
				"Não foi encontrado patrimônio com número de tombo informado");
		var patrimonio = patrimonioOptional.get();
		updatePatrimonio(patrimonioDto, patrimonio);
		repository.save(patrimonio);
		return patrimonio;
	}

	@Override
	public void deletePatrimonioByNumeroDeTombo(String numeroDeTombo) {
		var patrimonio = repository.findById(UUID.fromString(numeroDeTombo));
		if (patrimonio.isEmpty()) {
			throw new PatrimonioNotFoundException("Não foi encontrando patrimônio com o número de tombo informado.");
		}
		repository.delete(patrimonio.get());
	}

	private void throwExpectionIfPatrimonioNotFound(Optional<Patrimonio> patrimonioOptional, String msg) {
		if (patrimonioOptional.isEmpty()) {
			throw new PatrimonioNotFoundException(msg);
		}
	}

	private Marca getMarcaFromOptionalOrThrowException(Optional<Marca> marcaOp) {
		if (marcaOp.isEmpty()) {
			throw new MarcaNotFoundException("Não encontrada marca com o id informado.");
		}
		var marca = marcaOp.get();
		return marca;
	}

	private void updatePatrimonio(PatrimonioDto patrimonioDto, Patrimonio patrimonio) {
		patrimonio.setNome(patrimonioDto.getNome());
		patrimonio.setDescricao(patrimonioDto.getDescricao());
	}
}
