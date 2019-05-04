package br.com.stones.converter;

import br.com.stones.dao.DaoFactory;

public class AbstractConverter {
    
    protected DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);
    
}
