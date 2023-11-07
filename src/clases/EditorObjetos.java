package clases;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
//TODO pasar por parametro el objeto y editarlo aca
public class EditorObjetos {
    private  JPanel mainPanel;
    private  CardLayout cardLayout;
    private  JPanel cardPanel;
    private  String[] pasos;
    private int pasoActual = 0;
    private String retorno;

    public void editorSede(JPanel mainPanel) {
        this.mainPanel = mainPanel;
        this.cardLayout = new CardLayout();
        this.cardPanel = new JPanel(cardLayout);
        String [] pasosSede ={"PreguntaNombre", "InputNombre", "PreguntaUbicacion", "InputUbicacion", "Fin"};
        this.pasos=pasosSede ;
        mainPanel.add(cardPanel);
        crearPasosSede();
    }
    public void editorSeguro(JPanel mainPanel) {
        this.mainPanel = mainPanel;
        this.cardLayout = new CardLayout();
        this.cardPanel = new JPanel(cardLayout);
        String [] pasosSeguro ={"PreguntaDescripcion", "InputDescripcion", "PreguntaPctg", "InputPctg","Fin"};
        this.pasos=pasosSeguro ;
        mainPanel.add(cardPanel);
        crearPasosSeguro();
    }

    public void editar() {
        // Comienza con el primer paso
        mostrarPasoActual();
    }

    private void crearPasosSede() {
        crearPasoPregunta("PreguntaNombre", "¿Desea modificar el Nombre?", "InputNombre", "PreguntaUbicacion");
        crearPasoInput("InputNombre", "Nombre", "PreguntaUbicacion");
        crearPasoPregunta("PreguntaUbicacion", "¿Desea modificar la Ubicación?", "InputUbicacion", "PreguntaHora1");
        crearPasoInput("InputUbicacion", "Ubicación", "PreguntaHora1");
        crearPasoPregunta("PreguntaHora1", "¿Desea modificar el horario entre semana?", "InputHora1", "PreguntaHora2");
        crearPasoHorario("InputHora1", "Horario entre semana(hhmm)", "PreguntaHora2");
        crearPasoPregunta("PreguntaHora2", "¿Desea modificar el horario para fin de semana?", "InputHora2", "Fin");
        crearPasoHorario("InputHora2", "Horario para fin de semana (hhmm)", "Fin");
        crearPasoFin("Fin");
    }
    private void crearPasosSeguro() {
        crearPasoPregunta("PreguntaDescripcion", "¿Desea modificar la descripción del seguro?", "InputDescripcion", "PreguntaPctg");
        crearPasoInput("InputDescripcion", "Descripción", "PreguntaPctg");
        crearPasoPregunta("PreguntaPctg", "¿Desea modificar el porcentaje de la tarifa diaria a cobrar?", "InputPctg", "Fin");
        crearPasoDecimales("InputPctg", "Porcentaje de la tarifa diaria a cobrar", "Fin");
        crearPasoFin("Fin");
    }
    private void crearPasoPregunta(String preguntaKey, String pregunta, String siguientePasoKeySi, String siguientePasoKeyNo) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(pregunta);
        JButton siButton = new JButton("Sí");
        JButton noButton = new JButton("No");

        panel.setLayout(new FlowLayout());
        panel.add(label);
        panel.add(siButton);
        panel.add(noButton);

        siButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Si el usuario selecciona "Sí", avanza al siguiente paso "si"
                avanzarAlSiguientePaso(siguientePasoKeySi);
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Si el usuario selecciona "No", avanza al siguiente paso "no"
                avanzarAlSiguientePaso(siguientePasoKeyNo);
            }
        });

        cardPanel.add(panel, preguntaKey);
    }

    private void crearPasoInput(String pasoKey, String nombreCampo, String siguientePasoKey) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Nuevo " + nombreCampo + ":");
        JTextField textField = new JTextField(20);
        JButton avanzar = new JButton("Avanzar");

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(label);
        panel.add(textField);
        panel.add(avanzar);
        avanzar.setVisible(false);
        DocumentListener documentListener = new DocumentListener() {
        @Override
            public void insertUpdate(DocumentEvent e) {
                avanzar.setVisible(!textField.getText().trim().isEmpty());
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                avanzar.setVisible(!textField.getText().trim().isEmpty());
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                avanzar.setVisible(!textField.getText().trim().isEmpty());
            }
        };
        textField.getDocument().addDocumentListener(documentListener);
        avanzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Realiza la operación correspondiente con el nuevo valor
                System.out.println("Nuevo " + nombreCampo + ": " + textField.getText());

                // Avanza al siguiente paso
                avanzarAlSiguientePaso(siguientePasoKey);
            }
        });
        cardPanel.add(panel, pasoKey);
    }
    private void crearPasoHorario(String pasoKey, String nombreCampo, String siguientePasoKey) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Nuevo " + nombreCampo + ":");
        JLabel labela = new JLabel("\t");

        JLabel label1 = new JLabel("Hora inicio ");
        JLabel label2 = new JLabel("Hora fin ");
        JPanel horaPanel1 = new JPanel();
        JPanel horaPanel2 = new JPanel();

        DefaultComboBoxModel<String> opcionesHora1 = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> opcionesHora2 = new DefaultComboBoxModel<>();

        for (int i = 0; i <= 23; i++) {
            String s="";
            if (i<10){
                s=s+"0";
            }
            opcionesHora1.addElement(s+Integer.toString(i));
            opcionesHora2.addElement(s+Integer.toString(i));
        }
        JComboBox<String> horaComboBox1 = new JComboBox<>(opcionesHora1);
        JComboBox<String> horaComboBox2 = new JComboBox<>(opcionesHora2);
    
        DefaultComboBoxModel<String> opcionesMinutos1 = new DefaultComboBoxModel<>();
        opcionesMinutos1.addElement("00");
        DefaultComboBoxModel<String> opcionesMinutos2 = new DefaultComboBoxModel<>();
        opcionesMinutos2.addElement("00");

        JComboBox<String> minutosComboBox1 = new JComboBox<>(opcionesMinutos1);
        JComboBox<String> minutosComboBox2 = new JComboBox<>(opcionesMinutos2);
        opcionesHora1.setSelectedItem("01");
        opcionesHora2.setSelectedItem("01");
        opcionesMinutos1.setSelectedItem("00");
        opcionesMinutos2.setSelectedItem("00");

        JButton avanzarButton = new JButton("Avanzar");
    
        horaPanel1.add(horaComboBox1);
        horaPanel1.add(new JLabel(":"));
        horaPanel1.add(minutosComboBox1);
        horaPanel2.add(horaComboBox2);
        horaPanel2.add(new JLabel(":"));
        horaPanel2.add(minutosComboBox2);
    
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(label);
        panel.add(labela);
        panel.add(label1);
        panel.add(horaPanel1);
        panel.add(label2);
        panel.add(horaPanel2);
        panel.add(avanzarButton);
    
        avanzarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hora1 = horaComboBox1.getSelectedItem().toString();
                String minutos1 =minutosComboBox1.getSelectedItem().toString();
                String hora2 = horaComboBox2.getSelectedItem().toString();
                String minutos2 = minutosComboBox2.getSelectedItem().toString();
                String inicio=(hora1+minutos1);
                String fin=(hora2+minutos2);
                System.out.println("inicio:"+inicio);
                System.out.println("fin:"+fin);
                if(Integer.parseInt(fin)> Integer.parseInt(inicio)){
                avanzarAlSiguientePaso(siguientePasoKey);
                }
                else{
                    VentanaAdmin.errorDialog("Verifique que la fecha/periodo inicial sea previa a la fecha/periodo final.");
                }  
            }
        });
    
        cardPanel.add(panel, pasoKey);
    }
    
    private void crearPasoDecimales(String pasoKey, String nombreCampo, String siguientePasoKey) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Nuevo " + nombreCampo + ":");
        
        DefaultComboBoxModel<Double> opcionesDecimales = new DefaultComboBoxModel<>();
        for (double i = 0.1; i <= 2.0; i += 0.1) {
            double numeroRedondeado = Math.round(i * 10.0) / 10.0;
            opcionesDecimales.addElement(numeroRedondeado);
        }
        
        JComboBox<Double> decimalesComboBox = new JComboBox<>(opcionesDecimales);
        JButton avanzarButton = new JButton("Avanzar");
        avanzarButton.setEnabled(false); // Inicialmente, deshabilitar el botón "Avanzar"
    
        // Agregar un ItemListener para habilitar el botón cuando se seleccionen valores en el JComboBox
        decimalesComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (decimalesComboBox.getSelectedIndex() != -1) {
                    avanzarButton.setEnabled(true);
                } else {
                    avanzarButton.setEnabled(false);
                }
            }
        });
    
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(label);
        panel.add(decimalesComboBox);
        panel.add(avanzarButton);
    
        avanzarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = (double) decimalesComboBox.getSelectedItem();
                System.out.println("Nuevo " + nombreCampo + ": " + valor);
                avanzarAlSiguientePaso(siguientePasoKey);
            }
        });
    
        cardPanel.add(panel, pasoKey);
    }
    
    private void crearPasoFin(String pasoKey) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Cambios registrados");
        JButton finalizarButton = new JButton("Finalizar");

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(label);
        panel.add(finalizarButton);

        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar el frame y dejarlo vacío
                mainPanel.removeAll();
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        cardPanel.add(panel, pasoKey);
    }

    private void avanzarAlSiguientePaso(String siguientePasoKey) {
        cardLayout.show(cardPanel, siguientePasoKey);
    }

    private void mostrarPasoActual() {
        cardLayout.show(cardPanel, pasos[pasoActual]);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Editor de Sede");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JPanel mainPanel = new JPanel(new BorderLayout());
            frame.add(mainPanel);

            EditorObjetos editor = new EditorObjetos();
            editor.editorSede(mainPanel);
            editor.editar();

            frame.setVisible(true);
        });
    }
}
