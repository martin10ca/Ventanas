package clases;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelesModificaciones {
    private static boolean booleanEleccion;
    private static String retornoString;

    public static boolean preguntaModificaciones(JPanel mainPanel,String s) {
        booleanEleccion=false;
        JPanel panel= new JPanel();
        panel.setBounds(0, 0, 0, 0);

        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton opcion1 = new JRadioButton("Opción 1");
        JRadioButton opcion2 = new JRadioButton("Opción 2");
        buttonGroup.add(opcion1);
        buttonGroup.add(opcion2);
        JButton avanzar = new JButton("Avanzar");
        avanzar.setEnabled(false);

        opcion1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (opcion1.isSelected()) {
                    avanzar.setEnabled(true);
            	}}});
        opcion2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (opcion2.isSelected()) {
                    avanzar.setEnabled(true);
            	}}});
        avanzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (opcion1.isSelected()) {
                    booleanEleccion=true;
                }}});
        panel.add(new JLabel("¿Desea modificar "+s+"?"));
        panel.add(opcion1);
        panel.add(opcion2);
        panel.add(avanzar);
        panel.setVisible(true);
        mainPanel.add(panel);
        return booleanEleccion;
    }
    public static String modificacionString(JPanel mainPanel, String nom,String ejem){
        retornoString="";
        JPanel panel= new JPanel();
        panel.setBounds(0, 0, 0, 0);
        PlaceHolderTextField input=new PlaceHolderTextField(ejem); 
        JButton avanzar = new JButton("Avanzar");
        avanzar.setEnabled(false);

        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                avanzar.setEnabled(!input.getText().trim().isEmpty());
        }});
         avanzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retornoString=input.getText();
        }});
        panel.add(new JLabel(nom));
        panel.add(input);
        panel.add(avanzar);
        panel.setVisible(true);
        mainPanel.add(panel);
        return  retornoString;
    }
}
