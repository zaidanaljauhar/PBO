/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.daoPegawai;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import model.*;
import view.FormPegawai;

/**
 *
 * @author User
 */
public class controllerPegawai {
    FormPegawai frame;
    TabelModelPegawai peg;
    List<Pegawai> listPeg;
    daoPegawai daoPeg = new daoPegawai();
    Pegawai tambahPeg = new Pegawai();
    
    
    public controllerPegawai(FormPegawai frame) {
        this.frame = frame;
        listPeg = daoPeg.getData();
    }
    
    public void otomatisasiKodePeg() {
        Calendar kal = new GregorianCalendar();
        int tahun = kal.get(Calendar.YEAR);
        int bulan = kal.get(Calendar.MONTH)+1;
        int hari = kal.get(Calendar.DAY_OF_MONTH);
        
        String bln;
        if(bulan<10) {
            bln = "0"+bulan;
        } else {
            bln = Integer.toString(bulan);
        }
        
        String hr;
        if(hari<10) {
            hr = "0" + hari;
        } else {
            hr = Integer.toString(hari);
        }
        
        int kodepeg = daoPeg.cekKodePeg();
        String kodepegMasuk = Integer.toString(tahun).charAt(2) +"" +Integer.toString(tahun).charAt(3) +"." + bln +"." + hr +"." + "00" + kodepeg;
        
        frame.setTxtkodepeg(kodepegMasuk);
    }
    
    public void tampil_tabel() {
        TabelModelPegawai tabelPeg = new TabelModelPegawai(listPeg);
        frame.getTblpegawai().setModel(tabelPeg);
    }
    
    public void tambahData() {
        tambahPeg.setKodepeg(frame.getTxtkodepeg().getText());
        tambahPeg.setNamapeg(frame.getTxtnamapeg().getText());
        tambahPeg.setAlamat(frame.getTxtalamat().getText());
        tambahPeg.setJabatan(frame.getTxtjabatan().getText());
        tambahPeg.setJkel(frame.getJenkel());
        tambahPeg.setUsername(frame.getTxtusername().getText());
        tambahPeg.setPassword(frame.getTxtpassword().getText());
        daoPeg.tambah(tambahPeg);
        JOptionPane.showMessageDialog(frame, "Data berhasil di tambahkan");
    }
    
    public void ubahData() {
        tambahPeg.setKodepeg(frame.getTxtkodepeg().getText());
        tambahPeg.setNamapeg(frame.getTxtnamapeg().getText());
        tambahPeg.setAlamat(frame.getTxtalamat().getText());
        tambahPeg.setJabatan(frame.getTxtjabatan().getText());
        tambahPeg.setJkel(frame.getJenkel());
    //    tambahPeg.setUsername(frame.getTxtusername().getText);
    //    tambahPeg.setPassword(frame.getTxtpassword().getText);
        daoPeg.ubah(tambahPeg);
        JOptionPane.showMessageDialog(frame, "Data berhasil di ubah");
    }
    
    public void hapusData(String kodepeg) {
        tambahPeg.setKodepeg(frame.getTxtkodepeg().getText());
        daoPeg.hapus(tambahPeg);
        JOptionPane.showMessageDialog(frame, "Data Berhasil di Hapus");
    }
    
    public void cekUsername() {
        if (frame.getTxtusername().getText().equals("")) {
            JOptionPane.showMessageDialog(frame, "Username belum diisi");
        } else {
            int row = daoPeg.cekUser(frame.getTxtusername().getText());
            if (row==0) {
                JOptionPane.showMessageDialog(frame, "Username tersedia");
            } else {
                JOptionPane.showMessageDialog(frame, "Username sudah digunakan");
            }
        }
    }
    
    public void keluar() {
        frame.dispose();
    }

}
