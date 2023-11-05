package clases;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.*;

public class VentanaRegistro extends JFrame {
    private JLabel nombreEmpresa;
    private JLabel textoBienvenida;
    private JLabel instrucciones;
    private JLabel etiquetaDatos;
    private JLabel etiquetaDocumento;
    private PlaceHolderTextField campoDocumento;
    private JLabel etiquetaNombre;
    private PlaceHolderTextField campoNombre;
    private JLabel etiquetaCorreo;
    private PlaceHolderTextField campoCorreo;
    private JLabel etiquetaTelefono;
    private PlaceHolderTextField campoTelefono;
    private JLabel etiquetaFecha;
    private JComboBox<String> listaDia;
    private JComboBox<String> listaMes;
    private JComboBox<String> listaAnho;
    private int limite;
    private JLabel etiquetaNacionalidad;
    private PlaceHolderTextField campoNacionalidad;
    private JButton botonContinuar;


    public VentanaRegistro() {
        super("Registro de Usuario");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JPanel panelInfo = new JPanel(new GridLayout(0, 1));

        nombreEmpresa = new JLabel("<Nombre Empresa>");
        textoBienvenida = new JLabel("¡Bienvenido a nuestro sistema!");
        instrucciones = new JLabel("Necesitamos que por favor ingrese los siguientes datos para crear su cuenta.");
        etiquetaDatos = new JLabel("Datos Personales");

        panelInfo.add(nombreEmpresa);
        panelInfo.add(textoBienvenida);
        panelInfo.add(instrucciones);
        panelInfo.add(etiquetaDatos);

        JPanel panelDatos = new JPanel(new GridLayout(0, 2));
        etiquetaDocumento = new JLabel("Documento de Identidad: ");
        campoDocumento = new PlaceHolderTextField("Ej: 1000000000");
        etiquetaNombre = new JLabel("Nombre Completo: ");
        campoNombre = new PlaceHolderTextField("Ej: Juan López");
        etiquetaCorreo = new JLabel("Correo Electrónico: ");
        campoCorreo = new PlaceHolderTextField("Ej: ejemplo@correo.com");
        etiquetaTelefono = new JLabel("Número de Teléfono Celular: ");
        campoTelefono = new PlaceHolderTextField("Ej: 3000000000");
        etiquetaFecha = new JLabel("Fecha de Nacimiento: ");
        
        listaAnho = new JComboBox<>();
        int anhoActual = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        for (int i = anhoActual; i >= 1900; i--) {
            listaAnho.addItem(String.valueOf(i));
        }
        String[] meses = {"01", "02", "03", "04", "05", "06", "07",
                         "08", "09", "10", "11", "12"};
        listaMes = new JComboBox<>(meses);
        listaDia = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            listaDia.addItem(String.valueOf(i));
        }

        etiquetaNacionalidad = new JLabel("Nacionalidad: ");
        campoNacionalidad = new PlaceHolderTextField("Ej: Colombia");

        JPanel panelFecha = new JPanel(new GridLayout(0, 3));

        panelDatos.add(etiquetaDocumento);
        panelDatos.add(campoDocumento);
        panelDatos.add(etiquetaNombre);
        panelDatos.add(campoNombre);
        panelDatos.add(etiquetaCorreo);
        panelDatos.add(campoCorreo);
        panelDatos.add(etiquetaTelefono);
        panelDatos.add(campoTelefono);
        panelDatos.add(etiquetaFecha);
        panelFecha.add(listaDia);
        panelFecha.add(listaMes);
        panelFecha.add(listaAnho);
        panelDatos.add(panelFecha);
        panelDatos.add(etiquetaNacionalidad);
        panelDatos.add(campoNacionalidad);

        panel.add(panelInfo);
        panel.add(panelDatos);
        botonContinuar = new JButton("Continuar");
        botonContinuar.setEnabled(false);
        

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 600);
        setVisible(true);
    }
}
