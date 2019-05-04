package br.com.stones.dao.categoria;

import br.com.stones.dao.DaoDefault;
import br.com.stones.model.Categoria;
import java.util.List;

public interface CategoriaDao extends DaoDefault{
    
    public abstract Object getCategoria(int id);
    
    public abstract List<Categoria> buscarTodos();
    
}
