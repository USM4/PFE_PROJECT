import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class Choix {

	private JFrame frmLesServices;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Choix window = new Choix();
					window.frmLesServices.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Choix() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLesServices = new JFrame();
		frmLesServices.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\21262\\Desktop\\LOFO.png"));
		frmLesServices.setTitle("Les services ");
		frmLesServices.getContentPane().setBackground(new Color(153, 0, 255));
		frmLesServices.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Gestion des abcenses");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLesServices.dispose();
				GestionAbs.main(null);
			}
		});
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(0, 206, 209));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(78, 237, 217, 87);
		frmLesServices.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Suivi les heures d'employ\u00E9");
		btnNewButton_1.setForeground(new Color(0, 206, 209));
		btnNewButton_1.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			admin.main(null);
			}
		});
		btnNewButton_1.setBounds(413, 237, 238, 87);
		frmLesServices.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\21262\\Desktop\\TKHERBI9\\LOFO.png"));
		lblNewLabel_2.setBounds(101, 11, 507, 155);
		frmLesServices.getContentPane().add(lblNewLabel_2);
		frmLesServices.setBounds(100, 100, 749, 435);
		frmLesServices.setLocationRelativeTo(null);
		frmLesServices.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
