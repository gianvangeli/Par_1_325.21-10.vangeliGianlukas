package ar.edu.utn.fra;

/**
 *
 * @author gianv
 */
public abstract class Nave {
    private String nombre;
    private int capacidadTripulacion;
    private int anioLanzamiento;
    
    public Nave(String nombre, int capacidadTripulacion, int anioLanzamiento){
        this.nombre = nombre;
        this.capacidadTripulacion = capacidadTripulacion;
        this.anioLanzamiento = anioLanzamiento;
    }
    
    public String getNombre(){
        return nombre;
    }
    public int getCapacidadTripulacion(){
        return capacidadTripulacion;
    }
    public int getAnioLanzamiento(){
        return anioLanzamiento;
    }
    
    @Override
    public String toString(){
        return "Nombre: " + nombre +
                ", Tripulacion: " + capacidadTripulacion +
                ",Año: " + anioLanzamiento;
    }
}
