package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import banco.Cuenta;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaCuenta extends JDialog {

    private static final long serialVersionUID = 1L; // Serial para la serialización.
    private final JPanel contentPanel = new JPanel(); // Panel principal para el contenido del diálogo.
    private JTable table; // Tabla para mostrar la lista de cuentas.
    private ArrayList<Cuenta> cuentas; // Lista de cuentas.

    @SuppressWarnings("serial")
    public ListaCuenta(ArrayList<Cuenta> cuentasExistentes, String usuario) {
        this.cuentas = new ArrayList<>(cuentasExistentes); // Inicializar la lista con cuentas existentes.

        setTitle("Lista de Cuentas"); // Establece el título del diálogo.
        setModal(true); // Hace que el diálogo sea modal.

        setBounds(100, 100, 450, 300); // Establece la posición y el tamaño del diálogo.
        getContentPane().setLayout(new BorderLayout()); // Establece el layout del contenido del diálogo.
        contentPanel.setBackground(SystemColor.activeCaption); // Establece el color de fondo del panel.
        contentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null)); // Establece un borde en el panel.
        getContentPane().add(contentPanel, BorderLayout.CENTER); // Agrega el panel al contenido del diálogo.
        contentPanel.setLayout(null); // Establece el layout del panel como nulo.

        // Configuración del JScrollPane que contendrá la tabla.
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null)); // Establece un borde en el JScrollPane.
        scrollPane.setBounds(30, 24, 376, 179); // Establece la posición del JScrollPane.
        contentPanel.add(scrollPane); // Agrega el JScrollPane al panel de contenido.

        // Configuración de la tabla.
        table = new JTable();
        table.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null)); // Establece un borde en la tabla.
        table.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12)); // Establece la fuente de la tabla.
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"No. Cuenta", "Tipo de Cuenta", "Saldo"} // Establece los nombres de las columnas.
        ) {
            boolean[] columnEditables = new boolean[] { false, false, false }; // Establece que las columnas no son editables.

            // Método para definir si la celda es editable.
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column]; // Retorna false para que no se puedan editar las celdas.
            }
        });

        scrollPane.setViewportView(table); // Establece la tabla como la vista del JScrollPane.
        
        // Etiqueta que muestra el nombre del cliente.
        JLabel lblNewLabel_1 = new JLabel("Cliente: " + usuario);
        lblNewLabel_1.setForeground(SystemColor.desktop); // Establece el color del texto.
        lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15)); // Establece la fuente.
        lblNewLabel_1.setBackground(Color.WHITE);
        lblNewLabel_1.setBounds(0, 215, 436, 13); // Establece la posición de la etiqueta.
        contentPanel.add(lblNewLabel_1); // Agrega la etiqueta al panel de contenido.

        // Panel para los botones en la parte inferior.
        JPanel buttonPane = new JPanel();
        buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null)); // Establece un borde en el panel de botones.
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Establece el layout del panel de botones.
        getContentPane().add(buttonPane, BorderLayout.SOUTH); // Agrega el panel de botones al contenido del diálogo.
        
        // Botón "OK" para cerrar el diálogo.
        JButton okButton = new JButton("OK");
        okButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 10)); // Establece la fuente.
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
        cancelButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 10)); // Establece la fuente.
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el diálogo al hacer clic en "Cancel".
            }
        });
        cancelButton.setActionCommand("Cancel");
        buttonPane.add(cancelButton); // Agrega el botón "Cancel" al panel de botones.

        llenarTabla(); // Llenar la tabla con cuentas existentes al iniciar.
    }

    // Método para llenar la tabla con las cuentas.
    private void llenarTabla() {
        DefaultTableModel model = (DefaultTableModel) table.getModel(); // Obtiene el modelo de la tabla.
        model.setRowCount(0); // Limpiar el modelo existente.

        // Iterar sobre la lista de cuentas y agregar cada cuenta a la tabla.
        for (Cuenta cuenta : cuentas) {
            Object[] row = {
                cuenta.getNodeCuenta(), // Número de cuenta.
                cuenta.getTipodeCuenta(), // Tipo de cuenta.
                cuenta.getSaldo() // Saldo.
            };
            model.addRow(row); // Agregar fila al modelo.
        }
        table.repaint(); // Repaint para actualizar la tabla.
    }
}
