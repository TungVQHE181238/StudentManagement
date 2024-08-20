
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import jdk.nashorn.internal.parser.Lexer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tunkyo
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> stuList = new ArrayList<>();
        int choice;

        do {
            System.out.println("====================================");
            System.out.println("Welcome to Student Management System");
            System.out.println("OPTIONS:");
            System.out.println("1. Add new student");
            System.out.println("2. Edit a student");
            System.out.println("3. Delete a student");
            System.out.println("4. Search a student");
            System.out.println("5. Display all students");
            System.out.println("6. Exit the program");
            System.out.println("====================================");
            System.out.print("Your option(1,2,3,4): ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    sc.nextLine();

                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    String email;
                    while (true) {
                        System.out.print("Email: ");
                        email = sc.nextLine();

                        if (email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                            break;
                        } else {
                            System.out.println("Invalid email.Please try again");
                        }
                    }

                    System.out.println("GRADE:");
                    System.out.print("Grade for PRF192: ");
                    double prf192 = sc.nextDouble();
                        while(prf192 <=0 && prf192 > 10) {
                        
                    }
                    
                    System.out.print("Grade for MAE101: ");
                    double mae101 = sc.nextDouble();
                    System.out.print("Grade for CSI101: ");
                    double csi101 = sc.nextDouble();

                    Student.Grade grade = new Student().new Grade(prf192, mae101, csi101);

                    Student newStu = new Student(id, name, email, grade);
                    stuList.add(newStu);
                    System.out.println("Added new student, this is your new student information:");
                    newStu.displayStudent();
                    System.out.println("");
                    break;

                case 2:
                    sc.nextLine();

                    System.out.print("Enter ID of student: ");
                    String idE = sc.nextLine();
                    Student editStudent = Student.searchStudent(stuList, idE);

                    if (editStudent != null) {
                        System.out.println("Found student!");
                        System.out.print("ID(leave black to keep current): ");
                        String newId = sc.nextLine();

                        if (!newId.isEmpty()) {
                            editStudent.id = newId;
                        }
                        System.out.print("Name(leave black to keep current): ");
                        String newName = sc.nextLine();
                        if (!newName.isEmpty()) {
                            editStudent.name = newName;
                        }

                        System.out.print("Email: ");
                        String newEmail = sc.nextLine();
                        if (!newEmail.isEmpty()) {
                            while (!newEmail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                                System.out.println("Invalid email.Please try again");
                                System.out.print("Email: ");
                                newEmail = sc.nextLine();
                            }
                            editStudent.email = newEmail;
                        }

                        System.out.println("GRADE:");
                        System.out.print("Grade for PRF192(Type -1 to keep current): ");
                        double newPrf192 = sc.nextDouble();
                        if (newPrf192 > 0 && newPrf192 <= 10) {
                            editStudent.grade.PRF192 = newPrf192;
                        }
                        
                        System.out.print("Grade for MAE101(Type -1 to keep current): ");
                        double newMae101 = sc.nextDouble();
                        if (newMae101 > 0 && newMae101 <= 10) {
                            editStudent.grade.MAE101 = newMae101;
                        }
                        
                        System.out.print("Grade for CSI101(Type -1 to keep current): ");
                        double newCsi101 = sc.nextDouble();
                        if (newCsi101 > 0 && newCsi101 <= 10) {
                            editStudent.grade.CSI101 = newCsi101;
                        }
                        
                        System.out.println("Updated your new information: ");
                        editStudent.displayStudent();
                    } else {
                        System.out.println("Not found any student with id: " + idE);
                    }

                    break;

                case 4:
                    System.out.print("Enter ID of student: ");
                    String idF = sc.next();
                    Student studentFound = Student.searchStudent(stuList, idF);

                    if (studentFound != null) {
                        studentFound.displayStudent();
                    } else {
                        System.out.println("No student found with the id: " + idF);
                    }
                    break;

                case 5:
                    for (Student student : stuList) {
                        System.out.println("------------------------");
                        student.displayStudent();
                    }
                    break;

                case 6:
                    System.out.println("Exitting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again");
                    break;

            }
        } while (choice != 6);

    }
}
