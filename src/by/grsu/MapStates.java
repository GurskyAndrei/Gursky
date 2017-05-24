package by.grsu;

import by.grsu.dataModul.State;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;


public class MapStates extends JFrame{

    private static final String title = "States";
    private static final boolean visible = true;
    private static final int width = 1700;
    private static final int height = 720;
    private List<State> states;

    public MapStates(List<State> states){
        super(title);
        this.setSize(width,height);
        this.setVisible(visible);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.states = states;
    }

    public void paint(Graphics g){
        Random rand = new Random();
        for (State state : states){
            for (Polygon polygon : state.polygons){
                g.setColor(new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
                g.fillPolygon(polygon);
            }
            for (Polygon polygon : state.polygons){
                g.setColor(Color.black);
                g.drawPolygon(polygon);
            }
        }
    }
}
