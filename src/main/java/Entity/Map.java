package Entity;

import Entity.Aircraft.ControllableAircraft;
import Entity.Unit.CPoint;
import Entity.Unit.Size;
import Gui.Gui;

import java.util.ArrayList;

public final class Map implements Drawable {
    private static Map instance;
    private ControllableAircraft myAircraft;
    private final ArrayList<Watchtower> watchtowers;

    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }

    private Map () {
        this.watchtowers = new ArrayList<>();
    }

    public void addTower(Watchtower tower) {
        this.watchtowers.add(tower);
    }

    public void setMyAircraft(ControllableAircraft myAircraft) {
        this.myAircraft = myAircraft;
    }

    public ControllableAircraft getMyAircraft() {
        if (myAircraft == null)
            throw new RuntimeException("You should pass an aircraft to Map before usage.");
        return myAircraft;
    }

    public ArrayList<Watchtower> getWatchtowers() {
        return watchtowers;
    }

    @Override
    public String getImagePath() {
        return "/europe-map.jpg";
    }

    @Override
    public CPoint getPoint() {
        return new CPoint(0,0);
    }

    @Override
    public Size getSize() {
        return new Size(Gui.gameDisplayWidth, Gui.gameDisplayHeight);
    }
}
