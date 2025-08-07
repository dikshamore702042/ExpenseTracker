
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.*;
import javax.swing.JOptionPane;


public class expensereport extends javax.swing.JFrame {
        Connection con = null;
        PreparedStatement pst = null;
        
        
   
    public expensereport() {
        initComponents();
        
       
      
        
   
        
        
        
        
        
          // Set column names
        
        try {
             String url = "jdbc:mysql://localhost:3306/expensetracking"; // Database URL (use the database you created)
		        String username = "root"; // Default MySQL username
		        String password = ""; // Default MySQL password (empty by default on WAMP)

		        
		            // Step 1: Load the MySQL JDBC driver
		            Class.forName("com.mysql.cj.jdbc.Driver");

		            // Step 2: Establish the connection
		            con = DriverManager.getConnection(url, username, password);
		            System.out.println("Connected to the database.");
                      
                             // Load table and totals
                                reloadTable();
                           //Display report 
    pst = con.prepareStatement("SELECT srno, date, description, amount FROM expense");
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
            
            
        // Display total expense    
        String query1 = "SELECT SUM(amount) AS total_amount FROM expense";
        pst = con.prepareStatement(query1);
        rs = pst.executeQuery();
        
      

        if (rs.next()) {
            double totalAmount = rs.getDouble("total_amount");
            t1.setText(String.format("%.2f", totalAmount)); // display in textbox with 2 decimal places
        }
        
        //close of display expense
        
            String query= "SELECT owner_name from expense";
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            if (rs.next()) {
                String uname = rs.getString("owner_name");
                t2.setText(uname);
            } 

        
            
            
            
		        } catch (Exception e) {
		        	e.printStackTrace();
		        }
            
            
            
            
            

        
    }
        
       
		           
      
    

    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l1 = new javax.swing.JLabel();
        b1 = new javax.swing.JButton();
        l2 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        l3 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Track Expense");
        setAlwaysOnTop(true);
        setBackground(javax.swing.UIManager.getDefaults().getColor("tab_focus_fill_lower"));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(400, 300));
        setMinimumSize(new java.awt.Dimension(800, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        l1.setText("Expense Report");
        getContentPane().add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 170, 40));

        b1.setBackground(new java.awt.Color(196, 78, 78));
        b1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        b1.setForeground(new java.awt.Color(255, 255, 255));
        b1.setText("Back");
        b1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        getContentPane().add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 180, 60));

        l2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        l2.setForeground(new java.awt.Color(255, 51, 51));
        l2.setText("Total Expense");
        getContentPane().add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 550, -1, -1));

        t1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        t1.setForeground(new java.awt.Color(51, 51, 255));
        t1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 540, 200, 60));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setFocusCycleRoot(true);
        jTable1.setFocusTraversalPolicyProvider(true);
        jTable1.setGridColor(new java.awt.Color(102, 255, 102));
        jTable1.setRowHeight(26);
        jTable1.setSelectionForeground(new java.awt.Color(204, 255, 255));
        jTable1.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 1230, 270));

        l3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        l3.setForeground(new java.awt.Color(0, 0, 255));
        l3.setText("Name");
        getContentPane().add(l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        t2.setEditable(false);
        t2.setBackground(new java.awt.Color(255, 255, 255));
        t2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        t2.setForeground(new java.awt.Color(255, 0, 0));
        t2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 230, 40));

        b2.setBackground(new java.awt.Color(196, 78, 78));
        b2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        b2.setForeground(new java.awt.Color(245, 244, 244));
        b2.setText("Update");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        getContentPane().add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 540, 180, 60));

        b3.setBackground(new java.awt.Color(198, 79, 79));
        b3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        b3.setForeground(new java.awt.Color(255, 255, 245));
        b3.setText("Remove");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        getContentPane().add(b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 540, 160, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
            /*    try{
                        String url = "jdbc:mysql://localhost:3306/expensetracking"; // Database URL (use the database you created)
		        String username = "root"; // Default MySQL username
		        String password = ""; // Default MySQL password (empty by default on WAMP)

		        
		            // Step 1: Load the MySQL JDBC driver
		            Class.forName("com.mysql.cj.jdbc.Driver");

		            // Step 2: Establish the connection
		            Connection con = DriverManager.getConnection(url, username, password);
		            System.out.println("Connected to the database.");

*/


// Button: UPDATE selected row

    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to update.");
        return;
    }

    String srno = jTable1.getValueAt(selectedRow, 0).toString();
    String currentDesc = jTable1.getValueAt(selectedRow, 2).toString();
    String currentAmount = jTable1.getValueAt(selectedRow, 3).toString();

    String newDesc = JOptionPane.showInputDialog(this, "Enter new description:", currentDesc);
    String newAmount = JOptionPane.showInputDialog(this, "Enter new amount:", currentAmount);

    if (newDesc == null || newAmount == null || newDesc.trim().isEmpty() || newAmount.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Update cancelled or invalid input.");
        return;
    }

    try {
        String query = "UPDATE expense SET description = ?, amount = ? WHERE srno = ?";
        pst = con.prepareStatement(query);
        pst.setString(1, newDesc);
        pst.setDouble(2, Double.parseDouble(newAmount));
        pst.setInt(3, Integer.parseInt(srno));
        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Record updated successfully!");
        reloadTable(); // Refresh table after update
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error while updating record.");
    }
            /*    }catch(Exception e)
                {
                    System.out.println(e);
                }
*/
// Button: DELETE selected row


    }//GEN-LAST:event_b2ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed

    
   /*
         try{
                        String url = "jdbc:mysql://localhost:3306/expensetracking"; // Database URL (use the database you created)
		        String username = "root"; // Default MySQL username
		        String password = ""; // Default MySQL password (empty by default on WAMP)

		        
		            // Step 1: Load the MySQL JDBC driver
		            Class.forName("com.mysql.cj.jdbc.Driver");

		            // Step 2: Establish the connection
		            Connection con = DriverManager.getConnection(url, username, password);
		            System.out.println("Connected to the database.");
        */
        
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(expensereport.this, "Please select a row to delete.");
            return;
        }

        String srno = jTable1.getValueAt(selectedRow, 0).toString();

        int confirm = JOptionPane.showConfirmDialog(expensereport.this, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        try {
            String query = "DELETE FROM expense WHERE srno = ?";
            pst = con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(srno));
            pst.executeUpdate();

            JOptionPane.showMessageDialog(expensereport.this, "Record deleted successfully!");
            reloadTable(); // Refresh table after delete
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(expensereport.this, "Error while deleting record.");
        }
   /* }catch(Exception e)
                {
                    System.out.println(e);
                }
*/



    }//GEN-LAST:event_b3ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
      new Mdi().setVisible(true);
    }//GEN-LAST:event_b1ActionPerformed
private void reloadTable() {
     try {
        // Clear previous data
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        jTable1.setModel(model);

        String query = "SELECT srno, date, description, amount FROM expense";
        pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int cols = metaData.getColumnCount();

        // Set column names
        for (int i = 1; i <= cols; i++) {
            model.addColumn(metaData.getColumnName(i));
        }

        // Add data rows
        while (rs.next()) {
            Object[] rowData = new Object[cols];
            for (int i = 1; i <= cols; i++) {
                rowData[i - 1] = rs.getString(i);
            }
            model.addRow(rowData);
        }

        // Refresh total amount
        query = "SELECT SUM(amount) AS total_amount FROM expense";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        if (rs.next()) {
            double totalAmount = rs.getDouble("total_amount");
            t1.setText(String.format("%.2f", totalAmount));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

}



    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new expensereport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    // End of variables declaration//GEN-END:variables
}
