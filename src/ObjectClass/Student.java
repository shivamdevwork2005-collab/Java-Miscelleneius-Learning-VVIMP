package ObjectClass;

public class Student {
    String name;
    Student(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Name: "+name;
    }

    public static void main(String[] args) {
        Student s1 = new Student("Adarsh");
        System.out.println(s1);
    }

}
