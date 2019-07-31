package dao;

public class UsuarioDAOFactory {
	public I_UsuarioDAO createUsuarioDAO() throws DAOException {
		return new UsuarioDAOJDBCImpl();
	}
	
	public I_UsuarioDAO updateUsuarioDAO() throws DAOException {
		return new UsuarioDAOJDBCImpl();
	}
	
	public I_UsuarioDAO deleteUsuarioDAO() throws DAOException {
		return new UsuarioDAOJDBCImpl();
	}
	
	public I_UsuarioDAO findUsuarioDAO() throws DAOException {
		return new UsuarioDAOJDBCImpl();
	}
}

