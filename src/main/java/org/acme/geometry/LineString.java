package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString extends AbstractGeometry{
    
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

    @Override
    public void translate(double dx, double dy){
        for (Point point : points) {
            point.translate(dx, dy);
        }
    }

    @Override
    public LineString clone(){
        List<Point> pointsClone = new ArrayList<Point>();
        for (Point point : points) {
            pointsClone.add(point.clone());
        }
        return new LineString(pointsClone);
    }
    
    @Override
    public Envelope getEnvelope(){
        EnvelopeBuilder envBuild = new EnvelopeBuilder();
        envBuild.visit(this);
        return envBuild.build();
    }

    @Override
    public void accept(GeometryVisitor visitor){
        visitor.visit(this);
    }

    @Override
    public String asText() {
        WktVisitor visitor = new WktVisitor();
        visitor.visit(this);
        return visitor.getResult();   
    }
}
