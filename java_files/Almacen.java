package entidades;

public class Almacen {

	//atributos
	private String codAlmacen;
	private String nombreAlmacen;
	private String poblacion;
	private String telefono;
	private String email;
	
	//constructor
	public Almacen(String codAlmacen, String nombreAlmacen, String poblacion, String telefono, String email) {
		this.codAlmacen=codAlmacen;
		this.nombreAlmacen=nombreAlmacen;
		this.poblacion=poblacion;
		this.telefono=telefono;
		this.email=email;
	}

	//getters and setters
	public String getCodAlmacen() {
		return codAlmacen;
	}

	@SuppressWarnings("unused")
	private void setCodAlmacen(String codAlmacen) {
		this.codAlmacen = codAlmacen;
	}

	public String getNombreAlmacen() {
		return nombreAlmacen;
	}

	@SuppressWarnings("unused")
	private void setNombreAlmacen(String nombreAlmacen) {
		this.nombreAlmacen = nombreAlmacen;
	}

	public String getPoblacion() {
		return poblacion;
	}

	@SuppressWarnings("unused")
	private void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getTelefono() {
		return telefono;
	}

	@SuppressWarnings("unused")
	private void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	@SuppressWarnings("unused")
	private void setEmail(String email) {
		this.email = email;
	}
	
	//metodos
	@Override
	public String toString() {
		return "Datos Almacen [Cod. Almacen: " + codAlmacen + ", Nombre Almacen: " + nombreAlmacen + ", Población: " + poblacion + ", Telefono: " + telefono + ", Email: " + email + " ]";
	}
}