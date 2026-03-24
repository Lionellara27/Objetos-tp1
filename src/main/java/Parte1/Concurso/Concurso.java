package Parte1.Concurso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {

    private String nombre;
    private LocalDate inicio;
    private LocalDate fin;
    private static final int DURACION_ESTANDAR = 10;
    private static final int PUNTOS = 10; //ASI LE SUMO AL PARTICIPANTE SUS 10p
    private List<Participante> inscriptos; // voy a almacenar a los participantes PARA que cada concurso tenga su propia lista de los mismos!
    //entonces concurso a -> conoce todo sos participantes y participante conoce todos sus concursos

    public Concurso(String nombre, LocalDate inicio) {
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = this.inicio.plusDays(DURACION_ESTANDAR);
        this.inscriptos = new ArrayList<>();
    }


    public boolean estaInscripto(Participante p) {
        return this.inscriptos.contains(p);
    }

    public void agregarParticipante(Participante p) {
        this.inscriptos.add(p);
    }

    public void inscribirA(Participante p, LocalDate fecha) {
        //inicio una fecha hoy cuando llamo a este metodo para ver las validaciones
        //LocalDate ahora =  -> descartado o consultar
        if(!estaActivo(fecha)) {
            throw new RuntimeException("El concurso no esta activo, pruebe en otro momento");
        }
        //if (estaInscripto(p)) return; // -> si esta inscripto corto tod0

        if (estaInscripto(p)) {
            throw new RuntimeException("El participante ya esta inscripto");
        }

        this.inscriptos.add(p);
        p.agregarConcurso(this); // al participante le agrego "este" concurso

        if(esPrimerDia(fecha)) {
            p.sumarPuntos(PUNTOS); // llamo a que le sume los +10 del primer dia
        }
    }
 
    //me guardo estas logica privada para preguntar si sigue activo y si es primer dia!
    private boolean estaActivo(LocalDate fecha) {
        return !fecha.isBefore(inicio) && !fecha.isAfter(fin);
    }

    private boolean esPrimerDia(LocalDate fecha) {
        return fecha.equals(this.inicio);
    }

}



