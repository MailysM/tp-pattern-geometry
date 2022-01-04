package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class GeometryWithCachedEnvelopeTest {

    public static final double EPSILON = 1.0e-15;
    public static final Coordinate c1 = new Coordinate(1.0,2.0);
    public static final Coordinate c2 = new Coordinate(3.0,6.0);
    public static final Coordinate c3 = new Coordinate(0.5,10.0);


	public List<Point> points = new ArrayList<Point>();

    @Test
    public void testGeometryWithCachedEnvelope(){
        Geometry g = new Point(new Coordinate(3.0,3.0));
        // décoration
        g = new GeometryWithCachedEnvelope(g);
        Envelope a = g.getEnvelope() ; // calcul et stockage dans cachedEnvelope
        Envelope b = g.getEnvelope() ; // renvoi de cachedEnvelope
        Assert.assertSame(a,b);
    }

    @Test
    public void testOnChange(){
        Geometry g = new Point(new Coordinate(3.0,3.0));
        GeometryWithCachedEnvelope listener = new GeometryWithCachedEnvelope(g);
        g.addListener(listener);
        Envelope a = listener.getEnvelope() ; // calcul et stockage dans cachedEnvelope
        g.translate(2.0, 5.0);
        Envelope b = listener.getEnvelope();
        Assert.assertEquals(g.getEnvelope().getXMax(),b.getXMax(),EPSILON);
        Assert.assertEquals(g.getEnvelope().getXMin(),b.getXMin(),EPSILON);
        Assert.assertEquals(g.getEnvelope().getYMax(),b.getYMax(),EPSILON);
        Assert.assertEquals(g.getEnvelope().getYMin(),b.getYMin(),EPSILON);
    }
    
}
