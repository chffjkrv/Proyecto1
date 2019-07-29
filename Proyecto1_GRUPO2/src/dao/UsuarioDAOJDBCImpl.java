package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Usuario;



public class UsuarioDAOJDBCImpl implements I_UsuarioDAO{
	private Connection con = null;
	
	UsuarioDAOJDBCImpl(){
	
        con = new ConexionDB().getConnection();
    }


	@Override
	public void addUsuario(Usuario usu) throws DAOException {
		 try (Statement stmt = con.createStatement()) {
	            String query = "INSERT INTO USUARIOS VALUES (" + usu.getNombre() + ","
	                    + "'" + new java.sql.Date(usu.getFechaNacimiento().getTime())  + "'," + "'" + usu.getCiudad() + ")";
	            if (stmt.executeUpdate(query) != 1) {
	                throw new DAOException("Error adding usuario");
	            }
	        } catch (SQLException se) {
	            //se.printStackTrace();
	            throw new DAOException("Error adding usuario in DAO", se);
	        }
		
	}

	@Override
	public void updateUsuario(Usuario usu) throws DAOException {
        try (Statement stmt = con.createStatement()) {
            String query = "UPDATE USUARIO "
                    + "SET nombre='" + usu.getNombre() + "',"
                    + "fecha_nacimiento='" + new java.sql.Date(usu.getFechaNacimiento().getTime())  + "',"
                    + "ciudad='" + usu.getCiudad() + "',"
                    + "WHERE nombre=" + usu.getNombre();
            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("Error updating employee");
            }
        } catch (SQLException se) {
            throw new DAOException("Error updating employee in DAO", se);
        }
		
	}

	@Override
	public void deleteUsuario(String nombre) throws DAOException {
		Usuario usu = findByNombreUsuario(nombre);
        if (usu == null) {
            throw new DAOException("Employee nombre: " + nombre + " does not exist to delete.");
        }
        try (Statement stmt = con.createStatement()) {
            String query = "DELETE FROM EMPLOYEE WHERE ID=" + nombre;
            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("Error deleting employee");
            }
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error deleting employee in DAO", se);
        }		
	}

	@Override
	public Usuario findByNombreUsuario(String nombre) throws DAOException {
		 try (Statement stmt = con.createStatement()) {
	            String query = "SELECT * FROM USUARIO WHERE NOMBRE=" + nombre;
	            ResultSet rs = stmt.executeQuery(query);
	            if (!rs.next()) {
	                return null;
	            }
	            return (new Usuario(rs.getString("nombre"), rs.getDate("fecha_nacimiento"),
	                    rs.getString("ciudad")));
	        } catch (SQLException se) {
	            //se.printStackTrace();
	            throw new DAOException("Error finding employee in DAO", se);
	        }
	}

	@Override
	public Usuario[] getAllUsuarios() throws DAOException {
        try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM usuario";
            ResultSet rs = stmt.executeQuery(query);
            // Create an ArrayList to save resulting records
            ArrayList<Usuario> usuarios = new ArrayList<>();
            // Iterate through the results and create Employee objects
            while (rs.next()) {
            	usuarios.add(new Usuario(rs.getString("nombre"), rs.getDate("fecha_nacimiento"),
	                    rs.getString("ciudad")));
            }
            return usuarios.toArray(new Usuario[0]);
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error getting all employees in DAO: " + se.getMessage(), se);
        }
	}


	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Usuario findByIdUsuario(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
