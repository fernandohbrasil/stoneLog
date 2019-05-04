package br.com.stones.dao;

import br.com.stones.dao.OrdemCompra.OrdemCompraDao;
import br.com.stones.dao.OrdemCompra.OrdemCompraJdbc;
import br.com.stones.dao.categoria.CategoriaDao;
import br.com.stones.dao.categoria.CategoriaJdbc;
import br.com.stones.dao.cesta.CestaDao;
import br.com.stones.dao.cesta.CestaJdbc;
import br.com.stones.dao.cliente.ClienteDao;
import br.com.stones.dao.cliente.ClienteJdbc;
import br.com.stones.dao.contasReceber.ContasReceberDao;
import br.com.stones.dao.contasReceber.ContasReceberJdbc;
import br.com.stones.dao.municipio.MunicipioDao;
import br.com.stones.dao.municipio.MunicipioJdbc;
import br.com.stones.dao.pedidoCliente.PedidoClienteDao;
import br.com.stones.dao.pedidoCliente.PedidoClienteJdbc;
import br.com.stones.dao.produto.ProdutoDao;
import br.com.stones.dao.produto.ProdutoJdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDaoFactory extends DaoFactory{

    private static Connection conexao;

    private static Connection createConexao() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@//10.60.30.18:1521/XE", "interdisciplinar", "interdisciplinar");
            return conexao;
        } catch (Exception e) {
            return null;
        }
    }

    public static Connection fechaConexao() throws SQLException {
        if (conexao != null) {
            conexao.close();
        }
        return conexao;
    }

    public static Connection abreConexao() throws SQLException {
        return conexao = createConexao();
    }

    @Override
    public CategoriaDao getCategoriaDao() {
        return new CategoriaJdbc();
    }

    @Override
    public ProdutoDao getProdutoDao() {
        return new ProdutoJdbc();
    }

    @Override
    public ClienteDao getClienteDao() {
        return new ClienteJdbc();
    }

    @Override
    public MunicipioDao getMunicipioDao() {
        return new MunicipioJdbc();
    }

    @Override
    public CestaDao getCestaDao() {
        return new CestaJdbc();
    }

    @Override
    public OrdemCompraDao getOrdemCompraDao() {
        return new OrdemCompraJdbc();
    }

    @Override
    public PedidoClienteDao getPedidoClienteDao() {
        return new PedidoClienteJdbc();
    }

    @Override
    public ContasReceberDao getContasReceberDao() {
        return new ContasReceberJdbc();
    }

}
