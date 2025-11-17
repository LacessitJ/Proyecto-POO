
package uts.edu.poo.modelo;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class Conexion {
    
    Statement consulta;
    String ruta = "db/bd_taller.db";
    
    String url = "jdbc:sqlite:" + ruta;
    Connection con;

    public Connection getConnection() {
        
        try {
                
            con = DriverManager.getConnection(url);
            consulta = con.createStatement();
            System.out.println("Conexión exitosa");
                
        } catch (Exception e) {
            
            System.out.println("Error al conectar: " + e.getMessage());
            
        }
            
        return con;
        
    }
    
}
