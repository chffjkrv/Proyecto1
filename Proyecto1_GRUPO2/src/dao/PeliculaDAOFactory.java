package dao;

public class PeliculaDAOFactory {

	public I_PeliculaDAO createPeliculaDAO() throws DAOException {
		return new PeliculaDAOJDBCImpl();
	}
}
