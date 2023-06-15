package Entity;

import Entity.Unit.CPoint;
import Entity.Unit.Size;
import Gui.Gui;

public final class Country implements Drawable {
    private final String name;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getImagePath() {
        return "/flags/"+name.toLowerCase() + "_640.png";
    }

    @Override
    public CPoint getPoint() {
        return new CPoint( 0,Gui.gameDisplayHeight - getSize().height - 40);
    }

    @Override
    public Size getSize() {
        return new Size(150,100);
    }
}
