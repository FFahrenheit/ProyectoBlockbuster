/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Admin extends javax.swing.JFrame {

    BD bd;
    
    public Admin(BD f) {
        bd=f;
        initComponents();
        setLocationRelativeTo(null); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        agregarAdminButton = new javax.swing.JButton();
        editarAdminButton = new javax.swing.JButton();
        borrarAdminButton = new javax.swing.JButton();
        borrarCerrarSesion = new javax.swing.JButton();
        fondoAdmin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregarAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarAdminButtonActionPerformed(evt);
            }
        });
        getContentPane().add(agregarAdminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 170, 50));

        editarAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarAdminButtonActionPerformed(evt);
            }
        });
        getContentPane().add(editarAdminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 170, 50));

        borrarAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarAdminButtonActionPerformed(evt);
            }
        });
        getContentPane().add(borrarAdminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 170, 50));

        borrarCerrarSesion.setText("Cerrar Sesion");
        borrarCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarCerrarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(borrarCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 150, 30));

        fondoAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/Admin.png"))); // NOI18N
        getContentPane().add(fondoAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarAdminButtonActionPerformed
        Nuevo ventana = new Nuevo(bd);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_agregarAdminButtonActionPerformed

    private void borrarCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarCerrarSesionActionPerformed
        Login ventana = new Login(bd);
        ventana.setVisible(true);
        this.dispose();
        JOptionPane.showMessageDialog(this, "Sesion terminada");
        
    }//GEN-LAST:event_borrarCerrarSesionActionPerformed

    private void editarAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarAdminButtonActionPerformed
        ListaEditar ventana = new ListaEditar();
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_editarAdminButtonActionPerformed

    private void borrarAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarAdminButtonActionPerformed
        JOptionPane.showMessageDialog(this, "Proximamente");
    }//GEN-LAST:event_borrarAdminButtonActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Admin(bd).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarAdminButton;
    private javax.swing.JButton borrarAdminButton;
    private javax.swing.JButton borrarCerrarSesion;
    private javax.swing.JButton editarAdminButton;
    private javax.swing.JLabel fondoAdmin;
    // End of variables declaration//GEN-END:variables
}
