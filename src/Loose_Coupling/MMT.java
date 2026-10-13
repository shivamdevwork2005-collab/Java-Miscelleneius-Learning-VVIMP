package Loose_Coupling;

public class MMT {
    WeatherForcast wf = new AccuWether();
    WeatherForcast wf2 = new AccuWether();

    public void showForcast(){
        String res = wf.getDetails("Goa");
        System.out.println(res);

        System.out.println();
        String res2 = wf2.getDetails("Goa");
        System.out.println(res2);

    }
}
