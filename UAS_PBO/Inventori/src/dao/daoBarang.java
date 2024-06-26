/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

//import com.mysql.cj.xdevapi.PreparableStatement;
//import com.sun.jdi.connect.spi.Connection;
import controller.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Barang;

/**
 *
 * @author USER
 */
public class daoBarang {
    Connection connection;
    final String insert = "INSERT INTO barang (kode, nama, jumlah, harga, merek) VALUES (?,?,?,?,?);";
    final String update = "UPDATE barang SET nama=?, jumlah=?, harga=?, merek=? WHERE kode=?";
    final String delete = "DELETE FROM barang WHERE kode=?;";
    final String select = "SELECT * FROM barang ORDER BY kode ASC;";
    final String selectData = "SELECT * FROM barang WHERE kode=?;";
    
    public daoBarang(){
        connection = koneksi.connection();
    }
    
    public void tambah(Barang brg){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, brg.getKode());
            statement.setString(2, brg.getNama());
            statement.setInt(3, brg.getJumlah());
            statement.setInt(4, brg.getHarga());
            statement.setString(5, brg.getMerek());
            statement.executeUpdate();
        }catch (SQLException ex){
            
        }
    }
    
    public void ubah(Barang brg){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, brg.getNama());
            statement.setInt(2, brg.getJumlah());
            statement.setInt(3, brg.getHarga());
            statement.setString(4, brg.getMerek());
            statement.setString(5, brg.getKode());
            statement.executeUpdate();
        }catch (SQLException ex){
            
        }
    }
    
    public void hapus(Barang brg){
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, brg.getKode());
            statement.executeUpdate();
        }catch (SQLException ex){
            
        }
    }
    
    public void tampil(Barang brg){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(selectData);
            statement.setString(1, brg.getKode());
            statement.executeUpdate();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public List<Barang> getData(){
        List<Barang> listBrg = null;
        try {
            listBrg = new ArrayList<>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                Barang brg = new Barang();
                brg.setKode(rs.getString("kode"));
                brg.setNama(rs.getString("nama"));
                brg.setJumlah(rs.getInt("jumlah"));
                brg.setHarga(rs.getInt("harga"));
                brg.setMerek(rs.getString("merek"));
                listBrg.add(brg);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        return listBrg;
    }
    
    public int cekKode(String kode){
        PreparedStatement statement = null;
        int ketemu = 0;
        try {
            statement = connection.prepareStatement(selectData);
            statement.setString(1, kode);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                ketemu++;
            }
        }catch (SQLException ex){
            
        }
        return ketemu;
    }
}
