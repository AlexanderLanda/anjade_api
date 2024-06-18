	package com.anjade.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjade.entity.AfiliadosCategoriasDto;
import com.anjade.entity.AfiliadosFuncionDto;
import com.anjade.entity.CuestionarioDto;
import com.anjade.entity.CuestionarioFromDto;
import com.anjade.entity.DeportesDto;
import com.anjade.entity.EstadosUsuariosDto;
import com.anjade.entity.FederacionDto;
import com.anjade.entity.LocalidadDto;
import com.anjade.entity.ProvinciaDto;
import com.anjade.entity.TipoDocumentoDto;
import com.anjade.entity.TipoPagoDto;
import com.anjade.entity.UserCuestionarioDto;
import com.anjade.entity.UsuariosDto;
import com.anjade.entity.UsuariosRolDto;
import com.anjade.service.AfiliadosCategoriaService;
import com.anjade.service.AfiliadosFuncionService;
import com.anjade.service.CuestionarioService;
import com.anjade.service.DeportesService;
import com.anjade.service.EstadosUsuariosService;
import com.anjade.service.FederacionService;
import com.anjade.service.LocalidadService;
import com.anjade.service.ProvinciaService;
import com.anjade.service.TipoDocumentoService;
import com.anjade.service.TipoPagoService;
import com.anjade.service.UserCuestionarioService;
import com.anjade.service.UsuariosRolService;
import com.anjade.service.UsuariosService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "${frontend.url}")
public class EntityController {
	
	@Value("${frontend.url}") // Inyecta el valor de frontend.url
    private String frontendUrl;
	
    private static final Logger logger = LoggerFactory.getLogger(EntityController.class);


	@Autowired
	private final AfiliadosFuncionService afiliadosRolService;
	@Autowired
	private final UsuariosRolService usuariosRolService;
	@Autowired
	private final DeportesService deportesService;
	@Autowired
	private final EstadosUsuariosService estadosUsuariosService;
	@Autowired
	private final ProvinciaService provinciaService;
	@Autowired
	private final LocalidadService localidadService;
	@Autowired
	private final AfiliadosCategoriaService afiliadosCategoriaService;
	@Autowired
	private final UserCuestionarioService userCuestionarioService;
	@Autowired
	private final CuestionarioService cuestionarioService;
	@Autowired
	private final FederacionService federacionService;
	@Autowired
	private final TipoPagoService tipoPagoService;
	@Autowired
	private final TipoDocumentoService tipoDocumentoService;
	@Autowired
	private final UsuariosService usuariosService;

	
    
	public EntityController(AfiliadosFuncionService afiliadosRolService,AfiliadosCategoriaService afiliadosCategoriaService, UsuariosRolService usuariosRolService,
			DeportesService deportesService, EstadosUsuariosService estadosUsuariosService, LocalidadService localidadService,ProvinciaService provinciaService,
			CuestionarioService cuestionarioService, UserCuestionarioService userCuestionarioService,FederacionService federacionService,TipoPagoService tipoPagoService,
			TipoDocumentoService tipoDocumentoService,UsuariosService usuariosService) {
		this.usuariosService = usuariosService;
		this.afiliadosRolService = afiliadosRolService;
		this.usuariosRolService = usuariosRolService;
		this.deportesService = deportesService;
		this.estadosUsuariosService = estadosUsuariosService;
		this.provinciaService = provinciaService;
		this.localidadService = localidadService;
		this.afiliadosCategoriaService = afiliadosCategoriaService;
		this.userCuestionarioService = userCuestionarioService;
		this.cuestionarioService = cuestionarioService;
		this.federacionService = federacionService;
		this.tipoDocumentoService = tipoDocumentoService;
		this.tipoPagoService = tipoPagoService;
}
	
	@GetMapping("/apiendpoint")
    public String handleRequest(HttpServletRequest request) {
        String origin = request.getHeader("Origin");
        // Aquí puedes imprimir o registrar la URL de origen para verificarla
        System.out.println("La solicitud proviene de: " + origin);
        
        // Resto del código de manejo de la solicitud...
        
        return "Respuesta de la API";
    }
	
	@GetMapping("/{entity}/{id}")
	public ResponseEntity<Object> getById(@PathVariable String entity, @PathVariable Long id) {
		Object entidad = null;
		switch (entity) {
		case "afiliadosfuncion":
			entidad = afiliadosRolService.getFunctionAfiliadosById(id);
			break;
		case "afiliadoscategoria":
			entidad = afiliadosCategoriaService.getCategoriasAfiliadosById(id);
			break;
		case "usuariosrol":
			entidad = usuariosRolService.getRolesUsuariosById(id);
			break;
		case "deportes":
			entidad = deportesService.getDeportesById(id);
			break;
		case "estadosusuario":
			entidad = estadosUsuariosService.getEstadosUsuariosById(id);
			break;
		case "provincia":
			entidad = provinciaService.getProvinciasById(id);
			break;
		case "localidad":
			entidad = localidadService.getLocalidadById(id);
			break;
		case "cuestionario":
			entidad = cuestionarioService.getCuestionarioById(id);
			break;
		case "usercuestionario":
			entidad = userCuestionarioService.getUserCuestionarioById(id);
			break;
		case "federacion":
			entidad = federacionService.getFederacionById(id);
			break;
		case "tipopago":
			entidad = tipoPagoService.getTipoPagosById(id);
			break;
		case "tipodocumento":
			entidad = tipoDocumentoService.getTipoDocumentoById(id);
			break;
		default:
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entidad no encontrada");
		}
		return ResponseEntity.ok(entidad);	
	}
	
	@GetMapping("/{entity}")
	public ResponseEntity<List<Object>> getAll(@PathVariable String entity) {
		List<Object> entidades = new ArrayList<Object>();
		switch (entity) {
		case "afiliadosfuncion":
			List<AfiliadosFuncionDto> aux  = afiliadosRolService.getAllFunctionAfiliados();
			entidades.addAll(aux);
			break;
		case "afiliadoscategoria":
			List<AfiliadosCategoriasDto> categorias  = afiliadosCategoriaService.getAllCategoriasAfiliados();
			entidades.addAll(categorias);
			break;
		case "usuariosrol":
			List<UsuariosRolDto> users  = usuariosRolService.getAllRolesUsuarios();
			entidades.addAll(users);
			break;
		case "deportes":
			List<DeportesDto> depor  = deportesService.getAllDeportes();
			entidades.addAll(depor);
			break;
		case "estadosusuario":
			List<EstadosUsuariosDto> estados  = estadosUsuariosService.getAllEstadosUsuarios();
			entidades.addAll(estados);
			break;
		case "provincia":
			List<ProvinciaDto> provincias  = provinciaService.getAllProvincias();
			entidades.addAll(provincias);
			break;
		case "localidad":
			List<LocalidadDto> localidades  = localidadService.getAllLocalidades();
			entidades.addAll(localidades);
			break;
		case "cuestionario":
			List<CuestionarioDto> cuestionarios  = cuestionarioService.getAllCuestionarios();
			entidades.addAll(cuestionarios);
			break;
		case "usercuestionario":
			List<UserCuestionarioDto> userCuestionarios  = userCuestionarioService.getAllUserCuestionarios();
			entidades.addAll(userCuestionarios);
			break;
		case "federacion":
			List<FederacionDto> federaciones  = federacionService.getAllFederaciones();
			entidades.addAll(federaciones);
			break;
		case "tipopago":
			List<TipoPagoDto> tipoPagos  = tipoPagoService.getAllTiposPagos();
			entidades.addAll(tipoPagos);
			break;
		case "tipodocumento":
			List<TipoDocumentoDto> tipoDocumentos  = tipoDocumentoService.getAllTipoDocumentoDto();
			entidades.addAll(tipoDocumentos);
			break;
		default:
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(entidades);
		}
		return ResponseEntity.ok(entidades);	
	}
	
	 @PostMapping("/{entity}")
	    public ResponseEntity<Object> saveOrUpdate(@PathVariable String entity, @RequestBody String json) {
		 ObjectMapper objectMapper = new ObjectMapper();   
		 Locale locale ;
		 switch (entity) {
	            case "afiliadosfuncion":
	                try {
	                	List<AfiliadosFuncionDto> afiliadosList = objectMapper.readValue(json, new TypeReference<List<AfiliadosFuncionDto>>(){});
	                    for (AfiliadosFuncionDto afiliadosDto : afiliadosList) {
	                        afiliadosRolService.saveOrUpdate(afiliadosDto);
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                break;
	            case "afiliadoscategoria":
	                try {
	                	List<AfiliadosCategoriasDto> afiliadosList = objectMapper.readValue(json, new TypeReference<List<AfiliadosCategoriasDto>>(){});
	                    for (AfiliadosCategoriasDto afiliadosDto : afiliadosList) {
	                        afiliadosCategoriaService.saveOrUpdate(afiliadosDto);
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                break;
	            case "usuariosrol":
	            	try {
	                	List<UsuariosRolDto> usuariosRolList = objectMapper.readValue(json, new TypeReference<List<UsuariosRolDto>>(){});
	                    for (UsuariosRolDto usuariosRoDto : usuariosRolList) {
	                    	usuariosRolService.saveOrUpdate(usuariosRoDto);
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            	break;
	            case "deportes":
	                try {
	                	DeportesDto deportesList = (DeportesDto) objectMapper.readValue(json, new TypeReference<DeportesDto>(){});
	                    	DeportesDto deportesDto  =  deportesService.saveOrUpdate(deportesList);
	                        return new ResponseEntity<>(deportesDto, HttpStatus.CREATED);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            
	                break;
	            case "estadosusuario":
	            	try {
	                	List<EstadosUsuariosDto> estadosUsuariosList = objectMapper.readValue(json, new TypeReference<List<EstadosUsuariosDto>>(){});
	                    for (EstadosUsuariosDto estadosUsuariosDto : estadosUsuariosList) {
	                    	estadosUsuariosService.saveOrUpdate(estadosUsuariosDto);
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            	break;
	            case "provincia":
	            	try {
	                	List<ProvinciaDto> provinciasList = objectMapper.readValue(json, new TypeReference<List<ProvinciaDto>>(){});
	                    for (ProvinciaDto provinciaDto : provinciasList) {
	                    	provinciaService.saveOrUpdate(provinciaDto);
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            	break;
	            case "localidad":
	            	try {
	                	List<LocalidadDto> localidadesList = objectMapper.readValue(json, new TypeReference<List<LocalidadDto>>(){});
	                    for (LocalidadDto localidadDto : localidadesList) {
	                    	localidadService.saveOrUpdate(localidadDto);
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            	break;	
	            case "cuestionario":
	    			try {
	    				CuestionarioFromDto cuestionario = objectMapper.readValue(json, CuestionarioFromDto.class);
	    				Map<String, Object> mapa = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {});
	    				UsuariosDto getUsuarioDto = usuariosService.getByIdAfiliacion(String.valueOf(mapa.get("idAfiliacion")));
	    				if (getUsuarioDto!=null) {
	    					List<CuestionarioDto> cuestionarios = cuestionarioService.getAllCuestionarios();
		    				for (CuestionarioDto cuestionarioDto : cuestionarios) {
		    					UserCuestionarioDto aux = new UserCuestionarioDto(getUsuarioDto,cuestionarioDto,String.valueOf(mapa.get(cuestionarioDto.getNombreCampo())));
							System.out.println(aux.getRespuesta()+"-"+aux.getCuestionario().getPregunta());
							userCuestionarioService.saveOrUpdate(aux);
		    				}
		    				System.out.println("Registro completo");
		    				Map<String, String> response = new HashMap<>();
		    	            response.put("message", "Operación realizada exitosamente");
		    	            return ResponseEntity.ok(response);	
						}
	    				else {
	    					Map<String, String> response = new HashMap<>();
		    	            response.put("message", "No puede enviar el Cuestionario sin Número de Afiliación");
		    	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    				}
	    				
	                } catch (Exception e) {
	                    e.printStackTrace();
	                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", e.getMessage()));
	                }
		case "usercuestionario":
	    			try {
	    				List<UserCuestionarioDto> userCuestionariosList = objectMapper.readValue(json, new TypeReference<List<UserCuestionarioDto>>(){});
	                    for (UserCuestionarioDto cuestionario : userCuestionariosList) {
	                    	userCuestionarioService.saveOrUpdate(cuestionario);
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	    			break;
	    		case "federacion":
	    			try {
	    				List<FederacionDto> feracionList = objectMapper.readValue(json, new TypeReference<List<FederacionDto>>(){});
	                    for (FederacionDto federacion : feracionList) {
	                    	federacionService.saveOrUpdate(federacion);
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	    			break;
	            
	            default:
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entidad no encontrada");
	        }
	        return ResponseEntity.ok("Operación realizada exitosamente");
	    }

	    @DeleteMapping("/{entity}/{id}")
	    public ResponseEntity<Object> delete(@PathVariable String entity, @PathVariable Long id) {
	        switch (entity) {
	            case "afiliadosfuncion":
	                afiliadosRolService.delete(id);
	                break;
	            case "afiliadoscategoria":
	                afiliadosRolService.delete(id);
	                break;
	            case "usuariosrol":
	                usuariosRolService.delete(id);
	                break;
	            case "deportes":
	                deportesService.delete(id);
	                break;
	            case "estadosusuario":
	                estadosUsuariosService.delete(id);
	                break;
	            case "provincia":
	                provinciaService.delete(id);
	                break;
	            case "localidad":
	                localidadService.delete(id);
	                break;
	            case "cuestionario":
	                cuestionarioService.delete(id);
	                break;
	            case "usercuestionario":
	                userCuestionarioService.delete(id);
	                break;
	            case "federacion":
	                federacionService.delete(id);
	                break;
	            default:
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entidad no encontrada");
	        }
	        return ResponseEntity.ok("Operación realizada exitosamente");
	    }
	
}