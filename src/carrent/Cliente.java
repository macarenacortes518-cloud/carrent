package carrent;

public class Cliente {
	private String cedula;
	private String nombre;
	private boolean vigente;
	
	public Cliente (String cedula, String nombre, boolean vigente) {
		this.cedula=cedula;
		this.nombre=nombre;
		this.vigente=vigente;
	}
	
	public Cliente () {
		
	}
	
	public String getCedula() {
		return cedula;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean isVigente() {
		return vigente;
	}
	
	public void setCedula(String rut) {
		this.cedula=rut;
	}
	
	public void setNombre(String nom) {
		this.nombre=nom;
	}
	
	public void setVigente(boolean vig) {
		this.vigente=vig;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + " cedula: " + cedula + " vigencia: " + vigente;
	}
}
