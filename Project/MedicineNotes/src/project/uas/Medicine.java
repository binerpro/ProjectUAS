/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.uas;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author mursy
 */
public  abstract class Medicine {
    private IntegerProperty medsID;
    private StringProperty Nama;
    private StringProperty kegunaan;

    public Medicine(Integer medsID, String nama, String kegunaan) {
        this.medsID.set(medsID);
        this.Nama.set(nama);
        this.kegunaan.set(kegunaan);
    }

    public Integer getMedsID() {
        return medsID.get();
    }

    public void setMedsID(Integer medsID) {
        this.medsID.set(medsID);
    }

    public String getNama() {
        return Nama.get();
    }

    public void setNama(String nama) {
        this.Nama.set(nama);
    }

    public String getKegunaan() {
        return kegunaan.get();
    }

    public void setKegunaan(String kegunaan) {
        this.kegunaan.set(kegunaan);
    }
    
    public IntegerProperty medsID(){
        return medsID;
    }
    public StringProperty nama(){
        return Nama;
    }
    public StringProperty kegunaan(){
        return kegunaan;
    }
    
}
