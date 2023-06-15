package Gui;

import Entity.Map;

import javax.swing.*;

public class Gui {
    JFrame jf;
    Draw d;

    public static int informationBoxWidth = 400;
    public static int gameDisplayWidth = 800, gameDisplayHeight = 800;
    public static int width = informationBoxWidth + gameDisplayWidth, height = 800;
    public static int xoff = 0;


    public void createGui(){
        jf = new JFrame("Flight Simulation by Mohammad Fallah");
        jf.setSize(width,height);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.addKeyListener(Map.getInstance().getMyAircraft());

        d = new Draw();
        d.setBounds(0,0,width,height);
        d.setVisible(true);
        jf.add(d);

        jf.requestFocus();
        jf.setVisible(true);
    }

    public void refresh() {
        d.repaint();
    }
}
