package banco;

// Definición de la clase Cuenta.
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Cuenta {
    // Variable de instancia privada para almacenar el número de cuenta.
    private String nodeCuenta;
    
    // Variable de instancia privada para almacenar el saldo de la cuenta.
    private double saldo = 0.0;
    
    // Variable de instancia privada para almacenar el tipo de cuenta (ej., corriente, ahorro).
    private String tipoDeCuenta;
    
    // Variable de instancia privada para almacenar el historial de movimientos.
    private ArrayList<Movimiento> historialMovimientos = new ArrayList<>();
    
    // Método público para obtener el valor del número de cuenta.
    public String getNodeCuenta() {
        return nodeCuenta;
    }

    // Método público para establecer un valor al número de cuenta.
    public void setNodeCuenta(String nodeCuenta) {
        this.nodeCuenta = nodeCuenta;
    }

    // Método público para obtener el saldo de la cuenta.
    public double getSaldo() {
        return saldo;
    }

    // Método público para establecer un valor al saldo de la cuenta.
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Método público para obtener el tipo de cuenta.
    public String getTipodeCuenta() {
        return tipoDeCuenta;
    }

    // Método público para establecer un valor al tipo de cuenta.
    public void setTipodeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    // Método público para agregar un movimiento al historial. Actualiza el saldo basado en el monto del movimiento.
    public void agregarMovimiento(Movimiento movimiento) {
        historialMovimientos.add(movimiento); // Agrega el movimiento a la lista
        saldo -= movimiento.getMonto(); // Actualiza el saldo basado en el monto del movimiento
    }

    // Método público para mostrar el historial de movimientos en un cuadro de diálogo.
    public void mostrarHistorialMovimientos() {
        StringBuilder sb = new StringBuilder();
    
        // Usando forEach para iterar sobre la lista de movimientos
        historialMovimientos.forEach(movimiento -> sb.append(movimiento.toString()).append("\n"));
    
        if (!historialMovimientos.isEmpty()) {
            // Muestra el historial de movimientos en un cuadro de diálogo.
            JOptionPane.showMessageDialog(null, sb.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No hay movimientos aún");
        }
    }
    
    // Método público para proporcionar una representación en cadena de la cuenta.
    public String toString() {
        return "Cuenta: " + nodeCuenta + " | Tipo: " + tipoDeCuenta + " | Saldo: " + saldo;
    }
    
}
