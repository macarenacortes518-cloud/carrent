package carrent;

import java.awt.event.*;
import javax.swing.*;

public class ControladorPrincipal implements ActionListener {

    private VistaPrincipal vista;
    private GestionCarRent sistema;

    public ControladorPrincipal(VistaPrincipal vista, GestionCarRent sistema) {
        this.vista = vista;
        this.sistema = sistema;

        vista.getItemArriendoCuotas().addActionListener(this);
        vista.getItemPagarCuotas().addActionListener(this);
        vista.getItemAgregarCliente().addActionListener(this);
        vista.getItemSalir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vista.getItemArriendoCuotas()) {
            abrirArriendoCuota();
        } else if (source == vista.getItemPagarCuotas()) {
            JOptionPane.showMessageDialog(vista,
                    "Funcionalidad no implementada",
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE);

        } else if (source == vista.getItemAgregarCliente()) {
            abrirCliente();

        } else if (source == vista.getItemSalir()) {
            salir();
        }
    }

    private void abrirCliente() {
        VistaCliente vistaCliente = new VistaCliente(sistema);
        ControladorCliente controlador = new ControladorCliente(vistaCliente, sistema, vista);
        vistaCliente.setVisible(true);
    }

    private void abrirArriendoCuota() {
        VistaArriendoCuotas vistaArriendo = new VistaArriendoCuotas(sistema);
        ControladorArriendoCuotas controlador = new ControladorArriendoCuotas(vistaArriendo, sistema);
        vistaArriendo.setVisible(true);
    }

    private void salir() {
        int opcion = JOptionPane.showConfirmDialog(vista,
                "¿Está seguro que desea salir?",
                "Salir",
                JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}