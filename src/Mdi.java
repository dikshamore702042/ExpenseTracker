
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Mdi extends javax.swing.JFrame {

    
   
    
    public Mdi() {
        initComponents();
        
        
        // database connection
         String url = "jdbc:mysql://localhost:3306/expensetracking"; // Database URL (use the database you created)
		        String username = "root"; // Default MySQL username
		        String password = ""; // Default MySQL password (empty by default on WAMP)

		        try {
		            // Step 1: Load the MySQL JDBC driver
		            Class.forName("com.mysql.cj.jdbc.Driver");

		            // Step 2: Establish the connection
		            Connection con = DriverManager.getConnection(url, username, password);
		            System.out.println("Connected to the database.");
        //close of connection
                            
        String query = "SELECT SUM(amount) AS total_amount FROM expense";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        
        String query1 = "SELECT income FROM user";
         pst = con.prepareStatement(query1);
        ResultSet rs1 = pst.executeQuery();
      

        if (rs.next()) {
            double totalAmount = rs.getDouble("total_amount");
            t2.setText(String.format("%.2f", totalAmount)); // display in textbox with 2 decimal places
            
        
        if (rs1.next()) {
            double income = rs1.getDouble("income");
            t1.setText(String.format("%.2f", income)); // display in textbox with 2 decimal places
        
        }
          // Category-wise Expense
        String categoryQuery = "SELECT description, SUM(amount) AS category_total FROM expense " +
               "WHERE description IN ('Grocery', 'Bills', 'Shopping', 'Taxes', 'Insurance') " +
               "GROUP BY description";
        PreparedStatement categoryStmt = con.prepareStatement(categoryQuery);
        ResultSet categoryRs = categoryStmt.executeQuery();

        double groceryAmount = 0, billsAmount = 0, shoppingAmount = 0,TaxesAmount = 0,InsuranceAmount = 0;

        while (categoryRs.next()) {
            String desc = categoryRs.getString("description");
            double amt = categoryRs.getDouble("category_total");
            int progress = totalAmount > 0 ? (int) ((amt/ totalAmount) * 100) : 0;

            if ("grocery".equals(desc)) {
                 groceryAmount = amt;
           } else if ("Bills".equals (desc)) {
                 billsAmount = amt;
           } else if ("shopping".equals(desc)) {
                 shoppingAmount = amt;
           }else if ("Taxes".equals(desc)) {
                 TaxesAmount = amt;
           }else if ("Insurance".equals(desc)) {
                 InsuranceAmount = amt;
           }
            
        }
         double totalExpense = 0;
        // Avoid division by zero
        //f (totalExpense == 0) totalExpense = 1;

        //Set progress bars
         int percent = (int)((groceryAmount / totalAmount) * 100);
        jProgressBar6.setValue(percent);
         int percent2 = (int)((billsAmount / totalAmount) * 100);
        jProgressBar2.setValue(percent2);
        int percent3 = (int)((shoppingAmount / totalAmount) * 100);
        jProgressBar3.setValue(percent3);
        int percent4 = (int)((TaxesAmount / totalAmount) * 100);
        jProgressBar4.setValue(percent4);
        int percent5 = (int)((InsuranceAmount / totalAmount) * 100);
        jProgressBar5.setValue(percent5);

        // Display exact amount as text on progress bars
        jProgressBar6.setStringPainted(true);
      //  jProgressBar1.setValue(progress);
        jLabel10.setText("₹" + String.format("%.2f", groceryAmount));

        jProgressBar2.setStringPainted(true);
        jLabel13.setText("₹" + String.format("%.2f", billsAmount));

        jProgressBar3.setStringPainted(true);
        jLabel11.setText("₹" + String.format("%.2f", shoppingAmount));
        
        jProgressBar4.setStringPainted(true);
        jLabel14.setText("₹" + String.format("%.2f", TaxesAmount));
        
        jProgressBar5.setStringPainted(true);
        jLabel12.setText("₹" + String.format("%.2f", InsuranceAmount));
        }
        
        
        /* 2. Get category-wise expenses
              pst = con.prepareStatement(categoryQuery);
                 rs = pst2.executeQuery() {

                while (rs.next()) {
                    String category = rs.getString("description");
                    double categoryTotal = rs.getDouble("category_total");

                    int percentage = totalExpense == 0 ? 0 : (int) ((categoryTotal / totalExpense) * 100);

                    labels.get(category).setText(category + ": ₹" + String.format("%.2f", categoryTotal));
                    jLabel10.get(category).setValue(percentage);
                }
            }

        */
		        } catch (Exception e) {
		        	e.printStackTrace();
		        }
        
      
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        b3 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jProgressBar4 = new javax.swing.JProgressBar();
        jProgressBar5 = new javax.swing.JProgressBar();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jProgressBar6 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));
        setFocusable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Track Your Expense");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 560, 240, 90));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Income");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Total Expense");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        b3.setBackground(new java.awt.Color(0, 102, 102));
        b3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        b3.setForeground(new java.awt.Color(255, 255, 255));
        b3.setText("Expense Report");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        jPanel2.add(b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 310, 60));

        b5.setBackground(new java.awt.Color(0, 102, 102));
        b5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        b5.setForeground(new java.awt.Color(255, 255, 255));
        b5.setText("Logout");
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });
        jPanel2.add(b5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 310, 60));

        b4.setBackground(new java.awt.Color(0, 102, 102));
        b4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        b4.setForeground(new java.awt.Color(255, 255, 255));
        b4.setText("Add Expense");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });
        jPanel2.add(b4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 310, 60));

        t1.setEditable(false);
        t1.setBackground(new java.awt.Color(255, 255, 255));
        t1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        t1.setForeground(new java.awt.Color(51, 51, 255));
        t1.setBorder(null);
        t1.setEnabled(false);
        jPanel2.add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 170, 50));

        t2.setEditable(false);
        t2.setBackground(new java.awt.Color(255, 255, 255));
        t2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        t2.setForeground(new java.awt.Color(51, 51, 255));
        t2.setToolTipText("");
        t2.setBorder(null);
        t2.setEnabled(false);
        jPanel2.add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 170, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Categories");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        jLabel5.setText("Grocery");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        jLabel6.setText("Bills");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        jPanel3.add(jProgressBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 360, 20));

        jLabel7.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        jLabel7.setText("insurance");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));
        jPanel3.add(jProgressBar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 360, 20));
        jPanel3.add(jProgressBar4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 360, 20));
        jPanel3.add(jProgressBar5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 360, 20));

        jLabel8.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        jLabel8.setText("Shopping");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        jLabel9.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        jLabel9.setText("Taxes");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 255));
        jLabel10.setText("0");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 255, 204));
        jLabel11.setText("0");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 51, 153));
        jLabel12.setText("0");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 255, 0));
        jLabel13.setText("0");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 204, 204));
        jLabel14.setText("0");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, -1, -1));
        jPanel3.add(jProgressBar6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 360, 20));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 430, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        // TODO add your handling code here:
         new Home().setVisible(true);
    }//GEN-LAST:event_b4ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
       new expensereport().setVisible(true);
    }//GEN-LAST:event_b3ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        new Login().setVisible(true);
    }//GEN-LAST:event_b5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mdi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mdi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JProgressBar jProgressBar5;
    private javax.swing.JProgressBar jProgressBar6;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    // End of variables declaration//GEN-END:variables
}
