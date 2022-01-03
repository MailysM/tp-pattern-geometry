package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LineStringTest {
    public static final double EPSILON = 1.0e-15;
	//Init Coordinbate and List<Points> for testing
	public static final Coordinate c1 = new Coordinate(1.0,5.0);
	public static final Coordinate c2 = new Coordinate(3.0,6.0);

	public static final Point p1 = new Point(c1);
	public static final Point p2 = new Point(c2);
	public List<Point> points = new ArrayList<Point>();


	@Test
	public void testDefaultConstructor(){
		LineString line = new LineString();
		Assert.assertEquals(0,line.getNumPoints(), EPSILON);
	}

	@Test
	public void testConstructor(){
        
		points.add(p1);
		points.add(p2);
        LineString line = new LineString(points);

		Assert.assertEquals(2,line.getNumPoints(), EPSILON);
		Assert.assertEquals(1.0, line.getPointN(0).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(5.0, line.getPointN(0).getCoordinate().getY(), EPSILON);
        Assert.assertEquals(3.0, line.getPointN(1).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(6.0, line.getPointN(1).getCoordinate().getY(), EPSILON);
	}

    @Test
	public void testGetType(){
		LineString line = new LineString();
		Assert.assertEquals("LineString",line.getType());

	}

	@Test
	public void testIsEmpty(){
		points.add(p1);
		points.add(p2);
		LineString line1 = new LineString();
		LineString line2 = new LineString(points);
		Assert.assertEquals(true,line1.isEmpty());
		Assert.assertEquals(false,line2.isEmpty());
	}
}
