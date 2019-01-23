package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import conexionBBDD.Connect;
import entidades.Pedido;
import entidades.Usuario;
import interfaz.VentanaLibreria;

public class GestionPedidos {

	//atributos
	Connect obj;
	Connection con;
	
	//constructor
	public GestionPedidos(String sURL, String user, String pass) {
		this.obj = new Connect(sURL, user, pass);
	}
	
	//metodos
	public boolean altaPedido(Pedido pedido, String codAlmacen) {
		boolean dadoAlta = false;
		try {
			con = obj.conectar();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM test.pedidos WHERE idPedido = ? AND ISBN = ?");
			ps.setInt(1, pedido.getIdPedido());
			ps.setString(2, pedido.getIsbn());
			ResultSet resultado = ps.executeQuery();
			if (resultado.next()) {
				dadoAlta = false;
			} else {
				ps = con.prepareStatement("INSERT INTO test.pedidos VALUES (?, ?, ?, ?, ?)");
				ps.setInt(1, pedido.getIdPedido());
				ps.setString(2, pedido.getIsbn());
				ps.setInt(3, pedido.getCantidad());
				ps.setDouble(4, pedido.getPrecioTotal());
				ps.setString(5, pedido.getFechaPedido());
				ps.execute();
				dadoAlta = true;
				restarStock(pedido, codAlmacen);
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
	
	public boolean bajaPedido(Pedido pedido) {
		boolean dadoBaja = false;
		try {
			con = obj.conectar();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM test.pedidos WHERE idPedido = ?");
			ps.setInt(1, pedido.getIdPedido());
			ResultSet resultado = ps.executeQuery();
			if (resultado.next()==false) {
				dadoBaja = false;
			} else {
				ps = con.prepareStatement("DELETE FROM test.pedidos WHERE idPedido=?");
				ps.setInt(1, pedido.getIdPedido());
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
	
	public boolean modificacionPedido(Pedido pedido) {
		boolean modificado = false;
		try {
			con = obj.conectar();
			PreparedStatement ps = null;
			ResultSet resultado;
			ps = con.prepareStatement("SELECT * FROM test.pedidos WHERE idPedido = ?");
			ps.setInt(1, pedido.getIdPedido());
			resultado = ps.executeQuery();
			if (resultado.next()) {
				ps = con.prepareStatement("UPDATE test.pedidos SET ISBN=?, Cantidad=?, Precio_Total=?, Fecha_Pedido=? WHERE idPedido=?");
				ps.setString(1, pedido.getIsbn());
				ps.setInt(2, pedido.getCantidad());
				ps.setDouble(3, pedido.getPrecioTotal());
				ps.setString(4, pedido.getFechaPedido());
				ps.setInt(5, pedido.getIdPedido());
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
	
	public DefaultTableModel tablaPedidos() {
		DefaultTableModel modelo = null;
		try {
			con = obj.conectar();
			Statement st =  (Statement) con.createStatement();
			ResultSet resultado = st.executeQuery("SELECT * FROM test.pedidos");
			modelo = new DefaultTableModel();
			modelo.addColumn("Id Pedido");
			modelo.addColumn("ISBN");
			modelo.addColumn("Cantidad");
			modelo.addColumn("Precio Total");
			modelo.addColumn("Fecha Pedido");
			while(resultado.next()) {
				Object[] fila = new Object[5];
				for(int i=0; i<5; i++) {
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
	
	public DefaultComboBoxModel<String> isbnComboBox(Usuario usuario) {
		DefaultComboBoxModel<String> modelo = null; 
		try {
			con = obj.conectar();
			PreparedStatement ps = null;
			ResultSet resultado;
			ps = con.prepareStatement("SELECT ISBN FROM test.stock WHERE Cod_Almacen = ?");
			String codAlmacen = codAlmacenVendedor(usuario.getUser());
			ps.setString(1, codAlmacen);
			resultado = ps.executeQuery();
			modelo = new DefaultComboBoxModel<String>();
			while(resultado.next()) {
				modelo.addElement(resultado.getString(1));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return modelo;
	}
	
	public int idPedido() {
		int idPedido = 0;
		try {
			con = obj.conectar();
			Statement st =  (Statement) con.createStatement();
			ResultSet resultado = st.executeQuery("SELECT MAX(idPedido) FROM test.pedidos");
			resultado.next();
			if (resultado.getString(1) != null) {
				idPedido = resultado.getInt(1);
				idPedido++;
			} else {
				idPedido = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idPedido;
	}
	
	public String fechaActualPedido() {
		String fechaActual;
		Calendar fecha = Calendar.getInstance();
		int año = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH);
		int dia = fecha.get(Calendar.DAY_OF_MONTH);
		fechaActual = año + "-" + (mes + 1) + "-" + dia;
		return fechaActual;
	}
	
	public double precioTotalPedido(String isbn, int cantidad) {
		double precioTotal = 0;
		try {
			con = obj.conectar();
			PreparedStatement ps = null;
			ResultSet resultado;
			ps = con.prepareStatement("SELECT Precio FROM test.libros WHERE ISBN = ?");
			ps.setString(1, isbn);
			resultado = ps.executeQuery();
			resultado.next();
			precioTotal = resultado.getDouble(1)*cantidad;
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return precioTotal;		
	}
	
	public int maxCantidadPedido(String isbn, Usuario usuario) {
		int max=0;
		try {
			con = obj.conectar();
			PreparedStatement ps = null;
			ResultSet resultado;
			ps = con.prepareStatement("SELECT Cantidad FROM test.stock WHERE ISBN = ? AND Cod_Almacen=?");
			ps.setString(1, isbn);
			String codAlmacen = codAlmacenVendedor(usuario.getUser());
			ps.setString(2, codAlmacen);
			resultado = ps.executeQuery();
			resultado.next();
			max = resultado.getInt(1);
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(VentanaLibreria.Libreria, "Almacen sin stock", "Advertencia", JOptionPane.WARNING_MESSAGE);
		}
		return max;
	}
	
	public String codAlmacenVendedor(String user) {
		String codAlmacen = null;
		try {
			con = obj.conectar();
			PreparedStatement ps = null;
			ResultSet resultado;
			ps = con.prepareStatement("SELECT codAlmacen FROM test.vendedores WHERE user = ?");
			ps.setString(1, user);
			resultado = ps.executeQuery();
			if (resultado.next()) {
				codAlmacen = resultado.getString(1);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return codAlmacen;	
	}
	
	private void restarStock(Pedido pedido, String codAlmacen) {
		try {
			con = obj.conectar();
			PreparedStatement ps = null;
			ps = con.prepareStatement("UPDATE test.stock SET Cantidad=(Cantidad-?) WHERE Cod_Almacen=? AND ISBN=?");
			ps.setInt(1, pedido.getCantidad());
			ps.setString(2, codAlmacen);
			ps.setString(3, pedido.getIsbn());
			ps.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}