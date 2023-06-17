package estacionamiento;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.swing.JOptionPane;

public class Vehiculos {

		private String patente;
		private String tipo;
		private LocalDateTime horaEntrada;
		private LocalDateTime horaSalida;
		private Boolean estacionado;
		
		public Vehiculos(String patente, String tipo, LocalDateTime horaEntrada, LocalDateTime horaSalida, Boolean estacionado) {
			this.patente = patente;
			this.tipo = tipo;
			this.horaEntrada = horaEntrada;
			this.horaSalida = horaSalida;
			this.estacionado = estacionado;
		}
		
		
		//INICIO GETTERS Y SETTERS
		public String getPatente() {
			return patente;
		}

		public void setPatente(String patente) {
			this.patente = patente;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public LocalDateTime getHoraEntrada() {
			return horaEntrada;
		}

		public void setHoraEntrada(LocalDateTime horaEntrada) {
			this.horaEntrada = horaEntrada;
		}

		public LocalDateTime getHoraSalida() {
			return horaSalida;
		}

		public void setHoraSalida(LocalDateTime horaSalida) {
			this.horaSalida = horaSalida;
		}

		public Boolean getEstacionado() {
			return estacionado;
		}

		public void setEstacionado(Boolean estacionado) {
			this.estacionado = estacionado;
		}
		//FIN GETTERS Y SETTERS
		
		
		//CALCULA EL COBRO DE SALIDA
		 public double calcularCobro(LocalDateTime horaSalida) {
		        double cobroFraccion = 0.0;
		        double cobroEstadia = 0.0;
		        
		        long minutosEstacionados = ChronoUnit.MINUTES.between(horaEntrada, horaSalida);
		        
		        switch (tipo) {
		            case "Moto":
		                cobroFraccion = 30.0;
		                cobroEstadia = 1300.0;
		                break;
		            case "Auto":
		                cobroFraccion = 50.0;
		                cobroEstadia = 3000.0;
		                break;
		            case "Camioneta":
		                cobroFraccion = 80.0;
		                cobroEstadia = 4500.0;
		                break;
		        }
		        
		        double cobroTotal = cobroFraccion * Math.ceil(minutosEstacionados / 15.0);
		        
		        if (minutosEstacionados <= 15) {
		        	cobroTotal = cobroFraccion;
		        }else if (minutosEstacionados >= 1440) {
		        	cobroTotal = cobroEstadia;
		        }else if(cobroTotal > cobroEstadia){
		        	cobroTotal = cobroEstadia;
		        }
		        
		        return cobroTotal;
		    }
		
		 
		 //VALIDA SI LA PATENTE INGRESADA ES VALIDA
		 public static boolean validarPatenteArgentina(String patente) {
			    // Verificar que la patente tenga un formato válido para las patentes nuevas (2 letras seguidas de 3 números, seguidas de 2 letras).
			    if (patente.matches("[A-Z]{2}[0-9]{3}[A-Z]{2}")) {
			        // Verificar que las letras sean válidas
			        String letrasValidas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			        for (int i = 0; i < 2; i++) {
			            char letra = patente.charAt(i);
			            if (letrasValidas.indexOf(letra) == -1) {
			                return false;
			            }
			        }
			        for (int i = 5; i < 7; i++) {
			            char letra = patente.charAt(i);
			            if (letrasValidas.indexOf(letra) == -1) {
			                return false;
			            }
			        }

			        // Verificar que los números estén dentro del rango permitido (001-999)
			        int numeros = Integer.parseInt(patente.substring(2, 5));
			        if (numeros < 1 || numeros > 999) {
			            return false;
			        }
			    } else if (patente.matches("[A-Z]{3}[0-9]{3}")) { // Verificar el formato válido para las patentes viejas (3 letras seguidas de 3 números)
			        // Verificar que las letras sean válidas
			        String letrasValidas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			        for (int i = 0; i < 3; i++) {
			            char letra = patente.charAt(i);
			            if (letrasValidas.indexOf(letra) == -1) {
			                return false;
			            }
			        }

			        // Verificar que los números estén dentro del rango permitido (001-999)
			        int numeros = Integer.parseInt(patente.substring(3, 6));
			        if (numeros < 1 || numeros > 999) {
			            return false;
			        }
			    } else {
			        return false; // Si no cumple ninguno de los formatos válidos, la patente es inválida
			    }

			    // Si la patente pasa todas las validaciones anteriores, es válida.
			    return true;
			}


		 public boolean validaPatente(String patente) {
		        if (patente.equals("")) {
		            JOptionPane.showMessageDialog(null, "Ingrese la patente del vehículo.");
		            return false;
		        }else if(validarPatenteArgentina(patente)) {
		        	return true;
		        }else {
		        	JOptionPane.showMessageDialog(null,"La patente " + patente + " no es válida.");
		        	return false;
		        }
			}
			
}
