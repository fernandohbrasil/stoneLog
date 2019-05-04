package br.com.stones.dao.municipio;

import br.com.stones.dao.JdbcDaoFactory;
import br.com.stones.model.Municipio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MunicipioJdbc implements MunicipioDao {

    private Connection conexao;
    private PreparedStatement stmt;

    @Override
    public Object getMunicipio(int id) {
        try {
            conexao = JdbcDaoFactory.abreConexao();
            stmt = conexao.prepareStatement("Select * from MUNICIPIOS_IBGE where CODIGO_IBGE = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();

            Municipio oMunicipio = new Municipio();
            oMunicipio.setCodigo_ibge(rs.getInt("CODIGO_IBGE"));
            oMunicipio.setDescricao(rs.getString("MUNICIPIO"));
            oMunicipio.setLatitude(rs.getDouble("LATITUDE"));
            oMunicipio.setLongitude(rs.getDouble("LONGITUDE"));
            oMunicipio.setUf(rs.getString("UF"));

            return oMunicipio;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                stmt.close();
                conexao = JdbcDaoFactory.fechaConexao();
            } catch (SQLException ex) {

            }
        }
    }

    @Override
    public List<Municipio> buscarTodosSC() {
        try {
            conexao = JdbcDaoFactory.abreConexao();
            stmt = conexao.prepareStatement("select * from municipios_ibge where uf = 'SC' order by municipio");

            ResultSet rs = stmt.executeQuery();

            ArrayList<Municipio> todos = new ArrayList<Municipio>();

            while (rs.next()) {
                Municipio oMunicipio = new Municipio();
                oMunicipio.setCodigo_ibge(rs.getInt("CODIGO_IBGE"));
                oMunicipio.setDescricao(rs.getString("MUNICIPIO"));
                oMunicipio.setLatitude(rs.getDouble("LATITUDE"));
                oMunicipio.setLongitude(rs.getDouble("LONGITUDE"));
                oMunicipio.setUf(rs.getString("UF"));
                todos.add(oMunicipio);
            }
            return todos;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                stmt.close();
                conexao = JdbcDaoFactory.fechaConexao();
            } catch (SQLException ex) {

            }
        }
    }

    @Override
    public List<Municipio> buscarTodos() {
        try {
            conexao = JdbcDaoFactory.abreConexao();
            stmt = conexao.prepareStatement("select * from municipios_ibge order by municipio");

            ResultSet rs = stmt.executeQuery();

            ArrayList<Municipio> todos = new ArrayList<Municipio>();

            while (rs.next()) {
                Municipio oMunicipio = new Municipio();
                oMunicipio.setCodigo_ibge(rs.getInt("CODIGO_IBGE"));
                oMunicipio.setDescricao(rs.getString("MUNICIPIO"));
                oMunicipio.setLatitude(rs.getDouble("LATITUDE"));
                oMunicipio.setLongitude(rs.getDouble("LONGITUDE"));
                oMunicipio.setUf(rs.getString("UF"));
                todos.add(oMunicipio);
            }
            return todos;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                stmt.close();
                conexao = JdbcDaoFactory.fechaConexao();
            } catch (SQLException ex) {

            }
        }
    }

    @Override
    public boolean insert(Object oObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
