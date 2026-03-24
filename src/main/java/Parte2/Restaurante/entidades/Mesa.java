package Parte2.Restaurante.entidades;

import Parte2.Restaurante.contratos.ItemMenu;
import Parte2.Restaurante.contratos.Tarjeta;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private int cantidadPersonas;
    private List<ItemMenu> itemsPedidos;
    private Menu menu;
    private boolean pedidoConfirmado = false;

    public Mesa(int cantidadPersonas, Menu menu) {
        this.cantidadPersonas = cantidadPersonas;
        this.menu = menu;
        itemsPedidos = new ArrayList<>();
    }

    public void mostrarMenu() {
        this.menu.mostrarMenu();
    }


    // agregamos cosas hasta que el cliente diga que no quiere mas!
    public void realizarPedido(List<ItemMenu> pedido){
        if(this.pedidoConfirmado) {
            throw new RuntimeException("No se pueden agregar items: el pedido ya fue confirmado.");
        }
        this.itemsPedidos.addAll(pedido);
    }

    // con eso ya damos que el cliente NO PIDE MAS y se cierra!
    public void confirmarPedido() {
        if (this.itemsPedidos.isEmpty()) {
            throw new RuntimeException("No podés confirmar un pedido vacío."); //validamos que no este vacio!
        }
        this.pedidoConfirmado = true;
    }

    public double calcularCostoFinal(Tarjeta tarjeta, int propina) {
        // Validamos la propina primero
        if (propina != 2 && propina != 3 && propina != 5) {
            throw new RuntimeException("La propina debe ser del 2%, 3% o 5%");
        }

        int totalPlato = this.sumarPlatos();
        int totalBebidas = this.sumarBebidas();

        // como es valida y llego aca calculamos!
        double montoPropina = (totalPlato + totalBebidas) * (propina / 100.0);

        //este ya te devuelve el descuento xq se supone cada "tarjeta" sabe su propio descuento!!!
        double totalConDescuento = tarjeta.calcularCosto(totalPlato, totalBebidas);

        //retornamos el monto a pagar !
        return montoPropina + totalConDescuento;
    }

    //metodos privados para calcular costos
    private int sumarPlatos(){
        int suma = 0;
        for (ItemMenu item : this.itemsPedidos){
            if (item instanceof Plato){
                suma += item.precio();
            }
        }
        return suma;
    }
    private int sumarBebidas(){
        int suma = 0;
        for (ItemMenu item : this.itemsPedidos){
            if (item instanceof Bebida){
                suma += item.precio();
            }
        }
        return suma;
    }
}

