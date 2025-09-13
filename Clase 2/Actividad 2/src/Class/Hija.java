/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author User
 */
public class Hija extends Padre {
int edad;

    public Hija(String nombre, int edad) {
        super(nombre); 
        this.edad = edad;
    }

    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad;
    }
}