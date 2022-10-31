import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import javax.swing.JPanel;
import java.awt.Toolkit;

public class Tab {

	private JFrame frmGestionDuTemps;
	private JTable table;
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
					Tab window = new Tab();
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
	public Tab() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frmGestionDuTemps = new JFrame();
		frmGestionDuTemps.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\21262\\Desktop\\LOFO.png"));
		frmGestionDuTemps.setTitle("Gestion du Temps de Travail des Employ\u00E9s");
		frmGestionDuTemps.getContentPane().setBackground(new Color(0, 206, 209));
		frmGestionDuTemps.setBounds(100, 100, 736, 468);
		frmGestionDuTemps.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDuTemps.getContentPane().setLayout(null);
		frmGestionDuTemps.setLocationRelativeTo(null);
		cnx=  Connection_SQL.ConnexionDB();
		JPanel panel = new JPanel();
		panel.setBounds(20, 49, 652, 339);
		frmGestionDuTemps.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		scrollPane.setBounds(0, 5, 652, 334);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Date", "Debut", "Fin", "heures normale", "heures supplementaire"
			}
		)
	);
		table.getColumnModel().getColumn(0).setPreferredWidth(135);
		table.getColumnModel().getColumn(1).setPreferredWidth(76);
		table.getColumnModel().getColumn(3).setPreferredWidth(111);
		table.getColumnModel().getColumn(4).setPreferredWidth(138);
		
		
		
	
		
			
		JLabel lblNewLabel = new JLabel("Nom d'employ\u00E9 : ");
		lblNewLabel.setBounds(10, 11, 230, 32);
		lblNewLabel.setBackground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Calisto MT", Font.BOLD,26));
		frmGestionDuTemps.getContentPane().add(lblNewLabel);
		lblNewLabel.setText(String.valueOf(admin.nameEmp1));
		
		JButton btnNewButton = new JButton("Actualiser");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
                       UpdateTable(); 
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(153, 0, 255));
		btnNewButton.setBounds(572, 16, 100, 23);
		frmGestionDuTemps.getContentPane().add(btnNewButton);
		
		JButton btnQuitter = new JButton("Se déconnecter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a= JOptionPane.showConfirmDialog(btnNewButton, "êtes-vous sûr");
				if (a==JOptionPane.YES_OPTION) {
					
					FirstTest tst= new FirstTest();
					tst.Firstframe.setVisible(true);
					frmGestionDuTemps.dispose();
				} 
			}
		});
		
		

		
		
		
		
		
		
		
		
		btnQuitter.setForeground(Color.BLACK);
		btnQuitter.setBackground(new Color(153, 0, 255));
		btnQuitter.setBounds(557, 395, 125, 23);
		frmGestionDuTemps.getContentPane().add(btnQuitter);
		
		JButton btnPrcedent = new JButton("Pr\u00E9cedent");
		btnPrcedent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		    frmGestionDuTemps.dispose();
			admin.main(null);
			}
		});
		btnPrcedent.setForeground(Color.BLACK);
		btnPrcedent.setBackground(new Color(153, 0, 255));
		btnPrcedent.setBounds(30, 395, 100, 23);
		frmGestionDuTemps.getContentPane().add(btnPrcedent);}
		
		public void UpdateTable() {
			String sql="SELECT * from heure_sup h where h.id_user=(select employe.user_id from employe where username= '"+admin.nameEmp1+"')";
			
			try {
				prepared= cnx.prepareStatement(sql);
				resultat=prepared.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(resultat));
				
			} catch (Exception e) {
					e.printStackTrace();
				}
			
	}
		}
