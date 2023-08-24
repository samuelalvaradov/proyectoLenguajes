import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibroCRUDFrame extends JFrame {
    private JTextField autorIDField;
    private JTextField categoriaIDField;
    private JTextField tituloField;
    private JTextField añoField;

    private LibroDAO libroDAO;

    public LibroCRUDFrame() {
        libroDAO = new LibroDAO();

        setTitle("Libro CRUD (B)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel autorIDLabel = new JLabel("Autor ID:");
        autorIDField = new JTextField();

        JLabel categoriaIDLabel = new JLabel("Categoría ID:");
        categoriaIDField = new JTextField();

        JLabel tituloLabel = new JLabel("Título:");
        tituloField = new JTextField();

        JLabel añoLabel = new JLabel("Año:");
        añoField = new JTextField();

        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int autorID = Integer.parseInt(autorIDField.getText());
                int categoriaID = Integer.parseInt(categoriaIDField.getText());
                String titulo = tituloField.getText();
                int año = Integer.parseInt(añoField.getText());

                Libro libro = new Libro(0, autorID, categoriaID, titulo, año);
                libroDAO.insertLibro(libro);

                JOptionPane.showMessageDialog(LibroCRUDFrame.this, "Libro agregado exitosamente.");
            }
        });

        panel.add(autorIDLabel);
        panel.add(autorIDField);
        panel.add(categoriaIDLabel);
        panel.add(categoriaIDField);
        panel.add(tituloLabel);
        panel.add(tituloField);
        panel.add(añoLabel);
        panel.add(añoField);
        panel.add(addButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LibroCRUDFrame().setVisible(true);
            }
        });
    }
}
