package TightCouplingAndLooseCouplingLearning;

public class JioSim implements  SimCard {
    @Override
    public void sim(){
        System.out.println("Jio Sim card \n");
    }


    @Override
    public void showPlans(){
        System.out.println("Showing plans of jio \n");
    }

    @Override
    public void showData(){
        System.out.println("Showing data of jio \n");
    }

    @Override
    public void showBalance(){
        System.out.println("Showing balance of jio \n");
    }

    @Override
    public void recharge(){
        System.out.println("Recharging of jio \n");
    }

    @Override
    public void showHistory(){
        System.out.println("Showing history of jio \n");
    }

    @Override
    public void showSettings(){
        System.out.println("Showing settings jio \n");
    }


}
