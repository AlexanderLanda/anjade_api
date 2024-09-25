package com.anjade.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user_cuestionario")
public class UserCuestionarioDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user")
    private UsuariosDto usuario;

    @ManyToOne
    @JoinColumn(name = "id_pregunta")
    private CuestionarioDto cuestionario;

    @Column(name = "respuesta")
    private String respuesta;

    // Constructor vacío
    public UserCuestionarioDto() {
    }

    // Constructor con todos los campos
    public UserCuestionarioDto(UsuariosDto usuario, CuestionarioDto cuestionario, String respuesta) {
        this.usuario = usuario;
        this.cuestionario = cuestionario;
        this.respuesta = respuesta;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuariosDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosDto usuario) {
        this.usuario = usuario;
    }

    public CuestionarioDto getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(CuestionarioDto cuestionario) {
        this.cuestionario = cuestionario;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}