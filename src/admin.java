import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class admin {

	private JFrame frmGestionDuTemps;
	private JTextField textField;
	Connection cnx1;
	PreparedStatement ps ;
	ResultSet res,res1;
	int i=0;
	public static String nameEmp1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin window = new admin();
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
	public admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDuTemps = new JFrame();
		frmGestionDuTemps.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\21262\\Desktop\\LOFO.png"));
		frmGestionDuTemps.setTitle("Gestion du Temps de Travail des Employ\u00E9s");
		frmGestionDuTemps.getContentPane().setBackground(new Color(153, 0, 255));
		frmGestionDuTemps.setBounds(100, 100, 782, 457);
		frmGestionDuTemps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDuTemps.getContentPane().setLayout(null);
		frmGestionDuTemps.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 206, 209));
		panel.setBounds(249, 158, 374, 57);
		frmGestionDuTemps.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 354, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nom d'utilisateur :");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel.setBounds(89, 181, 150, 14);
		frmGestionDuTemps.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("RECHERCHER");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(new Color(0, 206, 209));
		cnx1=  Connection_SQL.ConnexionDB();
          
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			 String requete="select username from employe where username=?";
			 String username = textField.getText();
			 try {
				 
				    
				ps= cnx1.prepareStatement(requete);
				ps.setString(1, textField.getText());
				res= ps.executeQuery();
				
				while (res.next()) {
					
					 String username1 = res.getString("username");
					 
					if(username1.equals(username)) {
					    i=1;
					    
					    nameEmp1=username1;
					    
					    
					    frmGestionDuTemps.dispose();
						Tab.main(null); 
						
						
					}
					
											
				}
				if(i!=1 ) 
				{
					
					 JOptionPane.showMessageDialog(null, "employé n'existe pas vueillez réssayer","Erreur",JOptionPane.ERROR_MESSAGE);
					 
					 
				 }

				
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			 
			
			}
		});
		
		btnNewButton.setBounds(306, 274, 135, 35);
		frmGestionDuTemps.getContentPane().add(btnNewButton);
		
		JButton btnPrcedent = new JButton("Pr\u00E9cedent");
		btnPrcedent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGestionDuTemps.dispose();
				
			}
		});
		btnPrcedent.setForeground(Color.BLACK);
		btnPrcedent.setBackground(new Color(0, 206, 209));
		btnPrcedent.setBounds(33, 362, 100, 23);
		frmGestionDuTemps.getContentPane().add(btnPrcedent);
	}
}
