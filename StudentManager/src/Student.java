
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tunkyo
 */
public class Student {
    protected String id;
    protected String name;
    protected String email;
    protected Grade grade;
    
    class Grade {
        protected double PRF192;
        protected double MAE101;
        protected double CSI101;

        public Grade(double PRF192, double MAE101, double CSI101) {
            this.PRF192 = PRF192;
            this.MAE101 = MAE101;
            this.CSI101 = CSI101;
        }
        
        
    }

    public Student() {
    }

    public Student(String id, String name, String email, Grade grade) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.grade = grade;
    }
    
    public double calGPA(double PRF192, double MAE101, double CSI101) {
        double gpa = (PRF192 + MAE101 + CSI101)/3;
        
        return gpa;
    }

      public int schorlarShip(double calGPA) {
        if (calGPA > 8 && calGPA < 10) {
            System.out.println("Student.schorlarShip 100%");
        }
        if (calGPA > 6 && calGPA < 7) {
            System.out.println("Student.schorlarShip 50%");
        }
        if (calGPA > 5 && calGPA < 6) {
            System.out.println("Student.schorlarShip 30%");
        }
        return 0;
}
    
    public static Student searchStudent(List<Student> students, String id) {
        for (Student student : students) {
            if(student.id.equals(id)) {
                return student;
            }
        }
        return null;
    }
    
    public void displayStudent() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("GRADES:");
        System.out.println("PRF192: " + grade.PRF192);
        System.out.println("MAE101: " + grade.MAE101);
        System.out.println("CSI101: " + grade.CSI101);
        System.out.println("");
    }
}
