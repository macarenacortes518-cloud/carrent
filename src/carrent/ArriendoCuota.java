package carrent;

import java.util.ArrayList;

public class ArriendoCuota extends Arriendo{
	private int cantCuotas;

	public ArriendoCuota(int numA, String fec, int dias, int cantCuotas) {
		super(numA, fec, dias);
		this.cantCuotas=cantCuotas;
	}
	
	public ArriendoCuota() {
		
	}
	
	public int getCantCuotas() {
		return cantCuotas;
	}
	
	public void setCantCuotas(int cantCuotas) {
		this.cantCuotas=cantCuotas;
	}
	
	public ArrayList<CuotaArriendo> generarCuotas(int precioDia) {
	    ArrayList<CuotaArriendo> lista = new ArrayList<>();

	    int montoTotal = obtenerMontoApagar(precioDia);
	    int valorCuota = montoTotal / cantCuotas;

	    for (int i = 1; i <= cantCuotas; i++) {
	        CuotaArriendo c = new CuotaArriendo(i, valorCuota);
	        lista.add(c);
	    }

	    return lista;
	}
	
	public boolean ingresarArriendoConCuota(int precioDia) {
	    // 1. Evaluar si el arriendo es válido
	    if (!evaluarArriendo()) {
	        return false;
	    }

	    // 2. Cambiar condición del vehículo a 'A' (arrendado)
	    Vehiculo v = getVehiculo();
	    if (v != null) {
	        v.setCondicion('A');
	    }

	    // 3. Generar las cuotas para este arriendo
	    ArrayList<CuotaArriendo> listaCuotas = generarCuotas(precioDia);

	    // 4. Asignar las cuotas al arriendo (atributo heredado de Arriendo)
	    setCuotas(listaCuotas);

	    return true;
	}

	@Override
	public String toString() {
		return "Cantidad de cuotas: " + cantCuotas;
	}
}
