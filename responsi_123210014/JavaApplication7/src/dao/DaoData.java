/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbConnect.Connector;
import Model.ModelData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author PC PRAKTIKUM
 */
public class DaoData implements InterfaceData {

    Connector connection = new Connector();
    Connection koneksi;

    final String delete = "DELETE FROM lomba WHERE judul=?;";
    final String select = "SELECT * FROM lomba;";
    final String insert = "INSERT INTO lomba(judul, alur, orisinalitas, pemilihanKata, nilai) VALUES (?, ?, ?, ?, ?);";

    public DaoData() {
        koneksi = connection.getConnection();
    }

    @Override
    public void insert(ModelData data) {
        PreparedStatement statement = null;
        try {
            statement = koneksi.prepareStatement(insert);
            statement.setString(1, data.getJudul());
            statement.setDouble(2, data.getAlur());
            statement.setDouble(3, data.getOrisinalitas());
            statement.setDouble(4, data.getKata());
            statement.setDouble(5, data.getNilai());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(ModelData data) {
        PreparedStatement statement = null;

        try {
            statement = koneksi.prepareStatement(delete);
            statement.setString(1, data.getJudul());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<ModelData> getData() {
        List<ModelData> listData = null;
        try {
            listData = new ArrayList<ModelData>();
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                ModelData data = new ModelData();
                data.setJudul(rs.getString("judul"));
                data.setAlur(rs.getDouble("alur"));
                data.setOrisinalitas(rs.getDouble("orisinalitas"));
                data.setKata(rs.getDouble("pemilihanKata"));
                data.setNilai(rs.getDouble("nilai"));
            }
        } catch (SQLException ex) {
            System.out.println("error");
        }
        return listData;
    }

}
