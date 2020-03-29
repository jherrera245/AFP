package Implementacion;

import Administracion.Pension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.Ventana;

/**
 *
 * @author josue
 */
public class ControlPension extends Pension implements ActionListener {

    /**
     * Constructo de la clase
     *
     * @param ventana JFrame
     */
    public ControlPension(Ventana ventana) {
        View = ventana;
        View.btnAñadirPensionado.addActionListener(this);
        View.btnCalcularPension.addActionListener(this);
        View.btnListaPensionado.addActionListener(this);
        View.btnPagarPension.addActionListener(this);
    }

    /**
     * Metodo para ejecutar los eventos sobre la ventana.
     *
     * @param ae evento
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == View.btnAñadirPensionado) { // Agregar una persona a la lista de pensionados
            String persona = (String) View.cbxPersona.getSelectedItem();
            RemoverItem(persona);
        }
        if (ae.getSource() == View.btnCalcularPension) { //Calcular monto de pension de la persona
            View.btnMostrarSaldoCuenta.doClick();
            View.txtSaldoActual.setText(View.txtSaldoCuenta.getText());
            View.txtTotalPension.setText("300");
        }
        if (ae.getSource() == View.btnListaPensionado) { //Ver lista de pensionados
            JOptionPane.showMessageDialog(null, ListaPensionados(), "Pensionados", JOptionPane.INFORMATION_MESSAGE);
        }
        if (ae.getSource() == View.btnPagarPension) { // Pagar pension a persona.
            double descontar = -Double.parseDouble(View.txtTotalPension.getText());
            View.txtMondoDeInversion.setText(String.valueOf(descontar));
            View.btnInvertirCuenta.doClick();
        }
    }

    public void RemoverItem(String persona) { //Remover elemento del combo box
        View.cbxPersona.removeItem(persona);
        View.cbxPersonaPago.removeItem(persona);
        View.cbxPersonaPensionada.addItem(persona);
    }

    private void Limpiar() { //Limpiar cajas de texto
        View.txtSaldoCuenta.setText("");
        View.txtMondoDeInversion.setText("");
    }

    //Miembro de Clase.
    private Ventana View;
}
