package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BikePhotoTest {
    @Test
    public void testConstructorSimpleAndBikeType() {
        BikePhoto bp = new BikePhoto();
        assertEquals(BikeType.UNKNOWN, bp.getBikeType());
    }

	@Test
    public void testConstructorWithPhotoId() {
    	PhotoId pId = PhotoId.NULL_ID;
        BikePhoto bp = new BikePhoto(pId);
        assertNotNull(bp);
    }

	@Test
    public void testConstructorWithPhotoIdAndBikeType() {
    	PhotoId pId = PhotoId.NULL_ID;
        BikePhoto bp = new BikePhoto(pId, BikeType.CITYBIKE);
        assertNotNull(bp);
        assertEquals(BikeType.CITYBIKE, bp.getBikeType());
    }

    @Test
    public void testConstructorAndBikeTypeWithAllBikeTypes() {
        for(BikeType bt : BikeType.values()){
            BikePhoto bp = new BikePhoto(bt);
            assertEquals(bt, bp.getBikeType());
        }
    }

    @Test
    public void testSetGetBikeType() {
        BikePhoto bp_no_bt = new BikePhoto();
        assertEquals(BikeType.UNKNOWN, bp_no_bt.getBikeType());
        bp_no_bt.setBikeType(BikeType.CITYBIKE);
        assertEquals(BikeType.CITYBIKE, bp_no_bt.getBikeType());

        BikePhoto bp_w_bt = new BikePhoto(BikeType.CITYBIKE);
        assertEquals(BikeType.CITYBIKE, bp_w_bt.getBikeType());
        bp_w_bt.setBikeType(BikeType.RACINGBIKE);
        assertEquals(BikeType.RACINGBIKE, bp_w_bt.getBikeType());
    }

}
