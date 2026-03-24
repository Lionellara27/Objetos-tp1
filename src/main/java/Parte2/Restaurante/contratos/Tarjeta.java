package Parte2.Restaurante.contratos;

public interface Tarjeta {

    //double calcularDescuento(int totalPlatos, int totalBebidas);
    String getNombre();

    double calcularCosto(int platos, int bebidas);
}
