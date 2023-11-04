package clases;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAdmin {
    JFrame frame;
    public VentanaAdmin() {
        this.frame = new JFrame();
        JFrame frame = new JFrame("Menu Administrador de Sesión");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Panel superior
        JPanel panelSuperior= new JPanel();
        panelSuperior.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        JPanel panelSupIzq= new JPanel();
        JLabel imagenEmpresa= new JLabel("imagen");
        JLabel nomEmpresa= new JLabel("texto");
        panelSupIzq.add(imagenEmpresa);
        panelSupIzq.add(nomEmpresa);
        panelSuperior.add(panelSupIzq, BorderLayout.WEST);
        JPanel panelSupDere= new JPanel();
        JButton cerrarSesionButton = new JButton("Cerrar Sesión");
        panelSupDere.add(cerrarSesionButton);
        panelSuperior.add(panelSupDere, BorderLayout.EAST);

        // Panel inferior
        JPanel panel2= new JPanel();
        JPanel panel3= new JPanel();
        JPanel panel4= new JPanel();
        JPanel panel5= new JPanel();
        JPanel panel6= new JPanel();
        JTabbedPane panelInferior = new JTabbedPane(JTabbedPane.TOP);

        panelInferior.add("Vehículos",panelVehiculos());
        panelInferior.add("Categorías",panel2);
        panelInferior.add("Sedes",panel3);
        panelInferior.add("Seguros",panel4);
        panelInferior.add("Personal",panel5);
        panelInferior.add("Tarifas/periodos",panel6);

        frame.add(panelSuperior,BorderLayout.NORTH);
        frame.add(panelInferior);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JPanel panelVehiculos(){
        return new JPanel();
    }
        public static void main(String[] args) {
            VentanaAdmin ventana = new VentanaAdmin();
        }

}
