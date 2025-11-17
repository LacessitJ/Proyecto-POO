
package uts.edu.poo.modelo;

public class Repuesto {
 
    private int idRepuesto;
    private String nombre;
    private double precio;

    public Repuesto(int idRepuesto, String nombre, double precio) {
        this.idRepuesto = idRepuesto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Repuesto() {
    }

    public int getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(int idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
