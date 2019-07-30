package dao;

import java.sql.Connection;
import java.util.ArrayList;

import modelo.Pelicula;
import modelo.Usuario;
import servicios.I_Listados;

public class ListarDAOJDBCImpl implements I_Listados {

	private Connection con = null;
	
	ListarDAOJDBCImpl(){
		con = new ConexionDB().getConnection();
	}
	
	@Override
	public ArrayList<Usuario> ListarUsuario() throws DAOException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		
		return usuarios;
	}

	@Override
	public ArrayList<Pelicula> ListarPeliculas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Pelicula> ListarPeliculasCategoria(String categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Pelicula> ListarPeliculasPorUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Usuario> ListarUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

}
