package carrent;

import java.awt.*;
import javax.swing.*;

public class VistaPrincipal extends JFrame {

    private GestionCarRent sistema;

    // Labels para actualizar
    private JLabel lblArriendos;
    private JLabel lblVehiculos;
    private JLabel lblClientes;

    // Menú
    private JMenuBar menuBar;
    private JMenu menuOperaciones;
    private JMenuItem itemArriendoCuotas;
    private JMenuItem itemPagarCuotas;
    private JMenuItem itemAgregarCliente;
    private JMenuItem itemSalir;

    public VistaPrincipal(GestionCarRent sistema) {
        super("Sistema Car-Rent");
        this.sistema = sistema;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        crearMenu();
        crearPanelCentral();
        setVisible(true);
    }

    private void crearMenu() {
        menuBar = new JMenuBar();
        menuOperaciones = new JMenu("Operaciones");

        itemArriendoCuotas = new JMenuItem("Arrendar con Cuotas");
        itemPagarCuotas = new JMenuItem("Pagar Cuotas");
        itemAgregarCliente = new JMenuItem("Agregar Cliente");
        itemSalir = new JMenuItem("Salir");

        menuOperaciones.add(itemArriendoCuotas);
        menuOperaciones.add(itemPagarCuotas);
        menuOperaciones.add(itemAgregarCliente);
        menuOperaciones.addSeparator();
        menuOperaciones.add(itemSalir);

        menuBar.add(menuOperaciones);
        setJMenuBar(menuBar);
    }

    private void crearPanelCentral() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.WHITE);

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(70, 130, 180));
        panelTitulo.setPreferredSize(new Dimension(600, 80));

        JLabel lblTitulo = new JLabel("SISTEMA CAR-RENT");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 32));
        lblTitulo.setForeground(Color.WHITE);
        panelTitulo.add(lblTitulo);

        JPanel panelEstadisticas = new JPanel();
        panelEstadisticas.setBackground(Color.WHITE);
        panelEstadisticas.setLayout(new GridLayout(4, 1, 10, 15));
        panelEstadisticas.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

        int arriendos = sistema.getArriendos().size();
        int vehiculos = sistema.getVehiculos().size();
        int clientes = sistema.getClientes().size();

        lblArriendos = new JLabel("Arriendos: " + arriendos);
        lblArriendos.setFont(new Font("Arial", Font.PLAIN, 20));

        lblVehiculos = new JLabel("Vehículos: " + vehiculos);
        lblVehiculos.setFont(new Font("Arial", Font.PLAIN, 20));

        lblClientes = new JLabel("Clientes: " + clientes);
        lblClientes.setFont(new Font("Arial", Font.PLAIN, 20));

        JLabel lblInstruccion = new JLabel("Seleccione opción del menú Operaciones");
        lblInstruccion.setFont(new Font("Arial", Font.ITALIC, 14));
        lblInstruccion.setForeground(Color.GRAY);

        panelEstadisticas.add(lblArriendos);
        panelEstadisticas.add(lblVehiculos);
        panelEstadisticas.add(lblClientes);
        panelEstadisticas.add(lblInstruccion);

        panel.add(panelTitulo, BorderLayout.NORTH);
        panel.add(panelEstadisticas, BorderLayout.CENTER);

        add(panel);
    }

    public void actualizarContadores() {
        lblArriendos.setText("Arriendos: " + sistema.getArriendos().size());
        lblVehiculos.setText("Vehículos: " + sistema.getVehiculos().size());
        lblClientes.setText("Clientes: " + sistema.getClientes().size());
    }

    // ===== GETTERS =====

    public JMenuItem getItemArriendoCuotas() {
        return itemArriendoCuotas;
    }

    public JMenuItem getItemPagarCuotas() {
        return itemPagarCuotas;
    }

    public JMenuItem getItemAgregarCliente() {
        return itemAgregarCliente;
    }

    public JMenuItem getItemSalir() {
        return itemSalir;
    }

    public GestionCarRent getSistema() {
        return sistema;
    }
}