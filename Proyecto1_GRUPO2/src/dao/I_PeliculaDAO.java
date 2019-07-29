package dao;

import modelo.Pelicula;

<<<<<<< HEAD
public interface I_PeliculaDAO {

	public void aniadirPelicula(Pelicula peli) throws DAOException;
=======
public interface I_PeliculaDAO extends AutoCloseable {

	public void añadirPeli(Pelicula peli) throws DAOException;

	public void modificarPeli(Pelicula peli) throws DAOException;

	public void borrarPeli(int id) throws DAOException;

	public Pelicula findById(int id) throws DAOException;

	public Pelicula[] listarPeliculas() throws DAOException;

>>>>>>> 008b9229fe7c995d85e763453366f63717d023e2
}
