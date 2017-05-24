package by.grsu.dataModul;

/*
 * Created by Andrei on 14.03.2017.
 */
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class Area {
    public List<Point2D.Double> points;

    public Area(){
        points = new ArrayList<>();
    }

    public void addPoint(Point2D.Double point){
        points.add(point);
    }

    public String toString(){
        String string = "[";
        for (Point2D.Double point : points){
            string += "[" + point.x + ", " + point.y + "]";
            if(point != points.get(points.size() - 1))
                string += ", ";
            else string += "]";
        }
        return string;
    }
}
