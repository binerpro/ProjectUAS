/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.uas;

import javafx.beans.property.StringProperty;

/**
 *
 * @author mursy
 */
public class Detail extends Medicine{
    StringProperty golongan;
    StringProperty kategori;

    public Detail(Integer medsID, 
            String nama, String kegunaan, String golongan, 
            String kategori) {
        super(medsID, nama, kegunaan);
        this.golongan.set(golongan);
        this.kategori.set(kategori);
    }

    public String getGolongan() {
        return golongan.get();
    }

    public void setGolongan(String golongan) {
        this.golongan.set(golongan);
    }

    public String getKategori() {
        return kategori.get();
    }

    public void setKategori(String kategori) {
        this.kategori.set(kategori);
    }
    
    public StringProperty GolonganProperty() {
        return golongan;
    }
    
    public StringProperty KategoriProperty() {
        return kategori;
    }
}
