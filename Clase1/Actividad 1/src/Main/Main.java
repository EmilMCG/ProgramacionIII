/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Clases.Animales;
import java.time.LocalDate;

/**
 *
 * @author Emil
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        LocalDate Fecha_cumpleaños = LocalDate.of(2020, 1, 20); 
        LocalDate Fecha_ultima_vacuna = LocalDate.of(2022, 1, 20); 
        
        Animales A = new Animales("Chifu", 10, "Emil Mateo", Fecha_cumpleaños, Fecha_ultima_vacuna);
        
        String nombreAnimal = A.getNombre();
        int pesoAnimal = A.getPeso();
        String propietarioAnimal = A.getPropietario();
        LocalDate cumpleAnimal = A.getFecha_cumpleaños();
        LocalDate vacunaAnimal = A.getFecha_ultima_vacuna();
        
        System.out.println("El nombre del animal es: " + nombreAnimal);
        System.out.println("Su peso es: " + pesoAnimal);
        System.out.println("El propietario es: " + propietarioAnimal);
        System.out.println("Su fecha de cumpleaños es: " + cumpleAnimal);
        System.out.println("Su fecha de vacunación es: " + vacunaAnimal);
    }
}
