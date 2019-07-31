package control;
import utilidades.Datos;
import servicios.PeliculaServ;
import servicios.UsuarioServ;
import modelo.Usuario;
import modelo.Pelicula;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import dao.DAOException;
import dao.I_PeliculaDAO;
import dao.I_UsuarioDAO;
import dao.PeliculaDAOFactory;
import dao.UsuarioDAOFactory;
import gui.Menu;
import servicios.I_PeliculasServ;
import servicios.I_UsuarioServ;
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
				I_UsuarioServ ususaurio = new UsuarioServ();
				ususaurio.addUsuario(nuevoUsuario);
				
				break;
				
			case 3:
				//Borrar un ususario
				Usuario nuevoUsuario1 = new Usuario();
				System.out.println("Introduzca el nombre del usuario: ");
				nuevoUsuario1.setNombre(Datos.recogeString()); //no me he equivocado de fecha nazi
				LocalDate fechaNazi1 = LocalDate.of(Datos.recogeInt(), Datos.recogeInt(), Datos.recogeInt()); //no me he equivocado, ha sido intencionado.
				System.out.println("Introduzca la fecha de nacimiento: " +fechaNazi1.getDayOfMonth()+"/"+fechaNazi1.getDayOfMonth()+"/"+fechaNazi1.getYear());				
				System.out.println("Introduzca la cuidad: ");
				nuevoUsuario1.setCiudad(Datos.recogeString());
				I_UsuarioServ usu = new UsuarioServ();
				usu.deleteUsuario(nuevoUsuario1.getNombre());
				System.out.println("Introduzca el nombre del usuario a borrar: ");
				I_UsuarioServ user = new UsuarioServ();
				user.deleteUsuario(Datos.recogeString());

				
				break;
				
			case 4:
				//Modificar un ususario
				Usuario nuevoUsuario2 = new Usuario();
				System.out.println("Introduzca el nombre del usuario: ");
				nuevoUsuario2.setNombre(Datos.recogeString()); //no me he equivocado de fecha nazi
				LocalDate fechaNazi2 = LocalDate.of(Datos.recogeInt(), Datos.recogeInt(), Datos.recogeInt()); //no me he equivocado, ha sido intencionado.
				System.out.println("Introduzca la fecha de nacimiento: " +fechaNazi2.getDayOfMonth()+"/"+fechaNazi2.getDayOfMonth()+"/"+fechaNazi2.getYear());				
				System.out.println("Introduzca la cuidad: ");
				nuevoUsuario2.setCiudad(Datos.recogeString());
				I_UsuarioServ usu1 = new UsuarioServ();
				usu1.updateUsuario(nuevoUsuario2);
				
				
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
				PeliculaServ peliServcat = new PeliculaServ();
				Pelicula[] arrPelicat = peliServcat.listarPeliculas();

				for (Pelicula xxx:  arrPelicat) {


					System.out.println("|---------------------------------------------|");
					System.out.println("	[Nombre: "+xxx.getNombre()+"]\n");
					System.out.println("	[Anio estreno: "+xxx.getAgnoPelicula()+"]\n");
					System.out.println("	[Categoria: "+xxx.getCategoria()+"]\n");
					System.out.println("	[Id: "+xxx.getId()+"]\n");
					System.out.println("|---------------------------------------------|");

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
				
			case 6:
				UsuarioServ userServ = new UsuarioServ();
				Usuario[] arrUser = userServ.getAllUsuarios();

				for (Usuario xxx:  arrUser) {
					System.out.println("|---------------------------------------------|");
					System.out.println("	[Nombre: "+xxx.getNombre()+"]\n");
					System.out.println("	[Fecha de Nacimiento: "+xxx.getFechaNacimiento()+"]\n");
					System.out.println("	[Ciudad: "+xxx.getCiudad()+"]\n");
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
