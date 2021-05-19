package com.tutorial.crud.security.service;

import com.tutorial.crud.security.entity.Usuario;
import com.tutorial.crud.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    
    //METODOS AGREGADOS
    public List<Usuario> list(){
    	return usuarioRepository.findAll();
    }
    
    public Optional<Usuario> getOne(int id){
    	return usuarioRepository.findById(id);
    }
    //
    
    public Usuario getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    //public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
      //  return usuarioRepository.findByNombreUsuario(nombreUsuario);
    //}Comentado porque necesitaba quitarle el optional

    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }
    
    public void delete(int id) {
    	usuarioRepository.deleteById(id);
    }
}
