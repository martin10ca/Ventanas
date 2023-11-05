package clases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class EditorSede {
    private final JPanel mainPanel;

    public EditorSede(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void editarSede() {
        editarNombre();
        editarUbicacionPortada();
        editarHorarioSemana();
        editarHorarioFinDeSemana();
    }

    private void crearPanel(String titulo, JComponent... componentes) {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel contenido = new JPanel();
        contenido.setLayout(new BoxLayout(contenido, BoxLayout.PAGE_AXIS));

        JLabel label = new JLabel(titulo);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        contenido.add(label);

        for (JComponent componente : componentes) {
            componente.setAlignmentX(Component.CENTER_ALIGNMENT);
            contenido.add(componente);
        }

        panel.add(contenido, BorderLayout.CENTER);
        mainPanel.add(panel);
    }

    private void editarNombre() {
        JTextField nombreTextField = new JTextField(20);
        JButton avanzarButton = new JButton("Avanzar");
        avanzarButton.addActionListener(e -> {
            String nuevoNombre = nombreTextField.getText();
            // Realiza la operación correspondiente con el nuevo nombre
            // ...
        });

        crearPanel("Paso 1: Editar Nombre", nombreTextField, avanzarButton);
    }

    private void editarUbicacionPortada() {
        // Implementa la lógica para editar ubicación y portada aquí
    }

    private void editarHorarioSemana() {
        // Implementa la lógica para editar horario de atención entre semana aquí
    }

    private void editarHorarioFinDeSemana() {
        // Implementa la lógica para editar horario de atención en fin de semana aquí
    }
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Tu código va aquí
        JFrame frame= new JFrame();
        JPanel panel= new JPanel();
        EditorSede sede= new EditorSede(panel);
        sede.editarSede();
        frame.add(panel);
        panel.setVisible(true);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(400,400);
    }
}

