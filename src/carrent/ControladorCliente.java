package carrent;

import java.awt.event.*;
import javax.swing.*;

public class ControladorCliente implements ActionListener {

    private VistaCliente vista;
    private GestionCarRent sistema;
    private VistaPrincipal vistaPrincipal;

    public ControladorCliente(VistaCliente vista, GestionCarRent sistema, VistaPrincipal vistaPrincipal) {
        this.vista = vista;
        this.sistema = sistema;
        this.vistaPrincipal = vistaPrincipal;

        this.vista.getBtnAgregar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnAgregar()) {
            agregarCliente();
        }
    }

    private void agregarCliente() {
        String cedula = vista.getTxtCedula().getText().trim();
        String nombre = vista.getTxtNombre().getText().trim();
        boolean vigente = vista.getCheckVigente().isSelected();

        if (cedula.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(
                    vista,
                    "Debe completar todos los campos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        Cliente clienteExistente = sistema.buscarClientePorCedula(cedula);
        if (clienteExistente != null) {
            JOptionPane.showMessageDialog(
                    vista,
                    "Ya existe un cliente con esa cédula.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        Cliente nuevoCliente = new Cliente(cedula, nombre, vigente);

        sistema.agregarCliente(nuevoCliente);

        if (vistaPrincipal != null) {
            vistaPrincipal.actualizarContadores();
        }

        JOptionPane.showMessageDialog(
                vista,
                "Cliente agregado correctamente.\n" +
                        "Cédula: " + cedula + "\n" +
                        "Nombre: " + nombre + "\n" +
                        "Vigente: " + (vigente ? "Sí" : "No"),
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE
        );

        vista.limpiarCampos();
    }
}