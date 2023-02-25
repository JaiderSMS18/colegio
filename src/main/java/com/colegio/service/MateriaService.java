package com.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.materias.entidades.Materia;
import com.colegio.repositorio.MateriaRepository;

@Service
public class MateriaService {
	
	@Autowired
	private MateriaRepository materiaRepository;
	
	public List<Materia> getAll(){
		return materiaRepository.findAll();
	}
	
	public Materia getMateriaById(int id) {
		return materiaRepository.findById(id).orElse(null);
	}
	
	public Materia save(Materia materia) {
		Materia nuevaMateria = materiaRepository.save(materia);
		return nuevaMateria;
	}
	
	public List<Materia> byUsuarioId(int usuarioId){
		return materiaRepository.findByUsuario(usuarioId);
	}


}

