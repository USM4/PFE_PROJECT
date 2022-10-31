import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.SwingConstants;

import com.mysql.cj.callback.UsernameCallback;



import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Fenetre2 {

	private JFrame frmGestionDuTemps;
	private JTextField txtBonjour;
	ResultSet resultat;
	 Connection cnx = Connection_SQL.ConnexionDB();
		Statement st ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre2 window = new Fenetre2();
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
	public Fenetre2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDuTemps = new JFrame();
		frmGestionDuTemps.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\21262\\Desktop\\LOFO.png"));
		frmGestionDuTemps.getContentPane().setBackground(Color.WHITE);
		frmGestionDuTemps.setBackground(new Color(0, 0, 0));
		frmGestionDuTemps.setTitle("Choix de pointage ");
		frmGestionDuTemps.setBounds(100, 100, 754, 459);
		frmGestionDuTemps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDuTemps.getContentPane().setLayout(null);
		frmGestionDuTemps.setLocationRelativeTo(null);
		
		
		
		txtBonjour = new JTextField();
		txtBonjour.setHorizontalAlignment(SwingConstants.CENTER);
		txtBonjour.setEditable(false);
		txtBonjour.setFont(new Font("OCR A Extended", Font.BOLD, 40));
		txtBonjour.setBackground(new Color(0, 206, 209));
		txtBonjour.setBounds(48, 75, 637, 60);
		frmGestionDuTemps.getContentPane().add(txtBonjour);
		txtBonjour.setColumns(10);
				
		
		txtBonjour.setText(String.valueOf("Bonjour Mr."+FirstTest.nameEmp));
		
		
		
		
       
       
		JButton btnNewButton = new JButton("Entrer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGestionDuTemps.dispose();
				Entrer.main(null);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(153, 0, 255));
		btnNewButton.setBounds(158, 255, 133, 34);
		frmGestionDuTemps.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sortir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGestionDuTemps.dispose();
				Sortie.main(null);
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(153, 0, 255));
		btnNewButton_1.setBounds(428, 255, 133, 34);
		frmGestionDuTemps.getContentPane().add(btnNewButton_1);
	}

	

	
}
