package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BikePhotoFactoryTest {
    @Test
    public void testGetStaticFinalInstance() {
        // there should be only a single BikePhotoFactory!
        BikePhotoFactory bpfInstance = BikePhotoFactory.getInstance();
        assertNotNull(bpfInstance);
        BikePhotoFactory bpfInstanceSecond = BikePhotoFactory.getInstance();
        assertEquals(bpfInstance, bpfInstanceSecond);
    }

    @Test(expected = IllegalStateException.class)
    public void testOverrideExistingInstance() {
        // there should be an exception thrown when attempting to replace an instance!
        BikePhotoFactory bpfInstance = BikePhotoFactory.getInstance();
        assertNotNull(bpfInstance);
        BikePhotoFactory.setInstance(new BikePhotoFactory());
    }
}
