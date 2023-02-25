package com.colegio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.materias.entidades.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer> {

	List<Materia> findByUsuario(int usuarioId);
}
