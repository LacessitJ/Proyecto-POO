
package uts.edu.poo.modelo;

public class Trabajo {
    
    private int idTrabajo;
    private String descripcion;
    private double costo;

    public Trabajo(int idTrabajo, String descripcion, double costo) {
        this.idTrabajo = idTrabajo;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public Trabajo() {
    }

    public int getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(int idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
}
