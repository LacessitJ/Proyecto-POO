
package uts.edu.poo.vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class FormularioMoto extends JFrame implements ActionListener {
    
    private JPanel panelNorth;
    private JTable tablaCliente;
    private JButton buscarCliente;
    private JButton listarClientes;
    private JTextField txBuscarCliente;
    private JPanel panelNB;

    public FormularioMoto() {
        
        panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.X_AXIS));
        panelNorth.setBorder(new TitledBorder("Seleccionar propietario"));
        
        String[] columnas = {"ID", "NOMBRE"};
        
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        
        tablaCliente = new JTable(modelo);
        
        tablaCliente.setShowHorizontalLines(true);
        tablaCliente.setShowVerticalLines(true);
        
        JScrollPane scroll = new JScrollPane(tablaCliente);
        
        panelNB = new JPanel();
        
        panelNB.setLayout(new GridLayout(3, 1, 5, 5));
        
        panelNB.add(listarClientes);
        panelNB.add(txBuscarCliente);
        panelNB.add(buscarCliente);
        
    }        

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
    }
    
}
