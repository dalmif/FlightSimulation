package Utility;

public enum Dir {
    UP, LEFT, RIGHT, DOWN, NONE;

    @Override
    public String toString() {
        switch (this) {
            case UP:
                return "up";
            case LEFT:
                return "left";
            case RIGHT:
                return "right";
            case DOWN:
                return "down";
            case NONE:
                return "none";
        }
        return "none";
    }
}
