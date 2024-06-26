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
import view.MenuUtama;
//import view.FormPembelian;
/**
 *
 * @author User
 */
public class controllerLogin {
    FormLogin frame;
    List<Pegawai> listPeg;
    daoPegawai daoPeg = new daoPegawai();
    FormLupa lupa = new FormLupa();
    MenuUtama menu = new MenuUtama();
    //FormPembelian fBeli = new FormPembelian();
    
    public controllerLogin(FormLogin frame) {
        this.frame = frame;
        listPeg = daoPeg.getData();
    }
    
    public void cekData() {
        if ((frame.getTxtUserName().getText().equals("")) ||
                (frame.getTxtPassword().getText().equals(""))) {
            JOptionPane.showMessageDialog(frame, "Username atau password belum diisi");
        } else {
            Pegawai peg = daoPeg.cekUserPass(frame.getTxtUserName().getText(),
                    frame.getTxtPassword().getText());
            if (peg.getKodepeg() != null) {
                menu.setVisible(true);
                
                batal();
                frame.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(frame, "Username atau Password Salah");
                batal();
            }
        }
    }
    
    public void lupaPass() {
        frame.dispose();;
        lupa.setVisible(true);
    }
    
    public void batal() {
        frame.setTxtUserName("");
        frame.setTxtPassword("");
    }
    
    public void keluar() {
        frame.dispose();
    }
}
