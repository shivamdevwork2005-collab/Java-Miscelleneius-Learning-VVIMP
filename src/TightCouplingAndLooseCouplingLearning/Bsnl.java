package TightCouplingAndLooseCouplingLearning;

public class Bsnl implements SimCard{

    @Override
    public void sim(){
        System.out.println("Bsnl Sim card \n");
    }


    @Override
    public void showPlans(){
        System.out.println("Showing plans of Bsnl \n");
    }

    @Override
    public void showData(){
        System.out.println("Showing data of Bsnl \n");
    }

    @Override
    public void showBalance(){
        System.out.println("Showing balance of Bsnl \n");
    }

    @Override
    public void recharge(){
        System.out.println("Recharging of Bsnl \n");
    }

    @Override
    public void showHistory(){
        System.out.println("Showing history of Bsnl \n");
    }

    @Override
    public void showSettings(){
        System.out.println("Showing settings Bsnl \n");
    }

}
