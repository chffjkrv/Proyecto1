package dao;

public class PeliculaDAOFactory {

	public I_PeliculaDAO createPeliculaDAO() {
		return new PeliculaDAOJDBCImpl();
	}
}
