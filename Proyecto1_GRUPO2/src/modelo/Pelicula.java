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

	/**
	 * @param id: recoge un entero 
	 * @param nombre: recoge un string 
	 * @param agnoPelicula: recoge un entero
	 * @param categoria: recoge un string
	 */
	public Pelicula(int id, String nombre, int agnoPelicula, String categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.agnoPelicula = agnoPelicula;
		this.categoria = categoria;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the agnoPelicula
	 */
	public int getAgnoPelicula() {
		return agnoPelicula;
	}

	/**
	 * @param agnoPelicula the agnoPelicula to set
	 */
	public void setAgnoPelicula(int agnoPelicula) {
		this.agnoPelicula = agnoPelicula;
	}

	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Pelicula [nombre=" + nombre + ", agnoPelicula=" + agnoPelicula + ", categoria=" + categoria
				+ ", toString()=" + super.toString() + "]";

	}

}
