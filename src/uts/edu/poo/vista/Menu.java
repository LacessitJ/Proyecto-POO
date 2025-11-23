
package uts.edu.poo.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JFrame implements ActionListener{

    private final JMenuBar barraMenu;
    private final JMenu menuInicio;
    
    private final JMenuItem itemCliente;
    private final JMenuItem itemMoto;
    private final JMenuItem itemTecnico;
    private final JMenuItem itemRepuesto;
    private final JMenuItem itemTrabajo;
    
    private final JMenu menuSalir;
    
    private final JMenuItem salirApp;
    
    private ActionListener listener;
    
    public Menu() {
        
        setTitle("Taller Yamaha");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        barraMenu = new JMenuBar();
        
        menuInicio = new JMenu("Inicio");
        
        itemCliente = new JMenuItem("Clientes");
        itemMoto = new JMenuItem("Motocicletas");
        itemTecnico = new JMenuItem("Tecnicos");
        itemRepuesto = new JMenuItem("Repuestos");
        itemTrabajo = new JMenuItem("Trabajos");
        
        menuSalir = new JMenu("Salir");
        
        salirApp = new JMenuItem("Salir de la aplicacion");
        
        menuInicio.add(itemCliente);
        menuInicio.add(itemMoto);
        menuInicio.addSeparator();
        menuInicio.add(itemRepuesto);
        menuInicio.add(itemTrabajo);
        menuInicio.addSeparator();
        menuInicio.add(itemTecnico);
        
        menuSalir.add(salirApp);
        
        barraMenu.add(menuInicio);
        barraMenu.add(menuSalir);
        
        setJMenuBar(barraMenu);
        
    }
    
    public void iniciarListeners(ActionListener listener){
        
        this.listener = listener;
        
        itemCliente.setActionCommand("Clientes");
        itemMoto.setActionCommand("Motos");
        itemRepuesto.setActionCommand("Repuestos");
        itemTrabajo.setActionCommand("Trabajos");
        itemTecnico.setActionCommand("Tecnicos");
        
        itemCliente.addActionListener(listener);
        itemMoto.addActionListener(listener);
        itemRepuesto.addActionListener(listener);
        itemTrabajo.addActionListener(listener);
        itemTecnico.addActionListener(listener);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (listener != null) {
            
            listener.actionPerformed(e);
            
        }
        
    }
    
}
