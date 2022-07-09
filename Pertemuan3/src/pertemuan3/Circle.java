/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan3;

/**
 *
 * @author ACER
 */
public class Circle {
    double radius = 1;

    // konstruktor
    Circle() {// nama konstruktor harus sama dengan nama class

    }

    Circle(double newRadius) {
        radius = newRadius;// tidak menggunakan this karena nama parameter berbeda dengan nama variabel
    }

    // method fungsi atau prosedur
    double getArea() {
        // method fungsi
        return radius * radius * Math.PI;
    }

    double getPerimeter() {
        // method fungsi
        return 2 * radius * Math.PI;
    }

    void setRadius(double newRadius) {
        radius = newRadius;
        // method prosedur setter
    }

    public static void main(String[] args) {
        // object harus di dalam method main
        Circle circle1 = new Circle();// radius , sudah default
        Circle circle2 = new Circle(25);// set radius dari konstruktor
        Circle circle3 = new Circle();
        // circle1.setRadius(125);// set radius dari method setter

        System.out.println("Luas circle1 = " + circle1.getArea());
        System.out.println("keliling circle1 = " + circle1.getPerimeter());
        System.out.println("Luas circle2 = " + circle2.getArea());
        System.out.println("keliling circle2 = " + circle2.getPerimeter());
        System.out.println("Luas circle3 = " + circle3.getArea());
        System.out.println("keliling circle3 = " + circle3.getPerimeter());
    }
}
