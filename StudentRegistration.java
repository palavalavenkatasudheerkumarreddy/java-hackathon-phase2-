import java.util.Scanner;

class Student {

    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;
    Student(String name, int roll, double m, String course, int credits) {
        studentName = name;
        rollNumber = roll;
        marks = m;
        courseName = course;
        courseCredits = credits;
    }
    double calculateFee() {
        double fee = courseCredits * 1500;
        return fee;
    }
    boolean checkEligibility() {
        if (marks >= 50) {
            return true;
        } else {
            return false;
        }
    }
    double calculateScholarship() {
        double fee = calculateFee();
        if (marks >= 85) {
            return fee * 20 / 100;
        } 
        else if (marks >= 70) {
            return fee * 10 / 100;
        } 
        else {
            return 0;
        }
    }
    double calculateFinalFee() {
        double fee = calculateFee();
        double scholarship = calculateScholarship();
        return fee - scholarship;
    }
    void displayDetails() {

        System.out.println("Student Details: ");
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        if (checkEligibility()) {
            System.out.println("Eligibility: Eligible");
        } else {
            System.out.println("Eligibility: Not Eligible");
        }
        System.out.println("Total Fee: Rs. " + calculateFee());
        System.out.println("Scholarship: Rs. " + calculateScholarship());
        System.out.println("Final Fee: Rs. " + calculateFinalFee());
    }
}
public class StudentRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();
        System.out.print("Enter Course Credits: ");
        int credits = sc.nextInt();
        Student s = new Student(name, roll, marks, course, credits);
        if (s.checkEligibility()) {
            s.displayDetails();
        } 
        else {
            System.out.println("\nStudent is not eligible for registration.");
            System.out.println("Minimum marks required is 50.");
        }
        sc.close();
    }
}
