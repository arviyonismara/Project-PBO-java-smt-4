/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas4_asosiasi;

/**
 *
 * @author ACER
 */
public class Faculty {
    //atribut
    private String teacher;
    private Course[] listCourses = new Course[3];
    private int countCourse;
    
    //method
    public Faculty(String teacher){
        //konstruktor
        this.teacher = teacher;
    }
    public String getNameTeacher(){
        return teacher;
    }
    public void  teachCourse(Course c){
        listCourses[countCourse] = c;
        countCourse++;
    }
    public Course[] getListCourse(){
        return listCourses;
    }
    public int getCountCourse(){
        return countCourse;
    }
    public static void main(String[] args) {
        
    }
}
