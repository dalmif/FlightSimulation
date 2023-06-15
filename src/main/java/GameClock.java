import Entity.Aircraft.ControllableAircraft;
import Entity.Map;
import Gui.Gui;

public class GameClock extends Thread {

    public static boolean running = true;
    private final ControllableAircraft aircraft;
    private final Gui gui;
    public GameClock(Gui gui) {
        this.aircraft = Map.getInstance().getMyAircraft();
        this.gui = gui;
    }

    public void run(){
        while(running){
            gui.refresh();
            try {
                sleep(60);
                aircraft.move();
                aircraft.useFuel();
                aircraft.setWaitToMove(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}