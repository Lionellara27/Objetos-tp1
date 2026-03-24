package Parte2.Restaurante;

import Parte2.Restaurante.contratos.ItemMenu;
import Parte2.Restaurante.contratos.Tarjeta;
import Parte2.Restaurante.entidades.Bebida;
import Parte2.Restaurante.entidades.Menu;
import Parte2.Restaurante.entidades.Mesa;
import Parte2.Restaurante.entidades.Plato;
import Parte2.Restaurante.tarjetas.Viedma;
import Parte2.Restaurante.tarjetas.Visa;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        //voy a crear una T.C comarca y una viedma
        Tarjeta tarjeteViedma = new Viedma();
        Tarjeta tarjetaVisa = new Visa();

        //creo una bebida y un plato
        Bebida dosCocas = new Bebida(2,200, "coca cola", "refrescante");
        Plato dosMilas = new Plato(2,2000, "Milanga", "milanga papa no falla");
        Plato flan = new Plato(1,400,"flan", "gelatinozo y vegano");

        // el menu de hoy tiene esas opciones!
        Menu menuhoy = new Menu();
        menuhoy.agregarItemMenu(dosCocas);
        menuhoy.agregarItemMenu(dosMilas);
        menuhoy.agregarItemMenu(flan);

        // 2 personas random, pero bueno le pongo el menu de hoy
        Mesa primerMesa = new Mesa(2, menuhoy); // 2 personas random, pero bueno le pongo el menu de hoy
        primerMesa.mostrarMenu();

        //meto todo en un pedido
        List<ItemMenu> pedidoPrimerMesa = new ArrayList<>();
        pedidoPrimerMesa.add(dosCocas);
        pedidoPrimerMesa.add(dosMilas);  //basicamente agrego todo el menu !
        pedidoPrimerMesa.add(flan);
        //deberia ser total 4800.

        primerMesa.realizarPedido(pedidoPrimerMesa);
        primerMesa.confirmarPedido(); //finalizo la orden

        //ahora veo cuanto me cuesta si es verdad que depende la tj me hacen descuento
        primerMesa.calcularCostoFinal(tarjeteViedma, 2);
        primerMesa.calcularCostoFinal(tarjetaVisa, 2);
    }
}
