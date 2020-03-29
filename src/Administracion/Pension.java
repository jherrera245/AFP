package Administracion;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author josue
 */
public class Pension {

    //Constructor de la clase pago.
    public Pension() {
        Pensionado = new ArrayList<>();
    }

    /**
     * Metodo para agregar a lista de Pensionado.
     *
     * @param nombrePensionado
     */
    public void AgregarPensionado(String nombrePensionado) {
        Pensionado.add(nombrePensionado);
    }

    /**
     * Metodo que sirve para Mostrar lista de Pensionados
     * @return 
     */
    public String ListaPensionados() {
        Iterator pensionado = Pensionado.iterator();
        while (pensionado.hasNext()) {
            return pensionado.next() + "\n";
        }
        return "No hay pensionados";
    }

    //Miembro de Clase.
    private ArrayList<String> Pensionado;
}
