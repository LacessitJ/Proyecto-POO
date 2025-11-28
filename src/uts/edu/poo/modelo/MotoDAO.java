
package uts.edu.poo.modelo;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MotoDAO {
 
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Motocicleta m;
    Cliente c;

    public List listar(){
        
        List<Cliente> datos = new ArrayList<>();
        
        try {
            
            con = conectar.getConnection(); 
            ps = con.prepareStatement("select cedula, nombre from cliente");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                c = new Cliente();
                c.setCedula(rs.getInt(1));
                c.setNombre(rs.getString(2));
                datos.add(c);
                
            }
            
        } catch (Exception e) {
        }
        
        return datos;
        
    }
    
    public List listarMotos(){
        
        List<Motocicleta> datos = new ArrayList<>();
        
        try {
            
            con = conectar.getConnection(); 
            ps = con.prepareStatement("select * from motocicleta");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                m = new Motocicleta();
                m.setPlaca(rs.getString(1));
                m.setModelo(rs.getString(2));
                m.setnMotor(rs.getString( 3));
                m.setCedulaCliente(rs.getInt(4));
                datos.add(m);
                
            }
            
        } catch (Exception e) {
        }
        
        return datos;
        
    }
    
    public int agregar(Motocicleta m){
        
        int r = 0;
        
        String sql = "insert into motocicleta(placa, modelo, numero_motor, cedula_cliente)values(?,?,?,?)";
        
        try {
            
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getPlaca());
            ps.setString(2, m.getModelo());
            ps.setString(3, m.getnMotor());
            ps.setInt(4, m.getCedulaCliente());
            
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
    
    public int actualizarMoto(Motocicleta m){
        
        int r = 0;
        String sql = "update motocicleta set placa=?, modelo=?, numero_motor=?, cedula_cliente=? where placa=?";
        
        try {
            
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getPlaca());
            ps.setString(2, m.getModelo());
            ps.setString(3, m.getnMotor());
            ps.setInt(4, m.getCedulaCliente());
            ps.setString(5, m.getPlaca());
            
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
    
    public int eliminarMoto(String placa){
        
        int r = 0;
        String sql = "delete from motocicleta where placa = ?";
        
        try{
            
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, placa);
            r = ps.executeUpdate();
                
        }catch (Exception e) {
        }
        
        return r;
        
    }
    
}
