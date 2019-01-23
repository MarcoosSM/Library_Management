package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import conexionBBDD.Connect;
import entidades.Cliente;

public class GestionClientes {

	//atributos
	Connect obj;
	Connection con;
	
	//constructor
	public GestionClientes(String sURL, String user, String pass) {
		this.obj = new Connect(sURL, user, pass);
	}
	
	//metodos
	public boolean altaCliente(Cliente cliente) {
		boolean dadoAlta = false;
		try {
			con = obj.conectar();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM test.clientes WHERE idClientes = ?");
			ps.setInt(1, cliente.getIdCliente());
			ResultSet resultado = ps.executeQuery();
			if (resultado.next()) {
				dadoAlta = false;
			} else {
				ps = con.prepareStatement("INSERT INTO test.clientes (idClientes, DNI, Nombre, Apellidos, Direccion, Poblacion, Telefono ,Email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
				ps.setInt(1, cliente.getIdCliente());
				ps.setString(2, cliente.getDni());
				ps.setString(3, cliente.getNombre());
				ps.setString(4, cliente.getApellidos());
				ps.setString(5, cliente.getDireccion());
				ps.setString(6, cliente.getPoblacion());
				ps.setString(7, cliente.getTelefono());
				ps.setString(8, cliente.getEmail());
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
	
	public boolean bajaCliente(Cliente cliente) {
		boolean dadoBaja = false;
		try {
			con = obj.conectar();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM test.clientes WHERE idClientes = ?");
			ps.setInt(1, cliente.getIdCliente());
			ResultSet resultado = ps.executeQuery();
			if (resultado.next()==false) {
				dadoBaja = false;
			} else {
				ps = con.prepareStatement("DELETE FROM test.clientes WHERE idClientes=?");
				ps.setInt(1, cliente.getIdCliente());
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
	
	public boolean modificacionCliente(Cliente cliente) {
		boolean modificado = false;
		try {
			con = obj.conectar();
			PreparedStatement ps = null;
			ResultSet resultado;
			ps = con.prepareStatement("SELECT * FROM test.clientes WHERE idClientes = ?");
			ps.setInt(1, cliente.getIdCliente());
			resultado = ps.executeQuery();
			if (resultado.next()) {
				ps = con.prepareStatement("UPDATE test.clientes SET DNI=?, Nombre=?, Apellidos=?, Direccion=?, Poblacion=?, Telefono=?, Email=? WHERE idClientes=?");
				ps.setString(1, cliente.getDni());
				ps.setString(2, cliente.getNombre());
				ps.setString(3, cliente.getApellidos());
				ps.setString(4, cliente.getDireccion());
				ps.setString(5, cliente.getPoblacion());
				ps.setString(6, cliente.getTelefono());
				ps.setString(7, cliente.getEmail());
				ps.setInt(8, cliente.getIdCliente());
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
	
	public DefaultTableModel tablaClientes() {
		DefaultTableModel modelo = null;
		try {
			con = obj.conectar();
			Statement st =  (Statement) con.createStatement();
			ResultSet resultado = st.executeQuery("SELECT * FROM test.clientes");
			modelo = new DefaultTableModel();
			modelo.addColumn("Id Cliente");
			modelo.addColumn("DNI");
			modelo.addColumn("Nombre");
			modelo.addColumn("Apellidos");
			modelo.addColumn("Direccion");
			modelo.addColumn("Poblacion");
			modelo.addColumn("Telefono");
			modelo.addColumn("Email");
			while(resultado.next()) {
				Object[] fila = new Object[8];
				for(int i=0; i<8; i++) {
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
	
	public DefaultComboBoxModel<String> dniClienteComboBox() {
		DefaultComboBoxModel<String> modelo = null; 
		try {
			con = obj.conectar();
			Statement st =  (Statement) con.createStatement();
			ResultSet resultado = st.executeQuery("SELECT DNI FROM test.clientes");
			modelo = new DefaultComboBoxModel<String>();
			modelo.addElement("");
			while(resultado.next()) {
				modelo.addElement(resultado.getString(1));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return modelo;
	}
	
	
	public int obtenerIdCliente(String dni) {
		int idCliente = 0;
		try {
			con = obj.conectar();
			PreparedStatement ps = con.prepareStatement("SELECT idClientes FROM test.clientes WHERE DNI = ?");
			ps.setString(1, dni);
			ResultSet resultado = ps.executeQuery();
			resultado.next();
			idCliente = resultado.getInt(1);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return idCliente;
	}
	
	public int idCliente() {
		int idCliente = 0;
		try {
			con = obj.conectar();
			Statement st =  (Statement) con.createStatement();
			ResultSet resultado = st.executeQuery("SELECT MAX(idClientes) FROM test.clientes");
			resultado.next();
			if (resultado.getString(1) != null) {
				idCliente = resultado.getInt(1);
				idCliente++;
			} else {
				idCliente = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idCliente;
	}
}