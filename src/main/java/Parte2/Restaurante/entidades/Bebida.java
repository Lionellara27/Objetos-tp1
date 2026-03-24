package Parte2.Restaurante.entidades;

import Parte2.Restaurante.contratos.ItemMenu;

public class Bebida extends ItemMenu {

    public Bebida(int cantidad, int precio, String nombre, String descripcion) {
        super(cantidad, precio, nombre, descripcion);
    }
    @Override
    public String toString() {
        return "Bebida{" + this.nombre + " - precio:" + this.precio + "}" ;
    }
}
