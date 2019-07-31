package dao;
/**
 * 
 * @author Grupo2
 *
 */
public class UsuarioDAOFactory {
	/**
	 * 
	 * @throws DAOException
	 */
	public I_UsuarioDAO createUsuarioDAO() throws DAOException {
		return new UsuarioDAOJDBCImpl();
	}
	/**
	 * 
	 * @throws DAOException
	 */
	public I_UsuarioDAO updateUsuarioDAO() throws DAOException {
		return new UsuarioDAOJDBCImpl();
	}
	/**
	 * 
	 * @throws DAOException
	 */
	public I_UsuarioDAO deleteUsuarioDAO() throws DAOException {
		return new UsuarioDAOJDBCImpl();
	}
	/**
	 * 
	 * @throws DAOException
	 */
	public I_UsuarioDAO findUsuarioDAO() throws DAOException {
		return new UsuarioDAOJDBCImpl();
	}
}

