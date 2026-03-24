package Parte2.Restaurante.tarjetas;

import Parte2.Restaurante.contratos.Tarjeta;

public class ComarcaPlus implements Tarjeta {
    private double porcentajeDescuento = 0.02;

    /*@Override
    public double calcularDescuento(int totalPlatos, int totalBebidas) {
        return 0;
    }*/

    @Override
    public String getNombre() {
        return "ComarcaPlus";
    }

    @Override
    public double calcularCosto(int platos, int bebidas) {
        double totalBruto = platos + bebidas;
        return totalBruto * (1 - porcentajeDescuento);
    }

    /*public void cambiarDescuento(float newDescuento){
        this.porcentajeDescuento = newDescuento;
    }*/
}
