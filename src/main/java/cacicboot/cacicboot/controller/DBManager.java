package cacicboot.cacicboot.controller;

import cacicboot.cacicboot.db.DAOFactory;
import cacicboot.cacicboot.db.RevisionDao;
import cacicboot.cacicboot.db.TemaDao;
import cacicboot.cacicboot.db.TrabajoDao;
import cacicboot.cacicboot.db.UsuarioDao;

public class DBManager {
	private String db = "MYSQL";

	public DBManager() {
	};

	public RevisionDao getRevisionDao() {
		return DAOFactory.getRevisionDao(db);
	}

	public UsuarioDao getUsuarioDao() {
		return DAOFactory.getUsuarioDao(db);
	}

	public TrabajoDao getTrabajoDao() {
		return DAOFactory.getTrabajoDao(db);
	}

	public TemaDao getTemaDao() {
		return DAOFactory.getTemaDao(db);
	}

	private void setDB(String db) {
		this.db = db;
	}
}