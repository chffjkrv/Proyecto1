package dao;
/**
 * 
 * @author Grupo2
 *
 */
public class PeliculaDAOFactory {
/**
 * Crea DAO para comunicar con la BD
 * @return I_PeliculaDAO
 * @throws DAOException
 */
	public I_PeliculaDAO createPeliculaDAO() throws DAOException {
		return new PeliculaDAOJDBCImpl();
	}
}
