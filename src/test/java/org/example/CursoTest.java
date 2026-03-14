package org.example;
import org.example.Participante;
import org.example.Concurso;

//Junit 5
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class CursoTest {
    @Test
    public void testInscribirParticipante() {
        LocalDate hoy = LocalDate.now();
        LocalDate manana = hoy.plusDays(1);

        Concurso c = new Concurso("Programacion 1", hoy);
        Participante lio = new Participante("Lionel", 44324687);

        //primero lo inscribio obvio
        lio.inscribirseA(c, manana);

        //aca pregunto si ya esta ! en teoria?=?
        //ASSERT para verificar
        assertTrue(c.estaInscripto(lio));
    }
    //PRIMER TEST bien!

    @Test
    public void testInscripcionPrimerDiaGanaPuntos() {
        LocalDate hoy = LocalDate.now();

        Concurso c = new Concurso("Programacion 1", hoy);
        Participante lio = new Participante("Lionel", 44324687);

        //
        lio.inscribirseA(c, hoy);

        assertEquals(10, lio.puntosParticipante());
    } //efectivamente lio se inscribio el primer dia xq tiene los 10 ptos.

    @Test
    public void testInscripcionFueraDeRango() {
        LocalDate hoy = LocalDate.now();
        Concurso c = new Concurso("Programacion 1", hoy);

        LocalDate fueraTiempo = hoy.plusDays(11); // 11 dias despues ya termino el tiempo
        Participante pepe = new Participante("Pepee", 44123456);

        assertThrows(RuntimeException.class, () -> {
            pepe.inscribirseA(c, fueraTiempo);
        });
    } //este test fue el mas dificil! lo hago explotar y atraplo la explosion preguntando
    //che lo que iba a explotar EXPLOTO? SI. todo ok!
}
