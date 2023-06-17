package estacionamiento;

import javax.swing.JComboBox;

public class EmpleadoLogic {
	private static EmpleadoABM empleadoabm = new EmpleadoABM();
	
	
	public static boolean autentificar(String empleado, String contrasenia) {
		if (obtener(empleado)!= null) {
			Empleado empleadoConsulta = obtener(empleado);
			if (empleadoConsulta.getNombre().equals(empleado)&&
					empleadoConsulta.getContrasenia().equals(contrasenia)) {
				return true;
			}else 
				return false;
		}else {
			return false;
		}
	}
	
	public static boolean insertar(Empleado empleado) {
		return empleadoabm.insertar(empleado);
	}
	public static boolean modificar(Empleado empleado) {
		return empleadoabm.modificarHabilitado(empleado);
	}
	public static boolean eliminar(String empleado) {
		return empleadoabm.eliminar(empleado);
	}
	public static Empleado obtener(String empleado) {
		return empleadoabm.obtener(empleado);
	}
	
	public static JComboBox<String> muestreoEmpleados() {
		return empleadoabm.muestreoEmpleados();
	}
	public static String estadoEmpleado(String empleado) {
		return empleadoabm.estadoEmpleado(empleado);
	}


}
