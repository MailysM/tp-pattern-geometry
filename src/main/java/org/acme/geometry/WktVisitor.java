package org.acme.geometry;

public class WktVisitor implements GeometryVisitor {

    StringBuilder buffer;

    WktVisitor(){
        this.buffer = new StringBuilder();
    }

    public String getResult(){
        return this.buffer.toString();
    }

    @Override
    public void visit(Point point) {
        if(point.isEmpty()){
            this.buffer.append("POINT EMPTY");
        }else{
            this.buffer.append("POINT("+point.getCoordinate().getX()+" "+point.getCoordinate().getY()+")");
        } 
    }

    @Override
    public void visit(LineString lineString) {
        if(lineString.isEmpty()){
            this.buffer.append("LINESTRING EMPTY");
        }else{
            String result = "LINESTRING(";
            for(int i=0 ; i< lineString.getNumPoints() ; i++){
                result += lineString.getPointN(i).getCoordinate().getX()+" "+lineString.getPointN(i).getCoordinate().getY();
                if(i==lineString.getNumPoints()-1){
                    break;
                }else{
                    result += ",";
                }
            }
            result += ")";
            this.buffer.append(result);
        }
    }
    
}
