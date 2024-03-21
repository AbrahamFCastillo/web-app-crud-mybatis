package mx.smartkode.webmvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {

	private Integer id;
	private String nombre; 
	private String puesto;
	private Integer sueldo;
}