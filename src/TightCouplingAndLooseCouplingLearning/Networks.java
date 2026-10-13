package TightCouplingAndLooseCouplingLearning;

public class Networks {

    //JioSim jio = new JioSim();
    //Airtel airtel = new Airtel(); // tightCoupling

    //HalfCoupling

    // SimCard simCard = new JioSim();
    // SimCard simCard = new Airtel();

    Networks(SimCard simCard1) {  // kind Of Upcasting

        SimCard simCard = simCard1;

       // jio.sim();
       // airtel.sim();

        //HalfCoupling

        simCard.sim();
        simCard.recharge();
        simCard.showHistory();
        simCard.showSettings();
        simCard.showData();
        simCard.showBalance();
        simCard.showPlans();
    }

    static {
        System.out.println("\n====================== Connecting to network=========================\n");
    }

    {
        System.out.println("\n======================= Showing networks ==============================\n");
    }


    void disconnect(){
        System.out.println("\n========================= Disconnecting from network ================\n");
    }


}
