import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diksha More
 */
public class database {

    public static void main(String args[]) {
		        // MySQL connection details
		        String url = "jdbc:mysql://localhost:3306/expensetracking"; // Database URL (use the database you created)
		        String username = "root"; // Default MySQL username
		        String password = ""; // Default MySQL password (empty by default on WAMP)

		        try {
		            // Step 1: Load the MySQL JDBC driver
		            Class.forName("com.mysql.cj.jdbc.Driver");

		            // Step 2: Establish the connection
		            Connection con = DriverManager.getConnection(url, username, password);
		            System.out.println("Connected to the database.");

		            
		            // Step 5: Close the connection
		            con.close();
		        } catch (Exception e) {
		        	e.printStackTrace();
		        }
		    }


}
