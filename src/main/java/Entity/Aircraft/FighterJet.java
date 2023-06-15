package Entity.Aircraft;

import Entity.Aircraft.MilitaryAircraft;
import Entity.Weapon.Weapon;
import Utility.Dir;

import java.awt.event.KeyEvent;

public class FighterJet extends MilitaryAircraft {

    public FighterJet(String model, int maximumSpeed, int minimumSpeed, int fuelCapacity, String capitan , Weapon[] weapons, int combatRange) {
        super(model, maximumSpeed, minimumSpeed, fuelCapacity, capitan, weapons, combatRange);
    }

    public String getImagePath() {
        Dir pathName = getDir();
        if (pathName == Dir.NONE)
            pathName = getLastDir();
        return "/airplane_fighterjet_" + pathName.toString() + ".png";
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        for (Weapon weapon : getWeapons()) {
            if (weapon.getKey() == e.getKeyCode())
                weapon.fire();
        }
    }
}
