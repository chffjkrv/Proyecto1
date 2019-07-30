package servicios;

import dao.DAOException;
import dao.I_PeliculaDAO;
import dao.PeliculaDAOFactory;
import modelo.Pelicula;

public class PeliculaServ implements I_PeliculasServ{

	@Override
	public void crearPeli(Pelicula peli) throws DAOException {
		PeliculaDAOFactory factoryPeli=new PeliculaDAOFactory();
		I_PeliculaDAO peliDao=factoryPeli.createPeliculaDAO();
		peliDao.crearPeli(peli);
		
	}

	@Override
	public void modificarPeli(Pelicula peli) throws DAOException {
		
		
	}

	@Override
	public void borrarPeli(int id) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pelicula findById(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pelicula[] listarPeliculas() throws DAOException {
		
		PeliculaDAOFactory factoryPeli=new PeliculaDAOFactory();
		I_PeliculaDAO peliDao=factoryPeli.createPeliculaDAO();
		
		return peliDao.listarPeliculas();
		
	}

	@Override
	public Pelicula[] listarPeliculasCategorias(String categoria) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
