package CustomHashMap;

public class App {
    public static void main(String[] args) {

       CustomHashMap<String,Integer> mp = new CustomHashMap<String,Integer>();

       mp.put("One",1);
       mp.put("Two",2);
       mp.put("Three",3);
       mp.put("Four",4);
       mp.put("Five",5);

        System.out.println(mp);

       System.out.println(mp.get("One"));
       System.out.println(mp.get("Two"));
       System.out.println(mp.get("Three"));
       System.out.println(mp.get("Four"));
       System.out.println(mp.get("Five"));
       System.out.println(mp.get("Six"));
       System.out.println(mp.get("Seven"));
       System.out.println(mp.get("Eight"));
       System.out.println(mp.get("Nine"));
       System.out.println(mp.get("Ten"));

       mp.remove("One");
       System.out.println(mp.get("One"));

       System.out.println(mp.getSize());

       mp.put("One",1);
       System.out.println(mp.get("One"));
       System.out.println(mp.getSize());



    }
}
