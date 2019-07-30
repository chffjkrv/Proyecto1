package control;
import utilidades.Datos;
import modelo.Usuario;
import modelo.Pelicula;
import java.time.LocalDate;

import dao.I_PeliculaDAO;
import dao.I_UsuarioDAO;
import dao.PeliculaDAOFactory;
import dao.UsuarioDAOFactory;
import gui.Menu;

	
public class Streaming {
	 	 
	public boolean sleccionOpciones() {
		
		boolean continuar = true;
		
		try {
			
			Menu.mostrarMenu();
			
			
			switch(Datos.recogeInt()) {
			
			case 1:
				//añadir pelicula
				Pelicula nuevoPelicula = new Pelicula();
				System.out.println("Introduzca Nombre de la pelicula: ");
				nuevoPelicula.setNombre(Datos.recogeString());
				System.out.println("Introduzca el agno de estreno: ");
				nuevoPelicula.setAgnoPelicula(Datos.recogeInt());
				System.out.println("Introduzca la categoria de la pelicula: ");
				nuevoPelicula.setCategoria(Datos.recogeString());
				PeliculaDAOFactory factoryPeli=new PeliculaDAOFactory();
				I_PeliculaDAO peliDao=factoryPeli.createPeliculaDAO();
				peliDao.crearPeli(nuevoPelicula);
				
				break;
				
			case 2:
				//Alta de un ususarios
				Usuario nuevoUsuario = new Usuario();
				System.out.println("Introduzca el nombre del usuario: ");
				nuevoUsuario.setNombre(Datos.recogeString()); //no me he equivocado de fecha nazi
				LocalDate fechaNazi = LocalDate.of(Datos.recogeInt(), Datos.recogeInt(), Datos.recogeInt()); //no me he equivocado, ha sido intencionado.
				System.out.println("Introduzca la fecha de nacimiento: " +fechaNazi.getDayOfMonth()+"/"+fechaNazi.getDayOfMonth()+"/"+fechaNazi.getYear());				
				System.out.println("Introduzca la cuidad: ");
				nuevoUsuario.setCiudad(Datos.recogeString());
				UsuarioDAOFactory factoryUser=new UsuarioDAOFactory();
				I_UsuarioDAO userDao=factoryUser.createUsuarioDAO();
				userDao.addUsuario(nuevoUsuario);
				
				break;
			
			case 5:
				//listados
				Menu.menuListados();
				elegirListado(Datos.recogeInt());
				
				break;
				
			
			case 0:
				
				continuar = salir();
				
				break;
			}
			
		}catch (Exception e) {
			System.out.println("error: "+ e.toString());
		}
		return continuar;
	}
	
	private boolean salir() throws Exception{
		String sino = Datos.recogeString(" ¿Esta seguro? (S/N)");
		return (sino.toUpperCase().charAt(0)!='S');
	}
	
	private boolean elegirListado(int opcion) {
		
		boolean continuar = true;
		
		try {
			
			switch(opcion) {
			
			case 1:
				
				//dao.I_PeliculaDAO.listarPeliculas();
			
				break;
				
			case 0:
				
				continuar = salir();
				
				break;			
			}
			
		}catch(Exception e){
			System.out.println("error: "+e.toString());
		}
		return continuar;
	}
	
}
