/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI_User;

import Singleton.Singleton;
import UI.Helper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author birds
 */
public class ReservationClient extends javax.swing.JFrame {

    /**
     * Creates new form ReservationClient
     */
    public ReservationClient() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "marqueVoiture", "modeleVoiture", "couleurVoiture", "nomClient", "dateDebut", "dateFin", "valide"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 810, 110));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, 120, -1));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Supprimer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 140, -1));

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 25, -1));

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Modifier");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 120, -1));

        jLabel2.setText("Modifier dateDebut");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 120, 25));

        jLabel3.setText("Modifier dateFin");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 140, 25));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 120, -1));
        getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 140, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void loadTableData() {
    int idUser = AuthClient.idSession; 
    Connection conn = Singleton.getconn();
    String sql = "SELECT * FROM `reservation` WHERE Client_id = '" + idUser + "'" ;
    DefaultTableModel jt = null;
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        jt = Helper.buildTableModel(rs);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    jTable1.setModel(jt);
}
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jTable1.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            int selectedRow = jTable1.getSelectedRow();
            if (selectedRow != -1) {
                // Get the values from the selected row

                Object value6 = jTable1.getValueAt(selectedRow, 5);
                // ...

                // Populate the text fields with the selected values
              

                // ...
            }
        }
    });
        int idUser = AuthClient.idSession; 
        Connection conn = Singleton.getconn();
        String sql = "SELECT * FROM `reservation` WHERE Client_id = '" + idUser + "'" ;
        DefaultTableModel jt =null ;
        try{
            PreparedStatement ps =conn.prepareStatement(sql) ;
            ResultSet rs =ps.executeQuery() ;
            jt= Helper.buildTableModel(rs) ;

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        jTable1.setModel(jt);
        loadTableData();
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.setVisible(false);
MenuClient c= new MenuClient();
c.setVisible(true);// TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Connection conn =Singleton.getconn(); 
       int id =(int) jTable1.getValueAt(jTable1.getSelectedRow(), 0) ;
        String sql = "DELETE from reservation where id='"+id+"'" ; 
        try{
            PreparedStatement  ps = conn.prepareStatement(sql) ;
            ps.executeUpdate() ;
             JFrame jf = new JFrame();
            JOptionPane jop = new JOptionPane();
            jop.showMessageDialog(jf, "Element Supprimer", "Supprimer", JOptionPane.PLAIN_MESSAGE);
            jButton3ActionPerformed(evt);
        }catch(SQLException ex){
             ex.printStackTrace();
        }      // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int idUser = AuthClient.idSession; 
        Connection conn = Singleton.getconn();
        String sql = "SELECT * FROM `reservation` WHERE Client_id = '" + idUser + "'" ;
        DefaultTableModel jt =null ;
        try{
            PreparedStatement ps =conn.prepareStatement(sql) ;
            ResultSet rs =ps.executeQuery() ;
            jt= Helper.buildTableModel(rs) ;

        }catch(SQLException ex){
            ex.printStackTrace();
        }
        jTable1.setModel(jt);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
Connection conn = Singleton.getconn();
int id = (int) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");
java.util.Date selectedDateDebut = jDateChooser2.getDate();
java.util.Date selectedDateFin = jDateChooser1.getDate();
java.sql.Date theDate = new java.sql.Date(selectedDateDebut.getTime());
java.sql.Date theDate2 = new java.sql.Date(selectedDateFin.getTime());
String sql = "UPDATE reservation SET dateDebut=?, dateFin=? WHERE id=?";
try {
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setDate(1, theDate);
    ps.setDate(2, theDate2);
    ps.setInt(3, id);
    ps.executeUpdate();

    JFrame jf = new JFrame();
    JOptionPane jop = new JOptionPane();
    jop.showMessageDialog(jf, "Élément modifié", "Modifier", JOptionPane.PLAIN_MESSAGE);

    // Mettez à jour à nouveau la table avec les données modifiées
    loadTableData();
} catch (SQLException ex) {
    ex.printStackTrace();
}

    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(ReservationClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservationClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservationClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservationClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
