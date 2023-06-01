/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC PRAKTIKUM
 */
public class TabelData extends AbstractTableModel {

    List<ModelData> mdlData;

    public TabelData(List<ModelData> mdlData) {
        this.mdlData = mdlData;
    }

    @Override
    public int getRowCount() {
        return mdlData.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Judul";
            case 1:
                return "Alur";
            case 2:
                return "Orisinalitas";
            case 3:
                return "Pemilihan Kata";
            case 4: 
                return "Nilai";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return mdlData.get(rowIndex).getJudul();
            case 1:
                return mdlData.get(rowIndex).getAlur();
            case 2:
                return mdlData.get(rowIndex).getOrisinalitas();
            case 3:
                return mdlData.get(rowIndex).getKata();
            case 4:
                return mdlData.get(rowIndex).getNilai();
            default:
                return null;
        }
    }
}
