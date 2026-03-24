package Parte2.Restaurante.contratos;

public abstract class ItemMenu {
    protected int cantidad;
    protected int precio;
    protected String nombre;
    protected String descripcion;

    // Constructor padre
    public ItemMenu(int cantidad,int precio, String nombre, String descripcion) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int precio(){
        return precio * cantidad;
    }
}
