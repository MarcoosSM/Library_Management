package control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import conexionBBDD.Connect;
import entidades.Almacen;

public class GestionAlmacen {
	
	//atributos
	Connect obj;
	Connection con;
	
	//constructor
	public GestionAlmacen(String sURL, String user, String pass) {
		this.obj = new Connect(sURL, user, pass);
	}
	
	//metodos
	public boolean altaAlmacen(Almacen almacen) {
		boolean dadoAlta = false;
		try {
			con = obj.conectar();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM test.almacen WHERE Cod_Almacen = ?");
			ps.setString(1, almacen.getCodAlmacen());
			ResultSet resultado = ps.executeQuery();
			if (resultado.next()) {
				dadoAlta = false;
			} else {
				ps = con.prepareStatement("INSERT INTO test.almacen (Cod_Almacen, Nombre_Almacen, Poblacion, Telefono, Email) VALUES (?, ?, ?, ?, ?)");
				ps.setString(1, almacen.getCodAlmacen());
				ps.setString(2, almacen.getNombreAlmacen());
				ps.setString(3, almacen.getPoblacion());
				ps.setString(4, almacen.getTelefono());
				ps.setString(5, almacen.getEmail());
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
	
	public boolean bajaAlmacen(Almacen almacen) {
		boolean dadoBaja = false;
		try {
			con = obj.conectar();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM test.almacen WHERE Cod_Almacen = ?");
			ps.setString(1, almacen.getCodAlmacen());
			ResultSet resultado = ps.executeQuery();
			if (resultado.next()==false) {
				dadoBaja = false;
			} else {
				ps = con.prepareStatement("DELETE FROM test.almacen WHERE Cod_Almacen=?");
				ps.setString(1, almacen.getCodAlmacen());
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
	
	public boolean modificacionAlmacen(Almacen almacen) {
		boolean modificado = false;
		try {
			con = obj.conectar();
			PreparedStatement ps = null;
			ResultSet resultado;
			ps = con.prepareStatement("SELECT * FROM test.almacen WHERE Cod_Almacen = ?");
			ps.setString(1, almacen.getCodAlmacen());
			resultado = ps.executeQuery();
			if (resultado.next()) {
				ps = con.prepareStatement("UPDATE test.almacen SET Nombre_Almacen=?, Poblacion=?, Telefono=?, Email=? WHERE Cod_Almacen= ?");
				ps.setString(1, almacen.getNombreAlmacen());
				ps.setString(2, almacen.getPoblacion());
				ps.setString(3, almacen.getTelefono());
				ps.setString(4, almacen.getEmail());
				ps.setString(5, almacen.getCodAlmacen());
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
	
	public DefaultTableModel tablaAlmacenes() {
		DefaultTableModel modelo = null;
		try {
			con = obj.conectar();
			Statement st =  (Statement) con.createStatement();
			ResultSet resultado = st.executeQuery("SELECT * FROM test.almacen");
			modelo = new DefaultTableModel();
			modelo.addColumn("Cod. Almacen");
			modelo.addColumn("Nombre");
			modelo.addColumn("Poblacion");
			modelo.addColumn("Telefono");
			modelo.addColumn("Email");
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
	
	public DefaultComboBoxModel<String> codAlmacenComboBox() {
		DefaultComboBoxModel<String> modelo = null; 
		try {
			con = obj.conectar();
			Statement st =  (Statement) con.createStatement();
			ResultSet resultado = st.executeQuery("SELECT Cod_Almacen FROM test.almacen");
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
	
	public String codAlmacen() {
		String codAlmacen = null;
		char[] numero = null;
		try {
			con = obj.conectar();
			Statement st =  (Statement) con.createStatement();
			ResultSet resultado = st.executeQuery("SELECT MAX(Cod_Almacen) FROM test.almacen");
			resultado.next();
			if (resultado.getString(1) != null) {
				codAlmacen = resultado.getString(1);
				numero = codAlmacen.toCharArray();
				if (numero[1] < '9') {
					numero[1] = (char) (numero[1] + 1);
					codAlmacen = new String(numero);	
				}else {
					numero[1] = '9';
					codAlmacen = new String(numero);	
				}
			} else {
				codAlmacen = "01";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codAlmacen;
	}
}