import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class merci2 {

	private JFrame frmGestionDuTemps2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					merci2 window = new merci2();
					window.frmGestionDuTemps2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public merci2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDuTemps2 = new JFrame();
		frmGestionDuTemps2.setTitle("Gestion du Temps de Travail des Employ\u00E9s");
		frmGestionDuTemps2.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\21262\\Desktop\\LOFO.png"));
		frmGestionDuTemps2.getContentPane().setForeground(Color.WHITE);
		frmGestionDuTemps2.setBounds(100, 100, 790, 447);
		frmGestionDuTemps2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDuTemps2.getContentPane().setLayout(null);
		frmGestionDuTemps2.setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("Merci de pointer la sortie 😄");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 42));
		lblNewLabel.setBounds(129, 140, 561, 82);
		frmGestionDuTemps2.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Quitter");
		btnNewButton.setBackground(new Color(0, 206, 209));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGestionDuTemps2= new JFrame("Exit");
				System.exit(0);
			}
		});
		btnNewButton.setBounds(624, 340, 89, 23);
		frmGestionDuTemps2.getContentPane().add(btnNewButton);
	}
}

