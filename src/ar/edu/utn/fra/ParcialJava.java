package ar.edu.utn.fra;
import java.util.Scanner;

/**
 *
 * @author gianv
 */
public class ParcialJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            AgenciaExpediciones agencia = new AgenciaExpediciones();
            int opcion;
            
            do{
                System.out.println("\n=== AGENCIA DE EXPEDICIONES  ===");
                System.out.println("1. Agregar nave");
                System.out.println("2. Mostrar todas las naves");
                System.out.println("3. Iniciar exploración");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                
                if (sc.hasNextInt()){
                    opcion = sc.nextInt();
                }else {
                    sc.next();
                    opcion = -1;
                }
                
                switch(opcion){
                    case 1: 
                        agencia.agregarNave();
                        break;
                        
                    case 2: 
                        agencia.iniciarExploracion();
                        break;
                    case 3: 
                        agencia.mostrarNaves();
                        break;
                    case 4: 
                        System.out.println("Saliendo del sistema... ");
                        break;
                        
                    default :{
                        if (opcion != -1){
                            System.out.println("Opcion invalida.");
                        }else {
                            System.out.println(" Debe ingresar un numero.");
                        }
                    }
                }
            } while (opcion != 4);
            sc.close();
        }
        System.out.println("Fin del programa.");
    }
}
           
            
            
    

                
           
     
        
  
    

