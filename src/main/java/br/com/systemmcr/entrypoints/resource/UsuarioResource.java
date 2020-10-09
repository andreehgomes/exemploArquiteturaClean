package br.com.systemmcr.entrypoints.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systemmcr.core.model.UsuarioRegra;
import br.com.systemmcr.core.usecase.INovoUsuario;
import br.com.systemmcr.entrypoints.model.UsuarioHttp;

@RestController
@RequestMapping(value = "/api/usuario")
public class UsuarioResource {
	
	@Autowired
	private INovoUsuario novoUsuario;
	
	@PostMapping
	public ResponseEntity<UsuarioHttp> inserir(@Valid @RequestBody UsuarioHttp usuarioHttp) {
		UsuarioRegra usuarioRegra = novoUsuario.inserir(converter(usuarioHttp));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(converterUsuario(usuarioRegra));		
	}

	private UsuarioRegra converter(UsuarioHttp usuarioHttp) {		
		return UsuarioRegra.builder()
				.email(usuarioHttp.getEmail())
				.senha(usuarioHttp.getSenha())
				.nome(usuarioHttp.getNome())
				.id(usuarioHttp.getId())
				.build();
	}
	
	private UsuarioHttp converterUsuario(UsuarioRegra usuarioRegra) {		
		return UsuarioHttp.builder()
				.email(usuarioRegra.getEmail())
				.senha(usuarioRegra.getSenha())
				.nome(usuarioRegra.getNome())
				.id(usuarioRegra.getId())
				.build();
	}

}
