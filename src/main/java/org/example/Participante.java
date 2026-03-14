package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Participante {
    private String nombre;
    private int dni;
    private int puntos;
    private static final int PUNTOS = 10;
    private List<Concurso> concursos;


    //constructor vacio carga un ""participante"" defaul ponele
    public Participante( ) {
        this.nombre = "Participante";
        this.dni = 0;
        this.puntos = 0;
        this.concursos = new ArrayList<>();
    }

    public Participante(String nombre, int dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.puntos = 0;
        this.concursos = new ArrayList<>();
    }

    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int puntosParticipante(){
        return this.puntos; // obtengo los puntos sin un get aunque es lo mismo que un get¿? hay otra manera?
    }

    public void inscribirseA(Concurso c, LocalDate fecha){
        //primero pregunto si NO esta activo antes de anotarme a algo sjadk
        if (!c.estaActivo(fecha)){
            throw new RuntimeException("El concurso no esta activo, pruebe en otro momento");
        }
        //si ignoro el if ESTA ACTIVO
        this.concursos.add(c); //lo addeo
        c.agregarParticipante(this); // -> hago la; logica de agregar el participante al concurso! por eso lo llamo como "esto"

        if (c.esPrimerDia(fecha)){ // ACA en ves de hacer c.getInicio para obtener la fecha de inicio
                                    //creo el metodo primer dia en concurso
            this.sumarPuntos(PUNTOS); // si es asi SUMO puntos! tremendo
        }
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
