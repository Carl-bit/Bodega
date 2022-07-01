/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.interfacebodega;

/**
 *
 * @author VULCANO
 */

/*
    Definicion de cada espacio en el estante

 */
public class Estante {

    private int idPaquete;
    private boolean estadoEstante;

    public Estante(int idPaquete, boolean estadoEstante) {
        this.idPaquete = idPaquete;
        this.estadoEstante = estadoEstante;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public boolean isEstadoEstante() {
        return estadoEstante;
    }

    public void setEstadoEstante(boolean estadoEstante) {
        this.estadoEstante = estadoEstante;
    }

}
