package br.com.systemmcr.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.systemmcr.core.model.UsuarioRegra;
import br.com.systemmcr.dataproviders.db.IUsuario;

public class NovoUsuarioUseCase implements INovoUsuario {
	
	@Autowired
	private IUsuario usuario;

	@Override
	public UsuarioRegra inserir(UsuarioRegra usuarioRegra) {
		return usuario.inserirBanco(usuarioRegra);
	}

}
