package servicios;
import modelo.Pelicula;
import modelo.Usuario;

import java.util.ArrayList;



public interface I_Listados {
	
	public ArrayList<Usuario> ListarUsuario();
		
	public ArrayList<Pelicula> ListarPeliculas();
	
	public ArrayList<Pelicula> ListarPeliculasCategoria(String categoria);
	
	public ArrayList<Pelicula> ListarPeliculasPorUsuario();
	
}
