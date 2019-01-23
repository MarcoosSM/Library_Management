package entidades;

public class Cliente {
	// atributos
	private int idCliente;
	private String dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String poblacion;
	private String telefono;
	private String email;

	// constructor
	public Cliente(int idCliente, String dni, String nombre, String apellidos, String direccion, String poblacion, String telefono, String email) {
		this.idCliente = idCliente;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.telefono = telefono;
		this.email = email;
	}

	// getters and setters
	public int getIdCliente() {
		return idCliente;
	}

	@SuppressWarnings("unused")
	private void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDni() {
		return dni;
	}
	
	@SuppressWarnings("unused")
	private void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}
	
	@SuppressWarnings("unused")
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}
	
	@SuppressWarnings("unused")
	private void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	@SuppressWarnings("unused")
	private void setDireccion(String direccion) {
		this.direccion = direccion;
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
}