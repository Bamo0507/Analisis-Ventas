//Bryan Alberto Martínez Orellana
//Carnét 23542
//Ingeniería en Ciencias de la Computación
//Programación Orientada a Objetos
//Creación: 11/08/2023
//Última modificación: 12/08/2023

import java.util.Scanner;
import java.util.InputMismatchException;

public class Ventas {
    //Definimos las variables
    private static int seleccion;
    private static int n_comprador = 0;
    private static int bol_local1 = 0;
    private static int bol_local2 = 0;
    private static int bol_local3 = 0;
    private static boolean validar;
    private static float costo_total = 0;
    private static String seleccion2;
    private static float ventas_totales = 0;
    private static int x = 0;
    private static int seleccion3;


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //Se establecen las 3 localidades y sus costos. Además se abre el objeto aleatorio y el comprador
        Localidad localidad1 = new Localidad();
        localidad1.setCosto(100);


        Localidad localidad2 = new Localidad();
        localidad2.setCosto(500);


        Localidad localidad3 = new Localidad();
        localidad3.setCosto(1000);


        Aleatorio aleatorio = new Aleatorio();

        Comprador comprador = new Comprador();


        while (true) {
            validar = false;
            do{
                try{
            
                    //Menú principal del usuario
                    System.out.println("¿Qué desea hacer?");        
                    System.out.println("1. Nuevo comprador");
                    System.out.println("2. Nueva solicitud de boletos");
                    System.out.println("3. Consultar disponibilidad total");
                    System.out.println("4. Consultar disponibilidad individual");
                    System.out.println("5. Reporte de caja");
                    System.out.println("6. Salir");
                    System.out.println("Coloque aquí su selección: ");
                    //Se solicita lo que desee hacer
                    seleccion = scanner.nextInt();
                    scanner.nextLine();
                    validar = true;
                }


                //Verifica que la opción sea correcta
                catch(InputMismatchException e){
                    System.out.println("Por favor, verifica que estás colocando un número\n");
                    scanner.nextLine();
                }
            }
            while (!validar);


            switch(seleccion){

                //Se establece un nuevo comprador
                case 1:
                    x = 1;
                    n_comprador++;
                    String nombreComprador = "Comprador" + n_comprador;
                    comprador.setNombre(nombreComprador);
                    comprador.Solicitud();

                    //Establecemos las probabilidades de compra
                    aleatorio.Calcular_localidad();
                    aleatorio.Aprobar();

                    //Se aprueba la compra
                    if (aleatorio.getAprobado().equals("Yes")){
                        switch(aleatorio.getNumLocal()) {

                            //Localidad 1
                            case 1:

                                //Se verifica que todavía haya espacio
                                if (localidad1.getDisponibilidad() == 0){
                                    System.out.println("Lamentamos informarte que se han agotado las entredas para tu sector.\n");
                                    break;
                                }

                                //Se verifica que el usuario quiera comprar una cantidad de boletos por espacio
                                if (localidad1.getDisponibilidad() < comprador.getCant_boletos()){
                                    System.out.println("Lamentablemente no contamos con suficiente espacio para venderle todos los boletos que necesita.\n");
                                    System.out.println("Contamos con " + localidad1.getDisponibilidad() + " y usted necesita " + comprador.getCant_boletos() + " por lo que sólo le podemos vender " + localidad1.getDisponibilidad() + " boletos.\n");
                                    System.out.println("¿Desea proseguir con su compra? De ser así apache 1, si no, cualquier otra tecla.\n");
                                    seleccion2 = scanner.nextLine();
                                    
                                    //El usuario ya no desea seguir, entonces salimos
                                    if (!seleccion2.equals("1")){
                                        System.out.println("Regresando al menú principal.");
                                        break;
                                    }

                                    //El usuario quiere proseguir, se modifica su cantidad de boletos
                                    else if (seleccion2.equals("1")){
                                        comprador.setCant_boletos(localidad1.getDisponibilidad());
                                    }
                                }

                                //Se establece cuánto gastará el usuario
                                costo_total = (comprador.getCant_boletos()) * (localidad1.getCosto());

                                //Se verifica que su presupuesto sea apto al costo
                                if (costo_total > comprador.getPresupuesto()){
                                    System.out.println("Lamentablemente el costo está por encima de su presupuesto.\n");
                                    break;
                                }
                                
                                //Se procede con la compra
                                System.out.println("Felicidades, podemos proseguir con la compra!!!!!!\n");
                                System.out.println("Su total será de $" + costo_total + ".");
                                System.out.println("=========================================================\n");
                                localidad1.setDisponibilidad(localidad1.getDisponibilidad() - comprador.getCant_boletos());
                                ventas_totales += (costo_total);
                                bol_local1 += comprador.getCant_boletos();
                                break;


                            case 2:
                                //Se verifica que todavía haya espacio
                                if (localidad2.getDisponibilidad() == 0){
                                    System.out.println("Lamentamos informarte que se han agotado las entredas para tu sector.\n");
                                    break;
                                }

                                //Se verifica que el usuario quiera comprar una cantidad de boletos por espacio
                                if (localidad2.getDisponibilidad() < comprador.getCant_boletos()){
                                    System.out.println("Lamentablemente no contamos con suficiente espacio para venderle todos los boletos que necesita.\n");
                                    System.out.println("Contamos con " + localidad2.getDisponibilidad() + " y usted necesita " + comprador.getCant_boletos() + " por lo que sólo le podemos vender " + localidad2.getDisponibilidad() + " boletos.\n");
                                    System.out.println("¿Desea proseguir con su compra? De ser así apache 1, si no, cualquier otra tecla.\n");
                                    seleccion2 = scanner.nextLine();

                                    //El usuario ya no desea seguir, entonces salimos
                                    if (!seleccion2.equals("1")){
                                        System.out.println("Regresando al menú principal.");
                                        break;
                                    }
                                    //El usuario quiere proseguir, se modifica su cantidad de boletos
                                    else if (seleccion2.equals("1")){
                                        comprador.setCant_boletos(localidad2.getDisponibilidad());
                                    }
                                }

                                //Se establece cuánto gastará el usuario
                                costo_total = (comprador.getCant_boletos()) * (localidad2.getCosto());

                                //Se verifica que su presupuesto sea apto al costo
                                if (costo_total > comprador.getPresupuesto()){
                                    System.out.println("Lamentablemente el costo está por encima de su presupuesto.\n");
                                    break;
                                }
                                
                                //Se procede con la compra
                                System.out.println("Felicidades, podemos proseguir con la compra!!!!!!\n");
                                System.out.println("Su total será de $" + costo_total + ".");
                                System.out.println("=========================================================\n");
                                localidad2.setDisponibilidad(localidad2.getDisponibilidad() - comprador.getCant_boletos());
                                ventas_totales += (costo_total);
                                bol_local2 += comprador.getCant_boletos();
                                break;

                            case 3:

                                //Se verifica que todavía haya espacio
                                if (localidad3.getDisponibilidad() == 0){
                                    System.out.println("Lamentamos informarte que se han agotado las entredas para tu sector.\n");
                                    break;
                                }

                                //Se verifica que el usuario quiera comprar una cantidad de boletos por espacio
                                if (localidad3.getDisponibilidad() < comprador.getCant_boletos()){
                                    System.out.println("Lamentablemente no contamos con suficiente espacio para venderle todos los boletos que necesita.\n");
                                    System.out.println("Contamos con " + localidad3.getDisponibilidad() + " y usted necesita " + comprador.getCant_boletos() + " por lo que sólo le podemos vender " + localidad3.getDisponibilidad() + " boletos.\n");
                                    System.out.println("¿Desea proseguir con su compra? De ser así apache 1, si no, cualquier otra tecla.\n");
                                    seleccion2 = scanner.nextLine();

                                    //El usuario ya no desea seguir, entonces salimos
                                    if (!seleccion2.equals("1")){
                                        System.out.println("Regresando al menú principal.");
                                        break;
                                    }

                                    //El usuario quiere proseguir, se modifica su cantidad de boletos
                                    else if (seleccion2.equals("1")){
                                        comprador.setCant_boletos(localidad3.getDisponibilidad());
                                    }
                                }

                                //Se establece cuánto gastará el usuario
                                costo_total = (comprador.getCant_boletos()) * (localidad3.getCosto());

                                //Se verifica que su presupuesto sea apto al costo
                                if (costo_total > comprador.getPresupuesto()){
                                    System.out.println("Lamentablemente el costo está por encima de su presupuesto.\n");
                                    break;
                                }
                                
                                //Se procede con la compra
                                System.out.println("Felicidades, podemos proseguir con la compra!!!!!!\n");
                                System.out.println("Su total será de $" + costo_total + ".");
                                System.out.println("=========================================================\n");
                                localidad3.setDisponibilidad(localidad3.getDisponibilidad() - comprador.getCant_boletos());
                                ventas_totales += (costo_total);
                                bol_local3 += comprador.getCant_boletos();
                                break;
                                }
                            }

                    //Código a correr en caso de que no se haya tenido suerte de poder conseguir boletos
                    else if (aleatorio.getAprobado().equals("No")){
                        System.out.println("\n");
                    }
                    break;
                
                case 2:
                    //Se verifica que ya se tenga información de algún comprador
                    if (x == 0){
                        System.out.println("Primero debe registrarse como nuevo comprador por favor.\n");
                        break;
                    }
                    
                    //Se continúa normal con el código ya que tengamos información de un comprador
                    if (x == 1){
                        comprador.Solicitud();

                        //Establecemos las probabilidades de compra
                        aleatorio.Calcular_localidad();
                        aleatorio.Aprobar();

                        //Se aprueba la compra
                        if (aleatorio.getAprobado().equals("Yes")){
                            switch(aleatorio.getNumLocal()) {

                                //Localidad 1
                                case 1:

                                    //Se verifica que todavía haya espacio
                                    if (localidad1.getDisponibilidad() == 0){
                                        System.out.println("Lamentamos informarte que se han agotado las entredas para tu sector.\n");
                                        break;
                                    }

                                    //Se verifica que el usuario quiera comprar una cantidad de boletos por espacio
                                    if (localidad1.getDisponibilidad() < comprador.getCant_boletos()){
                                        System.out.println("Lamentablemente no contamos con suficiente espacio para venderle todos los boletos que necesita.\n");
                                        System.out.println("Contamos con " + localidad1.getDisponibilidad() + " y usted necesita " + comprador.getCant_boletos() + " por lo que sólo le podemos vender " + localidad1.getDisponibilidad() + " boletos.\n");
                                        System.out.println("¿Desea proseguir con su compra? De ser así apache 1, si no, cualquier otra tecla.\n");
                                        seleccion2 = scanner.nextLine();
                                        scanner.nextLine();
                                        //El usuario ya no desea seguir, entonces salimos
                                        if (!seleccion2.equals("1")){
                                            System.out.println("Regresando al menú principal.");
                                            break;
                                        }

                                        //El usuario quiere proseguir, se modifica su cantidad de boletos
                                        else if (seleccion2.equals("1")){
                                            comprador.setCant_boletos(localidad1.getDisponibilidad());
                                        }
                                    }

                                    //Se establece cuánto gastará el usuario
                                    costo_total = (comprador.getCant_boletos()) * (localidad1.getCosto());

                                    //Se verifica que su presupuesto sea apto al costo
                                    if (costo_total > comprador.getPresupuesto()){
                                        System.out.println("Lamentablemente el costo está por encima de su presupuesto.\n");
                                        break;
                                    }
                                    
                                    //Se procede con la compra
                                    System.out.println("Felicidades, podemos proseguir con la compra!!!!!!\n");
                                    System.out.println("Su total será de $" + costo_total + ".");
                                    System.out.println("=========================================================\n");
                                    localidad1.setDisponibilidad(localidad1.getDisponibilidad() - comprador.getCant_boletos());
                                    ventas_totales += (costo_total);
                                    bol_local1 += comprador.getCant_boletos();
                                    break;


                                case 2:
                                    //Se verifica que todavía haya espacio
                                    if (localidad2.getDisponibilidad() == 0){
                                        System.out.println("Lamentamos informarte que se han agotado las entredas para tu sector.\n");
                                        break;
                                    }

                                    //Se verifica que el usuario quiera comprar una cantidad de boletos por espacio
                                    if (localidad2.getDisponibilidad() < comprador.getCant_boletos()){
                                        System.out.println("Lamentablemente no contamos con suficiente espacio para venderle todos los boletos que necesita.\n");
                                        System.out.println("Contamos con " + localidad2.getDisponibilidad() + " y usted necesita " + comprador.getCant_boletos() + " por lo que sólo le podemos vender " + localidad2.getDisponibilidad() + " boletos.\n");
                                        System.out.println("¿Desea proseguir con su compra? De ser así apache 1, si no, cualquier otra tecla.\n");
                                        seleccion2 = scanner.nextLine();
                                        scanner.nextLine();
                                        //El usuario ya no desea seguir, entonces salimos
                                        if (!seleccion2.equals("1")){
                                            System.out.println("Regresando al menú principal.");
                                            break;
                                        }
                                        //El usuario quiere proseguir, se modifica su cantidad de boletos
                                        else if (seleccion2.equals("1")){
                                            comprador.setCant_boletos(localidad2.getDisponibilidad());
                                        }
                                    }

                                    //Se establece cuánto gastará el usuario
                                    costo_total = (comprador.getCant_boletos()) * (localidad2.getCosto());

                                    //Se verifica que su presupuesto sea apto al costo
                                    if (costo_total > comprador.getPresupuesto()){
                                        System.out.println("Lamentablemente el costo está por encima de su presupuesto.\n");
                                        break;
                                    }
                                    
                                    //Se procede con la compra
                                    System.out.println("Felicidades, podemos proseguir con la compra!!!!!!\n");
                                    System.out.println("Su total será de $" + costo_total + ".");
                                    System.out.println("=========================================================\n");
                                    localidad2.setDisponibilidad(localidad2.getDisponibilidad() - comprador.getCant_boletos());
                                    ventas_totales += (costo_total);
                                    bol_local2 += comprador.getCant_boletos();
                                    break;

                                case 3:

                                    //Se verifica que todavía haya espacio
                                    if (localidad3.getDisponibilidad() == 0){
                                        System.out.println("Lamentamos informarte que se han agotado las entredas para tu sector.\n");
                                        break;
                                    }

                                    //Se verifica que el usuario quiera comprar una cantidad de boletos por espacio
                                    if (localidad3.getDisponibilidad() < comprador.getCant_boletos()){
                                        System.out.println("Lamentablemente no contamos con suficiente espacio para venderle todos los espacios que necesita.\n");
                                        System.out.println("Contamos con " + localidad3.getDisponibilidad() + " y usted necesita " + comprador.getCant_boletos() + " por lo que sólo le podemos vender " + localidad3.getDisponibilidad() + " boletos.\n");
                                        System.out.println("¿Desea proseguir con su compra? De ser así apache 1, si no, cualquier otra tecla.\n");
                                        seleccion2 = scanner.nextLine();
                                        scanner.nextLine();
                                        //El usuario ya no desea seguir, entonces salimos
                                        if (!seleccion2.equals("1")){
                                            System.out.println("Regresando al menú principal.");
                                            break;
                                        }

                                        //El usuario quiere proseguir, se modifica su cantidad de boletos
                                        else if (seleccion2.equals("1")){
                                            comprador.setCant_boletos(localidad3.getDisponibilidad());
                                        }
                                    }

                                    //Se establece cuánto gastará el usuario
                                    costo_total = (comprador.getCant_boletos()) * (localidad3.getCosto());

                                    //Se verifica que su presupuesto sea apto al costo
                                    if (costo_total > comprador.getPresupuesto()){
                                        System.out.println("Lamentablemente el costo está por encima de su presupuesto.\n");
                                        break;
                                    }
                                    
                                    //Se procede con la compra
                                    System.out.println("Felicidades, podemos proseguir con la compra!!!!!!\n");
                                    System.out.println("Su total será de $" + costo_total + ".");
                                    System.out.println("=========================================================\n");
                                    localidad3.setDisponibilidad(localidad3.getDisponibilidad() - comprador.getCant_boletos());
                                    ventas_totales += (costo_total);
                                    bol_local3 += comprador.getCant_boletos();
                                    break;
                                    }
                                }
                        //Código a correr en caso de que no se haya tenido suerte de poder conseguir boletos
                        else if (aleatorio.getAprobado().equals("No")){
                            System.out.println("\n");
                        }
                        break;
                    }

                //Consultar disponibilidad total
                case 3:
                    System.out.println("=========================================================");
                    System.out.println("--------------Informe de disponibilidad------------------");
                    System.out.println("-------------------------------");
                    System.out.println("LOCALIDAD 1: \n");
                    System.out.println("Se han vendido " + bol_local1 + ".");
                    System.out.println("Se cuentan con " + localidad1.getDisponibilidad() + " espacios disponibles.\n"); 
                    System.out.println("-------------------------------");
                    System.out.println("LOCALIDAD 2: \n");
                    System.out.println("Se han vendido " + bol_local2 + ".");
                    System.out.println("Se cuentan con " + localidad2.getDisponibilidad() + " espacios disponibles.\n");
                    System.out.println("-------------------------------");
                    System.out.println("LOCALIDAD 3: \n");
                    System.out.println("Se han vendido " + bol_local3 + ".");
                    System.out.println("Se cuentan con " + localidad3.getDisponibilidad() + " espacios disponibles.\n");
                    System.out.println("-------------------------------");
                    System.out.println("=========================================================");
                    System.out.println("");
                    break;

                //Consultar disponibilidad individual
                case 4:
                    do{
                        System.out.println("¿De qué localidad desea saber la disponibilidad?\n");
                        System.out.println("1. Localidad 1");
                        System.out.println("2. Localidad 2");
                        System.out.println("3. Localidad 3");
                        System.out.println("Selección: ");
                        //Se verica que lo que se esté manejando es un entero
                        if(scanner.hasNextInt()){
                            seleccion3 = scanner.nextInt();
                            scanner.nextLine();
                            //Se verifica que el número haya sido un número entre 1 y 3
                            if(seleccion3 >= 1 && seleccion3 <= 3){
                                break;
                                }
                                else {
                                    System.out.println("Por favor ingrese 1, 2 o 3.");
                                }
                            }
                        //Se le recuerda al usuario la entrada que se espera
                        else {
                            System.out.println("Por favor, ingrese un número entero.");
                            scanner.next();
                            }
                        }
                        while (true);
                    
                        switch (seleccion3){
                            //Informe de localidad 1
                            case 1:
                                System.out.println("=========================================================");
                                System.out.println("--------------Informe de disponibilidad------------------");
                                System.out.println("-------------------------------");
                                System.out.println("LOCALIDAD 1: \n");
                                System.out.println("Se han vendido " + bol_local1 + ".");
                                System.out.println("Se cuentan con " + localidad1.getDisponibilidad() + " espacios disponibles."); 
                                System.out.println("-------------------------------");
                                System.out.println("=========================================================");
                                break;
                            
                            //Informe de localidad 2
                            case 2:
                                System.out.println("=========================================================");
                                System.out.println("--------------Informe de disponibilidad------------------");
                                System.out.println("-------------------------------");
                                System.out.println("LOCALIDAD 2: \n");
                                System.out.println("Se han vendido " + bol_local2 + ".");
                                System.out.println("Se cuentan con " + localidad2.getDisponibilidad() + " espacios disponibles.");
                                System.out.println("-------------------------------");
                                System.out.println("=========================================================");
                                break;
                            
                            //Informe de localidad 3
                            case 3:
                                System.out.println("=========================================================");
                                System.out.println("--------------Informe de disponibilidad------------------");
                                System.out.println("-------------------------------");
                                System.out.println("LOCALIDAD 3: \n");
                                System.out.println("Se han vendido " + bol_local3 + ".");
                                System.out.println("Se cuentan con " + localidad3.getDisponibilidad() + " espacios disponibles.");
                                System.out.println("-------------------------------");
                                System.out.println("=========================================================");
                                break;  
                        }
                        break;

                case 5:
                    //Se muestra el reporte total de ventas
                    System.out.println("=========================================================");
                    System.out.println("--------------------Reporte de Ventas--------------------");
                    System.out.println("-------------------------------");
                    System.out.println("Se han generado $" + ventas_totales + ".");
                    System.out.println("-------------------------------");
                    System.out.println("=========================================================");
                    break;
                
                //Mensaje a mostrar previo a salir del programa
                case 6:
                    System.out.println("Saliendo del sistema, que tenga un buen día.");
                    System.exit(0);
                    break;
                
                //Mensaje a mostrar en caso de no colocar ninguna de las opciones dentro del menú
                default:
                    System.out.println("Por favor, colocar una opción adecuada.\n");
                    break;

}
}
}
}



