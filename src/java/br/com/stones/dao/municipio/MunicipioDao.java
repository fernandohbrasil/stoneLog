package br.com.stones.dao.municipio;


import br.com.stones.dao.DaoDefault;
import br.com.stones.model.Municipio;

import java.util.List;

public interface MunicipioDao extends DaoDefault{
    
    public abstract Object getMunicipio(int id);
    
    public abstract List<Municipio> buscarTodos();
    public abstract List<Municipio> buscarTodosSC();
    
}
