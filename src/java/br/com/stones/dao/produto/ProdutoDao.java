package br.com.stones.dao.produto;

import br.com.stones.dao.DaoDefault;
import br.com.stones.model.Produto;
import java.util.List;

public interface ProdutoDao extends DaoDefault{
    
    public abstract List<Produto> buscarTodos();
    
    public abstract Object getProduto(int id);
    
}
