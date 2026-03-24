package Parte2.Restaurante.entidades;

import Parte2.Restaurante.contratos.ItemMenu;

public class Plato extends ItemMenu {

    public Plato(int cantidad, int precio, String nombre, String descripcion) {
        super(cantidad, precio, nombre, descripcion);
    }

    /*public double sumarPlatos(){
        return cantidad * precio;
    }*/

    @Override
    public String toString() {
        return "Plato{" + this.nombre + " - precio:" + this.precio + "}" ;    }
}
