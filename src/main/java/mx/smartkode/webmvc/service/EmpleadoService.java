package mx.smartkode.webmvc.service;

import java.util.List;

import mx.smartkode.webmvc.exception.ServiceException; 
import mx.smartkode.webmvc.model.Empleado;

public interface EmpleadoService {
    public Integer ingresaEmpleado(Empleado Empleado) throws ServiceException;
	
	public List<Empleado> consultaEmpleados() throws ServiceException; 
	
	public void actualizaEmpleado(Empleado Empleado) throws ServiceException;
	
	public void eliminaEmpleado(Integer id) throws ServiceException;
	
	public Empleado consultaEmpleado(Integer id) throws ServiceException;
}
