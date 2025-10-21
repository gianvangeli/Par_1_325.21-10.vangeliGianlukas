package ar.edu.utn.fra;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author gianv
 */
public class AgenciaExpediciones {
    private  List<Nave> naves = new ArrayList<>();
    private  Scanner sc = new Scanner(System.in);
    
    private int leerEntero(String mensaje){
        System.out.print(mensaje);
        /*Fuerzo al usuario ingresar un entero */
        while(!sc.hasNextInt()){
            System.out.println("Entrada invalida, ingrese un numero entero. ");
            sc.next();
            System.out.print(mensaje);
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }
    private String leerTexto(String mensaje){
        System.out.print(mensaje);
        return sc.nextLine();
    }
    
    
    public void agregarNave(){
        Nave nueva = null;
        
        
        
    try {
        System.out.println("--- Tipo de Nave ---");
        System.out.println("1. Nave de exploración");
        System.out.println("2. Carguero");
        System.out.println("3. Crucero estelar");
        
        int tipo = leerEntero("Seleccione el tipo (1, 2 o 3): ");
        
        String nombre = leerTexto("Nombre: ");
        int trip = leerEntero("Capacidad de tripulacion: ");
        int anio = leerEntero("Año de lanzamiento: ");
        
        
        switch (tipo) {
            case 1 -> { 
                System.out.println("\n--- Misión ---");
                System.out.println("1. CARTOGRAFIA  2. INVESTIGACION  3. CONTACTO");
                int m = leerEntero("Seleccione Misión (1-3): ");
                TipoMision tm;
                
                switch (m){
                    case 1 -> tm = TipoMision.CARTOGRAFIA;
                    case 2 -> tm = TipoMision.INVESTIGACION;
                    case 3 -> tm = TipoMision.CONTACTO;
                    default -> {
                        System.out.println("️Tipo de misión inválido, se usará CARTOGRAFIA por defecto.");
                        tm = TipoMision.CARTOGRAFIA;
                    }
                }
                nueva = new NaveExploracion(nombre, trip, anio,tm);
                }

                
            case 2 -> {
                int carga = 0;
                boolean cargaValida = false;
                
                while(!cargaValida){
                    carga = leerEntero("Capacidad de carga (100-500): ");
                    if (carga >= 100 && carga <=500){
                        cargaValida = true;
                        nueva = new Carguero(nombre, trip, anio, carga);
                    }else {
                        System.out.println("Error: Capacidad de carga debe estar entre 100 y 500. Intente de nuevo.");
                    }
                }
                
                }
            case 3 -> {
                int pasajeros = leerEntero("Cantidad de pasajeros: ");
                nueva = new CruceroEstelar(nombre, trip, anio, pasajeros);
                }
            default -> {
                System.out.println("️ Tipo de nave inválido. Regresando al menú.");
                return;
                }
            }
                
                
        if(nueva!= null){
            for (Nave existente : naves) {
                if (existente.getNombre().equalsIgnoreCase(nueva.getNombre())
                        && existente.getAnioLanzamiento() == nueva.getAnioLanzamiento()) {
                    throw new NaveDuplicadaException(
                        " Ya existe una nave con el nombre " + nueva.getNombre() +
                        " y año " + nueva.getAnioLanzamiento());
                }  
        
            }
            naves.add(nueva);
            System.out.println("Nave agregada con exito. ");
        }
        
        
    } catch (NaveDuplicadaException e){
        System.out.println("Error: " + e.getMessage());
        
    } catch (IllegalArgumentException e){
        System.out.println(" Error: " +  e.getMessage());
        
    }
}
        
    
    public void mostrarNaves(){
        if (naves.isEmpty()){
            System.out.println("No hay naves registradas.");
        }else {
            System.out.println("\n=== Naves registradas ===");
            for (Nave n : naves){
                System.out.println(n);
            }
        }
    }
    
    public void iniciarExploracion(){
        System.out.println("\nIniciando misiones de exploración:");
        if (naves.isEmpty()) {
        System.out.println(" No hay naves registradas para iniciar misiones.");
        return;
    }
        for (Nave n : naves){
            if (n instanceof Explorador e){
                e.explorar();
            } else {
                System.out.println("El crucero estelar " + n.getNombre() + 
                        "no puede iniciar mision, solo transporta pasajeros.");
            }
        }
        
    }
}
