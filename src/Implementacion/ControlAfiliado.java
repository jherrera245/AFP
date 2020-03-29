package Implementacion;

import Administracion.Afiliado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vista.Ventana;

/**
 *
 * @author josue
 */
public class ControlAfiliado extends Afiliado implements ActionListener {

    /**
     * Constructo de la clase
     * @param ventana JFrame
     */
    public ControlAfiliado(Ventana ventana){
        super("Josue Isai", "Herrera Benitez", "9879088-9");
        View = ventana;
        View.btnAfiliarPersona.addActionListener(this);
        AñadirAComboBox("Josue Isai Herrera Benitez");
    }
    
    /**
     * Metodo para ejecutar los eventos sobre la ventana.
     * @param ae evento
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        //Agregar un nuevo afiliado
        if (ae.getSource() == View.btnAfiliarPersona) { //Agregar nuevo afiliado o persona
            String nombrePersona = View.txtNombres.getText()+" "+View.txtApellidos.getText();
            String numeroDui = View.txtDui.getText();
            
            if (NuevoAfiliado(nombrePersona, numeroDui)) {
                JOptionPane.showMessageDialog(null, "Afiliado Registrado Exitosamente !!! ", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                AñadirAComboBox(nombrePersona);
            } else {
                JOptionPane.showMessageDialog(null, "Ah Ocurrido un error inesperado", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
            Limpiar();
        }
    }
    
    private void AñadirAComboBox(String nombrePersona){ //Metodo para agregar elementos al combo box.
        View.cbxPersona.addItem(nombrePersona);
        View.cbxPersonasCuenta.addItem(nombrePersona);
        View.cbxPersonaInforme.addItem(nombrePersona);
        View.cbxPersonaPago.addItem(nombrePersona);
    }
    
    private void Limpiar(){ //Metodo para limpiar cajas de texto
        View.txtNombres.setText("");
        View.txtApellidos.setText("");
        View.txtDui.setText("");
    }
    
    //Miembro de clase
    private Ventana View;
}
