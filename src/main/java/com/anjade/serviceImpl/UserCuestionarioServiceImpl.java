package com.anjade.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anjade.entity.CuestionarioDto;
import com.anjade.entity.UserCuestionarioDto;
import com.anjade.exception.AfiliadosCategoriasNotFoundException;
import com.anjade.repository.UserCuestionarioRepository;
import com.anjade.service.UserCuestionarioService;

@Service
public class UserCuestionarioServiceImpl implements UserCuestionarioService{

	private final  UserCuestionarioRepository  userCuestionarioRepository;
	
	public UserCuestionarioServiceImpl(UserCuestionarioRepository userCuestionarioRepository) {
		this.userCuestionarioRepository =  userCuestionarioRepository;
	}
	
	@Override
	public List<UserCuestionarioDto> getAllUserCuestionarios() {
		// TODO Auto-generated method stub
		return userCuestionarioRepository.findAll();
	}

	@Override
	public UserCuestionarioDto getUserCuestionarioById(Long id) {
		// TODO Auto-generated method stub
		UserCuestionarioDto cuestionario = userCuestionarioRepository.findById(id).orElseThrow(() -> new AfiliadosCategoriasNotFoundException("Cuestionario para dicho ususario no encontrado"));
	    return cuestionario;
	}

	@Override
	public void saveOrUpdate(UserCuestionarioDto rol) {
		// TODO Auto-generated method stub
		userCuestionarioRepository.save(rol);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		userCuestionarioRepository.deleteById(id);
	}

}
