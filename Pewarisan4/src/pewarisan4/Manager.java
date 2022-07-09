/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pewarisan4;

/**
 *
 * @author ACER
 */
public class Manager extends Pegawai{
    private double bonus;
    
    public double getBonus(){
        return bonus;
    }
    public void setBonus(double bonus){
        this.bonus = bonus;
    }
    public Manager(){
        
    }
    public Manager(int id, String name, String departement, double gaji, double bonus){
        super(id, name, departement, gaji);
        this.bonus = bonus;
        //setBonus(bonus);
    }
    public double computeSal(){
        return getGaji()+bonus;
    }
    public void accept(int id, String name, String departement, double gaji, double bonus){
        setId(id);
        setName(name);
        setDepartement(departement);
        setGaji(gaji);
        setBonus(bonus);
    }
    public void display(){
        super.display();
        System.out.println("Bonus\t = "+bonus);
    }
}
