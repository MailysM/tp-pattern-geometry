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
    
}
