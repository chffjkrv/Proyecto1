package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Pelicula;
/**
 * 
 * @author Grupo2
 *
 */
public class PeliculaDAOJDBCImpl implements I_PeliculaDAO {

	private Connection con = null;
/**
 * 
 * @throws DAOException
 */
	PeliculaDAOJDBCImpl() throws DAOException {
		con = new ConexionDB().getConnection();
	}

	@Override
	public void close() throws Exception {

	}
	/**
	 * 
	 * @throws DAOException
	 */
	@Override
	public void crearPeli(Pelicula peli) throws DAOException {

		try (Statement stmt = con.createStatement()) {

			String query = "INSERT INTO PELICULAS VALUES (" + peli.getId() + "," + "'" + peli.getNombre() + "',"
					+ peli.getAgnoPelicula() + "," + "'" + peli.getCategoria() + "')";
			if (stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error creando pelicula");
			}
		} catch (SQLException se) {
			// se.printStackTrace();
			throw new DAOException("Error creando pelicula DAO", se);
		}

	}
	/**
	 * 
	 * @throws DAOException
	 */
	@Override
	public void modificarPeli(Pelicula peli) throws DAOException {
		try (Statement stmt = con.createStatement()) {
			String query = "UPDATE peliculas " + "SET nombre='" + peli.getNombre() + "'," + "anio_estreno='"
					+ peli.getAgnoPelicula() + "'," + "categoria='" + peli.getCategoria() + "'," + "WHERE id_pelicula="
					+ peli.getId();
			if (stmt.executeUpdate(query) != 1) {
				throw new DAOException("Error modificando pelicula");
			}
		} catch (SQLException se) {
			throw new DAOException("Error modificando pelicula in DAO", se);
		}
	}
	/**
	 * 
	 * @throws DAOException
	 */
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
	/**
	 * 
	 * @throws DAOException
	 */
	@Override
	public Pelicula findById(int id) throws DAOException {

		try (Statement stmt = con.createStatement()) {
			String query = "SELECT * FROM PELICULAS WHERE id_pelicula=" + id;
			ResultSet rs = stmt.executeQuery(query);
			if (!rs.next()) {
				return null;
			}
			return (new Pelicula(rs.getInt("ID"), rs.getString("Nombre"), rs.getInt("Agno pelicula"),
					rs.getString("Categoria")));

		} catch (SQLException se) {
			// se.printStackTrace();
			throw new DAOException("Error encontrando pelicula en DAO", se);
		}

	}
	/**
	 * 
	 * @throws DAOException
	 */
	@Override
	public Pelicula[] listarPeliculas() throws DAOException {
		try (Statement stmt = con.createStatement()) {
			String query = "SELECT * FROM peliculas";
			ResultSet rs = stmt.executeQuery(query);

			ArrayList<Pelicula> pelis = new ArrayList<>();

			while (rs.next()) {
				pelis.add(new Pelicula(rs.getInt("id_pelicula"), rs.getString("pelicula"), rs.getInt("anio_estreno"),
						rs.getString("categoria")));
			}
			Pelicula[] arrPeli = new Pelicula[pelis.size()];
			pelis.toArray(arrPeli);
			return arrPeli;
			//	return pelis.toArray(new Pelicula[0]);
			
		} catch (SQLException se) {
			// se.printStackTrace();
			throw new DAOException("Error obteniendo peliculas en DAO: " + se.getMessage(), se);
		}

	}
	/**
	 * 
	 * @throws DAOException
	 */
	@Override
	public Pelicula[] listarPeliculasCategorias(String categoria) throws DAOException {
		try (Statement stmt = con.createStatement()) {
			String query = "SELECT * FROM proyecto1g2bd2.peliculas WHERE peliculas.categoria LIKE '%"+categoria+"%'";
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);

			ArrayList<Pelicula> pelis = new ArrayList<>();

			while (rs.next()) {
				System.out.println("-- añado "+rs.getInt("id_pelicula"));
				pelis.add(new Pelicula(rs.getInt("id_pelicula"), rs.getString("pelicula"), rs.getInt("anio_estreno"),
						rs.getString("categoria")));
			}
			Pelicula[] arrPeli = new Pelicula[pelis.size()];
			pelis.toArray(arrPeli);
			
			for (Pelicula xxx: arrPeli) {
				System.out.println("|---------------------------------------------|");
				System.out.println("	[Nombre: "+xxx.getNombre()+"]\n");
				System.out.println("	[Anio estreno: "+xxx.getAgnoPelicula()+"]\n");
				System.out.println("	[Categoria: "+xxx.getCategoria()+"]\n");
				System.out.println("	[Id: "+xxx.getId()+"]\n");
				System.out.println("|---------------------------------------------|");
		 }
			return arrPeli;
		} catch (SQLException se) {
			// se.printStackTrace();
			throw new DAOException("Error consiguiendo las peliculas por categoria in DAO: " + se.getMessage(), se);
		}
	}

	

	

}
