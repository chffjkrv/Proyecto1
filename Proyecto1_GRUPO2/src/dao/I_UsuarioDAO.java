package dao;
import modelo.Usuario;
/**
 * 
 * @author Grupo2
 * @see modelo.Usuario
 */


public interface I_UsuarioDAO extends AutoCloseable {
/**
 * 
 * @param usu: anade un usuario
 * @throws DAOException:12345
 */
    public void addUsuario(Usuario usu) throws DAOException;
    /**
     * 
     * @param usu: modifica usuario
     * @throws DAOException salta alerta si no se añade usuario
     */

    public void updateUsuario(Usuario usu) throws DAOException;
    /**
     * 
     * @param nombre: Borra usuario
     * @throws DAOException salta alerta si no se consigue actualizar el usuario
     */
    public void deleteUsuario(String nombre) throws DAOException;
    /**
     * 
     * @param id: encuentra id por usuario
     * @throws DAOException:12345
     */
    public Usuario findByIdUsuario(int id) throws DAOException;

    public Usuario[] getAllUsuarios() throws DAOException;

	Usuario findByNombreUsuario(String nombre) throws DAOException;
	
}