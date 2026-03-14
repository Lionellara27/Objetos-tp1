package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {

    private String nombre;
    private LocalDate inicio;
    private LocalDate fin;
    private static final int DURACION_ESTANDAR = 10;
    private List<Participante> inscriptos; // voy a almacenar a los participantes PARA que cada concurso tenga su propia lista de los mismos!
    //entonces concurso a -> conoce todo sos participantes y participante conoce todos sus concursos


    //constructor vacio carga un ""concurso"" defaul ponele
    public Concurso() {
        this.nombre = "Nuevo org.example.Concurso";
        this.inicio = LocalDate.now();
        this.fin = this.inicio.plusDays(10); // Usas tu constante aquí
        this.inscriptos = new ArrayList<>();
    }

    public Concurso(String nombre, LocalDate inicio) {
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = this.inicio.plusDays(DURACION_ESTANDAR);
        this.inscriptos = new ArrayList<>();
    }

    public boolean estaActivo(LocalDate fecha) {
        return !fecha.isBefore(inicio) && !fecha.isAfter(fin);
    }
    /*
    public boolean estaActivo(LocalDate fecha) {
        // La forma infalible:
        boolean despuesOIgualAlInicio = !fecha.isBefore(this.inicio);
        boolean antesOIgualAlFin = !fecha.isAfter(this.fin);

        return despuesOIgualAlInicio && antesOIgualAlFin;
    }*/

    public boolean esPrimerDia(LocalDate fecha) {
        return fecha.equals(this.inicio);
    }

    public boolean estaInscripto(Participante p) {
        return this.inscriptos.contains(p);
    }

    public void agregarParticipante(Participante p) {
        this.inscriptos.add(p);
    }

    //public boolean inscripcionAbierta(LocalDate fecha){
//        return !fecha.isBefore(inicio) && !fecha.isAfter(fin);
  //  }

    //public boolean esPrimerDia(LocalDate fecha){
      //  return fecha.equals(inicio);
    //}
}
