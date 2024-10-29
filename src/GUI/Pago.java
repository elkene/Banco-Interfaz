package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import banco.Cuenta;

public class Pago extends JDialog {

    private static final long serialVersionUID = 1L; // Serial para la serialización.
    private final JPanel contentPanel = new JPanel(); // Panel principal para el contenido del diálogo.
    private JComboBox<String> servicioComboBox; // ComboBox para seleccionar el servicio.
    private JComboBox<String> cuentasComboBox; // ComboBox para seleccionar la cuenta.
    private JTextField montoField; // Campo de texto para ingresar el monto.
    private JTextField referenciaField; // Campo de texto para ingresar la referencia.
    private JLabel fechaLabel; // Etiqueta para mostrar la fecha actual.
    private ArrayList<Cuenta> cuentasExistentes; // Lista de cuentas existentes.

    public Pago(ArrayList<Cuenta> cuentas, String usuario) {
        this.cuentasExistentes = cuentas; // Inicializa la lista de cuentas.

        setTitle("Pago de Servicios"); // Establece el título del diálogo.
        setModal(true); // Hace que el diálogo sea modal.
        setBounds(100, 100, 500, 350); // Establece la posición y el tamaño del diálogo.
        getContentPane().setLayout(new BorderLayout()); // Establece el layout del contenido del diálogo.
        contentPanel.setBackground(SystemColor.activeCaption); // Establece el color de fondo del panel.
        contentPanel.setLayout(null); // Establece el layout del panel como nulo.
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // Establece un borde en el panel.
        getContentPane().add(contentPanel, BorderLayout.CENTER); // Agrega el panel al contenido del diálogo.

        // Etiqueta para seleccionar la cuenta.
        JLabel lblCuenta = new JLabel("Cuenta:");
        lblCuenta.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 13)); // Establece la fuente.
        lblCuenta.setBounds(30, 30, 100, 25); // Establece la posición de la etiqueta.
        contentPanel.add(lblCuenta); // Agrega la etiqueta al panel.

        // ComboBox para seleccionar una cuenta existente.
        cuentasComboBox = new JComboBox<>();
        cuentasComboBox.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 13)); // Establece la fuente.
        for (Cuenta cuenta : cuentasExistentes) {
            // Agrega cuentas al ComboBox.
            cuentasComboBox.addItem(cuenta.getNodeCuenta() + " - " + cuenta.getTipodeCuenta());
        }
        cuentasComboBox.setBounds(130, 30, 300, 25); // Establece la posición del ComboBox.
        contentPanel.add(cuentasComboBox); // Agrega el ComboBox al panel.

        // Etiqueta para seleccionar el servicio.
        JLabel lblServicio = new JLabel("Servicio:");
        lblServicio.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 13)); // Establece la fuente.
        lblServicio.setBounds(30, 70, 100, 25); // Establece la posición de la etiqueta.
        contentPanel.add(lblServicio); // Agrega la etiqueta al panel.

        // ComboBox para seleccionar el tipo de servicio.
        servicioComboBox = new JComboBox<>(new String[]{"Electricidad", "Agua", "Internet", "Teléfono"});
        servicioComboBox.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 13)); // Establece la fuente.
        servicioComboBox.setBounds(130, 70, 300, 25); // Establece la posición del ComboBox.
        contentPanel.add(servicioComboBox); // Agrega el ComboBox al panel.

        // Etiqueta para el monto del pago.
        JLabel lblMonto = new JLabel("Monto:");
        lblMonto.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 13)); // Establece la fuente.
        lblMonto.setBounds(30, 110, 100, 25); // Establece la posición de la etiqueta.
        contentPanel.add(lblMonto); // Agrega la etiqueta al panel.

        // Campo de texto para ingresar el monto del pago.
        montoField = new JTextField();
        montoField.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 13)); // Establece la fuente.
        montoField.setBounds(130, 110, 300, 25); // Establece la posición del campo de texto.
        contentPanel.add(montoField); // Agrega el campo de texto al panel.
        montoField.setColumns(10); // Establece el número de columnas.

        // Agregar KeyListener para el campo monto (permitir solo dígitos y punto decimal).
        montoField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Permitir solo dígitos y el punto decimal.
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == '.')) {
                    e.consume(); // Evita que se ingrese el carácter.
                }
            }
        });

        // Etiqueta para la referencia del pago.
        JLabel lblReferencia = new JLabel("Referencia:");
        lblReferencia.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 13)); // Establece la fuente.
        lblReferencia.setBounds(30, 150, 100, 25); // Establece la posición de la etiqueta.
        contentPanel.add(lblReferencia); // Agrega la etiqueta al panel.

        // Campo de texto para ingresar la referencia.
        referenciaField = new JTextField();
        referenciaField.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 13)); // Establece la fuente.
        referenciaField.setBounds(130, 150, 300, 25); // Establece la posición del campo de texto.
        contentPanel.add(referenciaField); // Agrega el campo de texto al panel.
        referenciaField.setColumns(10); // Establece el número de columnas.

        // Agregar KeyListener para el campo referencia (permitir solo dígitos).
        referenciaField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Permitir solo dígitos.
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE)) {
                    e.consume(); // Evita que se ingrese el carácter.
                }
            }
        });

        // Etiqueta para mostrar la fecha actual.
        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 13)); // Establece la fuente.
        lblFecha.setBounds(30, 190, 100, 25); // Establece la posición de la etiqueta.
        contentPanel.add(lblFecha); // Agrega la etiqueta al panel.

        // Label que muestra la fecha actual.
        fechaLabel = new JLabel(LocalDate.now().toString());
        fechaLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 13)); // Establece la fuente.
        fechaLabel.setBounds(130, 190, 300, 25); // Establece la posición de la etiqueta.
        contentPanel.add(fechaLabel); // Agrega la etiqueta al panel.

        // Botón para confirmar el pago.
        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12)); // Establece la fuente.
        btnConfirmar.setBounds(100, 230, 120, 30); // Establece la posición del botón.
        btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarPago(); // Llama al método para realizar el pago.
            }
        });
        contentPanel.add(btnConfirmar); // Agrega el botón al panel.

        // Botón para cancelar la operación.
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12)); // Establece la fuente.
        btnCancelar.setBounds(250, 230, 120, 30); // Establece la posición del botón.
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el diálogo al hacer clic en "Cancelar".
            }
        });
        contentPanel.add(btnCancelar); // Agrega el botón al panel.
        
        // Etiqueta que muestra el nombre del cliente.
        JLabel lblNewLabel_1 = new JLabel("Cliente: " + usuario);
        lblNewLabel_1.setForeground(SystemColor.desktop); // Establece el color del texto.
        lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15)); // Establece la fuente.
        lblNewLabel_1.setBackground(Color.WHITE);
        lblNewLabel_1.setBounds(0, 290, 436, 13); // Establece la posición de la etiqueta.
        contentPanel.add(lblNewLabel_1); // Agrega la etiqueta al panel.
    }

    private void realizarPago() {
        try {
            String cuentaSeleccionada = (String) cuentasComboBox.getSelectedItem(); // Obtiene la cuenta seleccionada.

            // Verifica que se haya seleccionado una cuenta y se haya ingresado un monto.
            if (cuentaSeleccionada == null || montoField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione una cuenta y/o ingrese un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            float monto = Float.parseFloat(montoField.getText()); // Convierte el monto a un número de punto flotante.
            // Verifica que el monto sea mayor a cero.
            if (monto <= 0) {
                JOptionPane.showMessageDialog(this, "El monto debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Recorre las cuentas existentes para encontrar la cuenta seleccionada.
            for (Cuenta cuenta : cuentasExistentes) {
                if (cuentaSeleccionada.contains(cuenta.getNodeCuenta())) {
                    // Verifica si hay suficientes fondos para realizar el pago.
                    if (cuenta.getSaldo() >= monto) {
                        cuenta.setSaldo(cuenta.getSaldo() - monto); // Resta el monto del saldo de la cuenta.
                        JOptionPane.showMessageDialog(this, "Pago exitoso. Nuevo saldo: " + cuenta.getSaldo());
                    } else {
                        JOptionPane.showMessageDialog(this, "Fondos insuficientes para realizar el pago.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break; // Sale del bucle una vez que encuentra la cuenta.
                }
            }
            dispose(); // Cierra el diálogo después de realizar el pago.
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Monto no válido. Ingrese un número.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}