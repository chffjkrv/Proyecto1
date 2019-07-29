package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Pelicula;

public class PeliculaDAOJDBCImpl implements I_PeliculaDAO{
	
	 private Connection con = null;

	    
	    PeliculaDAOJDBCImpl() {
	    	con = new ConexionDB().getConnection();
		}

	        
	    

	@Override
	public void close() throws Exception {
		
		
	}

	@Override
	public void crearPeli(Pelicula peli) throws DAOException {
		
		try (Statement stmt = con.createStatement()) {
            String query = "INSERT INTO PELICULAS VALUES (" + peli.getNombre()() + ","
                    + "'" + peli.getAgnoPelicula()() + "'," + "'" + peli.getCategoria()() + "',"
                    + "'"  + ")";
            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("Error adding employee");
            }
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error adding employee in DAO", se);
        }
		
		
	}

	@Override
	public void modificarPeli(Pelicula peli) throws DAOException {
		
		
	}

	@Override
	public void borrarPeli(int id) throws DAOException {
		
		
	}

	@Override
	public Pelicula findById(int id) throws DAOException {
		
		return null;
	}

	@Override
	public Pelicula[] listarPeliculas() throws DAOException {
		
		return null;
	}
	
	
}
