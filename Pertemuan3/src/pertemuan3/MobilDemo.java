/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan3;

/**
 *
 * @author ACER
 */
public class MobilDemo {
        public static void main(String[] args) {
                // membuat objek baru
                Mobil mobilku = new Mobil(); // object mobilku
                // memanggil construktor ke-1 tanpa inputan
                Mobil mobilmu = new Mobil("white", 2020); // object mobilmu
                // memanggil konstruktor ke-2 dengan 2 inputan

                // mobilku.warna = "Merah";
                // mobilku.tahunProduksi = 2002;
                mobilku.setWarna("Biru");// setter
                mobilku.setTahunProduksi(2050);
                // System.out.println("Mobilku warna = "+mobilku.warna); //attribut
                // System.out.println("Mobilku tahun = "+mobilku.tahunProduksi);
                System.out.println("Mobilku warna = " + mobilku.getWarna());
                System.out.println("Mobilku tahun = " + mobilku.getTahunProduksi());
                mobilku.tambahGigi(); // method
                mobilku.tambahGigi();
                mobilku.kurangGigi();

                // mobilmu.warna = "Hitam";
                // mobilmu.tahunProduksi = 2008;
                System.out.println("\n\nMobilmu warna = " + mobilmu.warna); // attribut
                System.out.println("Mobilmu tahun = " + mobilmu.tahunProduksi);
                mobilmu.tambahGigi(); // method
                mobilmu.tambahGigi();
                mobilmu.kurangGigi();

        }
}
