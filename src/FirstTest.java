import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JTextField;


import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
public class FirstTest {

	 JFrame Firstframe;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	Connection cnx;
	PreparedStatement prepared ;
	ResultSet resultat;
 public static String nameEmp;
 public static int userId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstTest window = new FirstTest();
					window.Firstframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FirstTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private  void initialize() {
		Firstframe = new JFrame();
		Firstframe.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		Firstframe.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		Firstframe.getContentPane().setBackground(new Color(153, 0, 255));
		Firstframe.setBounds(100, 100, 768, 451);
		Firstframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Firstframe.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(273, 210, 238, 44);
		panel.setBackground(new Color(0, 206, 209));
		Firstframe.getContentPane().add(panel);
		panel.setLayout(null);
		cnx=  Connection_SQL.ConnexionDB();
				
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtUsername.setBounds(10, 11, 218, 22);
		txtUsername.setBackground(new Color(255, 255, 255));
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(273, 277, 238, 44);
		panel_1.setBackground(new Color(0, 206, 209));
		Firstframe.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setSelectedTextColor(new Color(34, 139, 34));
		passwordField.setBounds(10, 11, 218, 22);
		panel_1.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Nom d'utilisateur :");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(148, 218, 115, 24);
		Firstframe.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de passe :");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(158, 290, 111, 14);
		Firstframe.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("S'identifier");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0)); 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username0 = txtUsername.getText();
				String password0= passwordField.getText();
				int i=0;
				if (username0.contains("mouadoussama") && password0.contains("1111")) 
				{
				     i=2;
				     
				     Firstframe.dispose();
					  Choix.main(null);
					
					
				}
				
				
				String username = txtUsername.getText();
				String password= passwordField.getText();
				
				String sql="select user_id ,username , password from employe";
				
				try {
					
					prepared= cnx.prepareStatement(sql);
					resultat=prepared.executeQuery();
					
					
					while (resultat.next())
					{
					String username1 = resultat.getString("username");
					String password1 = resultat.getString("password");
					int id = resultat.getInt("user_id");		
					
					if (username1.equals(username) && password1.equals(password) )
					{
					      
				        i=1;
				        username1=resultat.getString("username");
				    	 id = resultat.getInt("user_id");	
						nameEmp=username1;	
						userId=id;
						
						Firstframe.dispose();
					    Fenetre2.main(null);
					
					
					}
					
					System.out.println(userId);
					}
					
					
				} catch (SQLException e) {
				   
					e.printStackTrace();
					
				}
				
				if(i!=1 && i!=2 ) 
				{
					 JOptionPane.showMessageDialog(null, "Connexion echoué","Erreur",JOptionPane.ERROR_MESSAGE);
					 
				 }
				
				
				
				
				
				
			}
		});
		btnNewButton.setBackground(new Color(0, 206, 209));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton.setBounds(324, 356, 139, 31);
		Firstframe.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(108, -11, 480, 218);
		Firstframe.getContentPane().add(lblNewLabel_2);
        ImageIcon img=new ImageIcon(this.getClass().getResource("/LOFO.png"));
        lblNewLabel_2.setIcon(img);
        
        Firstframe.setUndecorated(true);
        Firstframe.setLocationRelativeTo(null);
        
        
		
	}
}
