package Parte1.Concurso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Participante {
    private String nombre;
    private int dni;
    private int puntos;
    //private static final int PUNTOS = 10;
    private List<Concurso> concursos; //asi el participante almacena "sabe" en que curso esta


    public Participante(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.puntos = 0;
        this.concursos = new ArrayList<>();
    }

    //se le suma puntos
    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }

    //y se recuperan los mismos
    public int sumarPuntosPrimerDia(){
        return this.puntos; // obtengo los puntos sin un get aunque es lo mismo que un get¿? hay otra manera?
    }

    public void agregarConcurso(Concurso concurso){
        this.concursos.add(concurso);
    }

    //get --------------------------------
    public int getPuntos() {
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void getDni(int dni){
        this.dni = dni;
    }
    //--------------------------------------------

    //set
    public void  setPuntos(int puntos) {
        this.puntos = puntos;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDni(int dni){
        this.dni = dni;
    }
    /// //////////////////////////

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Participante)) return false;
        Participante otro = (Participante) o;
        return this.dni == otro.dni;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(dni);
    }
}
