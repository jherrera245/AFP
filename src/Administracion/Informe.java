package Administracion;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author josue
 */
public class Informe {

    /**
     * Constructor de la clase
     *
     * @param nombrePersona nombre de la persona
     * @param fechaPago fecha en la que se tramito el pago
     * @param estadoCuenta estado de la cuenta
     * @param totalAhorro total de dinero ahorrado
     * @param rentabilidad rentabilidad del ahorro.
     */
    public Informe(String nombrePersona, String fechaPago, double estadoCuenta, double totalAhorro, double rentabilidad) {
        NombrePersona = new ArrayList<>();
        EstadoCuenta = new ArrayList<>();
        FechasPagos = new ArrayList<>();
        TotalAhorro = new ArrayList<>();
        Rentabilidad = new ArrayList<>();

        NombrePersona.add(nombrePersona);
        EstadoCuenta.add(estadoCuenta);
        FechasPagos.add(fechaPago);
        TotalAhorro.add(totalAhorro);
        Rentabilidad.add(rentabilidad);
    }

    /**
     * Metodo que retorna informacion de una persona.
     *
     * @param nombrePersona nombre de la persona.
     * @return cadena de texto.
     */
    public String InformeAfilidado(String nombrePersona) {
        int index = NombrePersona.indexOf(nombrePersona);
        if (NombrePersona.contains(nombrePersona)) {
            return Cabecera() + String.format("%-85s%-25s%-25s%-25s%-20s", NombrePersona.get(index), EstadoCuenta.get(index), FechasPagos.get(index), TotalAhorro.get(index), Rentabilidad.get(index));
        }
        return "Sin elementos";
    }

    /**
     * Metodo que retorna la informacion de todas las personas.
     *
     * @return cadena de texto.
     */
    public String InformePlanilla() {
        Iterator nombre = NombrePersona.iterator();
        Iterator cuenta = EstadoCuenta.iterator();
        Iterator fecha = FechasPagos.iterator();
        Iterator ahorro = TotalAhorro.iterator();
        Iterator retabilidad = Rentabilidad.iterator();
        String datos = Cabecera();
        while (nombre.hasNext()) {
            datos += String.format("%-85s%-25s%-25s%-25s%-20s", nombre.next(), cuenta.next(), fecha.next(), ahorro.next(), retabilidad.next()) + "\n";
        }
        return datos;
    }

    /**
     * Metodo que retorna el enabezado de las planillas.
     *
     * @return cadena de texto
     */
    private String Cabecera() {
        return String.format("%-90s%-20s%-20s%-20s%-20s", "Nombre Persona", "Estado Cuenta", "Fechas Pagos", "Total Ahorro", "Rentabilidad") + "\n";
    }

    //Miembros de clase.
    public ArrayList<String> NombrePersona;
    public ArrayList<Double> EstadoCuenta;
    public ArrayList<String> FechasPagos;
    public ArrayList<Double> TotalAhorro;
    public ArrayList<Double> Rentabilidad;
}
