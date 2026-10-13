package Loose_Coupling;

public class BeingWether implements WeatherForcast {

    @Override
    public String getDetails(String Loc) {
        return "Today's Forcast in "+ Loc +" 50 deg and High Wind Speed with Tsunami and High Tides with Moist 10deg and low Air Quality";
    }
}
