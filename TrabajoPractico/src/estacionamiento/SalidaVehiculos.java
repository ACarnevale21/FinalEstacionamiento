package estacionamiento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalidaVehiculos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalidaVehiculos frame = new SalidaVehiculos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public SalidaVehiculos() {
		//CREA PANEL SALIDA VEHICULOS
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSalidaV = new JLabel("Salida Vehiculo");
		lblSalidaV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalidaV.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalidaV.setBounds(54, 22, 278, 24);
		contentPane.add(lblSalidaV);
		
		JLabel lblPatente = new JLabel("Patente:");
		lblPatente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPatente.setBounds(36, 69, 57, 45);
		contentPane.add(lblPatente);
		
		JTextField patenteTxt = new JTextField();
		patenteTxt.setBounds(103, 71, 201, 45);
		contentPane.add(patenteTxt);
		patenteTxt.setColumns(10);
		
		JButton btnCobro= new JButton("Cobro");
		btnCobro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patente = patenteTxt.getText();
				//VALIDA SI LA PATENTE ES VALIDA Y SI EL AUTO ESTA ESTACIONADO
				if (Vehiculos.validarPatenteArgentina(patente) && VehiculosLogic.buscar(patente) != -1) {
				    Vehiculos temporal = VehiculosLogic.obtener(patente);
				    //SI ENCUENTRA EL VEHICULO MUESTRA EL JPANEL CON EL COBRO Y MODIFICA EL ESTADO DEL VEHICULO
				    if (temporal != null) {
				        VehiculosLogic.mostrarCobro(temporal);
				        VehiculosLogic.modificarEstacionado(temporal);
				        
				    }
				} else {
			    	JOptionPane.showMessageDialog(contentPane, "No se encontró ningún vehículo con la patente especificada.");
			    }
			}
		}); 
		btnCobro.setBounds(36, 185, 129, 34);
		contentPane.add(btnCobro);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuOperador menuO = new MenuOperador();
				menuO.setVisible(true);
			}
		});
		btnSalir.setBounds(193, 185, 126, 34);
		contentPane.add(btnSalir);
	}
	
}
