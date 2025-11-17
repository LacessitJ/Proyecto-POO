
package uts.edu.poo.modelo;

public class Tecnico {
    
    private int cedula;
    private String nombre;

    public Tecnico(int cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public Tecnico() {
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
