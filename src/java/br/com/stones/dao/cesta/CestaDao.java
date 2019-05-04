package br.com.stones.dao.cesta;

import br.com.stones.dao.DaoDefault;
import br.com.stones.model.Cesta;
import java.util.List;


public interface CestaDao extends DaoDefault{
    
    public abstract List<Cesta> buscarTodos();
    
}
