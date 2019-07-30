package control;
import utilidades.Datos;
import servicios.PeliculaServ;
import modelo.Usuario;
import modelo.Pelicula;
import java.time.LocalDate;

import dao.I_PeliculaDAO;
import dao.I_UsuarioDAO;
import dao.PeliculaDAOFactory;
import dao.UsuarioDAOFactory;
import gui.Menu;
import servicios.I_PeliculasServ;
import servicios.PeliculaServ;
	
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
				I_PeliculasServ peli = new PeliculaServ();
				peli.crearPeli(nuevoPelicula);
				
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
				PeliculaServ peliServ = new PeliculaServ();
				Pelicula[] arrPeli = peliServ.listarPeliculas();

				for (Pelicula xxx:  arrPeli) {

<<<<<<< HEAD
					System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-|");
					System.out.println(xxx.getNombre());
					System.out.println(xxx.getAgnoPelicula());
					System.out.println(xxx.getCategoria());
					System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-|");
				}
			
				break;
				
			case 2:	
				PeliculaServ peliServcat = new PeliculaServ();
				Pelicula[] arrPelicat = peliServcat.listarPeliculas();

				for (Pelicula xxx:  arrPelicat) {

					System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-|");
					System.out.println(xxx.getNombre());
					System.out.println(xxx.getAgnoPelicula());
					System.out.println(xxx.getCategoria());
					System.out.println("|*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-|");
=======
					System.out.println("|---------------------------------------------|");
					System.out.println("	[Nombre: "+xxx.getNombre()+"]\n");
					System.out.println("	[Anio estreno: "+xxx.getAgnoPelicula()+"]\n");
					System.out.println("	[Categoria: "+xxx.getCategoria()+"]\n");
					System.out.println("	[Id: "+xxx.getId()+"]\n");
					System.out.println("|---------------------------------------------|");
>>>>>>> 07823bf1cd51c276df23f636f3e22beaf06b631c
				}
			
				break;
			
			case 2:
				System.out.println("Introduzca la categoria que desea buscar:\n");
				String categoria = Datos.recogeString();
				PeliculaServ peliServ1 = new PeliculaServ();
				Pelicula[] arrPeli1 = peliServ1.listarPeliculasCategorias(categoria);
				 for (Pelicula xxx: arrPeli1) {
						System.out.println("|---------------------------------------------|");
						System.out.println("	[Nombre: "+xxx.getNombre()+"]\n");
						System.out.println("	[Anio estreno: "+xxx.getAgnoPelicula()+"]\n");
						System.out.println("	[Categoria: "+xxx.getCategoria()+"]\n");
						System.out.println("	[Id: "+xxx.getId()+"]\n");
						System.out.println("|---------------------------------------------|");
				 }
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
