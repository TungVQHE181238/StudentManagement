
import java.io.FileWriter;
import java.io.IOException;
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
        double gpa = (PRF192 + MAE101 + CSI101) / 3;

        return gpa;
    }

    public void scholarship(double calGPA) {
        if (calGPA >= 8 && calGPA <= 10) {
            System.out.println("Student.scholarship 100%");
        } else if (calGPA >= 6.0 && calGPA <= 7.9) {
            System.out.println("Student.scholarship 50%");
        } else if (calGPA >= 5 && calGPA <= 5.9) {
            System.out.println("Student.scholarship 30%");
        } else {
            System.out.println("Student.scholarship 0%");
        }
    }

    public static Student exportStudentListToFile(List<Student> students, String fileName) throws IOException {

        try (FileWriter writer = new FileWriter(fileName)) {
            for (Student student : students) {
                writer.write(student.toString() + "\n");
            }
            writer.flush();
            System.out.println("Student list exported successfully to " + fileName);
        }
        return null;
    }

    public static Student searchStudent(List<Student> students, String id) {
        for (Student student : students) {
            if (student.id.equals(id)) {
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

    public static void displayTop3Student(List<Student> students) {
    Student[] top3 = new Student[3];

    for (Student student : students) {
        double gpa = student.calGPA(student.grade.PRF192, student.grade.MAE101, student.grade.CSI101);
        for (int i = 0; i < 3; i++) {
            if (top3[i] == null || gpa > top3[i].calGPA(top3[i].grade.PRF192, top3[i].grade.MAE101, top3[i].grade.CSI101)) {
                // Shift elements to the right to make space for the new top student
                for (int j = 2; j > i; j--) {
                    top3[j] = top3[j - 1];
                }
                top3[i] = student;
                break;
            }
        }
    }

    for (Student s : top3) {
        if (s != null) {
            System.out.println(s);
        }
    }
}

 

    @Override
    public String toString() {
        return id + "|" + name + "|" + email + "|" + grade.PRF192 + "|" + grade.MAE101 + "|" + grade.CSI101 + "|" + calGPA(grade.PRF192, grade.MAE101, grade.CSI101);
    }

}
