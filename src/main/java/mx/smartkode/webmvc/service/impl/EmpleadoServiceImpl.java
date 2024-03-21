package mx.smartkode.webmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import mx.smartkode.webmvc.Constantes;
import mx.smartkode.webmvc.dao.EmpleadoDao;
import mx.smartkode.webmvc.exception.ServiceException;
import mx.smartkode.webmvc.model.Empleado;
import mx.smartkode.webmvc.service.EmpleadoService;

@Service("empleadoService")
public class EmpleadoServiceImpl implements EmpleadoService{
    public Log log = LogFactory.getLog(EmpleadoServiceImpl.class);

    @Autowired
    private EmpleadoDao EmpleadoDao;

    @Override
    public List<Empleado> consultaEmpleados() throws ServiceException {
        List<Empleado> Empleados = null;
		try {
			Empleados = EmpleadoDao.consultaEmpleados();
		} catch (Exception e) {
			log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_CONSULTA, "Error al consultar registros");
		}
		return Empleados;    
    }

    @Override
    public Empleado consultaEmpleado(Integer id) throws ServiceException {
        Empleado Empleado = null;
		try {
			Empleado = EmpleadoDao.consultaEmpleado(id);
		} catch (Exception e) {
			log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_CONSULTA, "Error al consultar registro");
		}
		return Empleado;
    }

    @Override
    public Integer ingresaEmpleado(Empleado Empleado) throws ServiceException {
        Integer id = null;
        try {
            id = EmpleadoDao.ingresaEmpleado(Empleado);
        } catch (Exception e) {
            log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_AGREGAR, "Error al agregar Empleado");
        }
        return id;
    }

    @Override
    public void actualizaEmpleado(Empleado Empleado) throws ServiceException {
        try {
            if (Empleado.getId() == null) {
				throw new RuntimeException("Es requerido el ID.");
            }
            else {
                Empleado consulta = this.consultaEmpleado(Empleado.getId());
                if (consulta == null) {
					throw new RuntimeException("El Empleado no existe."); 
                }
                EmpleadoDao.actualizaEmpleado(Empleado);
            }
        } catch (Exception e) {
            log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			if(e instanceof RuntimeException) {
				throw new ServiceException(Constantes.ERROR_EDITAR, "Error al actualizar Empleado, "+e.getMessage());
			}
			throw new ServiceException(Constantes.ERROR_EDITAR, "Error al actualizar Empleado");
        }     
    } 

    @Override
    public void eliminaEmpleado(Integer id) throws ServiceException {
        try {
			EmpleadoDao.eliminaEmpleado(id);
		} catch (Exception e) {
			log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_EDITAR, "Error al eliminar Empleado");
		}
    }
    
}
