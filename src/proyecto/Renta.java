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

/**
 *
 * @author ivan_
 */
public class Renta {

    Integer usuario;
    Integer pelicula;
    String fecha;

    public Renta(Integer u, Integer p, String f) {
        usuario = u;
        pelicula = p;
        fecha = f;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public Integer getPelicula() {
        return pelicula;
    }

    public void setPelicula(Integer pelicula) {
        this.pelicula = pelicula;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public boolean is(int us, int pel, String f)
    {
        System.out.println(us+" "+pel+" "+f);
        return usuario == us && pelicula == pel && fecha.equals(f);
    }

    public boolean save() throws IOException {
        boolean res = false;
        File datos = new File("Rentadas.txt");
        FileWriter fw = new FileWriter(datos, true);
        BufferedWriter bw = new BufferedWriter(fw);
        String[] date = fecha.split("/");
        String cad = usuario.toString()+"#"+pelicula.toString()+"#"+date[0]+"#"+date[1]+"#"+date[2];
        bw.write(cad);
        bw.newLine();
        res = true;
        bw.close();
        fw.close();
        return res;
    }
}
