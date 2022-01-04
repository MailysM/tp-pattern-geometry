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
	@Test
	public void testConstructorNullValue(){
		Envelope e1 = new Envelope(c1,null);
		Envelope e2 = new Envelope(null,c2);
		Envelope e3 = new Envelope(null,null);
		Assert.assertEquals(1.0, e1.getXMin(), EPSILON);
		Assert.assertEquals(Double.NaN, e1.getYMax(), EPSILON);
		Assert.assertEquals(3.0, e2.getXMax(), EPSILON);
		Assert.assertEquals(Double.NaN, e2.getYMin(), EPSILON);
        Assert.assertEquals(Double.NaN, e3.getYMax(), EPSILON);
        Assert.assertEquals(Double.NaN, e3.getYMin(), EPSILON);
	}

	@Test
	public void testIsEmpty(){
		Envelope e1 = new Envelope(c1,c2);
		Envelope e2 = new Envelope(c1,null);
		Envelope e3 = new Envelope(null,c2);
		Envelope e4 = new Envelope(null,null);
		Assert.assertEquals(false, e1.isEmpty());
		Assert.assertEquals(true, e2.isEmpty());
		Assert.assertEquals(true, e3.isEmpty());
		Assert.assertEquals(true, e4.isEmpty());
		
	}
}
