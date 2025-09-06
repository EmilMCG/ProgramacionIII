package Formularios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Usuarios;
import RepositorioUsuarios;

public class FrmRegUser extends JFrame {
    private JTextField txtNombre, txtApellidos, txtEmail, txtNickname;
    private JPasswordField txtClave;
    private JButton btnGuardar;

    public FrmRegUser() {
        setTitle("Registrar Usuario");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        txtNombre = new JTextField();
        txtApellidos = new JTextField();
        txtEmail = new JTextField();
        txtNickname = new JTextField();
        txtClave = new JPasswordField();
        btnGuardar = new JButton("Guardar");

        add(new JLabel("Nombre:"));
        add(txtNombre);
        add(new JLabel("Apellidos:"));
        add(txtApellidos);
        add(new JLabel("Email:"));
        add(txtEmail);
        add(new JLabel("Nickname:"));
        add(txtNickname);
        add(new JLabel("Clave:"));
        add(txtClave);
        add(new JLabel(""));
        add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Usuarios nuevo = new Usuarios(
                    txtNombre.getText(),
                    txtApellidos.getText(),
                    txtEmail.getText(),
                    txtNickname.getText(),
                    new String(txtClave.getPassword())
                );
                RepositorioUsuarios.guardarUsuario(nuevo);
                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
                dispose();
            }
        });
    }
}