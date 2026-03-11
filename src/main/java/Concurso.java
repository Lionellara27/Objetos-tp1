import java.time.LocalDate;

public class Concurso {

    private String nombre;
    private LocalDate inicio;
    private LocalDate fin;

    public Concurso(String nombre, LocalDate inicio, LocalDate fin){
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
    }

    public boolean inscripcionAbierta(LocalDate fecha){
        return !fecha.isBefore(inicio) && !fecha.isAfter(fin);
    }

    public boolean esPrimerDia(LocalDate fecha){
        return fecha.equals(inicio);
    }
}
