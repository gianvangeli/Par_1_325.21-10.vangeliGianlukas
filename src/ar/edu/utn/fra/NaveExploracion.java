package ar.edu.utn.fra;

/**
 *
 * @author gianv
 */
public class NaveExploracion extends Nave implements Explorador{
    private  TipoMision tipoMision;
   

    public NaveExploracion(String nombre, int capacidadTripulacion, int anioLanzamiento ,TipoMision tipoMision) {
        super(nombre, capacidadTripulacion, anioLanzamiento);
        this.tipoMision = tipoMision;
    }
    
    @Override
    public void explorar(){
        System.out.println("La nave de exploracion " + getNombre() + " inicia mision de " + tipoMision);
    }
    
    @Override
    public String toString(){
        return super.toString() + " , Tipo de mision " + tipoMision;
    }

        
}
    
