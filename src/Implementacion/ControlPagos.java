package Implementacion;

import Administracion.Pago;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.Ventana;

/**
 *
 * @author josue
 */
public class ControlPagos extends Pago implements ActionListener {

    /**
     * Constructo de la clase
     *
     * @param ventana JFrame
     */
    public ControlPagos(Ventana ventana) {
        super("Josue Isai Herrera Benitez", "21-12-2000", 100000.00, 0, 0);
        View = ventana;
        View.btnPagarComision.setEnabled(false);
        View.btnPagarComision.addActionListener(this);
        View.btnComision.addActionListener(this);
        View.btnDetalleCuenta.addActionListener(this);
        View.btnEnviarInforme.addActionListener(this);
        View.txtFechaPago.setText(FechaPago);
    }

    /**
     * Metodo para ejecutar los eventos sobre la ventana.
     *
     * @param ae evento
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == View.btnComision) { //Calular el moto de comision
            CalcularComision();
        }
        if (ae.getSource() == View.btnPagarComision) { //Pagar la comision
            PagarComision();
        }
        if (ae.getSource() == View.btnDetalleCuenta) {// Ver infromacion de cuenta especifica
            String nombrePersona = (String) View.cbxPersonaPago.getSelectedItem();
            JOptionPane.showMessageDialog(null, InformeAfilidado(nombrePersona), "Mensaje para " + nombrePersona, JOptionPane.INFORMATION_MESSAGE);
        }
        if (ae.getSource() == View.btnEnviarInforme) { // Mostrar informe completo de afiliados
            JOptionPane.showMessageDialog(null, InformePlanilla(), "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void CalcularComision() { //Calcula las comisiones.
        View.btnPagarComision.setEnabled(true);
        double calcular = Double.parseDouble(View.txtAporteEmpleado.getText()) + Double.parseDouble(View.txtAporteEmpleador.getText());
        View.txtMontoComision.setText(String.valueOf(calcular * 0.022));
        View.txtTotalAhorro.setText(String.valueOf(calcular * 0.1080));
        View.txtMondoDeInversion.setText(View.txtTotalAhorro.getText());
        double mora = CalcularMora(View.txtFechaLimite.getText(), calcular);
        View.txtMora.setText(String.valueOf(mora));
        View.btnInvertirCuenta.doClick();
    }

    public void PagarComision() { //Metodo para pagar comision
        if (View.txtMontoComision.getText() != null) { //Verificar que la comision no se a nula
            String nombrePersona = (String) View.cbxPersonaPago.getSelectedItem();
            View.cbxPersonasCuenta.setSelectedItem(nombrePersona);
            View.btnMostrarSaldoCuenta.doClick();
            double ahorro = Double.parseDouble(View.txtTotalAhorro.getText());
            double estadoCuenta = Double.parseDouble(View.txtSaldoCuenta.getText());
            double comision = Double.parseDouble(View.txtMontoComision.getText());
            RegistrarPago(nombrePersona, ahorro, comision, estadoCuenta); //Registrar el pago
        }
        View.btnPagarComision.setEnabled(false);
        Limpiar();
        JOptionPane.showMessageDialog(null, "El Pago se a realizado exitosament", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    private void Limpiar() { //Limpiar cajas de texto
        View.txtAporteEmpleado.setText("");
        View.txtAporteEmpleador.setText("");
        View.txtMontoComision.setText("");
        View.txtTotalAhorro.setText("");
    }
    //Miembros de clase.
    private Ventana View;
}
