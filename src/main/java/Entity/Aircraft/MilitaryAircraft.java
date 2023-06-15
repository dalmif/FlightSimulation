package Entity.Aircraft;

import Entity.Weapon.Weapon;

public abstract class MilitaryAircraft extends ControllableAircraft {

    private Weapon[] weapons;
    private int combatRange; // it's the ratio which this military aircraft can combat

    public MilitaryAircraft(String model, int maximumSpeed, int minimumSpeed, int fuelCapacity,String capitan, Weapon[] weapons, int combatRange) {
        super(model, maximumSpeed, minimumSpeed, fuelCapacity, capitan);
        this.weapons = weapons;
        this.combatRange = combatRange;
    }

    @Override
    public void useFuel() {
        setRemainFuel(getRemainingFuel() - ((float) getSpeed()/9));
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapon[] weapons) {
        this.weapons = weapons;
    }

    public int getCombatRange() {
        return combatRange;
    }

    public void setCombatRange(int combatRange) {
        this.combatRange = combatRange;
    }
}
