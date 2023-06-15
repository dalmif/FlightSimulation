package Entity;

import Entity.Unit.CPoint;
import Entity.Unit.Size;

public interface Drawable {
    public String getImagePath();
    //get point on the gameplay size (Map)
    public CPoint getPoint();
    public Size getSize();
}
