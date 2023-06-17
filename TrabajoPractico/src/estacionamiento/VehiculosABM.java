package estacionamiento;

import java.awt.Dimension;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.JOptionPane;

public class VehiculosABM {
	private List<Vehiculos>vehiculos;
	
	public VehiculosABM() {
		vehiculos = new ArrayList<>();
	}
	
	//BUSCA EL VEHICULO
	public int buscar(String vehiculo) {
		int n = -1;
		for (int i = 0 ; i < vehiculos.size(); i++) {
			if (vehiculos.get(i).getPatente().equals(vehiculo)) {
				n = i;
				break;
			}
		}
		return n;
	}
	
	//INSERTA EL VEHICULO EN LA LISTA
	public boolean insertar(Vehiculos vehiculo) {
		if(buscar(vehiculo.getPatente()) == -1) {
			vehiculos.add(vehiculo);
			return true;
		}else {
			return false;
		}
	}
	
	//ELIMINA EL VEHICULO DE LA LISTA
	public boolean eliminar(String vehiculo) {
		if(buscar(vehiculo)!= -1) {
			vehiculos.remove(buscar(vehiculo));
			return true;
		}else {
			return false;
		}
	}
	
	//VERIFICA SI EL VEHICULO ESTA ESTACIONADO
	public boolean verificaEstacionado(Vehiculos vehiculo) {
		if(vehiculo.getEstacionado()) {
			return true;
			}else {
				return false;
			}
	}
	
	//MODIFICA EL ESTADO DE LOS VEHICULOS ESTACIONADO/NO ESTACIONADO
	public boolean modificarEstacionado(Vehiculos vehiculo) {
		if(buscar(vehiculo.getPatente()) != -1) {
			Vehiculos vehiculoaux = obtener(vehiculo.getPatente());
			if (vehiculoaux.getEstacionado()) {
				vehiculoaux.setEstacionado(false);;
			}else {
			vehiculoaux.setEstacionado(true);
			}
			return true;
		}else {
			return false;
		}
	}
	
	
	//OBTIENE LOS VEHICULOS
	public Vehiculos obtener(String vehiculo) {
		if(buscar(vehiculo)!= -1) {
			return vehiculos.get(buscar(vehiculo));
		}else {
			return null;
		}
	}
	
	//LISTA LA ENTRADA/SALIDA DE VEHICULOS ESTACIONADOS Y 
	//CALCULA LA CANTIDAD DE AUTOS QUE ESTAN ESTACIONADOS
	public void listarEstacionados(int num) {
	    List<Vehiculos> estacionados = new ArrayList<>();
	    List<Vehiculos> tot_estacionados = new ArrayList<>();
	    for (Vehiculos v : vehiculos) {
	        if (!(v.getPatente() == null)&& v.getEstacionado()) {
	            estacionados.add(v);
	        }
	        tot_estacionados.add(v);
	    }
	    
	    //UTILICE STRING BUILDER PARA UNA MAYOR EFICIENCIA Y MENOR CONSUMO DE RECURSOS
	    StringBuilder sb = new StringBuilder();
	    
	    int i = 1;
	    if (num == 1) {
	        sb.append("Cantidad de vehículos estacionados: ");
	        sb.append(estacionados.size());
	    } else {
	        sb.append("Listado de entrada y salida de Vehiculos \n");
	        for (Vehiculos v : tot_estacionados) {
	            sb.append(i++).append(". ").append(v.getPatente()).append("     ").append(v.getTipo()).append("     ").append(v.getEstacionado()).append("\n");
	        }
	    }
	    //CREA EL TEXT AREA PARA LISTA Y CANTIDAD DE VEHICULOS
	    JTextArea textArea = new JTextArea(sb.toString());
	    JScrollPane scrollPane = new JScrollPane(textArea);
	    scrollPane.setPreferredSize(new Dimension(250, 150));
	    JOptionPane.showMessageDialog(null, scrollPane);
	}
	
	    private double totalCobrado; // VARIABLE PARA ALMACENAR EL TOTAL COBRADO
	    
	    public void mostrarCobro(Vehiculos vehiculo) {
	        // OBTENER LOS DETALLES DEL VEHICULO
	        String patente = vehiculo.getPatente();
	        LocalDateTime horaIngreso = vehiculo.getHoraEntrada();
	        LocalDateTime horaSalida = LocalDateTime.now();
	        
	        // CALCULA EL MONTO A COBRAR
	        double monto = vehiculo.calcularCobro(horaSalida);
	        
	        // ACTUALIZA EL TOTAL COBRADO
	        totalCobrado += monto;
	        
	        // CREA EL MENSAJE A MOSTRAR EN EL JOPTIONPANE
	        String mensaje = "Patente: " + patente + "\n"
	                + "Hora de ingreso: " + horaIngreso.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n"
	                + "Hora de salida: " + horaSalida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n"
	                + "Monto a cobrar: $" + monto;
	        
	        // MUESTRA EL MENSAJE EN EL JOPTIONPANE
	        JOptionPane.showMessageDialog(null, mensaje, "Cobro", JOptionPane.INFORMATION_MESSAGE);
	    }
	    
	    //METODO PARA PODER ACCEDER DESDE OTRA CLASE AL VALOR DE TOTAL COBRADO
	    public double getTotalCobrado() {
	        return totalCobrado;
	    }
	}


