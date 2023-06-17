package estacionamiento;

public class VehiculosLogic {
	private static VehiculosABM vehiculosabm = new VehiculosABM();
	
	public static boolean insertar(Vehiculos vehiculo) {
		return vehiculosabm.insertar(vehiculo);
	}
	public static int buscar(String vehiculo) {
		return vehiculosabm.buscar(vehiculo);
	}
	
	public static boolean eliminar(String vehiculo) {
		return vehiculosabm.eliminar(vehiculo);
	}
	public static Vehiculos obtener(String vehiculo) {
		return vehiculosabm.obtener(vehiculo);
	}
	public static boolean verificaEstacionado(Vehiculos vehiculo) {
		return vehiculosabm.verificaEstacionado(vehiculo);
	}
	public static boolean modificarEstacionado(Vehiculos vehiculo) {
		return vehiculosabm.modificarEstacionado(vehiculo);
	}
	public static void listarEstacionados(int num){
		vehiculosabm.listarEstacionados(num);
	}
	public static void mostrarCobro(Vehiculos vehiculo) {
		vehiculosabm.mostrarCobro(vehiculo);
	}
	public static double getTotalCobrado() {
		return vehiculosabm.getTotalCobrado();
	}
}
