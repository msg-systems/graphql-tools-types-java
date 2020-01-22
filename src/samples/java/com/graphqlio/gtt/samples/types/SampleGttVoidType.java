/*******************************************************************************
 * *
 * **  Design and Development by msg Applied Technology Research
 * **  Copyright (c) 2019-2020 msg systems ag (http://www.msg-systems.com/)
 * **  All Rights Reserved.
 * ** 
 * **  Permission is hereby granted, free of charge, to any person obtaining
 * **  a copy of this software and associated documentation files (the
 * **  "Software"), to deal in the Software without restriction, including
 * **  without limitation the rights to use, copy, modify, merge, publish,
 * **  distribute, sublicense, and/or sell copies of the Software, and to
 * **  permit persons to whom the Software is furnished to do so, subject to
 * **  the following conditions:
 * **
 * **  The above copyright notice and this permission notice shall be included
 * **  in all copies or substantial portions of the Software.
 * **
 * **  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * **  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * **  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * **  IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * **  CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * **  TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * **  SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * *
 ******************************************************************************/
package com.graphqlio.gtt.samples.types;

import com.graphqlio.gtt.types.GttVoidType;

import graphql.language.StringValue;

/**
 * Class showing use of Void scalar type
 *
 * @author Michael Schäfer
 * @author Torsten Kühnert
 */

public class SampleGttVoidType {

	public static void main(String[] args) {
		new SampleGttVoidType().run();
	}

	public void run() {
		GttVoidType type = new GttVoidType();

		/*
		 * some scalar type information
		 */
		System.out.println("type.getDescription = " + type.getDescription());
		System.out.println("type.getName = " + type.getName());
		System.out.println("type = " + type);

		/*
		 * literal parsing
		 * 
		 * always null, so no class information available
		 */
		Object result = type.getCoercing().parseLiteral(new StringValue("2005-05-05 05:05:05"));
		System.out.println("result = " + result);

		/*
		 * value parsing
		 * 
		 * always null, so no class information available
		 */
		result = type.getCoercing().parseValue("hi there");
		System.out.println("result = " + result);

		/*
		 * serialization
		 * 
		 * always null, so no class information available
		 */
		result = type.getCoercing().serialize(result);
		System.out.println("result = " + result);
	}

}
