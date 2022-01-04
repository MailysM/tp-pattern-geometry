package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {

    public String asText(){
        WktVisitor visitor = new WktVisitor();
        if(this.getType()=="Point"){
            Point point = (Point)this;
            visitor.visit(point);
            return visitor.getResult();
        }else if(this.getType()=="LineString"){
            LineString line = (LineString)this;
            visitor.visit(line);
            return visitor.getResult();
        }
        else{
            throw new RuntimeException("geometry type not supported");
        }
    }

    @Override
    public AbstractGeometry clone(){
        return this.clone();
    }
}
