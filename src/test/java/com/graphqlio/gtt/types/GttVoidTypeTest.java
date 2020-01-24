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

import java.util.Date;

import org.junit.jupiter.api.Test;

import graphql.language.StringValue;
import graphql.schema.Coercing;

/**
 * Class for testing library graphql scalar type Void
 *
 * @author Michael Schäfer
 * @author Torsten Kühnert
 */

public class GttVoidTypeTest {

	private static final GttVoidType gttVoidType = new GttVoidType();
	private static final Coercing coercing = gttVoidType.getCoercing();

	/*
	 * testing parseLiteral
	 * 
	 * every input is ok, result is always null
	 */
	@Test
	public void testParseLiteral() {
		Object result = coercing.parseLiteral("2005-05-05 05:05:05");
		assertEquals(null, result);

		result = coercing.parseLiteral(new StringValue("2005-05-05"));
		assertEquals(null, result);

		result = coercing.parseLiteral(1235);
		assertEquals(null, result);

		result = coercing.parseLiteral(new Date());
		assertEquals(null, result);

		result = coercing.parseLiteral(null);
		assertEquals(null, result);
	}

	/*
	 * testing parseValue
	 * 
	 * every input is ok, result is always null
	 */
	@Test
	public void testParseValue() {
		Object result = coercing.parseValue(new StringValue("2005-05-05 05:05:05"));
		assertEquals(null, result);

		result = coercing.parseValue("2005-05-05");
		assertEquals(null, result);

		result = coercing.parseValue(1354);
		assertEquals(null, result);

		result = coercing.parseValue(new Date());
		assertEquals(null, result);
	}

	/*
	 * testing serialize
	 * 
	 * every input is ok, result is always null
	 */
	@Test
	public void testSerialize() {
		Object result = coercing.serialize("2005-05-05 05:05:05");
		assertEquals(null, result);

		result = coercing.serialize(new Date());
		assertEquals(null, result);

		result = coercing.serialize(1354);
		assertEquals(null, result);

		result = coercing.serialize(true);
		assertEquals(null, result);
	}

}
