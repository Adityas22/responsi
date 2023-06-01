/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbConnect;

import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Connector {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db_lomba";
    static final String USER = "root";
    static final String PASS = "";
    public java.sql.Connection koneksi;
    public Statement statement;

    public Connector() {
        try {
            Class.forName(JDBC_DRIVER);
            koneksi = (java.sql.Connection)DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("koneksi berhasil");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi gagal");
        }
    }
    public java.sql.Connection getConnection() {
        return koneksi;
    }
}
