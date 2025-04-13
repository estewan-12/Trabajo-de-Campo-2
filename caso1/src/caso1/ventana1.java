package caso1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class ventana1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTasaActual;
	private JTextField txtTasa;
	private JLabel lblNewLabel;
	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana1 frame = new ventana1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ventana1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			txtTasa = new JTextField();
			txtTasa.setBounds(104, 112, 96, 19);
			contentPane.add(txtTasa);
			txtTasa.setColumns(10);
		}
		{
			lblNewLabel = new JLabel("Nueva tasa : ");
			lblNewLabel.setBounds(40, 115, 71, 13);
			contentPane.add(lblNewLabel);
		}
		{
			btnActualizar = new JButton("Actualizar");
			btnActualizar.addActionListener(this);
			btnActualizar.setBounds(40, 140, 85, 21);
			contentPane.add(btnActualizar);
		}
		{
		lblTasaActual = new JLabel("Tasa actual: " + Tasas.mostrarTasaInteres() + "%");
		lblTasaActual.setBounds(30, 80, 300, 25);
		}
		contentPane.add(lblTasaActual);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			do_btnActualizar_actionPerformed(e);
		}
	}
	protected void do_btnActualizar_actionPerformed(ActionEvent e) {
		try {
			double nueva = Double.parseDouble(txtTasa.getText());
			Tasas.actualizarTasaInteres(nueva);
			lblTasaActual.setText("Tasa actual: " + Tasas.mostrarTasaInteres() + "%");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Ingrese un número válido");
		}
	}
}
