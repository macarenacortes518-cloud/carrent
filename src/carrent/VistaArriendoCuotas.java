package carrent;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class VistaArriendoCuotas extends JFrame{
	private GestionCarRent sistema;
	private JComboBox<Cliente> comboClientes;
	private JButton btnAgregarCliente;

	private JComboBox<Vehiculo> comboVehiculos;

	private JLabel jlTitulo;
	private JLabel jlFechaArriendo;
	private JLabel jlDias;
	private JLabel jlPrecioDia;
	private JLabel jlPrecioPagar;
	private JLabel jlCantidadCuotas;
	private JLabel jlCuotasAPagar;
	
	private JTextField txtFecha;
	private JTextField txtDias;
	private JTextField txtPrecioDia;
	private JTextField txtCantCuotas;
	private JTextField txtPrecioPagar;

	private JButton btnGuardarArriendo;
	private JButton btnPagarPrimeraCuota;
	
	private JList<CuotaArriendo> listaCuotas;
	
	public VistaArriendoCuotas(GestionCarRent sistema) {
		super("Arriendo con cuotas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		JPanel panelSup = new JPanel();
		panelSup.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		jlTitulo = new JLabel("ARRIENDO CON CUOTAS");
		panelSup.add(jlTitulo);
		
		
		JPanel panelCentral = new JPanel(new GridLayout(1,3, 10, 10));
		panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
		btnAgregarCliente = new JButton("Ingresar nuevo Cliente");
		comboClientes = new JComboBox<>();
		comboVehiculos = new JComboBox<>();

		panelCentral.add(comboClientes);
		panelCentral.add(comboVehiculos);
		panelCentral.add(btnAgregarCliente);
		
		JPanel panelIzq = new JPanel(new GridLayout(4, 2, 5, 5));
		panelIzq.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
		jlFechaArriendo = new JLabel ("Fecha Arriendo: ");
		txtFecha = new JTextField(8);
		jlDias = new JLabel("Días");
		txtDias = new JTextField(12);
		jlPrecioDia = new JLabel("Precio por día:");
		txtPrecioDia = new JTextField(8);
		jlPrecioPagar= new JLabel("MONTO A PAGAR:");
		txtPrecioPagar = new JTextField (8);
		txtPrecioPagar.setEditable(false);
		txtPrecioPagar.setEnabled(false);
		jlCantidadCuotas=new JLabel("Cantidad de cuotas:");
		txtCantCuotas = new JTextField(8);
		btnGuardarArriendo = new JButton("Guardar arriendo y mostrar cuotas >>");
		jlCuotasAPagar = new JLabel("CUOTAS A PAGAR");
		listaCuotas = new JList<>();
		JScrollPane scrollCuotas = new JScrollPane(listaCuotas);
		btnPagarPrimeraCuota = new JButton("Pagar Primera Cuota");
		
		panelIzq.add(jlFechaArriendo);
		panelIzq.add(txtFecha);

		panelIzq.add(jlDias);
		panelIzq.add(txtDias);

		panelIzq.add(jlPrecioDia);
		panelIzq.add(txtPrecioDia);

		panelIzq.add(jlPrecioPagar);
		panelIzq.add(txtPrecioPagar);

		
		JPanel panelCentro = new JPanel(new GridLayout(3, 1, 5, 5));
		panelCentro.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
		panelCentro.add(jlCantidadCuotas);
		panelCentro.add(txtCantCuotas);
		panelCentro.add(btnGuardarArriendo);
		
		JPanel panelDer = new JPanel(new BorderLayout(5, 5));
		panelDer.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
		panelDer.add(jlCuotasAPagar, BorderLayout.NORTH);
		panelDer.add(scrollCuotas, BorderLayout.CENTER);   // ¡Ojo! scrollCuotas, no listaCuotas sola
		panelDer.add(btnPagarPrimeraCuota, BorderLayout.SOUTH);

		
		JPanel panelAbajo = new JPanel(new GridLayout(1, 3, 20, 10));
	    
		panelAbajo.add(panelIzq);
		panelAbajo.add(panelCentro);
		panelAbajo.add(panelDer);
		
		add(panelSup, BorderLayout.NORTH);
		add(panelCentral, BorderLayout.CENTER);
		add(panelAbajo, BorderLayout.SOUTH);

		pack();
	}
	
	// ===== GETTERS PARA COMBOS =====
	public JComboBox<Cliente> getComboClientes() {
	    return comboClientes;
	}

	public JComboBox<Vehiculo> getComboVehiculos() {
	    return comboVehiculos;
	}

	// ===== GETTERS PARA TEXTFIELDS =====
	public JTextField getTxtFecha() {
	    return txtFecha;
	}

	public JTextField getTxtDias() {
	    return txtDias;
	}

	public JTextField getTxtPrecioDia() {
	    return txtPrecioDia;
	}

	public JTextField getTxtCantCuotas() {
	    return txtCantCuotas;
	}

	public JTextField getTxtPrecioPagar() {
	    return txtPrecioPagar;
	}

	// ===== GETTERS PARA LA LISTA DE CUOTAS =====
	public JList<CuotaArriendo> getListaCuotas() {
	    return listaCuotas;
	}

	// ===== GETTERS PARA BOTONES =====
	public JButton getBtnAgregarCliente() {
	    return btnAgregarCliente;
	}

	public JButton getBtnGuardarArriendo() {
	    return btnGuardarArriendo;
	}

	public JButton getBtnPagarPrimeraCuota() {
	    return btnPagarPrimeraCuota;
	}

	// ===== GETTER DEL SISTEMA =====
	public GestionCarRent getSistema() {
	    return sistema;
	}

}
