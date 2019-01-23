package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import conexionBBDD.Connect;
import entidades.Libro;

public class GestionLibreria {
	
	//atributos
	Connect obj;
	Connection con;
	
	//constructor
	public GestionLibreria(String sURL, String user, String pass) {
		this.obj = new Connect(sURL, user, pass);
	}
	
	//metodos
		public boolean altaLibro(Libro libro) {
			boolean dadoAlta = false;
			try {
				con = obj.conectar();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM test.libros WHERE ISBN = ?");
				ps.setString(1, libro.getISBN());
				ResultSet resultado = ps.executeQuery();
				if (resultado.next()) {
					dadoAlta = false;
				} else {
					ps = con.prepareStatement("INSERT INTO test.libros (ISBN, Titulo, Autor, Precio) VALUES (?, ?, ?, ?)");
					ps.setString(1, libro.getISBN());
					ps.setString(2, libro.getTitulo());
					ps.setString(3, libro.getAutor());
					ps.setDouble(4, libro.getPrecio());
					ps.execute();
					dadoAlta = true;
				}
				resultado.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
			return dadoAlta;
		}
		
		public boolean bajaLibro(Libro libro) {
			boolean dadoBaja = false;
			try {
				con = obj.conectar();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM test.libros WHERE ISBN = ?");
				ps.setString(1, libro.getISBN());
				ResultSet resultado = ps.executeQuery();
				if (resultado.next()==false) {
					dadoBaja = false;
				} else {
					ps = con.prepareStatement("DELETE FROM test.libros WHERE ISBN=?");
					ps.setString(1, libro.getISBN());
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
		
		public boolean modificacionLibro(Libro libro) {
			boolean modificado = false;
			try {
				con = obj.conectar();
				PreparedStatement ps = null;
				ResultSet resultado;
				ps = con.prepareStatement("SELECT * FROM test.libros WHERE ISBN = ?");
				ps.setString(1, libro.getISBN());
				resultado = ps.executeQuery();
				if (resultado.next()) {
					ps = con.prepareStatement("UPDATE test.libros SET Titulo=?, Autor=?, Precio=? WHERE ISBN= ?");
					ps.setString(1, libro.getTitulo());
					ps.setString(2, libro.getAutor());
					ps.setDouble(3, libro.getPrecio());
					ps.setString(4, libro.getISBN());
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
		
		public DefaultTableModel tablaLibros() {
			DefaultTableModel modelo = null;
			try {
				con = obj.conectar();
				Statement st =  (Statement) con.createStatement();
				ResultSet resultado = st.executeQuery("SELECT * FROM test.libros");
				modelo = new DefaultTableModel();
				modelo.addColumn("ISBN");
				modelo.addColumn("Titulo");
				modelo.addColumn("Autor");
				modelo.addColumn("Precio");
				while(resultado.next()) {
					Object[] fila = new Object[4];
					for(int i=0; i<4; i++) {
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
		
		public DefaultTableModel buscarLibro(String filtro, String busqueda) {
			DefaultTableModel modelo = null;
			try {
				con = obj.conectar();
				PreparedStatement ps = null; 
				if (filtro == "ISBN") {
					ps = con.prepareStatement("SELECT * FROM test.libros WHERE ISBN=?");
				}
				if (filtro == "Titulo") {
					ps = con.prepareStatement("SELECT * FROM test.libros WHERE Titulo=?");
				}
				if (filtro == "Autor") {
					ps = con.prepareStatement("SELECT * FROM test.libros WHERE Autor=?");
				}
				if (filtro == "Precio") {
					ps = con.prepareStatement("SELECT * FROM test.libros WHERE Precio=?");
				}
				ps.setString(1, busqueda);
				ResultSet resultado = ps.executeQuery();
				modelo = new DefaultTableModel();
				modelo.addColumn("ISBN");
				modelo.addColumn("Titulo");
				modelo.addColumn("Autor");
				modelo.addColumn("Precio");
				while(resultado.next()) {
					Object[] fila = new Object[4];
					for(int i=0; i<4; i++) {
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