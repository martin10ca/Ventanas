package clases;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;

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
        frame.setSize(1000, 600);
        frame.setLayout(new BorderLayout());

        // Panel superior
        

        // Panel inferior
        

        frame.add(this.panelSuperior,BorderLayout.NORTH);
        frame.add(this.panelInferior);
        JScrollPane scrollPane= new JScrollPane(panelInferior);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane);

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
        menu.setPreferredSize(new Dimension(600,0));
        GridLayout gridLayout1 = new GridLayout(0, 2);
        gridLayout1.setVgap(10);

        //Opción 1
        JPanel panel1= new JPanel();
        panel1.setPreferredSize(new Dimension(0, 400));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0)); // Establece un FlowLayout sin relleno

        panel1.add(new JLabel("Ingrese la información del nuevo vehículo"));
        panel1.add(new JLabel(""));
        panel1.setLayout(gridLayout1);
        panel1.add(new JLabel("Placa:"));
        panel1.add(new PlaceHolderTextField("Ej: ABC123"));
        panel1.add(new JLabel("Marca:"));
        panel1.add(new PlaceHolderTextField("Ej: Chevrolet"));
        panel1.add(new JLabel("Modelo:"));
        panel1.add(new PlaceHolderTextField("Ej: Aveo"));
        panel1.add(new JLabel("Color:"));
        panel1.add(new PlaceHolderTextField("Ej: Azul"));
        panel1.add(new JLabel("Transmisión:"));
        panel1.add(new JLabel(""));
        ButtonGroup opcionTransmision= new ButtonGroup();
        JRadioButton manual=new JRadioButton("Manual");
        JRadioButton automatica= new JRadioButton("Automática");
        opcionTransmision.add(manual);
        opcionTransmision.add(automatica);
        panel1.add(manual);
        panel1.add(automatica);
        panel1.add(new JLabel("Categoria:"));
        //TODO con un for añadir categorias
        JComboBox categorias= new JComboBox<>();
        categorias.add(new JButton("Opcion 1"));
        categorias.setPreferredSize(new Dimension(100, 20)); 
        categorias.setSelectedItem(-1);
        panel1.add(categorias);
        panel1.add(new JLabel("Sedes:"));
        //TODO con un for añadir sedes
        JComboBox sedes= new JComboBox<>();
        sedes.add(new JButton("Opcion 1"));
        sedes.setPreferredSize(new Dimension(20, 20)); 
        sedes.setSelectedItem(-1);
        panel1.add(sedes);
        JButton avanzar1= new JButton("Registrar vehículo");
        panel1.add(avanzar1);
        menu.add("Registrar Vehículo",panel1);
        //Opcion 2
        JPanel panel2= new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
            //Busqueda Carro
        JPanel panel2a= new JPanel();
        panel2a.setPreferredSize(new Dimension(0, 80));
        panel2a.setLayout(new BoxLayout(panel2a, BoxLayout.Y_AXIS));
        panel2a.add(new JLabel("Ingrese la placa del vehículo que desea monitorear/actualizar"));
        panel2a.add(new JLabel("\n"));
        PlaceHolderTextField placa=new PlaceHolderTextField("Placa");
        placa.setPreferredSize(new Dimension(30, 20)); // Establece el tamaño preferido a 200x30 píxeles
        panel2a.add(placa);
        panel2a.add(new JLabel("\n"));
        JButton avanzar2a= new JButton("Buscar");
        panel2a.add(avanzar2a);
        panel2.add(panel2a);
            //Resumen Carro
        JPanel panel2b= new JPanel();
        panel2b.setPreferredSize(new Dimension(0, 120));
        panel2.add(panel2b);
            //Menu interno
        JTabbedPane menuInterno = new JTabbedPane();
        menuInterno.setPreferredSize(new Dimension(0, 200));
        menuInterno.add("Dar de baja", new JPanel());
        menuInterno.add("Obtener archivo log", new JPanel());
        JPanel panel2c= new JPanel();
        panel2c.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); // Establece un FlowLayout sin relleno

        panel2c.add(new JLabel("Elija la sede a la que se trasladará el vehículo    "));
        //TODO lista sedes
        JComboBox sedes2 = new JComboBox<>();
        sedes2.add(new JButton("Opcion 1"));
        sedes2.setSelectedIndex(-1);
        panel2c.add(sedes2);
        sedes2.setPreferredSize(new Dimension(100, 30));
        panel2c.add( Box.createRigidArea(new Dimension(0,100)));
        menuInterno.add("Trasladar", panel2c);
        panel2.add(menuInterno);
        


        
        menu.add("Monitorear/ Actualizar vehículo",panel2);
        //Opcion 3
        JPanel panel3= new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); // Establece un FlowLayout sin relleno

        panel3.add(new JLabel("Elija la sede de la que desea visualizar la gráfica de alto nivel    "));
        //TODO lista sedes
        JComboBox sedes3 = new JComboBox<>();
        sedes3.add(new JButton("Opcion 1"));
        sedes3.setSelectedIndex(-1);
        sedes3.setPreferredSize(new Dimension(100, 30));
        panel3.add(sedes3);
        JPanel panel3a= new JPanel();
        panel3.add(panel3a);


        menu.add("Obtener visualización de alto nivel",panel3);
        
        menu.setSelectedIndex(-1);
        return menu;
    }

        private static JTabbedPane menuCategorias(){
        JTabbedPane menu = new JTabbedPane(JTabbedPane.LEFT);
        menu.add("Registrar Categoria",new JPanel());
        
        menu.setSelectedIndex(-1);
        return menu;
    }

        private static JTabbedPane menuSedes(){
        JTabbedPane menu = new JTabbedPane(JTabbedPane.LEFT);
        menu.add("Registrar Sede",new JPanel());
        menu.add("Modificar Sede",new JPanel());
        
        menu.setSelectedIndex(-1);
        return menu;
    }

        private static JTabbedPane menuSeguros(){
        JTabbedPane menu = new JTabbedPane(JTabbedPane.LEFT);
        menu.add("Registrar Seguro",new JPanel());
        menu.add("Modificar Seguro",new JPanel());
        menu.add("Eliminar Seguro",new JPanel());

        menu.setSelectedIndex(-1);
        return menu;
    }
        private static JTabbedPane menuPersonal(){
        JTabbedPane menu = new JTabbedPane(JTabbedPane.LEFT);
        menu.add("Registrar administrador local",new JPanel());
        menu.add("Actualizar sede de un administrador local",new JPanel());
        
        menu.setSelectedIndex(-1);
        return menu;
    }
        private static JTabbedPane menuTarifasPeriodos(){
        JTabbedPane menu = new JTabbedPane(JTabbedPane.LEFT);
        menu.add("Actualizar costo por conductor adicional",new JPanel());
        menu.add("Actualizar costo por traslado de vehículo",new JPanel());
        menu.add("Actualizar periodo de temporada alta",new JPanel());
        menu.add("Actualizar periodo de temporada baja",new JPanel());
        
        menu.setSelectedIndex(-1);
        return menu;
    }
        private static JButton botonAvanzar(String s, boolean b){
            JButton boton= new JButton("");
            DocumentListener documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateButtonState();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateButtonState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateButtonState();
            }

            private void updateButtonState() {

                boton.setEnabled(b);
            }
        };
            return boton;

        }
        public static void main(String[] args) {
            VentanaAdmin ventana = new VentanaAdmin();
        }
        

        
}
