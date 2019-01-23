package entidades;

public class Stock {
	
	//atributos
	private String ISBN;
	private String codAlmacen;
	private int cantidad;
	
	//constructor
	public Stock(String ISBN, String codAlmacen, int cantidad) {
		this.ISBN=ISBN;
		this.codAlmacen=codAlmacen;
		this.cantidad=cantidad;
	}

	//getters and setters
	public String getISBN() {
		return ISBN;
	}

	@SuppressWarnings("unused")
	private void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getCodAlmacen() {
		return codAlmacen;
	}

	@SuppressWarnings("unused")
	private void setCodAlmacen(String codAlmacen) {
		this.codAlmacen = codAlmacen;
	}

	public int getCantidad() {
		return cantidad;
	}

	@SuppressWarnings("unused")
	private void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	//metodos
	@Override
	public String toString() {
		return "Datos Stock [ISBN: " + ISBN + ", Cod. Almacen: " + codAlmacen + ", Cantidad de Libros: " + cantidad  + " ]";
	}
}