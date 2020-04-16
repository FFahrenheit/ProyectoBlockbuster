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
public class Menu extends javax.swing.JFrame {

   BD bd;
    public Menu(BD f) {
        bd=f;
        initComponents();
        setLocationRelativeTo(null);
        int usuario = bd.usuario.getId();
        System.out.println(""+usuario);
        bd.socios.forEach(s->{
            System.out.println(""+s.getId_socio());
                if(bd.usuario.getId()==s.getId_socio())
                {
                    uneteButton.setVisible(false);
                }
            });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uneteButton = new javax.swing.JButton();
        misPeliculasMenuButton = new javax.swing.JButton();
        buscarMenuButton = new javax.swing.JButton();
        misPeliculasCompradas = new javax.swing.JButton();
        buttonCerrarSesion = new javax.swing.JButton();
        miembroLabel = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        uneteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/Unete Button.png"))); // NOI18N
        uneteButton.setContentAreaFilled(false);
        uneteButton.setMaximumSize(new java.awt.Dimension(180, 90));
        uneteButton.setMinimumSize(new java.awt.Dimension(180, 90));
        uneteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uneteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(uneteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 170, 80));

        misPeliculasMenuButton.setText("Rentadas");
        misPeliculasMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                misPeliculasMenuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(misPeliculasMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, 130, 60));

        buscarMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarMenuButtonActionPerformed(evt);
            }
        });
        getContentPane().add(buscarMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 130, 60));

        misPeliculasCompradas.setText("Compradas");
        misPeliculasCompradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                misPeliculasCompradasActionPerformed(evt);
            }
        });
        getContentPane().add(misPeliculasCompradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 120, 60));

        buttonCerrarSesion.setText("Cerrar Sesion");
        buttonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCerrarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(buttonCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 140, 30));

        miembroLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/Ya eres miembro.png"))); // NOI18N
        getContentPane().add(miembroLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 70));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/Menu.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void misPeliculasMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_misPeliculasMenuButtonActionPerformed
//        JOptionPane.showMessageDialog(this, "Entro aqui");
        Rentadas rentadas = new Rentadas(bd);
        rentadas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_misPeliculasMenuButtonActionPerformed

    private void buttonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCerrarSesionActionPerformed
    
        Login ventana = new Login(bd);
        ventana.setVisible(true);
        this.dispose();
        JOptionPane.showMessageDialog(this, "Sesion terminada");
        
        
    }//GEN-LAST:event_buttonCerrarSesionActionPerformed

    private void buscarMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarMenuButtonActionPerformed
        Buscar ventana = new Buscar(bd);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buscarMenuButtonActionPerformed

    private void uneteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uneteButtonActionPerformed
        
        int usuario = bd.usuario.getId();
        int socio = bd.socios.size();
        Socio socio1 = new Socio(usuario, socio);
        
        bd.socios.add(socio1);
        bd.GuardarSocios();
        JOptionPane.showMessageDialog(this, "FELICIDADES, YA ERES MIEMBRO DE BLOCKBUSTER");
        uneteButton.setVisible(false);
        
        
        
        
    }//GEN-LAST:event_uneteButtonActionPerformed

    private void misPeliculasCompradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_misPeliculasCompradasActionPerformed
        Compradas compradas = new Compradas(bd);
        compradas.setVisible(true);
        this.dispose();    }//GEN-LAST:event_misPeliculasCompradasActionPerformed

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
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Menu(bd).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarMenuButton;
    private javax.swing.JButton buttonCerrarSesion;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel miembroLabel;
    private javax.swing.JButton misPeliculasCompradas;
    private javax.swing.JButton misPeliculasMenuButton;
    private javax.swing.JButton uneteButton;
    // End of variables declaration//GEN-END:variables
}
