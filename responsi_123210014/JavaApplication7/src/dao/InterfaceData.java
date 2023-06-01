/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import Model.ModelData;
import java.util.List;
/**
 *
 * @author PC PRAKTIKUM
 */
public interface InterfaceData {

    public void insert(ModelData data);

//    public void update(ModelData data);

    public void delete(ModelData data);

    public List<ModelData> getData();

//    public List<ModelData> search(String keyword);
}
