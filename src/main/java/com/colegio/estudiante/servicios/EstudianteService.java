package com.colegio.estudiante.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.estudiante.entidades.Estudiante;
import com.colegio.estudiante.repositorio.EstudianteRepository;

@Service
public class EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;

	public List<Estudiante> getAll() {
		return estudianteRepository.findAll();
	}

	public Estudiante getEstudianteById(int id) {
		return estudianteRepository.findById(id).orElse(null);
	}

	public Estudiante save(Estudiante estudiante) {
		Estudiante nuevaEstudiante = estudianteRepository.save(estudiante);
		return nuevaEstudiante;
	}

	public List<Estudiante> byUsuarioId(int usuarioId) {
		return estudianteRepository.findByUsuario(usuarioId);
	}

}
