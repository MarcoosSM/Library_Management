package conexionBBDD;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

import interfaz.VentanaLibreria;

public class Connect {

	//atributos
	String sURL;
	String user;
	String pass;
	
	//constructor
	public Connect(String sURL, String user, String pass) {
		this.sURL = sURL;
		this.user = user;
		this.pass = pass;
	}
	
	//metodos
	public Connection conectar() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(this.sURL,this.user,this.pass);
		} catch (CommunicationsException e) {	
			JOptionPane.showMessageDialog(VentanaLibreria.Libreria, "Base de datos no conectada", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}