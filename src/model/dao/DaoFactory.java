package model.dao;

import db.DB;
import model.dao.impl.JogadorDaoJDBC;

public class DaoFactory {

	public static JogadorDao createJogadorDao() {
		return new JogadorDaoJDBC(DB.getConnection());
	}

}
