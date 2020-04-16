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
import java.util.Calendar;
import java.util.Date;

public class Socio {
    private int id_user;
    private int id_socio;
    private int day;
    private int month;
    private int year;

    public Socio(int usuario, int socio) {
        id_user= usuario;
        id_socio=socio;
        Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016 
        Calendar cal = Calendar.getInstance(); 
        cal.setTime(today); // don't forget this if date is arbitrary e.g. 01-01-2014 
        this.day = cal.get(Calendar.DAY_OF_MONTH); // 17 
        this.month = cal.get(Calendar.MONTH) + 1; // 5 
        this.year = cal.get(Calendar.YEAR); // 2016
    }

    public Socio(int id_user, int id_socio, int day, int month, int year) {
        this.id_user = id_user;
        this.id_socio = id_socio;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_socio() {
        return id_socio;
    }

    public void setId_socio(int id_socio) {
        this.id_socio = id_socio;
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
        return "Socio{" + "id_user=" + id_user + ", id_socio=" + id_socio + ", day=" + day + ", month=" + month + ", year=" + year + '}';
    }
    
    public boolean save() throws IOException{
        boolean res = false;
        File datos = new File("Socios.txt");
        FileWriter fw = new FileWriter(datos, true);
        BufferedWriter bw = new BufferedWriter(fw);
        String cad = id_user+"#"+id_socio+"#"+day+"#"+month+"#"+year;
        
        bw.write(cad);
        bw.newLine();
        res=true;
        bw.close();
        fw.close();
        return res;
    }   
    
}
