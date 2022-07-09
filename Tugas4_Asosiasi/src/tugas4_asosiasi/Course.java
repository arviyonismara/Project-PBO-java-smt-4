/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas4_asosiasi;

/**
 *
 * @author ACER
 */
public class Course {
    //attribut
    private String nameCourse;
    private Student[] listStudent = new Student[60];
    private int countStudent;
    private Faculty[] listFaculty = new Faculty[3];
    private int countFaculty;
    
    //method
    public Course(String nameCourse){
        this.nameCourse = nameCourse;
    }
    public String getNameCourse(){
        return nameCourse;
    }
    public void addStudent(Student s){
       listStudent[countStudent] = s;
       countStudent++;
    }
    public Student[] getStudent(){
        return listStudent;
    }
    public int getCountStudent(){
        return countStudent;
    }
    public void setFaculty(Faculty f){
        listFaculty[countFaculty] = f;
        countFaculty++;
    }
    public Faculty[] getFaculty(){
        return listFaculty;
    }
    public int getCountFaculty(){
        return countFaculty;
    }
    public void printStudent(){
        for(int i=0; i<countStudent; i++){
            System.out.print(listStudent[i].getNameStudent()+", ");
        }
    }
    public void printTeacher(){
        for(int i=0; i<countFaculty; i++){
            System.out.print(listFaculty[i].getNameTeacher()+", ");
        }
    }
    public static void main(String[] args) {
        Course pbo = new Course("PBO"); //konstruktornya ada inputan nama Course
        Course web = new Course("Web");
        
        //set guru yang mengajar
        pbo.setFaculty(new Faculty("Nurul Anisa"));
        pbo.setFaculty(new Faculty("Abas Setiawan"));
        web.setFaculty(new Faculty("Nurul Anisa"));
        web.setFaculty(new Faculty("M. Syaifur Rochman"));
        //teacher adalah tokoh dari faculty
        
        //set Student
        web.addStudent(new Student("Arvie"));
        web.addStudent(new Student("Rahma"));
        web.addStudent(new Student("Dilan"));
        
        //print
        System.out.println("=== Matkul UDINUS ===");
        System.out.println("1. PBO");
        System.out.print("Dosen : ");
        pbo.printTeacher();
        System.out.print("\nMurid ada "+pbo.getCountStudent()+" :");
        pbo.printStudent();
        System.out.println("2. Web");
        System.out.print("Dosen : ");
        web.printTeacher();//void atau prosedur jadi bisa dipanggil tanpa prosedur
        System.out.print("\nMurid ada "+pbo.getCountStudent()+" :");
        //fungsi, adanya returnya, jadi panggilnya harus didalam sout
        //atau diletakkan di variabel
        web.printStudent();
    }
}
