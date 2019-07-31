package modelo;
/**
 * 
 * @author Grupo2
 *
 */
public class Pelicula {

	private int id;
	private String nombre;
	private int agnoPelicula;
	private String categoria;

	public Pelicula() {

	}

	

	public Pelicula(int id, String nombre, int agnoPelicula, String categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.agnoPelicula = agnoPelicula;
		this.categoria = categoria;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
