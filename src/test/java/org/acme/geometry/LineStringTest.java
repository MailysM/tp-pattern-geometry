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
	public static final Coordinate c3 = new Coordinate(0.5,10.0);

	public List<Point> points = new ArrayList<Point>();


	@Test
	public void testDefaultConstructor(){
		LineString line = new LineString();
		Assert.assertEquals(0,line.getNumPoints(), EPSILON);
	}

	@Test
	public void testConstructor(){
        Point p1 = new Point(c1);
	    Point p2 = new Point(c2);
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
	public void testConstructorNullValue(){

        LineString line = new LineString(null);
		Assert.assertEquals(0,line.getNumPoints(), EPSILON);
	}

    @Test
	public void testGetType(){
		LineString line = new LineString();
		Assert.assertEquals("LineString",line.getType());

	}

	@Test
	public void testIsEmpty(){
		Point p1 = new Point(c1);
	    Point p2 = new Point(c2);
		points.add(p1);
		points.add(p2);
		LineString line1 = new LineString();
		LineString line2 = new LineString(points);
		Assert.assertTrue(line1.isEmpty());
		Assert.assertFalse(line2.isEmpty());
	}

	@Test
	public void testTranslate(){
		Point p1 = new Point(c1);
	    Point p2 = new Point(c2);
		points.add(p1);
		points.add(p2);
		LineString line = new LineString(points);
		line.translate(1.5, 2.6);
		Assert.assertEquals(2.5, line.getPointN(0).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(7.6, line.getPointN(0).getCoordinate().getY(), EPSILON);
        Assert.assertEquals(4.5, line.getPointN(1).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(8.6, line.getPointN(1).getCoordinate().getY(), EPSILON);
	}

	@Test
	public void testClone(){
		Point p1 = new Point(c1);
	    Point p2 = new Point(c2);
		points.add(p1);
		points.add(p2);
		LineString line = new LineString(points);
		LineString lineClone = line.clone();
		//Test translate only on line and not on lineClone
		line.translate(1.5, 2.6);
        Assert.assertEquals(5.0, lineClone.getPointN(0).getCoordinate().getY(), EPSILON);
        Assert.assertEquals(3.0, lineClone.getPointN(1).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(6.0, lineClone.getPointN(1).getCoordinate().getY(), EPSILON);
	}

	@Test
	public void testGetEnvelope(){
		Point p1 = new Point(c1);
	    Point p2 = new Point(c2);
		Point p3 = new Point(c3);
		points.add(p1);
		points.add(p2);
		points.add(new Point());
		points.add(p3);
		LineString line = new LineString(points);
        Envelope lineEnv = line.getEnvelope();
		Assert.assertEquals(0.5, lineEnv.getXMin(), EPSILON);
		Assert.assertEquals(3.0, lineEnv.getXMax(), EPSILON);
		Assert.assertEquals(5.0, lineEnv.getYMin(), EPSILON);
		Assert.assertEquals(10.0, lineEnv.getYMax(), EPSILON);
			
	}
}
