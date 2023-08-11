import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoriaCRUDFrame extends JFrame {
    private JTextField nombreCatField;

    private CategoriaDAO categoriaDAO;

    public CategoriaCRUDFrame() {
        categoriaDAO = new CategoriaDAO();

        setTitle("Categoría CRUD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JLabel nombreCatLabel = new JLabel("Nombre:");
        nombreCatField = new JTextField();

        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreCatField.getText();
                Categoria categoria = new Categoria(0, nombre);
                categoriaDAO.insertCategoria(categoria);

                JOptionPane.showMessageDialog(CategoriaCRUDFrame.this, "Categoría agregada exitosamente.");
            }
        });

        panel.add(nombreCatLabel);
        panel.add(nombreCatField);
        panel.add(addButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CategoriaCRUDFrame().setVisible(true);
            }
        });
    }
}
