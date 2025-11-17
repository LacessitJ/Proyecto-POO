
package uts.edu.poo.modelo;

public class Motocicleta {
    
    private String placa;
    private int modelo;
    private String nMotor;
    private int cedulaCliente;

    public Motocicleta(String placa, int modelo, String nMotor, int cedulaCliente) {
        this.placa = placa;
        this.modelo = modelo;
        this.nMotor = nMotor;
        this.cedulaCliente = cedulaCliente;
    }

    public Motocicleta() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getnMotor() {
        return nMotor;
    }

    public void setnMotor(String nMotor) {
        this.nMotor = nMotor;
    }

    public int getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(int cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

}
