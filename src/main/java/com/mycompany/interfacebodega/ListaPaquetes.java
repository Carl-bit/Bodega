/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.interfacebodega;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author VULCANO
 */
public class ListaPaquetes {

    /*
        codificar la base de datos

     */
    private static Conection con;
    private ArrayList<Paquete> paquetes;

    public ListaPaquetes() throws SQLException {
        paquetes = new ArrayList<>();
        con = new Conection();
        llenarPaquetes();
    }

    public int tamPaquetes() {
        return paquetes.size();
    }

    public String posPaquete(String id) {
        String pos = null;
        for (int i = 0; i < paquetes.size(); i++) {
            if (paquetes.get(i).getId().equals(id)) {
                pos = i + "";
            }
        }

        if (pos != null) {
            System.out.println("posicion encontrada");
        } else {
            System.out.println("no se encontro la posicion");
        }

        return pos;
    }

    //------------------------------------------------
    public void compararIDPar() {
        Collections.sort(paquetes, new Comparator<Paquete>() {

            @Override
            public int compare(Paquete o1, Paquete o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });

    }

    public void compararIDPar2() {
        Collections.sort(paquetes, new Comparator<Paquete>() {

            @Override
            public int compare(Paquete o1, Paquete o2) {
                return o2.getId().compareTo(o1.getId());
            }
        });

    }

    //-----------------------------------------------
    public void compararFechaPar() {
        Collections.sort(paquetes, new Comparator<Paquete>() {

            @Override
            public int compare(Paquete o1, Paquete o2) {
                return o1.getFecha().compareTo(o2.getFecha());
            }
        });
    }

    public void compararFechaPar2() {
        Collections.sort(paquetes, new Comparator<Paquete>() {

            @Override
            public int compare(Paquete o1, Paquete o2) {
                return o2.getFecha().compareTo(o1.getFecha());
            }
        });
    }

    //-----------------------------------------------------------
    public void compararEncargadoPar() {
        Collections.sort(paquetes, new Comparator<Paquete>() {

            @Override
            public int compare(Paquete o1, Paquete o2) {
                return o1.getEncargado().compareTo(o2.getEncargado());
            }
        });
    }

    public void compararEncargadoPar2() {
        Collections.sort(paquetes, new Comparator<Paquete>() {

            @Override
            public int compare(Paquete o1, Paquete o2) {
                return o2.getEncargado().compareTo(o1.getEncargado());
            }
        });
    }

    //----------------------------------------------------------
    public void compararEstadoPar() {
        Collections.sort(paquetes, new Comparator<Paquete>() {

            @Override
            public int compare(Paquete o1, Paquete o2) {
                return o1.getEstado().compareTo(o2.getEstado());
            }
        });
    }

    public void compararEstadoPar2() {
        Collections.sort(paquetes, new Comparator<Paquete>() {

            @Override
            public int compare(Paquete o1, Paquete o2) {
                return o2.getEstado().compareTo(o1.getEstado());
            }
        });
    }

    //----------------------------------------------------------
    public String idPaquete(int pos) {
        return paquetes.get(pos).getId();
    }

    public String fechaPaquete(int pos) {
        return paquetes.get(pos).getFecha();
    }

    public String encargadoPaquete(int pos) {
        return paquetes.get(pos).getEncargado();
    }

    public String estadoPaquete(int pos) {
        return paquetes.get(pos).getEstado();
    }

    public String horaPaquete(int pos) {
        return paquetes.get(pos).getHora();
    }

    public int agregarPaquete(Paquete nuevoPaquete) throws SQLException {

        PreparedStatement cs = null;
        int NumID = 0;
        try {

            String consulta = ("insert into paquetes(id_bodeguero,fechaingreso,horaingreso,estado) values (?,?,?,?)");
            cs = (PreparedStatement) con.connectToDB().prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
            cs.setInt(1, Integer.parseInt(nuevoPaquete.getIdEncargado()));
            String strDateFecha = nuevoPaquete.getFecha();
            String strDateHora = nuevoPaquete.getHora();

            SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
            SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm");

            java.util.Date dateFecha = sdf.parse(strDateFecha);
            java.util.Date dateHora = dateFormat.parse(strDateHora);

            java.sql.Date sqlDateFecha = new Date(dateFecha.getTime()); //converting string into sql date
            java.sql.Time sqlDateHora = new Time(dateHora.getTime());

            cs.setDate(2, sqlDateFecha);
            cs.setTime(3, sqlDateHora);

            cs.setString(4, nuevoPaquete.getEstado());
            cs.execute();

            JOptionPane.showMessageDialog(null, "Insertó correctamente el Paquete, VERIFIQUE");
            ResultSet resultado = (ResultSet) cs.getGeneratedKeys(); // Para obtener el id del paquete que se acaba de agregar
            if (resultado.next()) {
                NumID = resultado.getInt(1);
                System.out.println(" ID -->" + NumID);
                return NumID;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se guardó correctamente los datos" + ex.toString());

        } catch (ParseException ex) {
            Logger.getLogger(ListaBodeguero.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex + " ");
        }
        con.cerrarConexion();
        return -1;

    }

    public int encontrarID(String encargado) throws SQLException {

        ArrayList<String> id = new ArrayList();
        ArrayList<String> nombres = new ArrayList();

        String sql = "select id_bodeguero,nombre from bodegueros;";
        Statement st;

        try {
            st = con.connectToDB().createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                id.add(rs.getString(1));
                nombres.add(rs.getString(2));
            }

        } catch (SQLException ex) {
            System.out.print("Error: " + ex.toString());
        }
        con.cerrarConexion();

        for (int i = 0; i < id.size(); i++) {
            if (nombres.get(i).equals(encargado)) {
                return Integer.parseInt(id.get(i));
            }
        }
        return -1;

    }

    public void modificarPaquete(String id, String fecha, String hora, String encargado, String estado) throws SQLException {
        String sql = "update paquetes set fecha =?, hora =?,id_bodeguero =? where id_paquete =" + id + ";";
        int idEncargado = encontrarID(encargado);

        if (idEncargado == -1) {
            System.out.println("No hay nada que hacer");
            return;
        }

        try {
            CallableStatement cs = con.connectToDB().prepareCall(sql);

            String strDateFecha = fecha;
            String strDateHora = hora;

            SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY");
            SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm");

            java.util.Date dateFecha = sdf.parse(strDateFecha);
            java.util.Date dateHora = dateFormat.parse(strDateHora);

            java.sql.Date sqlDateFecha = new Date(dateFecha.getTime()); //converting string into sql date
            java.sql.Time sqlDateHora = new Time(dateHora.getTime());

            cs.setDate(1, sqlDateFecha);
            cs.setTime(2, sqlDateHora);
            cs.setInt(3, idEncargado);

            cs.execute();

        } catch (SQLException ex) {
            System.out.print("Error: " + ex.toString());
        } catch (ParseException ex) {
            Logger.getLogger(ListaBodeguero.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex + " ");
        }
        con.cerrarConexion();

    }

    private void llenarPaquetes() throws SQLException {

        String sql = "select P.id_paquete, B.nombre,P.id_bodeguero, P.estado,P.fechaingreso,P.horaingreso from paquetes as P, bodegueros as B where B.id_bodeguero = P.id_bodeguero;";
        Statement st;
        String id, fecha, hora, encargado, idEncargado, estado;

        try {
            st = con.connectToDB().createStatement();

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                id = rs.getString(1);
                encargado = rs.getString(2);
                idEncargado = rs.getString(3);
                estado = rs.getString(4);
                fecha = rs.getString(5);
                hora = rs.getString(6);

                Paquete paquete = new Paquete(id, fecha, hora, encargado, idEncargado, estado);

                paquetes.add(paquete);

            }
        } catch (SQLException ex) {
            System.out.print("Error: " + ex.toString());
        }
        con.cerrarConexion();

        /*
        Paquete paquete1 = new Paquete("12345", "12-06-2022", "Pedro Perez", "Recibido");
        Paquete paquete2 = new Paquete("96541", "30-05-2022", "Pedro Perez", "Enviado");
        Paquete paquete3 = new Paquete("56112", "16-06-2022", "Tulio Trivinio", "Traslado");
        Paquete paquete4 = new Paquete("89740", "01-05-2022", "Tulio Trivinio", "Salida");
        Paquete paquete5 = new Paquete("21846", "03-05-2022", "Juan Antonio Leiva", "Enviado");
        paquetes.add(paquete1);
        paquetes.add(paquete2);
        paquetes.add(paquete3);
        paquetes.add(paquete4);
        paquetes.add(paquete5);
         */
    }

}
