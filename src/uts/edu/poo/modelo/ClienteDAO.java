
package uts.edu.poo.modelo;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    
    public int agregar(Cliente c){
        
        int r = 0;
        
        String sql = "insert into cliente(cedula, nombre, telefono, direccion)values(?,?,?,?)";
        
        try {
            
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getCedula());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getTelefono());
            ps.setString(4, c.getDireccion());
            
            r = ps.executeUpdate();
            
            if (r == 1) {
                
                return 1;
                
            }else {
                
                return 0;
                
            }
            
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "algo salio mal");
            e.printStackTrace(); // para ver el error real en consola
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            
        }
        
        return r;
        
    }
    
    public int actualizar(Cliente c){
        
        int r = 0;
        String sql = "update cliente set cedula=?, nombre=?, telefono=?, direccion=? where cedula=?";
        
        try {
            
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getCedula());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getTelefono());
            ps.setString(4, c.getDireccion());
            ps.setInt(5, c.getCedula());
            
            r = ps.executeUpdate();
            
            if (r == 1) {
                
                return 1;
                
            }else {
                
                return 0;
                
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "algo salio mal");
            e.printStackTrace(); // para ver el error real en consola
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            
        }
        
        return r;
        
    }
    
    public int eliminar(int id){
        
        int r = 0;
        String sql = "delete from cliente where cedula=" + id;
        
        try{
            
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
                
        }catch (Exception e) {
        }
        
        return r;
        
    }
    
}
