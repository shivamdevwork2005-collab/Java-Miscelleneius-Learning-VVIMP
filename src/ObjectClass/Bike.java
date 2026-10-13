package ObjectClass;

public class Bike {

//    @Override
//    public int hashCode(){
//        return 1000;
//    }

    public static void main(String[] args) {
        Bike b = new Bike();
        System.out.println(b.toString()); // implicit toString Method is called
        System.out.println(b.getClass());
        System.out.println(b.getClass().getName());
        System.out.println(b.hashCode());
        System.out.println(Integer.toHexString(b.hashCode()));
    }
}
