package com.graphqlio.gtt.samples.types;

import com.graphqlio.gtt.types.GttDateType;

import graphql.language.StringValue;

public class SampleGttDateType {

	public static void main(String[] args) {
		new SampleGttDateType().run();
	}

	public void run() {
		GttDateType type = new GttDateType();

		/*
		 * some scalar type information
		 */
		System.out.println("type.getDescription = " + type.getDescription());
		System.out.println("type.getName = " + type.getName());
		System.out.println("type = " + type);

		/*
		 * literal parsing
		 */
		Object result = type.getCoercing().parseLiteral(new StringValue("2005-05-05 05:05:05"));
		System.out.println("result.class = " + result.getClass().getName());
		System.out.println("result = " + result);

		/*
		 * value parsing
		 */
		result = type.getCoercing().parseValue("2005-05-05 05:05:05");
		System.out.println("result.class = " + result.getClass().getName());
		System.out.println("result = " + result);

		/*
		 * serialization
		 */
		result = type.getCoercing().serialize(result);
		System.out.println("result.class = " + result.getClass().getName());
		System.out.println("result = " + result);
	}

}
