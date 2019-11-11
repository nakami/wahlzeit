package org.wahlzeit.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.testEnvironmentProvider.RegisteredOfyEnvironmentProvider;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.io.IOException;


public class BikePhotoManagerTest {
    // necessary Rule to simulatie datastore and environment...
    @Rule
	public TestRule chain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider())
			                        .around(new RegisteredOfyEnvironmentProvider());

    @Test
    public void testGetStaticFinalInstance() {
        // there should be only a single BikePhotoManager!
        BikePhotoManager bpmInstance = BikePhotoManager.getInstance();
        assertNotNull(bpmInstance);
        BikePhotoManager bpmInstanceSecond = BikePhotoManager.getInstance();
        assertEquals(bpmInstance, bpmInstanceSecond);
    }

    @Test
    public void testEmptyBikePhotoManager() {
        BikePhotoManager bpmInstance = BikePhotoManager.getInstance();
        BikePhoto bikePhoto = new BikePhoto();
        bpmInstance.hasPhoto(bikePhoto.getId());
        assertFalse(bpmInstance.hasPhoto(bikePhoto.getId()));
    }

    @Test
    public void testCreatePhotoWithManagerAndFactory() throws IOException {
        // create a photo through BikePhotoFactory
        BikePhotoFactory bpfInstance = BikePhotoFactory.getInstance();
        BikePhoto newPhotoZero = bpfInstance.createPhoto();
        assertNotNull(newPhotoZero);
        PhotoId newPhotoZeroId = newPhotoZero.getId();
        assertNotNull(newPhotoZeroId);
        
        // add the photo to BikePhotoManager
        BikePhotoManager bpmInstance = BikePhotoManager.getInstance();
        assertNotNull(bpmInstance);
        bpmInstance.addPhoto(newPhotoZero);

        // retrieve the first photo by its PhotoId
        BikePhoto loadedPhotoZero = bpmInstance.getPhotoFromId(newPhotoZeroId);
        // the photos and their PhotoIds should be equal
        assertEquals(newPhotoZero, loadedPhotoZero);
        assertEquals(newPhotoZero.getId(), loadedPhotoZero.getId());

        // create a second photo through BikePhotoFactory
        BikePhoto newPhotoOne = bpfInstance.createPhoto();
        // the first and the second photo and their PhotoIds should NOT be equal
        assertNotEquals(newPhotoZero, newPhotoOne);
        assertNotEquals(newPhotoZero.getId(), newPhotoOne.getId());

	}
}
