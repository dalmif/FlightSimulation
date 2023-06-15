package Entity.Aircraft;

import java.util.ArrayList;

public abstract class Airliner extends ControllableAircraft {

    private int passengerCapacity;
    private int passengerCount;
    private int maximumTakeoffWeight;
    private int cruiseSpeed;

    public Airliner(String model, int maximumSpeed, int minimumSpeed, int fuelCapacity,String capitan, int passengerCapacity,int passengerCount, int maximumTakeoffWeight, int cruiseSpeed) {
        super(model, maximumSpeed, minimumSpeed, fuelCapacity,capitan);
        this.passengerCapacity = passengerCapacity;
        this.passengerCount = passengerCount;
        this.maximumTakeoffWeight = maximumTakeoffWeight;
        this.cruiseSpeed = cruiseSpeed;
    }

    @Override
    public void useFuel() {
        if (getSpeed() == 0)
            return;
        setRemainFuel(getRemainingFuel() - ((float) getSpeed()/18) - ((float) ((getPassengerCount() / 10) + getPassengerCapacity())) / 2100);
    }

    public int getCruiseSpeed() {
        return cruiseSpeed;
    }

    public void setCruiseSpeed(int cruiseSpeed) {
        this.cruiseSpeed = cruiseSpeed;
    }

    public int getMaximumTakeoffWeight() {
        return maximumTakeoffWeight;
    }

    public void setMaximumTakeoffWeight(int maximumTakeoffWeight) {
        this.maximumTakeoffWeight = maximumTakeoffWeight;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public ArrayList<String> getInformation() {
        ArrayList<String> info = super.getInformation();
        info.add("Passengers: " + getPassengerCount() + "/" +getPassengerCapacity());
        return info;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }
}
