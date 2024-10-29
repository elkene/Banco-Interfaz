package GUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import banco.Cuenta;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class Menu extends JFrame {

    private static final long serialVersionUID = 1L; // Serial para la serialización.
    private JPanel contentPane; // Panel principal de la ventana.
    private ArrayList<Cuenta> cuentasExistentes; // Atributo para almacenar cuentas existentes.

    // Constructor de la clase Menu, recibe el nombre del usuario.
    public Menu(String usuario) {
        setTitle("Banco"); // Establece el título de la ventana.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana.
        setBounds(100, 100, 450, 300); // Establece la posición y el tamaño de la ventana.

        cuentasExistentes = new ArrayList<>(); // Inicializa la lista de cuentas.
        inicializarCuentas(); // Llama al método para agregar cuentas existentes.

        // Configura la barra de menú.
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Menú para la sección "Cliente".
        JMenu mnNewMenu_1 = new JMenu("Cliente");
        mnNewMenu_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12));
        menuBar.add(mnNewMenu_1);

        // Opción para mostrar información del cliente.
        JMenuItem mntmNewMenuItem_7 = new JMenuItem("Informacion del Cliente");
        mntmNewMenuItem_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarclienteinfo(); // Llama al método para mostrar la info del cliente.
            }
        });
        mntmNewMenuItem_7.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12));
        mnNewMenu_1.add(mntmNewMenuItem_7);

        // Menú para la sección "Cuenta".
        JMenu mnNewMenu = new JMenu("Cuenta");
        mnNewMenu.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12));
        menuBar.add(mnNewMenu);

        // Opción para crear una nueva cuenta.
        JMenuItem mntmNewMenuItem = new JMenuItem("Crear Cuenta");
        mntmNewMenuItem.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12));
        mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cuentanueva(); // Llama al método para crear una nueva cuenta.
            }
        });
        mnNewMenu.add(mntmNewMenuItem);

        // Opción para mostrar cuentas existentes.
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("Mostrar Cuenta");
        mntmNewMenuItem_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12));
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarcuenta(); // Llama al método para mostrar cuentas.
            }
        });
        mnNewMenu.add(mntmNewMenuItem_1);

        // Menú para la sección "Movimientos".
        JMenu mnNewMenu_2 = new JMenu("Movimientos");
        mnNewMenu_2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12));
        menuBar.add(mnNewMenu_2);

        // Opción para realizar una transacción.
        JMenuItem mntmNewMenuItem_3 = new JMenuItem("Transacción");
        mntmNewMenuItem_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                transaccion(); // Llama al método para realizar una transacción.
            }
        });
        mntmNewMenuItem_3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12));
        mnNewMenu_2.add(mntmNewMenuItem_3);

        // Opción para realizar un pago.
        JMenuItem mntmNewMenuItem_5 = new JMenuItem("Pago");
        mntmNewMenuItem_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pago(); // Llama al método para realizar un pago.
            }
        });
        mntmNewMenuItem_5.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 12));
        mnNewMenu_2.add(mntmNewMenuItem_5);

        // Configuración del panel principal.
        contentPane = new JPanel();
        contentPane.setForeground(SystemColor.activeCaption);
        contentPane.setBackground(SystemColor.activeCaption);
        contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Etiqueta para mostrar un GIF de fondo.
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 436, 219);
        lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/Imagenes/gifbanco2.gif"))); // Cambia el path según sea necesario.
        contentPane.add(lblNewLabel);

        // Etiqueta que muestra el nombre del cliente.
        JLabel lblNewLabel_1 = new JLabel("Cliente: " + usuario);
        lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
        lblNewLabel_1.setForeground(Color.WHITE); // Establece el color del texto como blanco.
        lblNewLabel_1.setBounds(0, 229, 436, 13); // Posición de la etiqueta.
        contentPane.add(lblNewLabel_1);
    }

    // Método que inicializa cuentas predefinidas.
    private void inicializarCuentas() {
        // Crear cuentas existentes.
        Cuenta cuenta1 = new Cuenta();
        cuenta1.setNodeCuenta("12345"); // Número de cuenta.
        cuenta1.setTipodeCuenta("Ahorro"); // Tipo de cuenta.
        cuenta1.setSaldo(1000); // Saldo inicial.

        Cuenta cuenta2 = new Cuenta();
        cuenta2.setNodeCuenta("67890"); // Número de cuenta.
        cuenta2.setTipodeCuenta("Cheques"); // Tipo de cuenta.
        cuenta2.setSaldo(500); // Saldo inicial.

        // Agregar cuentas a la lista.
        cuentasExistentes.add(cuenta1);
        cuentasExistentes.add(cuenta2);
    }

    // Método para crear una nueva cuenta.
    public void cuentanueva() {
        CrearCuenta v = new CrearCuenta("Kenneth"); // Crea una nueva ventana para crear cuentas.
        v.setVisible(true); // Muestra la ventana.

        // Esperar a que se cierre el diálogo y obtener la cuenta creada.
        v.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                Cuenta nuevaCuenta = v.getCuentaCreada(); // Obtiene la cuenta creada.
                if (nuevaCuenta != null) {
                    cuentasExistentes.add(nuevaCuenta); // Agrega la nueva cuenta a la lista.
                }
            }
        });
    }

    // Método para mostrar las cuentas existentes.
    public void mostrarcuenta() {
        // Crea y muestra la ventana ListaCuenta con cuentas existentes.
        ListaCuenta v = new ListaCuenta(cuentasExistentes, "Kenneth");
        v.setVisible(true); // Muestra la ventana.
    }

    // Método para mostrar la información del cliente.
    public void mostrarclienteinfo() {
        MostrarClienteInfo v = new MostrarClienteInfo(); // Crea una nueva ventana para mostrar la info del cliente.
        v.setVisible(true); // Muestra la ventana.
    }

    // Método para realizar una transacción.
    public void transaccion() {
        Transaccion v = new Transaccion(cuentasExistentes, "Kenneth"); // Crea una nueva ventana para realizar transacciones.
        v.setVisible(true); // Muestra la ventana.
    }

    // Método para realizar un pago.
    public void pago() {
        Pago v = new Pago(cuentasExistentes, "Kenneth"); // Crea una nueva ventana para realizar pagos.
        v.setVisible(true); // Muestra la ventana.
    }
}