package com.colegio.estudiante.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.colegio.estudiante.entidades.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

	@Query(value = "select * from estudiante where estudiante.usuario_id=:id", nativeQuery=true)
	List<Estudiante> findByUsuario(@Param("id")int usuarioId);
}
