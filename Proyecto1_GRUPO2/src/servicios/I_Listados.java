package servicios;
import modelo.Pelicula;
import modelo.Usuario;

import java.util.ArrayList;

import dao.DAOException;



public interface I_Listados {
	
	public ArrayList<Usuario> ListarUsuario() throws DAOException;
		
	public ArrayList<Pelicula> ListarPeliculas() throws DAOException;
	
	public ArrayList<Pelicula> ListarPeliculasCategoria(String categoria) throws DAOException;
	
	public ArrayList<Pelicula> ListarPeliculasPorUsuario() throws DAOException;
	
}
