package dao;

import modelo.Pelicula;
/**
 * 
 * @author Grupo2
 *@see modelo.Pelicula.
 */
public interface I_PeliculaDAO extends AutoCloseable {

	/**
	 * Sirve para cear una pelicula
	 * @param peli: recibe un objeto pelicula
	 * @throws DAOException
	 */
	public void crearPeli(Pelicula peli) throws DAOException;

	/**
	 * Sirve para modificar una pelicula
	 * @param peli: recibe un objeto Pelicula
	 * @throws DAOException
	 */
	public void modificarPeli(Pelicula peli) throws DAOException;
	
	/**
	 * Sirve para eliminar una pelicula localizando por su identificador
	 * @param id: recibve un entero
	 * @throws DAOException
	 */
	public void borrarPeli(int id) throws DAOException;

	/**
	 * Sirve para buscar una pelicula por su identificador
	 * @param id: recibe un entero
	 * @return Pelicula: devuelve un objeto pelicula con todos sus atributos
	 * @throws DAOException
	 */
	public Pelicula findById(int id) throws DAOException;
	/**
	 * Sirve para generar un listado con todos las peliculas
	 * @return Pelicula[]: devuelve un array con todas las peliculas
	 * @throws DAOException
	 */
	public Pelicula[] listarPeliculas() throws DAOException;
	/**
	 * Sirve para listar peliculas segun su categoria
	 * @param categoria: recibe un string
	 * @return Pelicula[]: devuelve un array con el objeto Pelicula con todos sus atributos
	 * @throws DAOException
	 */
	public Pelicula[] listarPeliculasCategorias(String categoria) throws DAOException;
	
}
	
	
