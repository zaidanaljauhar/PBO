/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.daoPegawai;
import java.util.List;
import javax.swing.JOptionPane;
import model.Pegawai;
import view.FormLogin;
import view.FormLupa;

/**
 *
 * @author User
 */
public class controllerLupa {
    FormLupa frame;
    daoPegawai daoPeg = new daoPegawai();
    Pegawai tambahPeg = new Pegawai();
    List<Pegawai> listPeg;
    
    public controllerLupa(FormLupa frame) {
        this.frame = frame;
        listPeg = daoPeg.getData();
    }

public void ubahPass() {
    if (frame.getTxtUserName().getText().equals("")) {
        JOptionPane.showMessageDialog(frame, "Username belum diisi");
    } else {
        int row = daoPeg.cekUser(frame.getTxtUserName().getText());
        if (row==0) {
            JOptionPane.showMessageDialog(frame, "Username tidak ditemukan");
            bersih();
        } else {
            tambahPeg.setPassword(frame.getTxtPassword().getText());
            tambahPeg.setUsername(frame.getTxtUserName().getText());
            daoPeg.ubahPass(tambahPeg);
            JOptionPane.showMessageDialog(frame, "Berhasil mengubah data");
            bersih();
                    
        }
    }
}    

public void keluar() {
    frame.dispose();
    FormLogin flogin = new FormLogin();
    flogin.setVisible(true);
}

public void bersih() {
    frame.setTxtUserName("");
    frame.setTxtPassword("");
}
}
