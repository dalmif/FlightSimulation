import Entity.Aircraft.BusinessJet;
import Entity.Aircraft.CommercialAirliner;
import Entity.Aircraft.ControllableAircraft;
import Entity.Aircraft.FighterJet;
import Entity.Country;
import Entity.Map;
import Entity.Watchtower;
import Entity.Weapon.BomberWeapon;
import Entity.Weapon.ShootingWeapon;
import Entity.Weapon.Weapon;
import Gui.Gui;

public class Main {

    public static void main(String[] args) {
        configure();
        Gui g = new Gui();
        GameClock gc = new GameClock(g);
        g.createGui();
        gc.start();
    }

    private static void configure () {
        Map.getInstance().setMyAircraft(createAircraft());
        Map.getInstance().addTower(new Watchtower(new Country("Ireland"), 110,140, 200));
        Map.getInstance().addTower(new Watchtower(new Country("Norway"), 290,220, 200));
        Map.getInstance().addTower(new Watchtower(new Country("Sweden"), 350,140, 200));
        Map.getInstance().addTower(new Watchtower(new Country("Germany"), 270,380, 200));
        Map.getInstance().addTower(new Watchtower(new Country("Poland"), 400,330, 200));
        Map.getInstance().addTower(new Watchtower(new Country("Belarus"), 520,260, 200));
        Map.getInstance().addTower(new Watchtower(new Country("Lithuania"), 550,190, 200));
        Map.getInstance().addTower(new Watchtower(new Country("Ukraine"), 500,350, 200));
        Map.getInstance().addTower(new Watchtower(new Country("Russia"), 650,150, 200));
        Map.getInstance().addTower(new Watchtower(new Country("Iceland"), 20,20, 200));
        Map.getInstance().addTower(new Watchtower(new Country("Italy"), 300,500, 200));
        Map.getInstance().addTower(new Watchtower(new Country("Turkey"), 650,500, 200));
        Map.getInstance().addTower(new Watchtower(new Country("Syria"), 650,590, 200));
        Map.getInstance().addTower(new Watchtower(new Country("Iraq"), 750,650, 200));
        Map.getInstance().addTower(new Watchtower(new Country("Spain"), 100,540, 200));
        Map.getInstance().addTower(new Watchtower(new Country("Morocco"), 80,640, 200));
        Map.getInstance().addTower(new Watchtower(new Country("Algeria"), 200,670, 200));
        Map.getInstance().addTower(new Watchtower(new Country("Libya"), 340,700, 200));
        Map.getInstance().addTower(new Watchtower(new Country("Egypt"), 450,720, 200));
    }

    private static ControllableAircraft createAircraft () {
        return new CommercialAirliner("F41", 300, 150, 200, "Mohammad", 110, 90, 500, 200);
//        return new FighterJet("F41", 300, 150, 200, "Mohammad",
//                new Weapon[] {
//                        new BomberWeapon(),
//                        new ShootingWeapon()
//                }, 20);
    }

}