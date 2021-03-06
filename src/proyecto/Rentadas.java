/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Rentadas extends javax.swing.JFrame {

    LlenarTable llenar = new LlenarTable();
    DefaultTableModel modelo_tabla;
    Vector vCabeceras = new Vector();

    Integer seleccionado = null;
    String fecha;
    BD bd;

    public Rentadas(BD f) {
        bd = f;
        initComponents();
        setLocationRelativeTo(null);
        vCabeceras.addElement("ID");
        vCabeceras.addElement("Titulo");
        vCabeceras.addElement("Director");
        vCabeceras.addElement("Genero");
        vCabeceras.addElement("Clasificacion");
        vCabeceras.addElement("Precio");
        vCabeceras.addElement("Dia");

        modelo_tabla = new DefaultTableModel(vCabeceras, 0);
        tableBuscar.setModel(modelo_tabla);
        tableBuscar.setModel(llenar.listaPeliculasRentadas(bd));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonRegresarBuscar = new javax.swing.JButton();
        txtPelicula = new javax.swing.JTextField();
        ButtonRegresarBuscar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBuscar = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonRegresarBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButtonRegresarBuscar.setText("REGRESAR");
        ButtonRegresarBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRegresarBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonRegresarBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 150, 40));

        txtPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPeliculaActionPerformed(evt);
            }
        });
        getContentPane().add(txtPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 170, 40));

        ButtonRegresarBuscar1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButtonRegresarBuscar1.setText("ENTREGAR");
        ButtonRegresarBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRegresarBuscar1ActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonRegresarBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, 150, 40));

        tableBuscar.setModel(new javax.swing.table.DefaultTableModel(
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
        tableBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBuscarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableBuscar);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 790, 280));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto/Lista.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonRegresarBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRegresarBuscarActionPerformed
        Menu ventana = new Menu(bd);
        ventana.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ButtonRegresarBuscarActionPerformed

    private void tableBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBuscarMouseClicked

        int seleccion = tableBuscar.rowAtPoint(evt.getPoint());
        txtPelicula.setText(String.valueOf(tableBuscar.getValueAt(seleccion, 1)));
        seleccionado = Integer.parseInt(tableBuscar.getValueAt(seleccion, 0).toString());
        fecha = tableBuscar.getValueAt(seleccion, 6).toString();
    }//GEN-LAST:event_tableBuscarMouseClicked

    private void txtPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPeliculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPeliculaActionPerformed

    private void ButtonRegresarBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRegresarBuscar1ActionPerformed
        if (seleccionado != null) {
            int input = JOptionPane.showConfirmDialog(null, "Desea regresar esta pelicula?");
            System.out.println("" + input);
            if (input == 0) {
                bd.returnMovie(seleccionado, bd.usuario.getId(),fecha);
                JOptionPane.showMessageDialog(this,
                        "Pelicula regresada");
                bd.moreStock(seleccionado);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Seleccione una pelicula",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }    }//GEN-LAST:event_ButtonRegresarBuscar1ActionPerformed

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
            java.util.logging.Logger.getLogger(Rentadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rentadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rentadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rentadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Buscar().setVisible(true);
//            }
//        });
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Buscar().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonRegresarBuscar;
    private javax.swing.JButton ButtonRegresarBuscar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBuscar;
    private javax.swing.JTextField txtPelicula;
    // End of variables declaration//GEN-END:variables
}
