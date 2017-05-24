package by.grsu.dataModul;
/**
 * Created by Andrei on 14.03.2017.
 * Essence for states
 */
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class State {

    public String nameState;

    public List<Area> areas;
    /** Polygons for state */
    public List<Polygon> polygons;

    public State(String nameState)
    {
        this.nameState = nameState;
        areas = new ArrayList<>();
        polygons = new ArrayList<>();
    }

    public String toString(){
        return "\"" + nameState + "\" : " + areasToString();
    }
    public String areasToString(){
        String string = "[";
        for(Area area : areas){
            string += area.toString();
            if(area != areas.get(areas.size() - 1))
                string += ", ";
            else
                string += "]";
        }
        return string;
    }
}
