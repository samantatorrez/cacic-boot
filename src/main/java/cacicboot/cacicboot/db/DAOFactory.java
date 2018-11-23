package cacicboot.cacicboot.db;

import cacicboot.cacicboot.db.impl.RevisionMysqlDAOImpl;
import cacicboot.cacicboot.db.impl.TemaMysqlDAOImpl;
import cacicboot.cacicboot.db.impl.TrabajoMysqlDAOImpl;
import cacicboot.cacicboot.db.impl.UsuarioMysqlDAOImpl;

public class DAOFactory {
	public static RevisionDao getRevisionDao(String db) {
		switch (db.toUpperCase()) {
		case "MYSQL":
		default:
			return RevisionMysqlDAOImpl.getInstance();
		}
	}

	public static UsuarioDao getUsuarioDao(String db) {
		switch (db.toUpperCase()) {
		case "MYSQL":
		default:
			return UsuarioMysqlDAOImpl.getInstance();
		}
	}

	public static TrabajoDao getTrabajoDao(String db) {
		switch (db.toUpperCase()) {
		case "MYSQL":
		default:
			return TrabajoMysqlDAOImpl.getInstance();
		}
	}

	public static TemaDao getTemaDao(String db) {
		switch (db.toUpperCase()) {
		case "MYSQL":
		default:
			return TemaMysqlDAOImpl.getInstance();
		}
	}

}