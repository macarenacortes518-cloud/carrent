package carrent;

//import javax.swing.JOptionPane;

public class Vehiculo {
	private String patente;
	private char condicion;
	
	public Vehiculo (String patente, char condicion) {
		this.patente=patente;
		this.condicion=condicion;
	}
	
	public Vehiculo() {
		this.condicion = 'D';
	}
	
	public String getPatente() {
		return patente;
	}
	
	public char getCondicion() {
		return condicion;
	}
	
	public void setPatente(String pat) {
		this.patente=pat;
	}
	
	public void setCondicion(char cond) {
	    if (cond == 'D' || cond == 'A' || cond == 'M') {
	        this.condicion = cond;
	    } else {
	    	//mostrarMensaje("Condición inválida. Use D, A o M.", "Error");
	    }
	}
	
	@Override
	public String toString() {
		return "Patente: " + patente + " condición: " + condicion;
	}
}
