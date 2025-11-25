
package uts.edu.poo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import uts.edu.poo.modelo.Cliente;
import uts.edu.poo.modelo.ClienteDAO;
import uts.edu.poo.vista.FormuilarioCliente;
import uts.edu.poo.vista.Menu;
import java.util.List;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener {
    
    private final Menu menu;
    private final FormuilarioCliente formCliente;
    
    ClienteDAO dao = new ClienteDAO();
    Cliente c = new Cliente();
    
    DefaultTableModel modelo = new DefaultTableModel();

    public Controlador(Menu menu, FormuilarioCliente formCliente) {
        
        this.menu = menu;
        this.formCliente = formCliente;
        
    }

    public static void main(String[] args) {
        
        Menu menu = new Menu();
        FormuilarioCliente formcCliente = new FormuilarioCliente();
        Controlador controlador = new Controlador(menu, formcCliente);
        menu.iniciarListeners(controlador);
        formcCliente.iniciarListeners(controlador);
        menu.setVisible(true);
        
    }
    
    public void listar(JTable tabla){
        
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Cliente> lista = dao.listar();
        Object[] objeto = new Object[4];
        
        for (int i = 0; i < lista.size(); i++) {
            
            objeto[0] = lista.get(i).getCedula();
            objeto[1] = lista.get(i).getNombre();
            objeto[2] = lista.get(i).getTelefono();
            objeto[3] = lista.get(i).getDireccion();
            modelo.addRow(objeto);
            
        }
        
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);
        
    }
    
    public void agregar(){
        
        int cedula = formCliente.getCedula();
        String nombre = formCliente.getNombre();
        String telefono = formCliente.getTelefono();
        String direccion = formCliente.getDireccion();
        c.setCedula(cedula);
        c.setNombre(nombre);
        c.setTelefono(telefono);
        c.setDireccion(direccion);
        
        int r = dao.agregar(c);
        
        if (r == 1) {
            
            JOptionPane.showMessageDialog(formCliente, "Usuario agregado con exito");
            
        }else {
            
            JOptionPane.showMessageDialog(formCliente, "Error");
            
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String comando = e.getActionCommand();
        
        switch (comando) {
            case "Clientes":
                
                formCliente.setVisible(true);
                
                break;
                
            case "listarCliente":
                
                formCliente.limpiarTabla();
                listar(formCliente.tabla());
                
                break;
                
            case "agregarCliente":
                
                agregar();
                formCliente.limpiarTabla();
                listar(formCliente.tabla());
                formCliente.limpiarRegistros();
                
                break;
                
            default:
                throw new AssertionError();
        }
                
    }
    
}
