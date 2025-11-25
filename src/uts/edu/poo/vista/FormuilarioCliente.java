
package uts.edu.poo.vista;

import java.awt.BorderLayout;
import java.awt.Container;
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

public class FormuilarioCliente extends JFrame implements ActionListener {
    
    private final JPanel panelFondo;
    private final JPanel panelDatos;
    private final JPanel panelInDatos;
    private final JPanel panelOperaciones;
    private final JPanel panelNorth;
    private final JPanel panelBotones;
    private final JPanel panelDetalle;
    
    private final JLabel lbId;
    private final JLabel lbName;
    private final JLabel lbDir;
    private final JLabel lbTel;
    
    private final JTextField txId;
    private final JTextField txName;
    private final JTextField txDir;
    private final JTextField txTel;
    
    private final JButton btnAgreagar;
    private final JButton btnListar;
    private final JButton btnUpdate;
    private final JButton btnDelete;
    private final JButton btnEditar;
    private final JButton btnNuevo;
    
    private final JTable tablaDatos;
    
    private ActionListener listener;

    public FormuilarioCliente() {
        
        setTitle("Clientes");
        
        panelFondo = new JPanel();
        
        panelFondo.setLayout(new BorderLayout());
        panelFondo.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        panelDatos = new JPanel();
        
        panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.X_AXIS));
        panelDatos.setBorder(new TitledBorder("Datos"));
        
        panelInDatos = new JPanel();
        panelInDatos.setLayout(new GridLayout(4, 2, 5, 5));
        panelInDatos.setBorder(new CompoundBorder(new TitledBorder("Ingresar Datos"), new EmptyBorder(5, 10, 5, 10)));
        
        lbId = new JLabel("ID:");
        lbName = new JLabel("Nombre:");
        lbTel = new JLabel("Telefono:");
        lbDir = new JLabel("Direccion:");
        
        txId = new JTextField(20);
        txName = new JTextField(20);
        txTel = new JTextField(20);
        txDir = new JTextField(20);
        
        panelInDatos.add(lbId);
        panelInDatos.add(txId);
        panelInDatos.add(lbName);
        panelInDatos.add(txName);
        panelInDatos.add(lbTel);
        panelInDatos.add(txTel);
        panelInDatos.add(lbDir);
        panelInDatos.add(txDir);
        
        panelOperaciones = new JPanel();
        panelOperaciones.setLayout(new GridLayout(4, 1, 5, 5));
        panelOperaciones.setBorder(new CompoundBorder(new TitledBorder("Operaciones"), new EmptyBorder(5, 10, 5, 10)));
        
        btnAgreagar = new JButton("CREAR");
        btnListar = new JButton("LISTAR");
        btnUpdate = new JButton("ACTUALIZAR");
        btnDelete = new JButton("ELIMINAR");
        
        panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
        
        panelNorth = new JPanel();
        panelNorth.setLayout(new BoxLayout(panelNorth, BoxLayout.Y_AXIS));
        
        btnEditar = new JButton("EDITAR");
        btnNuevo = new JButton("NUEVO");
        
        panelBotones.add(btnEditar);
        panelBotones.add(Box.createHorizontalStrut(20));
        panelBotones.add(btnNuevo);
        
        panelOperaciones.add(btnAgreagar);
        panelOperaciones.add(btnListar);
        panelOperaciones.add(btnUpdate);
        panelOperaciones.add(btnDelete);
        
        panelDatos.add(panelInDatos);
        panelDatos.add(panelOperaciones);
        
        panelNorth.add(panelDatos);
        panelNorth.add(panelBotones);
        
        panelDetalle = new JPanel();
        panelDetalle.setBorder(new TitledBorder("Detalle"));
        panelDetalle.setLayout(new BorderLayout());
        
        String[] columnas = {"ID", "NOMBRE", "TELEFONO", "DIRECCION"};
        
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        
        tablaDatos = new JTable(modelo);
        
        tablaDatos.setShowHorizontalLines(true);
        tablaDatos.setShowVerticalLines(true);
        
        JScrollPane scroll = new JScrollPane(tablaDatos);
        
        panelDetalle.add(scroll, BorderLayout.CENTER);
        
        panelFondo.add(panelNorth, BorderLayout.NORTH);
        
        panelFondo.add(panelDetalle, BorderLayout.CENTER);
        
        Container contenedor = getContentPane();
        contenedor.add(panelFondo);
        
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    
    public JTable tabla(){
        
        return this.tablaDatos;
        
    }
    
    public int getCedula(){
        
        if (txId.getText().isEmpty()) {
            
            return 0;
            
        }else {
            
            return Integer.parseInt(txId.getText());
            
        }
        
    }
    
    public String getNombre(){
        
        return txName.getText();
        
    }
    
    public String getTelefono(){
        
        return txTel.getText();
        
    }
    
    public String getDireccion(){
        
        return txDir.getText();
        
    }
    
    public void limpiarTabla(){
        
        DefaultTableModel modelo = (DefaultTableModel) tablaDatos.getModel();
        modelo.setRowCount(0);
        
    }
    
    public void limpiarRegistros(){
        
        txId.setText(null);
        txName.setText(null);
        txTel.setText(null);
        txDir.setText(null);
        
    }
    
    public void setCedula(int cedula){
        
        this.txId.setText(String.valueOf(cedula));
        
    }
    
    public void setNomnbre(String nombre){
        
        this.txName.setText(nombre);
        
    }
    
    public void setTelefono(String telefono){
        
        this.txTel.setText(telefono);
        
    }
    
    public void setDireccion(String direccion){
        
        this.txDir.setText(direccion);
        
    }
    
    public void iniciarListeners(ActionListener listener){
        
        this.listener = listener;
        
        btnAgreagar.setActionCommand("agregarCliente");
        btnEditar.setActionCommand("editarCliente");
        btnDelete.setActionCommand("eliminarCliente");
        btnListar.setActionCommand("listarCliente");
        btnNuevo.setActionCommand("nuevoCliente");
        btnUpdate.setActionCommand("actualizarCliente");
        
        btnAgreagar.addActionListener(listener);
        btnEditar.addActionListener(listener);
        btnDelete.addActionListener(listener);
        btnListar.addActionListener(listener);
        btnNuevo.addActionListener(listener);
        btnUpdate.addActionListener(listener);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (listener != null) {
            
            listener.actionPerformed(e);
            
        }
        
    }
    
}
