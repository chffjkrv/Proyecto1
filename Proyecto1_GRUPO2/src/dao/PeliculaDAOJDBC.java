package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import modelo.Pelicula;

public class PeliculaDAOJDBC implements I_PeliculaDAO {

	private Connection con = null;

	public PeliculaDAOJDBC() {
		// TODO Auto-generated constructor stub
        con = new ConexionDB().getConnection();
    }
	
	@Override
	public void aniadirPelicula(Pelicula peli) throws DAOException {
		// TODO Auto-generated method stub
		try (Statement stmt = con.createStatement()) {
            String query = "INSERT INTO peliculas VALUES (" + peli.getNombre() + ","+ 
            		peli.getAgnoPelicula() + "'" + peli.getCategoria() + "')";
            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("Error adding employee");
            }
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error adding employee in DAO", se);
        }
	}
	
}
