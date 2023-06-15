package Entity;


import Entity.Aircraft.Connectable;
import Entity.Unit.CPoint;
import Entity.Unit.Size;

import java.util.ArrayList;

public class Watchtower implements Drawable {
    private int x, y;
    private int ratio;
    private Country country;
    private int  hostingCapacity = 2;
    private ArrayList<Connectable> connections;

    public Watchtower (Country country, int x,int y, int ratio) {
        this.setCountry(country);
        this.x = x;
        this.y = y;
        this.ratio = ratio;
        this.connections = new ArrayList<>();
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    @Override
    public String getImagePath() {
        for (Connectable connectable : connections){
            if (connectable == Map.getInstance().getMyAircraft())
                return "/active_tower.png";
        }
        return "/inactive_tower.png";
    }

    @Override
    public CPoint getPoint() {
        return new CPoint(getX(),getY());
    }

    @Override
    public Size getSize() {
        return new Size(30,30);
    }

    //You can throw an Exception which tell to Connectable
    public void connectionRequest (Connectable connectable) throws Exception {
        if (connections.size() >= hostingCapacity)
            throw new Exception("We don't have any space to be host of you. try again later");

        connections.add(connectable);
        connectable.connect(this);
    }

    public void disconnect (Connectable connectable) {
        connections.remove(connectable);
    }

    public ArrayList<Connectable> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<Connectable> connections) {
        this.connections = connections;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getHostingCapacity() {
        return hostingCapacity;
    }

    public void setHostingCapacity(int hostingCapacity) {
        this.hostingCapacity = hostingCapacity;
    }
}