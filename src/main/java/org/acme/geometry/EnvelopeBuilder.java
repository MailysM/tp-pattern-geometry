package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class EnvelopeBuilder implements GeometryVisitor {

    private List<Double> coordX;
    private List<Double> coordY;

    EnvelopeBuilder(){
        this.coordX = new ArrayList<Double>();
        this.coordY = new ArrayList<Double>();
    }
    
    public List<Double> getCoordX(){
        return coordX;
    }

    public List<Double> getCoordY(){
        return coordY;
    }


    public void insert(Coordinate coord){
        if(!coord.isEmpty()){
            coordX.add(coord.getX());
            coordY.add(coord.getY());
        }
    }

    public Envelope build(){
        if(coordX.size()==0){
            return new Envelope();
        }
        Coordinate bottomLeft = new Coordinate(Collections.min(coordX), Collections.min(coordY));
        Coordinate topRight = new Coordinate(Collections.max(coordX), Collections.max(coordY));
        return new Envelope(bottomLeft,topRight);
    }

    @Override
    public void visit(Point point) {
        this.insert(point.getCoordinate());
        
    }

    @Override
    public void visit(LineString lineString) {
        for (int i=0; i<lineString.getNumPoints(); i++) {
            this.insert(lineString.getPointN(i).getCoordinate());
        }
    }
    
    
}
