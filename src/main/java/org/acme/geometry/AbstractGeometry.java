package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry {

    private List<GeometryListener> listeners;

    AbstractGeometry(){
        this.listeners = new ArrayList<GeometryListener>();
    }

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
    public void addListener(GeometryListener listener){
        listeners.add(listener);
    }

    protected void triggerChange(){
        for (GeometryListener geometryListener : listeners) {
            geometryListener.onChange(this);
        }
    }

    @Override
    public abstract AbstractGeometry clone();
}
