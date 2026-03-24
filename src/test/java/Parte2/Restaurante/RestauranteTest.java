package Parte2.Restaurante;

import Parte2.Restaurante.contratos.ItemMenu;
import Parte2.Restaurante.contratos.Tarjeta;
import Parte2.Restaurante.entidades.Bebida;
import Parte2.Restaurante.entidades.Menu;
import Parte2.Restaurante.entidades.Mesa;
import Parte2.Restaurante.entidades.Plato;
import Parte2.Restaurante.tarjetas.ComarcaPlus;
import Parte2.Restaurante.tarjetas.MasterCard;
import Parte2.Restaurante.tarjetas.Viedma;
import Parte2.Restaurante.tarjetas.Visa;
//Junit 5
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class RestauranteTest {
    @Test
    public void testPropinaInvalida(){
        Menu menu = new Menu();
        Mesa mesa = new Mesa(1,menu);
        Tarjeta visa = new Visa();

        assertThrows(RuntimeException.class, () -> {
            mesa.calcularCostoFinal(visa, 20);
        });
    }


    @Test
    public void testCostoVisa(){
        Menu menu = new Menu();
        Plato milanga = new Plato(1, 4000, "Milanga", "..."); // $4000
        Bebida coca = new Bebida(2, 200, "Coca", "...");      // $400 (2x200)
        Plato flan = new Plato(1, 400, "Flan", "...");       // $400

        menu.agregarItemMenu(milanga);
        menu.agregarItemMenu(coca);
        menu.agregarItemMenu(flan);

        //Creo la mesa
        Mesa mesa = new Mesa(2, menu);

        //armo el pedido!
        List<ItemMenu> pedido = new ArrayList<>();
        pedido.add(coca);
        pedido.add(milanga);
        pedido.add(flan);

        //le seteo el pedido a la mesa
        mesa.realizarPedido(pedido);
        mesa.confirmarPedido();
        // TOTAL BRUTO: $4800
    //le voy a dar 2% de propina asi que serian $96

        //creo la tarjeta
        Tarjeta Visa = new Visa(); // -3% en bebida es decir bebida queda en $388
        //sumo 388(bebidas) + 400(flan) + 96(propina) + 4000(plato) = 4.884

        double costofinal=mesa.calcularCostoFinal(Visa,2);


        assertEquals("Visa", Visa.getNombre());
        assertEquals(4884.0, costofinal,0.1);
    }

    @Test
    public void testCostoComarcaPlus() {
        Menu menu = new Menu();
        Bebida dosCocas = new Bebida(2, 200, "Coca Cola", "Refrescante");
        Plato dosMilas = new Plato(2, 2000, "Milanga", "Milanga papa no falla");
        Plato flan = new Plato(1, 400, "Flan", "Gelatinoso y vegano");

        Mesa mesa = new Mesa(2, menu);

        List<ItemMenu> pedido = new ArrayList<>();
        pedido.add(dosCocas);
        pedido.add(dosMilas);
        pedido.add(flan);

        mesa.realizarPedido(pedido);
        mesa.confirmarPedido();

        Tarjeta comarca = new ComarcaPlus();
        double resultado = mesa.calcularCostoFinal(comarca, 2);
        // (4800 - 96 de total) + 96 de propina = 4800

        assertEquals("ComarcaPlus", comarca.getNombre());
        assertEquals(4800.0, resultado, 0.01);
    }

    @Test
    public void testCostoMastercard() {
        Menu menu = new Menu();
        Bebida dosCocas = new Bebida(2, 200, "Coca Cola", "Refrescante");
        Plato dosMilas = new Plato(2, 2000, "Milanga", "Milanga papa no falla");
        Plato flan = new Plato(1, 400, "Flan", "Gelatinoso y vegano");

        Mesa mesa = new Mesa(2, menu);

        List<ItemMenu> pedido = new ArrayList<>();
        pedido.add(dosCocas);
        pedido.add(dosMilas);
        pedido.add(flan);

        mesa.realizarPedido(pedido);
        mesa.confirmarPedido();

        Tarjeta master = new MasterCard();
        double resultado = mesa.calcularCostoFinal(master, 2);
        // (4800 - 88 de platos) + 96 de propina = 4808

        assertEquals("MasterCard", master.getNombre());
        assertEquals(4808.0, resultado, 0.01);
    }

    @Test
    public void testCostoViedma() {
        Menu menu = new Menu();
        Bebida dosCocas = new Bebida(2, 200, "Coca Cola", "Refrescante");
        Plato dosMilas = new Plato(2, 2000, "Milanga", "Milanga papa no falla");
        Plato flan = new Plato(1, 400, "Flan", "Gelatinoso y vegano");

        Mesa mesa = new Mesa(2, menu);

        List<ItemMenu> pedido = new ArrayList<>();
        pedido.add(dosCocas);
        pedido.add(dosMilas);
        pedido.add(flan);

        mesa.realizarPedido(pedido);
        mesa.confirmarPedido();

        Tarjeta viedma = new Viedma();
        double resultado = mesa.calcularCostoFinal(viedma, 2);
        // 4800 + 96 de propina = 4896

        assertEquals("Viedma", viedma.getNombre());
        assertEquals(4896.0, resultado, 0.01);
    }
}
