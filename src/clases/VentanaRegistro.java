package clases;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.GridLayout;

public class VentanaRegistro extends JFrame {
    private JTabbedPane tabbedPane;
    private JLabel nombreEmpresa;
    private JLabel textoBienvenida;
    private JLabel instrucciones;
    private JLabel etiquetaDatos;
    private JButton botonContinuar;
    private PlaceHolderTextField campoNombre;

    public VentanaRegistro(){
        super("Registro de Usuario");

        tabbedPane = new JTabbedPane();
        JPanel panelA = new JPanel(new GridLayout(0,1));
        JPanel panelDatos = new JPanel(new GridLayout(0,2));

        nombreEmpresa = new JLabel("<NombreEmpresa>");
        textoBienvenida = new JLabel("¡Bienvenido a nuestro sistema!");
        instrucciones = new JLabel("Necesitamos que por favor ingrese los siguientes datos para crear su cuenta.");
        etiquetaDatos = new JLabel("Datos Personales:");

        panelA.add(nombreEmpresa);
        panelA.add(textoBienvenida);
        panelA.add(instrucciones);
        panelA.add(etiquetaDatos);

        JLabel etiquetaDocumento = new JLabel("Documento de Identidad: ");
        NumericOnlyTextField campoDocumento = new NumericOnlyTextField();
        JLabel etiquetaNombre = new JLabel("Nombre Completo: ");
        campoNombre = new PlaceHolderTextField("Ej: Juan López");
        JLabel etiquetaCorreo = new JLabel("Correo Electrónico: ");
        PlaceHolderTextField campoCorreo = new PlaceHolderTextField("Ej: correo@ejemplo.com");
        JLabel etiquetaTelefono = new JLabel("Número de Teléfono Celular: ");
        NumericOnlyTextField campoTelefono = new NumericOnlyTextField();
        JLabel etiquetaNacionalidad = new JLabel("Nacionalidad");
        PlaceHolderTextField campoNacionalidad = new PlaceHolderTextField("Ej: Colombia");

        panelDatos.add(etiquetaDocumento);
        panelDatos.add(campoDocumento);
        panelDatos.add(etiquetaNombre);
        panelDatos.add(campoNombre);
        panelDatos.add(etiquetaCorreo);
        panelDatos.add(campoCorreo);
        panelDatos.add(etiquetaTelefono);
        panelDatos.add(campoTelefono);
        panelDatos.add(etiquetaNacionalidad);
        panelDatos.add(campoNacionalidad);

        panelA.add(panelDatos);

        botonContinuar = new JButton("Continuar");
        botonContinuar.setPreferredSize(new Dimension(50, 30));
        botonContinuar.setEnabled(false);
        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                habilitarBotonContinuar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                habilitarBotonContinuar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                habilitarBotonContinuar();
            }
            public void habilitarBotonContinuar() {
                boolean habilitar = !campoDocumento.getText().isEmpty() &&
                        !campoNombre.getText().isEmpty() &&
                        !campoCorreo.getText().isEmpty() &&
                        !campoTelefono.getText().isEmpty() && !campoNacionalidad.getText().isEmpty();
                botonContinuar.setEnabled(habilitar);
            }
        };
        campoDocumento.getDocument().addDocumentListener(documentListener);
        campoNombre.getDocument().addDocumentListener(documentListener);
        campoCorreo.getDocument().addDocumentListener(documentListener);
        campoTelefono.getDocument().addDocumentListener(documentListener);
        campoNacionalidad.getDocument().addDocumentListener(documentListener);

        botonContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crearUsuario();
            }
        });

        panelA.add(botonContinuar);

        tabbedPane.add("Datos Personales", panelA);
        
        add(tabbedPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 600);
        setVisible(true);
    }
    
    public void crearUsuario(){
        JPanel panelB = new JPanel(new GridLayout(0,1));
        JPanel panelUsuarioContraseña = new JPanel(new GridLayout(0, 2));
        
        JLabel labelUsuario = new JLabel("Nombre de Usuario (login): ");
        PlaceHolderTextField campoUsuario = new PlaceHolderTextField("Ej: jlopez123");
        JLabel labelContraseña = new JLabel("Contraseña: ");
        JPasswordField campoContraseña = new JPasswordField();       
        labelContraseña.setVisible(false);
        campoContraseña.setVisible(false);

        DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                mostrarCampoContraseña(!campoUsuario.getText().isEmpty());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                mostrarCampoContraseña(!campoUsuario.getText().isEmpty());
            }
    
            @Override
            public void changedUpdate(DocumentEvent e) {
                mostrarCampoContraseña(!campoUsuario.getText().isEmpty());
            }
    
            private void mostrarCampoContraseña(boolean mostrar) {
                labelContraseña.setVisible(mostrar);
                campoContraseña.setVisible(mostrar);
            }            
        };
        campoUsuario.getDocument().addDocumentListener(documentListener);;

        JButton botonLicencia = new JButton("Añadir Licencia de Conducción");
        JButton botonTarjeta = new JButton("Añadir Método de Pago");
        botonLicencia.setPreferredSize(new Dimension(50, 30));
        botonTarjeta.setPreferredSize(new Dimension(50, 30));
        
        ActionListener botonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == botonLicencia) {
                    crearLicencia();
                    
                } else if (e.getSource() == botonTarjeta) {
                    crearTarjeta();
                    
                }
            }
        };
        botonLicencia.addActionListener(botonListener);
        botonTarjeta.addActionListener(botonListener);

        panelUsuarioContraseña.add(labelUsuario);
        panelUsuarioContraseña.add(campoUsuario);
        panelUsuarioContraseña.add(labelContraseña);
        panelUsuarioContraseña.add(campoContraseña);

        JLabel labelbienvenida = new JLabel("Bienvenido " + campoNombre.getText());
        panelB.add(labelbienvenida);
        panelB.add(panelUsuarioContraseña);
        panelB.add(botonLicencia);
        panelB.add(botonTarjeta);

        tabbedPane.add("Usuario y Contraseña", panelB);
    
    }
    public void crearLicencia() {}
    public void crearTarjeta() {}

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaRegistro());
    }
}

    



