package servicios;
import modelo.Pelicula;
import modelo.Usuario;

import java.util.ArrayList;

import dao.DAOException;



public interface I_Listados {
	
<<<<<<< HEAD
	public ArrayList<Usuario> ListarUsuario() throws DAOException;
=======
<<<<<<< HEAD
	public void ListarUsuario();
	public void ListarPeliculas();

=======
	public ArrayList<Usuario> ListarUsuario();
>>>>>>> 11f11a008b58225ad404bc2da87c12a2d0336032
		
	public ArrayList<Pelicula> ListarPeliculas() throws DAOException;
	
	public ArrayList<Pelicula> ListarPeliculasCategoria(String categoria) throws DAOException;
	
	public ArrayList<Pelicula> ListarPeliculasPorUsuario() throws DAOException;
	
>>>>>>> 051f7204b862286b7fae2e97ff7bd756ca605688
}
