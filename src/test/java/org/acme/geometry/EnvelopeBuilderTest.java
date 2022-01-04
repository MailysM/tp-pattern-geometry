package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class EnvelopeBuilderTest {
    public static final double EPSILON = 1.0e-15;
    public static final Coordinate c1 = new Coordinate(1.0,2.0);
    public static final Coordinate c2 = new Coordinate(3.0,6.0);


    @Test
	public void testDefaultConstructor(){
		EnvelopeBuilder eb = new EnvelopeBuilder();
        List<Coordinate> nullList = new ArrayList<Coordinate>();
        Assert.assertEquals(nullList, eb.coodinates);
		
	}

    @Test
	public void testInsert(){
		EnvelopeBuilder eb = new EnvelopeBuilder();
        eb.insert(c1);
        eb.insert(c2);
        Assert.assertEquals(1.0, eb.getCoordinates().get(0).getX(),EPSILON);
        Assert.assertEquals(6.0, eb.getCoordinates().get(1).gety(),EPSILON);
		
	}

    @Test
	public void testBuilder(){
		EnvelopeBuilder eb = new EnvelopeBuilder();
        Envelope env =  eb.build();
        Assert.assertEquals(1.0,env.getXMin(),EPSILON);
        Assert.assertEquals(2.0,env.getYMin(),EPSILON);
        Assert.assertEquals(3.0,env.getXMax(),EPSILON);
        Assert.assertEquals(6.0,env.getYMax(),EPSILON);

		
	}
}
