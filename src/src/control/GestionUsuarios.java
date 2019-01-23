package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import conexionBBDD.Connect;
import entidades.Usuario;
import interfaz.VentanaLibreria;

public class GestionUsuarios {

	// atributos
	Connect obj;
	Connection con;

	// constructor
	public GestionUsuarios(String sURL, String user, String pass) {
		this.obj = new Connect(sURL, user, pass);
	}

	// metodos
		public boolean altaUsuario(Usuario usuario) {
			boolean dadoAlta = false;
			try {
				con = obj.conectar();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM test.usuarios WHERE User = ?");
				ps.setString(1, usuario.getUser());
				ResultSet resultado = ps.executeQuery();
				if (resultado.next()) {
					dadoAlta = false;
				} else {
					ps = con.prepareStatement("INSERT INTO test.usuarios (User, Password) VALUES (?, SHA(?))");
					ps.setString(1, usuario.getUser());
					ps.setString(2, usuario.getPass());
					ps.execute();
					ps = con.prepareStatement("INSERT INTO test.permisos_usuarios (User, Permisos) VALUES (?, ?)");
					ps.setString(1, usuario.getUser());
					ps.setInt(2, usuario.getPermisos());
					ps.execute();
					dadoAlta = true;
				}
				resultado.close();
				con.close();
			} catch (SQLIntegrityConstraintViolationException e) {
				JOptionPane.showMessageDialog(VentanaLibreria.Libreria , "Introduzca todos los datos", "Error", 1);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			return dadoAlta;
		}
		
		public boolean altaVendedor(Usuario usuario, String codAlmacen) {
			boolean dadoAlta = false;
			try {
				con = obj.conectar();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM test.vendedores WHERE user = ?");
				ps.setString(1, usuario.getUser());
				ResultSet resultado = ps.executeQuery();
				if (resultado.next()) {
					dadoAlta = false;
				} else {
					ps = con.prepareStatement("INSERT INTO test.vendedores (user, codAlmacen) VALUES (?, ?)");
					ps.setString(1, usuario.getUser());
					ps.setString(2, codAlmacen);
					ps.execute();
					dadoAlta = true;
				}
				resultado.close();
				con.close();
			} catch (SQLIntegrityConstraintViolationException e) {
				JOptionPane.showMessageDialog(VentanaLibreria.Libreria , "Introduzca todos los datos", "Error", 1);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			return dadoAlta;
		}

		public boolean bajaUsuario(Usuario usuario) {
			boolean dadoBaja = false;
			try {
				con = obj.conectar();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM test.usuarios WHERE User = ?");
				ps.setString(1, usuario.getUser());
				ResultSet resultado = ps.executeQuery();
				if (resultado.next() == false) {
					dadoBaja = false;
				} else {
					ps = con.prepareStatement("DELETE FROM test.usuarios WHERE User=?");
					ps.setString(1, usuario.getUser());
					ps.execute();
					dadoBaja = true;
				}
				resultado.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			return dadoBaja;
		}

		public boolean modificacionUsuario(Usuario usuario, int newPermisos) {
			boolean modificado = false;
			try {
				boolean passVacia = false;
				if (usuario.getPass().isEmpty()==true) {
					passVacia = true;
				}
				con = obj.conectar();
				PreparedStatement ps = null;
				ResultSet resultado;
				ps = con.prepareStatement("SELECT * FROM test.usuarios WHERE User = ?");
				ps.setString(1, usuario.getUser());
				resultado = ps.executeQuery();
				if (resultado.next()) {
					if (passVacia == false) {
						ps = con.prepareStatement(
								"UPDATE test.usuarios SET Password=SHA(?) WHERE User= ?");
						ps.setString(1, usuario.getPass());
						ps.setString(2, usuario.getUser());
						ps.execute();
					}
					ps = con.prepareStatement(
							"UPDATE test.permisos_usuarios SET Permisos=? WHERE User= ?");
					ps.setInt(1, newPermisos);
					ps.setString(2, usuario.getUser());
					ps.execute();
					modificado = true;
				} else {
					modificado = false;
				}
				resultado.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return modificado;
		}
		
		public boolean modificacionAlmacenVendedor(Usuario usuario, String codAlmacen) {
			boolean modificado = false;
			try {
				con = obj.conectar();
				PreparedStatement ps = null;
				ResultSet resultado;
				ps = con.prepareStatement("SELECT * FROM test.vendedores WHERE user = ? AND codAlmacen = ?");
				ps.setString(1, usuario.getUser());
				ps.setString(2, codAlmacen);
				resultado = ps.executeQuery();
				if (resultado.next()) {
					ps = con.prepareStatement(
								"UPDATE test.vendedores SET codAlmacen=? WHERE user= ?");
					ps.setString(1, codAlmacen);
					ps.setString(2, usuario.getUser());
					ps.execute();
					modificado = true;
				} else {
					modificado = false;
					altaVendedor(usuario, codAlmacen);
				}
				resultado.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return modificado;
		}

	public int login(Usuario usuario) {
		int permisos = -1;
		try {
			con = obj.conectar();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM test.usuarios WHERE User = ?");
			ps.setString(1, usuario.getUser());
			ResultSet resultado = ps.executeQuery();
			if (resultado.next() == false) {
				permisos = -1;
			} else {
				ps = con.prepareStatement("SELECT Password FROM test.usuarios WHERE User=? AND Password = sha(?)");
				ps.setString(1, usuario.getUser());
				ps.setString(2, usuario.getPass());
				resultado = ps.executeQuery();
				if (resultado.next()) {
					ps = con.prepareStatement("SELECT Permisos FROM test.permisos_usuarios WHERE User = ?");
					ps.setString(1, usuario.getUser());
					resultado = ps.executeQuery();
					resultado.next();
					permisos = resultado.getInt(1);
				} else {
					permisos = -1;
				}
			}
			resultado.close();
			con.close();
		} catch (NullPointerException e) {	
			e.printStackTrace();	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		return permisos;
	}
	
	public DefaultTableModel tablaUsuarios() {
		DefaultTableModel modelo = null;
		try {
			con = obj.conectar();
			Statement st =  (Statement) con.createStatement();
			ResultSet resultado = st.executeQuery("SELECT permisos_usuarios.User, descripcion_permisos.Descripcion FROM test.permisos_usuarios INNER JOIN test.descripcion_permisos ON permisos_usuarios.Permisos=descripcion_permisos.Permisos");
			modelo = new DefaultTableModel();
			modelo.addColumn("User");
			modelo.addColumn("Descripcion");
			while(resultado.next()) {
				Object[] fila = new Object[2];
				for(int i=0; i<2; i++) {
					fila[i] = resultado.getObject(i+1);
				}
				modelo.addRow(fila);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelo;
	}
}