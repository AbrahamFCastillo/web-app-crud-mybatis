package mx.smartkode.webmvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder 
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDto {
	private String nombre;
	private String puesto;
	private Integer sueldo;
}
