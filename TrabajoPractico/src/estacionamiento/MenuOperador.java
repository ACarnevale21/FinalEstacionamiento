package estacionamiento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuOperador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOperador frame = new MenuOperador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MenuOperador() {
		//CREA EL PANEL DE OPERADOR
		setTitle("Menu Operador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 1, 0, 10));
		
		JLabel lblTituloOp = new JLabel("Menu Operador");
		lblTituloOp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTituloOp.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTituloOp);
		
		JButton btnEntradaVehiculo = new JButton("Entrada Vehiculo");
		btnEntradaVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EntradaVehiculo entradaV = new EntradaVehiculo();
				entradaV.setVisible(true);
			}
		});
		contentPane.add(btnEntradaVehiculo);
		
		JButton btnSalidaVehiculo = new JButton("Salida Vehiculo");
		btnSalidaVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SalidaVehiculos salidaV = new SalidaVehiculos();
				salidaV.setVisible(true);
				
			}
		});
		contentPane.add(btnSalidaVehiculo);
		
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
