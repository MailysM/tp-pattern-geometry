package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {

    public String asText(){
        WktVisitor visitor = new WktVisitor();
        this.accept(visitor);
        return visitor.getResult();   
    }

    public Envelope getEnvelope(){
        EnvelopeBuilder envBuild = new EnvelopeBuilder();
        this.accept(envBuild);
        return envBuild.build();
    }

    @Override
    public AbstractGeometry clone(){
        return this.clone();
    }
}
