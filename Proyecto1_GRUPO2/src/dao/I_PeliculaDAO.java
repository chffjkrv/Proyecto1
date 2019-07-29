package dao;

import modelo.Pelicula;

public interface I_PeliculaDAO extends AutoCloseable {

	public void añadirPeli(Pelicula peli) throws DAOException;

	public void modificarPeli(Pelicula peli) throws DAOException;

	public void borrarPeli(int id) throws DAOException;

	public Pelicula findById(int id) throws DAOException;

	public Pelicula[] listarPeliculas() throws DAOException;

}
