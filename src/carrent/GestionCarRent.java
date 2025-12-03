package carrent;

import java.util.ArrayList;

public class GestionCarRent {
	
    private ArrayList<Cliente> clientes;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<ArriendoCuota> arriendos;

    public GestionCarRent() {
        clientes = new ArrayList<>();
        vehiculos = new ArrayList<>();
        arriendos = new ArrayList<>();
    }

    // -------------------------
    // Getters de las listas
    // -------------------------

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public ArrayList<ArriendoCuota> getArriendos() {
        return arriendos;
    }

    public void agregarCliente(Cliente c) {
        if (c != null) {
            clientes.add(c);
        }
    }

    public void agregarVehiculo(Vehiculo v) {
        if (v != null) {
            vehiculos.add(v);
        }
    }

    public void agregarArriendo(ArriendoCuota a) {
        if (a != null) {
            arriendos.add(a);
        }
    }

    public Cliente buscarClientePorCedula(String cedula) {
        if (cedula == null) {
            return null;
        }
        for (Cliente c : clientes) {
            if (cedula.equalsIgnoreCase(c.getCedula())) {
                return c;
            }
        }
        return null;
    }

    public Vehiculo buscarVehiculoPorPatente(String patente) {
        if (patente == null) {
            return null;
        }
        for (Vehiculo v : vehiculos) {
            if (patente.equalsIgnoreCase(v.getPatente())) {
                return v;
            }
        }
        return null;
    }

    public ArriendoCuota buscarArriendoPorNumero(int numArriendo) {
        for (ArriendoCuota a : arriendos) {
            if (a.getNumArriendo() == numArriendo) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<ArriendoCuota> buscarArriendosPorCliente(Cliente cli) {
        ArrayList<ArriendoCuota> resultado = new ArrayList<>();
        if (cli == null) {
            return resultado;
        }
        for (ArriendoCuota a : arriendos) {
            if (a.getCliente() != null && a.getCliente().equals(cli)) {
                resultado.add(a);
            }
        }
        return resultado;
    }
}

