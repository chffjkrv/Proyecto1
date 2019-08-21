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

	/**
	 * Sirve para anadir un usuario
	 * @param usu: recibe un objeto Usuario
	 * @exception DAOException
	 */
	@Override
	public void addUsuario(Usuario usu) throws DAOException {
		// TODO Auto-generated method stub
		UsuarioDAOFactory factoryUser = new UsuarioDAOFactory();
		I_UsuarioDAO userDao = factoryUser.createUsuarioDAO();
		userDao.addUsuario(usu);
	}
	/**
	 * Sirve para actualizar un usuario
	 * @param usu: recibe un objeto Usuario
	 * @exception DAOException
	 */

	@Override
	public void updateUsuario(Usuario usu) throws DAOException {
		// TODO Auto-generated method stub
		UsuarioDAOFactory factoryUser = new UsuarioDAOFactory();
		I_UsuarioDAO userDao = factoryUser.updateUsuarioDAO();
		userDao.updateUsuario(usu);
	}
	
	/**
	 * Sirve para eliminar un usuario
	 * @param usu: recibe un objeto Usuario
	 * @exception DAOException
	 */

	@Override
	public void deleteUsuario(String nombre) throws DAOException {
		// TODO Auto-generated method stub
		UsuarioDAOFactory factoryUser = new UsuarioDAOFactory();
		I_UsuarioDAO userDao = factoryUser.deleteUsuarioDAO();
		userDao.deleteUsuario(nombre);
	}
	
	/**
	 * Sirve para buscar un usuario con su identificador
	 * @param usu: recibe un objeto Usuario
	 * @exception DAOException
	 */

	@Override
	public Usuario findByIdUsuario(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Sirve para geberar un listado de usuarios
	 * @retun Usuario[]: devuelve userDao.gellAllUsuario
	 * @exception DAOException
	 */

	@Override
	public Usuario[] getAllUsuarios() throws DAOException {
		// TODO Auto-generated method stub
		UsuarioDAOFactory factoryUser = new UsuarioDAOFactory();
		I_UsuarioDAO userDao = factoryUser.findUsuarioDAO();
		return userDao.getAllUsuarios();
	}
	
	/**
	 * Sirve para buscar un usuario por su nombre
	 * @param nombre: recibe un string Usuario
	 * @exception DAOException
	 */

	@Override
	public Usuario findByNombreUsuario(String nombre) throws DAOException {
		// TODO Auto-generated method stub
		UsuarioDAOFactory factoryUser = new UsuarioDAOFactory();
		I_UsuarioDAO userDao = factoryUser.findUsuarioDAO();		
		return userDao.findByNombreUsuario(nombre);
	}
	
}
