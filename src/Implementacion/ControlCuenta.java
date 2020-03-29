package Implementacion;

import Administracion.Cuenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.Ventana;

/**
 *
 * @author josue
 */
public class ControlCuenta extends Cuenta implements ActionListener {

    /**
     * Constructo de la clase
     *
     * @param ventana JFrame
     */
    public ControlCuenta(Ventana ventana) {
        super("Josue Isai Herrera Benitez", 50.00);
        View = ventana;
        View.btnCrearCuenta.addActionListener(this);
        View.btnInvertirCuenta.addActionListener(this);
        View.btnMostrarSaldoCuenta.addActionListener(this);
    }

    /**
     * Metodo para ejecutar los eventos sobre la ventana.
     *
     * @param ae evento
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == View.btnMostrarSaldoCuenta) { //Mostrar saldo en la cuenta.
            String nombrePersona = (String) View.cbxPersonasCuenta.getSelectedItem();
            View.txtSaldoCuenta.setText(String.valueOf(MostrarSaldoDeCuenta(nombrePersona)));
        }

        if (ae.getSource() == View.btnCrearCuenta) { //Agregar nueva cuenta.
            String nombrePersona = (String) View.cbxPersonasCuenta.getSelectedItem();
            if (CrearCuenta(nombrePersona)) {
                JOptionPane.showMessageDialog(null, "Cuenta Registrado Exitosamente !!! ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe una cuenta con este nombre", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
            Limpiar();
        }

        if (ae.getSource() == View.btnInvertirCuenta) { //Inveritir en la cuenta.
            String nombrePersona = (String) View.cbxPersonasCuenta.getSelectedItem();
            double nuevaInversion = Double.parseDouble(View.txtMondoDeInversion.getText());
            InvertirEnLaCuenta(nombrePersona, nuevaInversion);
            Limpiar();
        }
    }

    private void Limpiar() {// Metodo Limpiar cajas de texto
        View.txtSaldoCuenta.setText("");
        View.txtMondoDeInversion.setText("");
    }
    //Miembros de clase
    private Ventana View;
}
