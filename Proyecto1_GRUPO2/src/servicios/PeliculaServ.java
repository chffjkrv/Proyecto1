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
		PeliculaDAOFactory factoryPeli=new PeliculaDAOFactory();
		I_PeliculaDAO peliDao=factoryPeli.createPeliculaDAO();
		peliDao.modificarPeli(peli);
		
	}

	@Override
	public void borrarPeli(int id) throws DAOException {
		PeliculaDAOFactory factoryPeli=new PeliculaDAOFactory();
		I_PeliculaDAO peliDao=factoryPeli.createPeliculaDAO();
		peliDao.borrarPeli(id);		
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
		PeliculaDAOFactory factoryPeli=new PeliculaDAOFactory();
		I_PeliculaDAO peliDao=factoryPeli.createPeliculaDAO();
		
		return peliDao.listarPeliculasCategorias(categoria);	
	}

}
