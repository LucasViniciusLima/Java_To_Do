package br.puc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.puc.model.Usuario;
import br.puc.service.UsuarioService;

/**
 * Cadastro de Clientes.
 */
@RestController
@RequestMapping({ "/usuario" })
public class UsuarioController {
	
	private final UsuarioService usuarioService;

	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	/**
	 * Realiza o cadastro de um novo cliente.
	 * @param usuario
	 */
	@PostMapping("/registrar")
	public void registrar(@RequestBody Usuario usuario) {
		usuarioService.registrar(usuario);
	}

}
