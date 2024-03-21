package mx.smartkode.webmvc.dao;

import java.util.List;

import mx.smartkode.webmvc.model.Empleado;

public interface EmpleadoDao {
    public Integer ingresaEmpleado(Empleado empleado);
	
	public List<Empleado> consultaEmpleados();
	
	public void actualizaEmpleado(Empleado empleado);
	
	public void eliminaEmpleado(Integer id);
	
	public Empleado consultaEmpleado(Integer id);
}
