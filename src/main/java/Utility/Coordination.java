package Utility;

public class Coordination {
    private double lat;
    private double lng;

    public Coordination () {

    }

    public void update (int x, int y) {
        this.lat =  65.318902 - y * 0.0455;
        this.lng = -43.005589 + x * 0.1471;
    }

    @Override
    public String toString() {
        return String.format("%.6f",lat) + ", " + String.format("%.6f",lng);
    }
}
