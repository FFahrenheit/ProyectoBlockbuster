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

public class Editar extends javax.swing.JFrame {

    LlenarTable llenar = new LlenarTable();
    DefaultTableModel modelo_tabla;
    Vector vCabeceras = new Vector();

    Integer seleccionado = null;
    BD bd;

    public Editar(BD f) {
        bd = f;
        initComponents();
        setLocationRelativeTo(null);

        vCabeceras.addElement("ID");
        vCabeceras.addElement("Titulo");
        vCabeceras.addElement("Director");
        vCabeceras.addElement("Genero");
        vCabeceras.addElement("Clasificacion");
        vCabeceras.addElement("Precio");
        vCabeceras.addElement("Stock");
        modelo_tabla = new DefaultTableModel(vCabeceras, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableBuscar.setModel(modelo_tabla );
        tableBuscar.setModel(llenar.listaPeliculasEditar());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonRegresarBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBuscar = new javax.swing.JTable();
        buttonComprar = new javax.swing.JButton();
        txtPelicula = new javax.swing.JTextField();
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
        getContentPane().add(ButtonRegresarBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 150, 40));

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

        buttonComprar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonComprar.setText("EDITAR");
        buttonComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonComprarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 430, 140, 40));

        txtPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPeliculaActionPerformed(evt);
            }
        });
        getContentPane().add(txtPelicula, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 140, 40));

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

    }//GEN-LAST:event_tableBuscarMouseClicked

    private void buttonComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonComprarActionPerformed
        if (seleccionado != null) {
            if (bd.getStock(seleccionado) <= 0) {
                JOptionPane.showMessageDialog(this,
                        "No hay stock suficiente",
                        "Lo sentimos",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!bd.isMember(bd.usuario.getId())) {
                JOptionPane.showMessageDialog(this,
                        "Tiene que ser miembro para comprar peliculas",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            int input = JOptionPane.showConfirmDialog(null, "Desea comprar esta pelicula?");
            System.out.println("" + input);
            if (input == 0) {

                FileWriter fw = null;
                try {
                    Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016 
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(today); // don't forget this if date is arbitrary e.g. 01-01-2014 
                    Integer day = cal.get(Calendar.DAY_OF_MONTH); // 17 
                    Integer month = cal.get(Calendar.MONTH) + 1; // 5 
                    Integer year = cal.get(Calendar.YEAR); // 2016

                    boolean res = false;
                    File datos = new File("Compradas.txt");
                    fw = new FileWriter(datos, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    String cad = bd.usuario.getId() + "#" + seleccionado.toString() + "#" + day.toString() + "#" + month.toString() + "#" + year.toString();
                    bw.write(cad);
                    bw.newLine();
                    res = true;
                    bw.close();
                    fw.close();
                    JOptionPane.showMessageDialog(this,
                            "Pelicula comprada");
                    bd.lessStock(seleccionado);
                } catch (IOException ex) {
                    Logger.getLogger(Editar.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        fw.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Editar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Seleccione una pelicula",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_buttonComprarActionPerformed

    private void txtPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPeliculaActionPerformed
    }//GEN-LAST:event_txtPeliculaActionPerformed

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
            java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton buttonComprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBuscar;
    private javax.swing.JTextField txtPelicula;
    // End of variables declaration//GEN-END:variables
}
