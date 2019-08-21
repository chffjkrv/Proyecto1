package dao;
/**
 * 
 * @author Grupo2
 *
 */
public class UsuarioDAOFactory {
	/**
	 * Crea DAO para comunicar con la BD 
	 * @return new UsuarioDAOJDBCImpl(): devuelve un objeto de UsuarioDAOJDBCImpl
	 * @throws DAOException
	 */
	public I_UsuarioDAO createUsuarioDAO() throws DAOException {
		return new UsuarioDAOJDBCImpl();
	}
	/**
	 * actualiza DAO para comunicar con la BD
	 * @return new UsuarioDAOJDBCImpl(): devuelve un objeto de UsuarioDAOJDBCImpl 
	 * @throws DAOException
	 */
	public I_UsuarioDAO updateUsuarioDAO() throws DAOException {
		return new UsuarioDAOJDBCImpl();
	}
	/**
	 * Elimina DAO para comunicar con la BD
	 * @return new UsuarioDAOJDBCImpl(): devuelve un objeto de UsuarioDAOJDBCImpl
	 * @throws DAOException
	 */
	public I_UsuarioDAO deleteUsuarioDAO() throws DAOException {
		return new UsuarioDAOJDBCImpl();
	}

	/**
	 * Busca DAO para comunicar con la BD
	 * @return new UsuarioDAOJDBCImpl(): devuelve un objeto de UsuarioDAOJDBCImpl
	 * @throws DAOException
	 */
	public I_UsuarioDAO findUsuarioDAO() throws DAOException {
		return new UsuarioDAOJDBCImpl();
	}
}

