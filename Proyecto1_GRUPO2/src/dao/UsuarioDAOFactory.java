package dao;

public class UsuarioDAOFactory {
	public I_UsuarioDAO createUsuarioDAO() {
		return new UsuarioDAOJDBCImpl();
	}
	
	public I_UsuarioDAO updateUsuarioDAO() {
		return new UsuarioDAOJDBCImpl();
	}
	
	public I_UsuarioDAO deleteUsuarioDAO() {
		return new UsuarioDAOJDBCImpl();
	}
	
	public I_UsuarioDAO findUsuarioDAO() {
		return new UsuarioDAOJDBCImpl();
	}
}

