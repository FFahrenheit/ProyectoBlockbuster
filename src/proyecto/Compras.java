/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Compras {
    private int id_usuario=0;
    private int id_pelicula=0;
    private int day;
    private int month;
    private int year;

    public Compras() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString() {
        return "Compras{" + "id_usuario=" + id_usuario + ", id_pelicula=" + id_pelicula + '}';
    }
    
    public boolean save() throws IOException{
        boolean res = false;
        File datos = new File("Compras.txt");
        FileWriter fw = new FileWriter(datos, true);
        BufferedWriter bw = new BufferedWriter(fw);
        String cad = id_usuario+"#"+id_pelicula+"#"+day+"#"+month+"#"+year;

        bw.write(cad);
        bw.newLine();
        res=true;
        bw.close();
        fw.close();
        return res;
    }
    
}
