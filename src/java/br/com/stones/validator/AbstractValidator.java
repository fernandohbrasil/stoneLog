package br.com.stones.validator;

import br.com.stones.dao.DaoFactory;

public class AbstractValidator {

    protected DaoFactory daoFactory = DaoFactory.getDaoFactory(DaoFactory.JDBC);

}
