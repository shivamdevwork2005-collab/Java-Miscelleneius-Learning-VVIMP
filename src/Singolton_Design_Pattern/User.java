package Singolton_Design_Pattern;

public class User {
    public static void main(String[] args) {
        AdharCard.getInstance();
        AdharCard.getInstance();
    }
}
