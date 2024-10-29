package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import java.awt.SystemColor;

public class Login extends JDialog {
    private static final long serialVersionUID = 1L; // Identificador único de la clase para la serialización
    private final JPanel contentPanel = new JPanel(); // Panel principal que contiene los elementos del diálogo
    private JTextField textField; // Campo de texto para el nombre de usuario
    private JPasswordField passwordField; // Campo de texto para la contraseña

    // Método principal que inicia la aplicación
    public static void main(String[] args) {
        try {
            // Establece el look and feel del UI, puede cambiarse por otro tema
            UIManager.setLookAndFeel(new AcrylLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace(); // Imprime la excepción en caso de error
        }

        try {
            // Crea una instancia del diálogo de Login
            Login dialog = new Login();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Cierra el diálogo al finalizar
            dialog.setVisible(true); // Hace visible el diálogo
        } catch (Exception e) {
            e.printStackTrace(); // Imprime la excepción en caso de error
        }
    }

    // Constructor de la clase Login
    public Login() {
        setTitle("Login"); // Establece el título del diálogo
        setModal(true); // Hace que el diálogo sea modal
        setBounds(100, 100, 450, 300); // Define el tamaño y posición del diálogo
        getContentPane().setLayout(new BorderLayout()); // Establece el layout del contenedor principal
        contentPanel.setBackground(SystemColor.activeCaption); // Establece el color de fondo del panel
        contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null)); // Establece un borde al panel
        getContentPane().add(contentPanel, BorderLayout.CENTER); // Añade el panel al contenedor central
        contentPanel.setLayout(null); // Establece el layout a null para posicionar componentes manualmente
        
        JPanel panel = new JPanel(); // Crea un panel para los campos de usuario y contraseña
        panel.setBounds(67, 57, 298, 146); // Establece las dimensiones y posición del panel
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true)); // Establece un borde al panel
        contentPanel.add(panel); // Añade el panel al contentPanel
        panel.setLayout(null); // Establece el layout a null para posicionar componentes manualmente
        
        // Etiqueta para el campo de usuario
        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(21, 32, 61, 13); // Establece la posición y dimensiones de la etiqueta
        lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13)); // Establece la fuente de la etiqueta
        panel.add(lblUsuario); // Añade la etiqueta al panel
        
        // Etiqueta para el campo de contraseña
        JLabel lblClave = new JLabel("Clave");
        lblClave.setBounds(21, 92, 61, 13); // Establece la posición y dimensiones de la etiqueta
        lblClave.setFont(new Font("Tahoma", Font.BOLD, 13)); // Establece la fuente de la etiqueta
        panel.add(lblClave); // Añade la etiqueta al panel
        
        textField = new JTextField(); // Inicializa el campo de texto para el usuario
        textField.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 13)); // Establece la fuente del campo de texto
        textField.setBounds(92, 30, 96, 19); // Establece la posición y dimensiones del campo de texto
        setMaxLength(textField, 7); // Limita la longitud máxima a 7 caracteres
        textField.setColumns(10); // Establece el número de columnas del campo de texto
        panel.add(textField); // Añade el campo de texto al panel
        
        passwordField = new JPasswordField(); // Inicializa el campo de texto para la contraseña
        passwordField.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 13)); // Establece la fuente del campo de texto
        passwordField.setBounds(92, 90, 96, 19); // Establece la posición y dimensiones del campo de texto
        setMaxLength(passwordField, 7); // Limita la longitud máxima a 7 caracteres
        panel.add(passwordField); // Añade el campo de texto al panel
        
        // Etiqueta para el título del banco
        JLabel lblTitulo = new JLabel("Bank Of America");
        lblTitulo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 32)); // Establece la fuente del título
        lblTitulo.setBounds(108, 10, 202, 52); // Establece la posición y dimensiones de la etiqueta
        contentPanel.add(lblTitulo); // Añade la etiqueta al panel principal
        
        // Etiqueta de bienvenida
        JLabel lblBienvenida = new JLabel("Bienvenido a nuestro banco, inicia sesion");
        lblBienvenida.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 25)); // Establece la fuente de la etiqueta
        lblBienvenida.setBounds(20, 200, 416, 52); // Establece la posición y dimensiones de la etiqueta
        contentPanel.add(lblBienvenida); // Añade la etiqueta al panel principal

        JPanel buttonPane = new JPanel(); // Crea un panel para los botones
        getContentPane().add(buttonPane, BorderLayout.SOUTH); // Añade el panel de botones al contenedor inferior
        buttonPane.setLayout(null); // Establece el layout a null para posicionar componentes manualmente

        JButton okButton = new JButton("OK"); // Crea un botón "OK"
        okButton.setBounds(318, 5, 45, 21); // Establece la posición y dimensiones del botón
        okButton.addActionListener(e -> aceptar()); // Asigna una acción al botón que llama al método aceptar()
        okButton.setActionCommand("OK"); // Establece el comando de acción del botón
        buttonPane.add(okButton); // Añade el botón al panel de botones
        getRootPane().setDefaultButton(okButton); // Establece el botón "OK" como el botón por defecto

        JButton cancelButton = new JButton("Cancel"); // Crea un botón "Cancel"
        cancelButton.setBounds(368, 5, 63, 21); // Establece la posición y dimensiones del botón
        cancelButton.addActionListener(e -> dispose()); // Asigna una acción que cierra el diálogo
        buttonPane.add(cancelButton); // Añade el botón al panel de botones
        cancelButton.setActionCommand("Cancel"); // Establece el comando de acción del botón

        // Agregar KeyListeners a los campos para que validen al presionar Enter
        KeyAdapter keyAdapter = new KeyAdapter() {
            public void keyPressed(KeyEvent e) { // Método que se ejecuta al presionar una tecla
                if (e.getKeyCode() == KeyEvent.VK_ENTER) { // Verifica si la tecla presionada es Enter
                    aceptar(); // Llama al método aceptar()
                }
            }
        };

        textField.addKeyListener(keyAdapter); // Añade el KeyListener al campo de usuario
        passwordField.addKeyListener(keyAdapter); // Añade el KeyListener al campo de contraseña
    }

    // Método que se ejecuta al presionar el botón "OK"
    private void aceptar() {
        String usuario = textField.getText(); // Obtiene el texto del campo de usuario
        String clave = new String(passwordField.getPassword()); // Obtiene la contraseña

        // Verifica si los campos están vacíos
        if (usuario.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(contentPanel, "Favor de ingresar el usuario y clave"); // Mensaje de error
        } else if (usuario.equals("Kenneth") && clave.equals("Armenta")) { // Verifica las credenciales
            JOptionPane.showMessageDialog(contentPanel, "Bienvenido!!"); // Mensaje de bienvenida
            dispose(); // Cierra el diálogo
            Menu menu = new Menu(usuario); // Crea una instancia del menú
            menu.setVisible(true); // Hace visible el menú
        } else {
            JOptionPane.showMessageDialog(contentPanel, "Usuario o clave incorrectos"); // Mensaje de error
        }
    }

    // Método para establecer la longitud máxima de caracteres en un campo de contraseña
    private void setMaxLength(JPasswordField passwordField, int maxLength) {
        AbstractDocument document = (AbstractDocument) passwordField.getDocument(); // Obtiene el documento del campo
        document.setDocumentFilter(new DocumentFilter() {
            public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
                if (fb.getDocument().getLength() - length + text.length() <= maxLength) {
                    super.replace(fb, offset, length, text, attrs); // Permite la operación si no supera el máximo
                }
            }

            public void insertString(FilterBypass fb, int offset, String text, javax.swing.text.AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + text.length() <= maxLength) {
                    super.insertString(fb, offset, text, attr); // Permite la operación si no supera el máximo
                }
            }
        });
    }

    // Método para establecer la longitud máxima de caracteres en un campo de texto
    private void setMaxLength(JTextField textField, int maxLength) {
        AbstractDocument document = (AbstractDocument) textField.getDocument(); // Obtiene el documento del campo
        document.setDocumentFilter(new DocumentFilter() {
            public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs) throws BadLocationException {
                if (fb.getDocument().getLength() - length + text.length() <= maxLength) {
                    super.replace(fb, offset, length, text, attrs); // Permite la operación si no supera el máximo
                }
            }

            public void insertString(FilterBypass fb, int offset, String text, javax.swing.text.AttributeSet attr) throws BadLocationException {
                if (fb.getDocument().getLength() + text.length() <= maxLength) {
                    super.insertString(fb, offset, text, attr); // Permite la operación si no supera el máximo
                }
            }
        });
    }
}
