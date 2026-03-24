package Parte2.Restaurante.entidades;

import Parte2.Restaurante.contratos.ItemMenu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<ItemMenu> productosDisponibles;

    public Menu() {
        this.productosDisponibles = new ArrayList<ItemMenu>();
    }

    public void agregarItemMenu(ItemMenu itemMenu) { //agrego cosas
        this.productosDisponibles.add(itemMenu);
    }

    public void mostrarMenu() { //MUESTRA el menu completo
        System.out.println("PLATOS---------------");
        if (!this.productosDisponibles.isEmpty()) {
            for (ItemMenu itemMenu : this.productosDisponibles) {
                if (itemMenu instanceof Plato) {
                    System.out.println(itemMenu);
                }
            }
            System.out.println("BEBIDAS---------------");
            for  (ItemMenu itemMenu : this.productosDisponibles) {
                if (itemMenu instanceof Bebida) {
                    System.out.println(itemMenu);
                }
            }
        }else {
            throw new RuntimeException("EL MENU ESTA VACIOOOOOOOOOOOOOOOOOO");
        }
    }
}

