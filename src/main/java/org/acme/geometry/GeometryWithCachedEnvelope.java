package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry {

    private Geometry original;
    private Envelope cachedEnvelope;

    GeometryWithCachedEnvelope(Geometry original){
        this.original = original;
    }

    @Override
    public String getType() {
        return original.getType();
    }

    @Override
    public Boolean isEmpty() {
        return original.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {
        original.translate(dx, dy);
    }

    @Override
    public GeometryWithCachedEnvelope clone() {
        return new GeometryWithCachedEnvelope(original.clone());
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        original.accept(visitor); 
    }

    @Override
    public Envelope getEnvelope() {
        if(this.cachedEnvelope==null){
            this.cachedEnvelope = original.getEnvelope();
        }
        return cachedEnvelope;
        
    }
    
}
