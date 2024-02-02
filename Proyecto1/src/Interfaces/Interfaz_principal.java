/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.FunctionTXT;

/**
 *
 * @author georg
 */
public class Interfaz_principal extends javax.swing.JFrame {

    /**
     * Creates new form Prueba
     */
    public Interfaz_principal() {
        initComponents();
        this.setLocationRelativeTo(null);
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Inicio = new javax.swing.JTabbedPane();
        Dashboard = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DisneyChanel = new javax.swing.JPanel();
        CartoonNetwork = new javax.swing.JPanel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        WorkStatus = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, -1));

        Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Dashboard.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton1.setText("Guardar");
        Dashboard.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, -1, -1));
        Dashboard.add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));
        Dashboard.add(jSpinner3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        jLabel1.setText("Duración del día (s)");
        Dashboard.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel3.setText("DeadLine");
        Dashboard.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        Inicio.addTab("Inicio", Dashboard);

        javax.swing.GroupLayout DisneyChanelLayout = new javax.swing.GroupLayout(DisneyChanel);
        DisneyChanel.setLayout(DisneyChanelLayout);
        DisneyChanelLayout.setHorizontalGroup(
            DisneyChanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        DisneyChanelLayout.setVerticalGroup(
            DisneyChanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        Inicio.addTab("Disney Chanel", DisneyChanel);

        CartoonNetwork.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        CartoonNetwork.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        jLabel2.setText("Project Manager");
        CartoonNetwork.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 109, 140, -1));

        WorkStatus.setText("jTextField1");
        WorkStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WorkStatusActionPerformed(evt);
            }
        });
        CartoonNetwork.add(WorkStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, -1));

        jLabel4.setText("WorkStatus");
        CartoonNetwork.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        Inicio.addTab("Cartoon Network", CartoonNetwork);

        getContentPane().add(Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void WorkStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WorkStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WorkStatusActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CartoonNetwork;
    private javax.swing.JPanel Dashboard;
    private javax.swing.JPanel DisneyChanel;
    private javax.swing.JTabbedPane Inicio;
    private javax.swing.JTextField WorkStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    // End of variables declaration//GEN-END:variables
}
