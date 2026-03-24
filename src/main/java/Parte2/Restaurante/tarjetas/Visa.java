package Parte2.Restaurante.tarjetas;

import Parte2.Restaurante.contratos.Tarjeta;

public class Visa implements Tarjeta {
    private double porcentajeDescuento = 0.03;
    //descuento con bebidas

    /*@Override
    public double calcularDescuento(int totalPlatos, int totalBebidas) {
        return 0;
    }*/

    @Override
    public String getNombre() {
        return "Visa";
    }

    @Override
    public double calcularCosto(int platos, int bebidas) {
        double bebidasConDescuento = bebidas * (1 - this.porcentajeDescuento);
        return platos + bebidasConDescuento; // Suma platos limpios + bebidas con descuento
    }

    /*public void cambiarDescuento(float newDescuento){
        this.porcentajeDescuento = newDescuento;
    }*/
}
