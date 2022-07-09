/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan3;

/**
 *
 * @author ACER
 */
public class Mobil {
    // attribut atau variable
    String warna = "merah";
    int tahunProduksi;
    int gigi = 0;

    // konstruktor
    public Mobil() {
        // tidak melakukan apa apa
    }

    public Mobil(String warna, int tahunProduksi) {
        this.warna = warna;
        // var.warna milik class mobil diisi var. warna dari inputan
        this.tahunProduksi = tahunProduksi;
    }

    // method atau fungsi
    void setWarna(String warnamobil) {
        warna = warnamobil;
        // method prosedur setter
    }

    String getWarna() {
        return warna;
        // method fungsi getter
    }

    void setTahunProduksi(int tahunProduksi) {
        this.tahunProduksi = tahunProduksi;
        // method prosedur setter
    }

    int getTahunProduksi() {
        return tahunProduksi;
        // method fungsi getter
    }

    void tambahGigi() {
        gigi = gigi + 1;
        System.out.println("gigi sekarang =" + gigi);
    }

    void kurangGigi() {
        gigi = gigi - 1;
        System.out.println("gigi sekarang =" + gigi);
    }
}
