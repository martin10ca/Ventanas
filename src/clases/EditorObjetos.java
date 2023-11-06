package clases;
import javax.swing.*;
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
        crearPasoPregunta("PreguntaHora1", "Horario entre semana", "InputHora1", "PreguntaHora2");
        crearPasoHora("InputHora1", "Horario entre semana(hhmm)", "PreguntaHora2");
        crearPasoPregunta("PreguntaHora2", "Horario para fin de semana", "InputHora2", "Fin");
        crearPasoHora("InputHora2", "Horario para fin de semana (hhmm)", "Fin");
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
        JButton avanzarButton = new JButton("Avanzar");

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(label);
        panel.add(textField);
        panel.add(avanzarButton);

        avanzarButton.addActionListener(new ActionListener() {
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
    private void crearPasoHora(String pasoKey, String nombreCampo, String siguientePasoKey) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Nuevo " + nombreCampo + ":");
        JPanel horaPanel = new JPanel();
    
        DefaultComboBoxModel<Integer> opcionesHora = new DefaultComboBoxModel<>();
        for (int i = 0; i <= 23; i++) {
            opcionesHora.addElement(i);
        }
        JComboBox<Integer> horaComboBox = new JComboBox<>(opcionesHora);
    
        String[] opcionesMinutos = {"00"};
        JComboBox<String> minutosComboBox = new JComboBox<>(opcionesMinutos);
    
        JButton avanzarButton = new JButton("Avanzar");
        avanzarButton.setEnabled(false); // Inicialmente, deshabilitar el botón "Avanzar"
    
        // Agregar ItemListener para habilitar el botón cuando se seleccionen ambos valores
        horaComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (horaComboBox.getSelectedIndex() != -1 && minutosComboBox.getSelectedIndex() != -1) {
                    avanzarButton.setEnabled(true);
                } else {
                    avanzarButton.setEnabled(false);
                }
            }
        });
    
        minutosComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (horaComboBox.getSelectedIndex() != -1 && minutosComboBox.getSelectedIndex() != -1) {
                    avanzarButton.setEnabled(true);
                } else {
                    avanzarButton.setEnabled(false);
                }
            }
        });
    
        horaPanel.add(horaComboBox);
        horaPanel.add(new JLabel(":"));
        horaPanel.add(minutosComboBox);
    
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(label);
        panel.add(horaPanel);
        panel.add(avanzarButton);
    
        avanzarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int hora = (int) horaComboBox.getSelectedItem();
                String minutos = (String) minutosComboBox.getSelectedItem();
                System.out.println("Nueva " + nombreCampo + ": " + String.format("%02d", hora) + ":" + minutos);
                avanzarAlSiguientePaso(siguientePasoKey);
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
            editor.editorSeguro(mainPanel);
            editor.editar();

            frame.setVisible(true);
        });
    }
}
