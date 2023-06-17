package estacionamiento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MenuAdm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdm frame = new MenuAdm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MenuAdm() {
		//CREA EL PANEL DE ADMINISTRADOR
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 365);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(7, 1, 0, 7));
		
		JLabel lblNewLabel = new JLabel("Menu Administrador");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JButton btnNewOperador = new JButton("Agregar Operador");
		btnNewOperador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregaOperador agregaOpe = new AgregaOperador();
				dispose();
				agregaOpe.setVisible(true);
			}
		});
		contentPane.add(btnNewOperador);
		
		JButton btnHabOperador = new JButton("Habilitar / Deshabilitar Operador");
		btnHabOperador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HabilitaDeshabOpe hab = new HabilitaDeshabOpe();
				hab.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnHabOperador);
		
		JButton btnTotalCob = new JButton("Total Cobrado");
		btnTotalCob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Total Cobrado: $"+VehiculosLogic.getTotalCobrado());
			}
		});
		contentPane.add(btnTotalCob);
		
		
		JButton btnCantVehiculos = new JButton("Cantidad de vehiculos estacionados");
		btnCantVehiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VehiculosLogic.listarEstacionados(1);
			}
		});
		contentPane.add(btnCantVehiculos);
		
		JButton btnListadoIE = new JButton("Listado Ingresos / Egresos de vehiculos");
		btnListadoIE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VehiculosLogic.listarEstacionados(2);
			}
		});
		contentPane.add(btnListadoIE);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login log = new Login();
				log.setVisible(true);
			}
		});
		contentPane.add(btnCerrarSesion);
	}
}
