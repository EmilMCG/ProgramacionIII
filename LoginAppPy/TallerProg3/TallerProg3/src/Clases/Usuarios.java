/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author 
 */
public class Usuarios {

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
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the username
     */
    public String getUser() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUser(String username) {
        this.username = username;
    }

    /**
     * @return the contraseña
     */
    public String getclave() {
        return clave;
    }

    /**
     * @param clave the contraseña to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }
    
    /**
     * @param rol el rol del usuario
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuarios(String nombre, String apellido, String email, String user, String password, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.username = user;
        this.clave = password;
        this.rol = rol;
        Conector con = new Conector();
        conexion = con.getConexion();
    }
    
    public Usuarios() {
        Conector con = new Conector();
        conexion = con.getConexion();
    }
    
    public Usuarios validarUsuario(String user, String password) {
        Usuarios usern = null;
        String sql = "SELECT * FROM usuario WHERE username = ? AND clave = ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usern = new Usuarios();
                usern.setNombre(rs.getString("nombre"));
                usern.setApellido(rs.getString("apellido"));
                usern.setEmail(rs.getString("email"));
                usern.setUser(rs.getString("user"));
                usern.setClave(rs.getString("password"));
                usern.setRol(rs.getString("rol"));
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al validar usuario: " + e.getMessage());
        }

        return usern;
    }

    public boolean registrarUsuario(String nombre, String apellido, String email, String username, String clave, String rol) {
        String sql = "INSERT INTO usuario (nombre, apellido, email, username, clave, rol) VALUES (?, ?, ?, ?, ?, ?)";
        boolean registrado = false;

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, email);
            ps.setString(4, username);
            ps.setString(5, clave);
            ps.setString(6, rol);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                registrado = true;
                System.out.println("Usuario agregado correctamente.");
            }

            ps.close();
        } catch (Exception e) {
            System.out.println("Error al agregar el usuario: " + e.getMessage());
        }

        return registrado;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
  
    private String nombre;
    private String apellido;
    private String email;
    private String username;
    private String clave;
    private String rol;
    private Connection conexion;
      
}


