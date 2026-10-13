package StringClass;

public class Demo {

    @Override
    public String toString() {
        return "Demo";
    }


    //============ internal impl ==================

//    public String toString() {
//        return this;
//    }

    public static void main(String[] args) {
        String s1 = "Hello";         // String Object
        String s2 = "Hello";
        String s3 = new String("Hello");
        String s4 = new String("Hello");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));

        System.out.println(s1.toString());
        System.out.println(s3);

        System.out.println(s4.hashCode());
        System.out.println(s2.hashCode());


    }
}
