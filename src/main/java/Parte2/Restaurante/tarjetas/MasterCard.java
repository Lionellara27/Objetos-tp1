package Parte2.Restaurante.tarjetas;

import Parte2.Restaurante.contratos.Tarjeta;

public class MasterCard implements Tarjeta {
    private double porcentajeDescuento = 0.02;

    /*@Override
    public double calcularDescuento(int totalPlatos, int totalBebidas) {
        return 0;
    }*/

    @Override
    public String getNombre() {
        return "MasterCard";
    }

    @Override
    public double calcularCosto(int platos, int bebidas) {
        double platoConDescuento =  platos * (1 - this.porcentajeDescuento);
        return platoConDescuento + bebidas; // Suma platos con descuento + bebidas limpio
    }

    /*public void cambiarDescuento(float newDescuento){
        this.porcentajeDescuento = newDescuento;
    }*/
}
