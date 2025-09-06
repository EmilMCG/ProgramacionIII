package Formularios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import RepositorioUsuarios;
import Usuarios;

public class FrmLogin extends JFrame {
    private JTextField txtNickname;
    private JPasswordField txtClave;
    private JButton btnIngresar, btnRegistrar;

    public FrmLogin() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        txtNickname = new JTextField();
        txtClave = new JPasswordField();
        btnIngresar = new JButton("Ingresar");
        btnRegistrar = new JButton("Registrar");

        add(new JLabel("Nickname:"));
        add(txtNickname);
        add(new JLabel("Clave:"));
        add(txtClave);
        add(btnIngresar);
        add(btnRegistrar);

        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Usuarios u = RepositorioUsuarios.validarUsuario(
                        txtNickname.getText(),
                        new String(txtClave.getPassword())
                );
                if (u != null) {
                    JOptionPane.showMessageDialog(null, "Login exitoso");
                    new FrmDashboard(u).setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o clave incorrectos");
                }
            }
        });

        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FrmRegUser().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new FrmLogin().setVisible(true);
    }
}