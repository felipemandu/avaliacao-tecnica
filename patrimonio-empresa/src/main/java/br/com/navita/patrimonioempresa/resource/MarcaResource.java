package br.com.navita.patrimonioempresa.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.navita.patrimonioempresa.dto.MarcaDto;
import br.com.navita.patrimonioempresa.model.Marca;
import br.com.navita.patrimonioempresa.service.interfaces.IMarcaService;
import br.com.navita.patrimonioempresa.utils.mapper.MarcaMapper;
import br.com.navita.patrimonioempresa.view.MarcaView;

@RestController
@RequestMapping("/api/marca")
public class MarcaResource {
	
	private IMarcaService marcaService;
	
	@Autowired
	public MarcaResource(IMarcaService marcaService) {
		this.marcaService = marcaService;
	}
	
	@PostMapping(produces = "application/json")
	public MarcaView postMarca(@Valid @RequestBody MarcaDto marcaDto) {
		var marca = marcaService.createMarca(marcaDto);
		return MarcaMapper.viewFromModel(marca);
	}
	
	@GetMapping(value ="/{id}", produces = "application/json")
	public MarcaView getMarcaById(@PathVariable("id") @NotBlank String id) {
		var marca = marcaService.findMarcaById(id);
		return MarcaMapper.viewFromModel(marca);
	}
	
	@GetMapping(produces = "application/json")
	public MarcaView getMarcaByNome(@PathParam("nome") String nome) {
		var marca = marcaService.findMarcaByName(nome);
		return MarcaMapper.viewFromModel(marca);
	}
	
	@GetMapping(value= "/marcas", produces = "application/json")
	public Page<MarcaView> getMarcas(Integer page) {
		Page<Marca> marcas= marcaService.findAllMarcas(page);
		return pageMarcaViewFromPageMarca(marcas);
	}
	
	private Page<MarcaView> pageMarcaViewFromPageMarca(Page<Marca> marcas) {
		List<MarcaView> marcasView = marcas.stream()
											.map(m -> MarcaMapper.viewFromModel(m))
											.collect(Collectors.toList());
		return new PageImpl<MarcaView>(marcasView, marcas.getPageable(), marcas.getNumberOfElements());
	}

	@PatchMapping(value = "/{id}", produces = "application/json")
	public MarcaView patchNomeMarca(@PathVariable("id") String id, @PathParam("nome") String nome) {
		if (nome.trim().isBlank()) { 
			throw new IllegalArgumentException("Nome da empresa não deve ser nulo");
		}		
		var marca = marcaService.changeMarcaName(id, nome);
		return MarcaMapper.viewFromModel(marca);
	}
	
	@PutMapping(value = "/{id}", produces = "application/json")
	public MarcaView putMarca(@Valid @RequestBody MarcaDto marcaDto) {
		return null;
	}
	

}
