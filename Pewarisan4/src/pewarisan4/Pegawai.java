/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pewarisan4;

/**
 *
 * @author ACER
 */
public class Pegawai {
    private int id;
    private String name;
    private String departement;
    private double gaji;
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDepartement(){
        return departement;
    }
    public void setDepartement(String departement){
        this.departement = departement;
    }
    public double getGaji(){
        return gaji;
    }
    public void setGaji(double gaji){
        this.gaji = gaji;
    }
    public Pegawai(){
        
    }
    public Pegawai (int id, String name, String departement, double gaji){    
//        this.id = id;
//        this.name = name;
//        this.departement = departement;
//        this.gaji = gaji;
        setId(id);
        setName(name);
        setDepartement(departement);
        setGaji(gaji);
    }
    public void display(){
        System.out.println("id\t = "+id);
        System.out.println("nama\t = "+name);
        System.out.println("departement\t = "+departement);
        System.out.println("gaji\t = "+gaji);
    }
}
