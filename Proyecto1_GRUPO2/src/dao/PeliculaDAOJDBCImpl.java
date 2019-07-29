package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Pelicula;

public class PeliculaDAOJDBCImpl implements I_PeliculaDAO {

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

            String query = "INSERT INTO PELICULAS VALUES (" + peli.getNombre() + ","
                    + "'" + peli.getAgnoPelicula() + "'," + "'" + peli.getCategoria() + "',"
                    + "'"  + ")";

            String query1="INSERT INTO peliculas VALUES (" + peli.getNombre() + ","+ 
            		peli.getAgnoPelicula() + "'" + peli.getCategoria() + "')";

            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("Error creando pelicula");
            }
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error creando pelicula DAO", se);
        }
		
		
	}

	@Override
	public void modificarPeli(Pelicula peli) throws DAOException {

	}

	@Override
	public void borrarPeli(int id) throws DAOException {

		Pelicula peli = findById(id);
		if (peli == null) {
			throw new DAOException("ID pelicula: " + id + " no se puede borrar.");
		}
		try (Statement stmt = con.createStatement()) {
			String query = "DELETE FROM PELICULAS WHERE id_pelicula=" + id;
			if (stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error borrando pelicula");
			}
		} catch (SQLException se) {
			// se.printStackTrace();
			throw new DAOException("Error borrando pelicula en DAO", se);
		}

	}

	@Override
	public Pelicula findById(int id) throws DAOException {

		try (Statement stmt = con.createStatement()) {
			String query = "SELECT * FROM PELICULAS WHERE ID=" + id;
			ResultSet rs = stmt.executeQuery(query);
			if (!rs.next()) {
				return null;
			}
			return (new Pelicula(rs.getString("Nombre"), rs.getInt("Agno pelicula"), rs.getString("Categoria")));

		} catch (SQLException se) {
			// se.printStackTrace();
			throw new DAOException("Error encontrando pelicula en DAO", se);
		}

		
	}

	@Override
	public Pelicula[] listarPeliculas() throws DAOException {

		return null;
	}

}
