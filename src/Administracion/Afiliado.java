package Administracion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author josue
 */
public class Afiliado {

    /**
     * Constructor de la clase.
     *
     * @param nombrePersona nombre de la persona afiliada
     * @param apellidoPersona apellido de la persona afiliada
     * @param duiPersona numero de dui de la persona afiliada
     */
    public Afiliado(String nombrePersona, String apellidoPersona, String duiPersona) {
        //Inicializar Miembros de clase.
        Afiliados = new ArrayList<>();
        NumeroDui = new ArrayList<>();
        FechaAfiliacion = new ArrayList<>();
        //Agregar valores a los arraylist.
        Afiliados.add(nombrePersona + " " + apellidoPersona);
        NumeroDui.add(duiPersona);
        FechaAfiliacion.add(ObtenerFechaActual());
    }

    /**
     * Metodo para crear nuevos afiliados.
     *
     * @param nombrePersona nombre de la persona
     * @param numeroDui numero de dui
     * @return boolean
     */
    public boolean NuevoAfiliado(String nombrePersona, String numeroDui) {
        if (!Afiliados.contains(nombrePersona)) { //Verificar que sta persona no este agregada.
            //Agregar nuevo afiliado.
            Afiliados.add(nombrePersona);
            FechaAfiliacion.add(ObtenerFechaActual());
            NumeroDui.add(numeroDui);
            return true;
        }
        return false;
    }

    //Metodo que genera la fecha actual.
    private String ObtenerFechaActual() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        Calendar calendar = GregorianCalendar.getInstance();
        return String.valueOf(simpleDateFormat.format(calendar.getTime()));
    }

    //Miembros de Clase.
    private ArrayList<String> Afiliados;
    private ArrayList<String> NumeroDui;
    private ArrayList<String> FechaAfiliacion;
}
