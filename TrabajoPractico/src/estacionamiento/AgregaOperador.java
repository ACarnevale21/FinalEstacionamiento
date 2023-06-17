package estacionamiento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregaOperador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textContra;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregaOperador frame = new AgregaOperador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AgregaOperador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 325);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 2, 10, 20));
		
		JLabel lblNewLabel = new JLabel("Agregar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Operador");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblUsuario);
		
		textUsuario = new JTextField();
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contrasenia");
		lblContrasenia.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblContrasenia);
		
		textContra = new JTextField();
		contentPane.add(textContra);
		textContra.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCargo);
		
		JComboBox<String> comboCargo;
		comboCargo = new JComboBox<String>();
		comboCargo.setMaximumRowCount(2);
		comboCargo.addItem("O");
		comboCargo.addItem("A");
		contentPane.add(comboCargo);
		
		JLabel lblHabilitado = new JLabel("Habilitado");
		lblHabilitado.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblHabilitado);
		
		JCheckBox checkHabilitado = new JCheckBox("Marque para habilitar");
		contentPane.add(checkHabilitado);
		
		JButton btnAgregarOperador = new JButton("Agregar");
		btnAgregarOperador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String hab;
				//VERIFICA SI INGRESO CARACTERES
				if (!textUsuario.getText().isEmpty() && !textContra.getText().isEmpty()) {
					if (checkHabilitado.isSelected()) {
						hab = "Habilitado";
					}else {
						hab ="Deshabilitado";
					}
					//CREA UNA INSTANCIA DE EMPLEADO Y VERIFICA SI EL USUARIO YA EXISTE
					Empleado empleado = new Empleado(textUsuario.getText(),textContra.getText(),comboCargo.getSelectedItem().toString(),hab);
					if (EmpleadoLogic.insertar(empleado)){
						JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
						textUsuario.setText("");
						textContra.setText("");
					}else {
						JOptionPane.showMessageDialog(null, "Usuario ya existente","Error", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Debe ingresar al menos un caracter en Usuario y Contrasenia", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		contentPane.add(btnAgregarOperador);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuAdm menuadm = new MenuAdm();
				menuadm.setVisible(true);
			}
		});
		contentPane.add(btnSalir);
		
	}

}
