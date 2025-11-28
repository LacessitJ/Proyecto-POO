
package uts.edu.poo.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class FormularioMoto extends JFrame implements ActionListener {
    
    private final JPanel panelFondo;
    
    private final JPanel panelNorth;
    
    private final JTable tablaCliente;
    private final JButton buscarCliente;
    private final JButton listarClientes;
    private final JTextField txBuscarCliente;
    private final JPanel panelNB;
    private final JButton seleccionarCliente;
    
    private final JPanel panelSouth;
    private final JPanel panelSouthC;
    private final JPanel panelBtn;
    
    private final JLabel lbPlaca;
    private final JLabel lbModelo;
    private final JLabel lbNMotor;
    private final JLabel lbCCPropietario;
    
    private final JTextField txPlaca;
    private final JTextField txModelo;
    private final JTextField txNMotor;
    private final JTextField txCCPropietario;
    
    private final JButton btnAgregarMoto;
    
    private ActionListener listener;

    public FormularioMoto() {
        
        setTitle("Crear Motocicleta");
        
        panelFondo = new JPanel();
        panelFondo.setLayout(new BorderLayout());
        panelFondo.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        panelNorth = new JPanel();
        
        panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.X_AXIS));
        panelNorth.setBorder(new CompoundBorder(new TitledBorder("Seleccionar propietario"), new EmptyBorder(10, 10, 10, 10)));
        
        String[] columnas = {"ID", "NOMBRE"};
        
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        
        tablaCliente = new JTable(modelo);
        
        tablaCliente.setShowHorizontalLines(true);
        tablaCliente.setShowVerticalLines(true);
        
        JScrollPane scroll = new JScrollPane(tablaCliente);
        
        panelNB = new JPanel();
        
        panelNB.setLayout(new BoxLayout(panelNB, BoxLayout.Y_AXIS));
        
        listarClientes = new JButton("Listar Clientes");
        
        txBuscarCliente = new JTextField();
        Dimension max = txBuscarCliente.getMaximumSize();
        max.height = txBuscarCliente.getPreferredSize().height;
        txBuscarCliente.setMaximumSize(max);
        
        buscarCliente = new JButton("Buscar Cliente");
        
        seleccionarCliente = new JButton("Seleccionar");
        
        panelNB.add(listarClientes);
        panelNB.add(Box.createVerticalStrut(40));
        panelNB.add(txBuscarCliente);
        panelNB.add(Box.createVerticalStrut(5));
        panelNB.add(buscarCliente);
        panelNB.add(Box.createVerticalStrut(40));
        panelNB.add(seleccionarCliente);
               
        panelNorth.add(scroll);
        panelNorth.add(Box.createHorizontalStrut(10));
        panelNorth.add(panelNB);
        
        panelSouth = new JPanel();
        panelSouth.setLayout(new GridLayout(2, 4, 5, 5));
        panelSouth.setBorder(new CompoundBorder(new TitledBorder("Ingreso de datos"), new EmptyBorder(5, 10, 10, 10)));
        
        lbPlaca = new JLabel("Placa");
        lbModelo = new JLabel("Modelo");
        lbNMotor = new JLabel("N° motor");
        lbCCPropietario = new JLabel("Propietario");
        
        txPlaca = new JTextField();
        txModelo = new JTextField();
        txNMotor = new JTextField();
        txCCPropietario = new JTextField();
        
        txCCPropietario.setEditable(false);
        
        panelSouthC = new JPanel();
        panelSouthC.setLayout(new BoxLayout(panelSouthC, BoxLayout.Y_AXIS));
        
        panelBtn = new JPanel();
        panelBtn.setLayout(new BoxLayout(panelBtn, BoxLayout.X_AXIS));
        
        btnAgregarMoto = new JButton("Agregar Motocicleta");
        
        panelBtn.add(btnAgregarMoto);
        
        panelSouth.add(lbPlaca);
        panelSouth.add(lbModelo);
        panelSouth.add(lbNMotor);
        panelSouth.add(lbCCPropietario);
        panelSouth.add(txPlaca);
        panelSouth.add(txModelo);
        panelSouth.add(txNMotor);
        panelSouth.add(txCCPropietario);        
        
        panelSouthC.add(panelSouth);
        panelSouthC.add(Box.createVerticalStrut(10));
        panelSouthC.add(panelBtn);
        panelSouthC.add(Box.createVerticalStrut(5));
        
        panelFondo.add(panelNorth, BorderLayout.NORTH);
        panelFondo.add(panelSouthC, BorderLayout.SOUTH);
        
        Container contenedor = getContentPane();
        contenedor.add(panelFondo);
        
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }        
    
    public JTable getTabla(){
        
        return tablaCliente;
        
    }

    public int getCC(){
        
        if (txCCPropietario.getText().isEmpty()) {
            
            return 0;
            
        }else {
            
            return Integer.parseInt(txCCPropietario.getText());
            
        }
        
    }
    
    public void setCC(int id){
        
        this.txCCPropietario.setText(String.valueOf(id));
        
    }
    
    public String getPlaca(){
        
        return txPlaca.getText();
        
    }
    
    public String getModelo(){
        
        return txModelo.getText();
        
    }
    
    public String getNMotor(){
        
        return txNMotor.getText();
        
    }
    
    public void iniciarListeners(ActionListener listener){
        
        this.listener = listener;
        
        btnAgregarMoto.setActionCommand("agregarMoto");
        listarClientes.setActionCommand("listarClientesM");
        seleccionarCliente.setActionCommand("seleccionarClienteM");
        
        btnAgregarMoto.addActionListener(listener);
        listarClientes.addActionListener(listener);
        seleccionarCliente.addActionListener(listener);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (listener != null) {
            
            listener.actionPerformed(e);
            
        }
        
    }
    
}
