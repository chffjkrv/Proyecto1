package servicios;

import dao.DAOException;
import modelo.Pelicula;
/**
 * 
 * @author Grupo2
 *
 */
public interface I_PeliculasServ {
	/**
	 * Sirve para crear una pelicula
	 * @param peli: recibe un objeto pelicula
	 * @exception DAOException genera excepcion si hay error al crear la pelicula
	 */
	public void crearPeli(Pelicula peli) throws DAOException;

	/**
	 * Sirve para modificar una pelicula
	 * @param peli: recibe un objeto Pelicula
	 * @throws DAOException genera excepcion si hay error al modificar la pelicula
	 */
	public void modificarPeli(Pelicula peli) throws DAOException;
	
	/**
	 * Sirve para eliminar una pelicula localizado por su identificador
	 * @param id: recibe un entero
	 * @throws DAOException genera excepcion si hay error al borrar la pelicula
	 */

	public void borrarPeli(int id) throws DAOException;
	/**
	 * Sirve para buscar una pelicula localizado por su identificador
	 * @param id: recibe un entero
	 * @return Pelicula: devuelve una pelicula con sus atributos
	 * @throws DAOException genera excepcion si hay error al buscar la pelicula
	 */

	public Pelicula findById(int id) throws DAOException;
	/**
	 * Sirve para listar todas las peliculas
	 * @return Pelicula[]: devuelve un array con todas las peliculas
	 * @throws DAOException genera excepcion si hay error al listar todas las peliculas 
	 */

	public Pelicula[] listarPeliculas() throws DAOException;
	/**
	 * Sirve para listar las peliculas segun una categoria
	 * @param categoria: recibe un string
	 * @return Pelicula[]: devuelve un array con las peliculas segun una categoria
	 * @throws DAOException genera excepcion si hay error al listar todas las peliculas segun categoria
	 */
	
	public Pelicula[] listarPeliculasCategorias(String categoria) throws DAOException;
}
