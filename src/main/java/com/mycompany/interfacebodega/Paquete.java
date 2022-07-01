/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.interfacebodega;

/**
 *
 * @author VULCANO
 */
public class Paquete {

    /*
        +Datos -> ID, fecha, hora, encargado, estado
	+Función -> Agregar/Modificar
	+ Lista de estado “Finalizados”

     */
    private String id;
    private String fecha;
    private String hora;
    private String encargado;
    private String idEncargado;
    private String estado;

    public Paquete(String id, String fecha, String hora, String idEncargado, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.idEncargado = idEncargado;
        this.estado = estado;
    }

    public Paquete(String id, String fecha, String hora, String encargado, String idEncargado, String estado) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.encargado = encargado;
        this.idEncargado = idEncargado;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(String idEncargado) {
        this.idEncargado = idEncargado;
    }

    @Override
    public String toString() {
        return "Paquete{"
                + "\nid='" + id + '\''
                + "\nfehca='" + fecha + '\''
                + "\nencargado='" + encargado + '\''
                + "\nestado='" + estado + '\''
                + "\n}";
    }

}
