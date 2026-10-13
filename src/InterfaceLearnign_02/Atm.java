package InterfaceLearnign_02;

public class Atm implements HdfcBank {

    @Override
    public void withDraw(int amount) {
        System.out.println(amount +" is Withdrawn");
    }

    @Override
    public void deposit(int amount) {
        System.out.println(amount +" is deposited");
    }
}
