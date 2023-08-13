//Bryan Alberto Martínez Orellana
//Carnét 23542
//Ingeniería en Ciencias de la Computación
//Programación Orientada a Objetos
//Creación: 11/08/2023
//Última modificación: 12/08/2023

import java.util.Random;

public class Aleatorio {
    private Random alazar = new Random();
    private String localidad;
    private int num_local;
    private String aprobado;
    private int num1;
    private int num2;
    private int num3;

    //De manera aleatoria establecemos la localidad que se le ofrecerá al comprador
    public void Calcular_localidad(){
        num1 = alazar.nextInt(3-1+1)+1;
        //Dependiendo de la localidad obtenida, se le mostrará la siguiente información y se definirán los valores de las variables num_local y localidad
        switch(num1) {
            case 1: 
                num_local = 1;
                System.out.println("Le ha tocado:");
                localidad = "Localidad 1 - la más alejada con un precio de $100.\n";
                System.out.println(localidad);
                break;
            case 2:
                num_local = 2;
                System.out.println("Le ha tocado:");
                localidad = "Localidad 2 - en medio con un precio de $500.\n";
                System.out.println(localidad);
                break;
            case 3:
                num_local = 3;
                System.out.println("Le ha tocado:");
                localidad = "Localidad 3 - hasta adelante con un precio de  $1000.\n";
                System.out.println(localidad);
                break;
        }
    }

    //Se aprueba el derecho de compra de manera aleatoria
    public void Aprobar(){
        num1 = alazar.nextInt(15000-1+1)+1;
        num2 = alazar.nextInt(15000-1+1)+1;
        num3 = alazar.nextInt(15000-1+1)+1;

        //Mensajes a mostrar en caso de que sea válido
        if (num2 <= num1 && num1 <= num3){
            aprobado = "Yes";
            System.out.println("Se verificará si es apto para la compra. ");
            System.out.println("=========================================================");
        }
        else if (num3 <= num1 && num1 <= num2){
            aprobado = "Yes";
            System.out.println("Se verificará si es apto para la compra. ");
            System.out.println("=========================================================");
        }

        //Mensaje a mostrar en caso de que no se haga válida la compra
        else {
            aprobado = "No";
            System.out.println("Lamentablemente no ha conseguido el derecho de compra :( ");
            System.out.println("=========================================================");
        }

    }

    //Se obtiene si fue aprobada o no la compra
    public String getAprobado(){
        return aprobado;
    }

    //Se obtiene el néro de localidad asignado
    public int getNumLocal(){
        return num_local;
    }


}
