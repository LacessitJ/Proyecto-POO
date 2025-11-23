
package uts.edu.poo.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uts.edu.poo.vista.FormuilarioCliente;
import uts.edu.poo.vista.Menu;


public class Controlador implements ActionListener {
    
    private final Menu menu;
    private FormuilarioCliente formCliente;

    public Controlador(Menu menu) {
        
        this.menu = menu;
        
    }

    public static void main(String[] args) {
        
        Menu menu = new Menu();
        Controlador controlador = new Controlador(menu);
        menu.iniciarListeners(controlador);
        menu.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String comando = e.getActionCommand();
        
        switch (comando) {
            case "Clientes":
                
                formCliente = new FormuilarioCliente();
                formCliente.setVisible(true);
                
                break;
            default:
                throw new AssertionError();
        }
                
    }
    
}
