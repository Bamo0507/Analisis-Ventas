//Bryan Alberto Martínez Orellana
//Carnét 23542
//Ingeniería en Ciencias de la Computación
//Programación Orientada a Objetos
//Creación: 11/08/2023
//Última modificación: 12/08/2023

public class Localidad {

    private int disponibilidad = 20;
    private float costo;

    //Se modifica la disponibilidad de la localidad
    public void setDisponibilidad(int disponibilidad){
        this.disponibilidad = disponibilidad;
    }

    //Se obtiene la disponibilidad de la localidad
    public int getDisponibilidad() {
        return this.disponibilidad;
    }

    //Colocamos el costo para la localidad
    public void setCosto(float costo){
        this.costo = costo;   
    }   

    //Obtenemos el costo de la localidad
    public float getCosto() {
        return this.costo;
    }

}
