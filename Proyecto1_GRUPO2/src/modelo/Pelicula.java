package modelo;

public class Pelicula {

		String nombre;
		int agnoPelicula;
		String categoria;
		
		public Pelicula() {
			
		}
		public Pelicula(String nombre, int agnoPelicula, String categoria) {
			super();
			this.nombre = nombre;
			this.agnoPelicula = agnoPelicula;
			this.categoria = categoria;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public int getAgnoPelicula() {
			return agnoPelicula;
		}
		public void setAgnoPelicula(int agnoPelicula) {
			this.agnoPelicula = agnoPelicula;
		}
		public String getCategoria() {
			return categoria;
		}
		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}
		@Override
		public String toString() {
			return "Pelicula [nombre=" + nombre + ", agnoPelicula=" + agnoPelicula + ", categoria=" + categoria
					+ ", toString()=" + super.toString() + "]";
		}
		
}
