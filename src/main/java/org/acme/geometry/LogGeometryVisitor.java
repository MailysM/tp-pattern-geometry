package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor {

    PrintStream printStream;

    LogGeometryVisitor(PrintStream printStream){
        if(printStream==null){
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            this.printStream = new PrintStream(os);
        }else{
            this.printStream = printStream;
        }
        
    }


    @Override
    public void visit(Point point){
        String log = "Je suis un point avec x="+point.getCoordinate().getX()+" et y="+point.getCoordinate().getY();
        printStream.println(log);
    }

    @Override
    public void visit(LineString lineString){
        String log = "Je suis une polyligne définie par "+lineString.getNumPoints()+" point(s)";
        printStream.println(log);
    }
    
}
