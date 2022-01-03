package org.acme.geometry;

public class Coordinate {
    private double x;
    private double y;

    Coordinate(){

    }

    Coordinate(double x, double y){
        this.x = x;
        this.y = y;
    }

    double getX(){
        return x;
    }

    double getY(){
        return y;
    }
}
