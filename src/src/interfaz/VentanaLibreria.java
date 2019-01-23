package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import control.GestionAlmacen;
import control.GestionClientes;
import control.GestionFacturas;
import control.GestionLibreria;
import control.GestionPedidos;
import control.GestionStock;
import control.GestionUsuarios;
import entidades.Almacen;
import entidades.Cliente;
import entidades.Factura;
import entidades.Libro;
import entidades.Pedido;
import entidades.Stock;
import entidades.Usuario;

public class VentanaLibreria {

	// ventana
	private String sURL = "jdbc:mysql://localhost:3306/test";
	private String userBBDD = "root";
	private String passBBDD = "";
	private GestionLibreria gLibros = new GestionLibreria(sURL, userBBDD, passBBDD);
	private GestionStock gStock = new GestionStock(sURL, userBBDD, passBBDD);
	private GestionAlmacen gAlmacen = new GestionAlmacen(sURL, userBBDD, passBBDD);
	private GestionUsuarios gUsuarios = new GestionUsuarios(sURL, userBBDD, passBBDD);
	private GestionPedidos gPedidos = new GestionPedidos(sURL, userBBDD, passBBDD);
	private GestionClientes gClientes = new GestionClientes(sURL, userBBDD, passBBDD);
	private GestionFacturas gFacturas = new GestionFacturas(sURL, userBBDD, passBBDD);
	public static JFrame Libreria;
	private JTextField textUser;
	private JTextField textUserAlta;
	private JPanel panelRegistro;
	private JLabel lblUserAlta;
	private JLabel lblPassAlta;
	private JButton btnAlta;
	private JButton btnCancelarAlta;
	private JLabel lblTituloAlta;
	private JButton btnRegistro;
	private JPanel panelInicioSesion;
	private JLabel lblUser;
	private JLabel lblPass;
	private JButton btnLogin;
	private JLabel lblTituloLogin;
	private JPasswordField passwordAlta;
	private JPasswordField passwordLogin;
	private JPanel panelConsultor;
	private JLabel lblTituloConsultor;
	private JPanel panelGestor;
	private JPanel panelAdmin;
	private JLabel lblTituloGestor;
	private JButton btnGestionarLibros;
	private JButton btnGestionarStock;
	private JButton btnGestionarAlmacenes;
	private JButton btnSalirGestor;
	private JButton btnSalirConsultor;
	private JButton btnConsultarAlmacenes;
	private JButton btnConsultarStock;
	private JButton btnConsultarLibros;
	private JLabel lblTituloAdmin;
	private JButton btnAdminLibros;
	private JButton btnAdminStock;
	private JButton btnAdminAlmacenes;
	private JButton btnSalirAdmin;
	private JButton btnAdminUsuarios;
	private JPanel panelConsultasLibros;
	private JTable tablaLibros;
	private JButton btnAtrasLibros;
	private JTable tablaStock;
	private JButton btnAtrasStock;
	private JPanel panelConsultasAlmacenes;
	private JTable tablaAlmacenes;
	private JButton btnAtrasAlmacenes;
	private JPanel panelConsultasStock;
	private JPanel panelGestorLibros;
	private JLabel lblGestionarLibros;
	private JPanel panelNorteGLibros;
	private JPanel panelSurCLibros;
	private JPanel panelSurCStock;
	private JPanel panelSurCAlmacenes;
	private JTable tablaGLibros;
	private JTextField textISBN;
	private JTextField textTitulo;
	private JLabel lblTitulo;
	private JTextField textAutor;
	private JLabel lblAutor;
	private JTextField textPrecio;
	private JLabel lblPrecio;
	private JButton btnAltaGLibros;
	private JButton btnBajaGLibros;
	private JButton btnModificarGLibros;
	private JButton btnAtrasGLibros;
	private JPanel panelGestorStock;
	private JPanel panelNorteGStock;
	private JLabel lblGestionarStock;
	private JPanel panelCentroGStock;
	private JPanel panelTablaGStock;
	private JTextField textISBNStock;
	private JLabel lblISBNStock;
	private JLabel lblCodAlmacenStock;
	private JLabel lblCantidad;
	private JButton btnBajaStock;
	private JButton btnModificarStock;
	private JButton btnAtrasGStock;
	private JPanel panelNorteGAlmacenes;
	private JLabel lblGestionarAlmacenes;
	private JPanel panelCentroAlmacenes;
	private JPanel panelTablaGAlmacenes;
	private JTextField textCodAlmacenGAlmacenes;
	private JTextField textNombreAlmacen;
	private JLabel lblCodAlmacen;
	private JLabel lblNombre;
	private JTextField textPoblacion;
	private JLabel lblPoblacion;
	private JTextField textTelefono;
	private JLabel lblTelefono;
	private JButton btnAltaGAlmacenes;
	private JButton btnBajaGAlmacenes;
	private JButton btnModificarGAlmacenes;
	private JButton btnAtrasGAlmacenes;
	private JPanel panelNorteGUsuarios;
	private JLabel lblGestionarUsuarios;
	private JPanel panelCentroGUsuarios;
	private JPanel panelTablaGUsuarios;
	private JTextField textUserGUsuarios;
	private JTextField textPassGUsuarios;
	private JLabel lblUserGUsuarios;
	private JLabel lblDescripcion;
	private JLabel lblPermisos;
	private JButton btnAltaGUsuarios;
	private JButton btnBajaGUsuarios;
	private JButton btnModificarGUsuarios;
	private JButton btnAtrasGUsuarios;
	private JTable tablaGStock;
	private JTextField textEmail;
	private JTable tablaGAlmacenes;
	private JTable tablaGUsuarios;
	private JComboBox<String> comboBoxPermisos;
	private JScrollPane scrollPaneGUsuarios;
	private JPanel panelGestorUsuarios;
	private JLabel lblEmail; 
	private JPanel panelCentroGLibros;
	private JPanel panelTablaGLibros;
	private JScrollPane scrollPaneGAlmacenes;
	private JPanel panelGestorAlmacenes;
	private JSpinner spinnerCantidad;
	private JScrollPane scrollPaneGStock; 
	private JLabel lblIsbn;
	private JScrollPane scrollPaneGLibros;
	private JButton btnAtrasAAlmacenes;
	private JButton btnAtrasAStock; 
	private JButton btnAtrasALibros;
	private JComboBox<String> comboBoxCodAlmacen;
	private JPanel panelCentroCLibros;
	private JScrollPane scrollPaneTablaCLibros;
	private JPanel panelNorteCLibros;
	private JButton btnBuscarLibros;
	private JTextField textBuscarLibros;
	private JComboBox<String> comboBoxBuscarLibros;
	private JPanel panelCentroCStock;
	private JScrollPane scrollPaneBuscarStock;
	private JPanel panelNorteCStock;
	private JComboBox<String> comboBoxBuscarStock;
	private JTextField textBuscarStock;
	private JButton btnBuscarStock;
	private JPanel panelCentroCAlmacenes;
	private JScrollPane scrollPaneCAlmacenes;
	private JPanel panelNorteCAlmacenes;
	private JTable tablaPedidos;
	private JTextField textIdPedido;
	private JTextField textPrecioTotalPedidos;
	private JTextField textFechaPedido;
	private JTable tablaClientes;
	private JTextField textIdCliente;
	private JTextField textDNICliente;
	private JTextField textNombreCliente;
	private JTextField textApellidosCliente;
	private JTextField textDireccionCliente;
	private JTextField textPoblacionCliente;
	private JTextField textTelefonoCliente;
	private JTextField textEmailCliente;
	private JTable tablaFacturas;
	private JTextField textIdFactura;
	private JTextField textIdPedidoFactura;
	private JTextField textIdClienteFactura;
	private JTextField textTotalFactura;
	private JPanel panelVendedor;
	private JPanel panelNorteVendedor;
	private JLabel lblPedidos;
	private JPanel panelCentroVendedor;
	private JPanel panelTablaVendedor;
	private JScrollPane scrollPaneVendedor;
	private JButton btnClientes;
	private JButton btnAddPedido;
	private JButton btnFinalizarPedido;
	private JLabel lblIdPedido;
	private JLabel lblIsbnPedidos;
	private JComboBox<String> comboBoxISBNPedidos;
	private JLabel lblCantidadPedidos;
	private JSpinner spinnerCantidadPedidos;
	private JLabel lblPrecioTotal;
	private JLabel lblFechaPedido;
	private JPanel panelCliente;
	private JPanel panelNorteCliente;
	private JLabel lblClientes;
	private JPanel panelCentroCliente;
	private JPanel panelTablaClientes;
	private JScrollPane scrollPaneClientes;
	private JButton btnAtrasClientes;
	private JButton btnModificarClientes;
	private JButton btnBajaClientes;
	private JButton btnAltaClientes;
	private JLabel lblIdCliente;
	private JLabel lblDniCliente;
	private JLabel lblNombreCliente;
	private JLabel lblApellidosCliente;
	private JLabel lblDireccionCliente;
	private JLabel lblPoblacionCliente;
	private JLabel lblTelefonoCliente;
	private JLabel lblEmailCliente;
	private JPanel panelFactura;
	private JPanel panelNorteFactura;
	private JLabel lblFacturas;
	private JPanel panelCentroFactura;
	private JPanel panelTablaFacturas;
	private JScrollPane scrollPaneFacturas;
	private JButton btnAtrasFactura;
	private JButton btnGenerar;
	private JLabel lblIdFactura;
	private JLabel lblIdPedidoFactura;
	private JLabel lblIdClienteFactura;
	private JLabel lblDniClienteFacturas;
	private JComboBox<String> comboBoxDNIClienteFactura;
	private JLabel lblTotalFactura;	
	private JComboBox<String> comboBoxCodAlmacenVendedor;
	private JLabel lblAlmacenVendedor;
	private static Usuario logeado;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					VentanaLibreria window = new VentanaLibreria();
					window.Libreria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaLibreria() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Libreria = new JFrame();
		Libreria.setTitle("Libreria");
		Libreria.setResizable(false);
		Libreria.setBounds(100, 100, 450, 300);
		Libreria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Libreria.getContentPane().setLayout(null);

		panelRegistro = new JPanel();
		panelRegistro.setVisible(false);
		
		panelInicioSesion = new JPanel();
		panelInicioSesion.setBounds(0, 0, 442, 273);
		Libreria.getContentPane().add(panelInicioSesion);
		panelInicioSesion.setLayout(null);

		lblUser = new JLabel("User");
		lblUser.setBounds(93, 86, 64, 14);
		panelInicioSesion.add(lblUser);

		lblPass = new JLabel("Password");
		lblPass.setBounds(93, 128, 64, 14);
		panelInicioSesion.add(lblPass);

		textUser = new JTextField();
		textUser.setBounds(167, 83, 165, 20);
		panelInicioSesion.add(textUser);
		textUser.setColumns(10);

		passwordLogin = new JPasswordField();
		passwordLogin.setBounds(167, 125, 165, 20);
		panelInicioSesion.add(passwordLogin);

		btnRegistro = new JButton("Registrarse");
		btnRegistro.setBounds(93, 197, 105, 23);
		panelInicioSesion.add(btnRegistro);

		btnLogin = new JButton("Iniciar Sesion");
		btnLogin.setBounds(226, 197, 120, 23);
		panelInicioSesion.add(btnLogin);

		lblTituloLogin = new JLabel("Inicio de Sesion");
		lblTituloLogin.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTituloLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLogin.setBounds(91, 26, 279, 23);
		panelInicioSesion.add(lblTituloLogin);

		panelRegistro.setBounds(0, 0, 442, 273);
		Libreria.getContentPane().add(panelRegistro);
		panelRegistro.setLayout(null);

		lblUserAlta = new JLabel("User");
		lblUserAlta.setBounds(93, 86, 64, 14);
		panelRegistro.add(lblUserAlta);

		lblPassAlta = new JLabel("Password");
		lblPassAlta.setBounds(93, 128, 64, 14);
		panelRegistro.add(lblPassAlta);

		textUserAlta = new JTextField();
		textUserAlta.setBounds(167, 83, 165, 20);
		textUserAlta.setColumns(10);
		panelRegistro.add(textUserAlta);

		passwordAlta = new JPasswordField();
		passwordAlta.setBounds(167, 125, 165, 20);
		panelRegistro.add(passwordAlta);

		btnAlta = new JButton("Registrarse");
		btnAlta.setBounds(228, 197, 104, 23);
		panelRegistro.add(btnAlta);

		btnCancelarAlta = new JButton("Cancelar");
		btnCancelarAlta.setBounds(94, 197, 97, 23);
		panelRegistro.add(btnCancelarAlta);

		lblTituloAlta = new JLabel("Registro");
		lblTituloAlta.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloAlta.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTituloAlta.setBounds(91, 26, 279, 23);
		panelRegistro.add(lblTituloAlta);
		
		panelConsultor = new JPanel();
		panelConsultor.setVisible(false);
		panelConsultor.setBounds(0, 0, 442, 273);
		Libreria.getContentPane().add(panelConsultor);
		panelConsultor.setLayout(null);
				
		lblTituloConsultor = new JLabel("Consultar Libreria");
		lblTituloConsultor.setBounds(91, 26, 279, 23);
		panelConsultor.add(lblTituloConsultor);
		lblTituloConsultor.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloConsultor.setFont(new Font("Tahoma", Font.BOLD, 17));
						
		btnConsultarLibros = new JButton("Consultar Libros");
		btnConsultarLibros.setBounds(152, 78, 161, 23);
		panelConsultor.add(btnConsultarLibros);
								
		btnConsultarStock = new JButton("Consultar Stock");
		btnConsultarStock.setBounds(152, 112, 161, 23);
		panelConsultor.add(btnConsultarStock);
										
		btnConsultarAlmacenes = new JButton("Consultar Almacenes");
		btnConsultarAlmacenes.setBounds(152, 146, 161, 23);
		panelConsultor.add(btnConsultarAlmacenes);
												
		btnSalirConsultor = new JButton("Salir");
		btnSalirConsultor.setBounds(152, 180, 161, 23);
		panelConsultor.add(btnSalirConsultor);
		
		panelGestor = new JPanel();
		panelGestor.setVisible(false);
				
		panelGestor.setBounds(0, 0, 442, 273);
		Libreria.getContentPane().add(panelGestor);
		panelGestor.setLayout(null);
		
		lblTituloGestor = new JLabel("Gestionar Libreria");
		lblTituloGestor.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloGestor.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTituloGestor.setBounds(91, 26, 279, 23);
		panelGestor.add(lblTituloGestor);
				
		btnGestionarLibros = new JButton("Gestionar Libros");
		btnGestionarLibros.setBounds(152, 78, 161, 23);
		panelGestor.add(btnGestionarLibros);
						
		btnGestionarStock = new JButton("Gestionar Stock");
		btnGestionarStock.setBounds(152, 112, 161, 23);
		panelGestor.add(btnGestionarStock);
								
		btnGestionarAlmacenes = new JButton("Gestionar Almacenes");
		btnGestionarAlmacenes.setBounds(152, 146, 161, 23);
		panelGestor.add(btnGestionarAlmacenes);
										
		btnSalirGestor = new JButton("Salir");
		btnSalirGestor.setBounds(152, 180, 161, 23);
		panelGestor.add(btnSalirGestor);
												
		panelAdmin = new JPanel();
		panelAdmin.setVisible(false);
		panelAdmin.setBounds(0, 0, 442, 273);
		Libreria.getContentPane().add(panelAdmin);
		panelAdmin.setLayout(null);
		
		lblTituloAdmin = new JLabel("Administrar Libreria");
		lblTituloAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloAdmin.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTituloAdmin.setBounds(91, 26, 279, 23);
		panelAdmin.add(lblTituloAdmin);
		
		btnAdminLibros = new JButton("Gestionar Libros");
		btnAdminLibros.setBounds(152, 78, 161, 23);
		panelAdmin.add(btnAdminLibros);
		
		btnAdminStock = new JButton("Gestionar Stock");
		btnAdminStock.setBounds(152, 112, 161, 23);
		panelAdmin.add(btnAdminStock);
		
		btnAdminAlmacenes = new JButton("Gestionar Almacenes");
		btnAdminAlmacenes.setBounds(152, 146, 161, 23);
		panelAdmin.add(btnAdminAlmacenes);
		
		btnAdminUsuarios = new JButton("Administrar Usuarios");
		btnAdminUsuarios.setBounds(152, 180, 161, 23);
		panelAdmin.add(btnAdminUsuarios);
		
		btnSalirAdmin = new JButton("Salir");
		btnSalirAdmin.setBounds(152, 215, 161, 23);
		panelAdmin.add(btnSalirAdmin);
		
		panelConsultasStock = new JPanel();
		panelConsultasStock.setVisible(false);
		
		panelConsultasLibros = new JPanel();
		panelConsultasLibros.setVisible(false);
		
		panelConsultasLibros.setBounds(0, 0, 442, 273);
		Libreria.getContentPane().add(panelConsultasLibros);
		panelConsultasLibros.setLayout(new BorderLayout(0, 0));
		
		panelNorteCLibros = new JPanel();
		panelConsultasLibros.add(panelNorteCLibros, BorderLayout.NORTH);
		panelNorteCLibros.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		comboBoxBuscarLibros = new JComboBox<String>();
		comboBoxBuscarLibros.setModel(new DefaultComboBoxModel<String>(new String[] {"ISBN", "Titulo", "Autor", "Precio"}));
		panelNorteCLibros.add(comboBoxBuscarLibros);
		
		textBuscarLibros = new JTextField();
		panelNorteCLibros.add(textBuscarLibros);
		textBuscarLibros.setColumns(10);
		
		btnBuscarLibros = new JButton("Buscar");
		panelNorteCLibros.add(btnBuscarLibros);
		
		panelCentroCLibros = new JPanel();
		panelConsultasLibros.add(panelCentroCLibros, BorderLayout.CENTER);
		panelCentroCLibros.setLayout(new BorderLayout(0, 0));
		
		tablaLibros = new JTable();
		tablaLibros.setEnabled(false);
		panelCentroCLibros.add(tablaLibros.getTableHeader(), BorderLayout.NORTH);
		
		scrollPaneTablaCLibros = new JScrollPane(tablaLibros);
		panelCentroCLibros.add(scrollPaneTablaCLibros, BorderLayout.CENTER);
		
		panelSurCLibros = new JPanel();
		panelConsultasLibros.add(panelSurCLibros, BorderLayout.SOUTH);
		
		btnAtrasLibros = new JButton("Atras");
		panelSurCLibros.add(btnAtrasLibros);

		panelConsultasStock.setBounds(0, 0, 442, 273);
		Libreria.getContentPane().add(panelConsultasStock);
		panelConsultasStock.setLayout(new BorderLayout(0, 0));
		
		panelNorteCStock = new JPanel();
		panelConsultasStock.add(panelNorteCStock, BorderLayout.NORTH);
		panelNorteCStock.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		comboBoxBuscarStock = new JComboBox<String>();
		comboBoxBuscarStock.setModel(new DefaultComboBoxModel<String>(new String[] {"ISBN", "Cod. Almacen"}));
		panelNorteCStock.add(comboBoxBuscarStock);
		
		textBuscarStock = new JTextField();
		panelNorteCStock.add(textBuscarStock);
		textBuscarStock.setColumns(10);
		
		btnBuscarStock = new JButton("Buscar");
		panelNorteCStock.add(btnBuscarStock);
		
		panelCentroCStock = new JPanel();
		panelConsultasStock.add(panelCentroCStock, BorderLayout.CENTER);
		panelCentroCStock.setLayout(new BorderLayout(0, 0));
		
		tablaStock = new JTable();
		tablaStock.setEnabled(false);
		panelCentroCStock.add(tablaStock.getTableHeader(), BorderLayout.NORTH);
		
		scrollPaneBuscarStock = new JScrollPane(tablaStock);
		panelCentroCStock.add(scrollPaneBuscarStock, BorderLayout.CENTER);
		
		panelSurCStock = new JPanel();
		panelConsultasStock.add(panelSurCStock, BorderLayout.SOUTH);
		
		btnAtrasStock = new JButton("Atras");
		panelSurCStock.add(btnAtrasStock);
		
		panelConsultasAlmacenes = new JPanel();
		panelConsultasAlmacenes.setVisible(false);
		panelConsultasAlmacenes.setBounds(0, 0, 442, 273);
		Libreria.getContentPane().add(panelConsultasAlmacenes);
		panelConsultasAlmacenes.setLayout(new BorderLayout(0, 0));
		
		panelNorteCAlmacenes = new JPanel();
		panelConsultasAlmacenes.add(panelNorteCAlmacenes, BorderLayout.NORTH);
		
		panelCentroCAlmacenes = new JPanel();
		panelConsultasAlmacenes.add(panelCentroCAlmacenes, BorderLayout.CENTER);
		panelCentroCAlmacenes.setLayout(new BorderLayout(0, 0));
		
		tablaAlmacenes = new JTable();
		tablaAlmacenes.setEnabled(false);
		panelCentroCAlmacenes.add(tablaAlmacenes.getTableHeader(), BorderLayout.NORTH);
				
		scrollPaneCAlmacenes = new JScrollPane(tablaAlmacenes);
		panelCentroCAlmacenes.add(scrollPaneCAlmacenes, BorderLayout.CENTER);
		
		panelSurCAlmacenes = new JPanel();
		panelConsultasAlmacenes.add(panelSurCAlmacenes, BorderLayout.SOUTH);
		
		btnAtrasAlmacenes = new JButton("Atras");
		panelSurCAlmacenes.add(btnAtrasAlmacenes);
		
		panelGestorLibros = new JPanel();
		panelGestorLibros.setVisible(false);
		panelGestorLibros.setBounds(0, 0, 444, 273);
		Libreria.getContentPane().add(panelGestorLibros);
		panelGestorLibros.setLayout(new BorderLayout(0, 0));
		
		panelNorteGLibros = new JPanel();
		panelGestorLibros.add(panelNorteGLibros, BorderLayout.NORTH);
		
		lblGestionarLibros = new JLabel("Gestionar Libros");
		panelNorteGLibros.add(lblGestionarLibros);
		lblGestionarLibros.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarLibros.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		panelCentroGLibros = new JPanel();
		panelGestorLibros.add(panelCentroGLibros, BorderLayout.CENTER);
		panelCentroGLibros.setLayout(null);
		
		panelTablaGLibros = new JPanel();
		panelTablaGLibros.setBounds(0, 0, 444, 135);
		panelCentroGLibros.add(panelTablaGLibros);
		panelTablaGLibros.setLayout(new BorderLayout(0, 0));
		
		tablaGLibros = new JTable();
		panelTablaGLibros.add(tablaGLibros.getTableHeader(), BorderLayout.NORTH);
		
		scrollPaneGLibros = new JScrollPane(tablaGLibros);
		panelTablaGLibros.add(scrollPaneGLibros, BorderLayout.CENTER);
		
		textISBN = new JTextField();
		textISBN.setBounds(66, 146, 123, 20);
		panelCentroGLibros.add(textISBN);
		textISBN.setColumns(10);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(288, 146, 123, 20);
		panelCentroGLibros.add(textTitulo);
		textTitulo.setColumns(10);
		
		lblIsbn = new JLabel("ISBN");
		lblIsbn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIsbn.setBounds(10, 149, 46, 14);
		panelCentroGLibros.add(lblIsbn);
		
		lblTitulo = new JLabel("Titulo");
		lblTitulo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitulo.setBounds(199, 149, 79, 14);
		panelCentroGLibros.add(lblTitulo);
		
		textAutor = new JTextField();
		textAutor.setBounds(66, 177, 123, 20);
		panelCentroGLibros.add(textAutor);
		textAutor.setColumns(10);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAutor.setBounds(10, 180, 46, 14);
		panelCentroGLibros.add(lblAutor);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(288, 177, 123, 20);
		panelCentroGLibros.add(textPrecio);
		textPrecio.setColumns(10);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecio.setBounds(199, 180, 79, 14);
		panelCentroGLibros.add(lblPrecio);
		
		btnAltaGLibros = new JButton("Alta");
		btnAltaGLibros.setBounds(332, 208, 91, 23);
		panelCentroGLibros.add(btnAltaGLibros);
		
		btnBajaGLibros = new JButton("Baja");
		btnBajaGLibros.setEnabled(false);
		btnBajaGLibros.setBounds(231, 208, 91, 23);
		panelCentroGLibros.add(btnBajaGLibros);
		
		btnModificarGLibros = new JButton("Modificar");
		btnModificarGLibros.setEnabled(false);
		btnModificarGLibros.setBounds(121, 208, 91, 23);
		panelCentroGLibros.add(btnModificarGLibros);
		
		btnAtrasGLibros = new JButton("Atras");
		btnAtrasGLibros.setVisible(false);
		btnAtrasGLibros.setBounds(20, 208, 91, 23);
		panelCentroGLibros.add(btnAtrasGLibros);
		
		btnAtrasALibros = new JButton("Atras");
		btnAtrasALibros.setVisible(false);
		btnAtrasALibros.setBounds(20, 208, 91, 23);
		panelCentroGLibros.add(btnAtrasALibros);
		
		panelGestorAlmacenes = new JPanel();
		panelGestorAlmacenes.setVisible(false);
		
		panelGestorStock = new JPanel();
		panelGestorStock.setVisible(false);
		panelGestorStock.setBounds(0, 0, 444, 273);
		Libreria.getContentPane().add(panelGestorStock);
		panelGestorStock.setLayout(new BorderLayout(0, 0));
		
		panelNorteGStock = new JPanel();
		panelGestorStock.add(panelNorteGStock, BorderLayout.NORTH);
		
		lblGestionarStock = new JLabel("Gestionar Stock");
		lblGestionarStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarStock.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelNorteGStock.add(lblGestionarStock);
		
		panelCentroGStock = new JPanel();
		panelCentroGStock.setLayout(null);
		panelGestorStock.add(panelCentroGStock, BorderLayout.CENTER);
		
		panelTablaGStock = new JPanel();
		panelTablaGStock.setBounds(0, 0, 444, 135);
		panelCentroGStock.add(panelTablaGStock);
		panelTablaGStock.setLayout(new BorderLayout(0, 0));
		
		tablaGStock = new JTable();
		panelTablaGStock.add(tablaGStock.getTableHeader(), BorderLayout.NORTH);
		
		scrollPaneGStock = new JScrollPane(tablaGStock);
		panelTablaGStock.add(scrollPaneGStock, BorderLayout.CENTER);
		
		textISBNStock = new JTextField();
		textISBNStock.setEnabled(false);
		textISBNStock.setColumns(10);
		textISBNStock.setBounds(66, 146, 123, 20);
		panelCentroGStock.add(textISBNStock);
		
		lblISBNStock = new JLabel("ISBN");
		lblISBNStock.setHorizontalAlignment(SwingConstants.RIGHT);
		lblISBNStock.setBounds(10, 149, 46, 14);
		panelCentroGStock.add(lblISBNStock);
		
		lblCodAlmacenStock = new JLabel("Cod. Almacen");
		lblCodAlmacenStock.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodAlmacenStock.setBounds(199, 149, 79, 14);
		panelCentroGStock.add(lblCodAlmacenStock);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidad.setBounds(0, 180, 56, 14);
		panelCentroGStock.add(lblCantidad);
		
		spinnerCantidad = new JSpinner();
		spinnerCantidad.setEnabled(false);
		spinnerCantidad.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
		spinnerCantidad.setBounds(66, 177, 123, 20);
		panelCentroGStock.add(spinnerCantidad);
		
		btnBajaStock = new JButton("Baja");
		btnBajaStock.setEnabled(false);
		btnBajaStock.setBounds(320, 208, 91, 23);
		panelCentroGStock.add(btnBajaStock);
		
		btnModificarStock = new JButton("Modificar");
		btnModificarStock.setEnabled(false);
		btnModificarStock.setBounds(176, 208, 91, 23);
		panelCentroGStock.add(btnModificarStock);
		
		btnAtrasGStock = new JButton("Atras");
		btnAtrasGStock.setVisible(false);
		btnAtrasGStock.setBounds(31, 208, 91, 23);
		panelCentroGStock.add(btnAtrasGStock);
		
		btnAtrasAStock = new JButton("Atras");
		btnAtrasAStock.setVisible(false);
		btnAtrasAStock.setBounds(31, 208, 91, 23);
		panelCentroGStock.add(btnAtrasAStock);
		
		comboBoxCodAlmacen = new JComboBox<String>();
		comboBoxCodAlmacen.setEnabled(false);
		comboBoxCodAlmacen.setBounds(288, 146, 123, 20);
		panelCentroGStock.add(comboBoxCodAlmacen);
		
		panelGestorAlmacenes.setBounds(0, 0, 444, 275);
		Libreria.getContentPane().add(panelGestorAlmacenes);
		panelGestorAlmacenes.setLayout(new BorderLayout(0, 0));
		
		panelNorteGAlmacenes = new JPanel();
		panelGestorAlmacenes.add(panelNorteGAlmacenes, BorderLayout.NORTH);
		
		lblGestionarAlmacenes = new JLabel("Gestionar Almacenes");
		lblGestionarAlmacenes.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarAlmacenes.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelNorteGAlmacenes.add(lblGestionarAlmacenes);
		
		panelCentroAlmacenes = new JPanel();
		panelCentroAlmacenes.setLayout(null);
		panelGestorAlmacenes.add(panelCentroAlmacenes, BorderLayout.CENTER);
		
		panelTablaGAlmacenes = new JPanel();
		panelTablaGAlmacenes.setBounds(0, 0, 444, 135);
		panelCentroAlmacenes.add(panelTablaGAlmacenes);
		panelTablaGAlmacenes.setLayout(new BorderLayout(0, 0));
		
		tablaGAlmacenes = new JTable();
		panelTablaGAlmacenes.add(tablaGAlmacenes.getTableHeader(), BorderLayout.NORTH);
	
		scrollPaneGAlmacenes = new JScrollPane(tablaGAlmacenes);
		panelTablaGAlmacenes.add(scrollPaneGAlmacenes, BorderLayout.CENTER);
		
		textCodAlmacenGAlmacenes = new JTextField();
		textCodAlmacenGAlmacenes.setEnabled(false);
		textCodAlmacenGAlmacenes.setColumns(10);
		textCodAlmacenGAlmacenes.setBounds(92, 146, 31, 20);
		panelCentroAlmacenes.add(textCodAlmacenGAlmacenes);
		
		textNombreAlmacen = new JTextField();
		textNombreAlmacen.setColumns(10);
		textNombreAlmacen.setBounds(189, 146, 79, 20);
		panelCentroAlmacenes.add(textNombreAlmacen);
		
		lblCodAlmacen = new JLabel("Cod. Almacen");
		lblCodAlmacen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodAlmacen.setBounds(0, 149, 82, 14);
		panelCentroAlmacenes.add(lblCodAlmacen);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(133, 149, 46, 14);
		panelCentroAlmacenes.add(lblNombre);
		
		textPoblacion = new JTextField();
		textPoblacion.setColumns(10);
		textPoblacion.setBounds(346, 146, 88, 20);
		panelCentroAlmacenes.add(textPoblacion);
		
		lblPoblacion = new JLabel("Poblacion");
		lblPoblacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPoblacion.setBounds(278, 149, 58, 14);
		panelCentroAlmacenes.add(lblPoblacion);
		
		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(92, 177, 72, 20);
		panelCentroAlmacenes.add(textTelefono);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setBounds(24, 180, 58, 14);
		panelCentroAlmacenes.add(lblTelefono);
		
		btnAltaGAlmacenes = new JButton("Alta");
		btnAltaGAlmacenes.setBounds(332, 208, 91, 23);
		panelCentroAlmacenes.add(btnAltaGAlmacenes);
		
		btnBajaGAlmacenes = new JButton("Baja");
		btnBajaGAlmacenes.setEnabled(false);
		btnBajaGAlmacenes.setBounds(231, 208, 91, 23);
		panelCentroAlmacenes.add(btnBajaGAlmacenes);
		
		btnModificarGAlmacenes = new JButton("Modificar");
		btnModificarGAlmacenes.setEnabled(false);
		btnModificarGAlmacenes.setBounds(121, 208, 91, 23);
		panelCentroAlmacenes.add(btnModificarGAlmacenes);
		
		btnAtrasGAlmacenes = new JButton("Atras");
		btnAtrasGAlmacenes.setVisible(false);
		btnAtrasGAlmacenes.setBounds(20, 208, 91, 23);
		panelCentroAlmacenes.add(btnAtrasGAlmacenes);
		
		btnAtrasAAlmacenes = new JButton("Atras");
		btnAtrasAAlmacenes.setVisible(false);
		btnAtrasAAlmacenes.setBounds(20, 208, 91, 23);
		panelCentroAlmacenes.add(btnAtrasAAlmacenes);
		
		lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(174, 180, 46, 14);
		panelCentroAlmacenes.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(231, 177, 180, 20);
		panelCentroAlmacenes.add(textEmail);
		textEmail.setColumns(10);
		
		panelGestorUsuarios = new JPanel();
		panelGestorUsuarios.setVisible(false);
		panelGestorUsuarios.setBounds(0, 0, 444, 273);
		Libreria.getContentPane().add(panelGestorUsuarios);
		panelGestorUsuarios.setLayout(new BorderLayout(0, 0));
		
		panelNorteGUsuarios = new JPanel();
		panelGestorUsuarios.add(panelNorteGUsuarios, BorderLayout.NORTH);
		
		lblGestionarUsuarios = new JLabel("Gestionar Usuarios");
		lblGestionarUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionarUsuarios.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelNorteGUsuarios.add(lblGestionarUsuarios);
		
		panelCentroGUsuarios = new JPanel();
		panelCentroGUsuarios.setLayout(null);
		panelGestorUsuarios.add(panelCentroGUsuarios, BorderLayout.CENTER);
		
		panelTablaGUsuarios = new JPanel();
		panelTablaGUsuarios.setBounds(0, 0, 444, 135);
		panelCentroGUsuarios.add(panelTablaGUsuarios);
		panelTablaGUsuarios.setLayout(new BorderLayout(0, 0));
		
		tablaGUsuarios = new JTable();
		panelTablaGUsuarios.add(tablaGUsuarios.getTableHeader(), BorderLayout.NORTH);

		scrollPaneGUsuarios = new JScrollPane(tablaGUsuarios);
		panelTablaGUsuarios.add(scrollPaneGUsuarios, BorderLayout.CENTER);
		
		textUserGUsuarios = new JTextField();
		textUserGUsuarios.setColumns(10);
		textUserGUsuarios.setBounds(66, 146, 123, 20);
		panelCentroGUsuarios.add(textUserGUsuarios);
		
		textPassGUsuarios = new JTextField();
		textPassGUsuarios.setColumns(10);
		textPassGUsuarios.setBounds(288, 146, 123, 20);
		panelCentroGUsuarios.add(textPassGUsuarios);
		
		lblUserGUsuarios = new JLabel("User");
		lblUserGUsuarios.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserGUsuarios.setBounds(10, 149, 46, 14);
		panelCentroGUsuarios.add(lblUserGUsuarios);
		
		lblDescripcion = new JLabel("Password");
		lblDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescripcion.setBounds(199, 149, 79, 14);
		panelCentroGUsuarios.add(lblDescripcion);
		
		lblPermisos = new JLabel("Permisos");
		lblPermisos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPermisos.setBounds(10, 180, 55, 14);
		panelCentroGUsuarios.add(lblPermisos);
		
		lblAlmacenVendedor = new JLabel("Almacen");
		lblAlmacenVendedor.setVisible(false);
		lblAlmacenVendedor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlmacenVendedor.setBounds(199, 180, 79, 14);
		panelCentroGUsuarios.add(lblAlmacenVendedor);
		
		btnAltaGUsuarios = new JButton("Alta");
		btnAltaGUsuarios.setBounds(332, 208, 91, 23);
		panelCentroGUsuarios.add(btnAltaGUsuarios);
		
		btnBajaGUsuarios = new JButton("Baja");
		btnBajaGUsuarios.setEnabled(false);
		btnBajaGUsuarios.setBounds(231, 208, 91, 23);
		panelCentroGUsuarios.add(btnBajaGUsuarios);
		
		btnModificarGUsuarios = new JButton("Modificar");
		btnModificarGUsuarios.setEnabled(false);
		btnModificarGUsuarios.setBounds(121, 208, 91, 23);
		panelCentroGUsuarios.add(btnModificarGUsuarios);
		
		btnAtrasGUsuarios = new JButton("Atras");
		btnAtrasGUsuarios.setBounds(20, 208, 91, 23);
		panelCentroGUsuarios.add(btnAtrasGUsuarios);
		
		comboBoxPermisos = new JComboBox<String>();
		comboBoxPermisos.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Consultor", "Gestor", "Administrador", "Vendedor"}));
		comboBoxPermisos.setSelectedIndex(0);
		comboBoxPermisos.setMaximumRowCount(5);
		comboBoxPermisos.setBounds(66, 176, 123, 20);
		panelCentroGUsuarios.add(comboBoxPermisos);
		
		comboBoxCodAlmacenVendedor = new JComboBox<String>();
		comboBoxCodAlmacenVendedor.setVisible(false);
		comboBoxCodAlmacenVendedor.setBounds(288, 176, 123, 20);
		panelCentroGUsuarios.add(comboBoxCodAlmacenVendedor);
		
		panelVendedor = new JPanel();
		panelVendedor.setBounds(0, 0, 444, 273);
		Libreria.getContentPane().add(panelVendedor);
		panelVendedor.setVisible(false);
		panelVendedor.setLayout(new BorderLayout(0, 0));
		
		panelNorteVendedor = new JPanel();
		panelVendedor.add(panelNorteVendedor, BorderLayout.NORTH);
		
		lblPedidos = new JLabel("Pedidos");
		lblPedidos.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelNorteVendedor.add(lblPedidos);
		
		panelCentroVendedor = new JPanel();
		panelVendedor.add(panelCentroVendedor, BorderLayout.CENTER);
		panelCentroVendedor.setLayout(null);
		
		panelTablaVendedor = new JPanel();
		panelTablaVendedor.setBounds(0, 0, 444, 135);
		panelCentroVendedor.add(panelTablaVendedor);
		panelTablaVendedor.setLayout(new BorderLayout(0, 0));
		
		tablaPedidos = new JTable();
		tablaPedidos.setEnabled(false);
		panelTablaVendedor.add(tablaPedidos.getTableHeader(), BorderLayout.NORTH);
		
		scrollPaneVendedor = new JScrollPane(tablaPedidos);
		panelTablaVendedor.add(scrollPaneVendedor, BorderLayout.CENTER);
		
		btnClientes = new JButton("Clientes");
		btnClientes.setBounds(30, 208, 105, 23);
		panelCentroVendedor.add(btnClientes);
		
		btnAddPedido = new JButton("Añadir al pedido");
		btnAddPedido.setBounds(143, 208, 133, 23);
		panelCentroVendedor.add(btnAddPedido);
		
		btnFinalizarPedido = new JButton("Finalizar pedido");
		btnFinalizarPedido.setBounds(285, 208, 133, 23);
		panelCentroVendedor.add(btnFinalizarPedido);
		
		textIdPedido = new JTextField();
		textIdPedido.setEnabled(false);
		textIdPedido.setBounds(66, 146, 37, 20);
		panelCentroVendedor.add(textIdPedido);
		textIdPedido.setColumns(10);
		
		lblIdPedido = new JLabel("Id Pedido");
		lblIdPedido.setBounds(10, 149, 62, 14);
		panelCentroVendedor.add(lblIdPedido);
		
		lblIsbnPedidos = new JLabel("ISBN");
		lblIsbnPedidos.setBounds(126, 149, 46, 14);
		panelCentroVendedor.add(lblIsbnPedidos);
		
		comboBoxISBNPedidos = new JComboBox<String>();
		comboBoxISBNPedidos.setBounds(163, 145, 123, 20);
		panelCentroVendedor.add(comboBoxISBNPedidos);
		
		lblCantidadPedidos = new JLabel("Cantidad");
		lblCantidadPedidos.setBounds(305, 149, 56, 14);
		panelCentroVendedor.add(lblCantidadPedidos);
		
		spinnerCantidadPedidos = new JSpinner();
		spinnerCantidadPedidos.setBounds(361, 148, 62, 18);
		panelCentroVendedor.add(spinnerCantidadPedidos);
		
		lblPrecioTotal = new JLabel("Precio Total");
		lblPrecioTotal.setBounds(10, 177, 73, 14);
		panelCentroVendedor.add(lblPrecioTotal);
		
		textPrecioTotalPedidos = new JTextField();
		textPrecioTotalPedidos.setEnabled(false);
		textPrecioTotalPedidos.setBounds(86, 174, 86, 20);
		panelCentroVendedor.add(textPrecioTotalPedidos);
		textPrecioTotalPedidos.setColumns(10);
		
		lblFechaPedido = new JLabel("Fecha Pedido");
		lblFechaPedido.setBounds(197, 177, 79, 14);
		panelCentroVendedor.add(lblFechaPedido);
		
		textFechaPedido = new JTextField();
		textFechaPedido.setEnabled(false);
		textFechaPedido.setBounds(279, 174, 86, 20);
		panelCentroVendedor.add(textFechaPedido);
		textFechaPedido.setColumns(10);
		
		panelCliente = new JPanel();
		panelCliente.setVisible(false);
		panelCliente.setBounds(0, 0, 444, 273);
		Libreria.getContentPane().add(panelCliente);
		panelCliente.setLayout(new BorderLayout(0, 0));
		
		panelNorteCliente = new JPanel();
		panelCliente.add(panelNorteCliente, BorderLayout.NORTH);
		
		lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelNorteCliente.add(lblClientes);
		
		panelCentroCliente = new JPanel();
		panelCliente.add(panelCentroCliente, BorderLayout.CENTER);
		panelCentroCliente.setLayout(null);
		
		panelTablaClientes = new JPanel();
		panelTablaClientes.setBounds(0, 0, 444, 114);
		panelCentroCliente.add(panelTablaClientes);
		panelTablaClientes.setLayout(new BorderLayout(0, 0));
		
		tablaClientes = new JTable();
		panelTablaClientes.add(tablaClientes.getTableHeader(), BorderLayout.NORTH);
		
		scrollPaneClientes = new JScrollPane(tablaClientes);
		panelTablaClientes.add(scrollPaneClientes, BorderLayout.CENTER);
		
		btnAtrasClientes = new JButton("Atras");
		btnAtrasClientes.setBounds(27, 208, 91, 23);
		panelCentroCliente.add(btnAtrasClientes);
		
		btnModificarClientes = new JButton("Modificar");
		btnModificarClientes.setEnabled(false);
		btnModificarClientes.setBounds(132, 208, 91, 23);
		panelCentroCliente.add(btnModificarClientes);
		
		btnBajaClientes = new JButton("Baja");
		btnBajaClientes.setEnabled(false);
		btnBajaClientes.setBounds(233, 208, 91, 23);
		panelCentroCliente.add(btnBajaClientes);
		
		btnAltaClientes = new JButton("Alta");
		btnAltaClientes.setBounds(334, 208, 91, 23);
		panelCentroCliente.add(btnAltaClientes);
		
		lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setBounds(10, 125, 52, 14);
		panelCentroCliente.add(lblIdCliente);
		
		textIdCliente = new JTextField();
		textIdCliente.setEnabled(false);
		textIdCliente.setBounds(66, 122, 37, 20);
		panelCentroCliente.add(textIdCliente);
		textIdCliente.setColumns(10);
		
		lblDniCliente = new JLabel("DNI");
		lblDniCliente.setBounds(10, 153, 22, 14);
		panelCentroCliente.add(lblDniCliente);
		
		textDNICliente = new JTextField();
		textDNICliente.setBounds(35, 150, 68, 20);
		panelCentroCliente.add(textDNICliente);
		textDNICliente.setColumns(10);
		
		lblNombreCliente = new JLabel("Nombre");
		lblNombreCliente.setBounds(113, 125, 46, 14);
		panelCentroCliente.add(lblNombreCliente);
		
		textNombreCliente = new JTextField();
		textNombreCliente.setBounds(160, 122, 86, 20);
		panelCentroCliente.add(textNombreCliente);
		textNombreCliente.setColumns(10);
		
		lblApellidosCliente = new JLabel("Apellidos");
		lblApellidosCliente.setBounds(253, 125, 53, 14);
		panelCentroCliente.add(lblApellidosCliente);
		
		textApellidosCliente = new JTextField();
		textApellidosCliente.setBounds(309, 122, 116, 20);
		panelCentroCliente.add(textApellidosCliente);
		textApellidosCliente.setColumns(10);
		
		lblDireccionCliente = new JLabel("Direcci\u00F3n");
		lblDireccionCliente.setBounds(113, 153, 55, 14);
		panelCentroCliente.add(lblDireccionCliente);
		
		textDireccionCliente = new JTextField();
		textDireccionCliente.setBounds(169, 150, 103, 20);
		panelCentroCliente.add(textDireccionCliente);
		textDireccionCliente.setColumns(10);
		
		lblPoblacionCliente = new JLabel("Poblaci\u00F3n");
		lblPoblacionCliente.setBounds(280, 153, 58, 14);
		panelCentroCliente.add(lblPoblacionCliente);
		
		textPoblacionCliente = new JTextField();
		textPoblacionCliente.setBounds(339, 150, 86, 20);
		panelCentroCliente.add(textPoblacionCliente);
		textPoblacionCliente.setColumns(10);
		
		lblTelefonoCliente = new JLabel("Telefono");
		lblTelefonoCliente.setBounds(10, 180, 52, 14);
		panelCentroCliente.add(lblTelefonoCliente);
		
		textTelefonoCliente = new JTextField();
		textTelefonoCliente.setBounds(66, 177, 86, 20);
		panelCentroCliente.add(textTelefonoCliente);
		textTelefonoCliente.setColumns(10);
		
		lblEmailCliente = new JLabel("Email");
		lblEmailCliente.setBounds(163, 180, 46, 14);
		panelCentroCliente.add(lblEmailCliente);
		
		textEmailCliente = new JTextField();
		textEmailCliente.setBounds(197, 177, 180, 20);
		panelCentroCliente.add(textEmailCliente);
		textEmailCliente.setColumns(10);
		
		panelFactura = new JPanel();
		panelFactura.setVisible(false);
		panelFactura.setBounds(0, 0, 444, 273);
		Libreria.getContentPane().add(panelFactura);
		panelFactura.setLayout(new BorderLayout(0, 0));
		
		panelNorteFactura = new JPanel();
		panelFactura.add(panelNorteFactura, BorderLayout.NORTH);
		
		lblFacturas = new JLabel("Facturas");
		lblFacturas.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelNorteFactura.add(lblFacturas);
		
		panelCentroFactura = new JPanel();
		panelFactura.add(panelCentroFactura, BorderLayout.CENTER);
		panelCentroFactura.setLayout(null);
		
		panelTablaFacturas = new JPanel();
		panelTablaFacturas.setBounds(0, 0, 444, 135);
		panelCentroFactura.add(panelTablaFacturas);
		panelTablaFacturas.setLayout(new BorderLayout(0, 0));
		
		tablaFacturas = new JTable();
		panelTablaFacturas.add(tablaFacturas.getTableHeader(), BorderLayout.NORTH);
		
		scrollPaneFacturas = new JScrollPane(tablaFacturas);
		panelTablaFacturas.add(scrollPaneFacturas, BorderLayout.CENTER);
		
		btnAtrasFactura = new JButton("Atras");
		btnAtrasFactura.setBounds(103, 208, 91, 23);
		panelCentroFactura.add(btnAtrasFactura);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.setBounds(244, 208, 91, 23);
		panelCentroFactura.add(btnGenerar);
		
		lblIdFactura = new JLabel("Id Factura");
		lblIdFactura.setBounds(40, 146, 66, 14);
		panelCentroFactura.add(lblIdFactura);
		
		textIdFactura = new JTextField();
		textIdFactura.setEnabled(false);
		textIdFactura.setBounds(102, 143, 37, 20);
		panelCentroFactura.add(textIdFactura);
		textIdFactura.setColumns(10);
		
		lblIdPedidoFactura = new JLabel("Id Pedido");
		lblIdPedidoFactura.setBounds(169, 146, 66, 14);
		panelCentroFactura.add(lblIdPedidoFactura);
		
		textIdPedidoFactura = new JTextField();
		textIdPedidoFactura.setEnabled(false);
		textIdPedidoFactura.setBounds(231, 143, 37, 20);
		panelCentroFactura.add(textIdPedidoFactura);
		textIdPedidoFactura.setColumns(10);
		
		lblIdClienteFactura = new JLabel("Id Cliente");
		lblIdClienteFactura.setBounds(301, 146, 66, 14);
		panelCentroFactura.add(lblIdClienteFactura);
		
		textIdClienteFactura = new JTextField();
		textIdClienteFactura.setEnabled(false);
		textIdClienteFactura.setBounds(363, 143, 37, 20);
		panelCentroFactura.add(textIdClienteFactura);
		textIdClienteFactura.setColumns(10);
		
		lblDniClienteFacturas = new JLabel("DNI Cliente");
		lblDniClienteFacturas.setBounds(40, 174, 66, 14);
		panelCentroFactura.add(lblDniClienteFacturas);
		
		comboBoxDNIClienteFactura = new JComboBox<String>();
		comboBoxDNIClienteFactura.setBounds(106, 171, 86, 20);
		panelCentroFactura.add(comboBoxDNIClienteFactura);
		
		lblTotalFactura = new JLabel("Total Factura");
		lblTotalFactura.setBounds(214, 174, 74, 14);
		panelCentroFactura.add(lblTotalFactura);
		
		textTotalFactura = new JTextField();
		textTotalFactura.setEnabled(false);
		textTotalFactura.setBounds(292, 171, 86, 20);
		panelCentroFactura.add(textTotalFactura);
		textTotalFactura.setColumns(10);
	
		// funciones botones

		// login
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = textUser.getText();
				String pass = new String(passwordLogin.getPassword());
				logeado = new Usuario(user, pass, -1);
				int permisos = gUsuarios.login(logeado);
				if (permisos == 0) {
					panelInicioSesion.setVisible(false);
					panelConsultor.setVisible(true);
					logeado = new Usuario(user, pass, 0);
				}else if (permisos == 1) {
					panelInicioSesion.setVisible(false);
					panelGestor.setVisible(true);
					logeado = new Usuario(user, pass, 1);
				}else if (permisos == 2) {
					panelInicioSesion.setVisible(false);
					panelAdmin.setVisible(true);
					logeado = new Usuario(user, pass, 2);
				}else if (permisos == 3) {
					panelInicioSesion.setVisible(false);
					panelVendedor.setVisible(true);
					logeado = new Usuario(user, pass, 3);
					comboBoxISBNPedidos.setModel(gPedidos.isbnComboBox(logeado));
					cargarPanelPedidos();
					textIdPedido.setText(String.valueOf(gPedidos.idPedido()));
					int max = gPedidos.maxCantidadPedido((String)comboBoxISBNPedidos.getSelectedItem(), logeado);
					if (max!=0) {
						spinnerCantidadPedidos.setModel(new SpinnerNumberModel(1, 1, max, 1));
					}else {
						spinnerCantidadPedidos.setModel(new SpinnerNumberModel(0, 0, max, 1));
					}
				} else {
					JOptionPane.showMessageDialog(Libreria, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
				}
				limpiarLogin();
			}
		});
		
		// registrarse
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelInicioSesion.setVisible(false);
				panelRegistro.setVisible(true);
				limpiarLogin();
			}
		});

		// altaUsuario
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean dadoAlta = false;
				String passAlta = new String(passwordAlta.getPassword());
				Usuario usuario = new Usuario(textUserAlta.getText(), passAlta, 0);
				dadoAlta = gUsuarios.altaUsuario(usuario);
				if (dadoAlta==true) {
					panelRegistro.setVisible(false);
					panelConsultor.setVisible(true);
				}
				limpiarLogin();
			}	
		});

		// cancelar registro
		btnCancelarAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRegistro.setVisible(false);
				panelInicioSesion.setVisible(true);
				limpiarLogin();
			}
		});
		
		//consultas libros
		btnConsultarLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelConsultor.setVisible(false);
				panelConsultasLibros.setVisible(true);
				tablaLibros.setModel(gLibros.tablaLibros()); 
			}
		});
		
		//consultas stock
		btnConsultarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelConsultor.setVisible(false);
				panelConsultasStock.setVisible(true);	
				tablaStock.setModel(gStock.tablaStock()); 
			}
		});
		
		//consultas almacenes
		btnConsultarAlmacenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelConsultor.setVisible(false);
				panelConsultasAlmacenes.setVisible(true);	
				tablaAlmacenes.setModel(gAlmacen.tablaAlmacenes()); 
			}
		});
		
		//gestion libros
		btnGestionarLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGestor.setVisible(false);
				btnAtrasGLibros.setVisible(true);
				btnAtrasGLibros.setEnabled(true);
				panelGestorLibros.setVisible(true);	
				tablaGLibros.setModel(gLibros.tablaLibros()); 
			}
		});
		
		//gestion stock
		btnGestionarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGestor.setVisible(false);
				btnAtrasGStock.setVisible(true);
				btnAtrasGStock.setEnabled(true);
				panelGestorStock.setVisible(true);	
				tablaGStock.setModel(gStock.tablaStock()); 
			}
		});
		
		//gestion almacenes
		btnGestionarAlmacenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGestor.setVisible(false);
				btnAtrasGAlmacenes.setVisible(true);
				btnAtrasGAlmacenes.setEnabled(true);
				textCodAlmacenGAlmacenes.setText(gAlmacen.codAlmacen());
				panelGestorAlmacenes.setVisible(true);	
				tablaGAlmacenes.setModel(gAlmacen.tablaAlmacenes()); 
			}
		});
		
		//administrar libros
		btnAdminLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelAdmin.setVisible(false);
				btnAtrasALibros.setVisible(true);
				btnAtrasALibros.setEnabled(true);
				panelGestorLibros.setVisible(true);	
				tablaGLibros.setModel(gLibros.tablaLibros()); 
			}
		});

		//administrar stock
		btnAdminStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelAdmin.setVisible(false);
				btnAtrasAStock.setVisible(true);
				btnAtrasAStock.setEnabled(true);
				panelGestorStock.setVisible(true);	
				comboBoxCodAlmacen.setModel(gAlmacen.codAlmacenComboBox());
				tablaGStock.setModel(gStock.tablaStock()); 
			}
		});
		
		//administrar almacenes
		btnAdminAlmacenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelAdmin.setVisible(false);
				btnAtrasAAlmacenes.setVisible(true);
				btnAtrasAAlmacenes.setEnabled(true);
				textCodAlmacenGAlmacenes.setText(gAlmacen.codAlmacen());
				panelGestorAlmacenes.setVisible(true);	
				tablaGAlmacenes.setModel(gAlmacen.tablaAlmacenes()); 
			}
		});
		
		//administrar usuarios
		btnAdminUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelAdmin.setVisible(false);
				panelGestorUsuarios.setVisible(true);	
				tablaGUsuarios.setModel(gUsuarios.tablaUsuarios()); 
			}
		});
		
		//gestionar clientes
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelVendedor.setVisible(false);
				panelCliente.setVisible(true);
				cargarPanelClientes();
				tablaClientes.setModel(gClientes.tablaClientes());
			}
		});
		
		//atras consulta libros
		btnAtrasLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelConsultasLibros.setVisible(false);
				panelConsultor.setVisible(true);
			}
		});
		
		//atras consulta stock
		btnAtrasStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelConsultasStock.setVisible(false);
				panelConsultor.setVisible(true);
			}
		});
		
		//atras consulta almacenes
		btnAtrasAlmacenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelConsultasAlmacenes.setVisible(false);
				panelConsultor.setVisible(true);
			}
		});
		
		//atras gestion libros
		btnAtrasGLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGestorLibros.setVisible(false);
				botonesGestionAdminOff();
				panelGestor.setVisible(true);
				limpiarGestion();
			}
		});
		
		//atras gestion stock
		btnAtrasGStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGestorStock.setVisible(false);
				botonesGestionAdminOff();
				panelGestor.setVisible(true);
				limpiarGestion();
			}
		});				
		
		//atras gestion almacenes
		btnAtrasGAlmacenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGestorAlmacenes.setVisible(false);
				botonesGestionAdminOff();
				panelGestor.setVisible(true);
				limpiarGestion();
			}
		});
		
		//atras admin libros
		btnAtrasALibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGestorLibros.setVisible(false);
				botonesGestionAdminOff();
				panelAdmin.setVisible(true);
				limpiarGestion();
			}
		});
		
		//atras admin stock
		btnAtrasAStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGestorStock.setVisible(false);
				botonesGestionAdminOff();
				panelAdmin.setVisible(true);
				limpiarGestion();
			}
		});
		
		//atras admin almacenes
		btnAtrasAAlmacenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGestorAlmacenes.setVisible(false);
				botonesGestionAdminOff();
				panelAdmin.setVisible(true);
				limpiarGestion();
			}
		});
		
		//atras admin usuarios
		btnAtrasGUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGestorUsuarios.setVisible(false);
				botonesGestionAdminOff();
				panelAdmin.setVisible(true);
				limpiarGestion();
			}
		});		
		
		//atras clientes
		btnAtrasClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0 ) {
				panelCliente.setVisible(false);
				panelVendedor.setVisible(true);
				cargarPanelPedidos();
				textIdPedido.setText(String.valueOf(gPedidos.idPedido()));
			}
		});
		
		//atras factura
		btnAtrasFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0 ) {
				panelFactura.setVisible(false);
				panelVendedor.setVisible(true);
				cargarPanelPedidos();
				textIdPedido.setText(String.valueOf(gPedidos.idPedido()));
			}
		});
		
		// salir consultor
		btnSalirConsultor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelConsultor.setVisible(false);
				panelInicioSesion.setVisible(true);
			}
		});
		
		// salir gestor
		btnSalirGestor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGestor.setVisible(false);
				panelInicioSesion.setVisible(true);
			}
		});
		
		// salir admin
		btnSalirAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelAdmin.setVisible(false);
				panelInicioSesion.setVisible(true);
			}
		});
		
		// tabla gestion libros
		tablaGLibros.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int fila = tablaGLibros.getSelectedRow();
				textISBN.setText(tablaGLibros.getValueAt(fila, 0).toString());
				textTitulo.setText(tablaGLibros.getValueAt(fila, 1).toString());
				textAutor.setText(tablaGLibros.getValueAt(fila, 2).toString());
				textPrecio.setText(tablaGLibros.getValueAt(fila, 3).toString());
				textISBN.setEnabled(false);
				btnAltaGLibros.setText("Alta Stock");
				btnAltaGLibros.setBounds(332, 208, 98, 23);
				btnModificarGLibros.setEnabled(true);
				btnBajaGLibros.setEnabled(true);
			}
		});
		
		// tabla gestion stock
		tablaGStock.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int fila = tablaGStock.getSelectedRow();
				textISBNStock.setText(tablaGStock.getValueAt(fila, 0).toString());
				comboBoxCodAlmacen.setSelectedItem(tablaGStock.getValueAt(fila, 1).toString());
				spinnerCantidad.setValue(tablaGStock.getValueAt(fila, 2));
				textISBNStock.setEnabled(false);
				comboBoxCodAlmacen.setEnabled(true);
				spinnerCantidad.setEnabled(true);
				btnModificarStock.setEnabled(true);
				btnBajaStock.setEnabled(true);
			}
		});
					
		// tabla gestion almacenes
		tablaGAlmacenes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int fila = tablaGAlmacenes.getSelectedRow();
				textCodAlmacenGAlmacenes.setText(tablaGAlmacenes.getValueAt(fila, 0).toString());
				textNombreAlmacen.setText(tablaGAlmacenes.getValueAt(fila, 1).toString());
				textPoblacion.setText(tablaGAlmacenes.getValueAt(fila, 2).toString());
				textTelefono.setText(tablaGAlmacenes.getValueAt(fila, 3).toString());
				textEmail.setText(tablaGAlmacenes.getValueAt(fila, 4).toString());
				textCodAlmacenGAlmacenes.setEnabled(false);
				btnModificarGAlmacenes.setEnabled(true);
				btnBajaGAlmacenes.setEnabled(true);
			}
		});
				
		// tabla gestion usuarios
		tablaGUsuarios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int fila = tablaGUsuarios.getSelectedRow();
				textUserGUsuarios.setText(tablaGUsuarios.getValueAt(fila, 0).toString());
				comboBoxPermisos.setSelectedItem(tablaGUsuarios.getValueAt(fila, 1).toString());
				comboBoxCodAlmacenVendedor.setSelectedItem(gPedidos.codAlmacenVendedor((String) tablaGUsuarios.getValueAt(fila, 0)));
				textUserGUsuarios.setEnabled(false);
				btnModificarGUsuarios.setEnabled(true);
				btnBajaGUsuarios.setEnabled(true);
			}
		});
		
		// tabla clientes
		tablaClientes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int fila = tablaClientes.getSelectedRow();
				textIdCliente.setText(tablaClientes.getValueAt(fila, 0).toString());
				textDNICliente.setText(tablaClientes.getValueAt(fila, 1).toString());
				textNombreCliente.setText(tablaClientes.getValueAt(fila, 2).toString());
				textApellidosCliente.setText(tablaClientes.getValueAt(fila, 3).toString());
				textDireccionCliente.setText(tablaClientes.getValueAt(fila, 4).toString());
				textPoblacionCliente.setText(tablaClientes.getValueAt(fila, 5).toString());
				textTelefonoCliente.setText(tablaClientes.getValueAt(fila, 6).toString());
				textEmailCliente.setText(tablaClientes.getValueAt(fila, 7).toString());
				btnModificarClientes.setEnabled(true);
				btnBajaClientes.setEnabled(true);
				btnAltaClientes.setEnabled(false);
			}
		});
				
		// alta libros
		btnAltaGLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					boolean vacios = false;
					String isbn = textISBN.getText();
					String titulo = textTitulo.getText();
					String autor = textAutor.getText();
					Double precio = Double.parseDouble(textPrecio.getText());
					Libro libro = new Libro(isbn, titulo, autor, precio);
					if (isbn.isEmpty()==true || titulo.isEmpty()==true  || autor.isEmpty()==true ) {
						vacios = true;
						JOptionPane.showMessageDialog(Libreria, "Faltan datos o hay datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
					}
					if (isbn.toCharArray().length != 13) {
						vacios = true;
						JOptionPane.showMessageDialog(Libreria, "El ISBN require 13 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
					}
					if (vacios == false) {
						gLibros.altaLibro(libro);
						JComboBox<String> comboTemp = new JComboBox<String>(gAlmacen.codAlmacenComboBox());
						JOptionPane.showMessageDialog(Libreria, comboTemp, "Selecciona el almacen", JOptionPane.QUESTION_MESSAGE);
						isbn = libro.getISBN();
						String codAlmacen = (String) comboTemp.getSelectedItem();
						JSpinner spinnerTemp = new JSpinner();
						spinnerTemp.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
						JOptionPane.showMessageDialog(Libreria, spinnerTemp, "Selecciona la cantidad", JOptionPane.QUESTION_MESSAGE);
						int cantidad = (int) spinnerTemp.getValue();
						Stock stock = new Stock(isbn, codAlmacen, cantidad);
						gStock.altaStock(stock);
						limpiarGestion();
						tablaGLibros.setModel(gLibros.tablaLibros()); 
					}else {
						limpiarGestion();
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(Libreria, "Faltan datos o hay datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
					limpiarGestion();
				}
			}
		});
		
		// alta almacen
		btnAltaGAlmacenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) throws NumberFormatException{
				try {
					boolean vacios = false;
					String codAlmacen = textCodAlmacenGAlmacenes.getText();
					String nomAlmacen = textNombreAlmacen.getText();
					String poblacion = textPoblacion.getText();
					String telefono = textTelefono.getText();
					String email = textEmail.getText();
					Almacen almacen = new Almacen(codAlmacen, nomAlmacen, poblacion, telefono, email);
					if (nomAlmacen.isEmpty()==true || poblacion.isEmpty()==true  || telefono.isEmpty()==true || email.isEmpty()==true) {
						vacios = true;
						JOptionPane.showMessageDialog(Libreria, "Faltan datos o hay datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
					}
					if (vacios==false) {
						gAlmacen.altaAlmacen(almacen);
						limpiarGestion();
						tablaGAlmacenes.setModel(gAlmacen.tablaAlmacenes()); 
						textCodAlmacenGAlmacenes.setText(gAlmacen.codAlmacen());
					}else {
						limpiarGestion();
						textCodAlmacenGAlmacenes.setText(gAlmacen.codAlmacen());
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(Libreria, "Faltan datos o hay datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// alta usuario
		btnAltaGUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) throws NumberFormatException{
				try	{
					Boolean vacios = false;
					String user = textUserGUsuarios.getText();
					String pass = textPassGUsuarios.getText();
					int permisos = (comboBoxPermisos.getSelectedIndex()-1);
					Usuario usuario = new Usuario(user, pass, permisos);
					if (user.isEmpty()==true || pass.isEmpty()==true  || permisos == -1 ) {
						vacios = true;
						JOptionPane.showMessageDialog(Libreria, "Faltan datos o hay datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
					}
					if (vacios==false) {
						gUsuarios.altaUsuario(usuario);
						if ((String)comboBoxPermisos.getSelectedItem() == "Vendedor") {
							String codAlmacenVendedor = (String) comboBoxCodAlmacenVendedor.getSelectedItem();
							gUsuarios.altaVendedor(usuario, codAlmacenVendedor);
						}
						limpiarGestion();
						tablaGUsuarios.setModel(gUsuarios.tablaUsuarios()); 
					}else {
						limpiarGestion();
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(Libreria, "Faltan datos o hay datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// alta cliente
		btnAltaClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) throws NumberFormatException{
				try {
					boolean vacios = false;
					int idCliente = Integer.parseInt(textIdCliente.getText());
					String dniCliente = textDNICliente.getText();
					String nombreCliente = textNombreCliente.getText();
					String apellidosCliente = textApellidosCliente.getText();
					String direccionCliente = textDireccionCliente.getText();
					String poblacionCliente = textPoblacionCliente.getText();
					String telefonoCliente = textTelefonoCliente.getText();
					String emailCliente = textEmailCliente.getText();
					Cliente cliente = new Cliente(idCliente, dniCliente, nombreCliente, apellidosCliente, direccionCliente, poblacionCliente, telefonoCliente, emailCliente);
					if (dniCliente.isEmpty()==true || nombreCliente.isEmpty()==true  || apellidosCliente.isEmpty()==true || direccionCliente.isEmpty()==true || poblacionCliente.isEmpty()==true || telefonoCliente.isEmpty()==true || emailCliente.isEmpty()==true) {
						vacios = true;
						JOptionPane.showMessageDialog(Libreria, "Faltan datos o hay datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
					}
					if (vacios==false) {
						gClientes.altaCliente(cliente);
						cargarPanelClientes();
					}else {
						cargarPanelClientes();
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(Libreria, "Faltan datos o hay datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//alta factura
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) throws NumberFormatException{
				try {
					boolean vacios = false;
					int idFactura = Integer.parseInt(textIdFactura.getText());
					int idPedido = Integer.parseInt(textIdPedidoFactura.getText());
					int idCliente = Integer.parseInt(textIdClienteFactura.getText());
					Double totalFactura = Double.parseDouble(textTotalFactura.getText());
					Factura factura = new Factura(idFactura, idPedido, idCliente, totalFactura);
					if (idCliente == 0) {
 						vacios = true;
						JOptionPane.showMessageDialog(Libreria, "Debes indicar el DNI del cliente", "Error", JOptionPane.ERROR_MESSAGE);
					}
					if (vacios==false) {
						gFacturas.altaFactura(factura);
						panelFactura.setVisible(false);
						panelVendedor.setVisible(true);
						JOptionPane.showMessageDialog(Libreria, "Factura generada con exito", "Factura generada", JOptionPane.INFORMATION_MESSAGE);	
					}else {
						cargarPanelFactura();
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(Libreria, "Faltan datos o hay datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//add pedido
		btnAddPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) throws NumberFormatException{
				try {
					int idPedido = Integer.parseInt(textIdPedido.getText());
					String isbn = (String) comboBoxISBNPedidos.getSelectedItem();
					int cantidad = (int) spinnerCantidadPedidos.getValue();
					double precioTotal = Double.parseDouble(textPrecioTotalPedidos.getText());
					String fechaActual = textFechaPedido.getText();
					Pedido pedido = new Pedido(idPedido, isbn, cantidad, precioTotal, fechaActual);
					String codAlmacenVendedor = gPedidos.codAlmacenVendedor(logeado.getUser());
					gPedidos.altaPedido(pedido, codAlmacenVendedor);
					textIdPedido.setText(String.valueOf(idPedido));
					cargarPanelPedidos();					
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(Libreria, "Faltan datos o hay datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		//finalizar pedido
		btnFinalizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) throws NumberFormatException{
				cargarPanelPedidos();
				textIdPedido.setText(String.valueOf(gPedidos.idPedido()));
				int respuesta = JOptionPane.showConfirmDialog(Libreria, "¿Desea generar una factura?", "Generar factura", JOptionPane.YES_NO_OPTION);
				if (respuesta == 0) {
					panelVendedor.setVisible(false);
					panelFactura.setVisible(true);
					tablaFacturas.setModel(gFacturas.tablaFacturas());
					cargarPanelFactura();
				}
			}
		});
				
		// baja libros
		btnBajaGLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String isbn = textISBN.getText();
				String titulo = textTitulo.getText();
				String autor = textAutor.getText();
				Double precio = Double.parseDouble(textPrecio.getText());
				Libro libro = new Libro(isbn, titulo, autor, precio);
				if (gLibros.bajaLibro(libro)==true) {
					limpiarGestion();
					tablaGLibros.setModel(gLibros.tablaLibros());
				}else {
					limpiarGestion();
				}
			}
		});
		
		// baja stock
		btnBajaStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String isbn = textISBNStock.getText();
				String codAlmacen = (String) comboBoxCodAlmacen.getSelectedItem();
				int cantidad = (int) spinnerCantidad.getValue();
				Stock stock = new Stock(isbn, codAlmacen, cantidad);
				if (gStock.bajaStock(stock)==true) {
					limpiarGestion();
					tablaGStock.setModel(gStock.tablaStock()); 
				}else {
					limpiarGestion();
				}
			}
		});
		
		// baja almacen
		btnBajaGAlmacenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codAlmacen = textCodAlmacenGAlmacenes.getText();
				String nomAlmacen = textNombreAlmacen.getText();
				String poblacion = textPoblacion.getText();
				String telefono = textTelefono.getText();
				String email = textEmail.getText();
				Almacen almacen = new Almacen(codAlmacen, nomAlmacen, poblacion, telefono, email);
				if (gAlmacen.bajaAlmacen(almacen)==true) {
					limpiarGestion();
					tablaGAlmacenes.setModel(gAlmacen.tablaAlmacenes()); 
					textCodAlmacenGAlmacenes.setText(gAlmacen.codAlmacen());
				}else {
					limpiarGestion();
					textCodAlmacenGAlmacenes.setText(gAlmacen.codAlmacen());
				}
			}
		});
		
		// baja usuario
		btnBajaGUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = textUserGUsuarios.getText();
				String pass = textPassGUsuarios.getText();
				int permisos = (comboBoxPermisos.getSelectedIndex()-1);
				Usuario usuario = new Usuario(user, pass, permisos);
				if (gUsuarios.bajaUsuario(usuario)==true) {
					limpiarGestion();
					botonesGestionAdminOff();
					tablaGUsuarios.setModel(gUsuarios.tablaUsuarios()); 
				}else {
					limpiarGestion();
					botonesGestionAdminOff();
				}
			}
		});
		
		// baja cliente
		btnBajaClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idCliente = Integer.parseInt(textIdCliente.getText());
				String dniCliente = textDNICliente.getText();
				String nombreCliente = textNombreCliente.getText();
				String apellidosCliente = textApellidosCliente.getText();
				String direccionCliente = textDireccionCliente.getText();
				String poblacionCliente = textPoblacionCliente.getText();
				String telefonoCliente = textTelefonoCliente.getText();
				String emailCliente = textEmailCliente.getText();
				Cliente cliente = new Cliente(idCliente, dniCliente, nombreCliente, apellidosCliente, direccionCliente, poblacionCliente, telefonoCliente, emailCliente);
				if (gClientes.bajaCliente(cliente)==true) {
					cargarPanelClientes();
				}else {
					cargarPanelClientes();
				}
			}
		});
		
		// modificar libros
		btnModificarGLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String isbn = textISBN.getText();
				String titulo = textTitulo.getText();
				String autor = textAutor.getText();
				Double precio = Double.parseDouble(textPrecio.getText());
				Libro libro = new Libro(isbn, titulo, autor, precio);
				if (gLibros.modificacionLibro(libro)==true) {
					limpiarGestion();
					tablaGLibros.setModel(gLibros.tablaLibros()); 
				}else {
					limpiarGestion();
				}
			}
		});
		
		// modificar stock
		btnModificarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String isbn = textISBNStock.getText();
				String codAlmacen = (String) comboBoxCodAlmacen.getSelectedItem();
				int cantidad = (int) spinnerCantidad.getValue();
				Stock stock = new Stock(isbn, codAlmacen, cantidad);
				int fila = tablaGStock.getSelectedRow();
				String oldCodAlmacen = (String) tablaGStock.getValueAt(fila, 1);
				if (gStock.modificacionStock(stock, oldCodAlmacen)==true) {
					limpiarGestion();
					tablaGStock.setModel(gStock.tablaStock()); 
				}else {
					limpiarGestion();
				}
			}
		});
		
		// modificar almacen
		btnModificarGAlmacenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codAlmacen = textCodAlmacenGAlmacenes.getText();
				String nomAlmacen = textNombreAlmacen.getText();
				String poblacion = textPoblacion.getText();
				String telefono = textTelefono.getText();
				String email = textEmail.getText();
				Almacen almacen = new Almacen(codAlmacen, nomAlmacen, poblacion, telefono, email);
				if (gAlmacen.modificacionAlmacen(almacen)==true) {
					limpiarGestion();
					tablaGAlmacenes.setModel(gAlmacen.tablaAlmacenes()); 
					textCodAlmacenGAlmacenes.setText(gAlmacen.codAlmacen());
				}else {
					limpiarGestion();
					textCodAlmacenGAlmacenes.setText(gAlmacen.codAlmacen());
				}
			}
		});
		
		// modificar usuario
		btnModificarGUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = textUserGUsuarios.getText();
				String pass = textPassGUsuarios.getText();
				int permisos = (comboBoxPermisos.getSelectedIndex()-1);
				Usuario usuario = new Usuario(user, pass, permisos);
				if (gUsuarios.modificacionUsuario(usuario, permisos)==true) {
					if ((String)comboBoxPermisos.getSelectedItem() == "Vendedor") {
						String codAlmacenVendedor = (String) comboBoxCodAlmacenVendedor.getSelectedItem();
						gUsuarios.modificacionAlmacenVendedor(usuario, codAlmacenVendedor);
					}
					limpiarGestion();
					botonesGestionAdminOff();
					tablaGUsuarios.setModel(gUsuarios.tablaUsuarios()); 
				}else {
					limpiarGestion();
					botonesGestionAdminOff();
				}
			}
		});
		
		// modificar cliente
		btnModificarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idCliente = Integer.parseInt(textIdCliente.getText());
				String dniCliente = textDNICliente.getText();
				String nombreCliente = textNombreCliente.getText();
				String apellidosCliente = textApellidosCliente.getText();
				String direccionCliente = textDireccionCliente.getText();
				String poblacionCliente = textPoblacionCliente.getText();
				String telefonoCliente = textTelefonoCliente.getText();
				String emailCliente = textEmailCliente.getText();
				Cliente cliente = new Cliente(idCliente, dniCliente, nombreCliente, apellidosCliente, direccionCliente, poblacionCliente, telefonoCliente, emailCliente);
				if (gClientes.modificacionCliente(cliente)==true) {
					cargarPanelClientes();
				}else {
					cargarPanelClientes();
				}
			}
		});
		
		//buscar libros
		btnBuscarLibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String filtro = (String) comboBoxBuscarLibros.getSelectedItem();
				String busqueda = textBuscarLibros.getText();
				if (busqueda.isEmpty()==true) {
					tablaLibros.setModel(gLibros.tablaLibros());
				} else {
					tablaLibros.setModel(gLibros.buscarLibro(filtro, busqueda));
				}	
			}
		});
		
		//buscar stock
		btnBuscarStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String filtro = (String) comboBoxBuscarStock.getSelectedItem();
				String busqueda = textBuscarStock.getText();
				if (busqueda.isEmpty()==true) {
					tablaStock.setModel(gStock.tablaStock());
				} else {
					tablaStock.setModel(gStock.buscarStock(filtro, busqueda));
				}	
			}
		});
		
		//calcular precio total pedido 1
		comboBoxISBNPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPrecioTotalPedidos.setText(String.valueOf(gPedidos.precioTotalPedido((String)comboBoxISBNPedidos.getSelectedItem(), (int)spinnerCantidadPedidos.getValue())));
				int max = gPedidos.maxCantidadPedido((String)comboBoxISBNPedidos.getSelectedItem(), logeado);
				if (max!=0) {
					spinnerCantidadPedidos.setModel(new SpinnerNumberModel(1, 1, max, 1));
				}else {
					spinnerCantidadPedidos.setModel(new SpinnerNumberModel(0, 0, max, 1));
				}
			}
		});
		
		//calcular precio total pedido 2
		spinnerCantidadPedidos.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				textPrecioTotalPedidos.setText(String.valueOf(gPedidos.precioTotalPedido((String)comboBoxISBNPedidos.getSelectedItem(), (int)spinnerCantidadPedidos.getValue())));
			}
		});	
		
		//mostrar almacen vendedor
		comboBoxPermisos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ((String) comboBoxPermisos.getSelectedItem() == "Vendedor") {
					lblAlmacenVendedor.setVisible(true);
					comboBoxCodAlmacenVendedor.setVisible(true);
					comboBoxCodAlmacenVendedor.setModel(gAlmacen.codAlmacenComboBox());
				} else {
					lblAlmacenVendedor.setVisible(false);
					comboBoxCodAlmacenVendedor.setVisible(false);
				}
			}
		});
		
		//mostrar idCliente facturas
		comboBoxDNIClienteFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String idClienteF = String.valueOf(gClientes.obtenerIdCliente((String) comboBoxDNIClienteFactura.getSelectedItem()));
				textIdClienteFactura.setText(idClienteF);
			}
		});
	}	
	
	//metodos
	private void limpiarLogin() {
		textUser.setText("");
		textUserAlta.setText("");
		passwordLogin.setText("");
		passwordAlta.setText("");
	}
	
	private void limpiarGestion() {
		textISBN.setText("");
		textTitulo.setText("");
		textAutor.setText("");
		textPrecio.setText("");
		textISBNStock.setText("");
		comboBoxCodAlmacen.setSelectedItem("");
		spinnerCantidad.getModel().setValue(0);
		textCodAlmacenGAlmacenes.setText("");
		textNombreAlmacen.setText("");
		textPoblacion.setText("");
		textTelefono.setText("");
		textEmail.setText("");
		textUserGUsuarios.setText("");
		textPassGUsuarios.setText("");
		comboBoxPermisos.setSelectedItem("");
		btnAltaGLibros.setText("Alta");
		btnAltaGLibros.setBounds(332, 208, 91, 23);
		textISBN.setEnabled(true);
		comboBoxCodAlmacen.setEnabled(false);
		spinnerCantidad.setEnabled(false);
		btnBajaGLibros.setEnabled(false);
		btnModificarGLibros.setEnabled(false);
		btnBajaStock.setEnabled(false);
		btnModificarStock.setEnabled(false);
		btnBajaGAlmacenes.setEnabled(false);
		btnModificarGAlmacenes.setEnabled(false);
		btnBajaGUsuarios.setEnabled(false);
		btnModificarGUsuarios.setEnabled(false);
	}
	
	private void botonesGestionAdminOff() {
		btnAtrasGLibros.setVisible(false);
		btnAtrasGStock.setVisible(false);
		btnAtrasGAlmacenes.setVisible(false);
		btnAtrasALibros.setVisible(false);
		btnAtrasAStock.setVisible(false);
		btnAtrasAAlmacenes.setVisible(false);
		btnAtrasGLibros.setEnabled(false);
		btnAtrasGStock.setEnabled(false);
		btnAtrasGAlmacenes.setEnabled(false);
		btnAtrasALibros.setEnabled(false);
		btnAtrasAStock.setEnabled(false);
		btnAtrasAAlmacenes.setEnabled(false);
		textISBN.setEnabled(true);
		textUserGUsuarios.setEnabled(true);
	}
	
	private void cargarPanelPedidos() {
		try {
			comboBoxISBNPedidos.setSelectedIndex(0);
			int max = gPedidos.maxCantidadPedido((String)comboBoxISBNPedidos.getSelectedItem(), logeado);
			if (max!=0) {
				spinnerCantidadPedidos.setModel(new SpinnerNumberModel(1, 1, max, 1));
			}else {
				spinnerCantidadPedidos.setModel(new SpinnerNumberModel(0, 0, max, 1));
			}
			textFechaPedido.setText(gPedidos.fechaActualPedido());
			textPrecioTotalPedidos.setText(String.valueOf(gPedidos.precioTotalPedido((String)comboBoxISBNPedidos.getSelectedItem(), (int)spinnerCantidadPedidos.getValue())));
			tablaPedidos.setModel(gPedidos.tablaPedidos()); 
		}catch (IllegalArgumentException e){
			JOptionPane.showMessageDialog(Libreria, "No hay libros en el stock", "Error", JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	private void cargarPanelClientes() {
		tablaClientes.setModel(gClientes.tablaClientes());
		textIdCliente.setText(String.valueOf(gClientes.idCliente()));
		textDNICliente.setText("");
		textNombreCliente.setText("");
		textApellidosCliente.setText("");
		textDireccionCliente.setText("");
		textPoblacionCliente.setText("");
		textTelefonoCliente.setText("");
		textEmailCliente.setText("");
		btnModificarClientes.setEnabled(false);
		btnBajaClientes.setEnabled(false);
		btnAltaClientes.setEnabled(true);
	}
	
	private void cargarPanelFactura() {
		textIdFactura.setText(String.valueOf(gFacturas.idFactura()));
		int idUltimoPedido = (gPedidos.idPedido() - 1);
		textIdPedidoFactura.setText(String.valueOf(idUltimoPedido));
		textIdClienteFactura.setText("0");
		comboBoxDNIClienteFactura.setModel(gClientes.dniClienteComboBox());
		textTotalFactura.setText(String.valueOf(gFacturas.calcularTotal(idUltimoPedido)));
	}
}