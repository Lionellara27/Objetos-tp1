public class Participante {
    private String nombre;
    private int dni;
    private int puntos;

    public Participante( ) {
    }

    public Participante(String nombre, int dni, int puntos) {
        this.nombre = nombre;
        this.dni = dni;
        this.puntos = 0;
    }

    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }

    //get --------------------------------
    public int getPuntos() {
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void getDni(int dni){
        this.dni = dni;
    }
    //--------------------------------------------

    //set
    public void  setPuntos(int puntos) {
        this.puntos = puntos;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDni(int dni){
        this.dni = dni;
    }
    /// //////////////////////////

}
