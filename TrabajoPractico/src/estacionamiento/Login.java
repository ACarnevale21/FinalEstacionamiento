package estacionamiento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Font;

public class Login extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtextUsuario;
	private JPasswordField jpassContra;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//--- GENERA CUENTA ADMINISTRADOR ---
					
					Empleado admin = new Empleado("admin", "admin", "A", "Habilitado");
					EmpleadoLogic.insertar(admin);
					//--- GENERA CUENTA OPERADOR ---
					Empleado operador = new Empleado("agus", "asdasd","O","Habilitado");
					EmpleadoLogic.insertar(operador);
					//-------------     ---------------
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Login() {
		//INICIO PANEL LOGIN
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(4, 2, 10, 30));
		
		JLabel lblNewLabel_1 = new JLabel("Inicio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Sesion");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(lblNewLabel);
		
		JLabel jLabelUsuario = new JLabel("Usuario");
		jLabelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jLabelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(jLabelUsuario);
		
		jtextUsuario = new JTextField();
		jtextUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(jtextUsuario);
		jtextUsuario.setColumns(10);
		
		JLabel jLabelContra = new JLabel("Contrasenia");
		jLabelContra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		jLabelContra.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(jLabelContra);
		
		jpassContra = new JPasswordField();
		jpassContra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(jpassContra);
		
		JButton btnIngreso = new JButton("Ingresar");
		btnIngreso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(btnIngreso);
		
		//CREAR METODO PARA INGRESO DE USUARIO
		//VERIFICA QUE EL USUARIO Y CONTRASEñA SEAN CORRECTOS
		btnIngreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!jtextUsuario.getText().isEmpty()&&!jpassContra.getText().isEmpty()) {
					if (EmpleadoLogic.autentificar(jtextUsuario.getText(),jpassContra.getText())) {
						if (EmpleadoLogic.obtener(jtextUsuario.getText()).getCargo().equals("A")) {
							JOptionPane.showMessageDialog(contentPane, "Bienvenido " + jtextUsuario.getText());	
							dispose();
							MenuAdm menuA = new MenuAdm();
							menuA.setVisible(true);
						}else {
							if (EmpleadoLogic.obtener(jtextUsuario.getText()).getHabilitado().equals("Habilitado")) {
								JOptionPane.showMessageDialog(contentPane, "Bienvenido " + jtextUsuario.getText());
								dispose();
								MenuOperador menuO = new MenuOperador();
								menuO.setVisible(true);
							}else {
								JOptionPane.showMessageDialog(contentPane, "Usted no esta habilitado en el sistema","Error", JOptionPane.ERROR_MESSAGE);
							}
						}
					}else {
						JOptionPane.showMessageDialog(contentPane, "Error usuario o contrasenia incorrectos.","Error", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(contentPane, "Falta ingresar usuario o contrasenia.","Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(btnSalir);
		
		//SI DESEA SALIR DE LA APLICACION 
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
	}
	public boolean validaIngreso() {
		
		return false;
	}
}