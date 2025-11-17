
package uts.edu.poo.vista;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class FormuilarioCliente extends JFrame {
    
    private final JPanel panelFondo;
    private final JPanel panelDatos;

    public FormuilarioCliente() {
        
        panelFondo = new JPanel();
        
        panelFondo.setLayout(new BorderLayout());
        panelFondo.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        panelDatos = new JPanel();
        
        panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.X_AXIS));
        panelDatos.setBorder(new TitledBorder("Datos"));
    }
        
}
