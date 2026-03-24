package Parte1.Concurso;

import java.time.LocalDate;

public class Main {
    public static void main( String[] args ){
        //pruebas aca dentro

        //registrar participante
        Participante p1 = new Participante("pepe", 44324687);
        Participante p2 = new Participante("juancito", 44324687);


        //crear curso
        LocalDate hoy = LocalDate.now();
        Concurso c1 = new Concurso("objetos I",hoy);
        Concurso c2 = new Concurso("objetos II",hoy);


        //ahora inscribo al usuario en el curso
        c1.inscribirA(p1, hoy);
        c2.inscribirA(p2, hoy);

    }
}
