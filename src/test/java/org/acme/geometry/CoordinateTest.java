package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){
		Coordinate c = new Coordinate();
		Assert.assertEquals(Double.NaN, c.getX(), EPSILON);
		Assert.assertEquals(Double.NaN,c.getY(), EPSILON);
	}

	@Test
	public void testConstructor(){
		Coordinate c = new Coordinate(1.0,5.0);
		Assert.assertEquals(1.0, c.getX(), EPSILON);
		Assert.assertEquals(5.0, c.getY(), EPSILON);
	}

	@Test
	public void testIsEmpty(){
		Coordinate c1 = new Coordinate();
		Coordinate c2 = new Coordinate(1.0,5.0);
		Coordinate c3 = new Coordinate(Double.NaN, 5.0);
		Coordinate c4 = new Coordinate(4.0,Double.NaN);

		Assert.assertTrue( c1.isEmpty());
		Assert.assertFalse( c2.isEmpty());
		Assert.assertTrue( c3.isEmpty());
		Assert.assertTrue( c4.isEmpty());
	}


}
