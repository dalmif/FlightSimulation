package Entity.Unit;

import java.util.Objects;

public final class CPoint {
    public int x,y;

    public CPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public CPoint getCenterOf (Size size) {
        return new CPoint(x + size.width/2, y + size.height/2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPoint cPoint = (CPoint) o;
        return x == cPoint.x && y == cPoint.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
