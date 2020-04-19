package proyecto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BD {

    public ArrayList<Usuario> usuarios = new ArrayList<>();
    public ArrayList<Pelicula> peliculas = new ArrayList<>();
    public ArrayList<Socio> socios = new ArrayList<>();

    public Usuario usuario;

    private void Mostrar() {
        usuarios.forEach(u
                -> {
            System.out.println(u.toString());
        }
        );
    }

    public BD() {
        LeerUsuarios();
        Mostrar();
        GuardarUsuarios();
        LeerSocios();
        LeerPeliculas();
        System.out.println("" + socios.size());
    }

    public void returnMovie(Integer movie, Integer user, String fecha) {
        try {
            String linea;
            ArrayList<Renta> rentas = new ArrayList<>();
            BufferedReader lector = new BufferedReader(new FileReader("Rentadas.txt"));
            while ((linea = lector.readLine()) != null) {
                String arg[] = linea.split("#");
                Renta r = new Renta(Integer.parseInt(arg[0]), Integer.parseInt(arg[1]), arg[2] + "/" + arg[3] + "/" + arg[4]);
                rentas.add(r);
            }

            File datos = new File("Rentadas.txt");
            FileWriter fw = new FileWriter(datos, false);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("");
            boolean already = false;

            //datos.createNewFile();
            for(int i=0; i<rentas.size();i++) {
                Renta r = rentas.get(i);
                System.out.println(r.toString());
                if (already || !r.is(user,movie,fecha)){
                    System.out.println("Entro aquiiiii");
                    try {
                        r.save();
                    } catch (IOException ex) {
                        Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    already = true;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void LeerUsuarios() {
        try {
            String linea;
            BufferedReader lector = new BufferedReader(new FileReader("Usuarios.txt"));
            while ((linea = lector.readLine()) != null) {

                String arg[] = linea.split("#");
                Usuario us = new Usuario(Integer.parseInt(arg[0]), arg[1], arg[2], arg[3], Integer.parseInt(arg[4]), arg[5], arg[6], arg[7]);
                usuarios.add(us);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Blockbuster.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Blockbuster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void GuardarUsuarios() {
        try {
            File datos = new File("Usuarios.txt");
            FileWriter fw = new FileWriter(datos, false);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("");
            //datos.createNewFile();
            usuarios.forEach(u -> {
                System.out.println(u.toString());
                try {
                    u.save();
                } catch (IOException ex) {
                    Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            );
        } catch (IOException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void LeerPeliculas() {
        try {
            String linea;
            BufferedReader lector = new BufferedReader(new FileReader("Peliculas.txt"));
            while ((linea = lector.readLine()) != null) {
                String arg[] = linea.split("#");
                Pelicula pel = new Pelicula(Integer.parseInt(arg[0]), arg[1], arg[2], arg[3], arg[4], Integer.parseInt(arg[5]), Integer.parseInt(arg[6]));
                peliculas.add(pel);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Blockbuster.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Blockbuster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void LeerSocios() {
        try {
            String linea;
            BufferedReader lector = new BufferedReader(new FileReader("Socios.txt"));
            while ((linea = lector.readLine()) != null) {
                String arg[] = linea.split("#");
                Socio soc = new Socio(Integer.parseInt(arg[0]), Integer.parseInt(arg[1]), Integer.parseInt(arg[2]), Integer.parseInt(arg[3]), Integer.parseInt(arg[4]));
                System.out.println(linea);
                socios.add(soc);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Blockbuster.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Blockbuster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void GuardarSocios() {
        try {
            File datos = new File("Socios.txt");
            FileWriter fw = new FileWriter(datos, false);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("");
            //datos.createNewFile();
            socios.forEach(u -> {
                System.out.println(u.toString());
                try {
                    u.save();
                } catch (IOException ex) {
                    Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            );
        } catch (IOException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void GuardarPeliculas() {
        try {
            File datos = new File("Peliculas.txt");
            FileWriter fw = new FileWriter(datos, false);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("");
            //datos.createNewFile();
            peliculas.forEach(u -> {
                System.out.println(u.toString());
                try {
                    u.save();
                } catch (IOException ex) {
                    Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            );
        } catch (IOException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario Login(String user, String pass) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario us = usuarios.get(i);
            if (us.getUser().equals(user) && us.getPass().equals(pass)) {
                this.usuario = us;
                return us;
            }
        }
        return null;
    }

    public String[] getMovieData(int id) {
        return getMovieData(id, 1);
    }

    public String[] getMovieData(int id, int mult) {
        String[] data = new String[5];
        peliculas.forEach(m
                -> {
            if (m.getId() == id) {
                data[0] = m.getTitulo();
                data[1] = m.getDirector();
                data[2] = m.getGenero();
                data[3] = m.getClasificacion();
                data[4] = "$" + String.valueOf((m.getPrecio() * mult)).toString();
            }
        });
        return data;
    }

    public boolean isMember(int idUser) {
        for (int i = 0; i < socios.size(); i++) {
            if (socios.get(i).getId_user() == idUser) {
                return true;
            }
        }
        return false;
    }

    public int getStock(int id) {
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getId() == id) {
                return peliculas.get(i).getStock();
            }
        }
        return 0;
    }

    public boolean lessStock(int id) {
        return alterateStock(id, -1);
    }

    private boolean alterateStock(int id, int n) {
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getId() == id) {
                peliculas.get(i).stock += n;
                this.GuardarPeliculas();
                return true;
            }
        }
        return false;
    }

    public boolean moreStock(int id) {
        return alterateStock(id, 1);
    }

    public Pelicula getPelicula(int id) {
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getId() == id) {
                return peliculas.get(i);
            }
        }
        return null;
    }
}
