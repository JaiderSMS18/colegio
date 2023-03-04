package com.martinez.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.martinez.entity.Usuario;
import com.martinez.modelo.Estudiante;
import com.martinez.modelo.Materia;

public interface IUsuarioService {

	public List<Usuario> listarUsuarios();
    
    public Usuario guardar(Usuario usuario);
    
    public void eliminar(Integer idUsuario);
    
    public Usuario encontrarUsuario(Integer idUsuario);
    
    public Integer buscarIdUsuarioByIdentificacionEstudiante(String idEstudiante);
    
    public boolean findExistUsuario(Integer id);
    
    public boolean findExistByUsernameCognito(String username);
    
    public List<Materia> listarMaterias(Long usuarioId);
    public List<Estudiante> listarEstudiantes(int usuarioId);
}
