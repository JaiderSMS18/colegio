package com.colegio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.colegio.entidades.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

	List<Estudiante> findByUsuario(int usuarioId);
}
