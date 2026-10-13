package Singolton_Design_Pattern;

public class AdharCard {
    private static AdharCard ac;

    private AdharCard(){

    }

    public static  void getInstance(){
        if(ac== null){
            ac = new AdharCard();
            System.out.println("AdharCard Instance Created........");
        }else{
            System.out.println("AdharCard instance already Exist !!!!");
        }
    }
}
