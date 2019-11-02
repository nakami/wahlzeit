package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Test files
//import org.wahlzeit.model.persistence.AbstractAdapterTest;
import org.wahlzeit.model.persistence.DatastoreAdapterTest;
import org.wahlzeit.model.AccessRightsTest;
import org.wahlzeit.model.CoordinateTest;
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
    CoordinateTest.class,
    FlagReasonTest.class,
    GenderTest.class,
    GuestTest.class,
    PhotoFilterTest.class,
    TagsTest.class,
    UserStatusTest.class,
    ValueTest.class
})
public class ModelTestSuite{}
