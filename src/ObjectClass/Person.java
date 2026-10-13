package ObjectClass;

public class Person {
    @Override
    public String toString() {
        return getClass().getName() + "@Adarsh_Ojha" + Integer.toHexString(hashCode());
    }

    public static void main(String[] args) {
        Object obj = new Person();

        Person p = new Person();
        System.out.println(p); // implicit toString Method is called
        System.out.println(p.toString()); // explicitly toString Method is called

    }
}
