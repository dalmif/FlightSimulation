package Entity.Weapon;

import java.awt.event.KeyEvent;

public class ShootingWeapon extends Weapon {
    public ShootingWeapon() {
        super(5, KeyEvent.VK_N);
    }

    @Override
    public void fire() {
        System.out.println("Shoot a bullet");
    }
}
