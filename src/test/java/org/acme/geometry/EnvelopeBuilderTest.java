package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class EnvelopeBuilderTest {
    public static final double EPSILON = 1.0e-15;
    public static final Coordinate c1 = new Coordinate(1.0,2.0);
    public static final Coordinate c2 = new Coordinate(3.0,6.0);
    public static final Coordinate c3 = new Coordinate(0.5,10.0);


    @Test
	public void testDefaultConstructor(){
		EnvelopeBuilder eb = new EnvelopeBuilder();
        List<Coordinate> nullList = new ArrayList<Coordinate>();
        Assert.assertEquals(nullList, eb.getCoordX());
        Assert.assertEquals(nullList, eb.getCoordY());
		
	}


    @Test
	public void testInsert(){
		EnvelopeBuilder eb = new EnvelopeBuilder();
        eb.insert(c1);
        eb.insert(c2);
        Assert.assertEquals(1.0, eb.getCoordX().get(0),EPSILON);
        Assert.assertEquals(6.0, eb.getCoordY().get(1),EPSILON);
		
	}
    @Test
	public void testInsertNull(){
		EnvelopeBuilder eb = new EnvelopeBuilder();
        eb.insert(c1);
        eb.insert(c2);
        eb.insert(new Coordinate());
        Assert.assertEquals(3.0, Collections.max(eb.getCoordX()),EPSILON);
        Assert.assertEquals(6.0, Collections.max(eb.getCoordY()),EPSILON);
		
	}

    @Test
	public void testBuilder(){
		EnvelopeBuilder eb = new EnvelopeBuilder();
        eb.insert(c1);
        eb.insert(c2);
        eb.insert(c3);
        Envelope env =  eb.build();
        Assert.assertEquals(0.5,env.getXMin(),EPSILON);
        Assert.assertEquals(2.0,env.getYMin(),EPSILON);
        Assert.assertEquals(3.0,env.getXMax(),EPSILON);
        Assert.assertEquals(10.0,env.getYMax(),EPSILON);

		
	}
}
