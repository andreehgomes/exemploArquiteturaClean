package br.com.systemmcr.dataproviders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systemmcr.dataproviders.model.UsuarioDB;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioDB, Long> {

}
