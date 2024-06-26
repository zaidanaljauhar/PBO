/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MyBook Hype
 */
public class TabelModelCariPegawai extends AbstractTableModel {
    List<Pegawai> listPgw;
    
    public TabelModelCariPegawai(List<Pegawai>listPgw){
        this.listPgw = listPgw;
    }
    
    @Override
    public int getRowCount() {
        return listPgw.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

   @Override
    public Object getValueAt(int row, int column){
        return switch (column){
            case 0 -> listPgw.get(row).getKodepeg();
            case 1 -> listPgw.get(row).getNamapeg();
            case 2 -> listPgw.get(row).getAlamat();
            case 3 -> listPgw.get(row).getJkel();
            case 4 -> listPgw.get(row).getJabatan();
            case 5 -> listPgw.get(row).getUsername();
            case 6 -> listPgw.get(row).getPassword();    
            default -> null;
        };
    }
    
    @Override
    public String getColumnName(int column){
        return switch(column){
            case 0 -> "Kode Pegawai";
            case 1 -> "namapeg";
            case 2 -> "Alamat";
            case 3 -> "jkel";
            case 4 -> "Jabatan";
            case 5 -> "Username";
            case 6 -> "Password";    
            default -> null;
        };
    }

}

 
