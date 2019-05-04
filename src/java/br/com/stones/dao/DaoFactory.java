package br.com.stones.dao;

import br.com.stones.dao.OrdemCompra.OrdemCompraDao;
import br.com.stones.dao.categoria.CategoriaDao;
import br.com.stones.dao.cesta.CestaDao;
import br.com.stones.dao.cliente.ClienteDao;
import br.com.stones.dao.contasReceber.ContasReceberDao;
import br.com.stones.dao.municipio.MunicipioDao;
import br.com.stones.dao.pedidoCliente.PedidoClienteDao;
import br.com.stones.dao.produto.ProdutoDao;

public abstract class DaoFactory {

    public static final int JPA = 1;
    public static final int JDBC = 2;

    public abstract CategoriaDao getCategoriaDao();

    public abstract ProdutoDao getProdutoDao();

    public abstract OrdemCompraDao getOrdemCompraDao();

    public abstract ClienteDao getClienteDao();

    public abstract MunicipioDao getMunicipioDao();

    public abstract CestaDao getCestaDao();
    
    public abstract PedidoClienteDao getPedidoClienteDao();
    
    public abstract ContasReceberDao getContasReceberDao();

    public static DaoFactory getDaoFactory(int tipo) {
        switch (tipo) {
            case JPA: {
                return new JpaDaoFactory();
            }
            case JDBC: {
                return new JdbcDaoFactory();
            }
            default: {
                return null;
            }
        }
    }
}
