
package uts.edu.poo.controlador;

import uts.edu.poo.modelo.Conexion;
import uts.edu.poo.vista.Menu;

public class Controlador {

    public static void main(String[] args) {
        
        Menu menu1 = new Menu();
        menu1.setVisible(true);
        Conexion conexion1 = new Conexion();
        conexion1.getConnection();
    }
    
}
