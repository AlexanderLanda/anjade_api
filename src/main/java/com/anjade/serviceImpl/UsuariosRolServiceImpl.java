package com.anjade.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anjade.entity.AfiliadosFuncionDto;
import com.anjade.entity.UsuariosRolDto;
import com.anjade.exception.AfiliadosCategoriasNotFoundException;
import com.anjade.exception.UsuariosRolNotFoundException;
import com.anjade.repository.AfiliadosFuncionRepository;
import com.anjade.repository.UsuariosRolRepository;
import com.anjade.service.AfiliadosFuncionService;
import com.anjade.service.UsuariosRolService;

@Service
public class UsuariosRolServiceImpl implements UsuariosRolService {


	private final UsuariosRolRepository usuariosRolRepository;

    public UsuariosRolServiceImpl(UsuariosRolRepository usuariosRolRepository) {
        this.usuariosRolRepository = usuariosRolRepository;
    }
	
	
	@Override
	public List<UsuariosRolDto> getAllRolesUsuarios() {
		// TODO Auto-generated method stub
		return usuariosRolRepository.findAll();
	}

	@Override
	public UsuariosRolDto getRolesUsuariosById(Long id) {
		 
		UsuariosRolDto afiliadosRol = usuariosRolRepository.findById(id).orElseThrow(() -> new UsuariosRolNotFoundException("Rol de usuario no encontrado"));
	    return afiliadosRol;
	}

	@Override
	public void saveOrUpdate(UsuariosRolDto rol) {

		usuariosRolRepository.save(rol);		
	}

	@Override
	public void delete(Long rol) {
		usuariosRolRepository.deleteById(rol);
		
	}

}
