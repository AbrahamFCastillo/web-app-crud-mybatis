package mx.smartkode.webmvc.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import mx.smartkode.webmvc.dao.EmpleadoDao;
import mx.smartkode.webmvc.model.Empleado;

@Repository("empleadoDao") 
public class EmpleadoDaoImpl extends SqlSessionDaoSupport implements EmpleadoDao {

    @Override
    public Integer ingresaEmpleado(Empleado Empleado) {
        getSqlSession().insert("ingresaEmpleado", Empleado);
        return Empleado.getId();
    }

    @Override
    public List<Empleado> consultaEmpleados() {
        return getSqlSession().selectList("consultaEmpleados");
    }

    @Override
    public void actualizaEmpleado(Empleado Empleado) {
        getSqlSession().update("actualizaEmpleado", Empleado);
    }

    @Override
    public void eliminaEmpleado(Integer id) {
		getSqlSession().delete("eliminaEmpleado", id);

    }

    @Override
    public Empleado consultaEmpleado(Integer id) {
        return getSqlSession().selectOne("consultaEmpleado", id);
    }

    
}
