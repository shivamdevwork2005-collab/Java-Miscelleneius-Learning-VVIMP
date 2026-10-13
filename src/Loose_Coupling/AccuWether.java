package Loose_Coupling;

public class AccuWether implements WeatherForcast{

    @Override
    public String getDetails(String Loc) {
        return "Today's Forcast  in "+ Loc +"30 deg and High Wind Speed with Moist 5deg and low Air Quality";
    }
}
