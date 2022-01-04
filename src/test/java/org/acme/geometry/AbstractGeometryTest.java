package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AbstractGeometryTest {

    public static final double EPSILON = 1.0e-15;
    public static final Coordinate c1 = new Coordinate(1.0,2.0);
    public static final Coordinate c2 = new Coordinate(3.0,6.0);
    public static final Coordinate c3 = new Coordinate(0.5,10.0);


	public List<Point> points = new ArrayList<Point>();

    @Test
	public void testWriterPoint(){
		Point p = new Point(c1);
        Assert.assertEquals("POINT(1.0 2.0)", p.asText());
	}

    @Test
	public void testWriterPointEmpty(){
		Point p = new Point();
        Assert.assertEquals("POINT EMPTY",p.asText());
	}

    @Test
	public void testWriterLineString(){
        Point p1 = new Point(c1);
	    Point p2 = new Point(c2);
        Point p3 = new Point(c3);
		points.add(p1);
		points.add(p2);
        points.add(p3);
		LineString line = new LineString(points);
        Assert.assertEquals("LINESTRING(1.0 2.0,3.0 6.0,0.5 10.0)", line.asText());
    }

    @Test
	public void testWriterLineStringEmpty(){
		LineString line = new LineString();
        Assert.assertEquals("LINESTRING EMPTY", line.asText());
	}



}
