package br.com.stones.dao;

import br.com.stones.dao.OrdemCompra.OrdemCompraDao;
import br.com.stones.dao.OrdemCompra.OrdemCompraJpa;
import br.com.stones.dao.categoria.CategoriaDao;
import br.com.stones.dao.categoria.CategoriaJpa;
import br.com.stones.dao.cesta.CestaDao;
import br.com.stones.dao.cesta.CestaJpa;
import br.com.stones.dao.cliente.ClienteDao;
import br.com.stones.dao.cliente.ClienteJpa;
import br.com.stones.dao.contasReceber.ContasReceberDao;
import br.com.stones.dao.contasReceber.ContasReceberJpa;
import br.com.stones.dao.municipio.MunicipioDao;
import br.com.stones.dao.municipio.MunicipioJpa;
import br.com.stones.dao.pedidoCliente.PedidoClienteDao;
import br.com.stones.dao.pedidoCliente.PedidoClienteJpa;
import br.com.stones.dao.produto.ProdutoDao;
import br.com.stones.dao.produto.ProdutoJpa;

public class JpaDaoFactory extends DaoFactory {
    
    @Override
    public CategoriaDao getCategoriaDao() {
        return new CategoriaJpa();
    }

    @Override
    public ProdutoDao getProdutoDao() {
        return new ProdutoJpa();
    }

    @Override
    public ClienteDao getClienteDao() {
        return new ClienteJpa();
    }

    @Override
    public MunicipioDao getMunicipioDao() {
        return new MunicipioJpa();
    }

    @Override
    public CestaDao getCestaDao() {
        return new CestaJpa();
    }

    @Override
    public OrdemCompraDao getOrdemCompraDao() {
        return new OrdemCompraJpa();
    }

    @Override
    public PedidoClienteDao getPedidoClienteDao() {
        return new PedidoClienteJpa();
    }

    @Override
    public ContasReceberDao getContasReceberDao() {
        return new ContasReceberJpa();
    }
}
