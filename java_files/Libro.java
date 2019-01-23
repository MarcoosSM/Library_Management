package entidades;

public class Libro {
	
	//atributos
	private String ISBN;
	private String titulo;
	private String autor;
	private double precio;
	
	//constructor
	public Libro(String ISBN,String titulo,String autor,double precio) {
		this.ISBN=ISBN;
		this.titulo=titulo;
		this.autor=autor;
		this.precio=precio;
	}

	//getters and setters
	public String getISBN() {
		return ISBN;
	}

	@SuppressWarnings("unused")
	private void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	@SuppressWarnings("unused")
	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	@SuppressWarnings("unused")
	private void setAutor(String autor) {
		this.autor = autor;
	}

	public double getPrecio() {
		return precio;
	}

	@SuppressWarnings("unused")
	private void setPrecio(int precio) {
		this.precio = precio;
	}
	
	//metodos
	@Override
	public String toString() {
		return "Datos Libro [ISBN: " + ISBN + ", Titulo: " + titulo + ", Autor: " + autor + ", Precio: " + precio + " €]";
	}
}