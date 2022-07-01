/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.interfacebodega;

import java.sql.*;

/**
 *
 * @author VULCANO
 */
public class Conection {

    Connection conexion;

    public Connection connectToDB() {

        try {
            // We register the PostgreSQL driver
            // Registramos el driver de PostgresSQL
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            conexion = null;
            // Database connect
            // Conectamos con la base de datos
            String host = "ec2-52-71-23-11.compute-1.amazonaws.com";
            String database = "d4o63mmv29uk5t";
            String user = "otgbqtmzrnswmg";
            String password = "2cd7ba706eb4d75d964aa27730f95530ecb7f94fb3100647aafdff728474709c";
            // ------ datos de conexion -------
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://" + host + ":5432/" + database, user, password);

            boolean valid = conexion.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");

        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);

        }
        return conexion;
    }

    public void cerrarConexion() throws SQLException {
        conexion.close();
    }

}
