package TightCouplingAndLooseCouplingLearning;

public class Mobile {
    public static void main(String[] args) {
        Networks net = new Networks(new JioSim());
        net.disconnect();

        System.out.println('\n');

        Networks net2 = new Networks(new Airtel());
        net2.disconnect();

        System.out.println('\n');

        Networks net3 = new Networks(new Bsnl());
        net3.disconnect();
    }
}
