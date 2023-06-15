package Entity.Aircraft;

import Entity.Aircraft.Airliner;
import Utility.Dir;

public class CommercialAirliner extends Airliner {

    public CommercialAirliner(String model, int maximumSpeed, int minimumSpeed, int fuelCapacity,String capitan, int passengerCapacity,int passengerCount, int maximumTakeoffWeight, int cruiseSpeed) {
        super(model, maximumSpeed, minimumSpeed, fuelCapacity, capitan, passengerCapacity, passengerCount, maximumTakeoffWeight, cruiseSpeed);
    }

    public String getImagePath() {
        Dir pathName = getDir();
        if (pathName == Dir.NONE)
            pathName = getLastDir();
        return "/airplane_" + pathName.toString() + ".png";
    }

}
