/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.uas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import project.uas.db.DBKonek;

/**
 *
 * @author mursy
 */
public class MedicineDataModel {
    private final Connection conn;

    public MedicineDataModel(String Driver) throws SQLException {
        this.conn = DBKonek.getConnection(Driver);
    }
    public void addMedicine(Detail meds) throws SQLException{
        String insertMeds = "INSERT INTO medicine(meds_id, nama, kegunaan)"
                + " VALUES (?,?,?)";
        String insertDetail = "INSERT INTO medicine(meds_id, golongan, kategori)"
                + " VALUES (?,?,?)";
        PreparedStatement stmtMeds = conn.prepareStatement (insertMeds);
        stmtMeds.setInt(1, meds.getMedsID());
        stmtMeds.setString(2, meds.getNama());
        stmtMeds.setString(3, meds.getKegunaan());
        stmtMeds.execute();
        
        PreparedStatement stmtDetail = conn.prepareStatement (insertDetail);
        stmtMeds.setInt(1, meds.getMedsID());
        stmtMeds.setString(2, meds.getGolongan());
        stmtMeds.setString(3, meds.getKategori
        
        
        
        ());
        stmtMeds.execute();
    }
}
