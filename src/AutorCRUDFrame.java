import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutorCRUDFrame extends JFrame {
    private JTextField nombreField;
    private JTextField paisField;

    private AutorDAO autorDAO;

    public AutorCRUDFrame() {
        autorDAO = new AutorDAO();

        setTitle("Autor CRUD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField();

        JLabel paisLabel = new JLabel("País:");
        paisField = new JTextField();

        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String pais = paisField.getText();
                Autor autor = new Autor(0, nombre, pais);
                autorDAO.insertAutor(autor);

                JOptionPane.showMessageDialog(AutorCRUDFrame.this, "Autor agregado exitosamente.");
            }
        });

        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(paisLabel);
        panel.add(paisField);
        panel.add(addButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AutorCRUDFrame().setVisible(true);
            }
        });
    }
}
