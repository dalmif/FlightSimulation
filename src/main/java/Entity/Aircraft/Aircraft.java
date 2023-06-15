package Entity.Aircraft;

import java.util.ArrayList;

public abstract class Aircraft {

    // CONSTANTS
    public static final int DEMONSTRATION_SPEED = 150; //150 equals to zero in simulation

    private String model;
    private int maximumSpeed;
    private int minimumSpeed;
    private int fuelCapacity;

    public Aircraft(String model, int maximumSpeed, int minimumSpeed, int fuelCapacity) {
        this.model = this.getClass().getSimpleName() + " " + model;
        setMaximumSpeed(maximumSpeed);
        setMinimumSpeed(minimumSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ArrayList<String> getInformation() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Aircraft Model: " + getModel());
        return list;
    }

    public int getMinimumSpeed() {
        return minimumSpeed;
    }

    public final void setMaximumSpeed(int maximumSpeed) {
        if (maximumSpeed < DEMONSTRATION_SPEED || maximumSpeed > DEMONSTRATION_SPEED * 2 ) {
            throw new RuntimeException("You just can set maximum between " + DEMONSTRATION_SPEED + ", " + DEMONSTRATION_SPEED * 2);
        }
        this.maximumSpeed = (maximumSpeed - DEMONSTRATION_SPEED) / 10;
    }

    public final void setMinimumSpeed(int minSpeed) {
        if (minSpeed < DEMONSTRATION_SPEED || minSpeed > DEMONSTRATION_SPEED * 2) {
            throw new RuntimeException("You just can set maximum between " + DEMONSTRATION_SPEED + ", " + DEMONSTRATION_SPEED * 2);
        }
        this.minimumSpeed = (minSpeed - DEMONSTRATION_SPEED) / 10;
    }
}
