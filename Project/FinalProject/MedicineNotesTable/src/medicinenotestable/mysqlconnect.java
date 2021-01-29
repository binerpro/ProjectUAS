/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicinenotestable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author mursy
 */
public class mysqlconnect {

    Connection conn = null;

    public static Connection ConnectDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/medicinenotestable");
            //JOptionPane.showMessageDialog(null, "ConnectionEstablished");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public static ObservableList<obat> getDataobat() {
        Connection conn = ConnectDb();
        ObservableList<obat> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from obat");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new obat(Integer.parseInt(rs.getString("meds_id")), rs.getString("nama"), rs.getString("kategori"), rs.getString("kegunaan")));

            }

        } catch (Exception e) {

        }

        return null;
    }
}
