package dao;
import modelo.Usuario;



public interface I_UsuarioDAO extends AutoCloseable {

    public void add(Usuario usu) throws DAOException;

    public void update(Usuario usu) throws DAOException;

    public void delete(String nombre) throws DAOException;

    public Usuario findById(int id) throws DAOException;

    public Usuario[] getAllUsuarios() throws DAOException;
}