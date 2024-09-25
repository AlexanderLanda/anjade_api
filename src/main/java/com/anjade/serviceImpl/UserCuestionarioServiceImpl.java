package com.anjade.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.anjade.entity.CuestionarioDto;
import com.anjade.entity.CuestionarioRespuestaDto;
import com.anjade.entity.UserCuestionarioDto;
import com.anjade.entity.UsuariosDto;
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
	public  List<CuestionarioRespuestaDto> getCuestionarioByUserId(Long id) {
		// TODO Auto-generated method stub
		UsuariosDto user = new UsuariosDto();
		user.setId_user(id);
		 List<UserCuestionarioDto> cuestionario = userCuestionarioRepository.findAllByUsuario(user);
	    return convertToCuestionarioRespuestaDto(cuestionario);
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

	@Override
	public boolean existsCuestionarioForUser(Long userId) {
		UsuariosDto user = new UsuariosDto();
		user.setId_user(userId);
        return userCuestionarioRepository.existsByUsuario(user);
    }
	
	
	private List<CuestionarioRespuestaDto> convertToCuestionarioRespuestaDto(List<UserCuestionarioDto> userCuestionarios) {
        return userCuestionarios.stream()
            .map(uc -> new CuestionarioRespuestaDto(
                uc.getId(),
                uc.getUsuario().getId_user(),
                uc.getCuestionario().getPregunta(),
                uc.getCuestionario().getNombreCampo(),
                uc.getRespuesta()
            ))
            .collect(Collectors.toList());
    }
	

}
