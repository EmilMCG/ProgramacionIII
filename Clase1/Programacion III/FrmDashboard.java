package Formularios;

import javax.swing.*;
import java.awt.*;
import Usuarios;

public class FrmDashboard extends JFrame {
    public FrmDashboard(Usuarios u) {
        setTitle("Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel lblBienvenida = new JLabel("Bienvenido " + u.getNombre() + " " + u.getApellidos(), JLabel.CENTER);
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 16));

        JLabel lblImagen = new JLabel(new ImageIcon("usuario.png"));
        lblImagen.setHorizontalAlignment(JLabel.CENTER);

        add(lblBienvenida, BorderLayout.NORTH);
        add(lblImagen, BorderLayout.CENTER);
    }
}