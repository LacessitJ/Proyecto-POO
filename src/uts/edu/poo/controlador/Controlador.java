
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
import uts.edu.poo.modelo.MotoDAO;
import uts.edu.poo.modelo.Motocicleta;
import uts.edu.poo.vista.FormularioCRUDMoto;
import uts.edu.poo.vista.FormularioMoto;

public class Controlador implements ActionListener {
    
    private final Menu menu;
    private final FormuilarioCliente formCliente;
    private final FormularioMoto formMoto;
    private final FormularioCRUDMoto formCRUDMoto;
    
    ClienteDAO dao = new ClienteDAO();
    Cliente c = new Cliente();
    
    MotoDAO mDAO = new MotoDAO();
    Motocicleta m = new Motocicleta();
    
    DefaultTableModel modelo = new DefaultTableModel();

    public Controlador(Menu menu, FormuilarioCliente formCliente, FormularioMoto formMoto, FormularioCRUDMoto formCRUDMoto) {
        
        this.menu = menu;
        this.formCliente = formCliente;
        this.formMoto = formMoto;
        this.formCRUDMoto = formCRUDMoto;
        
    }

    public static void main(String[] args) {
        
        Menu menu = new Menu();
        FormuilarioCliente formcCliente = new FormuilarioCliente();
        FormularioMoto formcMoto = new FormularioMoto();
        FormularioCRUDMoto formcCRUDMoto = new FormularioCRUDMoto();
        Controlador controlador = new Controlador(menu, formcCliente, formcMoto, formcCRUDMoto);
        menu.iniciarListeners(controlador);
        formcCliente.iniciarListeners(controlador);
        formcMoto.iniciarListeners(controlador);
        formcCRUDMoto.iniciarListeners(controlador);
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
    
    public void listarCM(JTable tabla){
        
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Cliente> lista = mDAO.listar();
        Object[] objeto = new Object[4];
        
        for (int i = 0; i < lista.size(); i++) {
            
            objeto[0] = lista.get(i).getCedula();
            objeto[1] = lista.get(i).getNombre();
            modelo.addRow(objeto);
            
        }
        
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);
        
    }
    
    public void listarMotos(JTable tabla){
        
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Motocicleta> lista = mDAO.listarMotos();
        Object[] objeto = new Object[4];
        
        for (int i = 0; i < lista.size(); i++) {
            
            objeto[0] = lista.get(i).getPlaca();
            objeto[1] = lista.get(i).getModelo();
            objeto[2] = lista.get(i).getnMotor();
            objeto[3] = lista.get(i).getCedulaCliente();
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
    
    public void agregarCM(){
        
        int cedula = formMoto.getCC();
        String placa = formMoto.getPlaca();
        String modeloo = formMoto.getModelo();
        String nMotor = formMoto.getNMotor();
        m.setCedulaCliente(cedula);
        m.setPlaca(placa);
        m.setModelo(modeloo);
        m.setnMotor(nMotor);
        
        int r = mDAO.agregar(m);
        
        if (r == 1) {
            
            JOptionPane.showMessageDialog(formCliente, "Motocicleta agregada con exito");
            
        }else {
            
            JOptionPane.showMessageDialog(formCliente, "Error");
            
        }
        
    }
    
    public void seleccionar(){
        
        int fila = formCliente.tabla().getSelectedRow();
        
        if (fila == -1) {
            
            JOptionPane.showMessageDialog(formCliente, "Debe seleccionar una fila");
            
        }else {
            
            int id = Integer.parseInt((String) formCliente.tabla().getValueAt(fila, 0).toString());
            String nombre = (String) formCliente.tabla().getValueAt(fila, 1);
            String telefono = (String) formCliente.tabla().getValueAt(fila, 2);
            String direccion = (String) formCliente.tabla().getValueAt(fila, 3);
            
            formCliente.setCedula(id);
            formCliente.setNomnbre(nombre);
            formCliente.setTelefono(telefono);
            formCliente.setDireccion(direccion);
            
        }
        
    }
    
    public void seleccionarMoto(){
        
        int fila = formCRUDMoto.tabla().getSelectedRow();
        
        if (fila == -1) {
            
            JOptionPane.showMessageDialog(formCRUDMoto, "Debe seleccionar una fila");
            
        }else {
            
            String placa = (String) formCRUDMoto.tabla().getValueAt(fila, 0);
            String modeloo = (String) formCRUDMoto.tabla().getValueAt(fila, 1);
            String nMotor = String.valueOf(formCRUDMoto.tabla().getValueAt(fila, 2));
            int id = Integer.parseInt((String) formCRUDMoto.tabla().getValueAt(fila, 3).toString());
            
            formCRUDMoto.setCedula(id);
            formCRUDMoto.setPlaca(placa);
            formCRUDMoto.setModelo(modeloo);
            formCRUDMoto.setNMotor(nMotor);
            
        }
        
    }
    
    public void seleccionarCM(){
        
        int fila = formMoto.getTabla().getSelectedRow();
        
        if (fila == -1) {
            
            JOptionPane.showMessageDialog(formMoto, "Debe seleccionar una fila");
            
        }else {
            
            int id = Integer.parseInt((String) formMoto.getTabla().getValueAt(fila, 0).toString());
            
            formMoto.setCC(id);
            
        }
        
    }
    
    public void actualizar(){
        
        if (formCliente.getCedula() == 0) {
            
            JOptionPane.showMessageDialog(formCliente, "No se identifica el id, debe seleccionar la opcion editar");
            
        }else {
            
            int cc = formCliente.getCedula();
            String nombre = formCliente.getNombre();
            String tel = formCliente.getTelefono();
            String dir = formCliente.getDireccion();
            c.setCedula(cc);
            c.setNombre(nombre);
            c.setTelefono(tel);
            c.setDireccion(dir);
            
            int r = dao.actualizar(c);
            
            if (r == 1) {
                
                JOptionPane.showMessageDialog(formCliente, "Usuario actualizado");
                
            }else {
                
                JOptionPane.showMessageDialog(formCliente, "Error");
                
            }
            
        }
        
    }
    
    public void actualizarMoto(){
        
        int cc = formCRUDMoto.getCedula();
        String placa = formCRUDMoto.getPlaca();
        String modeloo = formCRUDMoto.getModelo();
        String nMotor = formCRUDMoto.getNMotor();
        m.setCedulaCliente(cc);
        m.setPlaca(placa);
        m.setModelo(modeloo);
        m.setnMotor(nMotor);
            
        int r = mDAO.actualizarMoto(m);
            
        if (r == 1) {
             
            JOptionPane.showMessageDialog(formCliente, "Motocicleta actualizada");
                
        }else{        
                
            JOptionPane.showMessageDialog(formCliente, "Error");
                
        }
        
    }
    
    public void eliminar(){
        
        int fila = formCliente.tabla().getSelectedRow();
        
        if (fila == -1) {
            
            JOptionPane.showMessageDialog(formCliente, "Debe seleccionar una fila");
            
        }else {
            
            int id = Integer.parseInt((String) formCliente.tabla().getValueAt(fila, 0).toString());
            dao.eliminar(id);
            JOptionPane.showMessageDialog(formCliente, "Usuario eliminado");
            
        }
        
    }
    
    public void eliminarMoto(){
        
        int fila = formCRUDMoto.tabla().getSelectedRow();
        
        if (fila == -1) {
            
            JOptionPane.showMessageDialog(formCRUDMoto, "Debe seleccionar una fila");
            
        }else {
            
            String placa = String.valueOf(formCRUDMoto.tabla().getValueAt(fila, 0));
            mDAO.eliminarMoto(placa);
            JOptionPane.showMessageDialog(formCRUDMoto, "Motocicleta eliminada");
            
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
                
            case "editarCliente":
                
                seleccionar();
                
                break;
                
            case "actualizarCliente":
                
                actualizar();
                formCliente.limpiarTabla();
                listar(formCliente.tabla());
                formCliente.limpiarRegistros();
                
                break;
                
            case "eliminarCliente":
                
                eliminar();
                formCliente.limpiarTabla();
                listar(formCliente.tabla());
                
                break;
                
            case "Motos":
                
                formCRUDMoto.setVisible(true);
                
                break;
                
            case "listarClientesM":
                
                listarCM(formMoto.getTabla());
                
                break;
                
            case "seleccionarClienteM":
                
                seleccionarCM();
                
                break;
                
            case "agregarMoto":
                
                agregarCM();
                
                formMoto.dispose();
                
                break;
                
            case "FormularioMoto":
                
                formMoto.setVisible(true);
                
                break;
                
            case "listarMoto":
                
                formCRUDMoto.limpiarTabla();
                listarMotos(formCRUDMoto.tabla());
                
                break;
                
            case "editarMotoM":
                
                seleccionarMoto();
                
                break;
                
            case "actualizarMoto":
                
                actualizarMoto();
                formCRUDMoto.limpiarTabla();
                formCRUDMoto.limpiarRegistros();
                listarMotos(formCRUDMoto.tabla());
                
                break;
                
            case "borrarMoto":
                
                eliminarMoto();
                formCRUDMoto.limpiarTabla();
                formCRUDMoto.limpiarRegistros();
                listarMotos(formCRUDMoto.tabla());
                
                break;
                
            default:
                
                throw new AssertionError();
        }
                
    }
    
}
