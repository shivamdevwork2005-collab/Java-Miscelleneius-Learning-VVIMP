package InterfaceLearning_03;

public class App {
    public static void main(String[] args) {
        Bank b = new Atm(); // Upcasting To Achive 100% Abstraction.
        b.deposite(3000);
        b.withdraw(1000);
        b.checkBalance();
    }
}
