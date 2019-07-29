package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import model.Employee;
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
		Usuario usu = findById(id);
        if (emp == null) {
            throw new DAOException("Employee id: " + id + " does not exist to delete.");
        }
        try (Statement stmt = con.createStatement()) {
            String query = "DELETE FROM EMPLOYEE WHERE ID=" + id;
            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("Error deleting employee");
            }
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error deleting employee in DAO", se);
        }		
	}

	@Override
	public Usuario findByNombreUsuario(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario[] getAllUsuarios() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}
