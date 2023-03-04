package com.martinez.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.martinez.entity.Usuario;
import com.martinez.modelo.Estudiante;
import com.martinez.modelo.Materia;
import com.martinez.repositorio.IUsuarioDao;
import com.martinez.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioDao usuarioRepo;

	WebClient webClient = WebClient.builder().build();
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listarUsuarios() {
		return usuarioRepo.findAll();
	}

	@Override
	@Transactional
	public Usuario guardar(Usuario usuario) {
		if(findExistByUsernameCognito(usuario.getUser_dni())) {
			return null;
		}
		return usuarioRepo.save(usuario);
	}

	@Override
	@Transactional
	public void eliminar(Integer idUsuario) {
		usuarioRepo.deleteById(idUsuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario encontrarUsuario(Integer idUsuario) {
		return usuarioRepo.findById(idUsuario).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer buscarIdUsuarioByIdentificacionEstudiante(String idEstudiante) {
		return usuarioRepo.findByUser_dni(idEstudiante);
	}

	@Override
	@Transactional
	public boolean findExistUsuario(Integer id) {
		return usuarioRepo.existsById(id);
	}

	@Override
	@Transactional
	public boolean findExistByUsernameCognito(String username) {
		if(usuarioRepo.findByUser_dni(username) != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Materia> listarMaterias(Long usuarioId) {
		List<Materia> materia = webClient.get().uri("http://localhost:8081/materias/usuario/"  + usuarioId).retrieve().bodyToFlux(Materia.class)
															.collectList().block();
		return materia;
	}

	@Override
	public List<Estudiante> listarEstudiantes(int usuarioId) {
	List<Estudiante>  estudiantes = this.webClient.get().uri("http://localhost:8082/perfilDelEstudiante/usuario/" + usuarioId)
														.retrieve()
														.bodyToFlux(Estudiante.class)
														.collectList()
														.block();
		return estudiantes;
	}

}
