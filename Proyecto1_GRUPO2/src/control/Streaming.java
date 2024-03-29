package control;

/**
* @author Grupo2
* 
* @see gui.menu
* @see dao.I_UsuarioDAO
* @see dao.UsuarioDAOFactory
* @see modelo.Usuario
* @see modelo.Pelicula
* @see servicios.UsuarioServ
* @see java.time.LocalDate
* Recoge la opcion elegida y entra en los distintos casos con sus funciones
 */


import utilidades.Datos;
import servicios.PeliculaServ;
import servicios.UsuarioServ;
import modelo.Usuario;
import modelo.Pelicula;
import java.time.LocalDate;
import java.sql.Date;

import dao.I_UsuarioDAO;
import dao.UsuarioDAOFactory;
import gui.Menu;
import servicios.I_PeliculasServ;
import servicios.I_UsuarioServ;
	
public class Streaming {
	 	 
	public boolean sleccionOpciones() {
		
		boolean continuar = true;
		
		try {
			
			Menu.mostrarMenu();
			
			
			switch(Datos.recogeInt()) {
			
			case 1:
				//a�adir pelicula
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
				System.out.println("Introduzca la fecha de nacimiento: ");	
				LocalDate fechaNazi = LocalDate.of(Datos.recogeInt("Introduce el anio:"), Datos.recogeInt("Introduce el mes:"), Datos.recogeInt("Introduce el dia:")); //no me he equivocado, ha sido intencionado.
				nuevoUsuario.setFechaNacimiento(Date.valueOf(fechaNazi));
				System.out.println("Introduzca la cuidad: ");
				nuevoUsuario.setCiudad(Datos.recogeString());
				UsuarioDAOFactory factoryUser=new UsuarioDAOFactory();
				I_UsuarioDAO userDao=factoryUser.createUsuarioDAO();
				userDao.addUsuario(nuevoUsuario);
				
				break;
				
			case 3:
				//Borrar un ususario
				System.out.println("Introduzca el nombre del usuario a borrar: ");
				I_UsuarioServ user = new UsuarioServ();
				user.deleteUsuario(Datos.recogeString());
				
				break;
				
			case 4:
				//Modificar un ususario
				Usuario nuevoUsuario2 = new Usuario();
				System.out.println("Introduzca el nombre del usuario a modificar: ");
				nuevoUsuario2.setNombre(Datos.recogeString()); //no me he equivocado de fecha nazi				
				System.out.println("Introduzca la nueva fecha de nacimiento: ");	
				LocalDate fechaNazi2 = LocalDate.of(Datos.recogeInt("Introduce el anio:"), Datos.recogeInt("Introduce el mes:"), Datos.recogeInt("Introduce el dia:")); //no me he equivocado, ha sido intencionado.
				nuevoUsuario2.setFechaNacimiento(Date.valueOf(fechaNazi2));
				System.out.println("Introduzca la nueva cuidad: ");
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
		String sino = Datos.recogeString(" �Esta seguro? (S/N)");
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
				
			case 3:
				System.out.println("pedimos listado...");
				UsuarioServ userServ = new UsuarioServ();
				Usuario[] arrUser = userServ.getAllUsuarios();
				for (Usuario xxx:  arrUser) {
					System.out.println("empezamos a listar usuarios");
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
