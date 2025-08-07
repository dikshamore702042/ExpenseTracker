
package expensetracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class MonthlyExpenseReport extends javax.swing.JFrame {

    Connection con = null;
        PreparedStatement pst = null;
    public MonthlyExpenseReport() {
        initComponents();
        initComponents();
        setLocationRelativeTo(null); // Center the frame
        setTitle("Monthly Expense Report");
        //setupTable(); // Set correct table headers
        loadMonthlyExpenses(); 
        
    }
         private void loadMonthlyExpenses() {
       double totalAllMonths = 0;

        try {
            // Database connection
            String url = "jdbc:mysql://localhost:3306/expensetracking"; // Database URL (use the database you created)
		        String username = "root"; // Default MySQL username
		        String password = ""; // Default MySQL password (empty by default on WAMP)

		        
		            // Step 1: Load the MySQL JDBC driver
		            Class.forName("com.mysql.cj.jdbc.Driver");

		            // Step 2: Establish the connection
		            con = DriverManager.getConnection(url, username, password);
		            System.out.println("Connected to the database.");

           pst = con.prepareStatement(
    "SELECT DATE_FORMAT(date, '%Y-%m') AS month, SUM(amount) AS total " +
    "FROM expense GROUP BY month ORDER BY month DESC"
);
 ResultSet rs = pst.executeQuery();
 ResultSetMetaData metaData = rs.getMetaData();
    int cols = metaData.getColumnCount();
    
    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
    jTable1.setModel(model); 

            // Add column names to the table model
            for (int i = 1; i <= cols; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            // Add data to the table model
            while (rs.next()) {
                Object[] rowData = new Object[cols];
                for (int i = 1; i <= cols; i++) {
                    rowData[i - 1] = rs.getString(i);
                }
                model.addRow(rowData);
            }
            //close 
            

jLabel1.setText("Total of All Months: ₹" + String.format("%.2f", totalAllMonths));

            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
           System.out.println(e);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Month", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1110, -1));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jButton1.setText("jButton1");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 50, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MonthlyExpenseReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
