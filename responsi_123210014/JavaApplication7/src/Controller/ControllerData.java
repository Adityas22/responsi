/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import dao.DaoData;
import dao.InterfaceData;
import View.Home;
import Model.ModelData;
import Model.TabelData;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author PC PRAKTIKUM
 */
public class ControllerData {

    private Home view;
    InterfaceData infcData;
    List<ModelData> listData;
    
    public ControllerData(Home view) {
        this.view = view;
        infcData = new DaoData();
        listData = infcData.getData();
    }
    
    public void loadTable() {
        listData = infcData.getData();
        TabelData data = new TabelData(listData);
        view.getTabelData().setModel(data);
    }
    
    
}
