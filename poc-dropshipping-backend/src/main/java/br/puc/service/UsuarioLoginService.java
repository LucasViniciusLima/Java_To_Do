package br.puc.service;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.puc.model.Usuario;
import br.puc.repository.UsuarioRepository;

@Service
public class UsuarioLoginService implements UserDetailsService {

	private final UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioLoginService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email);

		if (usuario == null) {
			throw new UsernameNotFoundException(email);
		}

		return new User(usuario.getEmail(), usuario.getSenha(), emptyList());
	}
}
