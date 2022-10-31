import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Sortie {

	private JFrame frmGestionDuTemps;
	private JTextField txtSortiA;
	Connection cnx;
	PreparedStatement prepared ;
	ResultSet resultat;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sortie window = new Sortie();
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
	public Sortie() {
	
		initialize();
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void  initialize() {
		frmGestionDuTemps = new JFrame();
		frmGestionDuTemps.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\21262\\Desktop\\LOFO.png"));
		frmGestionDuTemps.getContentPane().setBackground(Color.WHITE);
		frmGestionDuTemps.setTitle("La sortie");
		frmGestionDuTemps.setBounds(100, 100, 768, 480);
		frmGestionDuTemps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDuTemps.getContentPane().setLayout(null);
		frmGestionDuTemps.setLocationRelativeTo(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(259, 11, 235, 214);
		frmGestionDuTemps.getContentPane().add(lblNewLabel);
		ImageIcon img= new ImageIcon(this.getClass().getResource("/sortieRE.png"));
		lblNewLabel.setIcon(img);
		 
		cnx=  Connection_SQL.ConnexionDB(); 
		txtSortiA = new JTextField();
		txtSortiA.setHorizontalAlignment(SwingConstants.CENTER);
		txtSortiA.setEditable(false);
		txtSortiA.setFont(new Font("Sitka Banner", Font.BOLD, 42));
		txtSortiA.setText("Sorti a :");
		DateTimeFormatter T= DateTimeFormatter.ofPattern("HH:mm");
		LocalTime now1= LocalTime.now();
		txtSortiA.setText(T.format(now1));
		String f=now1.toString();
		String debut="";
		
		try {
			 PreparedStatement prepared1 =cnx.prepareStatement ("select Debut from heure_sup");
			 PreparedStatement prepared =cnx.prepareStatement ("update heure_sup set Fin=? where Debut=?");
			 
			 resultat=prepared1.executeQuery();
			
				while (resultat.next())
				{
				debut = resultat.getString("Debut");
				
				}		
				System.out.println(f);
				
			prepared.setString(1,f);
			prepared.setString(2,debut);
			prepared.execute();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		try {
			 PreparedStatement prepared1 =cnx.prepareStatement ("select id, Debut, Fin from heure_sup");
			
			 resultat=prepared1.executeQuery();
			 String debut1="";
			 String fin="";	
			
			 while (resultat.next())
				{
				debut1 = resultat.getString("Debut");
				fin = resultat.getString("Fin");
		
				LocalTime time1 = LocalTime.parse(debut1);
	             LocalTime time2 = LocalTime.parse(fin);
	             
	            		 int id = resultat.getInt("id");
	            
	             Duration calculatedTime = Duration.between(time1, time2);
	             if (calculatedTime.isNegative()) {
	                 calculatedTime = calculatedTime.plusDays(1);
	                 
	             }
	             
	           long hrs = calculatedTime.toHours();
	             calculatedTime = calculatedTime.minusHours(hrs);
	             //String formattedTime = String.format(Locale.getDefault(),"%d:%02d",hrs, calculatedTime.toMinutes());
	          
	            
					PreparedStatement ps =cnx.prepareStatement ("update heure_sup set heures_normale =?,heures_supplementaire =? where id=?");
					if (hrs <=8) { 
						
						
						 long sup=0;
					   	 ps.setLong(1,hrs);
						 ps.setLong(2,sup);
			             ps.setInt(3,id);
			             ps.execute();
					}
					else {
						
						 long sup = hrs-8 ;
						 
						 hrs=8;
						 ps.setLong(1,hrs);
			             ps.setLong(2,sup);
			             ps.setInt(3,id);
			             ps.execute();
					}
	            
	       
	           
				}		
			    
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	     
		
		txtSortiA.setBackground(new Color(204, 153, 204));
		txtSortiA.setBounds(366, 260, 128, 42);
		frmGestionDuTemps.getContentPane().add(txtSortiA);
		txtSortiA.setColumns(10);
		
		JButton btnNewButton = new JButton("Avancé");
		btnNewButton.setBackground(new Color(0, 206, 209));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				merci2.main(null);
				frmGestionDuTemps.dispose();
			}
		});
		btnNewButton.setBounds(595, 366, 89, 23);
		frmGestionDuTemps.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Sorti a :");
		lblNewLabel_1.setFont(new Font("Sitka Banner", Font.BOLD, 33));
		lblNewLabel_1.setBounds(240, 268, 116, 30);
		frmGestionDuTemps.getContentPane().add(lblNewLabel_1);
	}
	
	
}
