package Administracion;

import java.util.ArrayList;

/**
 * @author josue
 */
public class Cuenta {

    /**
     * Constructor de la clase.
     *
     * @param nombrePersona nombre de la persona
     * @param Ahorro total de dinero a ahorrar.
     */
    public Cuenta(String nombrePersona, double Ahorro) {
        //Inicializar atributos
        AfiliadoCuenta = new ArrayList<>();
        MontoDeAhorro = new ArrayList<>();
        SaldoTotal = new ArrayList<>();
        //Agregar valores a los arraylist
        AfiliadoCuenta.add(nombrePersona);
        MontoDeAhorro.add(Ahorro);
        SaldoTotal.add(100000.00);
        InvertirEnLaCuenta(nombrePersona, Ahorro);
    }

    /**
     * Metodo para crear cuentas-
     *
     * @param nombrePersona nombre de la persona
     * @return boolean
     */
    public boolean CrearCuenta(String nombrePersona) {
        if (!AfiliadoCuenta.contains(nombrePersona)) {//Verificar que esta persona no tenga una cuenta
            AfiliadoCuenta.add(nombrePersona);
            MontoDeAhorro.add(0.0);
            SaldoTotal.add(0.0);
            return true;
        }
        return false;
    }

    /**
     * Metodo para Mostrar el saldo de una cuenta
     *
     * @param nombrePersona nombre de la persona
     * @return monto de dinero en la cuenta
     */
    public double MostrarSaldoDeCuenta(String nombrePersona) {
        int afiliadoCuenta = AfiliadoCuenta.indexOf(nombrePersona);
        return (afiliadoCuenta >= 0) ? SaldoTotal.get(afiliadoCuenta) : 0.0;
    }

    /**
     * Metodo para invertir en la cuenta
     *
     * @param nombrePersona nombre de la persona
     * @param inversion monto de inversion.
     */
    public void InvertirEnLaCuenta(String nombrePersona, double inversion) {
        int afiliadoCuenta = AfiliadoCuenta.indexOf(nombrePersona);
        double saldoActual = SaldoTotal.get(afiliadoCuenta);
        SaldoTotal.set(afiliadoCuenta, saldoActual + inversion);
    }

    //Miembros de clase
    private ArrayList<String> AfiliadoCuenta;
    private ArrayList<Double> MontoDeAhorro;
    private ArrayList<Double> SaldoTotal;
}
