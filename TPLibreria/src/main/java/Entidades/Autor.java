package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idAutor;
    @Basic
    private String nombreAut;
    private boolean alta;

      public Autor(int idAutor, String nombreAut, boolean alta) {
        this.idAutor = idAutor;
        this.nombreAut = nombreAut;
        this.alta = alta;
    }

    public Autor() {
    }
    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombreAut() {
        return nombreAut;
    }

    public void setNombreAut(String nombreAut) {
        this.nombreAut = nombreAut;
    }

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

  
}
