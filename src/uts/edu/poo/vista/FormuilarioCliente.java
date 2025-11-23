
package uts.edu.poo.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class FormuilarioCliente extends JFrame {
    
    private final JPanel panelFondo;
    private final JPanel panelDatos;
    private final JPanel panelInDatos;
    private final JPanel panelOperaciones;
    
    private final JLabel lbId;
    private final JLabel lbName;
    private final JLabel lbEmail;
    private final JLabel lbTel;
    
    private final JTextField txId;
    private final JTextField txName;
    private final JTextField txEmail;
    private final JTextField txTel;
    
    private final JButton btnAgreagar;
    private final JButton btnListar;
    private final JButton btnUpdate;
    private final JButton btnDelete;

    public FormuilarioCliente() {
        
        panelFondo = new JPanel();
        
        panelFondo.setLayout(new BorderLayout());
        panelFondo.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        panelDatos = new JPanel();
        
        panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.X_AXIS));
        panelDatos.setBorder(new TitledBorder("Datos"));
        
        panelInDatos = new JPanel();
        panelInDatos.setLayout(new GridLayout(4, 2, 5, 5));
        panelInDatos.setBorder(new TitledBorder("Ingresar Datos"));
        
        lbId = new JLabel("ID:");
        lbName = new JLabel("Nombre:");
        lbEmail = new JLabel("Correo:");
        lbTel = new JLabel("Telefono:");
        
        txId = new JTextField(20);
        txName = new JTextField(20);
        txEmail = new JTextField(20);
        txTel = new JTextField(20);
        
        panelInDatos.add(lbId);
        panelInDatos.add(txId);
        panelInDatos.add(lbName);
        panelInDatos.add(txName);
        panelInDatos.add(lbEmail);
        panelInDatos.add(txEmail);
        panelInDatos.add(lbTel);
        panelInDatos.add(txTel);
        
        panelOperaciones = new JPanel();
        panelOperaciones.setLayout(new BoxLayout(panelOperaciones, BoxLayout.Y_AXIS));
        panelOperaciones.setBorder(new TitledBorder("Operaciones"));
        
        btnAgreagar = new JButton("AGREGAR");
        btnListar = new JButton("LISTAR");
        btnUpdate = new JButton("UPDATE");
        btnDelete = new JButton("DELETE");
        
        panelOperaciones.add(btnAgreagar);
        panelOperaciones.add(btnListar);
        panelOperaciones.add(btnUpdate);
        panelOperaciones.add(btnDelete);
        
        panelDatos.add(panelInDatos);
        panelDatos.add(panelOperaciones);
        
        Container contenedor = getContentPane();
        contenedor.add(panelDatos);
        
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
        
}
