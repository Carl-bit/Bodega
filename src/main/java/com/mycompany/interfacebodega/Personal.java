/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.interfacebodega;

import java.util.Date;

/**
 *
 * @author VULCANO
 */
public class Personal {

    /*
        +datos -> Rut, Nombre, ID(a nivel parámetro), Fecha Nacimiento
	+ Random ID
	+Función -> Agregar/Modificar/Eliminar

     */
    private String rut;
    private String nombre;
    private String id;
    private String fechaNacimiento;

    public Personal(String rut, String nombre, String id, String fechaNacimiento) {
        this.rut = rut;
        this.nombre = nombre;
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Personal{\n"
                + "rut='" + rut + '\''
                + "\nnombre='" + nombre + '\''
                + "\nid='" + id + '\''
                + "\nfechaNacimiento='" + fechaNacimiento + '\''
                + "\n}";
    }

}
