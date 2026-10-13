package InterfaceLearning_03;

public class Atm implements Bank{

    int balance=10000;

    @Override
    public void deposite(int amount) {
        System.out.println("Amount to Deposite "+amount);
        balance+=amount;
        System.out.println("-------------------------------------------------");
    }

    @Override
    public void withdraw(int amount) {
        System.out.println("Amount to be Withdrawn "+amount);
        balance-=amount;
        System.out.println("-----------------------------");
    }

    @Override
    public void checkBalance() {
        System.out.println("Your Balance is "+balance);
        System.out.println("-------------------");
    }
}
