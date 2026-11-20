package xdany01.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

public class MainFrame extends JFrame {

    private JPanel mainPanel;
    private JPanel titlePanel;
    private JTextField userField;
    private JTextField passwordField;
    private JButton iniciarSesionButton;
    private JLabel passwordLabel;
    private JLabel userLabel;
    private JLabel titleLogin;

    public MainFrame() {
        init();
        iniciarSesionButton.addActionListener(e -> {
            validateInput();
        });
    }

    private void init() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setMinimumSize(new Dimension(600, 500));
        setLocationRelativeTo(null);

        var iconPath = Path.of("src", "main", "java", "xdany01", "assets", "icon.png").toString();
        setIconImage(toolkit.getImage(iconPath));

//        var dimension = toolkit.getScreenSize();
//        IO.println("Dimension: " + dimension.width + "x" + dimension.height);
    }

    private void validateInput() {
        String username = userField.getText();
        String password = passwordField.getText();

        if (username.equals("root") || password.equals("admin")) {
            showMessage("Datos correctos, bienvenido!");
        } else {
            showMessage("El usuario o la contraseña es incorrecto!");
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
