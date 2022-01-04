package org.acme.geometry;

public class WktWriter {

  WktWriter(){

  }  

  public String write(Geometry geometry){
        String type = geometry.getType().toUpperCase();
        if(geometry.isEmpty()){
            return type+" EMPTY";
        }
        if ( geometry instanceof Point ){
            Point point = (Point)geometry;
            return type+"("+point.getCoordinate().getX()+" "+point.getCoordinate().getY()+")";
        }else if ( geometry instanceof LineString ){
            LineString lineString = (LineString)geometry;
            String result = type+"(";
            for(int i=0 ; i< lineString.getNumPoints() ; i++){
                result += lineString.getPointN(i).getCoordinate().getX()+" "+lineString.getPointN(i).getCoordinate().getY();
                if(i==lineString.getNumPoints()-1){
                    break;
                }else{
                    result += ",";
                }
            }
            result += ")";
            return result;
        }else{
            throw new RuntimeException("geometry type not supported");
        }
  }
}
