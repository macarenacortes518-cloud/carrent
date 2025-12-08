package carrent;

import java.awt.*;
import javax.swing.*;

public class VistaCliente extends JFrame {

    private GestionCarRent sistema;

    // Componentes
    private JLabel lblTitulo;
    private JLabel lblCedula;
    private JLabel lblNombre;
    private JLabel lblVigente;

    private JTextField txtCedula;
    private JTextField txtNombre;
    private JCheckBox checkVigente;

    private JButton btnAgregar;

    public VistaCliente(GestionCarRent sistema) {
        super("Clientes");
        this.sistema = sistema;

        // Configuración básica
        setSize(350, 250);
        setLocationRelativeTo(null);
        setLayout(null); // Layout absoluto (simple)

        // Color de fondo
        getContentPane().setBackground(new Color(230, 230, 250));

        // Crear componentes
        lblTitulo = new JLabel("CLIENTES");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setBounds(20, 10, 300, 30);

        lblCedula = new JLabel("Cédula:");
        lblCedula.setBounds(50, 60, 80, 25);

        txtCedula = new JTextField();
        txtCedula.setBounds(130, 60, 150, 25);

        lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 100, 80, 25);

        txtNombre = new JTextField();
        txtNombre.setBounds(130, 100, 180, 25);

        lblVigente = new JLabel("¿ Vigente ?:");
        lblVigente.setBounds(130, 140, 80, 25);

        checkVigente = new JCheckBox("True");
        checkVigente.setBounds(210, 140, 100, 25);
        checkVigente.setSelected(true); // Por defecto marcado
        checkVigente.setBackground(new Color(230, 230, 250));

        btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(220, 180, 100, 30);

        // Agregar todo al JFrame
        add(lblTitulo);
        add(lblCedula);
        add(txtCedula);
        add(lblNombre);
        add(txtNombre);
        add(lblVigente);
        add(checkVigente);
        add(btnAgregar);
    }

    // ===== GETTERS =====

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JCheckBox getCheckVigente() {
        return checkVigente;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public GestionCarRent getSistema() {
        return sistema;
    }

    // Método para limpiar los campos después de agregar
    public void limpiarCampos() {
        txtCedula.setText("");
        txtNombre.setText("");
        checkVigente.setSelected(true);
    }
}