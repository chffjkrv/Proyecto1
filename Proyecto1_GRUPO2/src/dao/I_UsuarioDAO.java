package dao;
import modelo.Usuario;



public interface I_UsuarioDAO extends AutoCloseable {

    public void addUsuario(Usuario usu) throws DAOException;

    public void updateUsuario(Usuario usu) throws DAOException;

    public void deleteUsuario(String nombre) throws DAOException;

    public Usuario findByIdUsuario(int id) throws DAOException;

    public Usuario[] getAllUsuarios() throws DAOException;

	Usuario findByNombreUsuario(String nombre) throws DAOException;
}