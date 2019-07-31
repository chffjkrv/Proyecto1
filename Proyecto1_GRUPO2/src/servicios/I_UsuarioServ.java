package servicios;

import dao.DAOException;
import modelo.Usuario;
/**
 * 
 * @author Grupo2
 *
 */
public interface I_UsuarioServ {

    public void addUsuario(Usuario usu) throws DAOException;

    public void updateUsuario(Usuario usu) throws DAOException;

    public void deleteUsuario(String nombre) throws DAOException;

    public Usuario findByIdUsuario(int id) throws DAOException;

    public Usuario[] getAllUsuarios() throws DAOException;

	Usuario findByNombreUsuario(String nombre) throws DAOException;
}
