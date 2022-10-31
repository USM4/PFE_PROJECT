import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JComboBox;


import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.DataBufferUShort;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.DefaultButtonModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Rectangle;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;

public class GestionAbs {

	private JFrame frmGestionDesAbsences;
	private JTextField textField_2;
	private JComboBox comboBox ;
	Connection cnx;
	PreparedStatement prepared ;
	ResultSet resultat; 
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionAbs window = new GestionAbs();
					window.frmGestionDesAbsences.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionAbs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDesAbsences = new JFrame();
		frmGestionDesAbsences.setTitle("Gestion des absences ");
		frmGestionDesAbsences.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\21262\\Desktop\\LOFO.png"));
		frmGestionDesAbsences.setBounds(100, 100, 994, 546);
		frmGestionDesAbsences.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDesAbsences.getContentPane().setLayout(null);
		frmGestionDesAbsences.setLocationRelativeTo(null);
		cnx=  Connection_SQL.ConnexionDB();

		JButton btnNewButton_3_1 = new JButton("Se d\u00E9connecter");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a= JOptionPane.showConfirmDialog(btnNewButton_3_1,"êtes-vous sûr");
				if (a==JOptionPane.YES_OPTION) {
					
					FirstTest tst= new FirstTest();
					tst.Firstframe.setVisible(true);
					frmGestionDesAbsences.dispose();
				} 
				
			}
		});
		btnNewButton_3_1.setForeground(Color.BLACK);
		btnNewButton_3_1.setBackground(Color.WHITE);
		btnNewButton_3_1.setBounds(833, 11, 135, 23);
		frmGestionDesAbsences.getContentPane().add(btnNewButton_3_1);
		
		JButton btnPrcedent = new JButton("Pr\u00E9cedent");
		btnPrcedent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmGestionDesAbsences.dispose();
				Choix.main(null);
			}
		});
		btnPrcedent.setForeground(Color.BLACK);
		btnPrcedent.setBackground(new Color(0, 206, 209));
		btnPrcedent.setBounds(20, 83, 100, 23);
		frmGestionDesAbsences.getContentPane().add(btnPrcedent);
		
		JLabel lblNewLabel_9 = new JLabel("Format : dd/mm/yyyy");
		lblNewLabel_9.setForeground(new Color(230, 230, 250));
		lblNewLabel_9.setBounds(239, 248, 127, 14);
		frmGestionDesAbsences.getContentPane().add(lblNewLabel_9);
		
		JTextPane textPane = new JTextPane();
		textPane.setToolTipText("dd/mm/yyyy");
		textPane.setBounds(169, 217, 197, 26);
		frmGestionDesAbsences.getContentPane().add(textPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(396, 117, 572, 379);
		frmGestionDesAbsences.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 572, 379);
		panel.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nom employ\u00E9", "Date d'abcense", "Raison d'abcense"
			}
		));
		
		
		
		table.setForeground(new Color(0, 128, 0));
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setBackground(new Color(0, 0, 0));
	
		
		JButton btnNewButton_3 = new JButton("Actualiser");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateTable();
			}
		});
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(new Color(0, 206, 209));
		btnNewButton_3.setBounds(868, 83, 100, 23);
		frmGestionDesAbsences.getContentPane().add(btnNewButton_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Selectionnez", "Malade", "Retard"}));
		comboBox_1.setBounds(170, 273, 197, 26);
		frmGestionDesAbsences.getContentPane().add(comboBox_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selectionnez"}));
		comboBox.setBounds(169, 166, 197, 26);
		frmGestionDesAbsences.getContentPane().add(comboBox);
		String sql= "Select * from employe ";
		try {
			
			 
			prepared= cnx.prepareStatement(sql); 
			resultat=prepared.executeQuery();
			while(resultat.next()) {
				String nom=resultat.getString("username").toString();
				comboBox.addItem(nom);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBackground(new Color(0, 206, 209));
		       
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				String nomemp= comboBox.getSelectedItem().toString();
				String Date =textPane.getText();
                String raison =comboBox_1.getSelectedItem().toString();
                String sql2="insert into abs(username,Date_abs,raison) values(?,?,?)";
                 try {
                	 if(comboBox.getSelectedItem().equals("Selectionnez")|| Date.equals("")|| comboBox_1.getSelectedItem().equals("Selectionnez"))
                	 {
                		JOptionPane.showMessageDialog(null, "Completez les informations ");
                	 }
                	 else {
                		 prepared=cnx.prepareStatement(sql2);
                		 prepared.setString(1, nomemp);
                		 prepared.setString(2, Date);
                		 prepared.setString(3, raison);
                		 prepared.execute();
                		 
                		 comboBox.setSelectedItem("Selectionnez");
                		 comboBox_1.setSelectedItem("Selectionnez");
                		 textPane.setText("dd/mm/yyyy");
                		 JOptionPane.showMessageDialog(null, "absence ajoutée ");
                		 UpdateTable();
                		
                	 }
                	 }catch (Exception e) {
     					e.printStackTrace();
     				}

			}
		});
		
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int ligne =table.getSelectedRow();
				String nomemp=comboBox.getSelectedItem().toString();
				String Date = textPane.getText();
                String raison =comboBox_1.getSelectedItem().toString();
                String sql1 = null;
				if(ligne== -1) {
					JOptionPane.showMessageDialog(null, "Selectionnez une absence ");
				}
				else {
					String id1=table.getModel().getValueAt(ligne,0).toString();
					sql1= "update abs set username = ?, Date_abs = ?,raison = ? where id_abs ='"+id1+"'";
				     
				}
				 try {
					 prepared=cnx.prepareStatement(sql1);
            		 prepared.setString(1, nomemp);
            		 prepared.setString(2, Date);
            		 prepared.setString(3, raison);
					 prepared.execute();
					 JOptionPane.showMessageDialog(null, "Absence modifié ");
					 UpdateTable();
				 }catch (Exception e) {
  					e.printStackTrace();
  				}
				
				
				
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(0, 206, 209));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(141, 448, 100, 23);
		frmGestionDesAbsences.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int ligne =table.getSelectedRow();
				if(ligne== -1) {
					
					JOptionPane.showMessageDialog(null, "Selectionnez une absence ");
				}
				else {
					String id=table.getModel().getValueAt(ligne,0).toString();
					
					String  sql= "delete from abs where id_abs ='"+id+"'";
				
				 try {
					 prepared= cnx.prepareStatement(sql);
					 prepared.execute();
					 UpdateTable1();
					 JOptionPane.showMessageDialog(null, "Absence supprimé ");
				 }catch (Exception e) {
  					e.printStackTrace();
  				}
				 
				}
				
				
				
				
				
				
			}
		});
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBackground(new Color(0, 206, 209));
		btnNewButton_2.setBounds(266, 448, 100, 23);
		frmGestionDesAbsences.getContentPane().add(btnNewButton_2);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(20, 448, 100, 23);
		frmGestionDesAbsences.getContentPane().add(btnNewButton);
		
		
		
		
		
		
		
		
		JLabel lblNewLabel_5 = new JLabel("GESTION DES ABSENCES");
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 42));
		lblNewLabel_5.setBounds(295, 31, 422, 42);
		frmGestionDesAbsences.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_8 = new JLabel("Motif :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(94, 273, 41, 14);
		frmGestionDesAbsences.getContentPane().add(lblNewLabel_8);
		JLabel lblNewLabel_6 = new JLabel("Nom d'employ\u00E9 :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(32, 170, 114, 14);
		frmGestionDesAbsences.getContentPane().add(lblNewLabel_6);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Date d'absence :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(32, 217, 114, 14);
		frmGestionDesAbsences.getContentPane().add(lblNewLabel_7);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\21262\\Desktop\\design\\Screenshot 2021-06-11 193835.png"));
		lblNewLabel.setBounds(0, 0, 978, 109);
		frmGestionDesAbsences.getContentPane().add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\21262\\Desktop\\design\\Screenshot 2021-06-11 193726.png"));
		lblNewLabel_1.setBounds(0, 109, 978, 4);
		frmGestionDesAbsences.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\21262\\Desktop\\design\\Screenshot 2021-06-11 193726.png"));
		lblNewLabel_2.setBounds(386, 109, 4, 411);
		frmGestionDesAbsences.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\21262\\Desktop\\design\\Screenshot 2021-06-11 193835.png"));
		lblNewLabel_3.setBounds(0, 112, 403, 408);
		frmGestionDesAbsences.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\21262\\Desktop\\design\\Screenshot 2021-06-11 193835.png"));
		lblNewLabel_4.setBounds(386, 109, 592, 398);
		frmGestionDesAbsences.getContentPane().add(lblNewLabel_4);
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
	}
	public void UpdateTable() {
		String sql="select * from  abs ";
		try {
			prepared= cnx.prepareStatement(sql);
			resultat=prepared.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));
			
		} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	 public void UpdateTable1() {
		 String sql="select * from abs";
		 try {
			 prepared= cnx.prepareStatement(sql);
				resultat=prepared.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(resultat));
		 }catch (Exception e) {
				e.printStackTrace();
			} finally  {
				try {
					resultat.close();
					prepared.close();
					
				}catch (Exception e) {
					
				}
				
			}
	 }
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

