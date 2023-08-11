import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class PrestamoCRUDFrame extends JFrame {
    private JTextField usuarioIDField;
    private JTextField libroIDField;
    private JTextField fechaPrestamoField;
    private JTextField fechaDevolucionField;

    private PrestamoDAO prestamoDAO;

    public PrestamoCRUDFrame() {
        prestamoDAO = new PrestamoDAO();

        setTitle("Préstamo CRUD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel usuarioIDLabel = new JLabel("Usuario ID:");
        usuarioIDField = new JTextField();

        JLabel libroIDLabel = new JLabel("Libro ID:");
        libroIDField = new JTextField();

        JLabel fechaPrestamoLabel = new JLabel("Fecha Préstamo (yyyy-mm-dd):");
        fechaPrestamoField = new JTextField();

        JLabel fechaDevolucionLabel = new JLabel("Fecha Devolución (yyyy-mm-dd):");
        fechaDevolucionField = new JTextField();

        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int usuarioID = Integer.parseInt(usuarioIDField.getText());
                int libroID = Integer.parseInt(libroIDField.getText());
                Date fechaPrestamo = java.sql.Date.valueOf(fechaPrestamoField.getText());
                Date fechaDevolucion = java.sql.Date.valueOf(fechaDevolucionField.getText());

                Prestamo prestamo = new Prestamo(0, usuarioID, libroID, fechaPrestamo, fechaDevolucion);
                prestamoDAO.insertPrestamo(prestamo);

                JOptionPane.showMessageDialog(PrestamoCRUDFrame.this, "Préstamo agregado exitosamente.");
            }
        });

        panel.add(usuarioIDLabel);
        panel.add(usuarioIDField);
        panel.add(libroIDLabel);
        panel.add(libroIDField);
        panel.add(fechaPrestamoLabel);
        panel.add(fechaPrestamoField);
        panel.add(fechaDevolucionLabel);
        panel.add(fechaDevolucionField);
        panel.add(addButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PrestamoCRUDFrame().setVisible(true);
            }
        });
    }
}
