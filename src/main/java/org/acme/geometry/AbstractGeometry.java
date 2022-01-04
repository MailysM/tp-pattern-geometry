package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {

    abstract public String asText();

    abstract public Envelope getEnvelope();

    @Override
    public AbstractGeometry clone(){
        return this.clone();
    }
}
