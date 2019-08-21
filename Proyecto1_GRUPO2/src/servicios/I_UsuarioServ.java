package servicios;

import dao.DAOException;
import modelo.Usuario;
/**
 * 
 * @author Grupo2
 *
 */
public interface I_UsuarioServ {
	
	/**
	 * Sirve para anadir un usuario
	 * @param usu: recibe un objeto Usuario
	 * @exception DAOException
	 */
    public void addUsuario(Usuario usu) throws DAOException;
	/**
	 * Sirve para actualizar un usuario
	 * @param usu: recibe un objeto Usuario
	 * @exception DAOException
	 */
    public void updateUsuario(Usuario usu) throws DAOException;
	/**
	 * Sirve para eliminar un usuario
	 * @param usu: recibe un objeto Usuario
	 * @exception DAOException
	 */
    public void deleteUsuario(String nombre) throws DAOException;
	/**
	 * Sirve para buscar un usuario con su identificador
	 * @param usu: recibe un objeto Usuario
	 * @exception DAOException
	 */
    public Usuario findByIdUsuario(int id) throws DAOException;
	/**
	 * Sirve para geberar un listado de usuarios
	 * @retun Usuario[]: devuelve userDao.gellAllUsuario
	 * @exception DAOException
	 */
    public Usuario[] getAllUsuarios() throws DAOException;
	/**
	 * Sirve para buscar un usuario por su nombre
	 * @param nombre: recibe un string Usuario
	 * @exception DAOException
	 */
	Usuario findByNombreUsuario(String nombre) throws DAOException;
}
