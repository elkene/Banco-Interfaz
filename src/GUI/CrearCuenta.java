package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import banco.Cuenta;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class CrearCuenta extends JDialog {
    private static final long serialVersionUID = 7861332459242048150L; // Serial para la serialización.
    private JTextField noCuenta; // Campo para ingresar el número de cuenta.
    private JComboBox<String> tipocuenta; // ComboBox para seleccionar el tipo de cuenta.
    private JTextField saldoField; // Campo para ingresar saldo personalizado.
    private Cuenta cuentaCreada; // Objeto para almacenar la cuenta creada.

    // Constructor de la clase CrearCuenta.
    public CrearCuenta(String usuario) {
        setTitle("Crear Cuenta"); // Establece el título del diálogo.

        setModal(true); // Hace que el diálogo sea modal.
        setBounds(100, 100, 450, 300); // Establece la posición y el tamaño del diálogo.
        getContentPane().setLayout(new BorderLayout()); // Establece el layout del contenido del diálogo.
        
        JPanel contentPanel = new JPanel(); // Panel para el contenido del diálogo.
        contentPanel.setBackground(SystemColor.activeCaption); // Establece el color de fondo.
        contentPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null)); // Establece un borde en el panel.
        getContentPane().add(contentPanel, BorderLayout.CENTER); // Agrega el panel al contenido del diálogo.
        contentPanel.setLayout(null); // Establece el layout del panel como nulo.

        // Campo de texto para el número de cuenta.
        noCuenta = new JTextField();
        noCuenta.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 13)); // Establece la fuente.
        noCuenta.setBounds(121, 39, 96, 19); // Establece la posición del campo.
        contentPanel.add(noCuenta);
        noCuenta.setColumns(10); // Establece el número de columnas.

        // Etiqueta para el número de cuenta.
        JLabel lblNewLabel = new JLabel("No. Cuenta");
        lblNewLabel.setBounds(10, 40, 101, 13); // Establece la posición de la etiqueta.
        lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15)); // Establece la fuente.
        contentPanel.add(lblNewLabel);

        // Etiqueta para el tipo de cuenta.
        JLabel lblTipo = new JLabel("Tipo");
        lblTipo.setBounds(10, 80, 101, 13); // Establece la posición de la etiqueta.
        lblTipo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15)); // Establece la fuente.
        contentPanel.add(lblTipo);

        // ComboBox para seleccionar el tipo de cuenta.
        tipocuenta = new JComboBox<>();
        tipocuenta.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 13)); // Establece la fuente.
        tipocuenta.setBounds(121, 78, 96, 21); // Establece la posición del comboBox.
        tipocuenta.setModel(new DefaultComboBoxModel<>(new String[]{"", "Ahorro", "Cheques"})); // Establece los tipos de cuenta disponibles.
        tipocuenta.setSelectedIndex(0); // Establece el índice seleccionado por defecto.
        contentPanel.add(tipocuenta);

        // Etiqueta para el saldo.
        JLabel lblSaldo = new JLabel("Saldo");
        lblSaldo.setBounds(10, 120, 101, 13); // Establece la posición de la etiqueta.
        lblSaldo.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15)); // Establece la fuente.
        contentPanel.add(lblSaldo);

        // Campo de texto para el saldo.
        saldoField = new JTextField();
        saldoField.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 13)); // Establece la fuente.
        saldoField.setBounds(121, 120, 96, 19); // Establece la posición del campo.
        contentPanel.add(saldoField);
        saldoField.setColumns(10); // Establece el número de columnas.

        // Etiqueta que indica que se debe ingresar el saldo.
        JLabel lblPersonalizado = new JLabel("(Ingrese saldo)");
        lblPersonalizado.setBounds(230, 120, 100, 13); // Establece la posición de la etiqueta.
        lblPersonalizado.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 12)); // Establece la fuente.
        contentPanel.add(lblPersonalizado);

        // Etiqueta que muestra el nombre del cliente.
        JLabel lblNewLabel_1 = new JLabel("Cliente: " + usuario);
        lblNewLabel_1.setForeground(SystemColor.desktop); // Establece el color del texto.
        lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15)); // Establece la fuente.
        lblNewLabel_1.setBackground(Color.WHITE);
        lblNewLabel_1.setBounds(0, 213, 436, 13); // Establece la posición de la etiqueta.
        contentPanel.add(lblNewLabel_1);

        // Panel para los botones en la parte inferior.
        JPanel buttonPane = new JPanel();
        buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null)); // Establece un borde en el panel de botones.
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Establece el layout del panel de botones.
        getContentPane().add(buttonPane, BorderLayout.SOUTH); // Agrega el panel de botones al contenido del diálogo.

        // Botón "OK" para crear la cuenta.
        JButton okButton = new JButton("OK");
        okButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12)); // Establece la fuente.
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearCuenta(); // Llama al método para crear la cuenta al hacer clic en "OK".
            }
        });
        okButton.setActionCommand("OK");
        buttonPane.add(okButton); // Agrega el botón "OK" al panel de botones.
        getRootPane().setDefaultButton(okButton); // Establece el botón "OK" como el botón predeterminado.

        // Botón "Cancel" para cerrar el diálogo.
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12)); // Establece la fuente.
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el diálogo al hacer clic en "Cancel".
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton); // Agrega el botón "Cancel" al panel de botones.

        // Validaciones de campo vacío y acción de la tecla Enter.
        noCuenta.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                validarCampos(); // Valida los campos al liberar la tecla.
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    crearCuenta(); // Crea la cuenta si se presiona Enter.
                }
            }
        });

        saldoField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                validarCampos(); // Valida los campos al liberar la tecla.
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    crearCuenta(); // Crea la cuenta si se presiona Enter.
                }
            }
        });

        // Permitir solo la entrada de números en el campo de saldo.
        saldoField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Permitir solo dígitos y el punto decimal.
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == '.')) {
                    e.consume(); // Evita que se ingrese el carácter no permitido.
                }
            }
        });
    }

    // Método para crear la cuenta.
    private void crearCuenta() {
        String NCuenta = noCuenta.getText(); // Obtiene el número de cuenta.
        String TCuenta = (String) tipocuenta.getSelectedItem(); // Obtiene el tipo de cuenta.

        // Verifica que todos los campos estén completos.
        if (NCuenta.isEmpty() || TCuenta.isEmpty() || saldoField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(noCuenta, "Todos los campos deben estar completos."); // Muestra mensaje de error si algún campo está vacío.
            return;
        }

        float cantidad = 0f; // Variable para el saldo.
        try {
            cantidad = Float.parseFloat(saldoField.getText()); // Intenta convertir el saldo a float.
            if (cantidad < 0) {
                JOptionPane.showMessageDialog(saldoField, "El saldo no puede ser negativo."); // Muestra mensaje de error si el saldo es negativo.
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(saldoField, "Saldo no válido. Ingrese un número."); // Muestra mensaje de error si el saldo no es un número.
            return;
        }

        // Crea la cuenta.
        cuentaCreada = new Cuenta();
        cuentaCreada.setNodeCuenta(NCuenta);
        cuentaCreada.setTipodeCuenta(TCuenta);
        cuentaCreada.setSaldo(cantidad);
        JOptionPane.showMessageDialog(noCuenta, "Cuenta Creada"); // Muestra mensaje de éxito al crear la cuenta.
        dispose(); // Cierra el diálogo.
    }

    // Método para validar si los campos están llenos.
    private void validarCampos() {
        boolean camposLlenos = !noCuenta.getText().isEmpty() && !tipocuenta.getSelectedItem().equals("") &&
                !saldoField.getText().isEmpty();
        
        getRootPane().getDefaultButton().setEnabled(camposLlenos); // Habilita el botón "OK" si todos los campos están llenos.
    }

    // Método para obtener la cuenta creada.
    public Cuenta getCuentaCreada() {
        return cuentaCreada; // Devuelve la cuenta creada.
    }
}