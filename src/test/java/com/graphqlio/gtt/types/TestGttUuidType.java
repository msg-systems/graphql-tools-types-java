/*
**  Design and Development by msg Applied Technology Research
**  Copyright (c) 2019-2020 msg systems ag (http://www.msg-systems.com/)
**  All Rights Reserved.
** 
**  Permission is hereby granted, free of charge, to any person obtaining
**  a copy of this software and associated documentation files (the
**  "Software"), to deal in the Software without restriction, including
**  without limitation the rights to use, copy, modify, merge, publish,
**  distribute, sublicense, and/or sell copies of the Software, and to
**  permit persons to whom the Software is furnished to do so, subject to
**  the following conditions:
**
**  The above copyright notice and this permission notice shall be included
**  in all copies or substantial portions of the Software.
**
**  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
**  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
**  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
**  IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
**  CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
**  TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
**  SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package com.graphqlio.gtt.types;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;

/**
 * Class for testing library graphql scalar type UUID
 *
 * @author Michael Schäfer
 * @author Torsten Kühnert
 */

public class TestGttUuidType {

	private static final GttUuidType gttUuidType = new GttUuidType();
	private static final Coercing coercing = gttUuidType.getCoercing();

	private static final String UUID_STRING = "3b241101-e2bb-4255-8caf-4136c566a964";

	/*
	 * testing parseLiteral
	 * 
	 * String is wrong input type
	 */
	@Test
	public void testParseLiteral1() {
		Assertions.assertThrows(CoercingParseLiteralException.class, () -> {
			Object result = coercing.parseLiteral("hallo test");
		});
	}

	/*
	 * testing parseLiteral
	 * 
	 * StringValue is correct input type, but wrong input value format: no uuid
	 * value format
	 */
	@Test
	public void testParseLiteral2() {
		Assertions.assertThrows(CoercingParseLiteralException.class, () -> {
			Object result = coercing.parseLiteral(new StringValue("123"));
		});
	}

	/*
	 * testing parseLiteral
	 * 
	 * wrong input value format: no uuid value format
	 */
	@Test
	public void testParseLiteral3() {
		Assertions.assertThrows(CoercingParseLiteralException.class, () -> {
			Object result = coercing.parseLiteral(new StringValue("abc-123-xyz-789"));
		});
	}

	/*
	 * testing parseLiteral
	 * 
	 * correct input type, correct input value format
	 */
	@Test
	public void testParseLiteral4() {
		Object result = coercing.parseLiteral(new StringValue(UUID_STRING));
		assertEquals(UUID.fromString(UUID_STRING), result);
	}

	/*
	 * testing parseValue
	 * 
	 * StringValue is wrong input type
	 */
	@Test
	public void testParseValue1() {
		Assertions.assertThrows(CoercingParseValueException.class, () -> {
			Object result = coercing.parseValue(new StringValue(UUID_STRING));
		});
	}

	/*
	 * testing parseValue
	 * 
	 * StringValue is correct input type, but wrong input value format: no uuid
	 * value format
	 */
	@Test
	public void testParseValue2() {
		Assertions.assertThrows(CoercingParseValueException.class, () -> {
			Object result = coercing.parseValue("abc");
		});
	}

	/*
	 * testing parseValue
	 * 
	 * wrong input value format: no uuid value format
	 */
	@Test
	public void testParseValue3() {
		Assertions.assertThrows(CoercingParseValueException.class, () -> {
			Object result = coercing.parseValue("abc-123-3456-xyzz");
		});
	}

	/*
	 * testing parseValue
	 * 
	 * correct input type, correct input value format
	 */
	@Test
	public void testParseValue4() {
		Object result = coercing.parseValue(UUID_STRING);
		assertEquals(UUID.fromString(UUID_STRING), result);
	}

	/*
	 * testing serialize
	 * 
	 * StringValue is wrong input type
	 */
	@Test
	public void testParseValue5() {
		Assertions.assertThrows(CoercingParseValueException.class, () -> {
			Object result = coercing.parseValue("abc-123-3456-xyzz");
		});
	}

	/*
	 * testing serialize
	 * 
	 * String is wrong input type
	 */
	@Test
	public void testSerialize1() {
		Assertions.assertThrows(CoercingSerializeException.class, () -> {
			Object result = coercing.serialize(UUID_STRING);
		});
	}

	/*
	 * testing serialize
	 * 
	 * correct input, correct value format
	 */
	@Test
	public void testSerialize2() {
		Object result = coercing.serialize(UUID.fromString(UUID_STRING));
		assertEquals(UUID_STRING, result);
	}

}
