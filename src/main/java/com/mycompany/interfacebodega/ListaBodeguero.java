/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.interfacebodega;

//import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author VULCANO
 */
public class ListaBodeguero {

    /*
        Realizar la conexion con la base de datos
     */
    private ArrayList<Personal> trabajadores;
    private Conection con;

    public ListaBodeguero() throws SQLException {
        trabajadores = new ArrayList<>();
        con = new Conection();
        llenarTrabajadores();
    }

    public int tamTrabajadores() {
        return trabajadores.size();
    }

    public String posTrabajador(String rut) {
        for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i).getRut().equals(rut)) {
                return i + "";
            }
        }
        return null;
    }

    public String idTrabajador(int pos) {
        return trabajadores.get(pos).getId();
    }

    public String nombreTrabajador(int pos) {
        return trabajadores.get(pos).getNombre();
    }

    public String rutTrabajador(int pos) {
        return trabajadores.get(pos).getRut();
    }

    public String fechaTrabajador(int pos) {
        return trabajadores.get(pos).getFechaNacimiento();
    }

    public void agregarTrabajador(String rut, String nombre, String fecha) throws SQLException {
        //trabajadores.add(bodeguero);

        //System.out.println(strDate.toString());
        try {
            String consulta = ("insert into bodegueros(id_bodega,nombre,rut,fecha_nac) values (1,?,?,?);");
            CallableStatement cs = con.connectToDB().prepareCall(consulta);
            cs.setString(1, nombre);
            cs.setString(2, rut);

            String strDate = fecha;
            SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
            java.util.Date date = sdf.parse(strDate);
            java.sql.Date sqlDate = new Date(date.getTime()); //converting string into sql date

            cs.setDate(3, sqlDate);
            cs.execute();

            System.out.println("Insertó correctamente el Bodeguero, VERIFIQUE");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se guardó correctamente los datos" + ex.toString());

        } catch (ParseException ex) {
            Logger.getLogger(ListaBodeguero.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex + " ");
        }
        con.cerrarConexion();

    }

    public void eliminarTrabajador(String id) throws SQLException {

        String sql = "delete from bodegueros where id_bodeguero=" + id;
        Statement st;
        try {
            st = con.connectToDB().createStatement();
            int rs = st.executeUpdate(sql);
            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "ELIMINADO CON EXITO");
            }
        } catch (SQLException ex) {
            System.out.print("Error: " + ex.toString());
        }
        con.cerrarConexion();

        /*
            boolean posTrabajadorEliminar = false;

        for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i).getId().equals(id)) {
                posTrabajadorEliminar = true;
                trabajadores.remove(i);
                break;
            }
        }
        if (posTrabajadorEliminar) {
            System.out.println("Se elimino");
        } else {
            System.out.println("No existe");
        }
         */
    }

    public void modificarTrabajador(String id, String nombre, String rut, String fechaNac) throws SQLException {

        String sql = "update bodegueros set nombre =?, rut =?,fecha_nac =? where id_bodeguero =" + id + ";";

        try {
            CallableStatement cs = con.connectToDB().prepareCall(sql);

            cs.setString(1, nombre);
            cs.setString(2, rut);

            String strDate = fechaNac;
            SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
            java.util.Date date = sdf.parse(strDate);
            java.sql.Date sqlDate = new Date(date.getTime()); //converting string into sql date

            cs.setDate(3, sqlDate);

            cs.execute();

        } catch (SQLException ex) {
            System.out.print("Error: " + ex.toString());
        } catch (ParseException ex) {
            Logger.getLogger(ListaBodeguero.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex + " ");
        }
        con.cerrarConexion();

        /*
            boolean cambioDatosTrabajadores = false;
        for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadores.get(i).getId().equals(id)) {
                trabajadores.get(i).setNombre(nombre);
                trabajadores.get(i).setRut(rut);
                trabajadores.get(i).setFechaNacimiento(fechaNac);
                cambioDatosTrabajadores = true;
            }
        }

        if (cambioDatosTrabajadores) {
            System.out.println("Se realizo el cambio");
        } else {
            System.out.println("No se realizo el cambio/El id no coincide");
        }
         */
    }

    private void llenarTrabajadores() throws SQLException {

        String sql = "select * from bodegueros;";
        Statement st;
        String id, nombre, rut, fecha;

        try {
            st = con.connectToDB().createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                id = rs.getString(1);
                nombre = rs.getString(3);
                rut = rs.getString(4);
                fecha = rs.getString(5);
                Personal personal = new Personal(rut, nombre, id, fecha);

                trabajadores.add(personal);

            }
        } catch (SQLException ex) {
            System.out.print("Error: " + ex.toString());
        }
        con.cerrarConexion();

        /*
        Personal trabajador1 = new Personal("13.151.533-1","Pedro Perez","123510","12-12-1980");
        Personal trabajador2 = new Personal("19.123.152-k","Juan Antonio Leiva","964123","06-05-1998");
        Personal trabajador3 = new Personal("17.562.122-6","Tulio Trivinio","741520","04-05-1986");
        Personal trabajador4 = new Personal("20.361.213-1","Vin Diesel","956452","10-12-1999");
        trabajadores.add(trabajador3);
        System.out.println(trabajadores.get(0));
        trabajadores.add(trabajador1);
        System.out.println(trabajadores.get(1));
        trabajadores.add(trabajador2);
        System.out.println(trabajadores.get(2));
        trabajadores.add(trabajador4);
        System.out.println(trabajadores.get(3))
         */
    }

}
