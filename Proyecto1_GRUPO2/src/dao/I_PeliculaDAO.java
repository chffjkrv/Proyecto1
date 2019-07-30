package dao;

import modelo.Pelicula;

public interface I_PeliculaDAO extends AutoCloseable {

	public void crearPeli(Pelicula peli) throws DAOException;

	public void modificarPeli(Pelicula peli) throws DAOException;

	public void borrarPeli(int id) throws DAOException;

	public Pelicula findById(int id) throws DAOException;

	public Pelicula[] listarPeliculas() throws DAOException;
	
	public Pelicula[] listarPeliculasCategorias(String categoria) throws DAOException;
	
}
	
	
