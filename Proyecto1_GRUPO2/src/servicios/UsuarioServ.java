package servicios;

import dao.DAOException;
import dao.I_UsuarioDAO;
import dao.UsuarioDAOFactory;
import modelo.Usuario;
/**
 * 
 * @author Grupo2
 *
 */
public class UsuarioServ implements I_UsuarioServ{

	@Override
	public void addUsuario(Usuario usu) throws DAOException {
		// TODO Auto-generated method stub
		UsuarioDAOFactory factoryUser = new UsuarioDAOFactory();
		I_UsuarioDAO userDao = factoryUser.createUsuarioDAO();
		userDao.addUsuario(usu);
	}

	@Override
	public void updateUsuario(Usuario usu) throws DAOException {
		// TODO Auto-generated method stub
		UsuarioDAOFactory factoryUser = new UsuarioDAOFactory();
		I_UsuarioDAO userDao = factoryUser.updateUsuarioDAO();
		userDao.updateUsuario(usu);
	}

	@Override
	public void deleteUsuario(String nombre) throws DAOException {
		// TODO Auto-generated method stub
		UsuarioDAOFactory factoryUser = new UsuarioDAOFactory();
		I_UsuarioDAO userDao = factoryUser.deleteUsuarioDAO();
		userDao.deleteUsuario(nombre);
	}

	@Override
	public Usuario findByIdUsuario(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario[] getAllUsuarios() throws DAOException {
		// TODO Auto-generated method stub
		UsuarioDAOFactory factoryUser = new UsuarioDAOFactory();
		I_UsuarioDAO userDao = factoryUser.findUsuarioDAO();
		return userDao.getAllUsuarios();
	}

	@Override
	public Usuario findByNombreUsuario(String nombre) throws DAOException {
		// TODO Auto-generated method stub
		UsuarioDAOFactory factoryUser = new UsuarioDAOFactory();
		I_UsuarioDAO userDao = factoryUser.findUsuarioDAO();		
		return userDao.findByNombreUsuario(nombre);
	}
	
}
