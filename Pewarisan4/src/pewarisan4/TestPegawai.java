/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pewarisan4;

/**
 *
 * @author ACER
 */
public class TestPegawai {
    public static boolean isNamaSama(Manager p1, Manager p2){
        String namaP1 = p1.getName().toLowerCase();
        String namaP2 = p2.getName().toLowerCase();
        if(namaP1.equals(namaP2)){
            return true;
        }
        else
            return false;
    }
    public static double max2(double a, double b){
        if(a>b){
            return a;
        }
        else 
            return b;
    }
    
    public static void main(String[] args) {
        Manager e[]= new Manager[3];//array of object
        e[0]=new Manager();
        e[1]=new Manager(2, "Widodo", "IS", 1300.50,300.00);
        e[2]=new Manager(3, "Joko","Accounting",1250.0,100.5);
        e[0].accept(1, "Joko","R/D",1250.0,20.5);
        
        //buat jadi looping
        for (int i=0; i<2; i++){
            e[i].display();System.out.println("");
        }
        
        System.out.println("Manager 1 dan Manager 3 memiliki nama yang ");
        if(isNamaSama(e[0], e[2]))
            System.out.println("sama");
        else
            System.out.println("tidak sama");
        
        if (e[0].computeSal()>max2(e[1].computeSal(),e[2].computeSal()))
            System.out.println("Maximum Salary : "+e[0].computeSal());
        else if (e[1].computeSal()>max2(e[0].computeSal(),e[2].computeSal()))
            System.out.println("Maximum Salary : "+e[1].computeSal());
        else
            System.out.println("Maximum Salary : "+e[2].computeSal());
    }   
}
