package br.com.stones.dao.cesta;

import br.com.stones.dao.JdbcDaoFactory;
import br.com.stones.model.Categoria;
import br.com.stones.model.Cesta;
import br.com.stones.model.Cliente;
import br.com.stones.model.Municipio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CestaJdbc implements CestaDao {

    private Connection conexao;
    private PreparedStatement stmt;

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

    @Override
    public List<Cesta> buscarTodos() {
        try {
            conexao = JdbcDaoFactory.abreConexao();
            stmt = conexao.prepareStatement("select \n"
                    + "  cesta.*,  \n"
                    + "  cliente.nome,\n"
                    + "  municipios_ibge.codigo_ibge,\n"
                    + "  municipios_ibge.uf,\n"
                    + "  municipios_ibge.municipio,\n"
                    + "  municipios_ibge.latitude,\n"
                    + "  municipios_ibge.longitude  \n"
                    + "from \n"
                    + "  cesta, cliente, municipios_ibge\n"
                    + "where \n"
                    + "  cesta.clienteid = cliente.id\n"
                    + "  and\n"
                    + "  cliente.municipioid = municipios_ibge.codigo_ibge");

            ResultSet rs = stmt.executeQuery();

            ArrayList<Cesta> todos = new ArrayList<Cesta>();

            while (rs.next()) {
                Municipio oMunicipio = new Municipio();
                oMunicipio.setCodigo_ibge(rs.getInt("codigo_ibge"));
                oMunicipio.setDescricao(rs.getString("municipio"));
                oMunicipio.setLatitude(rs.getDouble("latitude"));
                oMunicipio.setLongitude(rs.getDouble("longitude"));
                oMunicipio.setUf(rs.getString("uf"));

                Cliente oCliente = new Cliente();
                oCliente.setId(rs.getInt("clienteId"));
                oCliente.setNome(rs.getString("nome"));
                oCliente.setMunicipio(oMunicipio);
                
                Cesta oCesta = new Cesta();
                oCesta.setId(rs.getInt("id"));
                oCesta.setCliente(oCliente);
                oCesta.setValor(rs.getDouble("valor"));
                                
                todos.add(oCesta);
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

}
