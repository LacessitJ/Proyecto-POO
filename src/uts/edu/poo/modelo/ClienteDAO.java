
package uts.edu.poo.modelo;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDAO {
    
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Cliente c;
    
    public List listar(){
        
        List<Cliente> datos = new ArrayList<>();
        
        try {
            
            con = conectar.getConnection(); 
            ps = con.prepareStatement("select * from cliente");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                c = new Cliente();
                c.setCedula(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setTelefono(rs.getString( 3));
                c.setDireccion(rs.getString(4));
                datos.add(c);
                
            }
            
        } catch (Exception e) {
        }
        
        return datos;
        
    }
    
}
