/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;

/**
 *
 * @author USER
 */
public class koneksi {
    static Connection kon;
    
    public static Connection connection(){
        if (kon == null){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("toko");
            data.setUser("root");
            data.setPassword("");
            try{
                kon = data.getConnection();
                System.out.println("sudah konek");
            }  catch (Exception e){
                      System.out.println("tidak konek");
                        
            }
        }
        return kon;
    }
}
