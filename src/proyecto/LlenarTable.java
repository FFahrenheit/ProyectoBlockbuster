/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class LlenarTable {

    Vector vPreincipal = new Vector();

    public DefaultTableModel listaPeliculas() {
        Vector cabeceras = new Vector();
        cabeceras.addElement("ID");
        cabeceras.addElement("Titulo");
        cabeceras.addElement("Director");
        cabeceras.addElement("Genero");
        cabeceras.addElement("Clasificacion");
        cabeceras.addElement("Precio");
        cabeceras.addElement("Stock");

        DefaultTableModel modelo_tabla = new DefaultTableModel(cabeceras, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try {
            FileReader fr = new FileReader("Peliculas.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d = br.readLine()) != null) {
                StringTokenizer dato = new StringTokenizer(d, "#");
                Vector x = new Vector();
                while (dato.hasMoreTokens()) {
                    x.addElement(dato.nextToken());
                }
                modelo_tabla.addRow(x);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return modelo_tabla;
    }

    public DefaultTableModel listaPeliculasRentadas(BD bd) {

        Vector cabeceras = new Vector();
        cabeceras.addElement("ID");
        cabeceras.addElement("Titulo");
        cabeceras.addElement("Director");
        cabeceras.addElement("Genero");
        cabeceras.addElement("Clasificacion");
        cabeceras.addElement("Precio");
        cabeceras.addElement("Dia");

        DefaultTableModel modelo_tabla = new DefaultTableModel(cabeceras, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try {
            FileReader fr = new FileReader("Rentadas.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d = br.readLine()) != null) {
                String[] r = d.split("#");
                System.out.println("Usuario: " + r[0]);
                if (Integer.parseInt(r[0]) == bd.usuario.getId()) {
                    System.out.println(r[1]);
                    String[] m = bd.getMovieData(Integer.parseInt(r[1]));
                    Vector x = new Vector();
                    x.addElement(r[1]);
                    for (int i = 0; i < 5; i++) {
                        x.addElement(m[i].toString());
                    }
                    x.addElement(r[2] + "/" + r[3] + "/" + r[4].toString());
                    modelo_tabla.addRow(x);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return modelo_tabla;
    }

    public DefaultTableModel listaPeliculasEditar() {
        Vector cabeceras = new Vector();
        cabeceras.addElement("ID");
        cabeceras.addElement("Titulo");
        cabeceras.addElement("Director");
        cabeceras.addElement("Genero");
        cabeceras.addElement("Clasificacion");
        cabeceras.addElement("Precio");

        DefaultTableModel modelo_tabla = new DefaultTableModel(cabeceras, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try {
            FileReader fr = new FileReader("Peliculas.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d = br.readLine()) != null) {
                StringTokenizer dato = new StringTokenizer(d, "#");
                Vector x = new Vector();
                int cont = 0;

                while (dato.hasMoreTokens()) {
                    String dato2 = dato.nextToken();
                    if (cont == 5) {
                        x.addElement("$" + dato2);
                    } else {
                        x.addElement(dato2);
                    }
                    cont++;
                }
                modelo_tabla.addRow(x);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return modelo_tabla;
    }

    public DefaultTableModel listaPeliculasBuscar() {
        Vector cabeceras = new Vector();
        cabeceras.addElement("ID");
        cabeceras.addElement("Titulo");
        cabeceras.addElement("Director");
        cabeceras.addElement("Genero");
        cabeceras.addElement("Clasificacion");
        cabeceras.addElement("Precio");

        DefaultTableModel modelo_tabla = new DefaultTableModel(cabeceras, 0)
        {
             @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try {
            FileReader fr = new FileReader("Peliculas.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d = br.readLine()) != null) {
                StringTokenizer dato = new StringTokenizer(d, "#");
                Vector x = new Vector();
                int cont = 0;

                while (dato.hasMoreTokens()) {
                    String dato2 = dato.nextToken();
                    if (cont == 5) {
                        x.addElement("$" + dato2);
                    } else if (cont != 6) {
                        x.addElement(dato2);
                    }
                    cont++;
                }
                modelo_tabla.addRow(x);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return modelo_tabla;
    }

    public DefaultTableModel listaPeliculasCompradas(BD bd) {

        Vector cabeceras = new Vector();
        cabeceras.addElement("Titulo");
        cabeceras.addElement("Director");
        cabeceras.addElement("Genero");
        cabeceras.addElement("Clasificacion");
        cabeceras.addElement("Precio");
        cabeceras.addElement("Dia");

        DefaultTableModel modelo_tabla = new DefaultTableModel(cabeceras, 0)
        {
             @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try {
            FileReader fr = new FileReader("Compradas.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d = br.readLine()) != null) {
                String[] r = d.split("#");
                System.out.println("Usuario: " + r[0]);
                if (Integer.parseInt(r[0]) == bd.usuario.getId()) {
                    System.out.println(r[1]);
                    String[] m = bd.getMovieData(Integer.parseInt(r[1]), 3);
                    Vector x = new Vector();
                    for (int i = 0; i < 5; i++) {
                        x.addElement(m[i].toString());
                    }
                    x.addElement(r[2] + "/" + r[3] + "/" + r[4].toString());
                    modelo_tabla.addRow(x);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return modelo_tabla;
    }

}
