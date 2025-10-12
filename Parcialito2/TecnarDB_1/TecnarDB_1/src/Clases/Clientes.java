/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Clases.Conector;
import java.sql.*;

/**
 *
 * @author afterlife
 */
public class Clientes {

    String nombre;
    String apellido;
    String direccion;
    String telefono;
    String email;

    public Clientes() {
    }

    public Clientes(String nombre, String apellido, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public ResultSet listarClientes() {
        Conector db = new Conector();
        ResultSet rs = null;

        try {
            db.conectar();
            String query = "SELECT * FROM clientes";
            rs = db.executeSelect(query);
        } catch (Exception e) {
            System.err.println("Error al listar los clientes Metodo: " + e.getMessage());
        }
        return rs;
    }

    // Método para insertar un nuevo cliente en la base de datos
    public int guardarCliente(String nombre, String apellido, String direccion, String email, String telefono) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "INSERT INTO clientes (nombre, apellido, direccion, email, telefono) VALUES (?, ?, ?, ?, ?)";
        return db.executeUpdate(query, nombre, apellido, direccion, email, telefono);
    }

    // Método para actualizar un cliente existente en la base de datos
    public int actualizarCliente(int id, String nombre, String apellido, String direccion, String email, String telefono) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "UPDATE clientes SET nombre = ?, apellido = ?, direccion = ?, telefono = ?, email = ? WHERE id = ?";
        return db.executeUpdate(query, nombre, apellido, direccion, telefono, email, id);
    }

    // Método para eliminar un cliente de la base de datos
    public int eliminarCliente(int id) throws SQLException {
        Conector db = new Conector();
        db.conectar();
        String query = "DELETE FROM clientes WHERE id = ?";
        return db.executeUpdate(query, id);
    }
}
