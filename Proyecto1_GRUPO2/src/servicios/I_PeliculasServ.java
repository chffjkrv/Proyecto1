package servicios;

import dao.DAOException;
import modelo.Pelicula;
/**
 * 
 * @author Grupo2
 *
 */
public interface I_PeliculasServ {
	public void crearPeli(Pelicula peli) throws DAOException;

	public void modificarPeli(Pelicula peli) throws DAOException;

	public void borrarPeli(int id) throws DAOException;

	public Pelicula findById(int id) throws DAOException;

	public Pelicula[] listarPeliculas() throws DAOException;
	
	public Pelicula[] listarPeliculasCategorias(String categoria) throws DAOException;
}
