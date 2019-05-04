package br.com.stones.dao.contasReceber;

import br.com.stones.dao.JdbcDaoFactory;
import br.com.stones.model.ContasReceber;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContasReceberJdbc implements ContasReceberDao {

    private Connection conexao;
    private PreparedStatement stmt;

    @Override
    public boolean insert(Object oObjeto) {
        ContasReceber oContasReceber =  (ContasReceber) oObjeto;
        try {
            conexao = JdbcDaoFactory.abreConexao();
            stmt = conexao.prepareStatement("insert into contasreceber (id, valor, clienteid) values (?,?,?)");

            stmt.setInt(1, oContasReceber.getId());
            stmt.setDouble(2, oContasReceber.getValor());
            stmt.setInt(3, oContasReceber.getCliente().getId());
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
            stmt = conexao.prepareStatement("Select coalesce(max(id), 1) + 1 codigo from contasReceber");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("codigo");
        } catch (Exception e) {
            return 0;
        } finally {
            try {
                stmt.close();
                conexao = JdbcDaoFactory.fechaConexao();
            } catch (SQLException ex) {

            }
        }
    }
}
