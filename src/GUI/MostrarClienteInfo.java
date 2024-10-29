package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;

public class MostrarClienteInfo extends JDialog {
    private static final long serialVersionUID = 1L; // Serial para la serialización.
    private final JPanel contentPanel = new JPanel(); // Panel principal de la ventana.

    // Constructor de la clase MostrarClienteInfo.
    public MostrarClienteInfo() {
        setTitle("Informacion del Cliente"); // Establece el título del diálogo.
        setModal(true); // Hace que el diálogo sea modal (bloquea la ventana padre).
        setBounds(100, 100, 450, 300); // Establece la posición y el tamaño del diálogo.
        getContentPane().setLayout(new BorderLayout()); // Establece el layout del contenido del diálogo.

        // Configuración del panel de contenido.
        contentPanel.setBackground(SystemColor.activeCaption); // Establece el color de fondo.
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // Establece un borde vacío alrededor del panel.
        getContentPane().add(contentPanel, BorderLayout.CENTER); // Agrega el panel al contenido del diálogo.
        contentPanel.setLayout(null); // Establece el layout del panel como nulo (posicionamiento manual).

        // Etiqueta para mostrar la imagen del cliente.
        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setBounds(20, 22, 117, 109); // Establece el tamaño de la etiqueta.
        contentPanel.add(lblNewLabel);

        // Cargar y escalar la imagen del cliente.
        try {
            BufferedImage originalImage = ImageIO.read(MostrarClienteInfo.class.getResource("/Imagenes/usuario.jpg")); // Carga la imagen desde el recurso.
            Image scaledImage = originalImage.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH); // Escala la imagen.
            lblNewLabel.setIcon(new ImageIcon(scaledImage)); // Establece la imagen escalada como ícono de la etiqueta.

            // Etiqueta para mostrar el nombre del cliente.
            JLabel lblNewLabel_1 = new JLabel("Nombre del Cliente:");
            lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15)); // Establece la fuente.
            lblNewLabel_1.setBounds(147, 22, 117, 13); // Establece la posición de la etiqueta.
            contentPanel.add(lblNewLabel_1);

            // Etiqueta para mostrar el CURP del cliente.
            JLabel lblNewLabel_1_1 = new JLabel("CURP:");
            lblNewLabel_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
            lblNewLabel_1_1.setBounds(147, 50, 45, 13);
            contentPanel.add(lblNewLabel_1_1);

            // Etiqueta para mostrar la fecha de nacimiento del cliente.
            JLabel lblNewLabel_1_1_1 = new JLabel("Fecha de Nacimiento:");
            lblNewLabel_1_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
            lblNewLabel_1_1_1.setBounds(147, 79, 122, 13);
            contentPanel.add(lblNewLabel_1_1_1);

            // Etiqueta para mostrar el número de celular del cliente.
            JLabel lblNewLabel_1_1_1_1 = new JLabel("Celular:");
            lblNewLabel_1_1_1_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
            lblNewLabel_1_1_1_1.setBounds(147, 107, 45, 13);
            contentPanel.add(lblNewLabel_1_1_1_1);

            // Etiqueta para mostrar el nombre del cliente.
            JLabel lblNewLabel_2 = new JLabel("Kenneth Armenta");
            lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
            lblNewLabel_2.setBounds(263, 22, 104, 13);
            contentPanel.add(lblNewLabel_2);

            // Etiqueta para mostrar el CURP.
            JLabel lblNewLabel_3 = new JLabel("AEIK030618HSLRBNA9");
            lblNewLabel_3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
            lblNewLabel_3.setBounds(183, 51, 104, 13);
            contentPanel.add(lblNewLabel_3);

            // Etiqueta para mostrar la fecha de nacimiento.
            JLabel lblNewLabel_4 = new JLabel("18/06/2003");
            lblNewLabel_4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
            lblNewLabel_4.setBounds(269, 80, 63, 13);
            contentPanel.add(lblNewLabel_4);

            // Etiqueta para mostrar el número de celular.
            JLabel lblNewLabel_5 = new JLabel("6731148022");
            lblNewLabel_5.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
            lblNewLabel_5.setBounds(194, 108, 63, 13);
            contentPanel.add(lblNewLabel_5);
        } catch (IOException e) {
            e.printStackTrace(); // Imprime la traza de la excepción en caso de error.
            JOptionPane.showMessageDialog(this, "Error al cargar la imagen."); // Muestra un mensaje de error.
        }

        // Configuración del panel de botones en la parte inferior.
        JPanel buttonPane = new JPanel();
        buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null)); // Establece un borde en el panel de botones.
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Establece el layout del panel de botones.
        getContentPane().add(buttonPane, BorderLayout.SOUTH); // Agrega el panel de botones al contenido del diálogo.

        // Botón "OK" para cerrar el diálogo.
        JButton okButton = new JButton("OK");
        okButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 10));
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el diálogo al hacer clic en "OK".
            }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton); // Agrega el botón "OK" al panel de botones.
        getRootPane().setDefaultButton(okButton); // Establece el botón "OK" como el botón predeterminado.

        // Botón "Cancel" para cerrar el diálogo.
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 10));
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el diálogo al hacer clic en "Cancel".
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton); // Agrega el botón "Cancel" al panel de botones.
    }
}