package estacionamiento;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HabilitaDeshabOpe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HabilitaDeshabOpe frame = new HabilitaDeshabOpe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HabilitaDeshabOpe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 193);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHabilitaDeshabilita = new JLabel("Habilitar / Deshabilitar Operador");
		lblHabilitaDeshabilita.setBounds(10, 11, 418, 21);
		lblHabilitaDeshabilita.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblHabilitaDeshabilita.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblHabilitaDeshabilita);
		
		JLabel lblSelecciona = new JLabel("Seleccione Operador: ");
		lblSelecciona.setBounds(10, 43, 142, 29);
		lblSelecciona.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblSelecciona);
		
				
		//MUESTREO DE EMPLEADOS
		JComboBox<String> combo = EmpleadoLogic.muestreoEmpleados();
		contentPane.add(combo);
		
		//LABEL DE ESTADO ACTUAL
		JLabel lblEstado = new JLabel("Estado Actual:");
		lblEstado.setBounds(5, 83, 147, 17);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblEstado);
		
		//BOTON PARA SALIR
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuAdm menuA = new MenuAdm();
				menuA.setVisible(true);
			}
		});
		btnSalir.setBounds(268, 111, 89, 23);
		contentPane.add(btnSalir);
		
		//LABEL PARA MOSTRAR EL CAMBIO DE ESTADO HABILITADO/DESHABILITADO
		JLabel lblEstadoAct = new JLabel(EmpleadoLogic.estadoEmpleado(combo.getSelectedItem().toString()));
		lblEstadoAct.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadoAct.setBounds(162, 83, 96, 21);
		contentPane.add(lblEstadoAct);
		
		//ACTUALIZA EL ESTADO INSTANTANEAMENTE 
		combo.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Actualizar el texto del JLabel con el estado del empleado seleccionado en el JComboBox
		        String estadoEmpleado = EmpleadoLogic.estadoEmpleado(combo.getSelectedItem().toString());
		        lblEstadoAct.setText(estadoEmpleado);
		    }
		});
		
		//BOTON DE CAMBIAR ESTADO
		JButton btnHabilitar = new JButton("Cambiar Estado");
		btnHabilitar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        EmpleadoLogic.modificar(EmpleadoLogic.obtener(combo.getSelectedItem().toString()));
		        String estadoEmpleado = EmpleadoLogic.estadoEmpleado(combo.getSelectedItem().toString());
		        lblEstadoAct.setText(estadoEmpleado);
		    }
		});

		btnHabilitar.setBounds(64, 111, 142, 23);
		contentPane.add(btnHabilitar);
	}
}
