package br.com.stones.dao.OrdemCompra;

import br.com.stones.dao.JdbcDaoFactory;
import br.com.stones.model.OrdemCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdemCompraJdbc implements OrdemCompraDao {

    private Connection conexao;
    private PreparedStatement stmt;

    @Override
    public boolean insert(Object oObjeto) {
        OrdemCompra oOrdemCompra =  (OrdemCompra) oObjeto;
        try {
            conexao = JdbcDaoFactory.abreConexao();
            stmt = conexao.prepareStatement("insert into ordemcompra (id, status, fornecedor, custoaquisicao, quantidade, produtoid) values (?,?,?,?,?,?)");

            stmt.setInt(1, oOrdemCompra.getId());
            stmt.setInt(2, 0);
            stmt.setString(3, oOrdemCompra.getFornecedor());
            stmt.setDouble(4, oOrdemCompra.getCustoAquisicao());
            stmt.setInt(5, oOrdemCompra.getQuantidade());
            stmt.setInt(6, oOrdemCompra.getProduto().getId());
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
        try {
            conexao = JdbcDaoFactory.abreConexao();
            stmt = conexao.prepareStatement("Select coalesce(max(id), 1) + 1 codigo from ordemCompra");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("codigo");
        } catch (Exception e) {
            return 1;
        } finally {
            try {
                stmt.close();
                conexao = JdbcDaoFactory.fechaConexao();
            } catch (SQLException ex) {

            }
        }
    }

}
