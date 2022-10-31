import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Entrer {

	private JFrame frmGestionDuTemps;
	private JTextField txtPointageValidA;
	private JLabel lblNewLabel_1;
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
					Entrer window = new Entrer();
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
	public Entrer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDuTemps = new JFrame();
		frmGestionDuTemps.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\21262\\Desktop\\LOFO.png"));
		frmGestionDuTemps.getContentPane().setFont(new Font("Sitka Banner", Font.BOLD, 37));
		frmGestionDuTemps.setTitle("L'Entrer");
		frmGestionDuTemps.getContentPane().setBackground(new Color(0, 206, 209));
		frmGestionDuTemps.setBounds(100, 100, 771, 460);
		frmGestionDuTemps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDuTemps.getContentPane().setLayout(null);
		frmGestionDuTemps.setLocationRelativeTo(null);
		cnx=  Connection_SQL.ConnexionDB();
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(163, 34, 419, 215);
		ImageIcon img=new ImageIcon(this.getClass().getResource("/Scre.png"));
		lblNewLabel.setIcon(img);
		frmGestionDuTemps.getContentPane().add(lblNewLabel);
		
		txtPointageValidA = new JTextField();
		txtPointageValidA.setEditable(false);
		txtPointageValidA.setForeground(new Color(0, 0, 0));
		txtPointageValidA.setBackground(new Color(204, 153, 204));
		txtPointageValidA.setSelectedTextColor(Color.BLACK);
		txtPointageValidA.setFont(new Font("Sitka Banner", Font.BOLD, 42));
		txtPointageValidA.setText(" Entr\u00E9 a :");
		txtPointageValidA.setToolTipText("");
		txtPointageValidA.setBounds(364, 268, 107, 50);
		frmGestionDuTemps.getContentPane().add(txtPointageValidA);
		txtPointageValidA.setColumns(10);
		DateTimeFormatter T=DateTimeFormatter.ofPattern("HH:mm");
		LocalTime now= LocalTime.now();
		LocalDate date= LocalDate.now();
		
		String x=now.toString();
		String y=date.toString();
		
		
		txtPointageValidA.setText(T.format(now));
		
		 
		 try {
			
			PreparedStatement prepared =cnx.prepareStatement ("insert into heure_sup(id_user,Date,Debut) values(?,?,?)");
			prepared.setInt(1,FirstTest.userId);
			prepared.setString(2,y);
			prepared.setString(3,x);
			 
			
			prepared.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
			
		
		
		lblNewLabel_1 = new JLabel("Entr\u00E9 a :");
		lblNewLabel_1.setFont(new Font("Sitka Banner", Font.BOLD, 37));
		lblNewLabel_1.setBounds(227, 274, 140, 42);
		frmGestionDuTemps.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Avancer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				merci.main(null);
				frmGestionDuTemps.dispose();
			}
		});
		btnNewButton.setBounds(598, 354, 95, 23);
		frmGestionDuTemps.getContentPane().add(btnNewButton);
	}
}
