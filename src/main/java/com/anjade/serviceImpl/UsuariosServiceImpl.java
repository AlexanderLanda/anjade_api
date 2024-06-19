package com.anjade.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.anjade.entity.AfiliadosFuncionDto;
import com.anjade.entity.UsuariosDto;
import com.anjade.entity.UsuariosRolDto;
import com.anjade.exception.AfiliadosCategoriasNotFoundException;
import com.anjade.exception.UsuariosNotFoundException;
import com.anjade.exception.UsuariosRolNotFoundException;
import com.anjade.repository.AfiliadosFuncionRepository;
import com.anjade.repository.UsuariosRepository;
import com.anjade.repository.UsuariosRolRepository;
import com.anjade.service.AfiliadosFuncionService;
import com.anjade.service.UsuariosRolService;
import com.anjade.service.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService {


	private final PasswordEncoder passwordEncoder;

 
	private final UsuariosRepository usuarioRepository;
	
	@Autowired
    public UsuariosServiceImpl(UsuariosRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }
	
	
	@Override
	public List<UsuariosDto> getAllUsuarios() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public UsuariosDto getUsuariosById(Long id) {
		UsuariosDto usuario = usuarioRepository.findById(id).orElseThrow(() -> new UsuariosNotFoundException("Usuario no encontrado"));
	    return usuario;
	}

	@Override
	public UsuariosDto saveOrUpdate(UsuariosDto user) {
		
		user.setFechaAfiliacion(new Date());
		long totalUsuarios = usuarioRepository.count();
        String numeroAfiliacion = String.format("AF%06d", totalUsuarios + 1061);
        user.setIdAfiliacion(numeroAfiliacion);
		if((user.getPassword()!=null&&!user.getPassword().isEmpty())&&user.getPassword().length()<25) {
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
		}
		return usuarioRepository.save(user);		
	}

	@Override
	public void delete(UsuariosDto rol) {
		usuarioRepository.delete(rol);
		
	}
	
	@Override
	public void deleteById(Long rol) {
		usuarioRepository.deleteById(rol);
		
	}


	@Override
	public UsuariosDto getByIdAfiliacion(String idAfiliacion) {
		// TODO Auto-generated method stub
		UsuariosDto usuario = usuarioRepository.findByIdAfiliacion(idAfiliacion);

		return  usuario;
		}


	@Override
	public Optional<UsuariosDto> login(String idAfiliacion, String password) {
		 Optional<UsuariosDto> user = Optional.ofNullable(usuarioRepository.findByIdAfiliacion(idAfiliacion));
	        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword()) && user.get().getEstadoCuenta().getEstado().equalsIgnoreCase("Aprobado")) {
	            return user;
	        }
	        return Optional.empty();
	    }
	
	@Override
	public boolean emailExists(String email) {
        return usuarioRepository.findByCorreo(email).isPresent();
    }

	@Override
	public boolean idAfiliacionExists(String id) {
		Optional<UsuariosDto> user = Optional.ofNullable(usuarioRepository.findByIdAfiliacion(id));
		if (user.isPresent()) {
			return true;
		}
		else {
			return false;
		}
		
        
    }

	
//passwordEncoder.matches(password, user.get().getPassword())
	//password.equalsIgnoreCase(user.get().getPassword())  

}
