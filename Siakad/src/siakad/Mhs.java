/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package siakad;

import java.io.PipedInputStream;
import javax.swing.plaf.nimbus.NimbusStyle;

/**
 *
 * @author ACER
 */
public class Mhs implements Nilai{
    public String nim, nama;
    double vUts, vUas, vTugas;
    double nilaiAkhir;
    char nHuruf;
    String predikat;
    
    public Mhs(String nim, String nama, double vUts, double vUas, double  vTugas){
        //konstruktor
        this.nim = nim;
        this.nama = nama;
        this.vUts = vUts;
        this.vUas = vUas;
        this.vTugas = vTugas;
    }
    
    public double uts(){
        return vUts * 35/100;
    }
    public double uas(){
        return vUas * 35/100;
    }
    public double tugas(){
        return vTugas * 30/100;
    }
    public double nilaiAkhir(){
        return uts()+ uas()+tugas();
    }
    
    @Override
    public char getNilHuruf(double nilaiAkhir) {
        if(nilaiAkhir>=85)
            nHuruf='A';
        else if(nilaiAkhir>=70 && nilaiAkhir<85)
            nHuruf='B';
        else if(nilaiAkhir>=60 && nilaiAkhir<75)
            nHuruf='C';
        else if(nilaiAkhir>=40 && nilaiAkhir<60)
            nHuruf='D';
        else 
            nHuruf='E';
        return nHuruf;
    }

    @Override
    public String getPredikat(char nhuruf) {
        switch(nhuruf)
        {
            case 'A' : predikat= "Apik";
               break;
            case 'B' : predikat= "Baik";
            break;
            case 'C' : predikat= "Cukup";
            break;
            case 'D' : predikat= "Dablek";
            break;
            default : predikat= "Elek";
        }
        return predikat;
    }
    
}
