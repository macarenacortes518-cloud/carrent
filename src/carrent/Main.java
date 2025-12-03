package carrent;

import javax.swing.SwingUtilities;

public class Main {
	public static void main (String [] args) {
		GestionCarRent sistema = new GestionCarRent(); 
		VistaArriendoCuotas vistaArriendoCuotas = new VistaArriendoCuotas(sistema);
		vistaArriendoCuotas.setVisible(true);
	}
}


