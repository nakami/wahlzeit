package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


// Test Suites
import org.wahlzeit.handlers.HandlersTestSuite;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.services.EmailServiceTestSuite;
import org.wahlzeit.utils.UtilsTestSuite;

// Test files
import org.wahlzeit.services.LogBuilderTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
    // Test Suites
    HandlersTestSuite.class,
    ModelTestSuite.class,
    EmailServiceTestSuite.class,
    UtilsTestSuite.class,
    // Test files
    LogBuilderTest.class
})

public class AllTests{}
