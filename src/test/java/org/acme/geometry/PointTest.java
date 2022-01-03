package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    public static final double EPSILON = 1.0e-15;

	//Init Coordinate

	public static final Coordinate c = new Coordinate(1.0,5.0);

	@Test
	public void testDefaultConstructor(){
		Point p = new Point();
		Assert.assertEquals(Double.NaN, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(Double.NaN, p.getCoordinate().getY(), EPSILON);
	}

	@Test
	public void testConstructor(){
		Point p = new Point(c);
		Assert.assertEquals(1.0, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(5.0, p.getCoordinate().getY(), EPSILON);
	}

    @Test
	public void testGetType(){
		Point p = new Point();
		Assert.assertEquals("Point",p.getType());

	}

	@Test
	public void testIsEmpty(){
		Point p1 = new Point();
		Point p2 = new Point(c);
		Assert.assertEquals(true,p1.isEmpty());
		Assert.assertEquals(false,p2.isEmpty());

	}

	@Test
	public void testTranslate(){
		Point p = new Point(c);
		p.translate(2.1, 1.5);
		Assert.assertEquals(3.1, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(6.5, p.getCoordinate().getY(), EPSILON);

	}

	@Test
	public void testClone(){
		Point p = new Point(c);
		Point pClone = p.clone();
		p.translate(2.1, 1.5);
		Assert.assertEquals(1.0, pClone.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(5.0, pClone.getCoordinate().getY(), EPSILON);

	}
}
