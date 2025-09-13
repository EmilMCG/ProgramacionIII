/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.time.LocalDate;


/**
 *
 * @author Emil
 */
public class Animales {
      private String nombre;
    private int peso;
    private String propietario;
    private LocalDate fecha_cumpleaños;
    private LocalDate fecha_ultima_vacuna;
    
    public Animales(String nombre, int peso, String propietario, LocalDate fecha_cumpleaños, LocalDate fecha_ultima_vacuna){
        this.nombre = nombre;
        this.peso = peso;
        this.propietario = propietario;
        this.fecha_cumpleaños = fecha_cumpleaños;
        this.fecha_ultima_vacuna = fecha_ultima_vacuna;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }
     /**
     * @return the propietario
     */
    public String getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    /**
     * @return the fecha_cumpleaños
     */
    public LocalDate getFecha_cumpleaños() {
        return fecha_cumpleaños;
    }

    /**
     * @param fecha_cumpleaños the fecha_cumpleaños to set
     */
    public void setFecha_cumpleaños(LocalDate fecha_cumpleaños) {
        this.fecha_cumpleaños = fecha_cumpleaños;
    }

    /**
     * @return the fecha_ultima_vacuna
     */
    public LocalDate getFecha_ultima_vacuna() {
        return fecha_ultima_vacuna;
    }

    /**
     * @param fecha_ultima_vacuna the fecha_ultima_vacuna to set
     */
    public void setFecha_ultima_vacuna(LocalDate fecha_ultima_vacuna) {
        this.fecha_ultima_vacuna = fecha_ultima_vacuna;
    }
    
}
