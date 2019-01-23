package entidades;

public class Pedido {
	// atributos
	private int idPedido;
	private String isbn;
	private int cantidad;
	private double precioTotal;
	private String fechaPedido;

	// constructor
	public Pedido(int idPedido, String isbn, int cantidad, double precioTotal, String fechaPedido) {
		this.idPedido = idPedido;
		this.isbn = isbn;
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
		this.fechaPedido = fechaPedido;				
	}
	
	// getters and setters
	public int getIdPedido() {
		return idPedido;
	}

	@SuppressWarnings("unused")
	private void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getIsbn() {
		return isbn;
	}

	@SuppressWarnings("unused")
	private void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getCantidad() {
		return cantidad;
	}

	@SuppressWarnings("unused")
	private void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	@SuppressWarnings("unused")
	private void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	@SuppressWarnings("unused")
	private void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
	}
}