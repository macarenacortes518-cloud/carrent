package carrent;

import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class ControladorArriendoCuotas implements ActionListener {

    private VistaArriendoCuotas vista;
    private GestionCarRent sistema;

    public ControladorArriendoCuotas(VistaArriendoCuotas vista, GestionCarRent sistema) {
        this.vista = vista;
        this.sistema = sistema;

        this.vista.getBtnGuardarArriendo().addActionListener(this);
        this.vista.getBtnPagarPrimeraCuota().addActionListener(this);
        this.vista.getBtnAgregarCliente().addActionListener(this);
        cargarCombos();
    }

    private void cargarCombos() {
        vista.getComboClientes().removeAllItems();
        for (Cliente c : sistema.getClientes()) {
            vista.getComboClientes().addItem(c);
        }

        vista.getComboVehiculos().removeAllItems();
        for (Vehiculo v : sistema.getVehiculos()) {
            vista.getComboVehiculos().addItem(v);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vista.getBtnGuardarArriendo()) {
            guardarArriendo();
        } else if (source == vista.getBtnPagarPrimeraCuota()) {
            pagarPrimeraCuota();
        } else if (source == vista.getBtnAgregarCliente()) {
            JOptionPane.showMessageDialog(
                    vista,
                    "Ventana nuevo cliente.",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // ================== LÓGICA PRINCIPAL ==================

    private void guardarArriendo() {

        // 1. Validar que haya cliente y vehículo seleccionados
        Cliente cli = (Cliente) vista.getComboClientes().getSelectedItem();
        Vehiculo veh = (Vehiculo) vista.getComboVehiculos().getSelectedItem();

        if (cli == null || veh == null) {
            JOptionPane.showMessageDialog(
                    vista,
                    "Debe seleccionar un cliente y un vehículo.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // 2. Obtener y validar campos de texto
        String fecha = vista.getTxtFecha().getText().trim();
        String diasStr = vista.getTxtDias().getText().trim();
        String precioDiaStr = vista.getTxtPrecioDia().getText().trim();
        String cantCuotasStr = vista.getTxtCantCuotas().getText().trim();

        if (fecha.isEmpty() || diasStr.isEmpty() || precioDiaStr.isEmpty() || cantCuotasStr.isEmpty()) {
            JOptionPane.showMessageDialog(
                    vista,
                    "Debe completar todos los campos del arriendo.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        int dias;
        int precioDia;
        int cantCuotas;

        try {
            dias = Integer.parseInt(diasStr);
            precioDia = Integer.parseInt(precioDiaStr);
            cantCuotas = Integer.parseInt(cantCuotasStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    vista,
                    "Días, Precio por día y Cantidad de cuotas deben ser números enteros.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (dias <= 0 || precioDia <= 0 || cantCuotas <= 0) {
            JOptionPane.showMessageDialog(
                    vista,
                    "Días, Precio por día y Cantidad de cuotas deben ser mayores que cero.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // 3. Crear el arriendo con cuotas
        int numArriendo = sistema.getArriendos().size() + 1;

        ArriendoCuota arriendo = new ArriendoCuota(numArriendo, fecha, dias, cantCuotas);
        arriendo.setCliente(cli);
        arriendo.setVehiculo(veh);

        // 4. Intentar ingresar el arriendo usando la lógica de negocio
        boolean ok = arriendo.ingresarArriendoConCuota(precioDia);

        if (!ok) {
            JOptionPane.showMessageDialog(
                    vista,
                    "No se puede ingresar el arriendo.\n" +
                    "Verifique que el cliente esté vigente y que el vehículo esté disponible.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // 5. Calcular monto a pagar y mostrarlo en la vista
        int montoTotal = arriendo.obtenerMontoApagar(precioDia);
        vista.getTxtPrecioPagar().setText(String.valueOf(montoTotal));

        // 6. Guardar arriendo en el sistema (si tienes este método)
        sistema.agregarArriendo(arriendo);

        // 7. Mostrar las cuotas en la JList
        ArrayList<CuotaArriendo> cuotas = arriendo.getCuotas();
        vista.getListaCuotas().setListData(cuotas.toArray(new CuotaArriendo[0]));

        JOptionPane.showMessageDialog(
                vista,
                "Arriendo ingresado correctamente.",
                "Información",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void pagarPrimeraCuota() {

    	JList<CuotaArriendo> lista = vista.getListaCuotas();

    	if (lista.getModel().getSize() == 0) {
    	    JOptionPane.showMessageDialog(vista, 
    	        "No hay cuotas para pagar.",
    	        "Error", JOptionPane.ERROR_MESSAGE);
    	    return;
    	}

        // Según el enunciado, se paga la primera cuota
    	CuotaArriendo primera = lista.getModel().getElementAt(0);

        boolean ok = primera.pagarCuota();

        if (!ok) {
            JOptionPane.showMessageDialog(
                    vista,
                    "La primera cuota ya estaba pagada.",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            // El toString de CuotaArriendo debería mostrar si está pagada.
            // Con repaint basta para refrescar el texto.
            vista.getListaCuotas().repaint();

            JOptionPane.showMessageDialog(
                    vista,
                    "Primera cuota pagada correctamente.",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}
