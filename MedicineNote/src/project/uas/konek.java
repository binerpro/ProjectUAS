package project.uas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class konek {
    private static Connection MySQLConfig;
    private static Connection configDB()throws SQLException{
        try{
            String url = "jdbc.mysql://localhost:3306/medicine_notes";
            String user = "root";
            String pass = "";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            MySQLConfig = DriverManager.getConnection(url, user, pass);
        }catch(SQLException e){
            System.out.println("Koneksi ke Database gagal" + e.getMessage());
        }
        return MySQLConfig;
    }
    
}