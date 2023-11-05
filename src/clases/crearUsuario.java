package clases;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class crearUsuario extends JPanel {
    public crearUsuario() {
        setLayout(new GridLayout(0, 1));
        JLabel labelMensaje = new JLabel("¡Ya falta poco! ");
        JLabel labelUsuario = new JLabel("Nombre de Usuario (login): ");
        PlaceHolderTextField campoUsuario = new PlaceHolderTextField("Ej: jlopez123");
        JLabel labelContraseña = new JLabel("Contraseña: ");
        JPasswordField campoContraseña = new JPasswordField();

        add(labelMensaje);
        add(labelUsuario);
        add(campoUsuario);



        add(labelContraseña);
        add(campoContraseña);
    }
    
}
