package clases;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class VentanaAdmin {
    static JFrame frame;
    JPanel panelSuperior;
    JTabbedPane panelInferior;
    static boolean inAction;
    static boolean boolModificar;
    public VentanaAdmin() {
        this.frame = new JFrame("Menu Administrador");
        this.panelSuperior= setPanelSuperior();
        this.panelInferior= setPanelInferior();
        inAction= false;

        panelInferior.setEnabled(!inAction);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 600);
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
        panel2c.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0)); // Establece un FlowLayout sin relleno

        panel2c.add(new JLabel("Elija la sede a la que se trasladará el vehículo"));
        //TODO lista sedes
        JComboBox sedes2 = new JComboBox<>();
        sedes2.add(new JButton("Opcion 1"));
        sedes2.setSelectedIndex(-1);
        panel2c.add(sedes2);
        sedes2.setPreferredSize(new Dimension(200, 30));
        panel2c.add( Box.createRigidArea(new Dimension(0,100)));
        //TODO logica
        JButton avanzar= new JButton("Trasladar");
        panel2c.add(avanzar);
        menuInterno.add("Trasladar", panel2c);
        panel2.add(menuInterno);
        


        
        menu.add("Monitorear/ Actualizar vehículo",panel2);
        //Opcion 3
        JPanel panel3= new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0)); // Establece un FlowLayout sin relleno

        panel3.add(new JLabel("Elija la sede de la que desea visualizar la gráfica de alto nivel"));
        //TODO lista sedes
        JComboBox sedes3 = new JComboBox<>();
        sedes3.add(new JButton("Opcion 1"));
        sedes3.setSelectedIndex(-1);
        sedes3.setPreferredSize(new Dimension(200, 30));
        panel3.add(sedes3);
        JButton avanzar2= new JButton("Continuar");
        panel3.add(avanzar2);
        //TODO -> panel 3a va a tener la grafica

        JPanel panel3a= new JPanel();
        panel3.add(panel3a);
        menu.add("Obtener visualización de alto nivel",panel3);
        menu.setSelectedIndex(-1);
        return menu;
    }

        private static JTabbedPane menuCategorias(){
        JTabbedPane menu = new JTabbedPane(JTabbedPane.LEFT);
        GridLayout gridLayout1 = new GridLayout(0, 2);
        gridLayout1.setVgap(10);
        JPanel panel1= new JPanel();
        panel1.setPreferredSize(new Dimension(0, 400));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0)); // Establece un FlowLayout sin relleno

        panel1.add(new JLabel("Ingrese la información de la nueva categoría"));
        panel1.add(new JLabel(""));
        panel1.setLayout(gridLayout1);
        panel1.add(new JLabel("Tipo de vehículo:"));
        panel1.add(new PlaceHolderTextField("Ej: PickUp"));
        panel1.add(new JLabel("Nivel de lujo del vehículo:"));
        String[] opcionesLujo = {"Premium", "Intermedio", "Económico"};
        JComboBox<String> nivelesLujo = new JComboBox<>(opcionesLujo);
        panel1.add(nivelesLujo);
        panel1.add(new JLabel("Capacidad:"));
        DefaultComboBoxModel<Integer> opcionesCapacidad = new DefaultComboBoxModel<>();
        for (int i = 1; i <= 20; i++) {
            opcionesCapacidad.addElement(i);
        }
        JComboBox<Integer> capacidad = new JComboBox<>(opcionesCapacidad);
        panel1.add(capacidad);
        panel1.add(new JLabel("% a pagar por Temporada Alta:"));
        DefaultComboBoxModel<Double> opcionesTemp1 = new DefaultComboBoxModel<>();
        for (double i = 0.1; i <= 2.1; i += 0.1) {
            double numeroRedondeado = (double) Math.round(i * Math.pow(10, 1)) / Math.pow(10, 1);
            opcionesTemp1.addElement(numeroRedondeado);
        }
        JComboBox<Double> temp1 = new JComboBox<>(opcionesTemp1);
        panel1.add(temp1);
        panel1.add(new JLabel("% a pagar por Temporada Baja:"));
        JComboBox<Double> temp2 = new JComboBox<>(opcionesTemp1);
        panel1.add(temp2);
        panel1.add(new JLabel("Costo por avería leve (COP):"));
        panel1.add(new PlaceHolderTextField("Ej: 100000"));
        panel1.add(new JLabel("Costo por avería moderada:"));
        panel1.add(new PlaceHolderTextField("Ej: 200000"));
        panel1.add(new JLabel("Costo por avería total:"));
        panel1.add(new PlaceHolderTextField("Ej: 1000000"));
        panel1.add(new JLabel("Tarifa diaria:"));
        panel1.add(new PlaceHolderTextField("Ej: 150000"));
        panel1.add(new JLabel("Categoria superior:"));
        JComboBox categorias= new JComboBox<>();
        categorias.add(new JButton("Opcion 1"));
        categorias.setPreferredSize(new Dimension(100, 20)); 
        categorias.setSelectedItem(-1);
        panel1.add(categorias);
        JButton avanzar= new JButton("Registrar Categoría");
        panel1.add(avanzar);
        menu.add("Registrar categoría", panel1);
        menu.setSelectedIndex(-1);
        return menu;
    }

        private static JTabbedPane menuSedes(){
        JTabbedPane menu = new JTabbedPane(JTabbedPane.LEFT);
        GridLayout gridLayout1 = new GridLayout(0, 3);
        gridLayout1.setVgap(10);
        //Opcion 1
        JPanel panel1= new JPanel();
        panel1.setPreferredSize(new Dimension(0, 400));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0)); // Establece un FlowLayout sin relleno
        panel1.add(new JLabel("Ingrese la información de la nueva sede"));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.setLayout(gridLayout1);
        panel1.add(new JLabel("Nombre de la sede:"));
        panel1.add(new PlaceHolderTextField("Ej: Sede Bosa"));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel("Ubicacion de la sede:"));
        panel1.add(new PlaceHolderTextField("Ej: Cl. 57c Sur #87-21"));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel("Horario de apertura (entre semana):"));
        DefaultComboBoxModel<Integer> opcionesHora = new DefaultComboBoxModel<>();
        for (int i = 1; i <= 23; i++) {
            opcionesHora.addElement(i);
        }
        String[] opcionesMinutos = {"00"};
        JComboBox<Integer> hora1 = new JComboBox<>(opcionesHora);
        JComboBox<String> min1 = new JComboBox<>(opcionesMinutos);
        panel1.add(hora1);
        panel1.add(min1);
        panel1.add(new JLabel("Horario de apertura (fin de semana):"));        
        JComboBox<Integer> hora2 = new JComboBox<>(opcionesHora);
        JComboBox<String> min2 = new JComboBox<>(opcionesMinutos);
        panel1.add(hora2);
        panel1.add(min2);
        
        JButton imag= new JButton();
        imag.setBackground(Color.WHITE);

        Font font = imag.getFont().deriveFont(Font.ITALIC | Font.BOLD);

        imag.setFont(font);
        imag.setText("Cargue una foto de la sede aquí");
        panel1.add(imag);
        panel1.add(new JLabel("")); 
        JButton avanzar= new JButton("Registrar Sede");
        panel1.add(avanzar);

        menu.add("Registrar Sede",panel1);
        //Opcion 2
        JPanel panel2= new JPanel();
        panel2.setPreferredSize(new Dimension(0, 400));
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
        //TODO sedes
        panel2.add(new JLabel("Seleccione la sede que desea modificar"));
        String[] listaSedes= {"Sede1","Sede2","Sede3"};
        JComboBox<String> sedes = new JComboBox<>(listaSedes);
        panel2.add(sedes);

        JButton avanzar2 = new JButton("Modificar");
        panel2.add(avanzar2);
        avanzar2.setEnabled(false);  // Inicialmente deshabilita el botón

        sedes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateButtonState();
            }
            private void updateButtonState() {
            if (sedes.getSelectedItem() != null && !sedes.getSelectedItem().toString().isEmpty()) {
                avanzar2.setEnabled(true);  // Habilita el botón "avanzar2" si se ha seleccionado una opción o se ha ingresado texto.
            } else {
                avanzar2.setEnabled(false); // Deshabilita el botón "avanzar2" si no hay una opción seleccionada o no hay texto ingresado.
            }
        }
        });

        ((JTextComponent) sedes.getEditor().getEditorComponent()).getDocument().addDocumentListener(new DocumentListener() {
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
                if (sedes.getSelectedItem() != null && !sedes.getSelectedItem().toString().isEmpty()) {
                    avanzar2.setEnabled(true);  // Habilita el botón "avanzar2" si se ha seleccionado una opción o se ha ingresado texto.
                } else {
                    avanzar2.setEnabled(false); // Deshabilita el botón "avanzar2" si no hay una opción seleccionada o no hay texto ingresado.
                }
            }
        });
        JPanel panel2a= new JPanel();
        JPanel panel2b= new JPanel();
        avanzar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.removeAll();
                panel2.setLayout(new GridLayout(0, 1));
                // Agrega un cuadro de código de sede
                JLabel label = new JLabel("\tCódigo de Sede: ");
                Border border = new LineBorder(Color.decode("#99A0A2"), 1);
                label.setBorder(border);
                label.setBackground(Color.decode("#CCEDF7"));
                label.setOpaque(true);
                label.setPreferredSize(new Dimension(170, 25));
                panel2a.add(label);
                // Agrega panel2a a panel2
                panel2.add(panel2a);
                // Agrega panel2b a panel2
                editarSede(panel2b);
                frame.revalidate();
                frame.repaint();

                // Pregunta por la modificación del nombre de la sede
                boolModificar = PanelesModificaciones.preguntaModificaciones(panel2b, "el nombre de la sede");
                refrescar(panel2b);
                refrescar(panel2);
                if (boolModificar) {
                    // Realiza la modificación del nombre
                    String nombre="";
                    //try {
                    //    nombre = PanelesModificaciones.modificacionString(panel2b, "Nombre", "Ej: Sede Bosa");
                    //} catch (InterruptedException e1) {e1.printStackTrace();} catch (ExecutionException e1) {e1.printStackTrace();}
                    boolModificar = false;
                    // TODO: Realiza la operación correspondiente con el nombre
                    System.out.println(nombre);
                }
                // Limpia los paneles nuevamente
                // Pregunta por la modificación de la ubicación de la sede
                boolModificar = PanelesModificaciones.preguntaModificaciones(panel2b, "la ubicación de la sede");
                if (boolModificar) {
                    // Realiza la modificación de la ubicación
                    String ubicacion="";
                    //try {
                    //    ubicacion = PanelesModificaciones.modificacionString(panel2b, "Ubicación", "Ej: Cl. 57c Sur #87-21");
                    //} catch (InterruptedException e1) {e1.printStackTrace();} catch (ExecutionException e1) {e1.printStackTrace();}
                    boolModificar = false;
                    // TODO: Realiza la operación correspondiente con la ubicación
                    System.out.println(ubicacion);
                }
                }});




    







        menu.add("Modificar Sede",panel2);

        
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
    
        private static void editarSede(JPanel mainPanel){
        //1. Nombre
        //2. Ubicacion y portada
        //3. Horario de Atencion entre semana
        //4. Horario de atencion fin de semana 



        }
        
        private static void refrescar(JPanel panel){
            panel.removeAll();
            panel.repaint();
            panel.revalidate();
            frame.revalidate();
            frame.repaint();
        }

        public static void main(String[] args) {
            VentanaAdmin ventana = new VentanaAdmin();
        }
        
}
