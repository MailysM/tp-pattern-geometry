package org.acme.geometry;

public class Envelope {
    private Coordinate bottomLeft;
    private Coordinate topRight;

    Envelope(){
        this.bottomLeft = new Coordinate();
        this.topRight = new Coordinate();
    }
    Envelope(Coordinate bottomLeft, Coordinate topRight){
        if(bottomLeft == null){
            this.bottomLeft = new Coordinate();
        }else{
            this.bottomLeft = bottomLeft;
        }
        if(topRight == null){
            this.topRight = new Coordinate();
        }
        else{
            this.topRight = topRight;
        }
        
    }

    public Boolean isEmpty(){
        if(bottomLeft.isEmpty() || topRight.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public double getXMin(){
        return bottomLeft.getX();
    }

    public double getYMin(){
        return bottomLeft.getY();
    }

    public double getXMax(){
        return topRight.getX();
    }

    public double getYMax(){
        return topRight.getY();
    }
}
