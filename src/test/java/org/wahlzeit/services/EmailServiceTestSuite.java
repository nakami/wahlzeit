package org.wahlzeit.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Test files
import org.wahlzeit.services.mailing.EmailServiceTest;
import org.wahlzeit.services.EmailAddressTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    EmailServiceTest.class,
    EmailAddressTest.class
})
public class EmailServiceTestSuite{}
