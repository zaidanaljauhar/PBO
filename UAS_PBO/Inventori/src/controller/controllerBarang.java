/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.daoBarang;
import java.util.List;
import javax.swing.JOptionPane;
import model.*;
import view.FormBarang;

/**
 *
 * @author USER
 */
public class controllerBarang {
    FormBarang frame;
    List<Barang> listBrg;
    daoBarang daoBrg = new daoBarang();
    Barang brg = new Barang();
    
    public controllerBarang(FormBarang frame){
        this.frame = frame;
        listBrg = daoBrg.getData();
    }
    
    public void tampil_tabel(){
        TableModelBarang tabelBrg = new TableModelBarang(listBrg);
        frame.getTblBarang().setModel(tabelBrg);
    }
    
    public void tambahData(){
        if (frame.getTxtKode().getText().equals("")){
            JOptionPane.showMessageDialog(null, "Kode barang belum diisi");
        } else {
            brg.setKode(frame.getTxtKode().getText());
            brg.setNama(frame.getTxtNama().getText());
            brg.setJumlah(Integer.parseInt(frame.getTxtJumlah().getText()));
            brg.setHarga(Integer.parseInt(frame.getTxtHarga().getText()));
            brg.setMerek(frame.getTxtMerek().getText());
            daoBrg.tambah(brg);
            JOptionPane.showMessageDialog(frame, "Data berhasil di simpan");
        }
    }
    
    public void ubahData(){
        if (frame.getTxtKode().getText().equals("")){
            JOptionPane.showMessageDialog(null, "Kode barang belum diisi");
        } else {
            brg.setKode(frame.getTxtKode().getText());
            brg.setNama(frame.getTxtNama().getText());
            brg.setJumlah(Integer.parseInt(frame.getTxtJumlah().getText()));
            brg.setHarga(Integer.parseInt(frame.getTxtHarga().getText()));
            brg.setMerek(frame.getTxtMerek().getText());
            daoBrg.ubah(brg);
            JOptionPane.showMessageDialog(frame, "Data berhasil di ubah");
        }
    }
    
    public void hapusData(){
        brg.setKode(frame.getTxtKode().getText());
        daoBrg.hapus(brg);
        JOptionPane.showMessageDialog(frame, "Data berhasil di hapus");
    }
    
    public void bersih() {
        frame.setTxtKode("");
        frame.setTxtNama("");
        frame.setTxtJumlah(0);
        frame.setTxtHarga(0);
        frame.setTxtMerek("");
    }
    
    public void keluar(){
        frame.dispose();
    }
}
