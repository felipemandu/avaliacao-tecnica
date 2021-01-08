package br.com.navita.patrimonioempresa.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.navita.patrimonioempresa.dto.PatrimonioDto;
import br.com.navita.patrimonioempresa.model.Patrimonio;
import br.com.navita.patrimonioempresa.service.interfaces.IPatrimonioService;
import br.com.navita.patrimonioempresa.utils.mapper.PatrimonioMapper;
import br.com.navita.patrimonioempresa.view.PatrimonioView;

@RestController
@RequestMapping("/api/patrimonio")
public class PatrimonioResource {

	private IPatrimonioService patrimonioService;

	@Autowired
	public PatrimonioResource(IPatrimonioService patrimonioService) {
		this.patrimonioService = patrimonioService;
	}

	@PostMapping(produces = "application/json")
	public PatrimonioView postPatrimonio(@Valid @RequestBody PatrimonioDto patrimonioDto) {
		var patrimonio = patrimonioService.createPatrimonio(patrimonioDto);
		return PatrimonioMapper.viewFromModel(patrimonio);
	}

	@GetMapping(value = "/numeroDeTombo/{numeroDeTombo}", produces = "application/json")
	public PatrimonioView getByNumeroDeTombo(@PathVariable("numeroDeTombo") @Min(12) String numeroDeTombo) {
		var patrimonio = patrimonioService.findByNumeroDeTombo(numeroDeTombo);
		return PatrimonioMapper.viewFromModel(patrimonio);
	}

	@GetMapping(value = "/marcaNome/{marcaNome}", produces = "application/json")
	public Page<PatrimonioView> getPatrimonioByMarcaNome(@PathVariable("marcaNome") @NotBlank @Min(2) String nome,
			@PathParam("page") Integer page) {
		Page<Patrimonio> patrimonios = patrimonioService.findByMarcaNome(nome, page);
		return pagePatrimonioViewFromPagePatrimonio(patrimonios);
	}


	@GetMapping(value = "/marcaId/{marcaId}", produces = "application/json")
	public Page<PatrimonioView> getPatrimonioByMarcaId(@PathVariable("marcaId") @NotBlank @Min(12) String id,
			@PathParam("page") Integer page) {
		Page<Patrimonio> patrimonios = patrimonioService.findByMarcaId(id, page);
		return pagePatrimonioViewFromPagePatrimonio(patrimonios);
	}

	@GetMapping(value = "/marcaNome/", produces = "application/json")
	public Page<PatrimonioView> getPatrimonioByMarcaNomeLike(@PathParam("marcaNomeLike") @NotBlank @Min(12) String nome, 
			@PathParam("page") Integer page) {
		Page<Patrimonio> patrimonios = patrimonioService.findByMarcaNomeLike(nome, page);
		return pagePatrimonioViewFromPagePatrimonio(patrimonios);
	}

	@GetMapping(value = "/descricao/{descricao}", produces = "application/json")
	public Page<PatrimonioView> getPatrimonioByDescricaoLike(@PathVariable("descricao") @NotBlank String descricao,
			@PathParam("page") Integer page) {
		Page<Patrimonio> patrimonios = patrimonioService.findByDescricaoLike(descricao, page);
		return pagePatrimonioViewFromPagePatrimonio(patrimonios);
	}
	
	@PutMapping(value ="/{numeroDeTombo}")
	public PatrimonioView putPatrimonioById(@PathVariable("numeroDeTombo") String numeroDeTombo, @Valid @RequestBody PatrimonioDto patrimonioDto) {
		var patrimonio = patrimonioService.changePatrimonio(patrimonioDto, numeroDeTombo);
		return PatrimonioMapper.viewFromModel(patrimonio);
	}
	
	@DeleteMapping(value = "/{numeroDeTombo}")
	public ResponseEntity<String> deletePatrimonioByNumeroDeTombo(@PathVariable("numeroDeTombo") String numeroDeTombo) {
		patrimonioService.deletePatrimonioByNumeroDeTombo(numeroDeTombo);
		return ResponseEntity.ok("Deletado o patrimônio com número de Tombo: " + numeroDeTombo);
	}

	private Page<PatrimonioView> pagePatrimonioViewFromPagePatrimonio(Page<Patrimonio> patrimonios) {
		List<PatrimonioView> patrimoniosView = patrimonios.stream()
				.map(p -> PatrimonioMapper.viewFromModel(p))
				.collect(Collectors.toList());
		return new PageImpl<PatrimonioView>(patrimoniosView, patrimonios.getPageable(), patrimonios.getTotalElements());
	}
}
