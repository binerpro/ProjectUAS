/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicinenotestable;

/**
 *
 * @author mursy
 */
public class obat {
    int id;
    String nama,kategori,kegunaan;

    public obat(int id, String nama, String kategori, String kegunaan) {
        this.id = id;
        this.nama = nama;
        this.kategori = kategori;
        this.kegunaan = kegunaan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getKegunaan() {
        return kegunaan;
    }

    public void setKegunaan(String kegunaan) {
        this.kegunaan = kegunaan;
    }
    
}
