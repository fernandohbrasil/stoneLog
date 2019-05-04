package br.com.stones.dao.cliente;

import br.com.stones.dao.DaoDefault;
import br.com.stones.model.Cliente;
import java.util.List;

public interface ClienteDao extends DaoDefault{
    
    public abstract Object getCliente(int id);
    
    public abstract List<Cliente> buscarTodos();
    
    public abstract boolean cpfExistente(String cpf);
    
}
