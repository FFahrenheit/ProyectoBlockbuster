/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ListaEditar extends javax.swing.JFrame {

    
        LlenarTable llenar = new LlenarTable();
        DefaultTableModel modelo_tabla;
        Vector vCabeceras = new Vector();
    
    public ListaEditar() {
        initComponents();
        setLocationRelativeTo(null); 
        
        vCabeceras.addElement("ID");
        vCabeceras.addElement("Titulo");
        vCabeceras.addElement("Director");
        vCabeceras.addElement("Genero");
        vCabeceras.addElement("Clasificacion");
        vCabeceras.addElement("Precio");
        vCabeceras.addElement("Srock");
        modelo_tabla = new DefaultTableModel(vCabeceras,0);
        tableEditar.setModel(modelo_tabla);
        tableEditar.setModel(llenar.listaPeliculas());
                
                
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonRegresarEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEditar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonRegresarEditar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButtonRegresarEditar.setText("REGRESAR");
        ButtonRegresarEditar.setToolTipText("");
        ButtonRegresarEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRegresarEditarActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonRegresarEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 443, 150, 40));

        tableEditar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableEditar);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 720, 270));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/Lista.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonRegresarEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRegresarEditarActionPerformed
//        Admin ventana = new Admin(bd);
//        ventana.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_ButtonRegresarEditarActionPerformed

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
            java.util.logging.Logger.getLogger(ListaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaEditar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonRegresarEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableEditar;
    // End of variables declaration//GEN-END:variables
}
