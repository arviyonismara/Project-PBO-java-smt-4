/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package siakad;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class DBConnection {
    public Connection getConnection(){
        Connection con = null;
        try {
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pbo2022","root","");
            //JOptionPane.showMessageDialog(null, "Koneksi Sukses");
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Tidak ada Koneksi database");
        }
        return con;
    }
}
