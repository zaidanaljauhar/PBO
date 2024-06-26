/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.*;

/**
 *
 * @author MyBook Hype
 */
public class daoCariPegawai {
     Connection connection;
    final String select = "SELECT * FROM pegawai ORDER BY namapeg ASC;";
    final String selectData = "SELECT * FROM pegawai WHERE namapeg LIKE %?%;";
    final String cari = "SELECT * FROM pegawai WHERE namapeg LIKE ?;";
    public daoCariPegawai(){
    connection = koneksi.connection();
    }
    public void tampil(Pegawai pgw){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(select);
            statement.setString(1, pgw.getKodepeg());
            statement.executeUpdate();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public List<Pegawai> getData(){
        List<Pegawai> listPgw = null;
        try {
            listPgw = new ArrayList<>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                Pegawai pgw = new Pegawai();
                pgw.setKodepeg(rs.getString("Kodepeg"));
                pgw.setNamapeg(rs.getString("namapeg"));
                pgw.setAlamat(rs.getString("Alamat"));
                pgw.setJkel(rs.getString("jkel"));
                pgw.setJabatan(rs.getString("Jabatan"));
                pgw.setUsername(rs.getString("Username"));
                pgw.setPassword(rs.getString("Password"));
                listPgw.add(pgw);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return listPgw;
    }
    
     public List<Pegawai> getCariData(String namapeg){
        PreparedStatement statement = null;
        List<Pegawai> listPgw = null;
        try {
            listPgw = new ArrayList<>();
//            Statement st = connection.createStatement();
//            ResultSet rs = st.executeQuery(selectData);
            statement = connection.prepareStatement(cari);
            statement.setString(1, "%" + namapeg + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Pegawai pgw = new Pegawai();
                pgw.setKodepeg(rs.getString("Kodepeg"));
                pgw.setNamapeg(rs.getString("namapeg"));
                pgw.setAlamat(rs.getString("Alamat"));
                pgw.setJkel(rs.getString("jkel"));
                pgw.setJabatan(rs.getString("Jabatan"));
                pgw.setUsername(rs.getString("Username"));
                pgw.setPassword(rs.getString("Password"));
                listPgw.add(pgw);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return listPgw;
    }     
     public int cekNama(String namapeg){
        PreparedStatement statement = null;
        int ketemu = 0;
        try {
            statement = connection.prepareStatement(selectData);
            statement.setString(1, namapeg);
            ResultSet rs = statement.executeQuery(cari);
            while(rs.next()) {
                ketemu++;
            }
        }catch (SQLException ex){
            
        }
        return ketemu;
    }


}
