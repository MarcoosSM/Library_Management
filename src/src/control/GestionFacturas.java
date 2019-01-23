package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import conexionBBDD.Connect;
import entidades.Factura;

public class GestionFacturas {

	//atributos
	Connect obj;
	Connection con;
	
	//constructor
	public GestionFacturas(String sURL, String user, String pass) {
		this.obj = new Connect(sURL, user, pass);
	}

	//metodos
	public boolean altaFactura(Factura factura) {
		boolean dadoAlta = false;
		try {
			con = obj.conectar();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM test.facturas WHERE idFacturas = ?");
			ps.setInt(1, factura.getIdFactura());
			ResultSet resultado = ps.executeQuery();
			if (resultado.next()) {
				dadoAlta = false;
			} else {
				ps = con.prepareStatement("INSERT INTO test.facturas (idFacturas, idPedido, idCliente, Total_Factura) VALUES (?, ?, ?, ?)");
				ps.setInt(1, factura.getIdFactura());
				ps.setInt(2, factura.getIdPedido());
				ps.setInt(3, factura.getIdCliente());
				ps.setDouble(4, factura.getTotalFactura());
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
	
	public boolean bajaFactura(Factura factura) {
		boolean dadoBaja = false;
		try {
			con = obj.conectar();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM test.facturas WHERE idFacturas = ?");
			ps.setInt(1, factura.getIdFactura());
			ResultSet resultado = ps.executeQuery();
			if (resultado.next()==false) {
				dadoBaja = false;
			} else {
				ps = con.prepareStatement("DELETE FROM test.facturas WHERE idFacturas=?");
				ps.setInt(1, factura.getIdFactura());
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
	
	public boolean modificacionFactura(Factura factura) {
		boolean modificado = false;
		try {
			con = obj.conectar();
			PreparedStatement ps = null;
			ResultSet resultado;
			ps = con.prepareStatement("SELECT * FROM test.facturas WHERE idFacturas = ?");
			ps.setInt(1, factura.getIdFactura());
			resultado = ps.executeQuery();
			if (resultado.next()) {
				ps = con.prepareStatement("UPDATE test.facturas SET idPedido=?, idCliente=?, Total_Factura=? WHERE idFacturas=?");
				ps.setInt(1, factura.getIdPedido());
				ps.setInt(2, factura.getIdCliente());
				ps.setDouble(3, factura.getTotalFactura());
				ps.setInt(4, factura.getIdFactura());
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
	
	public DefaultTableModel tablaFacturas() {
		DefaultTableModel modelo = null;
		try {
			con = obj.conectar();
			Statement st =  (Statement) con.createStatement();
			ResultSet resultado = st.executeQuery("SELECT * FROM test.facturas");
			modelo = new DefaultTableModel();
			modelo.addColumn("Id Factura");
			modelo.addColumn("Id Pedido");
			modelo.addColumn("Id Cliente");
			modelo.addColumn("Total Factura");
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
	
	public int idFactura() {
		int idFactura = 0;
		try {
			con = obj.conectar();
			Statement st =  (Statement) con.createStatement();
			ResultSet resultado = st.executeQuery("SELECT MAX(idFacturas) FROM test.facturas");
			resultado.next();
			if (resultado.getString(1) != null) {
				idFactura = resultado.getInt(1);
				idFactura++;
			} else {
				idFactura = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idFactura;
	}
	
	public double calcularTotal(int idPedido) {
		double totalFactura = 0;
		try {
			con = obj.conectar();
			PreparedStatement ps = null;
			ResultSet resultado;
			ps = con.prepareStatement("SELECT SUM(Precio_Total) FROM test.pedidos WHERE idPedido = ?");
			ps.setInt(1, idPedido);
			resultado = ps.executeQuery();
			resultado.next();
			totalFactura = resultado.getDouble(1);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return totalFactura;
	}
}