package entidades;

public class Usuario {
	
	//atributos
	private String user;
	private String pass;
	private int permisos;
	
	//constructor
	public Usuario(String user, String pass, int permisos) {
		this.user = user;
		this.pass = pass;
		this.permisos = permisos;
	}

	//getters and setters
	public String getUser() {
		return user;
	}

	@SuppressWarnings("unused")
	private void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	@SuppressWarnings("unused")
	private void setPass(String pass) {
		this.pass = pass;
	}

	public int getPermisos() {
		return permisos;
	}

	@SuppressWarnings("unused")
	private void setPermisos(int permisos) {
		this.permisos = permisos;
	}
}
