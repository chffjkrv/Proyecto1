package dao;

public class UsuarioDAOFactory {
	public I_UsuarioDAO createUsuarioDAO() {
		return new UsuarioDAOJDBCImpl();
	}
}

