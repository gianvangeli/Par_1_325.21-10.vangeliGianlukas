package ar.edu.utn.fra;

public class Carguero extends Nave implements Explorador {
    private int capacidadCarga;

    public Carguero(String nombre, int capacidadTripulacion, int anioLanzamiento, int capacidadCarga) {
        super(nombre, capacidadTripulacion, anioLanzamiento);
        if (capacidadCarga < 100 || capacidadCarga > 500){
            throw new IllegalArgumentException ("Capacidad de carga debe estar "
                    + "entre 100 y 500");
        }
        this.capacidadCarga = capacidadCarga;
        
        
    }

    @Override
    public void explorar() {
        System.out.println(" El carguero " + getNombre() +
                " Inicia mision con capacidad de " + capacidadCarga + " toneladas ");
    }

    
    @Override
    public String toString(){
        return super.toString() + ", Capacidad de carga: " + capacidadCarga + " toneladas ";
        
    }
    
}
