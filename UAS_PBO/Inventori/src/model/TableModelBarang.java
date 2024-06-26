/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USER
 */
public class TableModelBarang extends AbstractTableModel{
    
    List<Barang> listBrg;
    
    public TableModelBarang(List<Barang> listBrg){
        this.listBrg = listBrg;
    }
    
    @Override
    public int getRowCount(){
        return listBrg.size();
    }
    
    @Override
    public int getColumnCount(){
        return 5;
    }
    
    @Override
    public Object getValueAt(int row, int column){
        return switch (column){
            case 0 -> listBrg.get(row).getKode();
            case 1 -> listBrg.get(row).getNama();
            case 2 -> listBrg.get(row).getJumlah();
            case 3 -> listBrg.get(row).getHarga();
            case 4 -> listBrg.get(row).getMerek();
            default -> null;
        };
    }
    
    @Override
    public String getColumnName(int column){
        return switch(column){
            case 0 -> "Kode Barang";
            case 1 -> "Nama Barang";
            case 2 -> "Jumlah";
            case 3 -> "Harga";
            case 4 -> "Merek";
            default -> null;
        };
    }
}
