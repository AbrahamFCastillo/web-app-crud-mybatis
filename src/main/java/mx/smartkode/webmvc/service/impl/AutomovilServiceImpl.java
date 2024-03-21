package mx.smartkode.webmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 

import mx.smartkode.webmvc.Constantes;
import mx.smartkode.webmvc.dao.AutomovilDao;
import mx.smartkode.webmvc.exception.ServiceException;
import mx.smartkode.webmvc.model.Automovil;
import mx.smartkode.webmvc.service.AutomovilService;

@Service("automovilService")
public class AutomovilServiceImpl implements AutomovilService{
    @Autowired
    private AutomovilDao AutomovilDao;

	public Log log = LogFactory.getLog(AutomovilServiceImpl.class);

    @Override
    public Integer ingresaAutomovil(Automovil Automovil) throws ServiceException {
        Integer id = null;
        try {
            id = AutomovilDao.ingresaAutomovil(Automovil);
        } catch (Exception e) {
            log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_AGREGAR, "Error al agregar Automovil");
        }
        return id;
    }

    @Override
    public List<Automovil> consultaAutomoviles() throws ServiceException {
        List<Automovil> Automoviles = null;
		try {
			Automoviles = AutomovilDao.consultaAutomoviles();
		} catch (Exception e) {
			log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_CONSULTA, "Error al consultar registros");
		}
		return Automoviles;    
    }

    @Override
    public void actualizaAutomovil(Automovil Automovil) throws ServiceException {
        try {
            if (Automovil.getId() == null) {
				throw new RuntimeException("Es requerido el ID.");
            }
            else {
                Automovil consulta = this.consultaAutomovil(Automovil.getId());
                if (consulta == null) {
					throw new RuntimeException("El Automovil no existe."); 
                }
                AutomovilDao.actualizaAutomovil(Automovil);
            }
        } catch (Exception e) {
            log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			if(e instanceof RuntimeException) {
				throw new ServiceException(Constantes.ERROR_EDITAR, "Error al actualizar Automovil, "+e.getMessage());
			}
			throw new ServiceException(Constantes.ERROR_EDITAR, "Error al actualizar Automovil");
        }    
    }

    @Override
    public void eliminaAutomovil(Integer id) throws ServiceException {
        try {
			AutomovilDao.eliminaAutomovil(id);
		} catch (Exception e) {
			log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_EDITAR, "Error al eliminar Automovil");
		}
    }

    @Override
    public Automovil consultaAutomovil(Integer id) throws ServiceException {
        Automovil Automovil = null;
		try {
			Automovil = AutomovilDao.consultaAutomovil(id);
		} catch (Exception e) {
			log.error("ERROR EN CAPA DE SERVICIO: "+e.getMessage());
			throw new ServiceException(Constantes.ERROR_CONSULTA, "Error al consultar registro");
		}
		return Automovil;
    }
    
}
