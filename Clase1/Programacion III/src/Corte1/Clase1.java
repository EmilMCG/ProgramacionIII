/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Corte1;

/**
 *
 * @author User
 */
public class Clase1 {
    public static void main(String[] args) {
//llamado al constructor sin argumento
    Persona p = new Persona();

    p.setCedula(123456789);
    System.out.println("El valor asignado actual mente es:"+p.getCedula());
// llamado al constructor con argumento

    Persona p2 = new Persona (2632,"Emil");
    }
    
}
