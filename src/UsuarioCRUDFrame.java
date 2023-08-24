import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioCRUDFrame extends JFrame {
    private JTextField nombreUsuarioField;
    private JTextField direccionUsuarioField;
    private JTextField identificacionUsuarioField;

    private UsuarioDAO usuarioDAO;

    public UsuarioCRUDFrame() {
        usuarioDAO = new UsuarioDAO();

        setTitle("Usuario CRUD (A)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel nombreUsuarioLabel = new JLabel("Nombre:");
        nombreUsuarioField = new JTextField();

        JLabel direccionUsuarioLabel = new JLabel("Dirección:");
        direccionUsuarioField = new JTextField();

        JLabel identificacionUsuarioLabel = new JLabel("Identificación:");
        identificacionUsuarioField = new JTextField();

        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreUsuarioField.getText();
                String direccion = direccionUsuarioField.getText();
                String identificacion = identificacionUsuarioField.getText();

                Usuario usuario = new Usuario(0, nombre, direccion, identificacion);
                usuarioDAO.insertUsuario(usuario);

                JOptionPane.showMessageDialog(UsuarioCRUDFrame.this, "Usuario agregado exitosamente.");
            }
        });

        panel.add(nombreUsuarioLabel);
        panel.add(nombreUsuarioField);
        panel.add(direccionUsuarioLabel);
        panel.add(direccionUsuarioField);
        panel.add(identificacionUsuarioLabel);
        panel.add(identificacionUsuarioField);
        panel.add(addButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UsuarioCRUDFrame().setVisible(true);
            }
        });
    }
}
