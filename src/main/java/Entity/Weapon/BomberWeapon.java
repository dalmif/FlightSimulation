package Entity.Weapon;

import java.awt.event.KeyEvent;

public class BomberWeapon extends Weapon {

    public BomberWeapon() {
        super(15, KeyEvent.VK_M);
    }

    @Override
    public void fire() {
        System.out.println("Bomb thrown");
    }
}
