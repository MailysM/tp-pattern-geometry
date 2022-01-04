package org.acme.geometry;

public class LogGeometryVisitor {

    LogGeometryVisitor(){}

    public void visit(Point point){
        String log = "Je suis un point avec x="+point.getCoordinate().getX()+" et y="+point.getCoordinate().getY();
        System.out.println(log);
    }

    public void visit(LineString lineString){
        String log = "Je suis une polyligne définie par "+lineString.getNumPoints()+" point(s)";
        System.out.println(log);
    }
    
}
