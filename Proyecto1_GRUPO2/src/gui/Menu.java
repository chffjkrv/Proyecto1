package gui;

public class Menu {
	
	public static void mostrarMenu() {
		System.out.println(" ");
		System.out.println(" Sistema de video streaming ");
		System.out.println("****************************************");
		System.out.println(" 	Por favor, escoga una opcion:	 ");
		System.out.println("    	1.Crear película");
		System.out.println("    	2.Crear usuario");
		System.out.println("    	3.Borar usuario");
		System.out.println("    	4.Modificar usuario");
		System.out.println("		5.Listados");
	}
	
	public static void menuListados() {
		System.out.flush();
		System.out.println(" 		Opciones  para listados:		");
		System.out.println("			1.Listado de peliculas");
		System.out.println("			2.Listado de peliculas por categoria");
		System.out.println("			3.Listado de peliculas mas vistas");
		System.out.println("			4.Listado de peliculas mas valoradas");
		System.out.println("			5.Listado de peliculas menos vistas");
		System.out.println("			6..Listado de usuario");
	}
}
