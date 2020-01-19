package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Test files
//import org.wahlzeit.model.persistence.AbstractAdapterTest;
import org.wahlzeit.model.persistence.DatastoreAdapterTest;
import org.wahlzeit.model.AccessRightsTest;
import org.wahlzeit.model.BikePhotoTest;
import org.wahlzeit.model.BikePhotoFactoryTest;
import org.wahlzeit.model.BikePhotoManagerTest;
import org.wahlzeit.model.BikeManagerTest;
import org.wahlzeit.model.BikeTypeTest;
import org.wahlzeit.model.CartesianCoordinateTest;
import org.wahlzeit.model.SphericCoordinateTest;
import org.wahlzeit.model.FlagReasonTest;
import org.wahlzeit.model.GenderTest;
import org.wahlzeit.model.GuestTest;
import org.wahlzeit.model.PhotoFilterTest;
import org.wahlzeit.model.TagsTest;
import org.wahlzeit.model.UserStatusTest;
import org.wahlzeit.model.ValueTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    //AbstractAdapterTest.class,
    DatastoreAdapterTest.class,
    AccessRightsTest.class,
    BikePhotoTest.class,
    BikePhotoFactoryTest.class,
    BikePhotoManagerTest.class,
    BikeManagerTest.class,
    BikeTypeTest.class,
    CartesianCoordinateTest.class,
    SphericCoordinateTest.class,
    FlagReasonTest.class,
    GenderTest.class,
    GuestTest.class,
    PhotoFilterTest.class,
    TagsTest.class,
    UserStatusTest.class,
    ValueTest.class
})
public class ModelTestSuite{}
