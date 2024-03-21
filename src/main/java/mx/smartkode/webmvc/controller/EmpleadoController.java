package mx.smartkode.webmvc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 

import mx.smartkode.webmvc.exception.ServiceException;
import mx.smartkode.webmvc.model.Empleado;
import mx.smartkode.webmvc.service.EmpleadoService;
//import mx.smartkode.webmvc.dto.EmpleadoDto;
//import mx.smartkode.webmvc.service.EmpleadoServiceWeb; Service simulado

@Controller
public class EmpleadoController {

	private static Logger log = Logger.getLogger(EmpleadoController.class);

	@Autowired
	private EmpleadoService empleadoService;
	
	//no index
	@RequestMapping(value="/", method = RequestMethod.GET) // / o /empleados 
	public String listaEmpleados(Model m) throws ServiceException {
		log.info("Lista de empleados...");
		//Service DAO
		List<Empleado> emps = empleadoService.consultaEmpleados();
		m.addAttribute("emps", emps);
		
		return "index";
	}
	
	@RequestMapping(value="/nuevo-empleado", method = RequestMethod.GET)
	public String nuevoEmpleado(Model m) {
		//cuando se accede al form para crear un nuevo empleado, colocar en la plantilla un objeto "empleado" vacio
		m.addAttribute("command", new Empleado());
		return "nuevo-empleado";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String guardarEmpleado(@ModelAttribute("emp") Empleado emp) throws ServiceException {
		// asignacion de id indistinta; se agrega otro al insertar en la bd. Eliminar de la vista label con ID
		empleadoService.ingresaEmpleado(emp);
		return "redirect:/";
	}
	
	@RequestMapping(value="/editar-empleado/{id}", method = RequestMethod.GET)
	public String editarEmpleado(@PathVariable Integer id, Model m) throws ServiceException {
		Empleado emp = empleadoService.consultaEmpleado(id);
		
		m.addAttribute("command", emp);
		return "editar-empleado";
	}
	
	@RequestMapping(value="/editsave", method = RequestMethod.POST) 
	public String guardarEditarEmpleado(@ModelAttribute("emp") Empleado emp) throws ServiceException {
		//Evitar que se pueda editar el ID del empleado en la vista, pues modificaria la información del empleado con dicho ID (no el actual)
		empleadoService.actualizaEmpleado(emp);
		return "redirect:/";
	}
	
	@RequestMapping(value="/eliminar-empleado/{id}", method = RequestMethod.GET)
	public String eliminarEmpleado(@PathVariable Integer id) throws ServiceException {
		
		empleadoService.eliminaEmpleado(id);
		return "redirect:/";
	}
}
