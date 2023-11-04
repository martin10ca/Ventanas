package clases;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaRegistro extends JFrame {
    private JLabel nombreEmpresa;
    private JLabel textoBienvenida;
    private JLabel instrucciones;
    private JLabel etiquetaDatos;
    private JLabel etiquetaDocumento;
    private JTextField campoDocumento;
    private JLabel etiquetaNombre;
    private JTextField campoNombre;

    public VentanaRegistro() {
        super("Registro de Usuario");
        JPanel panel = new JPanel();

        nombreEmpresa = new JLabel("<Nombre Empresa>");
        textoBienvenida = new JLabel("¡Bienvenido a nuestro sistema!");
        instrucciones = new JLabel("Necesitamos que por favor ingrese los siguientes datos para crear su cuenta.");
        etiquetaDatos = new JLabel("Datos Personales");

        panel.add(nombreEmpresa);
        panel.add(textoBienvenida);
        panel.add(instrucciones);
        panel.add(etiquetaDatos);

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
