package br.com.systemmcr.dataproviders.db;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.systemmcr.core.model.UsuarioRegra;
import br.com.systemmcr.dataproviders.model.UsuarioDB;
import br.com.systemmcr.dataproviders.repository.UsuarioRepository;

public class UsuarioDataProvider implements IUsuario {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UsuarioRegra inserirBanco(UsuarioRegra usuarioRegra) {
		UsuarioDB usuarioDB = usuarioRepository.save(converter(usuarioRegra));
		
		return converterUsuario(usuarioDB);
	}

	private UsuarioDB converter(UsuarioRegra usuarioRegra) {
		return UsuarioDB.builder()
				.nome(usuarioRegra.getNome())
				.email(usuarioRegra.getEmail())
				.password(usuarioRegra.getSenha())
				.build();
	}
	
	private UsuarioRegra converterUsuario(UsuarioDB usuarioDB) {
		return UsuarioRegra.builder()
				.nome(usuarioDB.getNome())
				.email(usuarioDB.getEmail())
				.senha(usuarioDB.getPassword())
				.build();
	}

}
