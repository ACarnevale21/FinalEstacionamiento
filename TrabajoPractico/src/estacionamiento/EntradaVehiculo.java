package estacionamiento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntradaVehiculo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPatente;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntradaVehiculo frame = new EntradaVehiculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public EntradaVehiculo() {
		//CREA EL PANEL DE ENTRADA VEHICULO
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 2, 10, 10));
		
		JLabel lblEntrada = new JLabel("Entrada");
		lblEntrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblEntrada);
		
		JLabel lblAutomovil = new JLabel("Automovil");
		lblAutomovil.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblAutomovil);
		
		JLabel lblPatente = new JLabel("Patente");
		lblPatente.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPatente);
		
		txtPatente = new JTextField();
		contentPane.add(txtPatente);
		txtPatente.setColumns(10);
		
		JLabel lblHoraIngreso = new JLabel("Horario Ingreso");
		lblHoraIngreso.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblHoraIngreso);
		
		JLabel lblTiempo = new JLabel(DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a")
                .format(LocalDateTime.now()));
		lblTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTiempo);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTipo);
		
		JComboBox<?> comboTipo = new JComboBox();
		comboTipo.setMaximumRowCount(3);
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"Auto", "Moto", "Camioneta"}));
		contentPane.add(comboTipo);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			    // VALIDA SI LA PATENTE ES CORRECTA
			    String patente = txtPatente.getText();

			    if (Vehiculos.validarPatenteArgentina(patente)) {
			        if (VehiculosLogic.buscar(patente) == -1) {
			            // OBTIENE EL TIPO DE VEHICULO SELECCIONADO EN EL COMBO BOX
			            String tipo = (String) comboTipo.getSelectedItem();

			            // OBTIENE LA HORA DE ENTRADA DEL SISTEMA
			            LocalDateTime horaDeEntrada = LocalDateTime.now();

			            // CREAR UN OBJETO VEHICULO Y AGREGARLO A LA ESTRUCTURA DE DATOS
			            Vehiculos vehiculo = new Vehiculos(patente, tipo, horaDeEntrada, null, true);
			            VehiculosLogic.insertar(vehiculo);

			            // MOSTRAR UN MENSAJE INDICANDO QUE SE AGREGÓ EL VEHÍCULO
			            JOptionPane.showMessageDialog(contentPane, "Se agregó el vehículo con patente " + patente);

			            // LIMPIA LOS CAMPOS DE ENTRADA
			            txtPatente.setText("");
			            comboTipo.setSelectedIndex(0);
			        } else {
			        	//VERIFICA SI EL VEHICULO YA SE ENCUENTRA ESTACIONADO
			        	if(VehiculosLogic.verificaEstacionado(VehiculosLogic.obtener(patente))) {
			        		JOptionPane.showMessageDialog(contentPane, "El vehículo con patente " + patente + " ya se encuentra estacionado.");
			        	}else {
			        		//SI EL VEHICULO YA FUE AGREGADO ANTERIORMENTE MODIFICA SU ESTADO
			        		VehiculosLogic.modificarEstacionado(VehiculosLogic.obtener(patente));
			        		JOptionPane.showMessageDialog(contentPane, "Se agregó el vehículo con patente " + patente);
			        	}
			            

			            // LIMPIA LOS CAMPOS DE ENTRADA
			            txtPatente.setText("");
			            comboTipo.setSelectedIndex(0);
			        }
			    } else {
			        JOptionPane.showMessageDialog(contentPane, "La patente ingresada no es válida.");

			        // LIMPIA LOS CAMPOS DE ENTRADA
			        txtPatente.setText("");
			        comboTipo.setSelectedIndex(0);
			    }
			}

		});
		
		contentPane.add(btnAgregar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuOperador menuope = new MenuOperador();
				menuope.setVisible(true);
			}
		});
		contentPane.add(btnSalir);
	}
	
	
	


}
