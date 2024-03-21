package mx.smartkode.webmvc.dao;

import java.util.List;

import mx.smartkode.webmvc.model.Automovil;

public interface AutomovilDao {
    public Integer ingresaAutomovil(Automovil Automovil); 
	
	public List<Automovil> consultaAutomoviles(); 
	
	public void actualizaAutomovil(Automovil Automovil);
	
	public void eliminaAutomovil(Integer id);
	
	public Automovil consultaAutomovil(Integer id);

}
