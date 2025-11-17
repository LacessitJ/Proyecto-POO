
package uts.edu.poo.modelo;

import java.time.LocalDate;

public class OrdenServicio {
    
    private LocalDate fechaIn;
    private int kilometraje;
    private LocalDate fechaOut;
    private int estado;
    private String observaciones;
    private String placa;
    private int ccTecnico;

    public OrdenServicio(LocalDate fechaIn, int kilometraje, LocalDate fechaOut, int estado, String observaciones, String placa, int ccTecnico) {
        this.fechaIn = fechaIn;
        this.kilometraje = kilometraje;
        this.fechaOut = fechaOut;
        this.estado = estado;
        this.observaciones = observaciones;
        this.placa = placa;
        this.ccTecnico = ccTecnico;
    }

    public OrdenServicio() {
    }

    public LocalDate getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(LocalDate fechaIn) {
        this.fechaIn = fechaIn;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public LocalDate getFechaOut() {
        return fechaOut;
    }

    public void setFechaOut(LocalDate fechaOut) {
        this.fechaOut = fechaOut;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCcTecnico() {
        return ccTecnico;
    }

    public void setCcTecnico(int ccTecnico) {
        this.ccTecnico = ccTecnico;
    }    
    
}
