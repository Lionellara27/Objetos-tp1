package Parte2.Restaurante.tarjetas;

import Parte2.Restaurante.contratos.Tarjeta;

public class Viedma implements Tarjeta {

    /*@Override
    public double calcularDescuento(int totalPlatos, int totalBebidas) {
        return 0;
    }*/

    @Override
    public String getNombre() {
        return "Viedma";
    }

    @Override
    public double calcularCosto(int platos, int bebidas) {
        return platos + bebidas;
    }
}