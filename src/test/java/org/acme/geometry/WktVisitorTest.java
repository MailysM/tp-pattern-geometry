package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WktVisitorTest {
    
    public static final double EPSILON = 1.0e-15;
    public static final Coordinate c1 = new Coordinate(1.0,2.0);
    public static final Coordinate c2 = new Coordinate(3.0,6.0);
    public static final Coordinate c3 = new Coordinate(0.5,10.0);

	public List<Point> points = new ArrayList<Point>();

    @Test
	public void testWriterPoint(){
		WktVisitor visitor = new WktVisitor();
        Geometry geometry = new Point(c1);
        geometry.accept(visitor);
        Assert.assertEquals("POINT(1.0 2.0)",visitor.getResult());
	}

    @Test
	public void testWriterPointEmpty(){
		WktVisitor visitor = new WktVisitor();
        Geometry geometry = new Point();
        geometry.accept(visitor);
        Assert.assertEquals("POINT EMPTY", visitor.getResult());
	}

    @Test
	public void testWriterLineString(){
        Point p1 = new Point(c1);
	    Point p2 = new Point(c2);
        Point p3 = new Point(c3);
		points.add(p1);
		points.add(p2);
        points.add(p3);
		WktVisitor visitor = new WktVisitor();
        Geometry geometry = new LineString(points);
        geometry.accept(visitor);
        Assert.assertEquals("LINESTRING(1.0 2.0,3.0 6.0,0.5 10.0)", visitor.getResult());
    }

    @Test
	public void testWriterLineStringEmpty(){
		WktVisitor visitor = new WktVisitor();
        Geometry geometry = new LineString();
        geometry.accept(visitor);
        Assert.assertEquals("LINESTRING EMPTY", visitor.getResult());
	}
}
