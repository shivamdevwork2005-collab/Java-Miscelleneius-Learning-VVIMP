package ObjectArray;

import java.util.Scanner;

public class Student {
    int age;
    String name;
    Student(int age,String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{\n "+
                "      age=" + age +
                ",\n   name='" + name + '/' +
                "\n"+
                '}';
    }

    public static void main(String[] args) {
        Student s1 = new Student(21,"Adarsh");
        Student s2 = new Student(22,"Shivam");
        Student s3 = new Student(23,"Raghav");

        Student[] students = new Student[3];
        students[0] = s1;
        students[1] = s2;
        students[2] = s3;

        for(Student s: students){
            System.out.println(s);
            System.out.println();
        }
        System.out.println("\n");

        for(Student s: students){
            System.out.println(s.age + " " + s.name);
            System.out.println();
        }

        System.out.println("\n");

        for(Student s: students){
            System.out.print("Enter Your Name:-");
            s.name = new Scanner(System.in).nextLine();
            System.out.print("Enter your age:-");
            s.age = new Scanner(System.in).nextInt();
            System.out.println(s);

            System.out.println();
        }


    }
}
