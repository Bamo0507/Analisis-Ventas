//Bryan Alberto Martínez Orellana
//Carnét 23542
//Ingeniería en Ciencias de la Computación
//Programación Orientada a Objetos
//Creación: 11/08/2023
//Última modificación: 12/08/2023

import java.util.Scanner;
import java.util.InputMismatchException;

public class Comprador {
    Scanner scanner = new Scanner(System.in);
    private float presupuesto;
    private int cant_boletos;
    private boolean validar1 = false;
    private boolean validar2 = false;
    private String nombre;

    //Modificamos el nombre del comprador
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Obtenemos el presupuesto ingresado
    public float getPresupuesto() {
        return presupuesto;
    }

    //Obtenemos la canitdad de boletos que se desean
    public int getCant_boletos() {
        return cant_boletos;
    }

    //Modificamos la cantidad de boletos, ocurre cuando hay menos asientos disponibles que los deseados
    public void setCant_boletos(int cant_boletos) {
        this.cant_boletos = cant_boletos;
    }

    //Solicitud de información del comprador
    public void Solicitud(){
        //Se pide el presupuesto
        do{
            try{
                System.out.println("Buen día, por favor indique cuál es su presupuesto acá: ");
                presupuesto = scanner.nextFloat();
                scanner.nextLine();
                validar1 = true;
            }
            //Se verifica que se esté manejando un entero
            catch(InputMismatchException e){
                System.out.println("Por favor, asegurese de estar colocando un número.\n");
                scanner.nextLine();
            }
        }
        while (!validar1);
        //Reseteamos nuestra variable a false para posibles futuras verificaciones de nuevos compradores
        validar1 = false;
        
        //Se pide la cantidad de boletos
        do{
            try{
                System.out.println("\nAhora, cuántos tickets son los que desea: ");
                cant_boletos = scanner.nextInt();
                scanner.nextLine();
                validar2 = true;
            }
            catch(InputMismatchException e){
                System.out.println("Por favor, asegurese de estar colocando un número entero.\n");
                scanner.nextLine();
            }
        }
        while (!validar2);
        //Reseteamos nuestra variable a false para posibles futuras verificaciones de nuevos compradores
        validar2 = false;
        
    }



}
