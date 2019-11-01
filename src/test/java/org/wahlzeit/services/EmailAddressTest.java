/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.services;

import junit.framework.TestCase;

/**
 * Test cases for the EmailAddress class.
 */
public class EmailAddressTest extends TestCase {

	/**
	 *
	 */
	public EmailAddressTest(String name) {
		super(name);
	}

	/**
	 *
	 */
	public void testGetEmailAddressFromString() {
		// invalid email addresses are allowed for local testing and online avoided by Google

		assertTrue(createEmailAddressIgnoreException("bingo@bongo"));
		assertTrue(createEmailAddressIgnoreException("bingo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo.bongo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo+bongo@bango"));
	}

	/**
	 *
	 */
	protected boolean createEmailAddressIgnoreException(String ea) {
		try {
			EmailAddress.getFromString(ea);
			return true;
		} catch (IllegalArgumentException ex) {
			// creation failed
			return false;
		}
	}

	/**
	 *
	 */
	public void testEmptyEmailAddress() {
		assertFalse(EmailAddress.EMPTY.isValid());
	}

	public void testEmptyEmailAddressExtended() {
		EmailAddress mailFromGetString = EmailAddress.getFromString("");
		assertFalse(mailFromGetString.isValid());
	}

	public void testEmailIsEqual(){
		EmailAddress mailAddressA = new EmailAddress("abc.def@fau.de");
		EmailAddress mailAddressB = new EmailAddress("abc.def@google.com");
		EmailAddress mailAddressC = new EmailAddress("ghi@fau.de");

		// A<>A, B<>B, C<>C
		assertTrue(mailAddressA.isEqual(mailAddressA));
		assertTrue(mailAddressB.isEqual(mailAddressB));
		assertTrue(mailAddressC.isEqual(mailAddressC));
		
		// A<>B, B<>A, B<>C, C<>B, A<>C, C<>A
		assertFalse(mailAddressA.isEqual(mailAddressB));
		assertFalse(mailAddressB.isEqual(mailAddressA));
		assertFalse(mailAddressB.isEqual(mailAddressC));
		assertFalse(mailAddressC.isEqual(mailAddressB));
		assertFalse(mailAddressA.isEqual(mailAddressC));
		assertFalse(mailAddressC.isEqual(mailAddressA));
	}
}

