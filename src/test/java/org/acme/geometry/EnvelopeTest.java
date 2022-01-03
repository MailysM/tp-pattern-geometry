package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {
    public static final double EPSILON = 1.0e-15;
    public static final Coordinate c1 = new Coordinate(1.0,2.0);
    public static final Coordinate c2 = new Coordinate(3.0,6.0);

    @Test
	public void testDefaultConstructor(){
		Envelope e = new Envelope();
		Assert.assertEquals(Double.NaN, e.getXMax(), EPSILON);
		Assert.assertEquals(Double.NaN, e.getXMin(), EPSILON);
        Assert.assertEquals(Double.NaN, e.getYMin(), EPSILON);
        Assert.assertEquals(Double.NaN, e.getXMax(), EPSILON);
	}
    @Test
	public void testConstructor(){
		Envelope e = new Envelope(c1,c2);
		Assert.assertEquals(3.0, e.getXMax(), EPSILON);
		Assert.assertEquals(1.0, e.getXMin(), EPSILON);
        Assert.assertEquals(2.0, e.getYMin(), EPSILON);
        Assert.assertEquals(6.0, e.getYMax(), EPSILON);
	}
}
