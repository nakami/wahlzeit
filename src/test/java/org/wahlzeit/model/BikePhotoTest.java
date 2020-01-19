package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BikePhotoTest {
	@Test
    public void testConstructorWithPhotoId() {
    	PhotoId pId = PhotoId.NULL_ID;
        BikePhoto bp = new BikePhoto(pId);
        assertNotNull(bp);
    }
}
