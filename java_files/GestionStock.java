package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import conexionBBDD.Connect;
import entidades.Stock;
import interfaz.VentanaLibreria;

public class GestionStock {

	// atributos
	Connect obj;
	Connection con;

	// constructor
	public GestionStock(String sURL, String user, String pass) {
		this.obj = new Connect(sURL, user, pass);
	}

	// metodos
	public boolean altaStock(Stock stock) {
		boolean dadoAlta = false;
		try {
			con = obj.conectar();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM test.stock WHERE ISBN = ? AND Cod_Almacen= ?");
			ps.setString(1, stock.getISBN());
			ps.setString(2, stock.getCodAlmacen());
			ResultSet resultado = ps.executeQuery();
			if (resultado.next()) {
				dadoAlta = false;
			} else {
				ps = con.prepareStatement(
						"INSERT INTO test.stock (ISBN, Cod_Almacen, Cantidad) VALUES (?, ?, ?)");
				ps.setString(1, stock.getISBN());
				ps.setString(2, stock.getCodAlmacen());
				ps.setInt(3, stock.getCantidad());
				ps.execute();
				dadoAlta = true;
			}
			resultado.close();
			con.close();
		} catch (SQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(VentanaLibreria.Libreria , "Almacen no seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}	
		return dadoAlta;
	}

	public boolean bajaStock(Stock stock) {
		boolean dadoBaja = false;
		try {
			con = obj.conectar();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM test.stock WHERE ISBN = ? AND Cod_Almacen= ?");
			ps.setString(1, stock.getISBN());
			ps.setString(2, stock.getCodAlmacen());
			ResultSet resultado = ps.executeQuery();
			if (resultado.next() == false) {
				dadoBaja = false;
			} else {
				ps = con.prepareStatement("DELETE FROM test.stock WHERE ISBN= ? AND Cod_Almacen= ?");
				ps.setString(1, stock.getISBN());
				ps.setString(2, stock.getCodAlmacen());
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

	public boolean modificacionStock(Stock stock, String oldCodAlmacen) {
		boolean modificado = false;
		try {
			con = obj.conectar();
			PreparedStatement ps = null;
			ResultSet resultado;
			ps = con.prepareStatement("SELECT * FROM test.stock WHERE Cod_Almacen = ? AND ISBN = ?");
			ps.setString(1, oldCodAlmacen);
			ps.setString(2, stock.getISBN());
			resultado = ps.executeQuery();
			if (resultado.next()) {
				ps = con.prepareStatement(
						"UPDATE test.stock SET Cod_Almacen=?, Cantidad=? WHERE Cod_Almacen = ? AND ISBN = ?");
				ps.setString(1, stock.getCodAlmacen());
				ps.setInt(2, stock.getCantidad());
				ps.setString(3, oldCodAlmacen);
				ps.setString(4, stock.getISBN());
				ps.execute();
				modificado = true;
			} else {
				modificado = false;
			}
			resultado.close();
			con.close();
		} catch (MySQLIntegrityConstraintViolationException e) {
			JOptionPane.showMessageDialog(VentanaLibreria.Libreria , "Libro ya existente en el almacen seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modificado;
	}
	
	public DefaultTableModel tablaStock() {
		DefaultTableModel modelo = null;
		try {
			con = obj.conectar();
			Statement st =  (Statement) con.createStatement();
			ResultSet resultado = st.executeQuery("SELECT * FROM test.stock");
			modelo = new DefaultTableModel();
			modelo.addColumn("ISBN");
			modelo.addColumn("Cod. Almacen");
			modelo.addColumn("Cantidad");
			while(resultado.next()) {
				Object[] fila = new Object[3];
				for(int i=0; i<3; i++) {
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
	
	public DefaultTableModel buscarStock(String filtro, String busqueda) {
		DefaultTableModel modelo = null;
		try {
			con = obj.conectar();
			PreparedStatement ps = null; 
			if (filtro == "ISBN") {
				ps = con.prepareStatement("SELECT * FROM test.stock WHERE ISBN=?");
			}
			if (filtro == "Cod. Almacen") {
				ps = con.prepareStatement("SELECT * FROM test.stock WHERE Cod_Almacen=?");
			}
			ps.setString(1, busqueda);
			ResultSet resultado = ps.executeQuery();
			modelo = new DefaultTableModel();
			modelo.addColumn("ISBN");
			modelo.addColumn("Cod. Almacen");
			modelo.addColumn("Cantidad");
			while(resultado.next()) {
				Object[] fila = new Object[3];
				for(int i=0; i<3; i++) {
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