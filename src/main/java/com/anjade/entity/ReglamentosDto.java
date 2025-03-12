package com.anjade.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reglamentos")
@Getter @Setter

public class ReglamentosDto {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String name;
	    private String type;
	    private String path;
	    private String deporte;
	    
	    public ReglamentosDto() {
	        // Constructor vacío requerido por Hibernate
	    }

	    
		public ReglamentosDto(Long id, String name, String type, String path, String deporte) {
			super();
			this.id = id;
			this.name = name;
			this.type = type;
			this.path = path;
			this.deporte = deporte;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public String getDeporte() {
			return deporte;
		}
		public void setDeporte(String deporte) {
			this.deporte = deporte;
		}
	

	
}
