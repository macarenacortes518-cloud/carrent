package carrent;

import java.util.ArrayList;

public class Arriendo {
	private int numArriendo;
	private String fecArr;
	private int diasArriendo;
	private Cliente cliente;
	private Vehiculo vehiculo;
	private ArrayList<CuotaArriendo> cuotas;
	

	public Arriendo() {
		cuotas = new ArrayList<>();
	}
	
	public Arriendo(int numArriendo, String fecArr, int diasArriendo) {
		this.numArriendo=numArriendo;
		this.fecArr=fecArr;
		this.diasArriendo=diasArriendo;
	}
	
	public int getNumArriendo() {
		return numArriendo;
	}
	
	public String getFecArr() {
		return fecArr;
	}
	
	public int getDiasArriendo() {
		return diasArriendo;
	}
	
	public void setNumArriendo(int numArriendo) {
		this.numArriendo=numArriendo;
	}
	
	public void setDiasArriendo(int diasArriendo) {
		this.diasArriendo=diasArriendo;
	}
	
	public void setFecArr(String fecha) {
		this.fecArr=fecha;
	}
	
	public Cliente getCliente() {
	    return cliente;
	}

	public void setCliente(Cliente cliente) {
	    this.cliente = cliente;
	}

	public Vehiculo getVehiculo() {
	    return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
	    this.vehiculo = vehiculo;
	}
	
	public ArrayList<CuotaArriendo> getCuotas() {
		return cuotas;
	}
	
	public void setCuotas(ArrayList<CuotaArriendo> cuotas) {
		this.cuotas=cuotas;
	}

	public int obtenerMontoApagar(int precioDia) {
		return this.getDiasArriendo()*precioDia;
	}
	
	public boolean evaluarArriendo() {
	    if (this.getCliente() == null || this.getVehiculo() == null) {
	        return false;
	    }

	    boolean clienteVigente = this.getCliente().isVigente();
	    boolean vehiculoDisponible = this.getVehiculo().getCondicion() == 'D';

	    return clienteVigente && vehiculoDisponible;
	}

	@Override
	public String toString() {
		return "Número de arriendo: " + numArriendo +
				" Fecha de arriendo: " + fecArr +
				" Días de arriendo: " + diasArriendo;
	}
}
