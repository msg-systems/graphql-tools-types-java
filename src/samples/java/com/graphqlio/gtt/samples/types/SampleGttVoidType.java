package com.graphqlio.gtt.samples.types;

import com.graphqlio.gtt.types.GttVoidType;

import graphql.language.StringValue;

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
