package br.com.stones.dao.pedidoCliente;

import br.com.stones.dao.JdbcDaoFactory;
import br.com.stones.model.PedidoCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoClienteJdbc implements PedidoClienteDao {

    private Connection conexao;
    private PreparedStatement stmt;

    @Override
    public boolean insert(Object oObjeto) {
        PedidoCliente oPedidoCliente = (PedidoCliente) oObjeto;
        try {
            conexao = JdbcDaoFactory.abreConexao();
            stmt = conexao.prepareStatement("insert into pedidocliente (clienteid, produtoid, status) values (?,?,?)");

            stmt.setInt(1, oPedidoCliente.getCliente().getId());
            stmt.setInt(2, oPedidoCliente.getProduto().getId());
            stmt.setInt(3, 0);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                stmt.close();
                conexao = JdbcDaoFactory.fechaConexao();
            } catch (SQLException ex) {

            }
        }
    }

    @Override
    public boolean delete(Object oObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object oObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNextId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
