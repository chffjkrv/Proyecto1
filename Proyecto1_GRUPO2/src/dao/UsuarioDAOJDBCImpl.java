package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Usuario;
/**
 * 
 * @author Grupo2
 *
 */

public class UsuarioDAOJDBCImpl implements I_UsuarioDAO{
	private Connection con = null;
	
	UsuarioDAOJDBCImpl() throws DAOException{
	
        con = new ConexionDB().getConnection();
    }

	/**
	 * 
	 * @throws DAOException
	 */
	@Override
	public void addUsuario(Usuario usu) throws DAOException {
		 try (Statement stmt = con.createStatement()) {
	            String query = "INSERT INTO USUARIOS VALUES ('" + usu.getNombre() + "',"
	                    + "'" + new java.sql.Date(usu.getFechaNacimiento().getTime())  + "'," + "'" + usu.getCiudad() + "')";
	            if (stmt.executeUpdate(query) != 1) {
	                throw new DAOException("Error adding usuario");
	            }
	        } catch (SQLException se) {
	            //se.printStackTrace();
	            throw new DAOException("Error adding usuario in DAO: "+se.getMessage(), se);
	        }
		
	}
	/**
	 * 
	 * @throws DAOException
	 */
	@Override
	public void updateUsuario(Usuario usu) throws DAOException {
        try (Statement stmt = con.createStatement()) {
            String query = "UPDATE USUARIOS "
                    + "SET fecha_nacimiento='" + new java.sql.Date(usu.getFechaNacimiento().getTime())  + "',"
                    + "ciudad='" + usu.getCiudad() + "'"
                    + "WHERE nombre='" + usu.getNombre()+"'";
            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("Error updating usuario");
            }
        } catch (SQLException se) {
            throw new DAOException("Error updating usuario en DAO"+se.getMessage(), se);
        }
		
	}
	/**
	 * 
	 * @throws DAOException
	 */
	@Override
	public void deleteUsuario(String nombre) throws DAOException {
		Usuario usu = findByNombreUsuario(nombre);
        if (usu == null) {
            throw new DAOException("usuario nombre: " + nombre + " no existe para ser exterminado.");
        }
        try (Statement stmt = con.createStatement()) {
            String query = "DELETE FROM usuarios WHERE NOMBRE='" + nombre+"'";
            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("Error borrando usuario");
            }
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error deleting employee en DAO", se);
        }		
	}
	/**
	 * 
	 * @throws DAOException
	 */
	
	@Override

	public Usuario findByNombreUsuario(String nombre) throws DAOException {
		 try (Statement stmt = con.createStatement()) {
	            String query = "SELECT * FROM USUARIOS WHERE NOMBRE='" + nombre+"'";
	            ResultSet rs = stmt.executeQuery(query);
	            if (!rs.next()) {
	                return null;
	            }
	            return (new Usuario(rs.getString("nombre"), rs.getDate("fecha_nacimiento"),
	                    rs.getString("ciudad")));
	        } catch (SQLException se) {
	            //se.printStackTrace();
	            throw new DAOException("Error encontrando usuario en DAO", se);
	        }
	}
	/**
	 * 
	 * @throws DAOException
	 */
	@Override
	public Usuario[] getAllUsuarios() throws DAOException {
        try (Statement stmt = con.createStatement()) {
        	
            String query = "SELECT * FROM usuarios";
            
            ResultSet rs = stmt.executeQuery(query);
            
            // Create an ArrayList to save resulting records
            ArrayList<Usuario> usuarios = new ArrayList<>();
            // Iterate through the results and create Employee objects
            while (rs.next()) {
            	usuarios.add(new Usuario(rs.getString("nombre"), rs.getDate("fecha_nacimiento"),
	                    rs.getString("ciudad")));
            }
            Usuario[] arrUsu = new Usuario[usuarios.size()];
			usuarios.toArray(arrUsu);
            return arrUsu;
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("error pidiendo todos los usuarios por DAO: " + se.getMessage(), se);
        }
	}
	/**
	 * 
	 * @throws DAOException
	 */
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * @throws DAOException
	 */
	@Override
	public Usuario findByIdUsuario(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
