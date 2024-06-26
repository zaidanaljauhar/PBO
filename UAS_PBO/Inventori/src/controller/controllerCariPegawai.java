/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
//import dao.daoCariBarang;
import dao.daoCariPegawai;
import java.util.List;
import javax.swing.JOptionPane;
import model.*;
import view.FormCariPegawai;

/**
 *
 * @author MyBook Hype
 */
public class controllerCariPegawai {
    FormCariPegawai frame;
    List<Pegawai>listPgw;
    List<Pegawai> listCariPgw;
    daoCariPegawai daoCariPgw = new daoCariPegawai(); 
     public controllerCariPegawai(FormCariPegawai frame){
        this.frame = frame;
        listPgw = daoCariPgw.getData();
        listCariPgw = daoCariPgw.getCariData(frame.getTxtNamaPgw().getText());
    }

    public void tampil_tabel() {
        TabelModelCariPegawai tabelPgw = new TabelModelCariPegawai(listCariPgw);
        frame.getTblPegawai().setModel(tabelPgw);
    }
    
    public void tampilFilter_tabel(){
        TabelModelCariPegawai tabelPgw = new TabelModelCariPegawai(listCariPgw);
        frame.getTblPegawai().setModel(tabelPgw);
    }

    public void cekNamaPgw() {
        if (frame.getTxtNamaPgw().getText().equals("")) {
            JOptionPane.showMessageDialog(frame, "Nama Pegawai belum diisi");
        } else {
            daoCariPgw.getCariData(frame.getTxtNamaPgw().getText());
           // daoCariBrg.cekNama(frame.getTxtNamaBrg().getText());
            tampilFilter_tabel();
        }
    }

    public void keluar() {
        frame.dispose();
    }
    
}
