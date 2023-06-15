package Entity.Aircraft;

import Entity.Unit.CPoint;
import Entity.Drawable;
import Entity.Unit.Size;
import Entity.Watchtower;
import Gui.Gui;
import Utility.Coordination;
import Utility.Dir;
import Utility.Navigator;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public abstract class ControllableAircraft extends Aircraft implements Controllable, Connectable, Drawable, KeyListener {

    private int x = 0;
    private int y = 0;
    private Coordination coordination; //latitude and longitude on map
    private String capitan;
    private float remainFuel = 0;
    private int speed = 1;
    private Dir dir = Dir.RIGHT;
    private Dir lastDir = Dir.RIGHT;
    private boolean waitToMove = false;
    private Watchtower watchtower;
    private final Navigator navigation;

    public ControllableAircraft(String model, int maximumSpeed, int minimumSpeed, int fuelCapacity, String capitan) {
        super(model, maximumSpeed, minimumSpeed, fuelCapacity);
        this.capitan = capitan;
        setRemainFuel(fuelCapacity);
        coordination = new Coordination();
        navigation = new Navigator(this);
    }

    @Override
    public void move() {
        switch (getDir()) {
            case RIGHT:
                setX(getX() + getSpeed());
                break;
            case UP:
                setY(getY() - getSpeed());
                break;
            case LEFT:
                setX(getX() - getSpeed());
                break;
            case DOWN:
                setY(getY() + getSpeed());
                break;
            case NONE:
                break;
        }
        coordination.update(getX(),getY());
        Watchtower nearestTower = navigation.nearestTower();
        if (nearestTower != getWatchtower()) {
            try {
                nearestTower.connectionRequest(this);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getDemonstrationSpeed () {
        return DEMONSTRATION_SPEED + getSpeed() * 10;
    }
    public float getRemainingFuel() {
        return remainFuel;
    }

    @Override
    public ArrayList<String> getInformation() {
        ArrayList<String> info = super.getInformation();
        info.add("Capitan: " + getCapitan());
        info.add("Speed: " + getDemonstrationSpeed() + " mph");
        info.add("Fuel: " + (int) getRemainFuel() +"/" +getFuelCapacity());
        info.add("Coordinates: " + getCoordination());
        info.add("ACT: " + getWatchtower().getCountry().getName());
        return info;
    }

    public void resetFuel() {
        setRemainFuel(getFuelCapacity());
    }

    protected void setRemainFuel(float fuel) {
        this.remainFuel = fuel;
    }


    public double getRemainFuel() {
        return remainFuel;
    }

    public Coordination getCoordination() {
        return coordination;
    }

    public void setCoordination(Coordination coordination) {
        this.coordination = coordination;
    }

    public String getCapitan() {
        return capitan;
    }

    public void setCapitan(String capitan) {
        this.capitan = capitan;
    }

    public int getSpeed() {
        return remainFuel > 0 ? speed : 0;
    }

    public void setSpeed(int speed) {
        if (speed <= getMaximumSpeed() && speed >= getMinimumSpeed()) {
            this.speed = speed;
        }
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public Dir getLastDir() {
        return lastDir;
    }

    public void setLastDir(Dir lastDir) {
        this.lastDir = lastDir;
    }

    public void speedUp () {
        setSpeed(getSpeed() + 1);
    }

    public void speedDown () {
        setSpeed(getSpeed() - 1);
    }

    @Override
    public void connect(Watchtower watchtower) {
        if (this.watchtower != null && watchtower != this.watchtower) {
            this.watchtower.disconnect(this);
        }
        setWatchtower(watchtower);
    }

    public CPoint getPoint() {
        return new CPoint(getX() % Gui.gameDisplayWidth, getY() % Gui.gameDisplayWidth);
    }
    public Size getSize() {
        return new Size(120,120);
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

    public boolean isWaitToMove() {
        return waitToMove;
    }

    public void setWaitToMove(boolean waitToMove) {
        this.waitToMove = waitToMove;
    }

    public Watchtower getWatchtower() {
        return watchtower;
    }

    public boolean isInRatioTower() {
        if (watchtower == null) return false;
        return watchtower.getRatio() >= navigation.findDistance(watchtower);
    }

    public void setWatchtower(Watchtower watchtower) {
        this.watchtower = watchtower;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_R:
                if (getRemainFuel() < 10) {
                    resetFuel();
                }
                break;
            case KeyEvent.VK_UP:
                speedUp();
                break;
            case KeyEvent.VK_DOWN:
                speedDown();
                break;
            case KeyEvent.VK_W:
                if (!isWaitToMove()) {
                    setDir(Dir.UP);
                    setWaitToMove(true);
                }
                break;
            case KeyEvent.VK_SPACE:
                if (!isWaitToMove() && getDir() != Dir.NONE) {
                    setLastDir(getDir());
                    setDir(Dir.NONE);
                    setWaitToMove(true);
                }
                break;
            case KeyEvent.VK_A:
                if (!isWaitToMove()) {
                    setDir(Dir.LEFT);
                    setWaitToMove(true);
                }
                break;
            case KeyEvent.VK_S:
                if (!isWaitToMove()) {
                    setDir(Dir.DOWN);
                    setWaitToMove(true);
                }
                break;
            case KeyEvent.VK_D:
                if (!isWaitToMove()) {
                    setDir(Dir.RIGHT);
                    setWaitToMove(true);
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !isWaitToMove()) {
            setDir(getLastDir());
            setWaitToMove(true);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
}
