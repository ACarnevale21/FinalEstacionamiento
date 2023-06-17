package estacionamiento;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

public class EmpleadoABM {
	private List <Empleado> empleados;
	
	public EmpleadoABM() {
		empleados = new ArrayList<>();
		
	}
	// BUSCA UN EMPLEADO EN LA LISTA Y DEVUELVE SU ÍNDICE
	public int buscar(String empleado) {
		int n = -1;
		for (int i = 0 ; i < empleados.size(); i++) {
			if (empleados.get(i).getNombre().equals(empleado)) {
				n = i;
				break;
			}
		}
		return n;
	}
	
	// INSERTA UN EMPLEADO EN LA LISTA SI NO EXISTE OTRO CON EL MISMO NOMBRE
	public boolean insertar(Empleado empleado) {
		if(buscar(empleado.getNombre()) == -1) {
			empleados.add(empleado);
			return true;
		}else {
			return false;
		}
	}
	
	// Modifica el estado de habilitación de un empleado (Habilitado/Deshabilitado)
	public boolean modificarHabilitado(Empleado empleado) {
		if(buscar(empleado.getNombre()) != -1) {
			Empleado empleadoaux = obtener(empleado.getNombre());
			if (empleadoaux.getHabilitado().equals("Habilitado")) {
				empleadoaux.setHabilitado("Deshabilitado");
			}else {
			empleadoaux.setHabilitado("Habilitado");
			}
			return true;
		}else {
			return false;
		}
	}
	
	// Elimina un empleado de la lista
	public boolean eliminar(String empleado) {
		if(buscar(empleado)!= -1) {
			empleados.remove(buscar(empleado));
			return true;
		}else {
			return false;
		}
	}
	
	// Obtiene un objeto Empleado de la lista por su nombre
	public Empleado obtener(String empleado) {
		if(buscar(empleado)!= -1) {
			return empleados.get(buscar(empleado));
		}else {
			return null;
		}
	}
	
	// Crea y devuelve un JComboBox con los nombres de los empleados con cargo "Operador"
	public JComboBox<String> muestreoEmpleados() {
		JComboBox<String> combo = new JComboBox<String>();
		combo.setBounds(162, 43, 193, 29);
		for (int i =0; i < empleados.size(); i++) {
			if (empleados.get(i).getCargo().equals("O")) {
			combo.addItem(empleados.get(i).getNombre());
			}
		}
		return combo;
	}
	
	// Devuelve el estado de habilitación de un empleado por su nombre
	public String estadoEmpleado(String empleado) {
	    Empleado emp = obtener(empleado);
	    if (emp != null) {
	        return emp.getHabilitado();
	    } else {
	        return "Empleado no encontrado";
	    }
	}

}
