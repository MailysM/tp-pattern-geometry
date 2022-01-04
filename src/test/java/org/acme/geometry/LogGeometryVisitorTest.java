package org.acme.geometry;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LogGeometryVisitorTest {

    public static final double EPSILON = 1.0e-15;
    public static final Coordinate c1 = new Coordinate(1.0,5.0);
	public static final Coordinate c2 = new Coordinate(3.0,6.0);
	public static final Coordinate c3 = new Coordinate(0.5,10.0);
    public List<Point> points = new ArrayList<Point>();


  
    @Test
	public void testVisitPoint() throws UnsupportedEncodingException{
		
		Point p = new Point(c1);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);
        p.accept(visitor);
        String result = os.toString("UTF8");
        Assert.assertEquals("Je suis un point avec x=1.0 et y=5.0\n",result);
	}

    @Test
	public void testVisitLineString() throws UnsupportedEncodingException{
		Point p1 = new Point(c1);
	    Point p2 = new Point(c2);
		Point p3 = new Point(c3);
		points.add(p1);
		points.add(p2);
		points.add(p3);
		LineString line = new LineString(points);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);
        line.accept(visitor);
        String result = os.toString("UTF8");

        Assert.assertEquals("Je suis une polyligne définie par 3 point(s)\n", result);
	}
}
