package TightCouplingAndLooseCouplingLearning;

public class Airtel implements SimCard{
    @Override
    public void sim(){
        System.out.println("Airtel Sim card \n");
    }


    @Override
    public void showPlans(){
        System.out.println("Showing plans of airtel \n");
    }

    @Override
    public void showData(){
        System.out.println("Showing data of airtel \n");
    }

    @Override
    public void showBalance(){
        System.out.println("Showing balance of airtel \n");
    }

    @Override
    public void recharge(){
        System.out.println("Recharging of airtel \n");
    }

    @Override
    public void showHistory(){
        System.out.println("Showing history of airtel \n");
    }

    @Override
    public void showSettings(){
        System.out.println("Showing settings of airtel \n");
    }

}
