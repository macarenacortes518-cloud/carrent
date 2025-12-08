package carrent;

public class Main {
	public static void main(String[] args) {
		GestionCarRent sistema = new GestionCarRent();
		agregarDatosPrueba(sistema);

		VistaPrincipal ventana = new VistaPrincipal(sistema);

		ControladorPrincipal controlador = new ControladorPrincipal(ventana, sistema);
	}

	private static void agregarDatosPrueba(GestionCarRent sistema) {
		sistema.agregarCliente(new Cliente("12345678-9", "Juan Pérez", true));
		sistema.agregarCliente(new Cliente("98765432-1", "María González", true));
		sistema.agregarCliente(new Cliente("11111111-1", "Pedro Ramírez", true));
		sistema.agregarCliente(new Cliente("22222222-2", "Ana Silva", false));

		sistema.agregarVehiculo(new Vehiculo("AB-1234", 'D'));
		sistema.agregarVehiculo(new Vehiculo("CD-5678", 'D'));
		sistema.agregarVehiculo(new Vehiculo("EF-9012", 'D'));
		sistema.agregarVehiculo(new Vehiculo("GH-3456", 'M'));
		sistema.agregarVehiculo(new Vehiculo("IJ-7890", 'D'));

	}
}