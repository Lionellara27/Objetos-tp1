package Parte1.Concurso;

//Junit 5
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import Parte1.Concurso.Concurso;
import Parte1.Concurso.Participante;

public class CursoTest {
    @Test
    public void testInscribirParticipante() {
        LocalDate hoy = LocalDate.now();
        LocalDate manana = hoy.plusDays(1);

        Concurso concurso = new Concurso("Programacion 1", hoy);
        Participante lio = new Participante("Lionel", 44324687);

        //primero lo inscribio obvio
        concurso.inscribirA(lio, manana);

        //aca pregunto si ya esta ! en teoria?=?
        //ASSERT para verificar
        assertTrue(concurso.estaInscripto(lio));
    }
    //PRIMER TEST bien!

    @Test
    public void testInscripcionPrimerDiaGanaPuntos() {
        LocalDate hoy = LocalDate.now();

        Concurso concurso = new Concurso("Programacion 1", hoy);
        Participante lio = new Participante("Lionel", 44324687);

        //
        concurso.inscribirA(lio, hoy);

        assertEquals(10, lio.puntosParticipante());
    } //efectivamente lio se inscribio el primer dia xq tiene los 10 ptos.

    @Test
    public void testInscripcionFueraDeRango() {
        LocalDate hoy = LocalDate.now();
        Concurso concurso = new Concurso("Programacion 1", hoy);

        LocalDate fueraTiempo = hoy.plusDays(11); // 11 dias despues ya termino el tiempo
        Participante pepe = new Participante("Pepee", 44123456);

        assertThrows(RuntimeException.class, () -> {
            concurso.inscribirA(pepe, fueraTiempo);
        });
    } //este test fue el mas dificil! lo hago explotar y atraplo la explosion preguntando
    //che lo que iba a explotar EXPLOTO? SI. todo ok!

    @Test
    public void testEqualsObjetosDiferentes() {
        Participante p = new Participante("Lio",12345678);
        // Esto fuerza al 'instanceof' a devolver false
        assertFalse(p.equals("No soy un participante"));
        assertFalse(p.equals(null));
    }
}

//cobertura en Line de 91% -> bien


