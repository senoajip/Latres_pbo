
package Konsepmvc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ModelPraktikum {
    //mengkoneksikan ke database
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/dbcontact";//nama database kita di slash terakhir
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;//untuk perintah query

    public ModelPraktikum() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    public void insertcontact(String Nama, String No, String Umur, String Email){
        try {
           String query = "INSERT INTO `contact`(`Nama`, `No`, `Umur`, `Email`) VALUES ('"+Nama+"','"+No+"','"+Umur+"','"+Email+"')";//value 1 (id diskip)
           //String '"+String+"' kalau Int "+int+"
           statement = (Statement) koneksi.createStatement();
           statement.executeUpdate(query); //execute querynya
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil ditambah");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void update(String Nama,String No,String Umur,String Email) {
        try{
            String query = "UPDATE contact SET Nama='"+Nama+"',No = '"+No+"', Umur='"+Umur+"', Email='"+Email+"'  WHERE No = '"+No+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data anda berhasil diupdate");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

    public String[][] readcontact(){
        try{
            int jmlData = 0;//menampung jumlah data
            
            String data[][] = new String[getBanyakData()][4]; //baris, kolom nya ada 3
            
            String query = "Select * from`contact`"; //pengambilan dara dalam java dari database
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ //lanjut kedata selanjutnya jmlData bertambah
                data[jmlData][0] = resultSet.getString("Nama"); //kolom nama harus sama besar kecilnya dgn database
                data[jmlData][1] = resultSet.getString("No");                
                data[jmlData][2] = resultSet.getString("Umur");                
                data[jmlData][3] = resultSet.getString("Email");
                jmlData++; //barisnya berpindah terus
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int getBanyakData(){//menghitung jumlah baris
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `contact`"; //pengambilan dara dalam java dari database
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ //lanjut kedata selanjutnya jmlData bertambah
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void deletecontact (String Nama) {
        try{
            String query = "DELETE FROM `contact` WHERE `Nama` = '"+Nama+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
