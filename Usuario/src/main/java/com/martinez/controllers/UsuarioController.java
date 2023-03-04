package com.martinez.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.martinez.entity.Usuario;
import com.martinez.modelo.Estudiante;
import com.martinez.modelo.Materia;
import com.martinez.service.IUsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		return ResponseEntity.ok(usuarioService.listarUsuarios());
	}
	
	@PostMapping
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
		return new ResponseEntity<Usuario>(usuarioService.guardar(usuario), HttpStatus.CREATED);
	}
	
	@GetMapping("/materias/{usuarioId}")
	public ResponseEntity<List<Materia>> listarMaterias(@PathVariable("usuarioId") Long id){
		
		if(usuarioService.encontrarUsuario((int) (long)id) == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuarioService.listarMaterias(id));
	}
	
	
	@GetMapping("/perfilDelEstudiante/{usuarioId}")
	public ResponseEntity<List<Estudiante>> listarEstudiantes(@PathVariable("usuarioId") Integer id){
		return ResponseEntity.ok(usuarioService.listarEstudiantes(id));
	}
}
