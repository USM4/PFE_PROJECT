import javax.swing.*;
import java.sql.*;
public class Connection_SQL {
	
	Connection conn=null;
	
	 static Connection ConnexionDB() {
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/gestionemp","root","");
				
				return conn;
			
		}catch (Exception e) 
		{
			
		JOptionPane.showMessageDialog(null, e);
		 return null;
		}
		
	}
	
	
	
}
