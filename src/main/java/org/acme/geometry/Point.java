package org.acme.geometry;

public class Point implements Geometry {

    private Coordinate coordinate;

    Point(){
        this.coordinate = new Coordinate();
    }

    Point(Coordinate coordinate){
        if(coordinate == null){
            this.coordinate = new Coordinate();
        }else{
            this.coordinate = coordinate;
        } 
    }

    public Coordinate getCoordinate(){
        return coordinate;
    }

    public String getType(){
        return "Point";
    }

    public Boolean isEmpty(){
        return coordinate.isEmpty();
    }
    
}
