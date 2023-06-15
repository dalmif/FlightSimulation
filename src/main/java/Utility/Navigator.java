package Utility;

import Entity.Aircraft.ControllableAircraft;
import Entity.Unit.CPoint;
import Entity.Map;
import Entity.Watchtower;

import java.util.ArrayList;

public class Navigator {

    private final ControllableAircraft aircraft;

    public Navigator(ControllableAircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Watchtower nearestTower () {
        ArrayList<Watchtower> towers = Map.getInstance().getWatchtowers();
        double nearestDistance = Integer.MAX_VALUE;
        Watchtower nearestTower = null;
        for (Watchtower watchtower : towers) {
            double distance = findDistance(watchtower);
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestTower = watchtower;
            }
        }
        return nearestTower;
    }
    public double findDistance (Watchtower tower) {
        CPoint aircraftPosition = aircraft.getPoint().getCenterOf(aircraft.getSize());
        CPoint towerPosition = tower.getPoint().getCenterOf(tower.getSize());
        int x = aircraftPosition.x - towerPosition.x;
        int y = aircraftPosition.y - towerPosition.y;
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
    }
}
