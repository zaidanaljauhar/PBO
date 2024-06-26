/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class TabelModelPegawai extends AbstractTableModel {
    List<Pegawai> listPeg;
    
    public TabelModelPegawai(List<Pegawai> listPeg){
        this.listPeg = listPeg;
    }    
    @Override
    public int getRowCount() {
        return listPeg.size();
    }
    
    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override
    public String getColumnName(int column) {
        return switch (column) {
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
    
    @Override
    public Object getValueAt(int row, int column) {
        return switch (column) {
            case 0 -> listPeg.get(row).getKodepeg();
            case 1 -> listPeg.get(row).getNamapeg();
            case 2 -> listPeg.get(row).getAlamat();
            case 3 -> listPeg.get(row).getJkel();
            case 4 -> listPeg.get(row).getJabatan();
            case 5 -> listPeg.get(row).getUsername();
            case 6 -> listPeg.get(row).getPassword();
            default -> null;
        };
    }
        
}
