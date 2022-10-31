import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class merci {

	private JFrame frmGestionDuTemps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					merci window = new merci();
					window.frmGestionDuTemps.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public merci() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDuTemps = new JFrame();
		frmGestionDuTemps.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\21262\\Desktop\\LOFO.png"));
		frmGestionDuTemps.setTitle("Gestion du Temps de Travail des Employ\u00E9s");
		frmGestionDuTemps.getContentPane().setForeground(Color.WHITE);
		frmGestionDuTemps.setBounds(100, 100, 790, 447);
		frmGestionDuTemps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDuTemps.getContentPane().setLayout(null);
		frmGestionDuTemps.setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("Merci de pointer l'entr\u00E9e \uD83D\uDE04");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 42));
		lblNewLabel.setBounds(129, 140, 561, 82);
		frmGestionDuTemps.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Quitter");
		btnNewButton.setBackground(new Color(0, 206, 209));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGestionDuTemps= new JFrame("Exit");
				System.exit(0);
			}
		});
		btnNewButton.setBounds(624, 340, 89, 23);
		frmGestionDuTemps.getContentPane().add(btnNewButton);
	}
}
