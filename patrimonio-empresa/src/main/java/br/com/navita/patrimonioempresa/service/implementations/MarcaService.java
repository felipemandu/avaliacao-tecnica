package br.com.navita.patrimonioempresa.service.implementations;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.navita.patrimonioempresa.dto.MarcaDto;
import br.com.navita.patrimonioempresa.exceptions.MarcaAlreadyExistsException;
import br.com.navita.patrimonioempresa.exceptions.MarcaNotFoundException;
import br.com.navita.patrimonioempresa.model.Marca;
import br.com.navita.patrimonioempresa.repository.MarcaRepository;
import br.com.navita.patrimonioempresa.service.interfaces.IMarcaService;
import br.com.navita.patrimonioempresa.utils.mapper.MarcaMapper;

@Service
public class MarcaService implements IMarcaService{
	
	@Value("${model.pages.size:10}")
	private Integer SIZE_PAGES;
	
	private MarcaRepository marcaRepository;

	@Autowired
	public MarcaService(MarcaRepository marcaRepository) {
		this.marcaRepository = marcaRepository;
	}

	@Override
	@CacheEvict(value="marcas", allEntries=true)
	public Marca createMarca(MarcaDto marcaDto) {
		if(marcaRepository.findByNome(marcaDto.getNome()).isPresent()) {
			throw new MarcaAlreadyExistsException("Já existe uma marca com o nome informado: " + marcaDto.getNome());
		}
		var marca = MarcaMapper.modelFromDto(marcaDto);
		return marcaRepository.save(marca);
	}

	@Override
	public Marca findMarcaById(String id) {
		var marcaOptional = marcaRepository.findById(UUID.fromString(id));
		return marcaOptional.orElseThrow(() -> new MarcaNotFoundException("Não existe marca com o id Informado"));
	}


	@Override
	public Marca findMarcaByName(String nome) {
		var marcaOptional = marcaRepository.findByNome(nome);
		return marcaOptional.orElseThrow(() -> new MarcaNotFoundException("Não existe marca com o nome Informado"));
	}

	@Override
	public Marca changeMarcaName(String id, String nome) {
		var marcaOptional = marcaRepository.findById(UUID.fromString(id));
		var marca = marcaOptional.orElseThrow(() -> new MarcaNotFoundException("Não existe marca com o id Informado"));
		marca.setNome(nome);
		return marcaRepository.save(marca);
	}

	
	@Override
	@Cacheable("marcas")
	public Page<Marca> findAllMarcas(Integer page) {
		PageRequest pageRequest = PageRequest.of(page, SIZE_PAGES, Sort.by(Direction.ASC, "nome"));
		return marcaRepository.findAll(pageRequest);
	}

	

}
