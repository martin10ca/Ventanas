package clases;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAdmin {
    JFrame frame;
    JPanel panelSuperior;
    JTabbedPane panelInferior;
    static boolean inAction;
    public VentanaAdmin() {
        this.frame = new JFrame("Menu Administrador");
        this.panelSuperior= setPanelSuperior();
        this.panelInferior= setPanelInferior();
        inAction= false;

        panelInferior.setEnabled(!inAction);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Panel superior
        

        // Panel inferior
        

        frame.add(this.panelSuperior,BorderLayout.NORTH);
        frame.add(this.panelInferior);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private static JPanel setPanelSuperior(){
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
        return panelSuperior;
    }

    private static JTabbedPane setPanelInferior(){
        inAction=true;
        JTabbedPane panel1= new JTabbedPane();
        panel1.add(menuVehiculos());
        JTabbedPane panel2= new JTabbedPane();
        panel2.add(menuCategorias());
        JTabbedPane panel3= new JTabbedPane();
        panel3.add(menuSedes());
        JTabbedPane panel4= new JTabbedPane();
        panel4.add(menuSeguros());
        JTabbedPane panel5= new JTabbedPane();
        panel5.add(menuPersonal());
        JTabbedPane panel6= new JTabbedPane();
        panel6.add(menuTarifasPeriodos());
        JTabbedPane panelInferior = new JTabbedPane(JTabbedPane.TOP);

        panelInferior.add("Vehículos",panel1);
        panelInferior.add("Categorías",panel2);
        panelInferior.add("Sedes",panel3);
        panelInferior.add("Seguros",panel4);
        panelInferior.add("Personal",panel5);
        panelInferior.add("Tarifas/periodos",panel6);
        panelInferior.setSelectedIndex(-1);
        return panelInferior;
    }

    private static JTabbedPane menuVehiculos(){
        JTabbedPane menu = new JTabbedPane(JTabbedPane.LEFT);
        menu.add("Registrar Vehículo",new JPanel());
        menu.add("Monitorear/ Actualizar vehículo",new JPanel());
        menu.add("Obtener visualización de alto nivel",new JPanel());
        return menu;
    }

        private static JTabbedPane menuCategorias(){
        JTabbedPane menu = new JTabbedPane(JTabbedPane.LEFT);
        menu.add("Registrar Categoria",new JPanel());
        return menu;
    }

        private static JTabbedPane menuSedes(){
        JTabbedPane menu = new JTabbedPane(JTabbedPane.LEFT);
        menu.add("Registrar Sede",new JPanel());
        menu.add("Modificar Sede",new JPanel());
        return menu;
    }

        private static JTabbedPane menuSeguros(){
        JTabbedPane menu = new JTabbedPane(JTabbedPane.LEFT);
        menu.add("Registrar Seguro",new JPanel());
        menu.add("Modificar Seguro",new JPanel());
        menu.add("Eliminar Seguro",new JPanel());
        return menu;
    }
        private static JTabbedPane menuPersonal(){
        JTabbedPane menu = new JTabbedPane(JTabbedPane.LEFT);
        menu.add("Registrar administrador local",new JPanel());
        menu.add("Actualizar sede de un administrador local",new JPanel());
        return menu;
    }
        private static JTabbedPane menuTarifasPeriodos(){
        JTabbedPane menu = new JTabbedPane(JTabbedPane.LEFT);
        menu.add("Actualizar costo por conductor adicional",new JPanel());
        menu.add("Actualizar costo por traslado de vehículo",new JPanel());
        menu.add("Actualizar periodo de temporada alta",new JPanel());
        menu.add("Actualizar periodo de temporada baja",new JPanel());
        return menu;
    }
        public static void main(String[] args) {
            VentanaAdmin ventana = new VentanaAdmin();
        }

}
