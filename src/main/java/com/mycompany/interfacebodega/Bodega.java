/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.interfacebodega;

/**
 *
 * @author VULCANO
 */
public class Bodega {

    private Estante estantes[][][];
    /*
        i = cantidad de estantes
        j = alto de los estantes
        k = ancho de los estantes
    */
    private ListaPaquetes paquetes;

    public Bodega() throws SQLException, java.sql.SQLException {
        estantes = new Estante[5][4][8];
        paquetes = new ListaPaquetes();
        llenarBodega();
    }

    public void agregarPaquete(int idPaquete) {
            
        for (int i = 0; i < estantes.length; i++) {
            for (int j = 0; j < estantes[i].length; j++) {
                for (int k = 0; k < estantes[i][j].length; k++) {
                    if (estantes[i][j][k].isEstadoEstante() != true) {
                        estantes[i][j][k].setIdPaquete(idPaquete);
                        estantes[i][j][k].setEstadoEstante(true);
                    }
                }
            }
        }
        
    }
    
    

    public boolean estanteDesocupado(int posi,int posj,int posk) { //retorna si el estante esta desocupado
        
        return estantes[posi][posj][posk].isEstadoEstante();
    }

    /*
        True = si se encuentra y lo elimina
        False = si no lo encuentra
    */
    
    public boolean eliminarPaquete(int idPaquete) {
        for (int i = 0; i < estantes.length; i++) {
            for (int j = 0; j < estantes[i].length; j++) {
                for (int k = 0; k < estantes[i][j].length; k++) {
                    if (estantes[i][j][k].isEstadoEstante() != true) {
                        estantes[i][j][k].setIdPaquete(-1);
                        estantes[i][j][k].setEstadoEstante(false);
                        return true;
                    }
                }
            }
        }
        
        return false;
    }

    private void llenarBodega(){
        int posPaquete = 0;
        for (int i = 0; i < estantes.length; i++) {
            for (int j = 0; j < estantes[i].length; j++) {
                for (int k = 0; k < estantes[i][j].length; k++) {
                    if (!(paquetes.estadoPaquete(posPaquete).equals("Enviado"))) {
                        estantes[i][j][k].setIdPaquete(Integer.parseInt(paquetes.idPaquete(posPaquete)));
                        estantes[i][j][k].setEstadoEstante(true);
                    }
                }
            }
        }
    }
}
