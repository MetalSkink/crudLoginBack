package com.tutorial.crud.security.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.crud.dto.Mensaje;

import com.tutorial.crud.security.dto.NuevoUsuario;
import com.tutorial.crud.security.entity.Rol;
import com.tutorial.crud.security.entity.Usuario;
import com.tutorial.crud.security.enums.RolNombre;
import com.tutorial.crud.security.jwt.JwtProvider;
import com.tutorial.crud.security.service.RolService;
import com.tutorial.crud.security.service.UsuarioService;


@RestController
@RequestMapping("/auth2")
@CrossOrigin
public class SecureController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> list(){
		List<Usuario> list = usuarioService.list();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{nombre}")
	public ResponseEntity<Usuario> getById(@PathVariable("nombre") String nombre){
		//if(!usuarioService.existsById(id))
			//return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		//Usuario usuario = usuarioService.getOne(id).get();
		Usuario usuario = usuarioService.getByNombreUsuario(nombre);
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")int id){
		usuarioService.delete(id);
		return new ResponseEntity(new Mensaje("usuario eliminado"), HttpStatus.OK);
	}
	
}
