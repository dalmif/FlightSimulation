package Gui;

import Entity.Aircraft.ControllableAircraft;
import Entity.Unit.CPoint;
import Entity.Drawable;
import Entity.Map;
import Entity.Watchtower;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Draw extends JLabel {

    Map map;
	Point p;
    Graphics g;

    public Draw () {
        this.map = Map.getInstance();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g = g;
        ControllableAircraft myAircraft = Map.getInstance().getMyAircraft();
        Graphics2D g2d = (Graphics2D) g;

        // draw white background
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, Gui.width, Gui.height);


        //Draw Europe maps as background
        draw(Map.getInstance());

        //draw towers
        ArrayList<Watchtower> towers = map.getWatchtowers();
        for (Drawable drawable : towers) {
            draw(drawable);
        }
        if (myAircraft.isInRatioTower()) {
            CPoint aircraftPosition = myAircraft.getPoint().getCenterOf(myAircraft.getSize());
            CPoint towerPosition = myAircraft.getWatchtower().getPoint().getCenterOf(myAircraft.getWatchtower().getSize());
            g.setColor(Color.white);
            g2d.setStroke(new BasicStroke(3f));
            g.drawLine(towerPosition.x, towerPosition.y, aircraftPosition.x,aircraftPosition.y);
            draw(myAircraft.getWatchtower().getCountry());
        }
        //draw aircraft
        draw(myAircraft);

        // Draw information
        drawInfobox();

        //draw notification
        if (map.getMyAircraft().getRemainFuel() < 4)
            draw("your fuel has been ended (press R to refill)");
    }

    private void drawInfobox() {

        int xPadding = 35;
        int yPadding = 40;
        int xPosition = Gui.xoff + Gui.gameDisplayWidth;

        //background
        g.setColor(new Color(255, 255, 255));
        g.fillRect(xPosition, 0, Gui.informationBoxWidth, Gui.height);

        // draw title
        g.setFont(new Font("Roboto", Font.BOLD, 28));
        g.setColor(Color.BLACK);
        g.drawString("Flight Simulation", xPosition+xPadding,yPadding+= 15);

        //draw subtitle
        g.setFont(new Font("Roboto", Font.PLAIN, 16));
        g.setColor(new Color(175,175,175));
        g.drawString("developed by mohammad fallah", xPosition+xPadding,yPadding += 25);

        // draw text title of information
        g.setFont(new Font("Roboto", Font.BOLD, 20));
        g.setColor(Color.BLACK);
        g.drawString("information", xPosition+ xPadding,yPadding += 70);

        //draw details
        ArrayList<String> details = map.getMyAircraft().getInformation();
        g.setFont(new Font("Roboto", Font.PLAIN, 18));
        for (int i = 0; i < details.size(); i++) {
            g.setColor(i %2 == 1 ? new Color(247, 247, 247) : Color.white);
            g.fillRect(xPosition, yPadding += 25, Gui.informationBoxWidth, 60);
            g.setColor(new Color(48, 48, 48));
            g.drawString(details.get(i), xPosition + xPadding, yPadding += 37);
        }
    }

    private void draw(String text) {
        int yMargin = 30;
        int xMargin = 30;
        int hPadding = 20;
        int vPadding = 10;
        int neededWidth = (int) (text.length() * 8.3);
        int xBox = Gui.gameDisplayWidth - xMargin - neededWidth - 2 * hPadding;
        int yBox = Gui.gameDisplayHeight - yMargin - 50 - 2 * vPadding;
        int widthBox = neededWidth + 2 * hPadding;
        int heightBox = 30 + 2 * vPadding;
        g.setColor(new Color(0, 0, 0, 159));
        g.fillRoundRect(xBox, yBox, widthBox, heightBox, 30 , 30);
        g.setFont(new Font("Roboto", Font.PLAIN, 19));
        g.setColor(new Color(255, 255, 255));
        g.drawString(text,xBox + hPadding , yBox + vPadding + 20);
    }

    private void draw(Drawable drawable) {
        g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(drawable.getImagePath())),drawable.getPoint().x,drawable.getPoint().y, drawable.getSize().width,drawable.getSize().height,null);
    }

}
