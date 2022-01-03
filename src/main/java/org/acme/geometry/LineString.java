package org.acme.geometry;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry{
    
    private List<Point> points;

    LineString(){
        this.points = new ArrayList<Point>();
    }

    LineString(List<Point> points){
        if(points == null){
            this.points = new ArrayList<Point>();
        }else{
            this.points = points;
        }  
    }

    public int getNumPoints(){
        return points.size();
    }

    public Point getPointN(int i){
        return points.get(i);
    }

    @Override
    public String getType(){
        return "LineString";
    }

    @Override
    public Boolean isEmpty(){
        if(getNumPoints()== 0){
            return true;
        }
        return false;
    }
    
}
