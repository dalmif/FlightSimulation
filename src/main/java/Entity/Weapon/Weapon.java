package Entity.Weapon;

public abstract class Weapon {
    private int destructionPower;

    private final int key;

    public Weapon(int destructionPower, int key) {
        this.destructionPower = destructionPower;
        this.key = key;
    }

    abstract public void fire();

    public int getDestructionPower() {
        return destructionPower;
    }

    public void setDestructionPower(int destructionPower) {
        this.destructionPower = destructionPower;
    }

    public int getKey() {
        return key;
    }
}
