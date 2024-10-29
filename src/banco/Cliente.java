package banco;

import java.util.ArrayList;
import javax.swing.JOptionPane;

// Definición de la clase Cliente.
public class Cliente {
    // Variable de instancia privada para almacenar una lista de cuentas. Se inicializa con un tamaño máximo de 10 cuentas.
    private ArrayList<Cuenta> listaDeCuentas = new ArrayList<>();
    
    // Variables de instancia privadas para almacenar la información personal del cliente.
    private String nombre;
    private String curp;
    private String celular;
    
    // Variable de instancia privada para llevar el conteo de cuentas actualmente asociadas al cliente.
    private int numeroCuentas = 0;

    // Método público para agregar una cuenta a la lista de cuentas del cliente. 
    public void agregarCuenta(Cuenta cuenta) {
        listaDeCuentas.add(cuenta);  // Agrega la cuenta a la lista sin necesidad de verificar el tamaño.

    }

    // Método público para obtener una cuenta por su número de cuenta (nodoCuenta).
    //Usando for mejorado
    public Cuenta getCuenta(String nodoCuenta) {
        for (Cuenta cuenta : listaDeCuentas) {
            if (cuenta.getNodeCuenta().equals(nodoCuenta)) {
                return cuenta;
            }
        }
        return null; // Retorna null si no se encuentra la cuenta.
    }

    // Método público para obtener una cuenta por su índice en la lista.
    public Cuenta getCuenta(int index) {
        if (index >= 0 && index < listaDeCuentas.size()) {
            return listaDeCuentas.get(index);
        }
        return null; // Retorna null si el índice está fuera del rango.
    }

    // Método público para obtener el número de cuentas asociadas al cliente.
    public int getNumeroCuentas() {
        return numeroCuentas;
    }

    // Método público para obtener el nombre del cliente.
    public String getNombre() {
        return nombre;
    }

    // Método público para establecer un valor al nombre del cliente.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método público para obtener la CURP del cliente.
    public String getCurp() {
        return curp;
    }

    // Método público para establecer un valor a la CURP del cliente.
    public void setCurp(String curp) {
        this.curp = curp;
    }

    // Método público para obtener el número de celular del cliente.
    public String getCelular() {
        return celular;
    }

    // Método público para establecer un valor al número de celular del cliente.
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public void eliminarCuenta(String nodoCuenta) {
        Cuenta cuentaAEliminar = null;
        for (Cuenta cuenta : listaDeCuentas) {
            if (cuenta.getNodeCuenta().equals(nodoCuenta)) {
                cuentaAEliminar = cuenta;
                break; // Salir del bucle una vez que se encuentra la cuenta
            }
        }
        if (cuentaAEliminar != null) {
            listaDeCuentas.remove(cuentaAEliminar);
            JOptionPane.showMessageDialog(null, "Cuenta eliminada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Cuenta no encontrada.");
        }
    }

    // Método público para proporcionar una representación en cadena del cliente y sus cuentas asociadas.
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente: ").append(nombre).append(" | CURP: ").append(curp).append(" | Celular: ").append(celular).append("\n");
        for (Cuenta cuenta : listaDeCuentas) {
            sb.append(cuenta.toString()).append("\n");
        }
        return sb.toString();
    }
}