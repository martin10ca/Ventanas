package clases;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.Calendar;
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
        //Opción 1
        JPanel panel1= new JPanel();
        nuevoPanel1Vehiculo(panel1);
        menu.add("Registrar Vehículo",panel1);
        //Opcion 2
        JPanel panel2= new JPanel();
        nuevoPanel2Vehiculo(panel2);
        menu.add("Monitorear/ Actualizar vehículo",panel2);
        //Opcion 3
        JPanel panel3= new JPanel();
        nuevoPanel3Vehiculo(panel3);
        menu.add("Obtener visualización de alto nivel",panel3);
        menu.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
            // Obtener el índice de la pestaña seleccionada
            int selectedIndex = menu.getSelectedIndex();
            if (selectedIndex==1){
                nuevoPanel1Vehiculo(panel1);
                }
            else if (selectedIndex==2){
                nuevoPanel2Vehiculo(panel2);
            }
            else{nuevoPanel3Vehiculo(panel3);}
        }});
        menu.setSelectedIndex(-1);
        return menu;
    }

        private static JTabbedPane menuCategorias(){
        JTabbedPane menu = new JTabbedPane(JTabbedPane.LEFT);
        JPanel panel1= new JPanel();
        nuevoPanel1Categorias(panel1);
        menu.add("Registrar categoría", panel1);
        menu.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
            // Obtener el índice de la pestaña seleccionada
            int selectedIndex = menu.getSelectedIndex();
            if (selectedIndex==1){
                nuevoPanel1Categorias(panel1);
                }
        }});
        menu.setSelectedIndex(-1);
        return menu;
    }

        private static JTabbedPane menuSedes(){
        JTabbedPane menu = new JTabbedPane(JTabbedPane.LEFT);
        //Opcion 1
        JPanel panel1= new JPanel();
        nuevoPanel1Sedes(panel1);
        menu.add("Registrar Sede",panel1);
        //Opcion 2
        JPanel panel2= new JPanel();
        nuevoPanel2Sedes(panel2);
        menu.add("Modificar Sede",panel2);
        menu.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                // Obtener el índice de la pestaña seleccionada
                int selectedIndex = menu.getSelectedIndex();
                if (selectedIndex==1){
                    nuevoPanel1Sedes(panel1);
                }
                else {nuevoPanel2Sedes(panel2);}
        }});

        
        menu.setSelectedIndex(-1);
        return menu;
    }
        private static JTabbedPane menuSeguros(){
        JTabbedPane menu = new JTabbedPane(JTabbedPane.LEFT);
        //Opcion 1
        JPanel panel1= new JPanel();
        nuevoPanel1Seguros(panel1);
        menu.add("Registrar Seguro",panel1);
        //Opcion 2
        JPanel panel2= new JPanel();
        nuevoPanel2Seguros(panel2);
        menu.add("Modificar Seguro",panel2);
        //Opcion 3
        JPanel panel3= new JPanel();
        nuevoPanel3Seguros(panel3);
        menu.add("Eliminar Seguro",panel3);
        menu.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
        // Obtener el índice de la pestaña seleccionada
            int selectedIndex = menu.getSelectedIndex();
                if (selectedIndex==1){
                    nuevoPanel1Seguros(panel1);
                }
                else if (selectedIndex==2) {
                    nuevoPanel2Seguros(panel2);}
                else {nuevoPanel3Seguros(panel3);}
        }});
        menu.setSelectedIndex(-1);
        return menu;
    }
        private static JTabbedPane menuPersonal(){
        JTabbedPane menu = new JTabbedPane(JTabbedPane.LEFT);
        JPanel panel1 = new JPanel();
        nuevoPanel1Personal(panel1);
        menu.add("Registrar administrador local",panel1);
        JPanel panel2= new JPanel();
        nuevoPanel2Personal(panel2);
        menu.add("Actualizar sede de un administrador local",panel2);
        menu.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
        // Obtener el índice de la pestaña seleccionada
            int selectedIndex = menu.getSelectedIndex();
                if (selectedIndex==1){
                    nuevoPanel1Personal(panel1);
                }
                else{nuevoPanel2Personal(panel2);}
        }});
        
        menu.setSelectedIndex(-1);
        return menu;
    }
        private static JTabbedPane menuTarifasPeriodos(){
        JTabbedPane menu = new JTabbedPane(JTabbedPane.LEFT);
        JPanel panel1= new JPanel();
        nuevoPanelTarifas(panel1);
        menu.add("Actualizar costo por conductor adicional",panel1);
        JPanel panel2= new JPanel();
        nuevoPanelTarifas(panel2);
        menu.add("Actualizar costo por traslado de vehículo",panel2);
        JPanel panel3= new JPanel();
        //nuevoPanelPeriodos(panel3);
        menu.add("Actualizar periodo de temporada alta",panel3);
        JPanel panel4= new JPanel();
        //nuevoPanelPeriodos(panel4);
        menu.add("Actualizar periodo de temporada baja",panel4);
        menu.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
        // Obtener el índice de la pestaña seleccionada
            int selectedIndex = menu.getSelectedIndex();
                if (selectedIndex==1){
                    nuevoPanelTarifas(panel1);
                }
                else if (selectedIndex==2){nuevoPanelTarifas(panel2);
                }
                //else if (selectedIndex==3){nuevoPanelPeriodos(panel3);}
                //else {nuevoPanelPeriodos(panel4);}
        }});
        
        menu.setSelectedIndex(-1);
        return menu;
    }
        private static void nuevoPanel1Vehiculo(JPanel panel1){
        refresh(panel1);
        //
        PlaceHolderTextField placa=new PlaceHolderTextField("Ej: ABC123");
        PlaceHolderTextField marca= new PlaceHolderTextField("Ej: Chevrolet");
        PlaceHolderTextField modelo = new PlaceHolderTextField("Ej: Aveo");
        PlaceHolderTextField color= new PlaceHolderTextField("Ej: Azul");
        ButtonGroup opcionTransmision= new ButtonGroup();
        JComboBox categorias= new JComboBox<>();
        JComboBox sedes= new JComboBox<String>();
        //
        panel1.setPreferredSize(new Dimension(0, 400));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0)); // Establece un FlowLayout sin relleno
        GridLayout gridLayout1 = new GridLayout(0, 2);
        gridLayout1.setVgap(10);
        panel1.add(new JLabel("Ingrese la información del nuevo vehículo"));
        panel1.add(new JLabel(""));
        panel1.setLayout(gridLayout1);
        panel1.add(new JLabel("Placa:"));
        panel1.add(placa);
        panel1.add(new JLabel("Marca:"));
        panel1.add(marca);
        panel1.add(new JLabel("Modelo:"));
        panel1.add(modelo);
        panel1.add(new JLabel("Color:"));
        panel1.add(color);
        panel1.add(new JLabel("Transmisión:"));
        panel1.add(new JLabel(""));
        JRadioButton manual=new JRadioButton("Manual");
        JRadioButton automatica= new JRadioButton("Automática");
        opcionTransmision.add(manual);
        opcionTransmision.add(automatica);
        panel1.add(manual);
        panel1.add(automatica);
        panel1.add(new JLabel("Categoria:"));
        //TODO con un for añadir categorias
        String[] opcionesCategorias= {"Categoria1","Categoria2"};
        categorias= new JComboBox<>(opcionesCategorias);
        categorias.setPreferredSize(new Dimension(100, 20)); 
        categorias.setSelectedItem(-1);
        panel1.add(categorias);
        panel1.add(new JLabel("Sedes:"));
        //TODO con un for añadir sedes
        String[] opcionesSedes= {"Sede1","Sede2"};
        sedes= new JComboBox<String>(opcionesSedes);

        sedes.setPreferredSize(new Dimension(20, 20)); 
        sedes.setSelectedItem(-1);
        panel1.add(sedes);
        JButton avanzar1= new JButton("Registrar vehículo");
        panel1.add(avanzar1);
    }
        private static void nuevoPanel2Vehiculo(JPanel panel2){
        refresh(panel2);
        //
        PlaceHolderTextField placa=new PlaceHolderTextField("Placa");
        //
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
            //Busqueda Carro
        JPanel panel2a= new JPanel();
        panel2a.setPreferredSize(new Dimension(0, 80));
        panel2a.setLayout(new BoxLayout(panel2a, BoxLayout.Y_AXIS));
        panel2a.add(new JLabel("Ingrese la placa del vehículo que desea monitorear/actualizar"));
        panel2a.add(new JLabel("\n"));
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
    }
        private static void nuevoPanel3Vehiculo(JPanel panel3){
        refresh(panel3);
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
    }

        private static void nuevoPanel1Categorias(JPanel panel1){
        refresh(panel1);
        //
        PlaceHolderTextField tipoVehiculo= new PlaceHolderTextField("Ej: PickUp");
        JComboBox<Integer> capacidad = new JComboBox<>();
        JComboBox<Double> temp1 = new JComboBox<>();
        JComboBox<Double> temp2 = new JComboBox<>();
        NumericOnlyTextField costoLeve= new NumericOnlyTextField();
        NumericOnlyTextField costoModerado= new NumericOnlyTextField();
        NumericOnlyTextField costoGrave= new NumericOnlyTextField();
        NumericOnlyTextField tarifa= new NumericOnlyTextField();
        JComboBox categorias= new JComboBox<>();
        //
        panel1.setPreferredSize(new Dimension(0, 400));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0)); // Establece un FlowLayout sin relleno
        GridLayout gridLayout1 = new GridLayout(0, 2);
        gridLayout1.setVgap(10);
        panel1.add(new JLabel("Ingrese la información de la nueva categoría"));
        panel1.add(new JLabel(""));
        panel1.setLayout(gridLayout1);
        panel1.add(new JLabel("Tipo de vehículo:"));
        panel1.add(tipoVehiculo);
        panel1.add(new JLabel("Nivel de lujo del vehículo:"));
        String[] opcionesLujo = {"Premium", "Intermedio", "Económico"};
        JComboBox<String> nivelesLujo = new JComboBox<>(opcionesLujo);
        panel1.add(nivelesLujo);
        panel1.add(new JLabel("Capacidad:"));
        DefaultComboBoxModel<Integer> opcionesCapacidad = new DefaultComboBoxModel<>();
        for (int i = 1; i <= 20; i++) {
            opcionesCapacidad.addElement(i);
        }
        capacidad = new JComboBox<>(opcionesCapacidad);
        panel1.add(capacidad);
        panel1.add(new JLabel("% a pagar por Temporada Alta:"));
        DefaultComboBoxModel<Double> opcionesTemp1 = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<Double> opcionesTemp2 = new DefaultComboBoxModel<>();
        for (double i = 0.1; i <= 2.1; i += 0.1) {
            double numeroRedondeado = (double) Math.round(i * Math.pow(10, 1)) / Math.pow(10, 1);
            opcionesTemp1.addElement(numeroRedondeado);
            opcionesTemp2.addElement(numeroRedondeado);

        }
        temp1 = new JComboBox<>(opcionesTemp1);
        panel1.add(temp1);
        panel1.add(new JLabel("% a pagar por Temporada Baja:"));
        temp2 = new JComboBox<>(opcionesTemp2);
        panel1.add(temp2);
        panel1.add(new JLabel("Costo por avería leve (COP):"));
        panel1.add(costoLeve);
        panel1.add(new JLabel("Costo por avería moderada:"));
        panel1.add(costoModerado);
        panel1.add(new JLabel("Costo por avería total:"));
        panel1.add(costoGrave);
        panel1.add(new JLabel("Tarifa diaria:"));
        panel1.add(tarifa);
        panel1.add(new JLabel("Categoria superior:"));
        //TODO
        categorias.setPreferredSize(new Dimension(100, 20)); 
        categorias.setSelectedItem(-1);
        panel1.add(categorias);
        JButton avanzar= new JButton("Registrar Categoría");
        panel1.add(avanzar);
    }
        private static void nuevoPanel1Sedes(JPanel panel1){
        refresh(panel1);
        //
        PlaceHolderTextField nomSede= new PlaceHolderTextField("Ej: Sede Bosa");
        PlaceHolderTextField ubiSede= new PlaceHolderTextField("Ej: Cl. 57c Sur #87-21");
        DefaultComboBoxModel<Integer> opcionesHora1 = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<Integer> opcionesHora2 = new DefaultComboBoxModel<>();
        JComboBox<Integer> hora1 = new JComboBox<>();
        JComboBox<String> min1 = new JComboBox<>();
        JComboBox<Integer> hora2 = new JComboBox<>();
        JComboBox<String> min2 = new JComboBox<>();
        //
        GridLayout gridLayout1 = new GridLayout(0, 3);
        gridLayout1.setVgap(10);
        panel1.setPreferredSize(new Dimension(0, 400));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0)); // Establece un FlowLayout sin relleno
        panel1.add(new JLabel("Ingrese la información de la nueva sede"));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.setLayout(gridLayout1);
        panel1.add(new JLabel("Nombre de la sede:"));
        panel1.add(nomSede);
        panel1.add(new JLabel(""));
        panel1.add(new JLabel("Ubicación de la sede:"));
        panel1.add(ubiSede);
        panel1.add(new JLabel(""));
        panel1.add(new JLabel("Horario de apertura entre semana (hh mm):"));
        for (int i = 1; i <= 23; i++) {
            opcionesHora1.addElement(i);
            opcionesHora2.addElement(i);

        }
        String[] opcionesMinutos1 = {"00"};
        String[] opcionesMinutos2 = {"00"};

        hora1 = new JComboBox<>(opcionesHora1);
        min1 = new JComboBox<>(opcionesMinutos1);
        panel1.add(hora1);
        panel1.add(min1);
        panel1.add(new JLabel("Horario de apertura para fin de semana (hh mm):"));        
        hora2 = new JComboBox<>(opcionesHora2);
        min2 = new JComboBox<>(opcionesMinutos2);
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

    }
        public static void nuevoPanel2Sedes(JPanel panel2){
        refresh(panel2);
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
            public void actionPerformed(ActionEvent e) {updateButtonState();}
            private void updateButtonState() {
            if (sedes.getSelectedItem() != null && !sedes.getSelectedItem().toString().isEmpty()) {
                avanzar2.setEnabled(true);} else {avanzar2.setEnabled(false);}}});
        ((JTextComponent) sedes.getEditor().getEditorComponent()).getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {updateButtonState();}
            @Override
            public void removeUpdate(DocumentEvent e) {updateButtonState();}
            @Override
            public void changedUpdate(DocumentEvent e) {updateButtonState();}
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
                EditorObjetos editor = new EditorObjetos();
                editor.editorSede(panel2b);
                editor.editar();
                panel2.add(panel2b);
                frame.revalidate();
                frame.repaint();}});
    }
        public static void nuevoPanel1Seguros(JPanel panel1){
            refresh(panel1);
            //
            PlaceHolderTextField descripcion= new PlaceHolderTextField("Ej: Seguro ante robos");
            JComboBox<Double> pctg = new JComboBox<>();
            //
            GridLayout gridLayout1 = new GridLayout(0, 2);
            gridLayout1.setVgap(10);
            panel1.setPreferredSize(new Dimension(0, 400));
            panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0)); // Establece un FlowLayout sin relleno
            panel1.add(new JLabel("Ingrese la información del nuevo seguro"));
            panel1.add(new JLabel(""));
            panel1.setLayout(gridLayout1);
            panel1.add(new JLabel("Descripción del seguro:"));
            panel1.add(descripcion);
            panel1.add(new JLabel("Porcentaje de la tarifa diaria a cobrar:"));
            DefaultComboBoxModel<Double> opciones = new DefaultComboBoxModel<>();
            for (double i = 0.1; i <= 2.0; i += 0.1) {
                double numeroRedondeado = Math.round(i * 10.0) / 10.0;
                opciones.addElement(numeroRedondeado);
            }
            pctg = new JComboBox<>(opciones);
            panel1.add(pctg);
            panel1.add(Box.createRigidArea(new Dimension(0,150)));
            panel1.add(Box.createRigidArea(new Dimension(0,150)));
            JButton avanzar = new JButton("Registrar Seguro");
            panel1.add(avanzar);

        }
            public static void nuevoPanel2Seguros(JPanel panel2){
            refresh(panel2);
            GridLayout gridLayout1 = new GridLayout(0, 2);
            gridLayout1.setVgap(10);
            panel2.setPreferredSize(new Dimension(0, 400));
            panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0)); // Establece un FlowLayout sin relleno
            panel2.add(new JLabel("Seleccione el seguro que desea modificar"));
            panel2.add(new JLabel(""));
            panel2.setLayout(gridLayout1);
            //TODO opciones
            String[] opciones = {"Seguro1","Seguro2"};
            JComboBox<String> seguros = new JComboBox<>(opciones);
            panel2.add(seguros);
            JButton avanzar = new JButton("Modificar Seguro");
            panel2.add(Box.createRigidArea(new Dimension(0,200)));
            panel2.add(Box.createRigidArea(new Dimension(0,200)));
            panel2.add(Box.createRigidArea(new Dimension(0,200)));
            panel2.add(avanzar);
            JPanel panel2a= new JPanel();
            JPanel panel2b= new JPanel();
            avanzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.removeAll();
                panel2.setLayout(new GridLayout(0, 1));
                // Agrega un cuadro de código de sede
                JLabel label = new JLabel("\tCódigo de Seguro: ");
                Border border = new LineBorder(Color.decode("#99A0A2"), 1);
                label.setBorder(border);
                label.setBackground(Color.decode("#CCEDF7"));
                label.setOpaque(true);
                label.setPreferredSize(new Dimension(170, 25));
                panel2a.add(label);
                // Agrega panel2a a panel2
                panel2.add(panel2a);
                // Agrega panel2b a panel2
                EditorObjetos editor = new EditorObjetos();
                editor.editorSeguro(panel2b);
                editor.editar();
                panel2.add(panel2b);
                frame.revalidate();
                frame.repaint();}});


        }
            public static void nuevoPanel3Seguros(JPanel panel3){
            refresh(panel3);
            //
            JComboBox<String> seguros = new JComboBox<>();

            //
            GridLayout gridLayout1 = new GridLayout(0, 2);
            gridLayout1.setVgap(10);
            panel3.setPreferredSize(new Dimension(0, 400));
            panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0)); // Establece un FlowLayout sin relleno
            panel3.add(new JLabel("Seleccione el seguro que desea eliminar"));
            panel3.add(new JLabel(""));
            panel3.setLayout(gridLayout1);
            //TODO opciones
            String[] opciones = {"Seguro1","Seguro2"};
            seguros = new JComboBox<>(opciones);
            panel3.add(seguros);
            JButton avanzar = new JButton("Eliminar Seguro");
            panel3.add(Box.createRigidArea(new Dimension(0,200)));
            panel3.add(Box.createRigidArea(new Dimension(0,200)));
            panel3.add(Box.createRigidArea(new Dimension(0,200)));
            panel3.add(avanzar);
            avanzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh(panel3);
            }});
        }



            public static void nuevoPanel1Personal(JPanel panel1){
            refresh(panel1);
            //
            PlaceHolderTextField login= new PlaceHolderTextField("Ej: m.acosta");
            PlaceHolderTextField password = new PlaceHolderTextField("acosta123");
            //FALTA SEDES
            //
            GridLayout gridLayout1 = new GridLayout(0, 2);
            gridLayout1.setVgap(10);
            panel1.setPreferredSize(new Dimension(0, 400));
            panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0)); // Establece un FlowLayout sin relleno
            panel1.add(new JLabel("Ingrese la información del nuevo administrador local"));
            panel1.add(new JLabel(""));
            panel1.setLayout(gridLayout1);
            panel1.add(new JLabel("Login"));
            panel1.add(login);
            JButton avanzar = new JButton("Siguiente");
            panel1.add(Box.createRigidArea(new Dimension(0,200)));
            panel1.add(Box.createRigidArea(new Dimension(0,200)));
            panel1.add(avanzar);
            avanzar.setVisible(false);
            login.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    avanzar.setVisible(!login.getText().trim().isEmpty());
                }});
            avanzar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    //TODO verificar login
                    boolean existeLogin=false;
                    if (!existeLogin){
                        refresh(panel1);
                        login.setEditable(false);
                        panel1.add(new JLabel("Complete el registro del usuario"));
                        panel1.add(new JLabel(""));
                        panel1.add(new JLabel("Password"));
                        panel1.add(password);
                        panel1.add(new JLabel("Sede que administrará"));
                        // TODO
                        String[] opciones = {"Sede1", "Sede2"};
                        JComboBox<String> sedes = new JComboBox<>(opciones);
                        panel1.add(sedes);
                        JButton avanzar2 = new JButton("Agregar administrador local");
                        panel1.add(avanzar2);
                        avanzar2.setVisible(false);
                        password.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                avanzar2.setVisible(!password.getText().trim().isEmpty());
                                }});          
                        avanzar2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                // TODO: Realizar acciones al presionar "avanzar2"
                                System.out.println("login:"+login.getText());
                                System.out.println("Opcion sede:"+sedes.getSelectedItem().toString());
                                System.out.println(("password:"+password.getText()));

                                CambioGuardadoDialog();
                                refresh(panel1);
                            }
                        }); 
                    }}});}
                        
        public static void nuevoPanel2Personal(JPanel panel2){
            refresh(panel2);
            //
            PlaceHolderTextField login= new PlaceHolderTextField("Ej: m.acosta");
            //FALTA PASSWORD
            //FALTA SEDE
            //
            GridLayout gridLayout1 = new GridLayout(0, 2);
            gridLayout1.setVgap(10);
            panel2.setPreferredSize(new Dimension(0, 400));
            panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0)); // Establece un FlowLayout sin relleno
            panel2.add(new JLabel("Ingrese el login del administrador local"));
            panel2.add(new JLabel(""));
            panel2.setLayout(gridLayout1);
            panel2.add(new JLabel("Login"));
            panel2.add(login);
            JButton avanzar = new JButton("Siguiente");
            panel2.add(Box.createRigidArea(new Dimension(0,200)));
            panel2.add(Box.createRigidArea(new Dimension(0,200)));
            panel2.add(avanzar);
            avanzar.setVisible(false);
            login.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    avanzar.setVisible(!login.getText().trim().isEmpty());
                }});
            avanzar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    //TODO verificar si es admin
                    boolean esAdmin=false;
                    if (!esAdmin){
                        refresh(panel2);
                        login.setEditable(false);
                        panel2.add(new JLabel("Complete la actualización del usuario"));
                        panel2.add(new JLabel(""));

                        panel2.add(new JLabel("Password"));
                        PlaceHolderTextField password = new PlaceHolderTextField("acosta123");
                        panel2.add(password);
                        panel2.add(new JLabel("Sede que administrará"));
                        // TODO
                        String[] opciones = {"Sede1", "Sede2"};
                        JComboBox<String> sedes = new JComboBox<>(opciones);
                        panel2.add(sedes);
                        JButton avanzar2 = new JButton("Actualizar administrador local");
                        panel2.add(avanzar2);
                        avanzar2.setVisible(false);
                        password.addActionListener(new ActionListener(){
                            public void actionPerformed(ActionEvent e) {
                                avanzar2.setVisible(!password.getText().trim().isEmpty());
                                }});          
                        avanzar2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                // TODO: Realizar acciones al presionar "avanzar2"
                                System.out.println("login:"+login.getText());
                                System.out.println("Opcion sede:"+sedes.getSelectedItem().toString());
                                System.out.println(("password:"+password.getText()));
                                CambioGuardadoDialog();
                                refresh(panel2);
                            }
                        }); 
                    }}});}

            public static void nuevoPanelTarifas(JPanel panel) {
                refresh(panel);
                //
                NumericOnlyTextField precio = new NumericOnlyTextField();
                //
                panel.setLayout(new GridLayout(0, 2));
                panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 80));
                JLabel label = new JLabel("Nuevo Precio (COP) ");
                precio.setSize(new Dimension(100,50));
                JButton actualizarPrecio = new JButton("Actualizar precio");  
                actualizarPrecio.setSize(new Dimension(100,50));
                    
                panel.add(label);
                panel.add(precio);
                panel.add(Box.createRigidArea(new Dimension(0, 100)));
                panel.add(Box.createRigidArea(new Dimension(0, 100)));
                panel.add(actualizarPrecio);
                    
                actualizarPrecio.setVisible(false);
                
                precio.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    actualizarPrecio.setVisible(!precio.getText().trim().isEmpty());
                }
                });
                
            actualizarPrecio.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Precio actualizado: " + precio.getText());
                    CambioGuardadoDialog();
                    refresh(panel);
                }
            });
         }
                    
        public static void nuevoPanelPeriodos(JPanel panel){
                refresh(panel);
                //
                String periodo="";
                //
                panel.setLayout(new GridLayout(0, 2));
                panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 80));
                JLabel label = new JLabel("Nuevo Periodo ");
                JButton actualizar = new JButton("Actualizar periodo");  
                actualizar.setSize(new Dimension(100,50));
                DateSelectorPanel panelPeriodo= new DateSelectorPanel(panel,Calendar.getInstance().get(Calendar.YEAR+1));
                panel.add(label);
                panel.add(Box.createRigidArea(new Dimension(0, 100)));
                panel.add(Box.createRigidArea(new Dimension(0, 100)));
                panel.add(actualizar);
                    
                actualizar.setVisible(false);
                periodo=panelPeriodo.getSelectedMonth()+panelPeriodo.getSelectedDay();               
                actualizar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    actualizar.setVisible(!panelPeriodo.getSelectedMonth().trim().isEmpty());
                }
                });
                
                actualizar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Precio actualizado: " + panelPeriodo.getSelectedMonth()+panelPeriodo.getSelectedDay());
                    CambioGuardadoDialog();
                    refresh(panel);
                }
            });
            
        }
        public static void CambioGuardadoDialog() {
            JDialog dialog= new JDialog();
            GridLayout gridLayout1 = new GridLayout(1, 0);
            dialog.setLayout(gridLayout1);
            dialog.setTitle("Notificacion");
            dialog.setModalityType(ModalityType.APPLICATION_MODAL); // Bloquea otras ventanas mientras está abierta
            dialog.setSize(300, 200);
            dialog.setLocationRelativeTo(null); // Centra el diálogo en la pantalla
            JLabel label=new JLabel("    Cambio/s guardado/s"); 
            dialog.add(label);
            JButton okButton = new JButton("OK");
            okButton.setBounds(100, 25, 70, 30); // Establece la posición y tamaño del botón
            okButton.addActionListener(e -> {
                dialog.dispose(); // Cierra el diálogo al hacer clic en el botón "OK"
            });
    
            dialog.add(okButton);
            dialog.setVisible(true);
        }
        public static void refresh(JPanel panel){
            panel.removeAll();
            panel.repaint();
            panel.validate();
        }
        public static void main(String[] args) {
            VentanaAdmin ventana = new VentanaAdmin();
        }
        
}
