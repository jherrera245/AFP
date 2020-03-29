package Administracion;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author josue
 */
public class Pago extends Informe {  //Hereda los metodo de la clase Informe.

    /**
     * Contructor de la clase
     *
     * @param nombrePersona nombre de la persona
     * @param fechaPago fecha de pago.
     * @param estadoCuenta estado de la cuenta de la persona
     * @param totalAhorro total de ahorro registrado en essa fecha
     * @param rentabilidad rentabilidad generada.
     */
    public Pago(String nombrePersona, String fechaPago, double estadoCuenta, double totalAhorro, double rentabilidad) {
        super(nombrePersona, fechaPago, estadoCuenta, totalAhorro, rentabilidad);
        FechaPago = ObtenerFechaActual();
    }

    /**
     * Metodo para registrar pagos.
     *
     * @param nombrePersona nombre de la persona
     * @param totalAhorro monto de ahorro de la persona
     * @param rentabilidad rentabilidad generada
     * @param estadoCuenta total de dinero en la cuenta.
     */
    public void RegistrarPago(String nombrePersona, double totalAhorro, double rentabilidad, double estadoCuenta) {
        NombrePersona.add(nombrePersona);
        TotalAhorro.add(totalAhorro);
        Rentabilidad.add(rentabilidad);
        FechasPagos.add(FechaPago);
        EstadoCuenta.add(estadoCuenta);
    }

    /**
     * Metodo para obtener mora por pago atrasados.
     *
     * @param fecha fecha limite de pago
     * @param comision cantidad de dinero a pagar
     * @return monto de la mora.
     */
    public double CalcularMora(String fecha, double comision) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date actual = simpleDateFormat.parse(ObtenerFechaActual());
            Date limite = simpleDateFormat.parse(fecha);
            if (actual.after(limite)) {
                return comision * 0.05;
            }
        } catch (Exception e) {
            System.err.println("Error al converir fecha");
        }
        return 0;
    }

    /**
     * Metodo para obtener la fecha actual
     *
     * @return cadena de texto.
     */
    private String ObtenerFechaActual() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = GregorianCalendar.getInstance();
        return String.valueOf(simpleDateFormat.format(calendar.getTime()));
    }

    //Miembros de Clase.
    public String FechaPago;
}
