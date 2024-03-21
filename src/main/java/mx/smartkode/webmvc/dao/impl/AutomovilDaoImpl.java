package mx.smartkode.webmvc.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import mx.smartkode.webmvc.dao.AutomovilDao; 
import mx.smartkode.webmvc.model.Automovil;

@Repository("automovilDao")
public class AutomovilDaoImpl extends SqlSessionDaoSupport implements AutomovilDao {

    @Override 
    public Integer ingresaAutomovil(Automovil Automovil) {
        getSqlSession().insert("ingresaAutomovil", Automovil);
        return Automovil.getId();
    }

    @Override
    public List<Automovil> consultaAutomoviles() {
        return getSqlSession().selectList("consultaAutomoviles");
    }

    @Override
    public void actualizaAutomovil(Automovil Automovil) {
        getSqlSession().update("actualizaAutomovil", Automovil);
    }

    @Override
    public void eliminaAutomovil(Integer id) {
		getSqlSession().delete("eliminaAutomovil", id);

    }

    @Override
    public Automovil consultaAutomovil(Integer id) {
        return getSqlSession().selectOne("consultaAutomovil", id);
    }

    
}
