package br.com.systemmcr.core.model;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRegra {

	@Id
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotBlank
	private String nome;
		
	@NotBlank
	private String email;
	
	@NotBlank
	private String senha;
}
