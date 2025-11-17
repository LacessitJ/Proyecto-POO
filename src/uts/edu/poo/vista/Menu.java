
package uts.edu.poo.vista;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JFrame{

    public Menu() {
        
        setTitle("Taller Yamaha");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JMenuBar barraMenu = new JMenuBar();
        
        JMenu menuInicio = new JMenu("Inicio");
        
        JMenuItem itemCliente = new JMenuItem("Clientes");
        JMenuItem itemMoto = new JMenuItem("Motocicletas");
        JMenuItem itemTecnico = new JMenuItem("Tecnicos");
        JMenuItem itemRepuesto = new JMenuItem("Repuesto");
        JMenuItem itemTrabajo = new JMenuItem("Trabajo");
        
        JMenu menuSalir = new JMenu("Salir");
        
        JMenuItem salirApp = new JMenuItem("Salir de la aplicacion");
        
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
    
}
