import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorialCRUDFrame extends JFrame {
    private JTextField libroIDField;
    private JTextField direccionEditorialField;
    private JTextField ciudadEditorialField;
    private JTextField paisEditorialField;

    private EditorialDAO editorialDAO;

    public EditorialCRUDFrame() {
        editorialDAO = new EditorialDAO();

        setTitle("Editorial CRUD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel libroIDLabel = new JLabel("Libro ID:");
        libroIDField = new JTextField();

        JLabel direccionEditorialLabel = new JLabel("Dirección:");
        direccionEditorialField = new JTextField();

        JLabel ciudadEditorialLabel = new JLabel("Ciudad:");
        ciudadEditorialField = new JTextField();

        JLabel paisEditorialLabel = new JLabel("País:");
        paisEditorialField = new JTextField();

        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int libroID = Integer.parseInt(libroIDField.getText());
                String direccion = direccionEditorialField.getText();
                String ciudad = ciudadEditorialField.getText();
                String pais = paisEditorialField.getText();

                Editorial editorial = new Editorial(0, libroID, direccion, ciudad, pais);
                editorialDAO.insertEditorial(editorial);

                JOptionPane.showMessageDialog(EditorialCRUDFrame.this, "Editorial agregada exitosamente.");
            }
        });

        panel.add(libroIDLabel);
        panel.add(libroIDField);
        panel.add(direccionEditorialLabel);
        panel.add(direccionEditorialField);
        panel.add(ciudadEditorialLabel);
        panel.add(ciudadEditorialField);
        panel.add(paisEditorialLabel);
        panel.add(paisEditorialField);
        panel.add(addButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EditorialCRUDFrame().setVisible(true);
            }
        });
    }
}
