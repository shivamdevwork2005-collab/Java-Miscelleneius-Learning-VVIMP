package InterfaceLearnign_03;

public class App {
    public static void main(String[] args) {
        Mobile m1 = new Mobile("I phone 18");
        System.out.println("Model of Mobile is "+m1.model);
        m1.powerOn();
        m1.clickPhoto(120);
        m1.playMusic("Dolo jbl");
        m1.powerOff();

        System.out.println('\n');

        ButoothSpeaker s1 = new ButoothSpeaker();
        s1.powerOn();
        s1.playMusic("Sony");
        s1.powerOff();

        System.out.println('\n');

        Dclr d1 = new Dclr(500);
        d1.powerOn();
        d1.clickPhoto(500);
        d1.powerOff();
    }

}